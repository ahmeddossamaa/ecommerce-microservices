import React from "react";
import "./DeliveryAdvantages.css";

const images = require.context(
  "../../../Assets/Components/CheckoutPage/DeliveryAdvantages",
  true
);
const imageList = images.keys().reduce((acc, image) => {
  const name = image.split("./")[1].split(".")[0];
  acc[name] = images(image);
  return acc;
}, {});

function DeliveryAdvantages() {
  return (
    <div className="delivery-advantages">
      <div className="advantage-item">
        <div className="icon-background">
          <img src={imageList["secure_payment"]} alt="" />
        </div>
        <div className="advantage-text">
          <div className="title">Secure payment</div>
          <div className="description">Have you ever finally just</div>
        </div>
      </div>
      <div className="advantage-item">
        <div className="icon-background">
          <img src={imageList["customer_support"]} alt="" />
        </div>
        <div className="advantage-text">
          <div className="title">Customer support</div>
          <div className="description">Have you ever finally just</div>
        </div>
      </div>
      <div className="advantage-item">
        <div className="icon-background">
          <img src={imageList["free_delivery"]} alt="" />
        </div>
        <div className="advantage-text">
          <div className="title">Free delivery</div>
          <div className="description">Have you ever finally just</div>
        </div>
      </div>
    </div>
  );
}

export default DeliveryAdvantages;
