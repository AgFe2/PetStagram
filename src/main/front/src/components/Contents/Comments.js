import React from "react";

import comments from "../../styles/Comments.module.css";
import ItemUser from "../../styles/ItemUser.module.css";

function Comments(props) {
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
        <li className={comments.item}>
          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
          <div className={comments.main}>
            <span className={`${ItemUser.userName} ${comments.userName}`}>
              userName
            </span>
            <span className={comments.text}>abcdefghijk</span>
          </div>
        </li>
        <li className={comments.item}>
          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
          <div className={comments.main}>
            <span className={`${ItemUser.userName} ${comments.userName}`}>
              userName
            </span>
            <span className={comments.text}>abcdefghijk</span>
          </div>
        </li>
        <li className={comments.item}>
          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
          <div className={comments.main}>
            <span className={`${ItemUser.userName} ${comments.userName}`}>
              userName
            </span>
            <span className={comments.text}>abcdefghijk</span>
          </div>
        </li>
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
