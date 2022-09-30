import React from "react";
import { Link } from "react-router-dom";

import styles from "../../styles/Header.module.css";

function ProfileModal(props) {
  return (
    <>
      <ul className={styles.profileDepth}>
        <li className={styles.depthItem}>
          <Link to={"/userId"} className={styles.detphLink}>
            프로필
          </Link>
        </li>
        <li className={styles.depthItem} onClick={(e) => e.stopPropagation()}>
          설정
        </li>
        <li
          className={`${styles.depthItem} ${styles.depthLogout}`}
          onClick={(e) => e.stopPropagation()}
        >
          로그아웃
        </li>
      </ul>
    </>
  );
}

export default ProfileModal;
