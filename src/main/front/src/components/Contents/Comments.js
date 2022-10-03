import axios from "axios";
import React, { useEffect, useState } from "react";

import styles from "../../styles/Comments.module.css";
import ItemUser from "../../styles/ItemUser.module.css";
import { useQuery } from 'react-query'
import { useParams } from "react-router-dom";

function Comments(props){


  const [comments,setComments] = useState([{ email:'',context:'',createdAt:'' }])

  useEffect(()=>{
    async function getComment(){
      await axios.get('http://localhost:8080/feed/show-comments',
        {
         headers: {
           'Content-Type': 'application/json',
           'Authorization': 'Bearer' + localStorage.getItem('JWT')
         },
         params:{
            feedId:props.feedId
         }
       })
       .then((res) => setComments(res.data.content))
       .catch((e) => console.log(e))
      }
      getComment();
  },[comments.context])

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
      <span className={styles.time}>{comment.createdAt[0]}</span>
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
