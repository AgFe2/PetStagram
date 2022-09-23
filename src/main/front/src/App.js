import { Routes, Route } from "react-router-dom";
import Login from './pages/login/Login'
import Register from './pages/register/Register'
import Home from './pages/Home'
import My from "./pages/my/My";
import Taged from "./pages/tag";
import { QueryClient, QueryClientProvider } from "react-query";

const queryClient = new QueryClient()



function App() {

  return (
    <QueryClientProvider client={queryClient}>
      <Routes>
          <Route path='/' element={<Login />} />
          <Route path='/register' element={<Register />} />
          <Route path="/my" element={<My />} />
          <Route path="/taged" element={<Taged />} />
        </Routes>
    </QueryClientProvider>
  );
}

export default App;
