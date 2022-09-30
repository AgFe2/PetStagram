import React, { useEffect, useState } from "react";

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

  // commentValue
  const [commentValue, setCommentValue] = useState("");
  const onChangeComment = (e) => {
    setCommentValue(e.target.value);
  };

  // POST
  // async function postComment() {
  //   try {
  //     const response = await axios.post("feed/{feedId}/save-comment", {});
  //     // 성공
  //   } catch (error) {
  //     // 실패
  //   }
  // }

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
            <form className={styles.inputForm}>
              <input
                type="text"
                placeholder="댓글 달기..."
                className={styles.inputComment}
                value={commentValue}
                onChange={onChangeComment}
              />
              {commentValue.length > 0 ? (
                <button
                  type="submit"
                  className={`${styles.inputButton} ${styles.btnActive}`}
                >
                  게시
                </button>
              ) : (
                <button type="button" className={styles.inputButton}>
                  게시
                </button>
              )}
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ContentModal;
