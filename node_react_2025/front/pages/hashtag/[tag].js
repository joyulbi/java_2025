import React , { useEffect, useState } from 'react';
import AppLayout from '../../components/AppLayout';
import PostCard from '../../components/PostCard';

import { useRouter } from 'next/router';
import { useDispatch, useSelector } from 'react-redux';
import axios from 'axios';
import { LOAD_HASHTAG_POSTS_REQUEST } from '../../reducers/post';
import { LOAD_MY_INFO_REQUEST} from '../reducers/user';  //##
import { END } from 'redux-saga';
import wrapper from '../store/configureStore';

const Hashtag = () => {
  ////////////////////////// code
  const dispatch = useDispatch();
  const router = useRouter(); //router
  const { tag } = router.query; //query

  const {mainPosts,hasMorePosts,loadPostsLoading} = useSelector(state=>state.post)
  // const [mainPosts, setMainPosts] = useState([]);
  // const [hasMorePosts, setHasMorePosts] = useState(true);
  // const [loading, setLoading] = useState(true);
  // const [error, setError] = useState(null);
  /*useEffect(() => {
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
  }, [tag]);*/

  //##스크롤내려서 맨끝에서 다시 로딩
  useEffect(()=>{
    function onScroll(){
      if (window.screenY+document.documentElement.clientHeight>document.documentElement.scrollHeight-200) {
        if (hasMorePosts&&!loadPostsLoading) {
          dispatch({
            type:LOAD_HASHTAG_POSTS_REQUEST,
            lastId:mainPosts[mainPosts.length-1]&&mainPosts[mainPosts.length-1].id,
            data:tag
          })
         /* axios.get(`http://localhost:3065/hashtag/${tag}?lastId=${mainPosts[mainPosts.length-1]?.id}`,{withCredentials:true})
          .then((response)=>{
            setMainPosts((prev=>[...prev, ...response.data]));
            setHasMorePosts(response.data.length>0);
          })
          .catch((err)=>setError(err));*/
        }
      }
    }
    window.addEventListener('scroll',onScroll);
    return ()=>{
      window.removeEventListener('scroll',onScroll); //스크롤했으면 스크롤했던거 remove, 메모리 쌓임
    }
  },[mainPosts.length,hasMorePosts,tag,loadPostsLoading]);

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

///////////////////////////////////////////////////////////
export const getServerSideProps = wrapper.getServerSideProps(async (context) => {
  //1. cookie 설정
  const cookie = context.req ? context.req.headers.cookie : '';
  axios.defaults.headers.Cookie = '';

  if (context.req && cookie) { axios.defaults.headers.Cookie = cookie; }

  //2. redux 액션
  context.store.dispatch({ type: LOAD_MY_INFO_REQUEST });
  context.store.dispatch({ type: LOAD_HASHTAG_POSTS_REQUEST ,data:context.params.tag});
  context.store.dispatch(END);

  await context.store.sagaTask.toPromise();
});
///////////////////////////////////////////////////////////
export default Hashtag;