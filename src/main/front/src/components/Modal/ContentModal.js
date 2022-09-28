import React, { useEffect } from "react";

import ItemUser from "../Contents/ItemUser";
import Paragraph from "../ContentsInfo/Paragraph";
import Comments from "../Contents/Comments";
import Liked from "../ContentsInfo/Liked";

import styles from "../../styles/ContentModal.module.css";

function ContentModal(props) {
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

  const { handleCloseDetail } = props;
  return (
    <div className={styles.bg} onClick={handleCloseDetail}>
      <button className={styles.closeBtn} onClick={handleCloseDetail}>
        ✖
      </button>
      <div className={styles.body} onClick={(e) => e.stopPropagation()}>
        <div className={styles.pic}>사진</div>
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
            <div className={styles.inputForm}>
              <input
                type="text"
                placeholder="댓글 달기..."
                className={styles.inputComment}
              />
              <button type="button" className={styles.inputButton}>
                게시
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ContentModal;
