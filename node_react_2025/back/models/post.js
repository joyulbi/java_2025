module.exports = ( sequelize , DataTypes )=>{
  //const User
  const Post = sequelize.define('Post',{
    //id 기본값으로 자동설정
    content:{
      type : DataTypes.TEXT, //STRING ,TEXT, BOOLEAN, INTEGER, FLOAT, DATETIME
      allowNull:false, //필수
    },
  },{
    charset:'utf8mb4',
    collate:'utf8mb4_general_ci' // 이모티콘가능
  }); //posts테이블 - 자동으로 s 붙어서 생성
  //관계설정
  Post.associate = (db) => { 
    db.Post.hasMany(db.Image);   //post.addImages, post.getImages
    db.Post.hasMany(db.Comment); //post.addComments, post.getCommentsd
    db.Post.belongsTo(db.User);  //post.addUsers, post.getUsers, post.setUsers
    db.Post.belongsTo(db.Post,{as:'Retweet'}); //post.addRetweet
    db.Post.belongsToMany(db.Hashtag,{through:'PostHashtag'}) //post.addHashtags
    db.Post.belongsToMany(db.User,{through:'Like',as:'Likers'}) //post.addLikers, post.removeLikers
  };
  return Post;
};

/*
6) 포스트(게시판)관리 - [models] - post.js

 id 기본값
 content text 필수
 createsAt, updatedAt --

 > 관계설정
 - 게시글은 Image를 갖는다.      1:다 hasMany
 - 게시글은 Comment를 갖는다. 1:다 hasMany

 - 게시글은 유저에 속해있다 belongsTo
 ※ 유저는 많은 post를 가진다. 1:다 hasMany
 
 - 공유	    게시글은 많은공유(게시글 : Post)를 갖는다 belongsTo

 - 해시태그  게시글은 많은 해시태크를 갖는다. belongsToMany ( Hashtag ) 중간테이블 : PostHashtag
 - 좋아요     좋아요는 많은 좋아요를 갖는다. belongsToMany ( User ) 중간테이블 : Like, as : Likers
*/