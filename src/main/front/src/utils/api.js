import axios from "axios";

export const BASE_URL= 'http://localhost:8080';

export const API = axios.create({
    baseURL:'http://localhost:8080',
    headers:{
        'Content-Type' : 'applications/json',
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

