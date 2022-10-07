import React, { useState } from "react";
import axios from "axios";
import PropTypes from "prop-types";

//components
import SearchResult from "./SearchResult";

//CSS
import styles from "../../styles/SearchBar.module.css";

function SearchBar(props) {
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

  const [data, setData] = useState([]);
  // searchBar filter
  const [search, setSearch] = useState("");
  const handleSearchChange = (e) => {
    e.target.value &&
      axios
        .get("/search", {
          params: { searchType: select, searchValue: e.target.value },
        })
        .then((res) => {
          console.log(res.data);
          console.log(select);
          setData(res.data);
        })
        .catch((err) => console.log(err));
    setSearch(e.target.value);
  };

  // tagTitle 이 태그이름
  // id 가 아이디들

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
          onChange={handleSearchChange}
          value={search}
          onFocus={handleFocusSearch}
          onBlur={handleBlurSearch}
        ></input>
        <SearchResult
          activeSearch={activeSearch}
          search={search}
          data={data}
          searchType={select}
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
