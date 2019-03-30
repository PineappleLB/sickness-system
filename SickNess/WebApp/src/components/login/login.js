import React, { Component } from 'react';
import { Form, Input, Button } from 'antd';
import request from "../../utils/request";
import './login.css';

class Login extends Component {

    state = {
    }

    loginSubmit = (e) => {
        e.preventDefault();
        console.log(1)
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
                <Form {...formItemLayout} onSubmit={this.loginSubmit}>
                    <h1>区域疾病监控系统登录</h1>
                    <Form.Item label="用户名">
                        {getFieldDecorator('account')(
                            <Input />
                        )}
                    </Form.Item>
                    <Form.Item label="密  码">
                        {getFieldDecorator('pasword')(
                            <Input.Password />
                        )}
                    </Form.Item>
                    <Form.Item>
                        <div><a href="/regist">没有账号？点此立即注册！</a></div>
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
Login = Form.create({})(Login);
export default Login;