import React, { useState } from "react";
import styles from "../../styles/Gallery.module.css";
import ContentModal from "../Modal/ContentModal";

export default function GalleryItem({ imagepath, postcomment }) {
  const [openDetail, setOpenDetail] = useState(false);
  const handleOpenDetail = () => {
    setOpenDetail(true);
  };

  return (
    <div>
      <img
        className={styles.postImg}
        onClick={handleOpenDetail}
        src={imagepath}
        alt="갤러리 사진"
        role="button"
      />
      {openDetail === true ? (
        <ContentModal
          imgpath={imagepath}
          postcomment={postcomment}
          setOpenDetail={setOpenDetail}
        />
      ) : null}
    </div>
  );
}

GalleryItem.defaultProps = {
  imagepath: "/images/dog.jpeg",
};
