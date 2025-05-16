module.exports = ( sequelize , DataTypes )=>{
  //const User
  const Hashtag = sequelize.define('Hashtag',{
    //id 기본값으로 자동설정
    name:{
      type : DataTypes.STRING(200), //STRING ,TEXT, BOOLEAN, INTEGER, FLOAT, DATETIME
      allowNull:false, //필수
    },
  },{
    charset:'utf8',
    collate:'utf8_general_ci' // 한글저장
  }); //hashtags테이블 - 자동으로 s 붙어서 생성
  //관계설정
  Hashtag.associate = (db) => { 
    db.Hashtag.belongsToMany(db.Post,{through:'PostHashtag'});
  };
  return Hashtag;
};

/*
 9) 해쉬태그관리 - [models] - hashtag.js

 id 기본 값
 name varchar(20) 필수
 creatAt, updateAt -- 

 > 관계설정
 - 해시태그는 많은 게시글을 갖는다. belongsToMany ( Hashtag ) 중간테이블 : PostHashtag

*/