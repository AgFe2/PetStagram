import axios from "axios";

export const API =(token) => axios.create({

    baseURL:'http://localhost:8080',
    headers:{
        'Content-Type' : 'applications/json',
        "Authorization": "Bearer "+token,
      
        // 추가  
        "Access-Control-Allow-Origin": `http://localhost:3000`,
        'Access-Control-Allow-Credentials':"true",
    },
})

// API.interceptors.response.use(
//     (res)=>{
//         const {token} = res.data
//         localStorage.setItem("token",token);
//         return res;
//     },
//     (error) =>{
//         return Promise.reject(error)
//     }
// )

