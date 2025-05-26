import {all,fork,delay,put,takeLatest,throttle} from 'redux-saga/effects'
import {
LOAD_POSTS_REQUEST ,
LOAD_POSTS_SUCCESS ,
LOAD_POSTS_FAILURE ,
generateDummyPost, //더미데이터 호출

ADD_POST_REQUEST ,
ADD_POST_SUCCESS ,
ADD_POST_FAILURE ,

REMOVE_POST_REQUEST, 
REMOVE_POST_SUCCESS ,
REMOVE_POST_FAILURE ,

ADD_COMMENT_REQUEST ,
ADD_COMMENT_SUCCESS ,
ADD_COMMENT_FAILURE

}from '../reducers/post'

function addpostApi(data){
  return axios.POST('/post',data);
}
function* addpost(action){
  //const result = yield call(addpostApi, action.data); //처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type:ADD_POST_SUCCESS,
      data:action.data //result.data
    })
  } catch (error) {
    yield put({
      type:ADD_POST_FAILURE,
      data:error.response.data
    })
  }
}

function addCommentApi(data){
  return axios.POST('/post/comment',data);
}
function* addComment(action) {
  //const result = yield call( addpostApi , action.data); 처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type: ADD_COMMENT_SUCCESS,
      data: action.data   // result.data
    })
  } catch (error) {
    yield put({
      type: ADD_COMMENT_FAILURE,
      data: error.response.data
    })
  }
}

function removePostApi(data){
  return axios.DELETE('/post/',data);
}
function* removePost(action) {
  //const result = yield call( addpostApi , action.data); 처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type: REMOVE_POST_SUCCESS,
      data: action.data   // result.data
    })
  } catch (error) {
    yield put({
      type: REMOVE_POST_FAILURE,
      data: error.response.data
    })
  }
}

function loadPostsApi(data){
  return axios.POST('/posts',data);
}
function* loadPosts(action){
  //const result = yield call(addpostApi, action.data); //처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type:LOAD_POSTS_SUCCESS,
      data:generateDummyPost(10) //result.data
    })
  } catch (error) {
    yield put({
      type:LOAD_POSTS_FAILURE,
      data:error.response.data
    })
  }
}

/////step2) ACTION 기능추가
function*watchAddPost(){
  //yield take('ADD_POST_REQUEST',addpost); // take는 일회용 - 로그인 1번, 게시글도 1번만
  yield takeLatest(ADD_POST_REQUEST,addpost); // ver-2. 3번요청
  // yield throttle('ADD_POST',addpost,10000); ver-3. 몇초뒤에 실행, 시간설정가능 -10초뒤에
}
// ADD_COMMENT_REQUEST
function*watchAddComment(){
  yield takeLatest(ADD_COMMENT_REQUEST,addComment);
}
// REMOVE_POST_REQUEST
function*watchRemovePost(){
  yield takeLatest(REMOVE_POST_REQUEST,removePost);
}
// LOAD_POSTS_REQUEST
function*watchLoadPosts(){
  yield throttle(5000, LOAD_POSTS_REQUEST,loadPosts);
}
/////step1) all()
export default function*postSaga() {
  yield all([ //all - 동시에 배열로 받은 fork들을 동시에 실행
    fork(watchAddPost),
    fork(watchAddComment),
    fork(watchRemovePost),
    fork(watchLoadPosts)
  ]);
}

// fork - generator 함수들을 실행해줌.
// all - 동시에 배열로 받은 fork들을 동시에 실행
// yield