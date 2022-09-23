import React, { useRef, useState } from 'react';
import styles from '../styles/Info.module.css'
import Stories from '../data/Stories.json'
import ProfileStory from './ProfileStory';
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

    return (
        <div className={styles.stotyContainer}>

        <div className={styles.StoryList} onScroll={onScroll} ref={storiesRef}>
        {
            Stories.map((story) => (
                <ProfileStory imagepath={story.imagepath} key={story.id} name={story.name} />
                ))}
        </div>
        </div>
    );
};

export default ProfileStories;

