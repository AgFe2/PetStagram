import React, { useState } from "react";

// CSS
import styles from "../../styles/Contents.module.css";

function Paragraph(props) {
  const [descOpen, setDescOpen] = useState(false);
  const handleDescOpen = () => {
    setDescOpen(!descOpen);
  };
  return (
    <>
      <div className={styles.infoParagraph}>
        <h4 className={styles.paragraphName}>{props.userId}</h4>
        <p
          className={`${styles.paragraphDesc} ${
            descOpen ? `${styles.active}` : null
          }`}
        >
          {props.text}
        </p>
        <button
          type="button"
          className={`${styles.moreBtn} ${
            descOpen ? `${styles.active}` : null
          }`}
          onClick={handleDescOpen}
        >
          ...더보기
        </button>
      </div>
    </>
  );
}

export default Paragraph;
