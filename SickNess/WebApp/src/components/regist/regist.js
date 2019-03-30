import React, { Component } from 'react';
import { withRouter, NavLink } from 'react-router-dom';
import { Form, Input, Button } from 'antd';
import PropTypes from "proptypes";
import request from "../../utils/request";
import './regist.css';

class Regist extends Component {

    state = {
    }

    loginSubmit = (e) => {
        e.preventDefault();
        // console.log(1)
        // const { form: { validateFields } } = this.props;
        // const history = this.context.router.history;
        // validateFields((errors, values) => {
        //     if(errors) {
        //         console.log(errors)
        //         return;
        //     }
        //     sessionStorage.setItem("userInfo", JSON.stringify(values));
        //     history.push("/index");
        // });
    }

    checkRePassword = (rule, value, callback) => {
        const { getFieldValue } = this.props.form
        if (value && value !== getFieldValue('password')) {
            callback('两次输入的密码不一致！')
        }
        // Note: 必须总是返回一个 callback，否则 validateFieldsAndScroll 无法响应
        callback()
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
            <div className="registContainer">
                <Form {...formItemLayout} onSubmit={this.loginSubmit} onReset={() => { this.props.form.resetFields() }}>
                    <h1>区域疾病监控系统注册</h1>
                    <Form.Item label="用户名">
                        {getFieldDecorator('account',{
                            rules: [{
                                required: true,
                                message: '请输入用于登录的用户名！',
                            }],
                        })(
                            <Input placeholder="请输入登录用户名..." />
                        )}
                    </Form.Item>
                    <Form.Item label="手机号">
                        {getFieldDecorator('phoneNo',{
                            rules: [{
                                required: true,
                                message: '请输入您的手机号码！',
                            }, {
                                pattern: /^1[3|4|5|8|9]\d{9}$/,
                                message: '请输入正确的手机号码！',
                            }],
                        })(
                            <Input placeholder="请输入本人手机号码..." />
                        )}
                    </Form.Item>
                    <Form.Item label="密  码">
                        {getFieldDecorator('password',{
                            rules: [{
                                required: true,
                                message: '请输入登录密码！',
                            }],
                        })(
                            <Input.Password placeholder="请输入登录密码..." />
                        )}
                    </Form.Item>
                    <Form.Item label="确认密码">
                        {getFieldDecorator('rePasword',{
                            rules: [{
                                required: true,
                                message: '请输入登录密码！',
                            }, {
                                validator: this.checkRePassword,
                                // message
                            }],
                        })(
                            <Input.Password placeholder="请再次输入密码..." />
                        )}
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">注册</Button>
                        <Button type="primary" htmlType="reset">重置</Button>
                        <Button type="primary"><NavLink to="/login">返回登录</NavLink></Button>
                    </Form.Item>
                </Form>
            </div>
        )
    }
}
Regist.contextTypes = {
    router: PropTypes.object.isRequired
};
Regist = Form.create({})(Regist);
export default withRouter(Regist);