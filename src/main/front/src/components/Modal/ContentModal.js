import React, { useEffect, useState } from "react";

import ItemUser from "../Contents/ItemUser";
import Paragraph from "../ContentsInfo/Paragraph";
import Comments from "../Contents/Comments";
import Liked from "../ContentsInfo/Liked";

import styles from "../../styles/ContentModal.module.css";
import axios from "axios";

function ContentModal(props) {

  const {imgpath,postcomment ,comment,setModalIsOpen,handleCloseDetail} = props

  useEffect(() => {
    // 배경 스크롤 방지
    document.body.style.cssText = `
    position: fixed;
    top: -${window.scrollY}px;
    overflow-y : scroll;
    width: 100%;`;

    return () => {
      const scrollY = document.body.style.top;
      document.body.style.cssText = ``;
      window.scrollTo(0, parseInt(scrollY || "0", 10) * -1);
    };
  }, []);

  // 댓글 Create
  const [commentValue, setCommentValue] = useState("");
  const [commentArray, setCommentArray] = useState([]);
  const [isValid, setIsValid] = useState(false)


  const onChangeComment = (e) => {
    console.log(e.target.value)
    setCommentValue(e.target.value);
  };

  const handelAddComment = (e) => {
    e.preventDefault();
    let token = localStorage.getItem('JWT')||'';

    const feedId = 1;

    const comment = {

      email:'test@test.com',//임시
      context:commentValue
    }

    axios.post(`http://localhost:8080/feed/save-comment/${feedId}`
    ,JSON.stringify(comment),{
      headers: { "X-AUTH-TOKEN":token, },
    })
    .then((res) => res.json())
    .then(result =>{
      if(token){
        setCommentValue(commentValue);
        setCommentArray(commentArray.concat({
          content:comment.comment_context,
          email:comment.email
        })
        )
    }
    console.log(result)
    return result.data
  })
    
  }

  return (
    <div className={styles.bg} onClick={handleCloseDetail}>
      <button className={styles.closeBtn} onClick={handleCloseDetail}>
        ✖
      </button>
      <div className={styles.body} onClick={(e) => e.stopPropagation()}>
        <div className={styles.pic}>
        </div>
        <div className={styles.info}>
          <div className={styles.infoTop}>
            <ItemUser userId={"userId"} />
          </div>
          <div className={styles.main}>
            <div className={styles.scroll}>
              <Paragraph />
              <Comments />
            </div>
            <div className={`${styles.likedBox} ${styles.infoBottom}`}>
              <Liked />
            </div>
            <form className={styles.inputForm} onSubmit={handelAddComment}>
              <input
                type="text"
                placeholder="댓글 달기..."
                className={styles.inputComment}
                value={commentValue}
                onChange={onChangeComment}
              />
              {/* 자체 유효성 검사 */}
              <button
                  type="submit"
                  className={`${styles.inputButton} ${styles.btnActive}`}
                  disabled = {isValid ? true : false}
                >게시</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ContentModal;
