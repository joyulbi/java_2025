import { Button, Form, Input } from 'antd';
import React, { useCallback, useEffect } from 'react';
import PropTypes from 'prop-types';
import userInput from '../hooks/userInput'

//1.ADD_POST_REQUEST
import { ADD_COMMENT_REQUEST } from '../reducers/post';
//2.useDispatch, useSelector
import {useSelector,useDispatch} from 'react-redux';

const CommentForm = ({post}) => {    // 어떤게시글에대한 댓글
  //3. addCommentLoading, addCommentDone
  const{addCommentLoading, addCommentDone} = useSelector(state=>state.post);
  const id = useSelector(state=>state.user.user?.id);
 // console.log('..................' + id);
  //4. dispatch
  const dispatch=useDispatch();

  ///////////////////////////////////// code
  const [comment, onChangeComment,setComment] = userInput('');
  useEffect(()=>{
    if(addCommentDone){setComment('');}
  },[addCommentDone])

  const onSubmitForm = useCallback(()=>{
    console.log("........"+ post.id, comment );
    dispatch({
      type:ADD_COMMENT_REQUEST,
      data:{content:comment, userId:id, postId:post.id}
    })
  },[comment]);
  ///////////////////////////////////// view
  return (
    <Form onFinish={onSubmitForm} style={{margin:'30px 2px 70px 2px',position:'relative'}}>
      <Input.TextArea rows={5} value={comment} onChange={onChangeComment}/>
      <Button htmlType="submit" style={{position:'absolute',right:0,bottom:-50}} 
      type='primary' loading={addCommentLoading}>댓글</Button>
    </Form>
  );
};
CommentForm.propTypes = {
  post : PropTypes.object.isRequired
};
export default CommentForm;