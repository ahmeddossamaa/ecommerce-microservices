import React from "react";
import ProductCard from "../../Components/ProductsPage/ProductCard/ProductCard.js";
import Header from "../../Components/Shared/header/Header.js";
import Navbar from "../../Components/Shared/navbar/Navbar.js";
import FooterSection from "../../Components/Shared/FooterSection/FooterSection.js";
import "./ProductsPage.css";

function ProductPage() {
  return (
    <div className="product-page">
      <Header />
      <Navbar />
      <div className="products">
        <ProductCard />
        <ProductCard />
        <ProductCard />
        <ProductCard />
      </div>
      <FooterSection />
    </div>
  );
}

export default ProductPage;
