import React, { useEffect } from "react";
import Product from "../../Components/CheckoutPage/Product/Product.js";
import CouponSection from "../../Components/CheckoutPage/CouponSection/CouponSection.js";
import PriceSection from "../../Components/CheckoutPage/PriceSection/PriceSection.js";
import DeliveryAdvantages from "../../Components/CheckoutPage/DeliveryAdvantages/DeliveryAdvantages.js";
import "./CheckoutPage.css";
const images = require.context("../../Assets/Pages/CheckoutPage", true);
const imageList = images.keys().map((image) => images(image));

function CheckoutPage() {
  return (
    <div>
      <h2>My Cart (3)</h2>
      <div className="checkout">
        <div className="products-cart">
          <div className="checkout-products">
            <Product />
            <Product />
            {/* Add more Product components here for each product */}
          </div>
          <div className="buttons">
            <button className="back-button">
              <img src={imageList[0]} alt="back-icon" /> Back to shop
            </button>
            <button className="remove-all-button">Remove all</button>
          </div>
        </div>
        <div className="right-section">
          <CouponSection />
          <PriceSection />
        </div>
      </div>
      <DeliveryAdvantages />
    </div>
  );
}

export default CheckoutPage;
