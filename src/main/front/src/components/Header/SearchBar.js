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

  //selectRadio
  const [select, setSelect] = useState("tag");

  const handleSelectChange = (e) => {
    console.log(`선택한 값 : ${e.target.value}`);
    setSelect(e.target.value);
  };

  return (
    <>
      <div className={styles.body}>
        <form className={styles.radioBox}>
          <label for="tag" className={styles.radioLabel}>
            <input
              type="radio"
              name="search"
              value="tag"
              id="tag"
              checked={select === "tag"}
              onChange={handleSelectChange}
            ></input>
            태그
          </label>
          <label for="id">
            <input
              type="radio"
              name="search"
              value="id"
              checked={select === "id"}
              onChange={handleSelectChange}
            ></input>
            아이디
          </label>
        </form>

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
