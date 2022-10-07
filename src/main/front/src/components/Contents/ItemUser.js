import React from "react";

import styles from "../../styles/ItemUser.module.css";

function ItemUser(props) {
  // const { userProfileImg } = props;
  return (
    <div className={styles.itemUser}>
      <img className={styles.pic} src={""} alt="사용자 이미지" />
      <h4 className={styles.userName}>{props.userId}</h4>
    </div>
  );
}

export default ItemUser;
