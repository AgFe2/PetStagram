import React from "react";

// COMPONENTS
import ExistResult from "./ExistResult";
//CSS
import styles from "../../styles/SearchBar.module.css";

function SearchResult(props) {
  const { data, activeSearch, search, searchType } = props;
  return (
    <>
      <div
        className={`${styles.searchResult} ${
          activeSearch ? `${styles.focusActive}` : ""
        }`}
      >
        {data.length > 0 && search.length > 0 ? (
          <ExistResult data={data} search={search} searchType={searchType} />
        ) : (
          <div className={`${styles.resultNothing}`}>
            <span>검색 결과가 없습니다.</span>
          </div>
        )}
      </div>
    </>
  );
}

export default SearchResult;
