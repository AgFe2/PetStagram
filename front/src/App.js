import { BrowserRouter,Routes,Route } from "react-router-dom";
import { UserContext } from "./context/auth_context";
import Login from './pages/login/Login'
import Register from './pages/register/Register'
function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Login/>}></Route>
          <Route path='/register' element={<Register/>}></Route>
        </Routes>
      </BrowserRouter>
  );
}

export default App;

