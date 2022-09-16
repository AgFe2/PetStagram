import React from "react";
import Header from "../../components/Header/Header";
import Info from "../../components/Info/Info";
import styles from '../../styles/My.module.css';

function My() {
    return (
        <>
            <Header />
            <Info />
            <section className={styles.postContainer}>
                <div className={styles.postlist}>
                    <div className={styles.postRows}>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                    </div>
                </div>
                <div className={styles.postlist}>
                    <div className={styles.postRows}>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                    </div>
                </div>
                <div className={styles.postlist}>
                    <div className={styles.postRows}>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                    </div>
                </div>
                <div className={styles.postlist}>
                    <div className={styles.postRows}>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                    </div>
                </div>
                <div className={styles.postlist}>
                    <div className={styles.postRows}>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                    </div>
                </div>
                <div className={styles.postlist}>
                    <div className={styles.postRows}>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                        <div className={styles.post}>
                            <img className={styles.img} src="https://via.placeholder.com/300.png/09f/fff" alt="sample" />
                        </div>
                    </div>
                </div>
            </section>
        </>
    );
}

export default My;