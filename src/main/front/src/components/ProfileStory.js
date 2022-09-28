import React from 'react';
import styles from '../components/Carousel/Carousel.module.css'

const ProfileStory = ({ imagepath,name,onClick }) => {
    return (
        <div className={styles.followerItem}>
            <img className={styles.followerImg} src={imagepath} alt="친구이미지" onClick={onClick}/>
            <span className={styles.followerName}>{name}</span>
        </div>
    );
};

export default ProfileStory;