import React, { useState } from "react";
import axios from "axios";

import ItemUser from "../Contents/ItemUser";

import styles from "../../styles/UploadModal.module.css";

function UploadModal(props) {
  const { handleCloseUpload } = props;

  // 업로드 이미지 읽기
  const [imgSrc, setImgSrc] = useState(""); // 이미지 미리보기용
  const [imgFile, setImgFile] = useState(null); // 파일

  const handleChangeFile = (e) => {
    const file = e.target.files[0];
    console.log(file);
    setImgFile(file);

    const reader = new FileReader();
    reader.readAsDataURL(file);

    return new Promise((resolve) => {
      reader.onload = () => {
        setImgSrc(reader.result);
        resolve();
      };
    });
  };

  // WriteFeed
  const WriteFeed = async () => {
    const fd = new FormData();
    fd.append("file", file);
    fd.append("text", text);

    await axios
      .post("feed/write", fd, {
        headers: {
          "Content-Type": `mulipart/form-data`,
        },
      })
      .then((response) => {
        if (response.data) {
          console.log(response.data);
          history.push("/test1");
        }
      })
      .catch((error) => {
        console.log(error);
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
        </div>
        <div className={styles.main}>
          <form className={styles.form}>
            <div className={styles.imgWrapper}>
              <input
                type="file"
                name="img"
                accept="image/*"
                id="image"
                onChange={handleChangeFile}
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
            <button
              type="submit"
              className={styles.shareBtn}
              onClick={WriteFeed}
            >
              share
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default UploadModal;
