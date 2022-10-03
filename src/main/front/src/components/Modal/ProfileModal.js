import React from "react";
import axios from "axios";
import { Link, Navigate } from "react-router-dom";

import styles from "../../styles/Header.module.css";

function ProfileModal(props) {
  const handlerLogOut = () => {
    axios.get(`/api/users/logout`).then((response) => {
      if (response.data.success) {
        Navigate("/login");
      } else {
        alert("로그아웃에 실패했습니다.");
      }
    });
  };
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
          onClick={handlerLogOut}
        >
          로그아웃
        </li>
      </ul>
    </>
  );
}

export default ProfileModal;
