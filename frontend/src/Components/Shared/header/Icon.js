import React from "react";

const Icon = ({ name, icon, link }) => {
  return (
    <div className="icon">
      <a href={link}>
        <img src={icon} alt={name} />
      </a>
      <span>{name}</span>
    </div>
  );
};

export default Icon;
