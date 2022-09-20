import React from "react";
import Header from "../../components/Header";

import Contents from "../../components/Contents";
import styles from "../../styles/Contents.module.css";
export default function Main() {
  const datas = [
    {
      userId: "user01",
      liked: 13,
      comments: "23",
    },
    {
      userId: "user02",
      liked: "64",
      comments: "189",
    },
    {
      userId: "user03",
      liked: "87",
      comments: "65",
    },
  ];

  const contentsItem = datas.map((data) => (
    <Contents
      userId={data.userId}
      liked={data.liked}
      comments={data.comments}
    ></Contents>
  ));

  return (
    <>
      <Header />
      <div className="container">
        <div className={styles.contentsGroup}>
          <div>{contentsItem}</div>
        </div>
      </div>
    </>
  );
}
