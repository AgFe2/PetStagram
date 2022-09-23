import React from "react";

import Contents from "../../components/Contents/Contents";
import styles from "../../styles/Contents.module.css";
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

  const contentsItem = datas.map((data) => (
    <Contents
      userId={data.feed_id}
      liked={data.total_like_number}
      comments={data.comment.length}
    />
  ));

  return (
    <>
      <div className="container">
        <div className={styles.contentsGroup}>
          <div>{contentsItem}</div>
        </div>
      </div>
    </>
  );
}
