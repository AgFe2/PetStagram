import React from "react";
import styles from "../../styles/Info.module.css";
import { BsGrid3X3 } from "react-icons/bs";
import { MdTag } from "react-icons/md";
// import Skeletion from 'react-loading-skeleton';
import { Link } from "react-router-dom";
import InfoHeader from "./InfoHeader";
import ProfileStories from "../ProfileStories";

const Info = () => {
  return (
    <div className={styles.container}>
      <InfoHeader />
      <ProfileStories />
      <div className={styles.switchContainer}>
        <Link className={styles.switch} to="/my">
          <div>
            <BsGrid3X3 className={styles.icon} />
            <span>POST</span>
          </div>
        </Link>
        <Link className={styles.switch} to="/taged">
          <div>
            <MdTag className={styles.icon} />
            <span>TAG</span>
          </div>
        </Link>
      </div>
    </div>
  );
};

export default Info;
