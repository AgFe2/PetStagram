import React from 'react';
import Button from '../../Button/Button';
import styles from './AuthForm.module.css'
import { Link, useNavigate } from 'react-router-dom';
import { Formik, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup'
import axios from 'axios';


const LoginForm = () => {
    const navigate = useNavigate();

    const LoginValidSchema = Yup.object().shape({
        email: Yup.string()
            .email().required('이메일을 입력하세요'),
        password1: Yup.string()
            .required('비밀번호를 채워주세요'),
    })



    const handleSubmit = async (values,{ setSubmitting }) => {
    
        const data = {
            email : values.email,
            password1:values.password1
        }
        try{
            await axios.post('/member/login',
                JSON.stringify(data),
                {headers:{'Content-Type':'application/json'}}
            ).then(response =>{
                axios.defaults.headers.common[
                    "Authorization"
                ] = `Bearer ${response.data.accessToken}`;
                return response.data
            })
            .then(
                (token) => {
                    localStorage.setItem("JWT", token.accessToken)
                    alert('로그인되었습니다.')
                }
            )
            setTimeout(() =>{
                navigate('/my')
            },2000)
        }
        catch(e){
            console.log(e.response.data);
            alert('아이디가 존재하지않습니다.')
            setSubmitting(true);
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
                        <span>{errors.email}</span>
                        <input
                            className={styles.input}
                            type="password"
                            id='password'
                            name='password1'
                            placeholder="패스워드를 입력하세요"
                            value={values.password}
                            onChange={handleChange}
                        />
                        <span>{errors.password1}</span>
                        <Button className={styles.button}  disabled ={isSubmitting || !isValid}type="submit">로그인</Button>
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