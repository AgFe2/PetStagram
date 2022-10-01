import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

import styles from "../../styles/Gallery.module.css";

import GalleryItem from "./GalleryItem";

export default function Gallery(props) {
  const navigate = useNavigate();
  const { data } = props;

  const [imgSrc, setImgSrc] = useState();
  axios
    .get("file/list", { params: { userId: data.userID } })
    .then((res) => {
      console.log(res.data);
      setImgSrc(res.data.imgSrc);
    })
    .catch((err) => console.log(err));
  return (
    <section className={styles.postContainer}>
      <div className={styles.postlist}>
        {data.length > 1 ? (
          data.map((item, idx) => (
            <GalleryItem
              imagepath={imgSrc}
              postcomment={item.postcomment}
              key={idx}
            ></GalleryItem>
          ))
        ) : (
          <div>No Post</div>
        )}
      </div>
    </section>
  );
}
