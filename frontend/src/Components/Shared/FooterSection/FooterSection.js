import React from "react";
import "./FooterSection.css";
const images = require.context("./assets", true);
const imageList = images.keys().map((image) => images(image));

function FooterSection() {
  console.log(imageList);
  return (
    <>
      <div className="footer-container">
        <div className="left-section">
          <img src={imageList[5]} alt="" />
          <p>
            Best information about the company gies here but now lorem ipsum is
          </p>
          <div className="social-media-icons">
            <a href="#">
              <img src={imageList[1]} alt="Facebook" />
            </a>
            <a href="#">
              <img src={imageList[6]} alt="Twitter" />
            </a>
            <a href="#">
              <img src={imageList[4]} alt="Linkedin" />
            </a>
            <a href="#">
              <img src={imageList[3]} alt="Instagram" />
            </a>
            <a href="#">
              <img src={imageList[8]} alt="Youtube" />
            </a>
          </div>
        </div>
        <div className="footer-section">
          <h3>Section 2</h3>
          <ul>
            <li>Login</li>
            <li>Register</li>
            <li>Settings</li>
            <li>My Orders</li>
          </ul>
        </div>
        <div className="footer-section">
          <h3>Section 3</h3>
          <ul>
            <li>Login</li>
            <li>Register</li>
            <li>Settings</li>
            <li>My Orders</li>
          </ul>
        </div>
        <div className="footer-section">
          <h3>Section 4</h3>
          <ul>
            <li>Login</li>
            <li>Register</li>
            <li>Settings</li>
            <li>My Orders</li>
          </ul>
        </div>
        <div className="footer-section">
          <h3>For users</h3>
          <ul>
            <li>Login</li>
            <li>Register</li>
            <li>Settings</li>
            <li>My Orders</li>
          </ul>
        </div>
        <div className="footer-section">
          <h3>Get App</h3>
          <a href="#">
            <img src={imageList[0]} alt="App Store" />
          </a>
          <a href="#">
            <img src={imageList[2]} alt="Google Play" />
          </a>
        </div>
      </div>
      <div className="bottom-footer">
        <span>&copy; 2024 Ecommerce.</span>
        <div className="language-menu">
          <select>
            <option value="ar">Arabic</option>
            <option value="en">English</option>
            <option value="fr">French</option>
            <option value="de">German</option>
            {/* Add more language options here */}
          </select>
        </div>
      </div>
    </>
  );
}

export default FooterSection;
