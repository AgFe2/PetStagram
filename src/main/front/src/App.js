import { BrowserRouter, Route, Routes } from "react-router-dom";
import Main from "./pages/main/Main";
import Top from "./pages/top/Top";
import Explore from "./pages/explore/Explore";
import My from "./pages/my/My";
// import Header from "./components/Header";

// CSS & ICON
import "./styles/common.css";
import "./styles/reset.css";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path={"/"} element={<Main />}></Route>
          <Route path={"top"} element={<Top />}></Route>
          <Route path={"explore"} element={<Explore />}></Route>
          <Route path={"userId"} element={<My />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
