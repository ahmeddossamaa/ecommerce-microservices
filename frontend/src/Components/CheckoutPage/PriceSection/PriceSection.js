import React from "react";
import "./PriceSection.css";
const images = require.context("./assets", true);
const imageList = images.keys().map((image) => images(image));

function PriceSection() {
  return (
    <div className="price-section">
      <div className="price-details">
        <p className="subtotal">
          Subtotal: <span>$150</span>
        </p>
        <p className="discount">
          Discount: <span>$0</span>
        </p>
        <p className="tax">
          Tax: <span>$0</span>
        </p>
      </div>
      <hr />
      <p className="total">
        Total: <span>$150</span>
      </p>
      <button>Checkout</button>
      <div className="payment-icons">
        <img src={imageList[2]} alt="" className="usa-express" />
        <img src={imageList[1]} alt="" className="mastercard" />
        <img src={imageList[3]} alt="" className="paypal" />
        <img src={imageList[4]} alt="" className="visa" />
        <img src={imageList[0]} alt="" className="apple-pay" />
      </div>
    </div>
  );
}

export default PriceSection;
