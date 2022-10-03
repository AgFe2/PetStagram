import React from "react";

//CSS
import styles from "../../styles/SearchBar.module.css";
import { FaHashtag } from "react-icons/fa";

function SearchResult(props) {
  const { data, activeSearch, search } = props;
  return (
    <>
      <div
        className={`${styles.searchResult} ${
          activeSearch ? `${styles.focusActive}` : ""
        }`}
      >
        {data.length > 0 && search.length > 0 ? (
          data.map((item) => (
            <div className={styles.resultItem}>
              <div className={styles.hashtagBg}>
                <FaHashtag className={styles.hashtagIcon} />
              </div>
              <div className={styles.hashtagTxt}>
                <span className={styles.hashtagName}>
                  #{item.hashtag_context}
                </span>
                <span className={styles.hashtagCount}>
                  {item.hashtag_feed_count
                    .toString()
                    .replace(/\B(?=(\d{3})+(?!\d))/g, ",")}{" "}
                  posts
                </span>
              </div>
            </div>
          ))
        ) : (
          <div className={`${styles.resultNothing}`}>
            <span>검색 결과가 없습니다.</span>
          </div>
        )}
      </div>
    </>
  );
}

export default SearchResult;
