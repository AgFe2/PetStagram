import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { data } from '../../data/data';
import styles from '../../styles/Gallery.module.css'
import Modal from '../Modal/Modal'
import GalleryItem from './GalleryItem';

export default function Gallery() {
    const navigate = useNavigate()

    return (
        <section className={styles.postContainer}>

            <div className={styles.postlist} >
                {data.length > 1 ?
                    data.map((item, idx) => (
                        <GalleryItem imagepath={item.imagepath} postcomment={item.postcomment} key={idx}>
                        </GalleryItem>
                    ))
                    : <div>No Post</div>
                }
            </div>
        </section>
    );
};
