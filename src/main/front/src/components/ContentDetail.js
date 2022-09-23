import React from "react";

import styles from "../styles/ContentDetail.module.css";

function ContentDetail(props) {
  const { onClick } = props;
  return (
    <div className={styles.bg}>
      <div className={styles.body}>
        <button className={styles.closeBtn} onClick={onClick}>
          ✖
        </button>
      </div>
    </div>
  );
}

export default ContentDetail;
