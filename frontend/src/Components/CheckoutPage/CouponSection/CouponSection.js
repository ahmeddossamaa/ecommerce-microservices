import React from "react";
import "./CouponSection.css";

function CouponSection() {
  return (
    <div className="coupon-section">
      <p>Have a coupon?</p>
      <input type="text" placeholder="Enter coupon code" />
      <button>Apply</button>
    </div>
  );
}

export default CouponSection;
