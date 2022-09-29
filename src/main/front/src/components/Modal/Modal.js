import styles from './Modal.module.css'
import React from 'react';
import Button from '../Button/Button'
import {MdComment} from 'react-icons/md'
const Modal = ({ imgpath,postcomment ,comment,onSubmit,setModalIsOpen }) => {
    const closeModal = () =>{
        setModalIsOpen(false)
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
                                <Button className={styles.button}type="submit">
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