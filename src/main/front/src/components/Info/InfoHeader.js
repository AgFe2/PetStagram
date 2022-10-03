import React, { useState,useRef } from 'react';
import styles from '../../styles/InfoHeader.module.css'

const InfoHeader = () => {
    const [img, setImg] = useState('')
    const fileInput = useRef(null)


    const handleImgChange = (e) => {
        if (e.target.files[0]) {
            setImg(e.target.files[0])
        } else {
            setImg('');
            return
        }
        console.log(e.target.files[0])
        console.log(img)
        const reader = new FileReader();
        reader.onload = () => {
            if (reader.readyState === 2) {
                setImg(reader.result)
            }
        }
    reader.readAsDataURL(e.target.files[0])
    }

    const handleClick = () =>{
        fileInput.current.click()
    }

    return (
        <div className={styles.InfoContainer}>
        <div className={styles.pictureConatiner}>
            <div className={styles.profilePicture} onClick={handleClick}>
                <img className={styles.picture} src={img} size={200}/>
                <input 
                type="file"
                accept='image/jpg,impge/png,image/jpeg'
                onChange={handleImgChange} 
                ref={fileInput} 
                name="profileImg" />
            </div>
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
   
    </div>
    );
};

export default InfoHeader;

