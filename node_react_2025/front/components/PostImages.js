import { PlusOutlined } from "@ant-design/icons";
import PropTypes from "prop-types";
import React, { useCallback, useState } from "react";
import ImagesZoom from "./ImagesZoom";
const PostImages=({images})=>{
  //////////////////////////////// code
  const [showImageZoom, setShowImageZoom] = useState(false);
  const onZoom = useCallback(()=>{setShowImageZoom(true);},[]);
  const onClose = useCallback(()=>{setShowImageZoom(false)},[]);

  if(images.length===1){
    return(
      <>
        <img role="presentation" src={images[0].src} alt={images[0].src} onClick={onZoom}/>
        {showImageZoom && <ImageZoom images={images} onClose={onClose}/>}
      </>
    );
  }
  if(images.length===2){
    return(
      <>
        <img role="presentation" src={images[0].src} alt={images[0].src} onClick={onZoom} 
        style={{width:'50%',display:'inline-block'}}/>
        <img role="presentation" src={images[1].src} alt={images[1].src} onClick={onZoom} 
        style={{width:'50%',display:'inline-block'}}/>
        {showImageZoom && <ImagesZoom images={images} onClose={onClose}/>}
      </>
    );    
  }
  //////////////////////////////// view
  return(
    <>
      <div>
        <img role="presentation" src={images[0].src} alt={images[0].src} width="50%" onClick={onZoom}/>
        <div role="presentation"
          style={{display:'inline-block',width:'50%',textAlign:'center',
            verticalAlign:'middle'
          }}onClick={onZoom}>
          <PlusOutlined/>
          <br/>
          {images.length-1}개의 사진 더보기
        </div>
      </div>
      {showImageZoom && <ImagesZoom images={images} onClose={onClose}/>}
    </>
  );
};
PostImages.propTypes = {
  //images : PropTypes.arrayOf(PropTypes.object).isRequired
  images : PropTypes.arrayOf(PropTypes.shape({
    src:PropTypes.string
  })).isRequired
};
export default PostImages;