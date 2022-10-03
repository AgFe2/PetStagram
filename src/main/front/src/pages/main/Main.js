import React, { useEffect, useState } from "react";

import Header from "../../components/Header/Header";
import Contents from "../../components/Contents/Contents";
import styles from "../../styles/Contents.module.css";
import axios from "axios";
export default function Main() {
  // const datas = [
  //   {
  //     feed_id: "user01",
  //     total_like_number: 13,
  //     comment: [
  //       {
  //         comment_id: "user99",
  //         comment_feed_id: "user01",
  //         comment_context: "blahbalh",
  //         commented_date: "20220921",
  //         comment_writer: "user99",
  //       },
  //       {
  //         comment_id: "user99",
  //         comment_feed_id: "user01",
  //         comment_context: "blahbalh",
  //         commented_date: "20220921",
  //         comment_writer: "user99",
  //       },
  //       {
  //         comment_id: "user99",
  //         comment_feed_id: "user01",
  //         comment_context: "blahbalh",
  //         commented_date: "20220921",
  //         comment_writer: "user99",
  //       },
  //     ],
  //   },
  //   {
  //     feed_id: "user02",
  //     total_like_number: 75,
  //     comment: [
  //       {
  //         comment_id: "user99",
  //         comment_feed_id: "user01",
  //         comment_context: "blahbalh",
  //         commented_date: "20220921",
  //         comment_writer: "user99",
  //       },
  //       {
  //         comment_id: "user99",
  //         comment_feed_id: "user01",
  //         comment_context: "blahbalh",
  //         commented_date: "20220921",
  //         comment_writer: "user99",
  //       },
  //     ],
  //   },
  //   {
  //     feed_id: "user03",
  //     total_like_number: 564,
  //     comment: [
  //       {
  //         comment_id: "user99",
  //         comment_feed_id: "user01",
  //         comment_context: "blahbalh",
  //         commented_date: "20220921",
  //         comment_writer: "user99",
  //       },
  //       {
  //         comment_id: "user99",
  //         comment_feed_id: "user01",
  //         comment_context: "blahbalh",
  //         commented_date: "20220921",
  //         comment_writer: "user99",
  //       },
  //       {
  //         comment_id: "user99",
  //         comment_feed_id: "user01",
  //         comment_context: "blahbalh",
  //         commented_date: "20220921",
  //         comment_writer: "user99",
  //       },
  //       {
  //         comment_id: "user99",
  //         comment_feed_id: "user01",
  //         comment_context: "blahbalh",
  //         commented_date: "20220921",
  //         comment_writer: "user99",
  //       },
  //     ],
  //   },
  // ];

  const [contents, setContents] = useState([]);

  // useEffect(() => {
  //   axios
  //     .get("/board/followList")
  //     .then((res) => {
  //       console.log(res.data);
  //       setContents(res.data);
  //     })
  //     .catch((err) => console.log(err));

  // });

  // 토큰
  useEffect(() => {
    axios
      .get("/board/followList", {
        headers: {
          "Content-Type": "application/json",
          Authorization: "Bearer " + localStorage.getItem("JWT"),
        },
      })
      .then((res) => {
        console.log("res.data");
        console.log(res.data);
      })
      .then((json) => alert(json));
  }, []);

  // comments 갯수는 feedId를 통해서 comment에서 가져와야함.......
  return (
    <>
      <Header />
      <div className="container">
        <div className={styles.contentsGroup}>
          {contents.map((item) => (
            <Contents
              userId={item.userId}
              liked={item.likeCnt}
              comments={item.comment.length}
              key={item.feedId}
            />
          ))}
        </div>
      </div>
    </>
  );
}
