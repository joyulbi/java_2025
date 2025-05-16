module.exports = (sequelize,DataTypes)=>{
  ///const User
  const User = sequelize.define('User',{
    //id 기본값으로 자동설정
    email:{
      type : DataTypes.STRING(30), // STRING, TEXT, BOOLEAN, INTEGER, FLOAT, DATETME
      allowNull:false, //필수
      unique:true //고유값
    },
    nickname:{
      type : DataTypes.STRING(30), // STRING, TEXT, BOOLEAN, INTEGER, FLOAT, DATETME
      allowNull:false, //필수      
    },
    password:{
      type : DataTypes.STRING(100), // STRING, TEXT, BOOLEAN, INTEGER, FLOAT, DATETME
      allowNull:false, //필수      
    },
  },{
    charset:'utf8',
    collate:'utf8_general_ci' // 한글저장
  }); //users테이블 - 자동으로 s 붙어서 생성
  ///관계설정
  User.associate = (db)=>{
    db.User.hasMany(db.Post);
    db.User.hasMany(db.Comment);
    db.User.belongsToMany(db.Post,{through:'Like',as:'Liked'});
    db.User.belongsToMany(db.User,{through:'Follow',as:'Followers',foreignKey:'FollowingId'});
    // user.getFollowers() followingId 를 기준으로 관계 설정
    db.User.belongsToMany(db.User,{through:'Follow',as:'Followings',foreignKey:'FollowerId'});
    // user.getFollowings() followerId 를 기준으로 관계 설정
  };
  return User;
};

/*
 5) 멤버관리 - [models] - users.js

 id 기본값
 email	  varchar(30) 필수,unique
 nickname varchar(30) 필수,unique
 password varchar(30) 필수,unique
 createsAt, updatedAt --

관계설정
 - 유저는 많은 post를 가진다. hasMany
 - 유저는 많은 comment를 가진다. hasMany
 - 좋아요 : User객체와 Post 객체 사이에 다:다 belongsToMany / 테이블명:like / 별칭:liked 
   ※ user.getLiked() 특정사용자의 좋아요 게시물 목록
    유저는 많은 글에대한 좋아요를 남길 수가 있고
    글도 많은 유저가 좋아요를 남길 수 있다.

	post1 user1
	post1 user2
	post2 user1
	post2 user2

 - 팔로워 : 내가 올린 게시물을 보는 사람
    User객체에서 User테이블사이  belongsToMany / 테이블명:follow / 별칭:followers / fk:followingId
	
	팔로워  팔로잉
	user1    user1
	user1    user2
	user2    user1
	user2    user2

	내가 user1 팔로우 나는 user1의 팔로잉 (user1의 게시물 볼 수 있음)
	user1이 나를 팔로우 user1은 나의 팔로워 (내 게시물 볼 수 있음)
    
 - 팔로잉 : 내가 팔로우한 사람의 게시물을 볼 수 있는 상태 
    User객체에서 User테이블사이  belongsToMany / 테이블명:follow / 별칭:followings / fk:followerId

	※ fk 컬럼의 어떤 아이디를 참고
	 >   winter를 누가 팔로잉했는지 찾으려면
	 >   winter 팔로워 id를 먼저 찾고
	 >   following 확인

*/