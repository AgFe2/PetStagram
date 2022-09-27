import React from "react";

import ItemUser from "../Contents/ItemUser";
import Paragraph from "../ContentsInfo/Paragraph";
import Comments from "../Contents/Comments";
import Liked from "../ContentsInfo/Liked";

import styles from "../../styles/ContentModal.module.css";

function ContentModal(props) {
  const { onClick } = props;
  return (
    <div className={styles.bg} onClick={onClick}>
      <button className={styles.closeBtn} onClick={onClick}>
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
