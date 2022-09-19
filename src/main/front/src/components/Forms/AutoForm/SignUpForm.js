import React, { useEffect, useState, useCallback } from 'react';
import Button from '../../Button/Button';
import styles from './AuthForm.module.css'
import { Link, useNavigate } from 'react-router-dom';
import useInput from '../../../hooks/useInput';
import { useDispatchContext } from '../../../context/auth_context';

const SignUpForm = () => {
    const [name, setName, onChangeName] = useInput('');
    const [tel, setTel, onChangeTel] = useInput('');
    const [email, setEmail, onChangeEmail] = useInput("");
    const [pwd, setPwd, onChangePwd] = useInput("");
    const [confirmPwd, setConfirmPwd, onChangeCheckPwd] = useInput("");
    const [errorMessage, setErrorMessage] = useState({
        telError: "",
        pwdError: "",
        confirmPwdError: "",
        emailError: ""
    });
    
    const navigate = useNavigate()
    const { telError, pwdError, confirmPwdError, emailError } = errorMessage;

    
    let inputRegexs = {
        telReg :/^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/,
        pwdReg: /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[~?!@#$%^&*_-]).{7,15}$/,
        emailReg: /^[A-Za-z0-9_]+@[A-Za-z0-9]+[A-Za-z0-9]+/
    }
    const dispatch = useDispatchContext();

    const validationCheck = useCallback(
        (input, regex) => {
            let isValidate = false;
            if (input === "") {
                isValidate = false;
            } else if (regex.test(input)) {
                isValidate = true;
            } else {
                isValidate = false;
            }
            return isValidate;
        },
        [pwd,email,tel]
    );
    
    // 리셋 함수 
    const onReset = useCallback(() => {
        setName("");
        setTel("");
        setPwd("");
        setEmail("")
        setConfirmPwd("");
    }, [setName, setTel, setPwd, setConfirmPwd, setEmail]);

    // 유효성 검사 
    /* 아이디 체크  인풋값에 값이 바뀔떄 마다 마운트가 되서 조건에 맞게 에러메세지가 뜬다.*/


    useEffect(()=>{
        
        validationCheck(pwd,inputRegexs.pwdReg)|| pwd===""
        ? setErrorMessage({
            ...errorMessage,
            pwdError:"",})
        :setErrorMessage({
            ...errorMessage,
            pwdError:"비밀번호는 영어 숫자 특수문자 혼용으로 7~15자입니다."
        });
    },[pwd])

    useEffect(()=>{
        if (validationCheck(email, inputRegexs.emailReg) || email === "") {
            setErrorMessage({
                ...errorMessage,
                emailError: "",
            });
        } else {
            setErrorMessage({
                ...errorMessage,
                emailError:
                    "이메일 형식이 올바르지 않습니다.",
            });
        }
    },[email])
    
    useEffect(()=>{
        if (pwd === confirmPwd || confirmPwd === ""){
            setErrorMessage({
                ...errorMessage,
                confirmPwdError: "",
            });
        } else {
            setErrorMessage({
                ...errorMessage,
                confirmPwdError:
                    "비밀번호 확인이 일치하지 않습니다.",
            });
        }
    },[confirmPwd])

    useEffect(()=>{
        validationCheck(tel,inputRegexs.telReg)|| tel===""
        ? setErrorMessage({
            ...errorMessage,
            telError:"",})
        :setErrorMessage({
            ...errorMessage,
            telError:"유효하지 않는 전화번호입니다. ."
        });
    },[tel])


    // 모든 인풋값을 다 채워넣고 나서 작성 완료 버튼을 누르면 값이 전달되는 함수
    // dispatch
    const handleSubmit = () => {
        if (!name || !tel || !pwd || !confirmPwd || !email) {
            alert("모든 값을 정확하게 입력해주세요");
            return;
        }

        if (telError) {
            alert("전화번호가 형식에 맞지 않습니다");
            return;
        } else if (pwdError) {
            alert("비밀번호가 형식에 맞지 않습니다");
            return;
        } else if (confirmPwdError) {
            alert("비밀번호 확인이 일치하지 않습니다.");
            return;
        } else if (emailError) {
            alert("이메일을 입력하세요")
            return;
        }
        dispatch({
            type:"REGISTER",
            user:{
                email,              
                pwd,
                name,
                tel
            }
        });

        // fetch('/register',{
        //     method:'POST',
        //     body:JSON.stringify({
        //         email:email,
        //         pwd:pwd,
        //         name:name,
        //         tel:tel,
        //         confirmPwd:confirmPwd
        //     }),
        // })
        // .then((response) => response.json())
        // .then((result) => console.log("결과",result)) 

        alert("회원 가입 완료");
        navigate('/')
        onReset();

        
    };

    return (
        <section className={styles.Container}>
            <h1 className={styles.title}>REGISTER</h1>
            <form className={styles.authForm} onSubmit={handleSubmit}>
                <input
                    className={styles.input}
                    type="text"
                    placeholder="이메일을 입력하세요"
                    value={email}
                    onChange={onChangeEmail}
                />
                {emailError ? <div>{emailError}</div>:""}
                <input className={styles.input}
                    type="text"
                    name="name"
                    placeholder="이름을 입력하세요"
                    value={name}
                    onChange={onChangeName}
                />
                <input className={styles.input}
                    type="tel"
                    name="tel"
                    placeholder="전화번호를 입력하세요"
                    value={tel}
                    onChange={onChangeTel}
                />

                <input
                    className={styles.input}
                    type="password"
                    placeholder="비밀번호를 입력하세요"
                    value={pwd}
                    onChange={onChangePwd}
                />
                {pwdError ? <div> {pwdError}</div> : ""}
                <input
                    className={styles.input}
                    type="password"
                    placeholder="비밀번호를 입력하세요"
                    onChange={onChangeCheckPwd}
                    value={confirmPwd}
                />
                {confirmPwdError ? (
                    <div>{confirmPwdError}</div>) : ("")}
                <Button type="submit" value="작성완료" />
                <div className={styles.backToLogin}>
                    <h4>이미 회원이신가요?</h4>
                    <Link to='/' className={styles.back}>LOGIN 페이지로</Link>
                </div>
            </form>
        </section >
    );
};

export default SignUpForm;