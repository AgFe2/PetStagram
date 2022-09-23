import React from 'react';
import Button from '../../Button/Button';
import styles from './AuthForm.module.css'
import { Link, useNavigate } from 'react-router-dom';
import {API} from '../../../utils/api';
import axios from 'axios'
import { useQuery } from 'react-query';
import {  Formik, Form } from 'formik'
import * as Yup from 'yup'


const SignUpForm = () => {

    const validationSchema = Yup.object().shape({
        email: Yup.string()
            .email('이메일 형식이 옳지 않습니다.')
            .required('이메일을 입력하세요'),
        name: Yup.string()
            .min(3, '이름은 최소 3글자 이상입니다.')
            .required('이름을 입력해주세요'),
        // phone: Yup.string()
        //     .min(9, '핸드폰 번호가 너무 짧아요')
        //     .max(15, '핸드폰 번호가 너무 길어요')
        //     .phone('IN', false, '전화번호 형식이 옳지 않습니다.')
        //     .required('전화번호를 입력하세요'),
        password: Yup.string()
            .matches(
                /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/,
                '패스워드는 소문자,숫자,특수문자 혼용으로 최소 8자 이상 입력하세요')
            .required('비밀번호를 입력하세요'),
        password2: Yup.string()
            .oneOf([Yup.ref('password'), null],
                '패스워드가 일치하지 않습니다')
    })
    const navigate =  useNavigate()
    const submit = async (values) => {
        const {name,phone,email,password,password2} = values;
        try{
            await API.post('user/register',{
            name,phone,email,password,password2
            }).then((res) =>{
                console.log(res)
                if(validationSchema){
                    alert(JSON.stringify(values,null,2))
                }
            })
            navigate('/')
        }
        catch(e){
            console.log(e)
        }

    }
    return (

        <Formik
            initialValues={
                {
                    name: '',
                    phone: '',
                    email: '',
                    password: '',
                    password2: ''
                }
            }
            validationSchema={validationSchema}
            onSubmit={submit}
        >
            {({ values, handleChange, handleSubmit, isSubmitting, errors }) => (
                <section className={styles.Container}>
                    <h1 className={styles.title}>REGISTER</h1>
                    <Form className={styles.authForm}>
                        <input
                            className={styles.input}
                            id='email'
                            type="text"
                            placeholder="이메일을 입력하세요"
                            name='email'
                            value={values.email}
                            onChange={handleChange}
                        />
                        <span role="alert">
                            {errors.email}</span>
                        <input className={styles.input}
                            type="text"
                            id='name'
                            name="name"
                            placeholder="이름을 입력하세요"
                            value={values.name}
                            onChange={handleChange}
                        />
                        <span role="alert">
                            {errors.name}</span>
                        <input className={styles.input}
                            type="phone"
                            id='phone'
                            name="phone"
                            placeholder="전화번호를 입력하세요"
                            value={values.phone}
                            onChange={handleChange}
                        />
                        <span role="alert">
                            {errors.phone}</span>
                        <input
                            className={styles.input}
                            type="password"
                            name='password'
                            id='password'
                            placeholder="비밀번호를 입력하세요"
                            value={values.password}
                            onChange={handleChange}
                        />
                        <span role="alert">
                            {errors.password}</span>
                        <input
                            className={styles.input}
                            type="password"
                            name='password2'
                            id='password2'
                            placeholder="비밀번호를 입력하세요"
                            value={values.password2}
                            onChange={handleChange}
                        />
                        <span role="alert">
                            {errors.password2}</span>
                        <Button type="submit">입력완료</Button>
                        <div className={styles.backToLogin}>
                            <h4>이미 회원이신가요?</h4>
                            <Link to='/' className={styles.back}>LOGIN 페이지로</Link>
                        </div>
                    </Form>
                </section >
            )
            }
        </Formik>

    );
};

export default SignUpForm;


