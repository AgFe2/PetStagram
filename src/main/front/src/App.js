import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

// componets
import Header from "./components/Header/Header";

//Page
import Main from "./pages/main/Main";
import Top from "./pages/top/Top";
import Explore from "./pages/explore/Explore";
import My from "./pages/my/My";

// CSS & ICON
import "./styles/common.css";
import "./styles/reset.css";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path={"/"} element={<Main />}></Route>
          <Route path={"top"} element={<Top />}></Route>
          <Route path={"explore"} element={<Explore />}></Route>
          <Route path={"userId"} element={<My />}></Route>
          {/* <Route component={PageNotFound} /> */}
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
