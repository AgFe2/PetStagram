import React, { useState } from "react";

// CSS
import styles from "../../styles/Contents.module.css";

function InfoParagraph(props) {
  return (
    <>
      <div className={styles.infoParagraph}>
        <h4 className={styles.paragraphName}>{props.userId}</h4>
        <p className={styles.paragraphDesc}>
          description <span>...더보기</span>
        </p>
      </div>
    </>
  );
}

export default InfoParagraph;
