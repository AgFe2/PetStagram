import React, { useEffect, useState } from "react";

import Header from "../../components/Header/Header";
import Contents from "../../components/Contents/Contents";
import styles from "../../styles/Contents.module.css";
import axios from "axios";
export default function Main() {
  const [contents, setContents] = useState([]);
  const [commentsLength, setCommentsLength] = useState();

  // 토큰 및 보드
  useEffect(() => {
    axios
      .get("/board/followList", {
        headers: {
          "Content-Type": "application/json",
          Authorization: "Bearer " + localStorage.getItem("JWT"),
        },
      })
      .then((res) => {
        console.log(res.data);
        setContents(res.data);
      })
      .then((json) => alert(json));
  }, []);

  useEffect(() => {
    axios
      .get("http://localhost:8080/feed/show-comments", {
        headers: {
          "Content-Type": "application/json",
        },
        params: {
          feedId: contents.map((item) => item.feedId),
        },
      })
      .then((res) => setCommentsLength(res.data.content.length))
      .catch((e) => console.log(e));
  });

  return (
    <>
      <Header />
      <div className="container">
        <div className={styles.contentsGroup}>
          {contents.map((item) => (
            <Contents
              userId={item.userId}
              likeCnt={item.likeCnt}
              comments={commentsLength}
              mainText={item.mainText}
              key={item.feedId}
            />
          ))}
          <Contents
            userId={"userId"}
            likeCnt={12}
            comments={12}
            mainText={"texttexttexttexttexttexttexttexttexttexttexttext"}
          />
        </div>
      </div>
    </>
  );
}
