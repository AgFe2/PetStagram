import React from "react";

import styles from "../../styles/ItemUser.module.css";

function ItemUser(props) {
  return (
    <div className={styles.itemUser}>
      <div className={styles.pic} />
      <h4 className={styles.userName}>{props.userId}</h4>
    </div>
  );
}

export default ItemUser;
