import React from "react";

// components
import ItemUser from "./ItemUser";
import InfoLiked from "../ContentsInfo/InfoLiked";
import InfoParagraph from "../ContentsInfo/InfoParagraph";
import InfoComments from "../ContentsInfo/InfoComments";

// CSS
import styles from "../../styles/Contents.module.css";

export default function Contents(props) {
  return (
    <>
      {/* array.map(item => ( <li> ... </li>))
      몇 개 load할지 정한 뒤, 그 이상 스크롤할 경우 게시글 추가업로드 */}
      <div className={styles.contentsItem}>
        <ItemUser userId={props.userId} />
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
          <InfoLiked liked={props.liked} />
          <InfoParagraph userId={props.userId} />
          <InfoComments comments={props.comments} />
        </div>
      </div>
    </>
  );
}
