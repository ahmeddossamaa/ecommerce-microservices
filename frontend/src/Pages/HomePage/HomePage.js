// HomePage.js
import Navbar from "../../Components/Shared/navbar/Navbar.js";
import MainSection from "../../Components/HomePage/MainSection/MainSection.js";
import SaleSection from "../../Components/HomePage/SaleSection/SaleSection.js";
import BlockItemsGroup from "../../Components/HomePage/BlockItemsGroup/BlockItemsGroup.js";

function HomePage() {
  return (
    <div className="HomePage">
      <Navbar />
      <MainSection />
      <SaleSection />
      <BlockItemsGroup />
    </div>
  );
}

export default HomePage;
