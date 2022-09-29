import React from "react";
import { Route, Routes } from "react-router-dom";
import { QueryClient, QueryClientProvider } from "react-query";

// componets
import Header from "./components/Header/Header";

//Page
import Login from "./pages/login/Login";
import Register from "./pages/register/Register";
import Taged from "./pages/tag";
import Main from "./pages/main/Main";
import Top from "./pages/top/Top";
import Explore from "./pages/explore/Explore";
import My from "./pages/my/My";

// CSS & ICON
import "./styles/common.css";
import "./styles/reset.css";

const queryClient = new QueryClient();

function App() {
  return (
    <div>
      <QueryClientProvider client={queryClient}>
        <Header />
        <Routes>
          <Route path={"/"} element={<Main />} />
          <Route path={"top"} element={<Top />} />
          <Route path={"explore"} element={<Explore />} />
          <Route path={"userId"} element={<My />} />
          <Route path={"/login"} element={<Login />} />
          <Route path={"/register"} element={<Register />} />
          <Route path={"/my"} element={<My />} />
          <Route path={"/taged"} element={<Taged />} />
          {/* <Route component={PageNotFound} /> */}
        </Routes>
      </QueryClientProvider>
    </div>
  );
}

export default App;
