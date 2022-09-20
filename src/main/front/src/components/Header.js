import React, { useState } from "react";
import { Link } from "react-router-dom";

// components
import SearchBar from "./SearchBar";
import SearchResult from "./SearchResult";

// CSS & ICON
import styles from "../styles/Header.module.css";
import { FaHome, FaIcons, FaCamera, FaRegUserCircle } from "react-icons/fa";

export default function Header() {
  const hashtag = [
    {
      hashtag_id: "userId1",
      hashtag_feed_id: "userId99",
      hashtag_context: "abc",
      hashtag_feed_count: 1512,
    },
    {
      hashtag_id: "userId2",
      hashtag_feed_id: "userId98",
      hashtag_context: "abd",
      hashtag_feed_count: 12328,
    },
    {
      hashtag_id: "userId3",
      hashtag_feed_id: "userId97",
      hashtag_context: "acd",
      hashtag_feed_count: 1112,
    },
    {
      hashtag_id: "userId4",
      hashtag_feed_id: "userId96",
      hashtag_context: "ade",
      hashtag_feed_count: 1867759,
    },
    {
      hashtag_id: "userId5",
      hashtag_feed_id: "userId95",
      hashtag_context: "adf",
      hashtag_feed_count: 17238,
    },
  ];

  // searchBar filter n resultNothing
  const [search, setSearch] = useState("");
  const [resultNothing, setResultNothing] = useState(true);
  const onChange = (e) => {
    setResultNothing(false); // value값을 입력했다가 지우는 경우("" or null?)에 다시 true로 전환해야함
    setSearch(e.target.value);
  };

  const filterTag = hashtag.filter((tag) => {
    if (search === "") {
      return null;
    } else if (
      tag.hashtag_context
        .replace(" ", "")
        .toLocaleLowerCase()
        .includes(search.toLocaleLowerCase())
    ) {
      return tag;
    }
    return null; // 마지막 return을 안넣어주면 '화살표 함수에 마지막에는 리턴 밸류해줘야한다'는 에러가 뜸 why?
  });

  //searchBar Focus n Blur
  const [activeSearch, setActiveSearch] = useState(false);

  const handleFocusSearch = () => {
    setActiveSearch(true);
  };
  const handleBlurSearch = () => {
    setActiveSearch(false);
  };

  return (
    <header>
      <div className="container">
        <div className={styles.header}>
          <h1 style={{ color: "#2e2d30" }}>PetStagram</h1>
          <div
            className={styles.searchBar}
            onFocus={() => handleFocusSearch("searchFocus")}
            onBlur={() => handleBlurSearch("searchFocus")}
          >
            <SearchBar search={search} onChange={onChange}></SearchBar>
            <SearchResult
              filterTag={filterTag}
              activeSearch={activeSearch}
              resultNothing={resultNothing}
            />
          </div>
          <nav className={styles.nav}>
            <Link to="/" className={styles.navItem}>
              <p className="sr-only">Home</p>
              <FaHome className={styles.navIcon} />
            </Link>
            <Link to="/top" className={styles.navItem}>
              <p className="sr-only">Top</p>
              <FaIcons className={styles.navIcon} />
            </Link>
            <div className={styles.navItem}>
              <FaCamera
                className={[styles.navIcon, styles.uploadBtn].join(" ")}
              />
              <p className="sr-only">upload</p>
            </div>
            <Link to="/userId" className={styles.navItem}>
              <p className="sr-only">My Page</p>
              <FaRegUserCircle className={styles.navIcon} />
            </Link>
            {/* 인스타그램처럼 depth2로 만들어야 할 듯
                설정 변경(닉네임 등), 로그아웃 ... */}
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
