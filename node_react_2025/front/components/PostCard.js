import React, { useCallback, useState ,useEffect} from 'react';
import { Card, Avatar, Button , List, Comment  , Popover } from 'antd';
import { EllipsisOutlined, HeartOutlined, HeartTwoTone, MessageOutlined, RetweetOutlined } from '@ant-design/icons';
import PostImages from './PostImages';
import CommentForm from './commentForm';
import { useDispatch, useSelector } from 'react-redux';

//1. REMOVE_POST_REQUEST
import { REMOVE_POST_REQUEST,LIKE_POST_REQUEST,UNLIKE_POST_REQUEST } from '../reducers/post';
import FollowButton from './FollowButton';

const PostCard = ({post}) => { 
  ///////////////////////////////////////////// code
  const id= useSelector((state)=>state.user.user?.id);
  const {removePostLoading,removePostDone} = useSelector(state=>state.post)
  const dispatch=useDispatch();

  //1. 좋아요 - false
  //const [like,setLike] = useState(false);
  const onClickLike = useCallback(()=>{
    if(!id){return alert('로그인을 하시면 좋아요 추가가 가능합니다.');}
    return dispatch({
      type:LIKE_POST_REQUEST,
      data:post.id
    });
  },[id]);

  const onClickUnLike = useCallback(()=>{
    if(!id){return alert('로그인을 하시면 좋아요 추가가 가능합니다.');}
    return dispatch({
      type:UNLIKE_POST_REQUEST,
      data:post.id
    });
  },[id]);

  const like = post.Likers?.find((v)=>v.id==id); //내가 눌렀는지 체크

  //2. 댓글
  const [commentOpened, setCommentOpened] = useState(false);
  const onClickComment=useCallback(()=>{setCommentOpened((prev)=>!prev);},[])

  //3. 삭제 버튼
  useEffect(()=>{
    if(removePostDone){console.log('removePost');}
  },[]);

  const onRemovePost = useCallback(()=>{
    dispatch({
      type:REMOVE_POST_REQUEST,
      data:post.id
    });
  },[id,post.id]);



  ///////////////////////////////////////////// view
  return (<div  style={{margin:'3%'}}>
    <Card 
      cover={post.Images && post.Images.length > 0 &&
      <PostImages images ={post.Images}/>}
      actions={[
        <RetweetOutlined key="retweet"/>,
        like?
        <HeartTwoTone twoToneColor="#f00" key="heart" onClick={onClickUnLike}/>
        : <HeartOutlined key="heart" onClick={onClickLike}/>,
        <MessageOutlined key="comment" onClick={onClickComment}/>,
        <Popover content={(
          <Button.Group>
            { id&& id === post.User.id
            ?( <><Button>수정</Button>
              <Button type="danger" onClick={onRemovePost} loading={removePostLoading} >삭제</Button></>
            ) 
            :  <Button>신고</Button>
            }
          </Button.Group>

        )}>
          <EllipsisOutlined key="more"/>
        </Popover>
      ]}
      extra={id && <FollowButton post={post}/>}
    >
      <Card.Meta avatar={<Avatar>{post.User.nickname[0]}</Avatar>} 
        title={post.User.nickname} 
        description={post.content}/>
    </Card>
  {commentOpened &&(
  <>
    {/* 댓글 폼 */}
    <CommentForm post={post}/>
    {/* 댓글 리스트*/}
    <List
      header = {`${post.Comments.length}댓글`}
      itemLayout='horizontal'
      dataSource={post.Comments}
      renderItem={(item)=>(
        <li>
          <Comment
            avatar={<Avatar>{item.User.nickname[0]}</Avatar>}
            content={item.content}
            author={item.User.nickname}
          />
        </li>
      )}
    />
  </>
  )}
  </div>);
};
export default PostCard;