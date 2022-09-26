import React from 'react';
import Button from '../../Button/Button';
import styles from './AuthForm.module.css'
import { Link, useNavigate } from 'react-router-dom';
import { Formik, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup'
import { API } from '../../../utils/api';
import axios from 'axios';
import { BASE_URL } from '../../../utils/api';

const LoginForm = () => {
    const navigate = useNavigate();
    const VALIDATE_TEXT = '빈칸이 없게 입력하세요'

    const LoginValidSchema = Yup.object().shape({
        email: Yup.string()
            .email().required(VALIDATE_TEXT.require),
        password: Yup.string()
            .required(VALIDATE_TEXT.require),
    })



    const handleSubmit = async (values,{ setSubmitting }) => {
    
        const data = {
            email : values.email,
            password:values.password
        }
        try{
            await API.post('/member/login',
                JSON.stringify(data),
            ).then(response =>{
                response.json()
                console.log('login')
                console.log(response)
                console.log(values.email)
            }).then(
                (token) => {
                    localStorage.setItem("JWT", token.accessToken)
                    alert('로그인되었습니다.')
                }
            )
            setTimeout(() =>{
                navigate('/home')
            },2000)
        }
        catch(e){
            console.log(e);
            setSubmitting(true)
        }
    }

    return (
        <Formik
            initialValues={
                {
                    email: '',
                    password: ''
                }
            }
            validationSchema={LoginValidSchema}
            onSubmit={handleSubmit}
        >
            {({ values, handleChange, errors,isSubmitting,isValid }) => (
              
                <section className={styles.Container}>
                    <h1 className={styles.title}>LOGIN</h1>
                    <Form className={styles.authForm}>
                        <input
                            className={styles.input}
                            type="text"
                            id='email'
                            name='email'
                            placeholder="이메일을 입력하세요"
                            value={values.email}
                            onChange={handleChange}
                        />

                        <input
                            className={styles.input}
                            type="password"
                            id='password'
                            name='password'
                            placeholder="패스워드를 입력하세요"
                            value={values.password}
                            onChange={handleChange}
                        />

                        <Button disabled ={isSubmitting || !isValid}type="submit">로그인</Button>
                        <div className={styles.signUp}>
                            <h4>아직도 회원이 아니신가요? &nbsp;</h4>
                            <Link to="/register"><span>Sign Up</span></Link>
                        </div>
                    </Form>
                </section>
            )}
        </Formik>
    );
};

export default LoginForm;