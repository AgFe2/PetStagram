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
            <sapn className={comments.text}>abcdefghijk</sapn>
          </div>
        </li>
        <li className={comments.item}>
          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
          <div className={comments.main}>
            <span className={`${ItemUser.userName} ${comments.userName}`}>
              userName
            </span>
            <sapn className={comments.text}>abcdefghijk</sapn>
          </div>
        </li>
        <li className={comments.item}>
          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
          <div className={comments.main}>
            <span className={`${ItemUser.userName} ${comments.userName}`}>
              userName
            </span>
            <sapn className={comments.text}>abcdefghijk</sapn>
          </div>
        </li>
        <li className={comments.item}>
          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
          <div className={comments.main}>
            <span className={`${ItemUser.userName} ${comments.userName}`}>
              userName
            </span>
            <sapn className={comments.text}>abcdefghijk</sapn>
          </div>
        </li>
        <li className={comments.item}>
          <div className={`${ItemUser.pic} ${comments.pic}`}></div>
          <div className={comments.main}>
            <span className={`${ItemUser.userName} ${comments.userName}`}>
              userName
            </span>
            <sapn className={comments.text}>abcdefghijk</sapn>
          </div>
        </li>
      </ul>
    </>
  );
}

export default Comments;
