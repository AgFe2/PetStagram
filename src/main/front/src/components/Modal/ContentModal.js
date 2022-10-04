import React, { useEffect, useState } from "react";
import axios from "axios";
import ItemUser from "../Contents/ItemUser";
import Paragraph from "../ContentsInfo/Paragraph";
import Comments from "../Contents/Comments";
import Liked from "../ContentsInfo/Liked";
import CommentForm from "../Forms/CommentForms/CommentForm";
import styles from "../../styles/ContentModal.module.css";



function ContentModal(props) {
  const { handleCloseDetail, imgpath, postcomment, feedId } = props;

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


    
  return (
    <div className={styles.bg} onClick={handleCloseDetail}>
      <button className={styles.closeBtn} onClick={handleCloseDetail}>
        ✖
      </button>
      <div className={styles.body} onClick={(e) => e.stopPropagation()}>
        <div className={styles.picWrap}>
          <img src={imgpath} className={styles.pic} alt="contents-img" />
        </div>
        <div className={styles.info}>
          <div className={styles.infoTop}>
            <ItemUser userId={"user"} />
          </div>
          <div className={styles.main}>
            <div className={styles.scroll}>
              <Paragraph text={postcomment} />
                <Comments />             
            </div>
            <div className={`${styles.likedBox} ${styles.infoBottom}`}>
              <Liked />
            </div>

          </div>
        </div>
      </div>
    </div>
  );
}

export default ContentModal;
