module.exports = ( sequelize , DataTypes )=>{
  //const User
  const Comment = sequelize.define('Comment',{
    //id 기본값으로 자동설정
    content:{
      type : DataTypes.TEXT, //STRING ,TEXT, BOOLEAN, INTEGER, FLOAT, DATETIME
      allowNull:false, //필수
    },
  },{
    charset:'utf8',
    collate:'utf8_general_ci' // 한글저장
  }); //comments테이블 - 자동으로 s 붙어서 생성
  //관계설정
  Comment.associate = (db) => { 
    db.Comment.belongsTo(db.User);
    db.Comment.belongsTo(db.Post);
  };
  return Comment;
};

/*
 8) 댓글관리 - [models] - comment.js

 id 기본 값
 context text 필수
 creatAt, updateAt -- 

 > 관계설정
 - 댓글은 (User)에 속해있다 belongsTo
 - 댓글은 (Post)에 속해있다 belongsTo
*/