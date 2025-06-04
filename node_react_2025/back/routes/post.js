const express = require('express');
const router = express.Router();

const multer = require('multer'); //파일업로드
const path = require('path');//경로
const fs = require('fs');//file system

const { Post, User, Image, Comment, Hashtag } = require('../models');
const { isLoggedIn } = require('./middlewares');
const { where } = require('sequelize');
const { error } = require('console');
const comment = require('../models/comment');

//c(Create)r(findOne,findAll)ud


/////폴더 존재여부확인
try {
  fs.accessSync('uploads'); //폴더 존재여부 확인
} catch (error) {
  console.log('uploads 폴더가 없으면 생성합니다.');
  fs.mkdirSync('uploads'); //폴더 만들기
}
/////////////////////////////////////
//1.업로드설정
const upload = multer({
  storage: multer.diskStorage({//저장소설정 - 업로드된 파일의 저장위치,파일이름 지정하는 역할
    //파일을 디스크(로컬시스템)에 저장하도록 설정
    destination(req, file, done) { //지정경로
      done(null, 'uploads'); //지정경로 지정 - 콜백
      // null 에러없음, uploads 지정될 폴더 경로
    },
    filename(req, file, done) { // 업로드된 파일이름 지정
      // images1.png
      const ext = path.extname(file.originalname); //1. 확장자 추출 .png
      const basename = path.basename(file.originalname, ext); //2. 이미지이름 images1
      done(null, basename + '_' + new Date().getTime() + ext);//3. images1_날짜지정.png
    },
  }),
  limits: { fileSize: 10 * 1024 * 1024 }
});

//2.게시글 생성하고 관련데이터 저장하는 역할
// POST : localhost:3065/post 로그인을 했다면
// {"content" : "새 게시글입니다. #노드 #리액트"}
//
// upload.none():          form file 업로드 없을때 처리
router.post('/', isLoggedIn, upload.none(), async (req, res, next) => {
  //res.send('......post 게시글');
  try {
    // 1. 해시태그
    //  /#/g	#찾아
    //  /#[^\s#]+/g 	[]+ []안에 있는거 1개이상   2)  ^\s#   ^부정 \s 공백 #
    //  /#[^\s]+/g
    const hashtags = req.body.content.match(/#[^\s#]+/g)
    // 2. 게시글저장 
    const post = await Post.create({
      content: req.body.content,
      UserId: req.user.id
    });
    // 3. 해시태그 존재하면 - 해시태그 저장
    if (hashtags) {
      const result = await Promise.all( // 비동기로 작업 병렬로 실행하고, 작업완료시 결과 반환
        hashtags.map(tag =>
          Hashtag.findOrCreate({
            where: { name: tag.slice(1).toLowerCase() } //#node #react slice(1) 문자열 첫번째 제거
          })
        )
      );
      await post.addHashtags(result.map(v => v[0])) // [node,true] , [react,true]
    }
    // 4. 이미지처리
    if (req.body.image) {
      if (Array.isArray(req.body.image)) { //여러개 이미지
        const images = await Promise.all(
          req.body.image.map((image) => Image.create({ src: image }))
        )
        await post.addImages(images)

      } else { //1개이미지
        const image = await Image.create({ src: req.body.image });
        await post.addImages(image)
      }
    }


    // 5. 게시글 상세정보조회 - 해당유저의 id에 맞는 글찾기 / join / Image 테이블, Comment, User
    const fullPost = await Post.findOne({
      where: { id: post.id },
      include: [
        { model: User, attributes: ['id', 'nickname'] }
        , { model: Image } // 명시적으로 추가안해도 자동으로 포함
        , { model: User, as: 'Likers', attributes: ['id'] }
        , { model: Comment, include: [{ model: User, attributes: ['id', 'nickname'] }] }
      ]
    });

    res.status(201).json(fullPost);
  } catch (error) {
    console.error(error);
    next(error);
  }
});

/*
POST localhost:3065/post/images

1. 로그인
2. 이미지 업로드 테스트
Header : Content-Type : multipart/form-data
Body   : form-data "image" : 업로드할 파일 선택 test.png
//
*/
router.post('/images', isLoggedIn, upload.array('image'), (req, res, next) => {
  console.log(req.files);
  res.json(req.files.map((v) => v.filename));
});

// create : 객체.create({})
// select : 객체.findAll, 객체.findOne
// update : 객체.update
// delete : 객체.destroy()

//3.글 삭제
// DELETE : localhost:3065/post/:postId 로그인을 했다면
router.delete('/:postId', isLoggedIn, async (req, res, next) => {
  //res.send('......post 게시글삭제');
  try {
    await Post.destroy({
      where: {
        id: req.params.postId, // 삭제하려는 게시글 id
        UserId: req.user.id // 게시글 작성자
      }
    });
    res.status(200).json({ PostId: parseInt(req.params.postId, 10) });
  } catch (error) {
    console.error(error);
    next(error);
  }
});

// 글 수정
router.patch('/:postId', isLoggedIn, async (req, res, next) => {
  const hashtags = req.body.content.match(/#[^\s#]+/g);
  try {
    // 글 수정  
    await Post.update({
      content: req.body.content,
    }, {
      where: {
        id: req.params.postId,
        UserId: req.user.id,
      }
    });
    // 해쉬태그 findOrCreate
    const post = await Post.findOne({ where: { id: req.params.postId } }); // 게시글 찾아오기
    if (hashtags) { //해쉬태그가 존재한다면
      const result = await Promise.all(hashtags.map( //해쉬태그들 다시 조립
        (tag) => Hashtag.findOrCreate({ // DB : 찾거나 생성하거나
          where: { name: tag.slice(1).toLowerCase() },
        })
      )); // [node, true]
      await post.setHashtags(result.map((v) => v[0]));
    }
    res.status(200).json({ PostId: parseInt(req.params.postId, 10), content: req.body.content });
  } catch (error) {
    console.error(error);
    next(error);
  }
});

/////////////////////////////////////
//4.좋아요 추가
// 1. PATCH   localhost:3065/post/1/like (글번호)
// 2. 게사굴 존재여부 확인 Post.findOne
// 3. 좋아요 추가 post.addLikers
// 4. 응답
router.patch('/:postId/like', isLoggedIn, async (req, res, next) => {
  try {
    // 1. 게시글 존재 여부 확인
    const post = await Post.findOne({ where: { id: req.params.postId } });
    if (!post) {
      return res.status(404).json({ error: '존재하지 않는 게시글입니다.' });
    }

    // 2. 좋아요 추가
    await post.addLikers(req.user.id); // Sequelize의 belongsToMany 관계 활용

    // 3. 응답
    res.json({ PostId: post.id, UserId: req.user.id });
  } catch (error) {
    console.error(error);
    next(error);
  }
});

//5.좋아요 삭제
// 1. DELETE   localhost:3065/post/1/like (글번호)
// 2. 게사굴 존재여부 확인 Post.findOne
// 3. 좋아요 추가 post.removeLikers
// 4. 응답
router.delete('/:postId/like', isLoggedIn, async (req, res, next) => {
  try {
    // 1. 게시글 존재 여부 확인
    const post = await Post.findOne({ where: { id: req.params.postId } });
    if (!post) {
      return res.status(404).json({ error: '존재하지 않는 게시글입니다.' });
    }

    // 2. 좋아요 삭제
    await post.removeLikers(req.user.id); // Sequelize의 belongsToMany 관계 활용

    // 3. 응답
    res.json({ PostId: post.id, UserId: req.user.id });
  } catch (error) {
    console.error(error);
    next(error);
  }
});


/////////////////////////////////////
//6. 사용자 댓글
//1. POST localhost:3065/7/comment
//2. 게시물존재확인
//3. 댓글생성
//4. 댓글조회
//5. 응답코드
router.post('/:postId/comment', isLoggedIn, async (req, res, next) => {
  try {
    const post = await Post.findOne({ where: { id: req.params.postId } });
    if (!post) {
      return res.status(403).json({ error: '글을 확인해주세요' });
    }
    const comment = await Comment.create({ // 댓글 생성
      content: req.body.content,
      PostId: parseInt(req.params.postId, 10),
      UserId: req.user.id,
    });
    const fullComment = await Comment.findOne({ // 댓글생성 확인
      where: { id: comment.id },
      include: [{ model: User, attributes: ['id', 'nickname'] }]
    });
    res.status(201).json(fullComment);
  } catch (error) {
    console.error(error);
    next(error);
  }
});

//7. 리트윗
// POST : localhost:3065/post/게시글번호/retweet
// POST : localhost:3065/post/:postId/retweet

router.post('/:postId/retweet', isLoggedIn, async (req, res, next) => {
  try {
    //1. 기존게시글 확인 - findOne
    const post = await Post.findOne({
      where: { id: req.params.postId },
      include: [{ model: Post, as: 'Retweet' }]
    });
    if (!post) { return res.status(403).send('게시글을 확인해주세요'); }

    //2. 리트윗 - 조건확인 : 유저가 본인글인지 확인 || 리트윗 한적 있는지 확인
    if (req.user.id === post.UserId
      || (post.Retweet && post.Retweet.UserId == req.user.id)
    ) { return res.status(403).send('본인 게시물은 리트윗 할 수 없습니다.'); }

    //3. 리트윗할 게시글 번호
    const retweetTargetId = post.RetweetId || post.id

    //4. 중복 리트윗 여부
    const exPost = await Post.findOne({
      where: { UserId: req.user.id, RetweetId: retweetTargetId, }
    })
    if (exPost) { return res.status(403).send('이미 리트윗한 게시물입니다.') }

    //5. 리트윗 생성 - create
    const retweet = await Post.create({
      UserId: req.user.id, RetweetId: retweetTargetId, content: 'retweet',
    });

    //6. 리트윗 싱세조회
    const retweetDetail = await Post.findOne({
      where: { id: retweet.id },
      include: [
        {model: Post, as: 'Retweet', include: [
            { model: User, attributes: ['id', 'nickname'] },
            { model: Image },
          ]},
        { model: User, attributes: ['id', 'nickname'] },
        { model: Image },
        { model: Comment, include: [{ model: User, attributes: ['id', 'nickname'] },] },]
    });

    //7. res 응답
    res.status(201).json(retweetDetail);

  } catch (error) {
    console.error(error)
    next(error)
  }
});

module.exports = router;
