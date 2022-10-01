import React, { useState, useEffect } from "react";
import axios from "axios";

import Header from "../../components/Header/Header";
import Info from "../../components/Info/Info";
import Gallery from "../../components/post/Gallery";

import styles from "../../styles/My.module.css";

function My() {
  const [gallery, setGallery] = useState([]);

  useEffect(() => {
    axios
      .get("/board/myList")
      .then((res) => {
        console.log(res.data);
        setGallery(res.data);
      })
      .catch((err) => console.log(err));
  });
  return (
    <>
      <Header />
      <Info />
      <Gallery data={gallery} />
    </>
  );
}

export default My;
