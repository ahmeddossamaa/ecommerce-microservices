import React, { useEffect, useState } from "react";
import axios from "axios";
import ProductCard from "../../Components/ProductsPage/ProductCard/ProductCard.js";
import Navbar from "../../Components/Shared/navbar/Navbar.js";
import "./ProductsPage.css";

function ProductPage() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get("http://127.0.0.1:8080/api/products");
        setProducts(response.data);
      } catch (error) {
        console.error("Failed to fetch products:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="product-page">
      <Navbar />
      <div className="products">
        {products.map((product) => (
          <ProductCard
            key={product.id}
            name={product.name}
            price={product.price}
            description={product.description}
          />
        ))}
      </div>
    </div>
  );
}

export default ProductPage;
