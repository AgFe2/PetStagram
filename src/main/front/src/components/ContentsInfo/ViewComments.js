import React, { useState } from "react";

import ContentModal from "../Modal/ContentModal";

import styles from "../../styles/Contents.module.css";

function ViewComments(props) {
  const [openDetail, setOpenDetail] = useState(false);
  const handleOpenDetail = () => {
    setOpenDetail(true);
  };

  return (
    <>
      <button className={styles.allComments} onClick={handleOpenDetail}>
        {props.comments} view all comments
      </button>
      {openDetail === true ? (
        <ContentModal setOpenDetail={setOpenDetail} feedId={props.feedId} />
      ) : null}
    </>
  );
}

export default ViewComments;
