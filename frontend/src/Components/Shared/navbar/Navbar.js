// Navbar.js

import React from "react";
import "./Navbar.css";
import menuIcon from "./assets/menu.png";
const Navbar = () => {
  return (
    <nav className="navbar">
      <ul className="navbar-list">
        <li className="navbar-item">
          <img src={menuIcon} alt="All Categories" />
          <span>All Categories</span>
        </li>
        <li className="navbar-item">Hot Offers</li>
        <li className="navbar-item">Gift Boxes</li>
        <li className="navbar-item">Projects</li>
        <li className="navbar-item">Menu Item</li>
        <li className="navbar-item">
          <select className="help-select">
            <option value="help">Help</option>
            {/* Add more help options here */}
          </select>
        </li>
      </ul>
      <div className="navbar-submenu">
        <select className="currency-select">
          <option value="dollar">English, USD</option>
          <option value="egPound">Arabic, EGP</option>
          {/* Add more currency options here */}
        </select>
      </div>
      <div className="navbar-select">
        <select className="ship-to-select">
          <option value="egypt">
            Ship to Egypt
            <img src="egypt-flag.png" alt="🇪🇬" />
          </option>
          <option value="germany">
            Ship to Germany
            <img src="germany-flag.png" alt="🇩🇪" />
          </option>
          {/* Add more shipping destinations here */}
        </select>
      </div>
    </nav>
  );
};

export default Navbar;
