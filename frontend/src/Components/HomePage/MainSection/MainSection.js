import React from "react";
import "./MainSection.css";
const images = require.context(
  "../../../Assets/Components/HomePage/MainSection",
  true
);
const imageList = images.keys().reduce((acc, image) => {
  const name = image.split("./")[1].split(".")[0];
  acc[name] = images(image);
  return acc;
}, {});

const MainSection = () => {
  return (
    <div className="main-section">
      <div className="categories-section">
        <ul>
          <li className="active">Category 1</li>
          <li>Category 2</li>
          <li>Category 3</li>
          <li>Category 4</li>
          <li>Category 5</li>
          <li>Category 6</li>
          <li>Category 7</li>
          <li>Category 8</li>
          <li>Category 9</li>
          <li>Category 10</li>
        </ul>
      </div>
      <div className="banner-section">
        <div className="banner">
          <img src={imageList["banner"]} alt="Banner" />
          <div className="banner-content">
            <h2>Welcome to Our Store</h2>
            <p>Discover amazing products</p>
            <button>Learn More</button>
          </div>
        </div>
      </div>
      <div className="blocks-section">
        <div className="block block1">
          <div className="block1-top">
            <img src={imageList["user"]} alt="User" />
            <div className="text">
              Hi, <span>user</span>
              <div>let's get started</div>
            </div>
          </div>
          <button className="signup-button">
            <a href="/register">
              <span>Join now</span>
            </a>
          </button>
          <button className="login-button">
            <a href="/login">
              <span>Log in</span>
            </a>
          </button>
        </div>
        <div className="block block2">
          <p>Get US $10 off with a new supplier</p>
        </div>
        <div className="block block3">
          <p>Send quotes with supplier preferences</p>
        </div>
      </div>
    </div>
  );
};

export default MainSection;
