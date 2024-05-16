import React from "react";
import { useState } from "react";
import axios from 'axios';

const SearchBar = () => {
  const [searchValue, setSearchValue] = useState("");
  const applySearch = async () => {
    const response = await axios.get(`http://127.0.0.1:8080/api/products/search/${searchValue}`);

    console.log(response);
    // console.log("Searching for:", searchValue);
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
