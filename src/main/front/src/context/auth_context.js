import { createContext,useContext,useReducer } from "react";
import React from 'react';


const initialUser ={
    userList:[],
    user:null
}

const useAuthReducer = (state,action) =>{
    switch(action.type){
        case "REGISTER" :
            return{
                ...state,
                userList:state.userList.concat(action.user),
            }
        case "LOGIN" :
            return{
                ...state,
                user:{
                    userId:action.userId,
                    userPwd:action.userPwd
                },
            }
        case "LOGOUT" :
            return{
                ...state,
                user:null,
            }
        default:
            return state;
    }
}

const UserStateContext = createContext(null);
const UserDispatchContext = createContext(null);


export const UserContext = ({children}) => {
    const [state,dispatch] = useReducer(useAuthReducer,initialUser)
    return (
        <UserStateContext.Provider value={state}>
            <UserDispatchContext.Provider value={dispatch}>
                {children}
            </UserDispatchContext.Provider>
        </UserStateContext.Provider>
    );
};

export const useStateContext = () =>{
    const state = useContext(UserStateContext)
    if(!state) throw new Error("Cannot find UserProvider")
    return state;
}
export const useDispatchContext = () =>{
    const dispatch = useContext(UserDispatchContext);
    if (!dispatch) throw new Error("Cannot find UserProvider");
    return dispatch;
}