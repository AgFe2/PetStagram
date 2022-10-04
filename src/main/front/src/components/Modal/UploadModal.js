import React, { useState } from "react";
import axios from "axios";

import TextareaForm from "../Forms/TextareaForm";

import styles from "../../styles/UploadModal.module.css";
import ImgForm from "../Forms/ImgForm";

function UploadModal(props) {
  const { handleCloseUpload } = props;

  // 업로드 이미지 읽기, 파일 저장
  const [imgSrc, setImgSrc] = useState(""); // 이미지 미리보기용
  const [imgFile, setImgFile] = useState(null); // 파일

  const handleChangeFile = (e) => {
    const file = e.target.files[0];
    console.log("file");
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
  const submitImg = async (e) => {
    e.preventDefault();
    if (imgFile == null) {
      alert("이미지를 등록해주세요");
      return false; // 정상작동
    }
    const fd = new FormData();
    fd.append("file", imgFile);

    console.log("fd");
    console.log(fd);

    await axios
      .post("http://localhost:8080/file/upload", fd, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      })
      .then((response) => {
        if (response.data) {
          console.log(response.data);
          // history.push("/test1");
        }
      })
      .catch((error) => {
        console.log(error);
        console.log("에러");
      });

    setNextClick(true);
  };

  const [nextClick, setNextClick] = useState(false);

  /*
  file/upload 따로 있으니까 컴포넌트를 분리해서
  <form imgForm> 먼저 서브밋 하고</form> -> .post("file/upload")
  서브밋 이벤트에 textareaForm 나오게끔 설정해서
  그 <form textareaForm> 서브밋 </form> -> .post("feed/write")
  해서 최종적으로 완료?
  
  !! 둘 다 모두 userID 같이 보내줘야함 : 
  uploadModal URL에 hitsory로 params 심어주면 되지 않을까
  */

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
        <div
          className={`${styles.main} ${
            nextClick ? `${styles.formActive}` : ""
          }`}
        >
          {nextClick ? (
            <>
              <ImgForm
                handleChangeFile={handleChangeFile}
                imgSrc={imgSrc}
                submitImg={submitImg}
                nextClick={nextClick}
              />
              <TextareaForm />
            </>
          ) : (
            <ImgForm
              handleChangeFile={handleChangeFile}
              imgSrc={imgSrc}
              submitImg={submitImg}
            />
          )}
        </div>
      </div>
    </div>
  );
}
export default UploadModal;
