import React from "react";

const SearchBar = () => {
  return (
    <div className="search-bar">
      <input type="text" placeholder="Search..." />
      <select>
        <option value="all">All Categories</option>
        {/* Add more category options here */}
      </select>
      <button>Search</button>
    </div>
  );
};

export default SearchBar;
