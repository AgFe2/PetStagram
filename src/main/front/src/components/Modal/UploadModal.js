import React, { useState } from "react";

import styles from "../../styles/UploadModal.module.css";

function UploadModal(props) {
  const { handleCloseUpload } = props;

  // 업로드 이미지 읽기
  const [files, setFiles] = useState("");
  const onLoadFile = (e) => {
    const file = e.target.files;
    console.log(file);
    setFiles(file);
  };

  // 이미지 전송
  const handleClick = (e) => {
    const formdata = new FormData();
    formdata.append("uploadImage", files[0]);

    const config = {
      Headers: {
        "content-type": "multipart/form-data",
      },
    };

    axios.post(`api`, formdata, config);
  };

  return (
    <div
      className={styles.bg}
      onClick={() => {
        handleCloseUpload();
      }}
    >
      <button className={styles.closeBtn} onClick={() => handleCloseUpload()}>
        ✖
      </button>
      <div className={styles.body} onClick={(e) => e.stopPropagation()}>
        <div className={styles.wrapper}>
          <div className={styles.customImg}>
            <strong>업로드된 이미지</strong>
            <div className={styles.imgWrap}>
              <img src="" alt="" />
            </div>
          </div>
          <form className={styles.form}>
            <input
              type="file"
              accept="image/*"
              id="image"
              onChange={onLoadFile}
            ></input>
            <label htmlFor="image"></label>
          </form>
        </div>
      </div>
    </div>
  );
}

export default UploadModal;
