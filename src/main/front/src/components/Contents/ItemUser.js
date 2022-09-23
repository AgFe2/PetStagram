import React from "react";

import styles from "../../styles/Contents.module.css";

function ItemUser(props) {
  return (
    <div className={styles.itemUser}>
      <div className={styles.userProfile} />
      <h4 className={styles.userName}>{props.userId}</h4>
    </div>
  );
}

export default ItemUser;
