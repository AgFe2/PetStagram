import React from "react";
import PropTypes from "prop-types";
import styles from "../styles/Header.module.css";

function SearchBar({ search, onChange, onFocus, onBlur }) {
  return (
    <>
      <input
        className={styles.searchBarInput}
        type="text"
        placeholder={"검색"}
        onChange={onChange}
        value={search}
        onFocus={onFocus}
        onBlur={onBlur}
      ></input>
    </>
  );
}
SearchBar.propTypes = {
  search: PropTypes.any.isRequired,
  onChange: PropTypes.func.isRequired,
  onFocus: PropTypes.func.isRequired,
  onBlur: PropTypes.func.isRequired,
};

export default SearchBar;
