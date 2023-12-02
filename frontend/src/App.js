import { AnimatePresence } from "framer-motion";
import { Route, Routes } from "react-router-dom";
import HomePage from "./Pages/HomePage";
import ProductPage from "./Pages/Products";



function App() {
  
  return (
    <AnimatePresence>
      <Routes>
        <Route path="/" element={<HomePage />} >
        </Route>
        <Route path="/products" element={<ProductPage />} >
        </Route>


      </Routes>
  </AnimatePresence>
  );
}

export default App;
