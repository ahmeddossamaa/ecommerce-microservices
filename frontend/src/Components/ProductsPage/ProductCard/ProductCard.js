import React from "react";
import "./ProductCard.css";
const images = require.context("./assets", true);
const imageList = images.keys().map((image) => images(image));

function ProductCard() {
  return (
    <div className="product-card">
      <img src={imageList[0]} alt="Product 1" />
      <div className="product-details">
        <h3>Canon Camera EOS 2000, Black 10x zoom</h3>
        <div className="price">
          <span className="discounted-price">$998.00 </span>
          <span className="original-price">$1128.00</span>
        </div>
        <div className="orders-info">
          <div className="rating">
            <span className="rating">Rating: 4.5</span>
            <span className="rating-users">(200)</span>
          </div>
          <span className="orders-count">* 1000 order *</span>
          <span className="shipping">Free Shipping</span>
        </div>
        <p>
          Description: Lorem ipsum dolor sit amet consectetur adipisicing elit.
          Quas, quae.
        </p>
        <button className="add-to-basket">Add to Basket</button>
      </div>
    </div>
  );
}

export default ProductCard;
