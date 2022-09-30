import React ,{useEffect} from "react";
import Info from "../../components/Info/Info";
import Gallery from "../../components/post/Gallery";
import styles from "../../styles/My.module.css";
import axios from "axios";

function My() {


  return (
    <>
      <Info />
      <Gallery />
    </>
  );
}

export default My;
