import axios from "axios";
import React, { useEffect, useState } from "react";

import comments from "../../styles/Comments.module.css";
import ItemUser from "../../styles/ItemUser.module.css";
import { useQuery } from 'react-query'
import { useParams } from "react-router-dom";

function Comments(){
  const FEED_ID = useParams();
  const [board,setBoard] = useState({})
  const [isLoded, setIsLoded] = useState(false)
  
const getComment = async () =>{
    await axios.get('http://localhost:8080/feed/show-comments',
    {
       headers: {
         'Content-Type': 'application/json',
         'Authorization': 'Bearer' + localStorage.getItem('JWT')
       },
             params: {
                               feedId: 1
                             }
     })
     .then(res => console.log(res))
  }



  useEffect( ()=>{
    getComment()
  },[])

  



  return (
    <>
      <ul className={comments.group}>
        <li className={comments.item}>
          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
          <div className={comments.main}>
            <span className={`${ItemUser.userName} ${comments.userName}`}>
              userName
            </span>
            <span className={comments.text}>abcdefghijk</span>
          </div>
        </li>
      </ul>
    </>
  );
}

export default Comments;
