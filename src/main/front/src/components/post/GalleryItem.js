import React from 'react';
import styles from '../../styles/Gallery.module.css'


export default function GalleryItem ({imagepath}){
    console.log(imagepath)
    return (
        <div>
            <img className={styles.postImg} src={imagepath} alt="갤러리 사진" />
        </div>
    );
};

GalleryItem.defaultProps ={
    imagepath:'/images/dog.jpeg'
}