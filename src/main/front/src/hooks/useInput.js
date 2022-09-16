import { useCallback, useState } from 'react';

export default function useInput (initialState) {
    const [value,setValue] =useState(initialState)

    const handler = useCallback((e) =>{
        const blank = /\s/;
        if(blank.test(e.target.value) === true){
            alert("공백을 채워주세요")
            return;
        }
        setValue(e.target.value)
    },[])
    return [value,setValue,handler]
};
