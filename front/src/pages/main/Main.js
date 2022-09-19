import React from "react";
import Header from "../../components/Header";

import MainContent from "./MainContent";
import "../../styles/mainContent.css";

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
    <MainContent
      userId={data.userId}
      liked={data.liked}
      comments={data.comments}
    ></MainContent>
  ));
  return (
    <>
      <Header />
      <div className="container">
        <div className="contents-group">
          <div>{contentsItem}</div>
        </div>
      </div>
    </>
  );
}
