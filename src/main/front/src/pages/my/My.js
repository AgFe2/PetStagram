import React from "react";
import Header from "../../components/Header/Header";
import Info from "../../components/Info/Info";
import Gallery from "../../components/post/Gallery";
import styles from '../../styles/My.module.css';

function My() {
    return (
        <>
            <Header />
            <Info />
            <Gallery />
        </>
    );
}

export default My;