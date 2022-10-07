import axios from "axios";
import React, { useState } from "react";

import ItemUser from "../../components/Contents/ItemUser";
import styles from "../../styles/UploadModal.module.css";

function TextareaForm(props) {
  // textarea
  const [textarea, setTextarea] = useState("");
  const handleTextareaValue = (e) => {
    setTextarea(e.target.value);
  };

  const submitTextarea = async (e) => {
    e.preventDefault();
    if (textarea.length === 0) {
      alert("텍스트를 작성하세요");
      return false;
    }

    const fd = new FormData();
    fd.append("textarea", textarea); // FormData 들어가는지 안들어가는지 test

    console.log("textarea fd");
    console.log(fd);

    await axios
      .post("http://localhost:8080/feed/write", fd, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      })
      .then((response) => {
        if (response.data) {
          console.log(response.data);
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <form className={styles.textform} onSubmit={submitTextarea}>
      <ItemUser userId={"user01"} />
      <textarea
        name="textarea"
        type="text"
        placeholder="본문 작성 부문"
        value={textarea}
        onChange={(e) => handleTextareaValue(e)}
        className={styles.textarea}
      ></textarea>
      <button type="submit" className={styles.shareBtn}>
        share
      </button>
    </form>
  );
}

export default TextareaForm;
