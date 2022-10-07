import React,{useState} from "react";
import axios from "axios";
import { Link, Navigate } from "react-router-dom";

import styles from "../../styles/Header.module.css";

function ProfileModal(props) {
  const [isLogin,setIsLogin] = useState(false)

  const handlerLogOut = () => {
    axios.get(`http://localhost:8080/member/sign-in`,{
          headers: {
            "Content-Type": "application/json",
            Authorization: "Bearer" + localStorage.getItem("JWT"),
          }}).then((response) => {
      if (response.data.success) {
        localStorage.removeItem('JWT')
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
