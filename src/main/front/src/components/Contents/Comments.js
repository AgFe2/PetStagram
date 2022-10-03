import axios from "axios";
import React, { useEffect, useState } from "react";

import comments from "../../styles/Comments.module.css";
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
  },[])

console.log(comments)

const commentArray = comments.map((comment) =>{
    <li className={comments.item} key={comment.commentId}>
    <div className={`${ItemUser.pic} ${comments.pic}`}></div>
    <div className={comments.main}>
      <span className={`${ItemUser.userName} ${comments.userName}`}>
        {comment.email}
      </span>
      <span className={comments.text}>{comment.context}</span>
    </div>
  </li>
  })

  return (
    <>
      <ul className={comments.group}>
      {commentArray}
      </ul>
          </>
        );
      }
//       { comments.map((comment) => {
//        <li className={comments.item}>
//          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
//          <div className={comments.main}>
//            <span className={`${ItemUser.userName} ${comments.userName}`}>
//              {comment.email}
//            </span>
//            <span className={comments.text}>{comment.context}</span>
//          </div>
//        </li>
//       })
//        }
//      </ul>


//function Comments(){
//  const FEED_ID = useParams();
//  const [board,setBoard] = useState({})
//  const [isLoded, setIsLoded] = useState(false)
//
//const getComment = async () =>{
//    await axios.get('http://localhost:8080/feed/show-comments',
//    {
//       headers: {
//         'Content-Type': 'application/json',
//         'Authorization': 'Bearer' + localStorage.getItem('JWT')
//       },
//             params: {
//                               feedId: 1
//                             }
//     })
//     .then(res => setBoard(res.data.content))
//  }
//
//
//  useEffect( ()=>{
//    getComment()
//  },[])
//
////const commentArray = JSON.parse(board)
//
////  console.log(commentArray)
//  console.log(board[0])
//
//
//
//
//  return (
//    <>
//      <ul className={comments.group}>
//        <li className={comments.item}>
//          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
//          <div className={comments.main}>
//            <span className={`${ItemUser.userName} ${comments.userName}`}>
//              userName
//            </span>
//            <span className={comments.text}>abcdefghijk</span>
//          </div>
//        </li>
//      </ul>
//    </>
//  );
//}

export default Comments;
