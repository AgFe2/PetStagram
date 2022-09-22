import React from "react";
import PropTypes from "prop-types";
import styles from "../styles/Header.module.css";

function SearchBar(props) {
  const { search, onChange } = props;
  return (
    <>
      <input
        className={styles.searchBarInput}
        type="text"
        placeholder={"검색"}
        onChange={onChange}
        value={search}
      ></input>
    </>
  );
}
SearchBar.propTypes = {
  search: PropTypes.any.isRequired,
  onChange: PropTypes.func.isRequired,
};

export default SearchBar;
