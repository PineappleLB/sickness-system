import React, { Component } from 'react';
import { withRouter, NavLink } from 'react-router-dom';
import { Form, Input, Button } from 'antd';
import PropTypes from "proptypes";
import request from "../../utils/request";
import emitter from '../../event';
import './login.css';

class Login extends Component {

    state = {
    }

    loginSubmit = (e) => {
        e.preventDefault();
        console.log(1)
        const { form: { validateFields } } = this.props;
        const history = this.context.router.history;
        validateFields((errors, values) => {
            if(errors) {
                console.log(errors)
                return;
            }
            sessionStorage.setItem("userInfo", JSON.stringify(values));
            emitter.emit("userLogin", values)
            history.push("/index");
        });
    }

    render() {
        const { getFieldDecorator } = this.props.form;
        const formItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span: 4 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 20 },
            },
        };
        return (
            <div className="loginContainer">
                <Form {...formItemLayout} onSubmit={this.loginSubmit} onReset={() => {this.props.form.resetFields()}}>
                    <h1>区域疾病监控系统登录</h1>
                    <Form.Item label="用户名">
                        {getFieldDecorator('account')(
                            <Input placeholder="请输入用户名..." />
                        )}
                    </Form.Item>
                    <Form.Item label="密  码">
                        {getFieldDecorator('pasword')(
                            <Input.Password placeholder="请输入密码..." />
                        )}
                    </Form.Item>
                    <Form.Item>
                        <div><NavLink to="/regist">没有账号？点此立即注册！</NavLink></div>
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">登录</Button>
                        <Button type="primary" htmlType="reset">重置</Button>
                    </Form.Item>
                </Form>
            </div>
        )
    }
}
Login.contextTypes = {
    router: PropTypes.object.isRequired
};
Login = Form.create({})(Login);
export default withRouter(Login);