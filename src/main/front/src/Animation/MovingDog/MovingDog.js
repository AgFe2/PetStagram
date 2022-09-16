
import styles from './MovingDog.module.css'

const MovingDog = () => {
    return (
        <div className={styles.dogContainer}>
        <div className={styles.dog}>
            <div className={styles.torso}>
                <div className={styles.fur}>
                    <div className={styles.spot}></div>
                </div>
                <div className={styles.neck}>
                    <div className={styles.fur}></div>
                    <div className={styles.head}>
                        <div className={styles.fur}>
                            <div className={styles.snout}>
                            </div>
                                <div className={styles.nose}></div>
                        </div>
                        <div className={styles.ears}>
                            <div className={styles.ear}>
                                <div className={styles.fur}></div>
                            </div>
                            <div className={styles.ear}>
                                <div className={styles.fur}></div>
                            </div>
                        </div>
                        <div className={styles.eye}></div>
                    </div>
                    <div className={styles.collar}></div>
                </div>
                <div className={styles.legs}>
                    <div className={styles.leg}>
                        <div className={styles.fur}></div>
                        <div className={styles.legInner}>
                            <div className={styles.fur}></div>
                        </div>
                    </div>
                    <div className={styles.leg}>
                        <div className={styles.fur}></div>
                        <div className={styles.legInner}>
                            <div className={styles.fur}></div>
                        </div>
                    </div>
                    <div className={styles.leg}>
                        <div className={styles.fur}></div>
                        <div className={styles.legInner}>
                            <div className={styles.fur}></div>
                        </div>
                    </div>
                    <div className={styles.leg}>
                        <div className={styles.fur}></div>
                        <div className={styles.legInner}>
                            <div className={styles.fur}></div>
                        </div>
                    </div>
                </div>
                <div className={styles.tail}>
                    <div className={styles.tail}>
                        <div className={styles.tailEnd}>
                            <div className={styles.tail}>
                                <div className={styles.tail}>
                                    <div className={styles.tail}>
                                        <div className={styles.tail}>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    );
};

export default MovingDog;