import React, { useState, useCallback, useEffect } from 'react';
import PropTypes from 'prop-types';  // 넘겨받은 데이터확인 
import { Button, Input } from 'antd';  // 화면디자인
import { useSelector } from 'react-redux';  // 중앙저장소
import Link from 'next/Link';
const PostCardContent = ({ editMode, postData, onChangePost, onCancelUpdate }) => {
  ////////////////////////////////// code
  const { updatePostLoading, updatePostDone } = useSelector(state => state.post);  // 중앙저장소 상태
  const [editText, setEditText] = useState(postData);  // 글 받아서 수정 - 변수:글수정, react에게 알려서 글수정반영
  const onChangeText = useCallback((e) => {
    setEditText(e.target.value);
  });  //  글 수정 event 반영

  useEffect(() => {
    if (updatePostDone) {
      onCancelUpdate();
    }
  }, [updatePostDone]);
  const onClickCancel = useCallback(() => {
    setEditText(postData);
    onCancelUpdate();
  });  // 수정취소
  ////////////////////////////////// view
  return (
    <div>
      {
        editMode ? (
          <>
            <Input.TextArea value={editText} onChange={onChangeText} />
            <Button.Group style={{ margin: '5px 0' }}>
              <Button loading={updatePostLoading} onClick={onChangePost(editText)} style={{ margin: '5px' }}>수정</Button>
              <Button type="primary" onClick={onClickCancel} style={{ margin: '5px' }}>취소</Button>
            </Button.Group>
          </>
        ) : (postData
          .split(/(#[^\s#]+)/g) //해쉬태그
          .map((v, i) => {
            if (v.match(/(#[^\s#]+)/)) {
              return <Link href={`/hashtag/${v.slice(1)}`} prefetch={false} key={i}>{v}</Link>;
            }
            return v;
          })
        )
      }
    </div>
  );
};
PostCardContent.propTypes = {
  editMode: PropTypes.bool,
  postData: PropTypes.string.isRequired,
  onChangePost: PropTypes.func.isRequired,
  onCancelUpdate: PropTypes.func.isRequired
};
PostCardContent.defaultProps = {
  editMode: false
};

export default PostCardContent;