import styles from './Button.module.css'
import React from 'react';

const Button = ({children,type,onClick}) => {
    return (
        <button className={styles.button} type={type} onClick={onClick} >{children}</button>
    );
};

export default Button;

