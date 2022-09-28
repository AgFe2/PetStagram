import React from 'react';
import styles from '../styles/Info.module.css'

import Carousel from './Carousel/Carousel';
const ProfileStories = () => {

    return (
        <div className={styles.stotyContainer}>
            <Carousel />
        </div>
    );
};

export default ProfileStories;

