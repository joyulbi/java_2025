import React, { useEffect, useState } from "react";
import AppLayout from "../../components/AppLayout";
import { useSelector } from "react-redux";
import { Avatar, Card } from 'antd';
import Head from 'next/head';
import { useRouter } from 'next/router';
import axios from 'axios';
import PostCard from "../../components/PostCard";

const User = () => {
  // 유저정보
  const router = useRouter();
  const { id } = router.query; console.log('.....', id);
  const { user } = useSelector(state => state.user);;
  const [userInfo, setUserInfo] = useState(null);
  const [mainPosts, setMainPosts] = useState([]);
  const [hasMorePosts, setHasMorePosts] = useState(true);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // 유저정보 불러오기
  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        const userResponse = await axios.get(
          `http://localhost:3065/user/${id}`, { withCredentials: true }
        );
        const postsResponse = await axios.get(
          `http://localhost:3065/user/${id}/posts`, { withCredentials: true }
        );
        setUserInfo(userResponse.data);
        setMainPosts(postsResponse.data);
        setHasMorePosts(postsResponse.data.length > 0);
      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    };
    if (id) { fetchData(); }
  }, [id]);

  // 스크롤처리
  useEffect(() => {
    function onScroll() {
      //          내가 내린길이     + 화면에 보이는 높이                      = 브라우저 길이
      console.log(window.screenY, document.documentElement.clientHeight, document.documentElement.scrollHeight)
      //          내가 내린길이     + 화면에 보이는 높이 = 브라우저길이-200px 아래정도로 오면은      
      if (window.screenY + document.documentElement.clientHeight > document.documentElement.scrollHeight - 200) {
        if (hasMorePosts && !loading) {
          axios.get(`http://localhost:3065/user/${id}/posts?lastId=${mainPosts[mainPosts.length - 1]?.id}`, 
            { withCredentials: true })
            .then(response=>{
              setMainPosts(prev => [...prev,...response.data]);
              setHasMorePosts(response.data.length>0);
            })
            .catch(err=>setError(err));
        }
      }
    }
    window.addEventListener('scroll', onScroll);
    return () => {
      window.removeEventListener('scroll', onScroll); //스크롤했으면 스크롤했던거 remove, 메모리에 쌓임
    }
  }, [mainPosts, hasMorePosts, id,loading]);

  if (loading) { return <div>정보 ing...</div> }
  if (error) { return <div>error</div> }
  // post
  return (
    <AppLayout>
      {userInfo &&(
      <Head>
        <title>{userInfo.nickname}님의 글</title>
        <meta name="description" content={`${userInfo.nickname}님의 게시글`} />
      </Head>
      )}
      { userInfo && (
      <Card actions={[
        <div key="post">게시글<br/>{userInfo.Posts}</div>,
        <div key="followings">팔로잉<br/>{userInfo.Followings}</div>,
        <div key="followers">팔로워<br/>{userInfo.Followers}</div>
      ]}>
        <Card.Meta avatar={<Avatar>{userInfo.nickname[0]}</Avatar>} 
        title={userInfo.nickname} />
      </Card>
      )}
      {mainPosts.map(post =><PostCard key={post.id} post={post}/>)}
    </AppLayout>
  );
};

export default User;