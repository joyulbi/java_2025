// [reducers] - post.js
import shortId from 'shortid'; //##
import produce from 'immer';
import {faker} from '@faker-js/faker';
faker.seed(123);

export const initialState = {
  /*mainPosts:[{
    id:1,
    User : {id:1, nickname:'yulbi0725'},
    content:'첫번째 게시글 #node #react',
    Images : [{id:shortId.generate() ,src:'https://i.namu.wiki/i/2qEEMeUPp3N2LXaVzinmW0hrzB5208qevfS1Z6BD9rTxQaCKIbZXimGWEyJVF_IJZWI9-F9iK8PuF0CS6pPAOA.webp'},
      {id:shortId.generate() ,src:'https://i.namu.wiki/i/Rdz16dNRpyuRwaQvdrrBWooSRPiH7fpzRMUZbaVOAC16XR9ssogOQ7cOS9AEpQZmFBoNCS2FXiuL0H4MZx6bmw.webp'},
      {id:shortId.generate() ,src:'https://an2-img.amz.wtchn.net/image/v2/CswuhDjWNPFG1p_4h-iM-w.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1KbklsMHNJbkFpT2lJdmRqSXZjM1J2Y21VdmFXMWhaMlV2TVRZeU1qUXpOak0wT0RnMU16TXdPRFV5TUNKOS5FOURnQ0VKdDE2NFlGeUNsTlN2UGpqN3ZXSGhCTFIzX2o1ZnhNcHZWZ1ZF'}
      ],
    Comments:[{
      id:shortId.generate() ,
      User:{id:shortId.generate(), nickname:'one'}, content:'hello'
    },{User:{id:shortId.generate(),nickname:'two'},content:'hi'}]
  }],*/
  mainPosts:[],
   /////////////////////////// 추가 START
   //postAdd: false,
   imagePaths: [],
   hasMorePosts: true,

   loadPostsLoading: false,
   loadPostsDone: false,
   loadPostsError: null,

   addPostLoading: false,
   addPostDone: false,
   addPostError: null,

   removePostLoading: false,
   removePostDone: false,
   removePostError: null,

   addCommentLoading: false,
   addCommentDone: false,
   addCommentError: null,
   /////////////////////////// 추가 END
}
/////////////////////////// action
export const addPost = {type:'ADD_POST'}

////////// dummyPost
const dummyPost =(data)=>({
  //id:2,
  id:shortId.generate() ,
  content:data,
  User:{id:1,nickname:'123'},
  Images:[],
  Comments:[]
});
//////////
const dummyComment =(data)=>({
  //id:3,
  id:shortId.generate() ,
  content: data,
  User:{id:1, nickname:'123'},
});
//10개씩 무한스크롤 부르는 메서드
export const generateDummyPost = (number) => Array(number).fill().map(() => ({   
   id: shortId.generate(),
   User: {
      id: shortId.generate(),
      nickname: faker.internet.username(),
   },
   content: faker.lorem.paragraph(),
   Images: [{
      src: faker.image.avatar(),
   }],
   Comments: [{
      User: {
         id: shortId.generate(),
         nickname: faker.internet.username(),
      },
      content: faker.lorem.sentence(),
   }],
}));

export const LOAD_POSTS_REQUEST = 'LOAD_POSTS_REQUEST';
export const LOAD_POSTS_SUCCESS = 'LOAD_POSTS_SUCCESS';
export const LOAD_POSTS_FAILURE = 'LOAD_POSTS_FAILURE';

export const ADD_POST_REQUEST = 'ADD_POST_REQUEST';
export const ADD_POST_SUCCESS = 'ADD_POST_SUCCESS';
export const ADD_POST_FAILURE = 'ADD_POST_FAILURE';

export const REMOVE_POST_REQUEST = 'REMOVE_POST_REQUEST';
export const REMOVE_POST_SUCCESS = 'REMOVE_POST_SUCCESS';
export const REMOVE_POST_FAILURE = 'REMOVE_POST_FAILURE';

export const ADD_COMMENT_REQUEST = 'ADD_COMMENT_REQUEST';
export const ADD_COMMENT_SUCCESS = 'ADD_COMMENT_SUCCESS';
export const ADD_COMMENT_FAILURE = 'ADD_COMMENT_FAILURE';

/////////////////////////// next
const reducer=(state=initialState,action)=>produce(state,(draft)=>{
  switch(action.type){
    case LOAD_POSTS_REQUEST:
      draft.loadPostsLoading=true; 
      draft.loadPostsDone=false;
      draft.loadPostsError=null; 
      break;
    case LOAD_POSTS_SUCCESS:
      draft.loadPostsLoading=false; 
      draft.loadPostsDone=true;
      draft.mainPosts=action.data.concat(draft.mainPosts); //새로운데이터10 + 기존데이터
      console.log('...mainPosts',action.data.concat(draft.mainPosts).length);
      draft.hasMorePosts=draft.mainPosts.length<50; //게시물 50개부근 보이게 체크
      break;
    case LOAD_POSTS_FAILURE:
      draft.loadPostsLoading=false; 
      draft.loadPostsError=action.error; 
      break;
    case ADD_POST_REQUEST:
      draft.addPostLoading=true; 
      draft.addPostDone=false;
      draft.addPostError=null; 
      break;
    case ADD_POST_SUCCESS:
      draft.addPostLoading=false; 
      draft.addPostDone=true;
      draft.mainPosts.unshift(dummyPost(action.data));
      break;
    case ADD_POST_FAILURE:
      draft.addPostLoading=false; 
      draft.addPostError=action.error; 
      break;
    case REMOVE_POST_REQUEST:
      draft.removePostLoading = true;
      draft.removePostDone = false;
      draft.removePostError = null;
      break;
    case REMOVE_POST_SUCCESS:
      draft.removePostLoading = false;
      draft.removePostDone = true;
      draft.mainPosts=draft.mainPosts.filter(v=> v.id !== action.data);
      break;
    case REMOVE_POST_FAILURE:
      draft.removePostLoading = false;
      draft.removePostError = action.error;
      break;
      //////////
    case ADD_COMMENT_REQUEST:
      draft.addCommentLoading =true;
      draft.addCommentDone= false;
      draft.addCommentError=null;
      break;
    case ADD_COMMENT_SUCCESS:
      //1. postIndex 해당글 가져오기
      const post = draft.mainPosts.find(v=>v.id===action.data.postId);
      //2. post.Comment
      post.Comments.unshift(dummyComment(action.data.content));
      draft.addCommentLoading=false;
      draft.addCommentDone=true;
      break;
    case ADD_COMMENT_FAILURE:
      draft.addCommentLoading =false;
      draft.addCommentError=action.error;
      break;

    default:{
      break;
    }
  }
});

export default reducer;