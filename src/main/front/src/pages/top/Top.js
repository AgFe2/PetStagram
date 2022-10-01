import React, { useState, useEffect } from "react";
import axios from "axios";

import Header from "../../components/Header/Header";
import Gallery from "../../components/post/Gallery";

import styles from "../../styles/Top.module.css";

function Top(props) {
  const [gallery, setGallery] = useState([]);

  useEffect(() => {
    axios
      .get("/board/bestList")
      .then((res) => {
        console.log(res.data);
        setGallery(res.data);
      })
      .catch((err) => console.log(err));
  });

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
