import React from "react";

const Icon = ({ name, icon }) => {
  return (
    <div className="icon">
      <img src={icon} alt={name} />
      <span>{name}</span>
    </div>
  );
};

export default Icon;
