// BlockItemsGroup.js

import React from "react";
import "./BlockItemsGroup.css";
const images = require.context("./assets", true);
const imageList = images.keys().map((image) => images(image));

const BlockItemsGroup = () => {
  return (
    <div className="block-items-group">
      <div className="block-image">
        <img src={imageList[8]} alt="Block alt" />
        <div className="image-content">
          <h3>Title</h3>
          <button>Source now</button>
        </div>
      </div>
      {/* Repeat the block-item structure for each item */}
      {[...Array(8)].map((_, index) => (
        <div className="block-item" key={index}>
          <img src={imageList[index]} alt="Block alt" />
          <div className="block-content">
            <h3>Title {index + 1}</h3>
            <p>From</p>
            <span>USD 19</span>
          </div>
        </div>
      ))}
    </div>
  );
};

export default BlockItemsGroup;
