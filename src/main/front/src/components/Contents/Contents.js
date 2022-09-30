import React from "react";

// components
import ItemUser from "./ItemUser";
import Liked from "../ContentsInfo/Liked";
import Paragraph from "../ContentsInfo/Paragraph";
import ViewComments from "../ContentsInfo/ViewComments";

// CSS
import styles from "../../styles/Contents.module.css";

export default function Contents(props) {
  return (
    <>
      <div className={styles.Item}>
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
          <Liked liked={props.liked} />
          <Paragraph userId={props.userId} />
          <ViewComments comments={props.comments} />
        </div>
      </div>
    </>
  );
}
