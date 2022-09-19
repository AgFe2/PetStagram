import React from "react";
import { Link } from "react-router-dom";
import "../styles/header.css";
export default function Header() {
  function inputSubmit(e) {
    console.log(e.target.value);
  }
  return (
    <header>
      <div className="container">
        <div className="header">
          <h1 className="sr-only">PetStagram</h1>
          <div className="search-bar">
            <input
              type="text"
              placeholder="검색"
              onSubmit={inputSubmit}
            ></input>
            {/* <button>검색</button> */}
            {/* input value를 저장해서 searchPage로 이동해도 나오게끔,
            input type="submit" 넣으면 에러뜨는데 이유 찾기 */}
          </div>
          <nav>
            <Link to="/">home</Link>
            <Link to="/top">top</Link>
            <div>upload</div>
            <Link to="/userId">myPage</Link>
            {/* 인스타그램처럼 depth2로 만들어야 할 듯
                설정 변경(닉네임 등), 로그아웃 ... */}
          </nav>
        </div>
      </div>
    </header>
  );
}
