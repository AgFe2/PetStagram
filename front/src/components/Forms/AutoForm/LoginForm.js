import React, { useCallback, useId, useState } from 'react';
import Button from '../../Button/Button';
import styles from './AuthForm.module.css'
import { Link, useNavigate } from 'react-router-dom';
import useInput from '../../../hooks/useInput';
import { useDispatchContext,useStateContext } from '../../../context/auth_context';
const LoginForm = () => {
    const [id, onChangeId, setId] = useInput("")
    const [pwd, onChangePwd, setPwd] = useInput("")

    const navigate = useNavigate()

    const {userList} = useStateContext();
    const dispatch = useDispatchContext();

    console.log({userList})
    const handleSubmit = () => {
        if (!id || !pwd) {
            alert('모든값을 정확하게 입력하시오')
            return;
        }
        dispatch({
            type:"LOGIN",
            userId:id,
            userPw:pwd
        })

        alert('로그인 성공')
        navigate('/home')
    }


    
    return (
        <>
            <section className={styles.Container}>
                <h1 className={styles.title}>LOGIN</h1>
                <form className={styles.authForm} onSubmit={handleSubmit}>
                    <input className={styles.input}
                        type="text"
                        value={id.data}
                        name="id"
                        placeholder="아이디를 입력하세요"
                        onChange={onChangeId}
                    />
                    <input
                        className={styles.input}
                        type="password"
                        placeholder="패스워드를 입력하세요"
                        value={pwd.data}
                        onChange={onChangePwd}
                    />

                    <Button>로그인</Button>
                    <div className={styles.signUp}>
                        <h4>아직도 회원이 아니신가요? &nbsp;</h4>
                        <Link to="/register"><span>Sign Up</span></Link>
                    </div>
                </form>
            </section>
        </>
    );
};

export default LoginForm;