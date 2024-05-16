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
        <Icon name="Home" icon={imageList["home"]} link="/" />
        <Icon name="products" icon={imageList["products"]} link="/products" />
        <Icon
          name="My Cart"
          icon={imageList["shopping_cart"]}
          link="/checkout"
        />
        <Icon name="Profile" icon={imageList["person"]} link="/login" />
      </div>
    </header>
  );
};

export default Header;
