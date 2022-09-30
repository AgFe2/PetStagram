import React ,{useEffect} from "react";
import axios from "axios";

import Contents from "../../components/Contents/Contents";
import Header from "../../components/Header/Header";
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

useEffect(() => {
        axios.get('http://localhost:8080',{
            headers:{
              'Content-Type':'application/json',
              'Authorization': 'Bearer ' + localStorage.getItem("JWT"),
            }
          })
          .then(res => console.log(res))
          .then(json => console.log(json))
    })

  const contentsItem = datas.map((data) => (
    <Contents
      userId={data.feed_id}
      liked={data.total_like_number}
      comments={data.comment.length}
      key ={data.feed_id}
    />
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
