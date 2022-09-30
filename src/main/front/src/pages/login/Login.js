import React from 'react';
import styles from './Login.module.css'
import LoginForm from '../../components/Forms/AutoForm/LoginForm';
import MovingDog from '../../Animation/MovingDog/MovingDog';

const Login = () => {
    return (

        <main className={styles.wrapper}>
            <MovingDog className={styles.MovingDog} />
            <LoginForm />
            <div className={styles.logoContainer}>
            <h1 className={styles.Logo}>PETSTAGRAM</h1>
            </div>
        </main>

    );
};

export default Login;