import React, { Component } from 'react';
// import { message, Modal, Icon, Button, Input, Upload } from 'antd';
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Redirect } from "react-router";
import ScrollToTop from './ScrollToTop';
import PropTypes from "proptypes";
import Index from "./components/index/index";
import './App.css';
import Header from './components/header';
import Footer from './components/footer';

function About() {
  return <h2>About</h2>;
}

function Users() {
  return <h2>Users</h2>;
}
class App extends Component {

  render() {
    return (
      <div className="app">

        <Router>
          <div>
            <Header />
            <div className="router_container">
              <ScrollToTop>
                <Route path="/" exact render={() => (<Redirect to='/index' />)} />
                <Route path="/index" component={Index} />
                <Route path="/about/" component={About} />
                <Route path="/users/" component={Users} />
              </ScrollToTop>
            </div>
            <Footer/>
          </div>
        </Router>
      </div>
    );
  }
}

App.contextTypes = {
  router: PropTypes.object.isRequired
};
export default App;