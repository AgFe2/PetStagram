import styles from './Button.module.css'
import React from 'react';

const Button = ({children,type,onClick,className}) => {
    return (
        <button className={className} type={type} onClick={onClick} >{children}</button>
    );
};

export default Button;

