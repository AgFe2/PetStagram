import React, { useState } from "react";

import styles from "../../styles/Contents.module.css";
import { FaHeart, FaRegHeart } from "react-icons/fa";

function Liked(props) {
  const [likedBtn, setLikedBtn] = useState(false);
  const toggleLiked = () => setLikedBtn(!likedBtn);

  return (
    <div className={styles.infoLiked}>
      <button onClick={toggleLiked} className={styles.likedBtn}>
        {likedBtn ? <FaHeart /> : <FaRegHeart />}
      </button>
      <p style={{ fontWeight: "bold" }}>{props.liked} liked</p>
    </div>
  );
}

export default Liked;
