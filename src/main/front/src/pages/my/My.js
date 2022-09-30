import React ,{useEffect} from "react";
import Header from "../../components/Header/Header";
import Info from "../../components/Info/Info";
import Gallery from "../../components/post/Gallery";
import styles from "../../styles/My.module.css";
import axios from "axios";
function My() {
  useEffect(() => {
    axios.get('http://localhost:8080/feed/test',{
        headers:{
          'Content-Type':'application/json',
          'Authorization': 'Bearer ' + localStorage.getItem("JWT"),
        }
      })
      .then(res => console.log(res))
      .then(json => alert(json))
},[])

  return (
    <>
      <Header />
      <Info />
      <Gallery />
    </>
  );
}

export default My;
