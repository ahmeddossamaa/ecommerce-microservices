import React from "react";
import "./PriceSection.css";

const images = require.context(
  "../../../Assets/Components/CheckoutPage/PriceSection",
  true
);
const imageList = images.keys().reduce((acc, image) => {
  const name = image.split("./")[1].split(".")[0];
  acc[name] = images(image);
  return acc;
}, {});

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
        <img src={imageList["usa-express"]} alt="" className="usa-express" />
        <img src={imageList["mastercard"]} alt="" className="mastercard" />
        <img src={imageList["paypal"]} alt="" className="paypal" />
        <img src={imageList["visa"]} alt="" className="visa" />
        <img src={imageList["apple-pay"]} alt="" className="apple-pay" />
      </div>
    </div>
  );
}

export default PriceSection;
