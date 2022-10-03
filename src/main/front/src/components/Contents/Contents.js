import React, { useState } from "react";
import axios from "axios";
// components
import ItemUser from "./ItemUser";
import Liked from "../ContentsInfo/Liked";
import Paragraph from "../ContentsInfo/Paragraph";
import ViewComments from "../ContentsInfo/ViewComments";

// CSS
import styles from "../../styles/Contents.module.css";

export default function Contents(props) {
  const [imgSrc, setImgSrc] = useState();
  axios
    .get("file/list", { params: { userId: props.userID } })
    .then((res) => {
      console.log(res.data);
      res.arrayBuffer();
    })
    .then((buffer) => {
      const blob = new Blob([buffer]);
      setImgSrc(URL.createObjectURL(blob));
    })
    .catch((err) => console.log(err));

  return (
    <>
      <div className={styles.Item}>
        <ItemUser userId={props.userId} />
        <div>
          <img src={imgSrc} alt="" className={styles.img} />
        </div>
        <div className={styles.itemInfo}>
          <Liked liked={props.liked} />
          <Paragraph userId={props.userId} text={props.text} />
        </div>
      </div>
    </>
  );
}
