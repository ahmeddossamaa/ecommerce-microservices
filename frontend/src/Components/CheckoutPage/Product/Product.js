import React from "react";
import "./Product.css";
const images = require.context("./assets", true);
const imageList = images.keys().map((image) => images(image));

function Product() {
  return (
    <>
      <div className="product-item">
        <div className="details-side">
          <div className="product-image">
            <img src={imageList[0]} alt="Product 1" />
          </div>
          <div className="product-info">
            <h3>T-shirts with multiple colors, for men and lady</h3>
            <div>Size: Medium, Color: Blue, Material: Cotton</div>
            <p>Seller: Artel Market</p>
            <div className="product-actions">
              <button className="remove">Remove</button>
              <button className="save-for-later">Save for Later</button>
            </div>
          </div>
        </div>
        <div className="product-quantity-info">
          <div className="product-price">$50</div>
          <select className="quantity">
            <option value="1">Qty: 1</option>
            <option value="2">Qty: 2</option>
            <option value="3">Qty: 3</option>
            <option value="4">Qty: 4</option>
            <option value="5">Qty: 5</option>
          </select>
        </div>
      </div>
      <hr />
    </>
  );
}

export default Product;
