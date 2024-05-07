import React from "react";
import Logo from "./Logo";
import SearchBar from "./SearchBar";
import Icon from "./Icon";
import "./Header.css";

const images = require.context(
  "../../../Assets/Components/Shared/header",
  true
);
const imageList = images.keys().reduce((acc, image) => {
  const name = image.split("./")[1].split(".")[0];
  acc[name] = images(image);
  return acc;
}, {});

const Header = () => {
  return (
    <header className="header">
      <Logo />
      <SearchBar />
      <div className="icons">
        <Icon name="Profile" icon={imageList["person"]} />
        <Icon name="Messages" icon={imageList["message"]} />
        <Icon name="Orders" icon={imageList["favorite"]} />
        <Icon name="My Cart" icon={imageList["shopping_cart"]} />
      </div>
    </header>
  );
};

export default Header;
