import React from "react";
import "../../styles/mainContent.css";

export default function MainContent(props) {
  function clickedLike() {
    console.log(props.liked);
  }
  return (
    <>
      {/* array.map(item => ( <li> ... </li>))
      몇 개 load할지 정한 뒤, 그 이상 스크롤할 경우 게시글 추가업로드 */}
      <div className="contents-item">
        <div className="item-user">
          <div className="user-profile" />
          <h4 className="user-name">{props.userId}</h4>
        </div>
        <div>
          <img
            src=""
            alt=""
            style={{ backgroundColor: "pink", border: "none" }}
            height="500px"
            width="500px"
          />
        </div>
        <div className="item-info">
          <div className="info-liked">
            <button onClick={clickedLike}>하트</button>
            <p style={{ fontWeight: "bold" }}>{props.liked} liked</p>
          </div>
          <div className="info-paragraph">
            <h4 className="paragraph-name">{props.userId}</h4>
            <p className="paragraph-desc">
              description <span>...더보기</span>
            </p>
          </div>
          <p className="all-comments">{props.comments} view all comments</p>
        </div>
      </div>
    </>
  );
}
