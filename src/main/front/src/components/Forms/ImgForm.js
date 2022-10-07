import React, { useState } from "react";

import styles from "../../styles/UploadModal.module.css";
function ImgForm(props) {
  const { handleChangeFile, imgSrc, submitImg, nextClick } = props;

  return (
    <form
      className={`${styles.form} ${nextClick ? `${styles.formActive}` : ""}`}
      onSubmit={submitImg}
    >
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
      {nextClick ? null : (
        <button type="submit" className={styles.shareBtn}>
          next
        </button>
      )}
    </form>
  );
}

export default ImgForm;
