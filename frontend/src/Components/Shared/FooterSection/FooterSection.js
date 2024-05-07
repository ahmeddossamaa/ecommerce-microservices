import React from "react";
import "./FooterSection.css";

const images = require.context(
  "../../../Assets/Components/Shared/FooterSection",
  true
);
const imageList = images.keys().reduce((acc, image) => {
  const name = image.split("./")[1].split(".")[0];
  acc[name] = images(image);
  return acc;
}, {});

function FooterSection() {
  return (
    <>
      <div className="footer-container">
        <div className="left-section">
          <img src={imageList["Logo"]} alt="" />
          <p>
            Best information about the company goes here but now lorem ipsum is
          </p>
          <div className="social-media-icons">
            <a href="#">
              <img src={imageList["Facebook"]} alt="Facebook" />
            </a>
            <a href="#">
              <img src={imageList["Twitter"]} alt="Twitter" />
            </a>
            <a href="#">
              <img src={imageList["Linkedin"]} alt="Linkedin" />
            </a>
            <a href="#">
              <img src={imageList["Instagram"]} alt="Instagram" />
            </a>
            <a href="#">
              <img src={imageList["Youtube"]} alt="Youtube" />
            </a>
          </div>
        </div>
        <div className="footer-section">
          <h3>About</h3>
          <ul>
            <li>About Us</li>
            <li>Find store</li>
            <li>Categories</li>
            <li>Blogs</li>
          </ul>
        </div>
        <div className="footer-section">
          <h3>Partnership</h3>
          <ul>
            <li>About Us</li>
            <li>Find store</li>
            <li>Categories</li>
            <li>Blogs</li>
          </ul>
        </div>
        <div className="footer-section">
          <h3>Information</h3>
          <ul>
            <li>Help Center</li>
            <li>Money Refund</li>
            <li>Shipping</li>
            <li>Contact us</li>
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
            <img src={imageList["App-Store"]} alt="App Store" />
          </a>
          <a href="#">
            <img src={imageList["Google-Play"]} alt="Google Play" />
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
