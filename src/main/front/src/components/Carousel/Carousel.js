import styles from './Carousel.module.css';
import React, { useState, useRef } from 'react';
import Stories from '../../data/Stories.json'
import ProfileStory from '../ProfileStory'
import { FaArrowRight, FaArrowLeft } from 'react-icons/fa'

const Carousel = () => {
    const storiesRef = useRef(null)
    const [showLeft, setShowLeft] = useState(false)
    const [showRight, setShowRight] = useState(true)

    const onScroll = () => {
        if (storiesRef.current.scrollLeft > 0) {
            setShowLeft(true)
        } else {
            setShowLeft(false)
        }
        if (storiesRef.current.scrollLeft === storiesRef.current.scrollWidth - storiesRef.current.clientWidth) {
            setShowRight(true)
        } else {
            setShowRight(true)
        }
    }

    const GotoFollower = () => {
        console.log('follower')
    }
    return (
        <>
            <div className={styles.StoryList} onScroll={onScroll} ref={storiesRef}>
                {Stories.map((story) => (
                    <ProfileStory 
                    onClick={GotoFollower} 
                    imagepath={story.imagepath} 
                    key={story.id} 
                    name={story.name} />
                    ))}
            </div>
            <div className={styles.buttonContainer}>
                <button className={styles.button} onClick={() => { storiesRef.current.scrollLeft = storiesRef.current.scrollLeft - 300 }}>
                    <FaArrowLeft className={styles.scrollArrow}></FaArrowLeft>
                </button>
                <button className={styles.button} onClick={() => { storiesRef.current.scrollLeft = storiesRef.current.scrollLeft + 300 }}>
                    <FaArrowRight className={styles.scrollArrow}></FaArrowRight>
                </button>
            </div>
        </>
    );
};

export default Carousel;