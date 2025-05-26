import React ,{useCallback} from 'react'
import { Card, Avatar, Button } from 'antd';
import styled from 'styled-components';  

//import { logoutAction } from '../reducers/user'; //##1. redux
import { LOG_OUT_REQUEST } from '../reducers/user';
import { useDispatch, useSelector } from 'react-redux'; //##2. redux

const ButtonWrapper = styled.div `margin-top:5%;`;

//const UserProfile = ({setIsLogin}) => { 
const UserProfile = () => { //##3. redux
  const{logOutLoading,user}=useSelector(state=>state.user);
  console.log(user);
  console.log(user.Posts);
  ////////////////////////// code
  const dispatch = useDispatch(); //##4. redux
  // 로그아웃버튼을 누르면 로그아웃되게 만들기
  const onLogOut = useCallback(() => { 
 //   dispatch(logoutAction) //##5. redux
      dispatch({type:LOG_OUT_REQUEST})
  } , []);
  ////////////////////////// view
  return (<Card
    actions={[
         <div  key="sns">게시글<br/>{user.Posts?user.Posts.length:0}</div> 
        ,<div  key="followings">팔로잉<br/>{user.Followings?user.Followings.length:0}</div> 
        ,<div  key="followers"> 팔로워<br/>{user.Followers?user.Followers.length:0}</div> 
      ]}
    > 
    <Card.Meta avatar={<Avatar>{user.nickname[0]}</Avatar>}
      title={user.nickname} />
    <ButtonWrapper>
      <Button onClick={onLogOut} loading={logOutLoading}>로그아웃</Button>
    </ButtonWrapper>
  </Card>);
};

export default UserProfile;