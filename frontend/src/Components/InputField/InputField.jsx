// InputField.js
import React from 'react';
import './InputField.css';

const InputField = ({ icon, type, name, value, onChange, onBlur, placeholder, error }) => (
   <div className="input-container">
    <div className="ico-in">
    <label className="input-icon">
      <img src={icon} alt="" />
    </label>
    <input
      type={type}
      name={name}
      value={value}
      onChange={onChange}
      onBlur={onBlur}
      placeholder={placeholder} />
    </div>
    <div className="line"></div>
    {error && <small style={{ color: 'red' }}>{error}</small>}
  </div>
);

export default InputField;