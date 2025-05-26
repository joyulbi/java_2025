// [reducers] - user.js
import produce from 'immer';
// step1) 초기값
export const initialState = {
  logInLoading: false, // 로그인 시도중 - 로딩창
  logInDone: false,
  logInError: null, // 로그아웃 시도중 - 로딩창

  logOutLoading: false, // 로그아웃 시도중 - 로딩창
  logOutDone: false,
  logOutError: null, // 로그아웃 시도중 - 로딩창
  //////////////////////////////////////// 추가1
  signUpLoading: false, // 회원가입 시도중
  signUpDone: false,
  signUpError: null,

  changeNicknameLoading: false, // 닉네임 변경 시도중
  changeNicknameDone: false,
  changeNicknameError: null,

  followLoading:false,
  followDone: false,
  followError: null,

  unfollowLoading: false, // 언팔로우 시도중
  unfollowDone: false,
  unfollowError: null,

  //////////////////////////////////////// 추가1- END
  user: null,
  signupDate: {},
  loginData : {}
};

// step2) 로그인할때마다 설정 함수
export const loginAction = (data) => { 
  return {  type:'LOG_IN_REQUEST' , data,  }
};
export const logoutAction = { 
  type: 'LOG_OUT_REQUEST',
};

export const LOG_IN_REQUEST='LOG_IN_REQUEST';
export const LOG_IN_SUCCESS='LOG_IN_SUCCESS';
export const LOG_IN_FAILURE='LOG_IN_FAILURE';

export const LOG_OUT_REQUEST='LOG_OUT_REQUEST';
export const LOG_OUT_SUCCESS='LOG_OUT_SUCCESS';
export const LOG_OUT_FAILURE='LOG_OUT_FAILURE';

export const SIGN_UP_REQUEST='SIGN_UP_REQUEST';
export const SIGN_UP_SUCCESS='SIGN_UP_SUCCESS';
export const SIGN_UP_FAILURE='SIGN_UP_FAILURE';

export const CHANGE_NICKNAME_REQUEST='CHANGE_NICKNAME_REQUEST';
export const CHANGE_NICKNAME_SUCCESS='CHANGE_NICKNAME_SUCCESS';
export const CHANGE_NICKNAME_FAILURE='CHANGE_NICKNAME_FAILURE';

export const FOLLOW_REQUEST='FOLLOW_REQUEST';
export const FOLLOW_SUCCESS='FOLLOW_SUCCESS';
export const FOLLOW_FAILURE='FOLLOW_FAILURE';

export const UNFOLLOW_REQUEST='UNFOLLOW_REQUEST';
export const UNFOLLOW_SUCCESS='UNFOLLOW_SUCCESS';
export const UNFOLLOW_FAILURE='UNFOLLOW_FAILURE';

//--
const dummyUser = (data) => ({
  ...data,
  nickname:'yulbi',
  id:1,
  Posts:[{id:1}],
  Followings:[{nickname:'apple'},{nickname:'banana'},{nickname:'coconut'}],
  Followers:[{nickname:'one'},{nickname:'two'},{nickname:'three'}]
});

// step3) 이전 + 상태 = 다음상태
const reducer = (state=initialState,action) => produce(state,(draft)=>{
  switch (action.type) { 
    case LOG_IN_REQUEST:
      draft.logInLoading=true;
      draft.logInDone=false;
      draft.logInError=null;
      break;
    case LOG_IN_SUCCESS:   // 액션
      draft.user=dummyUser(action.data);
      draft.logInLoading=false;
      draft.logInDone=true;
      break;
    case LOG_IN_FAILURE:   // 액션
      draft.logInLoading=false;
      draft.logInError=action.error;
      break;
    case LOG_OUT_REQUEST:   // 액션
        draft.logOutLoading= true; // 로그아웃 시도중 - 로딩창
        draft.logOutDone= false;
        draft.logOutError= null; // 로그아웃 시도중 - 로딩창 
        break;
    case LOG_OUT_SUCCESS:   // 액션
      draft.user=null;
      draft.logOutLoading=false;
      draft.logOutDone=true;
      break;
    case LOG_OUT_FAILURE:   // 액션
      draft.logOutLoading=false;
      draft.logOutError=action.error;    
      break;
    ////////////////////////////////////////
    case SIGN_UP_REQUEST:   // 액션
      draft.signUpLoading = true;
      draft.signUpDone = false;
      draft.signUpError = null;
      break;
    case SIGN_UP_SUCCESS:   // 액션
      draft.signUpLoading = false;
      draft.signUpDone = true;
      break;
    case SIGN_UP_FAILURE:   // 액션
      draft.signUpLoading = false;
      draft.signUpError = action.error;   
      break;
    ////////////////////////////////////////
    case CHANGE_NICKNAME_REQUEST:   // 액션
      draft.changeNicknameLoading = true;
      draft.changeNicknameDone = false;
      draft.changeNicknameError = null;
      break;
    case CHANGE_NICKNAME_SUCCESS:   // 액션
      draft.user.nickname=action.data.nickname;
      draft.changeNicknameLoading=false;
      draft.changeNicknameDone=true;
      break;
    case CHANGE_NICKNAME_FAILURE:   // 액션
      draft.changeNicknameLoading=false;
      draft.changeNicknameError=action.error;
      break;


    
    ///////////////////////////////////////
    default:
      {break;}
  }  
});

export default reducer;