import { useState } from "react";
import InputField from "../../Components/InputField/InputField"

import "./Style.css";
import nameIcon from "../../Assets/Login-Register/people.png";
import registerImg from "../../Assets/Login-Register/signin-image.jpg";
import passwordIcon from "../../Assets/Login-Register/secure.png";
import mailIcon from "../../Assets/Login-Register/mail.png"
import { Link } from "react-router-dom";
import ValidateField from "../../utils/utils";


const Register = () => {
  //states
  const [formData, setFormData] = useState({
    username: "",
    email: "",
    password: "",
    confirmPassword: "",
  });
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);

  //handlers
  const handleBlur = (event) => {
    const { name, value } = event.target;
    const error = ValidateField(name, value);
    setFormErrors({ ...formErrors, [name]: error });
  };
  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    setFormErrors(ValidateField(formData));
    setIsSubmit(true);
    console.log("Form Data:", formData);
  };

  return (
      <div className="container">
          <form className="signup-form" onSubmit={handleSubmit}>
            <h2 className="title">Sign Up</h2>
            <InputField
              icon={nameIcon}
              type="text"
              name="username"
              value={formData.username}
              onChange={handleChange}
              onBlur={handleBlur}
              placeholder="Username"
              error={formErrors.username}
            />
            <InputField
              icon={mailIcon}
              type="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              onBlur={handleBlur}
              placeholder="email@xxx.com"
              error={formErrors.email}
            />
            <InputField
              icon={passwordIcon}
              type="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              onBlur={handleBlur}
              placeholder="Password"
              error={formErrors.password}
            />
            <InputField
              icon={passwordIcon}
              type="password"
              name="confirmPassword"
              value={formData.confirmPassword}
              onChange={handleChange}
              onBlur={handleBlur}
              placeholder="Re-enter your password"
              error={formErrors.confirmPassword}
            />
            <div className="checkbox-container">
              <input
                type="checkbox"
                name="agree-term"
                id="agree-term"
                className="agree-term"
              />
              <label htmlFor="agree-term" className="label-agree-term">
                <span><span></span></span>
                I agree all statements in 
                <a href="#" className="term-service">Terms of service</a>
              </label>
            </div>
            <div className="form-button">
              <input
                type="submit"
                name="signup"
                id="signup"
                className="form-submit"
                value="Register"
                disabled={Object.values(formErrors).some(error => error !== undefined) || isSubmit}
              />
            </div>
          </form>
          <div className="image-container">
            <img src={registerImg} alt="Sign up" />
            <Link to="/login" className="image-link">I'm already member</Link>
          </div>
      </div>
  );
};


export default Register;
