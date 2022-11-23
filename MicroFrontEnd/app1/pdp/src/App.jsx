import React from "react";
import ReactDOM from "react-dom";

import "./index.css";
import Header from "home/Header";
import Body from "home/Body";
import Footer from "home/Footer";

const App = () => (
  <div>
    <Header text="react">
    </Header>
    <Body Heading="Hello World" body="content"></Body>
    <Footer text="react"></Footer>
  </div>
);
ReactDOM.render(<App />, document.getElementById("app"));
