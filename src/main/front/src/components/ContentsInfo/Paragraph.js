import React from "react";

// CSS
import styles from "../../styles/Contents.module.css";

function Paragraph(props) {
  return (
    <>
      <div className={styles.infoParagraph}>
        <h4 className={styles.paragraphName}>{props.userId}</h4>
        <p className={styles.paragraphDesc}>description</p>
      </div>
    </>
  );
}

export default Paragraph;
