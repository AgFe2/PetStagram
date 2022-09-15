import React from "react";
import Header from "../../components/Header";
import Contents from "../../components/Contents";
import "../../styles/etcContent.css";

function Top(props) {
  return (
    <>
      <Header />
      <div className="top-contents-group container">
        <Contents />
        <Contents />
        <Contents />
        <Contents />
      </div>
    </>
  );
}

export default Top;
