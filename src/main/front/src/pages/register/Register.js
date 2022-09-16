import React from 'react';
import styles from './Register.module.css'
import SignUpForm from '../../components/Forms/AutoForm/SignUpForm';
import { Smartphone } from '../../Animation/Smartphone/Smartphone';
const Register = () => {
    return (
        <main className={styles.wrap}>
            <Smartphone/>
            <div className={styles.logoContainer}>
            <h1 className={styles.Logo}>PET STAGRAM</h1>
            </div>
            <SignUpForm></SignUpForm>
        </main>
)}


export default Register;