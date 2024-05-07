import React from "react";
import "./ProductCard.css";
const images = require.context(
  "../../../Assets/Components/ProductPage/ProductCard",
  true
);
const imageList = images.keys().map((image) => images(image));

function ProductCard(props) {
  return (
    <div className="product-card">
      <img src={imageList[0]} alt="Product 1" />
      <div className="product-details">
        <h3>{props.name}</h3>
        <div className="price">
          <span className="discounted-price">$998.00 </span>
          <span className="original-price">{props.price}</span>
        </div>
        <div className="orders-info">
          <div className="rating">
            <span className="rating">Rating: 4.5</span>
            <span className="rating-users">(200)</span>
          </div>
          <span className="orders-count">* 1000 order *</span>
          <span className="shipping">Free Shipping</span>
        </div>
        <p>Description: {props.description}</p>
      </div>
      <button className="add-to-basket">Add to Basket</button>
    </div>
  );
}

export default ProductCard;
