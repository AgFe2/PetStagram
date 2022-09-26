import React, { useRef, useState } from 'react';
import styles from '../styles/Info.module.css'
import Stories from '../data/Stories.json'
import ProfileStory from './ProfileStory';
import {BsArrowRightCircle,BsArrowLeftCircle} from 'react-icons/bs'
import clsx from 'clsx'
const ProfileStories = () => {
    const storiesRef = useRef(null)
    const [showLeft,setShowLeft] = useState(false)
    const [showRight, setShowRight] = useState(true)

    const onScroll = () =>{
        if(storiesRef.current.scrollLeft > 0){
            setShowLeft(true)
        }else {
            setShowLeft(false)
        }
        if(storiesRef.current.scrollLeft === storiesRef.current.scrollWidth - storiesRef.current.clientWidth){
            setShowRight(true)
        }else{
            setShowRight(true)
        }
    }

    const unvisible = () =>{
        
    }
    return (
        <div className={styles.stotyContainer}>

            <div className={styles.StoryList} onScroll={onScroll} ref={storiesRef}>
            {
                Stories.map((story) => (
                    <ProfileStory imagepath={story.imagepath} key={story.id} name={story.name} />
                    ))}
            </div>
            <div className={styles.buttonContainer}>
            <button className={styles.button} onClick={() => {storiesRef.current.scrollLeft = storiesRef.current.scrollLeft-300}}>
                <BsArrowLeftCircle className={clsx(styles.scrollArrow)}></BsArrowLeftCircle>
            </button>
            <button className={styles.button}  onClick={() => {storiesRef.current.scrollLeft = storiesRef.current.scrollLeft+300}}>
                <BsArrowRightCircle className={styles.scrollArrow}></BsArrowRightCircle>
            </button>
            </div>
        
        </div>
    );
};

export default ProfileStories;

