import React from "react";
import "./MainSection.css";
import bannerImg from "./assets/banner.png";
import userImg from "./assets/user.png";

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
          <li className="active">Category 10</li>
          {/* Add more categories here */}
        </ul>
      </div>
      <div className="banner-section">
        <div className="banner">
          <img src={bannerImg} alt="Banner" />
          <div className="banner-content">
            <h2>Welcome to Our Store</h2>
            <p>Discover amazing products</p>
            <button>Learn More</button>
          </div>
        </div>
      </div>
      <div className="blocks-section">
        <div className="block block1">
          <div class="block1-top">
            <img src={userImg} alt="User" />
            <div class="text">
              Hi, <span>user</span>
              <div>let's get started</div>
            </div>
          </div>
          <button className="signup-button">Join now</button>
          <button className="login-button">
            <span>Log in</span>
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
