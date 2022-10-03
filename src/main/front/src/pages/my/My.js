import React, { useState, useEffect } from "react";
import axios from "axios";

import Header from "../../components/Header/Header";
import Info from "../../components/Info/Info";
import Gallery from "../../components/post/Gallery";

function My() {
  const [gallery, setGallery] = useState([]);

  useEffect(() => {
    axios
      .get("/board/myList", {
        headers: {
          "Content-Type": "application/json",
          Authorization: "Bearer " + localStorage.getItem("JWT"),
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
      <Info />
      <Gallery data={gallery} />
    </>
  );
}

export default My;
