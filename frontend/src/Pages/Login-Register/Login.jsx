import { useState } from "react";
import "./Style.css";
import InputField from "../../Components/InputField/InputField";
import loginImg from "../../Assets/Login-Register/signin-image.jpg";
import passwordIcon from "../../Assets/Login-Register/secure.png";
import mailIcon from "../../Assets/Login-Register/mail.png"
import { Link } from "react-router-dom";
import ValidateField from "../../utils/utils";

const Login = () => {
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);

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
    <div className="image-container">
      <img src={loginImg} alt="Sign in" />
      <Link to="/register" className="image-link">new? Register</Link>
    </div>
    <form className="signin-form" onSubmit={handleSubmit}>
      <h2 className="signin-title">Sign Up</h2>
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
      <div className="checkbox-container">
        <input
          type="checkbox"
          name="agree-term"
          id="agree-term"
          className="agree-term"
        />
        <label htmlFor="agree-term" className="label-agree-term">
          <span><span></span></span>
          remember me.
        </label>
      </div>
      <div className="form-button">
        <input
          type="submit"
          name="signin"
          id="signin"
          className="form-submit"
          value="Log in"
          disabled={Object.values(formErrors).some(error => error !== undefined) || isSubmit}
        />
      </div>
    </form>
</div>

  );
};

export default Login;
