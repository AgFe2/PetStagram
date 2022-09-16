import { BrowserRouter,Routes,Route } from "react-router-dom";
import Login from './pages/login/Login'
import Register from './pages/register/Register'
import Home from './pages/Home'
import My from "./pages/my/My";
import Taged from "./pages/tag";
function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Login/>} />
          <Route path='/register' element={<Register/>}/>
          <Route path='/home' element={<Home />}/>
          <Route path="/userId" element={<My />}/>
          <Route path="/taged" element={<Taged />}/>
          
        </Routes>
      </BrowserRouter>
  );
}

export default App;
