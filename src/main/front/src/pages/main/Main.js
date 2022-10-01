import React, { useEffect } from "react";

import Header from "../../components/Header/Header";
import Contents from "../../components/Contents/Contents";
import styles from "../../styles/Contents.module.css";
import axios from "axios";
export default function Main() {
  const datas = [
    {
      feed_id: "user01",
      total_like_number: 13,
      comment: [
        {
          comment_id: "user99",
          comment_feed_id: "user01",
          comment_context: "blahbalh",
          commented_date: "20220921",
          comment_writer: "user99",
        },
        {
          comment_id: "user99",
          comment_feed_id: "user01",
          comment_context: "blahbalh",
          commented_date: "20220921",
          comment_writer: "user99",
        },
        {
          comment_id: "user99",
          comment_feed_id: "user01",
          comment_context: "blahbalh",
          commented_date: "20220921",
          comment_writer: "user99",
        },
      ],
    },
    {
      feed_id: "user02",
      total_like_number: 75,
      comment: [
        {
          comment_id: "user99",
          comment_feed_id: "user01",
          comment_context: "blahbalh",
          commented_date: "20220921",
          comment_writer: "user99",
        },
        {
          comment_id: "user99",
          comment_feed_id: "user01",
          comment_context: "blahbalh",
          commented_date: "20220921",
          comment_writer: "user99",
        },
      ],
    },
    {
      feed_id: "user03",
      total_like_number: 564,
      comment: [
        {
          comment_id: "user99",
          comment_feed_id: "user01",
          comment_context: "blahbalh",
          commented_date: "20220921",
          comment_writer: "user99",
        },
        {
          comment_id: "user99",
          comment_feed_id: "user01",
          comment_context: "blahbalh",
          commented_date: "20220921",
          comment_writer: "user99",
        },
        {
          comment_id: "user99",
          comment_feed_id: "user01",
          comment_context: "blahbalh",
          commented_date: "20220921",
          comment_writer: "user99",
        },
        {
          comment_id: "user99",
          comment_feed_id: "user01",
          comment_context: "blahbalh",
          commented_date: "20220921",
          comment_writer: "user99",
        },
      ],
    },
  ];

  // const [contents, setContens] = useState([]);

  // useEffect(() => {
  //   axios
  //     .get("/board/followList")
  //     .then((res) => {
  //       console.log(res.data);
  //       setContens(res.data);
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
      .then((res) => console.log(res))
      .then((json) => alert(json));
  }, []);

  return (
    <>
      <Header />
      <div className="container">
        <div className={styles.contentsGroup}>
          {datas.map((data) => (
            <Contents
              userId={data.feed_id}
              liked={data.total_like_number}
              comments={data.comment.length}
              key={data.feed_id}
            />
          ))}
        </div>
      </div>
    </>
  );
}
