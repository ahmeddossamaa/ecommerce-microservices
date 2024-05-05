// HomePage.js
import Header from "../../Components/Shared/header/Header.js";
import Navbar from "../../Components/Shared/navbar/Navbar.js";
import FooterSection from "../../Components/Shared/FooterSection/FooterSection.js";
import MainSection from "../../Components/MainPage/MainSection/MainSection.js";
import SaleSection from "../../Components/MainPage/SaleSection/SaleSection.js";
import BlockItemsGroup from "../../Components/MainPage/BlockItemsGroup/BlockItemsGroup.js";

function HomePage() {
  return (
    <div className="HomePage">
      <Header />
      <Navbar />
      <MainSection />
      <SaleSection />
      <BlockItemsGroup />
      <FooterSection />
      {/* Other page content goes here */}
    </div>
  );
}

export default HomePage;
