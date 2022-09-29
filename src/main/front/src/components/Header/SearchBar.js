import React, { useState } from "react";
import PropTypes from "prop-types";

//components
import SearchResult from "./SearchResult";

//CSS
import styles from "../../styles/SearchBar.module.css";

function SearchBar(props) {
  const { search, onChange, filterTag } = props;

  //searchBar Focus n Blur
  const [activeSearch, setActiveSearch] = useState(false);

  const handleFocusSearch = () => {
    setActiveSearch(true);
  };
  const handleBlurSearch = () => {
    setActiveSearch(false);
  };
  return (
    <>
      <div className={styles.body}>
        <select className={styles.options}>
          <option value="태그" selected className={styles.option}>
            태그
          </option>
          <option value="아이디" className={styles.option}>
            아이디
          </option>
        </select>
        <input
          className={styles.input}
          type="text"
          placeholder={"검색"}
          onChange={onChange}
          value={search}
          onFocus={handleFocusSearch}
          onBlur={handleBlurSearch}
        ></input>
        <SearchResult
          activeSearch={activeSearch}
          filterTag={filterTag}
          search={search}
        />
      </div>
    </>
  );
}
SearchBar.propTypes = {
  search: PropTypes.any.isRequired,
  onChange: PropTypes.func.isRequired,
};

export default SearchBar;
