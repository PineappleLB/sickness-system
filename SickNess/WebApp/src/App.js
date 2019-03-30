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
import { Modal, Form, Input } from 'antd';
import Login from './components/login/login';

function About() {
  return <h2>About</h2>;
}

function Users() {
  return <h2>Users</h2>;
}
class App extends Component {

  state = {
    user: null,
    loginVisiable: false,
  }

  showLoginModal = () => {
    this.state.loginVisiable = true;
    console.log(1)
  }

  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <div className="app">
        <Router>
          <div>
            <Header isLogin={this.state.user != null} login={this.showLoginModal} />
            <div className="router_container">
              <ScrollToTop>
                <Route path="/" exact render={() => (<Redirect to='/index' />)} />
                <Route path="/index" component={Index} />
                <Route path="/about/" component={About} />
                <Route path="/users/" component={Users} />
                <Route path="/login/" component={Login} />
              </ScrollToTop>
            </div>
            <Footer />
          </div>
        </Router>
        <Modal
          title="登录"
          visible={this.state.loginVisiable}
          onOk={() => {this.setState({loginVisiable: false})}}
          onCancel={() => {this.setState({loginVisiable: false})}}
        >
          <Form onSubmit={this.loginSubmit}>
            <Form.Item label="手机号">
              {getFieldDecorator('account')(
                <Input type="text" />
              )}
            </Form.Item>
            <Form.Item label="密码">
              {getFieldDecorator('pasword')(
                <Input.Password type="password" />
              )}
            </Form.Item>

          </Form>
        </Modal>
      </div>
    );
  }
}

App = Form.create({})(App);
App.contextTypes = {
  router: PropTypes.object.isRequired
};
export default App;