import React from "react";

import ItemUser from "../Contents/ItemUser";
import InfoParagraph from "../ContentsInfo/InfoParagraph";

import styles from "../../styles/ContentDetail.module.css";

function ContentModal(props) {
  const { onClick } = props;
  return (
    <div className={styles.bg} onClick={onClick}>
      <button className={styles.closeBtn} onClick={onClick}>
        ✖
      </button>
      <div className={styles.body} onClick={(e) => e.stopPropagation()}>
        <div className={styles.mainPic}>사진</div>
        <div>
          <ItemUser />
          <InfoParagraph />
        </div>
      </div>
    </div>
  );
}

export default ContentModal;
