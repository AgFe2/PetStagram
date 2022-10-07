import React, { useState } from "react";
import Button from "../../Button/Button";
import styles from "./AuthForm.module.css";
import { Link, useNavigate } from "react-router-dom";
import { Formik, Form} from "formik";
import * as Yup from "yup";
import axios from "axios";

const LoginForm = () => {
  const [isLogined, setIsLogined] = useState(false)
  const navigate = useNavigate();

  const LoginValidSchema = Yup.object().shape({
    email: Yup.string().email().required("이메일을 입력하세요"),
    password: Yup.string().required("비밀번호를 채워주세요"),
  });

  const handleSubmit = async (values, { setSubmitting }) => {
    const data = {
      email: values.email,
      password: values.password,
    };
    try {
      await axios
        .post("http://localhost:8080/member/sign-in", JSON.stringify(data), {
          headers: { "Content-Type": "application/json" },
          //          "Access-Control-Allow-Origin": "http://localhost:3000",
          //           'Access-Control-Allow-Credentials':"true"},
        })
        .then((response) => {
          axios.defaults.headers.common[
            "Authorization"
          ] = `Bearer ${response.data.accessToken}`;
          return response.data;
        })
        .then((token) => {
          localStorage.setItem("JWT", token.accessToken);
          alert("로그인되었습니다.");
        });
        if(!isLogined) {
          setIsLogined(true)
        }
      setTimeout(() => {
        navigate("/");
      }, 2000);
    } catch (e) {
      alert("아이디가 존재하지않습니다.");
      setSubmitting(true);
    }
  };
  return (
    <Formik
      initialValues={{
        email: "",
        password: "",
      }}
      validationSchema={LoginValidSchema}
      onSubmit={handleSubmit}
    >
      {({ values, handleChange, errors, isSubmitting, isValid }) => (
        <section className={styles.Container}>
          <h1 className={styles.title}>LOGIN</h1>
          <Form className={styles.authForm}>
            <input
              className={styles.input}
              type="text"
              id="email"
              name="email"
              placeholder="이메일을 입력하세요"
              value={values.email}
              onChange={handleChange}
            />
            <span>{errors.email}</span>
            <input
              className={styles.input}
              type="password"
              id="password"
              name="password"
              placeholder="패스워드를 입력하세요"
              value={values.password}
              onChange={handleChange}
            />
            <span>{errors.password}</span>
            <Button
              className={styles.button}
              disabled={isSubmitting || !isValid}
              type="submit"
            >
              로그인
            </Button>
            <div className={styles.signUp}>
              <h4>아직도 회원이 아니신가요? &nbsp;</h4>
              <Link to="/register">
                <span>Sign Up</span>
              </Link>
            </div>
          </Form>
        </section>
      )}
    </Formik>
  );
};

export default LoginForm;
