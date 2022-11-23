import React from "react";
import ReactDOM from "react-dom";
import Header from './Header'
import Footer from "./Footer"
import Body from  "./Body"
import "./index.css";

const App= ()=> (
  
  <div>
    <Header text="Header"></Header>
    <Body Heading="Heading" body="content"></Body>
    <Footer text="Footer"></Footer>
  </div>
  
);
ReactDOM.render(<App />, document.getElementById("app"));
