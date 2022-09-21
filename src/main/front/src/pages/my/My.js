import React from "react";
import Header from "../../components/Header";

function My(props) {
  return (
    <>
      <Header />
      <div>
        <div>
          <img
            src=""
            alt=""
            style={{
              backgroundColor: "lightblue",
              borderRadius: "50%",
              width: "200",
              height: "200",
              overflow: "hidden",
            }}
          />
          <div>
            <h3>UserName</h3>
            <ul>
              <li style={{ display: "inline-block" }}>
                <span style={{ fontWeight: "bold" }}>99</span> post
              </li>
              <li style={{ display: "inline-block" }}>
                <span style={{ fontWeight: "bold" }}>99</span> follow
              </li>
              <li style={{ display: "inline-block" }}>
                <span style={{ fontWeight: "bold" }}>99</span> follower
              </li>
            </ul>
            <p>
              <h4>Name</h4>
              <span>bio, description</span>
            </p>
          </div>
        </div>
      </div>
    </>
  );
}

export default My;
