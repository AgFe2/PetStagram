import React from "react";

import styles from "../../styles/SearchBar.module.css";
import { FaHashtag } from "react-icons/fa";

function ExistResult(props) {
  const { data, searchType } = props;
  return (
    <>
      {searchType === "tag"
        ? data.map((item) => (
            <div className={styles.resultItem}>
              <div className={styles.hashtagBg}>
                <FaHashtag className={styles.hashtagIcon} />
              </div>
              <div className={styles.hashtagTxt}>
                <span className={styles.hashtagName}>#{item.tagTitle}</span>
                <span className={styles.hashtagCount}>
                  {data.length.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}{" "}
                  posts
                </span>
              </div>
            </div>
          ))
        : data.map((item) => (
            <div className={styles.resultItem}>
              <div className={styles.imgBox}>
                <img className={styles.img} src={""} alt="프로필 이미지"></img>
              </div>
              <div className={styles.userId}>
                <span className={styles.userName}>{item.email}</span>
              </div>
            </div>
          ))}
    </>
  );
}

export default ExistResult;
