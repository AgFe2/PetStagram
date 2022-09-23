import React from 'react';
import styles from '../styles/Info.module.css'

const ProfileStory = ({ imagepath,name }) => {
    return (
        <div className={styles.followerItem}>
            <img className={styles.followerImg} src={imagepath} alt="친구이미지" />
            <span className={styles.followerName}>{name}</span>
        </div>
    );
};

export default ProfileStory;