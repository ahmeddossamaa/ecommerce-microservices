// App.js
import "./App.css";
import Header from "./Pages/Components/Shared/header/Header.js";
import Navbar from "./Pages/Components/Shared/navbar/Navbar.js";
import FooterSection from "./Pages/Components/Shared/FooterSection/FooterSection.js";
import MainSection from "./Pages/Components/MainPage/MainSection/MainSection.js";
import SaleSection from "./Pages/Components/MainPage/SaleSection/SaleSection.js";
import BlockItemsGroup from "./Pages/Components/MainPage/BlockItemsGroup/BlockItemsGroup.js";

function App() {
  return (
    <div className="App">
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

export default App;
