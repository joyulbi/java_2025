const Sequelize = require('sequelize');

const env = process.env.NODE_ENV || 'development';
const config = require('../config/config')[env];
const db = {}; // 객체를 생성해서 객체 저장 공간 만들기

const sequelize = new Sequelize(config.database , config.username, config.password, config);
// db, username, password, config 설정 정보 이용해서 인스턴스 생성

//1. Sequelize - 모델정의
db.User = require('./user')(sequelize,Sequelize); //모듈연결 sequelize 실행
db.Post = require('./post')(sequelize,Sequelize); //모듈연결 sequelize 실행
db.Image = require('./image')(sequelize,Sequelize); //모듈연결 sequelize 실행
db.Hashtag = require('./hashtag')(sequelize,Sequelize); //모듈연결 sequelize 실행
db.Comment = require('./comment')(sequelize,Sequelize); //모듈연결 sequelize 실행

//2. 모델 관계 설정
Object.keys(db).forEach( modelName=>{
  if(db[modelName].associate){ //model안에 modelNAme associate가 있다면
    db[modelName].associate(db); //associate 실행
  }
});

db.sequelize = sequelize; // 인스턴스
db.Sequelize = Sequelize; // Sequelize 라이브러리 db객체에 저장

module.exports = db; // 다른 파일에서도 db 사용가능하게