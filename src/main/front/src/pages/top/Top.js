import React, { useState, useEffect } from "react";
import axios from "axios";

import Header from "../../components/Header/Header";
import Gallery from "../../components/post/Gallery";

import styles from "../../styles/Top.module.css";

function Top(props) {
  const [gallery, setGallery] = useState([]);

  useEffect(() => {
    axios
      .get("/board/bestList", {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((res) => {
        console.log(res.data);
        setGallery(res.data);
      })
      .then((json) => alert(json));
  }, []);

  return (
    <>
      <Header />
      <div className={styles.galleryWrap}>
        <Gallery data={gallery} />
      </div>
    </>
  );
}

export default Top;
