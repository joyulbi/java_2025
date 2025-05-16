module.exports = ( sequelize , DataTypes )=>{
  //const User
  const Image = sequelize.define('Image',{
    //id 기본값으로 자동설정
    src:{
      type : DataTypes.STRING(200), //STRING ,TEXT, BOOLEAN, INTEGER, FLOAT, DATETIME
      allowNull:false, //필수
    },
  },{
    charset:'utf8',
    collate:'utf8_general_ci' // 한글저장
  }); //images테이블 - 자동으로 s 붙어서 생성
  //관계설정
  Image.associate = (db) => { 
    db.Image.belongsTo(db.Post);
  };
  return Image;
};

/*
 7) 이미지관리 - [models] - image.js

 id 기본값
 src varchar(200) 필수
 createsAt, updatedAt --

 > 관계설정
 - 이미지는 게시글(Post)에 속해있다 belongsTo
*/