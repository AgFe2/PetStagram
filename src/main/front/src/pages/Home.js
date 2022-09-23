import React from 'react';
import { useDispatchContext, useStateContext } from '../context/auth_context';

const Home = () => {


    const onLogOut = () => {
      alert("로그아웃 되었습니다.");
    };

    return (
        <>
        <div>userId 님 환영합니다.</div>
        <button onClick={onLogOut}>로그아웃</button>
      </>
    );
};

export default Home;