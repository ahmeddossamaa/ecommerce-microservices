import React from "react";
import Logo from "./Logo";
import SearchBar from "./SearchBar";
import Icon from "./Icon";
import "./Header.css";
import personIcon from "./assets/person.png";
import messageIcon from "./assets/message.png";
import favoriteIcon from "./assets/favorite.png";
import cartIcon from "./assets/shopping_cart.png";

const Header = () => {
  return (
    <header className="header">
      <Logo />
      <SearchBar />
      <div className="icons">
        <Icon name="Profile" icon={personIcon} />
        <Icon name="Messages" icon={messageIcon} />
        <Icon name="Orders" icon={favoriteIcon} />
        <Icon name="My Cart" icon={cartIcon} />
      </div>
    </header>
  );
};

export default Header;
