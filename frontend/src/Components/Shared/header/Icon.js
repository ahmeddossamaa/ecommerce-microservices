import React from "react";

const Icon = ({ name, icon }) => {
  return (
    <div className="icon">
      <a href="">
        <img src={icon} alt={name} />
      </a>
      <span>{name}</span>
    </div>
  );
};

export default Icon;
