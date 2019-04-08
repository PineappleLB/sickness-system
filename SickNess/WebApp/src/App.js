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
import managerLogin from './components/manager/login/managerLogin';
import superManagerLogin from './components/manager/login/superManagerLogin';

let sessionUser = Utils.getUser();
let sessionManager = Utils.getManager();
let sessionSuperManager = Utils.getSuperManager();
function About() {
  return <h2>About</h2>;
}
class App extends Component {

  state = {
    user: sessionUser,
    manager: sessionManager,
    superManager: sessionSuperManager,
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
    this.eventEmitter = emitter.addListener("managerLogin", (managerInfo) => {
      console.log("emmiter:" + managerInfo)
      if (managerInfo != null) {
        this.setState({
          manager: managerInfo,
        });
      }
    });
    this.eventEmitter = emitter.addListener("superManagerLogin", (superManagerInfo) => {
      console.log("emmiter:" + superManagerInfo)
      if (superManagerInfo != null) {
        this.setState({
          superManager: superManagerInfo,
        });
      }
    });
    this.eventEmitter = emitter.addListener("logout", () => {
      this.setState({
        user: null,
        manager: null,
        superManager: null,
      });
    });
  }

  render() {
    let { user, manager, superManager } = this.state;
    let isLogin = user || manager || superManager;
    let loginType = superManager ? 3 : manager ? 2 : user ? 1 : 0;
    return (
      <div className="app">
        <Router>
          <div>
            <Header isLogin={isLogin} loginType={loginType} />
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
                <Route path="/manager" component={managerLogin} />
                <Route path="/superManager" component={superManagerLogin} />
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