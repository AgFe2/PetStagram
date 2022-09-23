import React from 'react';
import { data } from '../../data/data';
import styles from '../../styles/Gallery.module.css'
import GalleryItem from './GalleryItem';

export default function Gallery() {
    return (
        <section className={styles.postContainer}>
            <div className={styles.postlist}>
                {data.length > 1 ?
                data.map((item,idx)=>(
                    <GalleryItem imagepath={item.imagepath} key={idx} />
                ))
                :<div>No Post</div>
                }
            </div>
        </section>
    );
};
