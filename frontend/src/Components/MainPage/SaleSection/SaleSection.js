import React from "react";
import "./SaleSection.css";
const images = require.context("./assets", true);
const imageList = images.keys().map((image) => images(image));
const SaleSection = () => {
  return (
    <div className="sale-section">
      <div className="countdown-section">
        <h3>Deals and offers</h3>
        <p>Hygiene equipments</p>
        <div className="countdown-timer">
          <div className="timer-item">
            <div className="days-count">10</div>
            <div className="days">Days</div>
          </div>
          <div className="timer-item">
            <span>05</span>
            <span>Hour</span>
          </div>
          <div className="timer-item">
            <span>30</span>
            <span>Min</span>
          </div>
          <div className="timer-item">
            <span>45</span>
            <span>Sec</span>
          </div>
        </div>
      </div>
      {/* <div className="categories-section"> */}
      {/* <div className="category-items"> */}
      {/* Map through categories and render items */}
      {[...Array(5)].map((_, index) => (
        <div className="category-item" key={index}>
          <img src={imageList[index]} alt={`Category ${index + 1}`} />
          <h3>Category {index + 1}</h3>
          <div className="discount-badge">-50%</div>
        </div>
      ))}
      {/* </div> */}
      {/* </div> */}
    </div>
  );
};

export default SaleSection;
