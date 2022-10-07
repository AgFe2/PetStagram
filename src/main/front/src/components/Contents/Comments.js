import axios from "axios";
import React, { useEffect, useState } from "react";
import { useQuery } from "react-query";

import styles from "../../styles/Comments.module.css";
import ItemUser from "../../styles/ItemUser.module.css";
function Comments(props) {
  const [comments, setComments] = useState([
    { email: "", context: "", createdAt: "" },
  ]);
  
  useEffect(() => {
      async function getComment() {
        try{await axios
          .get("http://localhost:8080/feed/show-comments", {
            headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer" + localStorage.getItem("JWT"),
            },
            params: {
              feedId: 1,
            },
          })
          .then(
            (res) => {
              setComments(res.data.content)
            }
          )
        }
          catch(e){console.log(e)};
      }
      getComment()
  }, []);
  




  const commentArray = comments.map((comment) => {
    return (
      <li className={styles.item} key={comment.commentId}>
        <div className={`${ItemUser.pic} ${styles.pic}`}></div>
        <div className={styles.main}>
          <span className={`${ItemUser.userName} ${styles.userName}`}>
            {comment.email}
          </span>
          <span className={styles.text}>{comment.context}</span>
          {/* <span className={styles.time}>
            {comment.createdAt[0] + '년'
              + comment.createdAt[1] + '월'
              + comment.createdAt[2] + '일'
              + comment.createdAt[3] + '시'
              + comment.createdAt[4] + '분'}</span> */}
        </div>
      </li>
    );
  });

  return (
    <>
      <ul className={comments.group}>
        {commentArray}
      </ul>

    </>)
}

export default Comments;



