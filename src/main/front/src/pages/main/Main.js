
import React, { useEffect, useState } from "react";
import Contents from "../../components/Contents/Contents";
import styles from "../../styles/Contents.module.css";
import mock from '../../data/feed.json'




export default function Main() {

  // useEffect(()=>{
  //   axios.get('/data/mock_feed.json')
  //   .then((res) =>res.json())
  //   .then((res) =>{
  //     console.log(res +'success');
  //     setState({
  //       data:res.data
  //     })
  //     console.log(res)
  //   })
  // })
  

  const contentsItem = mock.map((data,idx) => (
    <Contents
      userId={data.feed_id}
      liked={data.total_like_number}
      comments={data.comment.length}
      key={idx}
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
