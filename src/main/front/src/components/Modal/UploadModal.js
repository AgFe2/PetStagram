import React, { useEffect, useState, uesRef } from "react";
import axios from "axios";

import ItemUser from "../Contents/ItemUser";

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

  // 이미지 서버로 전송 : 최종으로 컨텐츠 등록하는 버튼에 심어주기
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

  // 이미지 미리보기
  useEffect(() => {
    preview();

    return () => preview();
  });

  const preview = () => {
    if (!files) return false;

    const imgEL = document.querySelector(`.imgBox`);

    const reader = new FileReader();

    reader.onload = () =>
      (imgEL.style.backgroundImage = `url(${reader.result})`);

    reader.readAsDataURL(files[0]);
  };

  const StyleImgBox = {
    width: "100%",
    height: "auto",
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
          <h4 className={styles.title}>create and post</h4>
          <button type="submit" className={styles.shareBtn}>
            share
          </button>
        </div>
        <div className={styles.main}>
          <div className={styles.imgWrapper}>
            <div className={styles.customImg}>
              <strong>업로드된 이미지</strong>
              <div className="imgBox" style={StyleImgBox} />
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
          <div className={styles.infoWrapper}>
            <ItemUser userId={"user01"} />
            <input
              type="textarea"
              placeholder="본문 작성 부문"
              className={styles.infoTxt}
            ></input>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UploadModal;
