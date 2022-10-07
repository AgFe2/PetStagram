import React from "react";
import Button from "../../Button/Button"
import styles from "./AuthForm.module.css";


const Logout = () => {
    const logOut = () =>
    {localStorage.removeItem('JWT')}
    return (
        <Button className={styles.logoutBtn} onClick={logOut}>
            로그아웃
        </Button>
    );
};

export default Logout;