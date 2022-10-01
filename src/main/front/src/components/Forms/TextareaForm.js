import React, { useState } from "react";

import ItemUser from "../../components/Contents/ItemUser";
import styles from "../../styles/UploadModal.module.css";

function TextareaForm(props) {
  // textarea
  const [textarea, setTextarea] = useState("");
  const handleTextareaValue = (e) => {
    setTextarea(e.target.value);
    console.log(e.target.value);
  };
  return (
    <form className={styles.textform}>
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
