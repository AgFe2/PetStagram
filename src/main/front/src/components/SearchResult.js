import React from "react";

import styles from "../styles/Header.module.css";
import { FaHashtag } from "react-icons/fa";

function SearchResult({ filterTag, activeSearch, resultNothing }) {
  return (
    <>
      <div
        className={`${styles.searchResult} ${
          activeSearch ? `${styles.focusActive}` : ""
        }`}
      >
        {filterTag.map((hashtag) => (
          <div className={styles.resultItem}>
            <div className={styles.hashtagBg}>
              <FaHashtag className={styles.hashtagIcon} />
            </div>
            <div className={styles.hashtagTxt}>
              <span className={styles.hashtagName}>
                #{hashtag.hashtag_context}
              </span>
              <span className={styles.hashtagCount}>
                {hashtag.hashtag_feed_count
                  .toString()
                  .replace(/\B(?=(\d{3})+(?!\d))/g, ",")}{" "}
                posts
              </span>
            </div>
          </div>
        ))}
        <div
          className={`${styles.resultNothing} ${
            resultNothing ? `${styles.nothingActive}` : ""
          }`}
        >
          <span>검색 결과가 없습니다.</span>
        </div>
      </div>
    </>
  );
}

export default SearchResult;
