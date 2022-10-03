import axios from "axios";
import React, { useEffect, useState } from "react";

import styles from "../../styles/Comments.module.css";
import ItemUser from "../../styles/ItemUser.module.css";
import { useQuery } from 'react-query'
import { useParams } from "react-router-dom";

function Comments(){
  const [comments,setComments] = useState([])

  const getComment = async () =>{
    await axios.get('http://localhost:8080/feed/show-comments',
      {
       headers: {
         'Content-Type': 'application/json',
         'Authorization': 'Bearer' + localStorage.getItem('JWT')
       },
       params:{
          feedId:1
       }
     })
     .then((res) => setComments(res.data.content))
     .catch((e) => console.log(e))
    }

  useEffect( ()=>{
    getComment()
  },[comments])

console.log(comments)

const commentArray = comments.map((comment) =>{
    return (
    <li className={styles.item} key={comment.commentId}>
    <div className={`${ItemUser.pic} ${styles.pic}`}></div>
    <div className={styles.main}>
      <span className={`${ItemUser.userName} ${styles.userName}`}>
        {comment.email}
      </span>
      <span className={styles.text}>{comment.context}</span>
    </div>
  </li>
  )
  })

  return (
    <>
      <ul className={comments.group}>
        <h1>hellod</h1>
      {commentArray}
      </ul>
          </>
        );
      }


export default Comments;
