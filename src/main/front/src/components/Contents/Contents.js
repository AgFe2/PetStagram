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
  // const [userProfileImg, setUserProfileImg] = useState();
  // 게시글 이미지 말고 유저 이미지는 어디서?

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
          <Liked
            likeCnt={props.likeCnt}
            userId={props.userId}
            feedId={props.feedId}
          />
          <Paragraph userId={props.userId} text={props.mainText} />
          <ViewComments comments={props.comments} feedId={props.key} />
        </div>
      </div>
    </>
  );
}
