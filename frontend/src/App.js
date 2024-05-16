// App.js
import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import HomePage from "./Pages/HomePage/HomePage.js";
import CheckoutPage from "./Pages/CheckoutPage/CheckoutPage.js";
import ProductPage from "./Pages/ProductsPage/ProductsPage.js";
import Register from "./Pages/Login-Register/Register.jsx";
import Login from "./Pages/Login-Register/Login.jsx";
import Header from "./Components/Shared/header/Header.js";
import FooterSection from "./Components/Shared/FooterSection/FooterSection.js";

function App() {
  return (
    <div>
      <Header />
      <Router>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/checkout" element={<CheckoutPage />} />
          <Route path="/products" element={<ProductPage />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </Router>
      <FooterSection />
    </div>
  );
}

export default App;
