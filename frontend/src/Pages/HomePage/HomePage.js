// HomePage.js
import Navbar from "../../Components/Shared/navbar/Navbar.js";
import MainSection from "../../Components/HomePage/MainSection/MainSection.js";
import SaleSection from "../../Components/HomePage/SaleSection/SaleSection.js";
import BlockItemsGroup from "../../Components/HomePage/BlockItemsGroup/BlockItemsGroup.js";
import { useEffect } from "react";
import axios from "axios";

function HomePage() {
  // useEffect(() => {
  //   axios.get("http://127.0.0.1:8080/api/products").then((data) => {
  //     console.log(data);
  //   });
  // });
  return (
    <div className="HomePage">
      <Navbar />
      <MainSection />
      <SaleSection />
      <BlockItemsGroup />
      {/* Other page content goes here */}
    </div>
  );
}

export default HomePage;
