import React from "react";
import "./BlockItemsGroup.css";
const images = require.context(
  "../../../Assets/Components/HomePage/BlockItemsGroup",
  true
);
const imageList = images.keys().reduce((acc, image) => {
  const name = image.split("./")[1].split(".")[0];
  acc[name] = images(image);
  return acc;
}, {});

const BlockItemsGroup = () => {
  return (
    <div className="block-items-group">
      <div className="block-image">
        <img src={imageList["zblock-image"]} alt="Block alt" />
        <div className="image-content">
          <h3>Title</h3>
          <button>Source now</button>
        </div>
      </div>
      {Object.keys(imageList)
        .slice(0, 8)
        .map((imageName, index) => (
          <div className="block-item" key={index}>
            <img src={imageList[imageName]} alt="Block alt" />
            <div className="block-content">
              <h3>{imageName}</h3>
              <p>From</p>
              <span>USD 19</span>
            </div>
          </div>
        ))}
    </div>
  );
};

export default BlockItemsGroup;
