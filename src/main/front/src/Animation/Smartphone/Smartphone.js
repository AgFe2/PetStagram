import styles from './Smartphone.module.css'

export const Smartphone = () => {
    return (
        <div className={styles.smartphoneContainer}>
            <div className={styles.phoneline}>
                <div className={styles.smartphone}>
                    <div className={styles.bezel}></div>
                    <div className={styles.content}>PET STAGRAM</div>
                </div>
            </div>
            <div className={styles.frontPhoneline}>
                <div className={styles.Frontsmartphone}>
                    <div className={styles.bezel}></div>
                </div>
            </div>
        </div>
    )
}

