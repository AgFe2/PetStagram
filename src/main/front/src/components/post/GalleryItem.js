import React, { useState } from 'react';
import styles from '../../styles/Gallery.module.css'
import Modal from '../Modal/Modal'

export default function GalleryItem ({imagepath,postcomment}){
    const [modalIsOpen,setModalIsOpen] =useState(false)
    const handleModal = () => {
        setModalIsOpen(true)
    }

    return (
        <div>
            <img 
            className={styles.postImg} 
            onClick={handleModal} 
            src={imagepath} 
            alt="갤러리 사진" 
            role="button"/>
            {modalIsOpen === true ? <Modal imgpath={imagepath} postcomment={postcomment} setModalIsOpen={setModalIsOpen}/> : null}
        </div>
    );
};

GalleryItem.defaultProps ={
    imagepath:'/images/dog.jpeg'
}