import React, { useState, useCallback, useEffect } from 'react';
import { Card, Avatar, Button, List, Comment, Popover } from 'antd';
import { DingdingOutlined, EllipsisOutlined, HeartOutlined, HeartTwoTone, MessageOutlined, RetweetOutlined, ShareAltOutlined } from '@ant-design/icons';
import PostImages from './PostImages';
import CommentForm from './CommentForm';
import PostCardContent from './PostCardContent';
import FollowButton from './FollowButton';
import { useDispatch, useSelector } from 'react-redux';  //2. ## useDispatch
import PropTypes, { object } from 'prop-types';

//1. ## REMOVE_POST_REQUEST 
import {
  REMOVE_POST_REQUEST, LIKE_POST_REQUEST, UNLIKE_POST_REQUEST, UPDATE_POST_REQUEST,
  RETWEET_REQUEST
} from '../reducers/post';
import Link from 'next/Link';

const PostCard = ({ post }) => {
  const id = useSelector((state) => state.user.user?.id);
  const { removePostLoading, removePostDone } = useSelector(state => state.post); //##3
  const dispatch = useDispatch();  //##4
  ///////////////////////////////////////////////////// code

  //1. 좋아요 - false
  //const [like, setLike] = useState(false);
  const onClickLike = useCallback(() => {
    if (!id) { return alert('로그인을 하시면 좋아요추가가 가능합니다.'); }
    return dispatch({
      type: LIKE_POST_REQUEST,
      data: post.id
    });
  }, [id]);

  const onClickUnLike = useCallback(() => {
    if (!id) { return alert('로그인을 하시면 좋아요추가가 가능합니다.'); }
    return dispatch({
      type: UNLIKE_POST_REQUEST,
      data: post.id
    });
  }, [id]);

 


  //2. 댓글 -  댓글의 상태체크 / 댓글처음에는 안보이게, 클릭하면  토글기능
  const [commentOpen, setCommentOpen] = useState(false);
  const onClickComment = useCallback(() => { setCommentOpen(prev => !prev); }, []);

  //3. 삭제버튼
  useEffect(() => {
    if (removePostDone) { console.log('..... removePostDone'); }
  }, []);

  const onRemovePost = useCallback(() => {
    dispatch({
      type: REMOVE_POST_REQUEST,
      data: post.id
    });
  }, []);

  // 4. 수정
  const [editMode, setEditMode] = useState(false);
  const onClickUpdate = useCallback(() => {
    setEditMode(true);
  }, []);
  const onCancelUpdate = useCallback(() => {
    setEditMode(false);
  }, []);
  const onEditPost = useCallback((editText) => () => {
    dispatch({
      type: UPDATE_POST_REQUEST,
      data: { PostId: post.id, content: editText }
    });
  }, [post]);

  // 5. 리트윗
  const onRetweet = useCallback(() => {
    if (!id) { return alert('로그인 후 리트윗이 가능합니다.'); }
    return dispatch({
      type: RETWEET_REQUEST,
      data: post.id
    });

  });
  
  const like = post.Likers?.find((v) => v.id === id);  // 내가 눌렀는지 체크
  /////////////////////////////////////////////////////////////////////////

  const loadKakaoSDK = () => {
    const script = document.createElement("script"); //script 태그만들기
    script.src = "https://developers.kakao.com/sdk/js/kakao.js"; // script src=""
    script.async = true;
    script.onload = () => {
      if (window.Kakao) { window.Kakao.init("c9a89692b607ff0542f7261e58f6230c"); } //js앱키
    };
    document.head.appendChild(script);
  };

  useEffect(() => { loadKakaoSDK(); }, []);

  const shareToKakao = (postId) => {
    window.Kakao.Link.sendDefault({
      objectType: "text",
      text: "이 링크를 확인해보세요!",
      link: {
        mobileWebUrl: `http://localhost:3000/post/${postId}`,
        webUrl: `http://localhost:3000/post/${postId}`,
      },
    });
  };

  ///////////////////////////////////////////////////// view
  return (<div style={{ margin: '3%' }}>
    <Card
      cover={post.Images && post.Images.length > 0 && <PostImages images={post.Images} />}
      actions={[
        <RetweetOutlined key="retweet" onClick={onRetweet} />,
        like
          ? <HeartTwoTone twoToneColor="#f00" key="heart" onClick={onClickUnLike} />
          : <HeartOutlined key="heart" onClick={onClickLike} />,

        <MessageOutlined key="comment" onClick={onClickComment} />,
        <Popover content={(
          <Button.Group>
            {id && id === post.User.id
              ? (<><Button onClick={onClickUpdate}>수정</Button>
                <Button type="danger"
                  loading={removePostLoading} onClick={onRemovePost} >삭제</Button></>
              )
              : <Button>신고</Button>
            }
          </Button.Group>
        )}>
          <EllipsisOutlined />
        </Popover>,
        <ShareAltOutlined key="share" onClick={()=>shareToKakao(post.id)}/>
      ]}
      title={post.RetweetId ? `${post.User.nickname}님이 리트윗 하셨습니다.` : null}
      extra={id && id !== post.User.id && <FollowButton post={post} />}
    >
      {post.RetweetId && post.Retweet ? (
        <Card cover={post.Retweet.Images[0] && <PostImages images={post.Retweet.Images} />}>
          <Card.Meta
            avatar={<Link href={`/user/${post.Retweet.User.id}`} prefetch={false}>
              <Avatar>{post.Retweet.User.nickname[0]}</Avatar></Link>}
            title={post.Retweet.User.nickname}
            description={<PostCardContent
              editMode={editMode}
              onChangePost={onEditPost}
              onCancelUpdate={onCancelUpdate}
              postData={post.Retweet.content} />}
          />
        </Card>
      ) : (
        <Card.Meta
          avatar={<Link href={`/user/${post.User.id}`} prefetch={false}><Avatar>{post.User.nickname[0]}</Avatar></Link>}
          title={post.User.nickname}
          description={<PostCardContent
            editMode={editMode}
            onChangePost={onEditPost}
            onCancelUpdate={onCancelUpdate}
            postData={post.content} />}
        />
      )}
    </Card>
    {commentOpen && (
      <>
        {/*  댓글폼  */}
        <CommentForm post={post} />
        {/*  댓글리스트  */}
        <List
          header={`${post.Comments.length}  댓글`}
          itemLayout='horizontal'
          dataSource={post.Comments}
          renderItem={(item) => (
            <li>
              <Comment
                avatar={<Avatar>{item.User.nickname[0]}</Avatar>}
                content={item.content}
                author={item.User.nickname}
              />
            </li>
          )
          }
        />
      </>
    )}
  </div>);
};

PostCard.propTypes = { post: PropTypes.object.isRequired };

export default PostCard;