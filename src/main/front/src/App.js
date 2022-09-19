import { Routes, Route } from "react-router-dom";
import Login from './pages/login/Login'
import Register from './pages/register/Register'
import Home from './pages/Home'
import My from "./pages/my/My";
import Taged from "./pages/tag";
import { useStateContext } from "./context/auth_context";
function App() {
  const { user } = useStateContext()
  return (
    <>
    <Routes>
        <Route path='/' element={<Login />} />
        <Route path='/register' element={<Register />} />
        <Route path="/my" element={<My />} />
        <Route path="/taged" element={<Taged />} />
      </Routes>
    </>
  );
}

export default App;
