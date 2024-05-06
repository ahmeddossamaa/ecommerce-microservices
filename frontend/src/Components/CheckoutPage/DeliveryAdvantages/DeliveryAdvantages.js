import React from "react";
import "./DeliveryAdvantages.css";
const images = require.context("./assets", true);
const imageList = images.keys().map((image) => images(image));

function DeliveryAdvantages() {
  return (
    <div className="delivery-advantages">
      <div className="advantage-item">
        <div className="icon-background">
          <img src={imageList[1]} alt="" />
        </div>
        <div className="advantage-text">
          <div className="title">Secure payment</div>
          <div className="description">Have you ever finally just</div>
        </div>
      </div>
      <div className="advantage-item">
        <div className="icon-background">
          <img src={imageList[0]} alt="" />
        </div>
        <div className="advantage-text">
          <div className="title">Customer support</div>
          <div className="description">Have you ever finally just</div>
        </div>
      </div>
      <div className="advantage-item">
        <div className="icon-background">
          <img src={imageList[2]} alt="" />
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
