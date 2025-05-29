import React,{useCallback} from 'react';
import {Card,Avatar,Button} from 'antd';
import Link from 'next/Link';
import styled from 'styled-components';
//import { logoutAction } from '../reducers/user'; //#1.
import { LOG_OUT_REQUEST } from '../reducers/user';
import { useDispatch,useSelector } from 'react-redux'; //#2.

const ButtonWrapper = styled.div`
  margin-top:5%;
`;

//const UserProfile = ({setIsLogin})=>{
const UserProfile = ()=>{ //#3.
  ///////////////////////////code

  const {logOutLoading,user} = useSelector(state=>state.user);
  console.log(user);
  console.log(user.Posts);
  const dispatch = useDispatch(); //#4.

  // 로그아웃버튼을 누르면 로그아웃되게 만들기
  const onLogOut = useCallback(()=>{
    //setIsLogin(false);
    //dispatch(logoutAction); //#5.
    dispatch({type:LOG_OUT_REQUEST});
  },[]);




  ///////////////////////////view
  return (
  <Card actions={[
    <div key="sns"><Link href={`/user/${user.id}`}>
      <span>게시글<br/>{user.Posts?user.Posts.length:0}</span></Link></div>,
    <div key="followings"><Link href="/profile">
      <span>팔로잉<br/>{user.Followings?user.Followings.length:0}</span></Link></div>,
    <div key="followers"><Link href="/profile">
      <span>팔로워<br/>{user.Followers?user.Followers.length:0}</span></Link></div>,
  ]}>
    <Card.Meta avatar={<Avatar>{user.nickname?user.nickname[0]:'N'}</Avatar>} title={user.nickname}/>
    <ButtonWrapper>
      <Button onClick={onLogOut} loading={logOutLoading}>로그아웃</Button>
    </ButtonWrapper>

  </Card>
  );
};

export default UserProfile;