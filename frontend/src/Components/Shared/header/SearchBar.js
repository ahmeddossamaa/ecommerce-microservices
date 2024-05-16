import React from "react";
import { useState } from "react";

const SearchBar = () => {
  const [searchValue, setSearchValue] = useState("");
  const applySearch = () => {
    console.log("Searching for:", searchValue);
  };
  return (
    <div className="search-bar">
      <input
        type="text"
        placeholder="Search..."
        value={searchValue}
        onChange={(e) => setSearchValue(e.target.value)}
      />
      <select>
        <option value="all">All Categories</option>
      </select>
      <button onClick={applySearch}>Search</button>
    </div>
  );
};

export default SearchBar;
