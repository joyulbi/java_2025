import React , { useEffect, useState } from 'react';
import { useRouter } from "next/router";
import axios from 'axios';

import AppLayout from '../../components/AppLayout';
import PostCard from '../../components/PostCard';

const Hashtag = () => {
  ////////////////////////// code
  const router = useRouter(); //router
  const { tag } = router.query; //query
  const [mainPosts, setMainPosts] = useState([]);
  const [hasMorePosts, setHasMorePosts] = useState(true);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  useEffect(() => {
    //////axios
    const fetchData = async () => {
      try {
        setLoading(true);
        const response = await axios.get(
          `http://localhost:3065/hashtag/${tag}`, { withCredentials: true }
        );
        setMainPosts(response.data);
        setHasMorePosts(response.data.length > 0);
      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    };
    if (tag) { fetchData(); }
  }, [tag]);

  //##스크롤내려서 맨끝에서 다시 로딩
  useEffect(()=>{
    function onScroll(){
      if (window.screenY+document.documentElement.clientHeight>document.documentElement.scrollHeight-200) {
        if (hasMorePosts&&!loadPostsLoading) {
          axios.get(`http://localhost:3065/hashtag/${tag}?lastId=${mainPosts[mainPosts.length-1]?.id}`,{withCredentials:true})
          .then((response)=>{
            setMainPosts((prev=>[...prev, ...response.data]));
            setHasMorePosts(response.data.length>0);
          })
          .catch((err)=>setError(err));
        }
      }
    }
    window.addEventListener('scroll',onScroll);
    return ()=>{
      window.removeEventListener('scroll',onScroll); //스크롤했으면 스크롤했던거 remove, 메모리 쌓임
    }
  },[mainPosts,hasMorePosts,tag,loading]);

  if(loading){return <div>해쉬태그 게시글 ing...</div>;}
  if(error){return <div>error...</div>;}
  ////////////////////////// view
  return (
    <AppLayout>
      {mainPosts.map((post) => {
        return (
          <PostCard post={post} key={post.id} />
        );
      })}
    </AppLayout>);
};

export default Hashtag;