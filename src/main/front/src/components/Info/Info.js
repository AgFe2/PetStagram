import React from 'react';
import styles from '../../styles/Info.module.css'
import {BsGrid3X3} from 'react-icons/bs'
import {MdTag} from 'react-icons/md'
const Info = () => {
    return (
        <div className={styles.container}>
            <haeder className={styles.InfoContainer}>
                    <div className={styles.pictureConatiner}>
                        <div className={styles.profilePicture}></div>
                    </div>
                    <section className={styles.userInfoContainer}>
                        <h3 className={styles.name}>PETSTAGRAM</h3>
                        <ul className={styles.followList}>
                            <li className={styles.followItem}>
                                <span style={{ fontWeight: "bold" }}>게시글 99</span>
                            </li>
                            <li className={styles.followItem}>
                                <span style={{ fontWeight: "bold" }}>팔로우 99</span>
                            </li>
                            <li className={styles.followItem}>
                                <span style={{ fontWeight: "bold" }}>팔로워 99</span>
                            </li>
                        </ul>
                        <div>
                            <h4>Name</h4>
                            <span>bio, description</span>
                        </div>
                    </section>
            </haeder>
            <div className={styles.slider}>
                <a className={styles.sliderlist} href='/userId'>
                <BsGrid3X3 /><span>POST</span></a>
                <a className={styles.sliderlist} href='/taged'>
                <MdTag/> <span>TAG</span></a>
            </div>
        </div>

    );
};

export default Info;