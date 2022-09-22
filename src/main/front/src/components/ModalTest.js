import React from "react";

import styles from "../styles/Header.module.css";

function ModalTest(props) {
  return (
    <>
      <ul className={styles.profileDepth}>
        <li className={styles.depthItem}>프로필</li>
        <li className={styles.depthItem}>설정</li>
        <li className={`${styles.depthItem} ${styles.depthLogout}`}>
          로그아웃
        </li>
      </ul>
    </>
  );
}

export default ModalTest;
