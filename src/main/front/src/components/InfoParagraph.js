import React, { useState } from "react";

// components
import ContentDetail from "./ContentDetail";

// CSS
import styles from "../styles/Contents.module.css";
import { FaHeart, FaRegHeart } from "react-icons/fa";

function InfoParagraph(props) {
  const [likedBtn, setLikedBtn] = useState(false);
  const toggleLiked = () => setLikedBtn(!likedBtn);

  const [openDetail, setOpenDetail] = useState(false);
  const handleOpenDetail = () => {
    setOpenDetail(true);
  };
  const handleCloseDetail = () => {
    setOpenDetail(false);
  };

  return (
    <div className={styles.itemInfo}>
      <div className={styles.infoLiked}>
        <button onClick={toggleLiked} className={styles.likedBtn}>
          {likedBtn ? <FaHeart /> : <FaRegHeart />}
        </button>
        <p style={{ fontWeight: "bold" }}>{props.liked} liked</p>
      </div>
      <div className={styles.infoParagraph}>
        <h4 className={styles.paragraphName}>{props.userId}</h4>
        <p className={styles.paragraphDesc}>
          description <span>...더보기</span>
        </p>
      </div>
      <button className={styles.allComments} onClick={handleOpenDetail}>
        {props.comments} view all comments
      </button>
      {openDetail == true ? (
        <ContentDetail onClick={handleCloseDetail} />
      ) : null}
    </div>
  );
}

export default InfoParagraph;
