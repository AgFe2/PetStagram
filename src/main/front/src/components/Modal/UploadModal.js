import React, { useState } from "react";
// import axios from "axios";

import ItemUser from "../Contents/ItemUser";

import styles from "../../styles/UploadModal.module.css";

function UploadModal(props) {
  const { handleCloseUpload } = props;

  // 업로드 이미지 읽기
  // const [files, setFiles] = useState("");
  // const onLoadFile = (e) => {
  //   const file = e.target.files;
  //   console.log(file);
  //   setFiles(file);
  // };

  // 이미지 서버로 전송 : 최종으로 컨텐츠 등록하는 버튼에 심어주기
  // const handleClick = (e) => {
  //   const formdata = new FormData();
  //   formdata.append("uploadImage", files[0]);

  //   const config = {
  //     Headers: {
  //       "content-type": "multipart/form-data",
  //     },
  //   };

  //   axios.post(`api`, formdata, config);
  // };

  // 이미지 미리보기
  const [imgSrc, setImgSrc] = useState("");

  const encodeFileToBase64 = (fileBlob) => {
    const reader = new FileReader();
    reader.readAsDataURL(fileBlob);

    return new Promise((resolve) => {
      reader.onload = () => {
        setImgSrc(reader.result);
        resolve();
      };
    });
  };

  // textarea
  const [textarea, setTextarea] = useState("");
  const handleTextareaValue = (e) => {
    setTextarea(e.target.value);
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
        <div className={styles.top}>
          <h4 className={styles.title}>Create and Post</h4>
          <button type="submit" className={styles.shareBtn}>
            share
          </button>
        </div>
        <div className={styles.main}>
          <form className={styles.form}>
            <div className={styles.imgWrapper}>
              <input
                type="file"
                accept="image/*"
                id="image"
                onChange={(e) => {
                  encodeFileToBase64(e.target.files[0]);
                }}
              ></input>
              <label htmlFor="image" className="sr-only">
                image
              </label>
              <div className={styles.imgPreview}>
                {imgSrc && <img src={imgSrc} alt="preview-img"></img>}
              </div>
            </div>

            <div className={styles.infoWrapper}>
              <ItemUser userId={"user01"} />
              <input
                type="textarea"
                placeholder="본문 작성 부문"
                value={textarea}
                onChange={(e) => handleTextareaValue(e)}
                className={styles.infoTxt}
              ></input>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default UploadModal;
