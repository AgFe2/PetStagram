import React, { useState } from "react";
import styles from "../styles/Contents.module.css";
import { FaHeart, FaRegHeart } from "react-icons/fa";

export default function Contents(props) {
  const [likedBtn, setLikedBtn] = useState(false);
  const toggleLiked = () => setLikedBtn(!likedBtn);

  return (
    <>
      {/* array.map(item => ( <li> ... </li>))
      몇 개 load할지 정한 뒤, 그 이상 스크롤할 경우 게시글 추가업로드 */}
      <div className={styles.contentsItem}>
        <div className={styles.itemUser}>
          <div className={styles.userProfile} />
          <h4 className={styles.userName}>{props.userId}</h4>
        </div>
        <div>
          <img
            src=""
            alt=""
            style={{ backgroundColor: "pink", border: "none" }}
            height="500px"
            width="500px"
          />
        </div>
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
          <p className={styles.allComments}>
            {props.comments} view all comments
          </p>
        </div>
      </div>
    </>
  );
}
