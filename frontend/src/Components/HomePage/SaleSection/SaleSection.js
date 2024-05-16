import React, { useState, useEffect } from "react";
import "./SaleSection.css";
const images = require.context(
  "../../../Assets/Components/HomePage/SaleSection",
  true
);
const imageList = images.keys().reduce((acc, image) => {
  const name = image.split("./")[1].split(".")[0];
  acc[name] = images(image);
  return acc;
}, {});

const SaleSection = () => {
  const calculateTimeLeft = () => {
    const difference = +new Date("2024-05-09") - +new Date();
    let timeLeft = {};

    if (difference > 0) {
      timeLeft = {
        days: Math.floor(difference / (1000 * 60 * 60 * 24)),
        hour: Math.floor((difference / (1000 * 60 * 60)) % 24),
        min: Math.floor((difference / 1000 / 60) % 60),
        sec: Math.floor((difference / 1000) % 60),
      };
    }

    return timeLeft;
  };

  const [timeLeft, setTimeLeft] = useState(calculateTimeLeft());

  useEffect(() => {
    const timer = setTimeout(() => {
      setTimeLeft(calculateTimeLeft());
    }, 1000);

    return () => clearTimeout(timer);
  });

  const timerComponents = [];

  Object.keys(timeLeft).forEach((interval) => {
    if (!timeLeft[interval]) {
      return;
    }

    timerComponents.push(
      <div className="timer-item" key={interval}>
        <span>{timeLeft[interval]}</span> {interval}
      </div>
    );
  });

  return (
    <div className="sale-section">
      <div className="countdown-section">
        <h3>Deals and offers</h3>
        <p>Hygiene equipments</p>
        <div className="countdown-timer">
          {timerComponents.length ? timerComponents : <span>Time's up!</span>}
        </div>
      </div>
      {Object.keys(imageList).map((imageName, index) => (
        <div className="category-item" key={index}>
          <img src={imageList[imageName]} alt={imageName} />
          <h3>{imageName}</h3>
          <div className="discount-badge">-{(index + 1) * 10}%</div>
        </div>
      ))}
    </div>
  );
};

export default SaleSection;
