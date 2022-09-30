import axios from 'axios';
import styles from './Modal.module.css'
import React from 'react';
import Button from '../Button/Button'
import {MdComment} from 'react-icons/md'
const Modal = ({ imgpath,postcomment ,comment,onSubmit,setModalIsOpen }) => {
    const closeModal = () =>{
        setModalIsOpen(false)
    }
    const test = () =>{
            axios.get('http://localhost:8080/',{
                headers:{
                  'Content-Type':'application/json',
                  'Authorization': 'Bearer ' + localStorage.getItem("JWT"),
                }
              }).then(res => console.log(res))
              .then(json => alert(json))

        }
    return (
        <>
            <section className={styles.ModalWrapper} onClick={closeModal}>
                <div className={styles.ModalContent}>
                    <div className={styles.postImg}>
                        <img src={imgpath} />
                    </div>
                    <div className={styles.postCmt}>
                        <div className={styles.postContent}>
                            {postcomment}
                        </div>
                        <div className={styles.commentContainer}>
                            <span>{comment}</span>
                            <form onSubmit={onSubmit}>
                                <input className={styles.input} type="text" />
                                <Button className={styles.button}type="submit" onClick={test}>
                                    <MdComment className={styles.AddIcon}></MdComment>
                                </Button>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </>
    );
};

export default Modal;