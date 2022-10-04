import React, { useEffect, useState } from "react";
import axios from "axios";
import ItemUser from "../Contents/ItemUser";
import Paragraph from "../ContentsInfo/Paragraph";
import Comments from "../Contents/Comments";
import Liked from "../ContentsInfo/Liked";
import styles from "../../styles/ContentModal.module.css";

function ContentModal({ handleCloseDetail, imgpath, postcomment, feedId }) {

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
  const [feedComments, setFeedComments] = useState([]); //댓글 모음
  const onChangeComment = (e) => {
    console.log(typeof e.target.value);
    setCommentValue(e.target.value);
  };



  const addComment = async (e) => {
    e.preventDefault();

    await axios
      .post(
        'http://localhost:8080/feed/save-comment',
        JSON.stringify({
          context: commentValue,
        }),

        {
          headers: {
            "Content-Type": "application/json",
            Authorization: "Bearer" + localStorage.getItem("JWT"),
          },
          params:
          {
            feedId:1
          }
        }
      )
      .then((res) => {
        console.log(res)
        setCommentValue("");
      })
      .catch((error) => console.log(error));
  };

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
              <Comments feedId={feedId} />
            </div>
            <div className={`${styles.likedBox} ${styles.infoBottom}`}>
              <Liked />
            </div>
            <form className={styles.inputForm} onSubmit={addComment}>
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

