import React, { useState } from "react";
import { Link } from "react-router-dom";

// components
import SearchBar from "./SearchBar";
import ProfileModal from "../Modal/ProfileModal";
import UploadModal from "../Modal/UploadModal";

// CSS & ICON
import styles from "../../styles/Header.module.css";
import { FaHome, FaIcons, FaCamera, FaRegUserCircle } from "react-icons/fa";

export default function Header() {
  const hashtag = [
    {
      hashtag_feed_id: "userId99",
      hashtag_context: "abc",
      hashtag_feed_count: 1512,
    },
    {
      hashtag_feed_id: "userId98",
      hashtag_context: "abd",
      hashtag_feed_count: 12328,
    },
    {
      hashtag_feed_id: "userId97",
      hashtag_context: "acd",
      hashtag_feed_count: 1112,
    },
    {
      hashtag_feed_id: "userId96",
      hashtag_context: "ade",
      hashtag_feed_count: 1867759,
    },
    {
      hashtag_feed_id: "userId95",
      hashtag_context: "adf",
      hashtag_feed_count: 17238,
    },
  ];

  // searchBar filter
  const [search, setSearch] = useState("");
  const handleSearchChange = (e) => {
    setSearch(e.target.value);
  };

  const filterTag = hashtag.filter((tag) => {
    return tag.hashtag_context
      .replace(" ", "")
      .toLocaleLowerCase()
      .includes(search.toLocaleLowerCase());
  });

  // uploadModal
  const [uploadModal, setUploadModal] = useState(false);
  // const handleOpenUpload = () => {
  //  setUploadModal(true);
  // };
  const handleCloseUpload = () => {
    setUploadModal(false);
  };

  // profileModal
  const [profileDepth, setProfileDepth] = useState(false);

  return (
    <header>
      <div className="container">
        <div className={styles.header}>
          <Link to="/" className={styles.logo}>
            <h1 className={styles.logoTxt}>PetStagram</h1>
          </Link>
          <SearchBar
            search={search}
            onChange={handleSearchChange}
            filterTag={filterTag}
          ></SearchBar>
          <nav className={styles.nav}>
            <Link to="/" className={styles.navItem}>
              <p className="sr-only">Home</p>
              <FaHome className={styles.navIcon} />
            </Link>
            <Link to="/top" className={styles.navItem}>
              <p className="sr-only">Top</p>
              <FaIcons className={styles.navIcon} />
            </Link>
            <div
              className={styles.navItem}
              onClick={() => setUploadModal(!uploadModal)}
            >
              <p className="sr-only">upload</p>
              <FaCamera
                className={[styles.navIcon, styles.uploadBtn].join(" ")}
              />
              {uploadModal === true ? (
                <UploadModal handleCloseUpload={handleCloseUpload} />
              ) : null}
            </div>
            <div
              className={`${styles.navItem} ${styles.profile}`}
              onClick={() => setProfileDepth(!profileDepth)}
            >
              <p className="sr-only">My Page</p>
              <FaRegUserCircle className={styles.navIcon} />
              {profileDepth === true ? <ProfileModal /> : null}
            </div>
          </nav>
        </div>
      </div>
    </header>
  );

  // searchRecent
  /* <div className={styles.searchRecent}>
      <div className={styles.searchRecentTitle}>
        <p className={styles.recentTitle}>RECENT</p>
        <button className={styles.recentClearBtn}>clear</button>
      </div>
      <ul className={styles.searchRecentItems}> // 검색해봤던 검색어들 저장
        <li>abc</li>
        <li>abd</li>
        <li>aed</li>
      </ul>
  </div> */
}
