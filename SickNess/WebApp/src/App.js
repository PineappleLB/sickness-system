import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Redirect } from "react-router";
import ScrollToTop from './ScrollToTop';
import PropTypes from "proptypes";
import Index from "./components/index/index";
import './App.css';
import Header from './components/header';
import Footer from './components/footer';
import Login from './components/login/login';
import Regist from './components/regist/regist';
import emitter from './event';
import Utils from './utils/appUtils';
import User from './components/user/user';
import ResetPassword from './components/user/rePassword';
import FeedBack from './components/feedback/feedback';
import Consult from './components/consult/consult';
import Chat from './components/chat/chat';
import knowledge from './components/knowledge/knowledge';

let sessionUser = Utils.getUser();
function About() {
  return <h2>About</h2>;
}
class App extends Component {

  state = {
    user: sessionUser,
  }

  componentDidMount() {
    this.eventEmitter = emitter.addListener("userLogin", (userInfo) => {
      console.log("emmiter:" + userInfo)
      if (userInfo != null) {
        this.setState({
          user: userInfo,
        });
      }
    });
    this.eventEmitter = emitter.addListener("userLogout", () => {
      this.setState({
        user: null,
      });
    });
  }

  render() {
    return (
      <div className="app">
        <Router>
          <div>
            <Header isLogin={this.state.user != null} />
            <div className="router_container">
              <ScrollToTop>
                <Route path="/" exact render={() => (<Redirect to='/index' />)} />
                <Route path="/index" component={Index} />
                <Route path="/about" component={About} />
                <Route path="/user" component={User} />
                <Route path="/login" component={Login} />
                <Route path="/regist" component={Regist} />
                <Route path="/feedback" component={FeedBack} />
                <Route path="/consult" component={Consult} />
                <Route path="/resetPwd" component={ResetPassword} />
                <Route path="/knowledge" component={knowledge} />
                <Route path="/onlineChat/:dockerId" component={Chat} />
              </ScrollToTop>
            </div>
            <Footer />
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