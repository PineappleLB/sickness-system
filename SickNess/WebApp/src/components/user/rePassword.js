import React, { Component } from 'react';
import { Form, Input, Button } from 'antd';
// import request from "../../utils/request";
import { withRouter } from 'react-router-dom';
import PropTypes from "proptypes";
import "./rePassword.css"
import moment from 'moment';
import 'moment/locale/zh-cn';
moment.locale('zh-cn');
class ResetPassword extends Component {

    formSubmit = (e) => {
        e.preventDefault();
    }

    checkRePassword = (rule, value, callback) => {
        const { getFieldValue } = this.props.form
        if (value && value !== getFieldValue('newPwd')) {
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
            <div className="resetPassword">
                <Form {...formItemLayout} onSubmit={this.formSubmit} onReset={() => { this.props.form.resetFields() }}>
                    <h1>重置密码</h1>
                    <Form.Item label="用户账号">
                        <Input disabled value={"123123"} />
                    </Form.Item>
                    <Form.Item label="原密码">
                        {getFieldDecorator('password', {
                            rules: [{
                                required: true,
                                message: '请输入您的原密码！'
                            }]
                        })(
                            <Input placeholder="请输入您的原密码..." />
                        )}
                    </Form.Item>
                    <Form.Item label="新密码">
                        {getFieldDecorator('newPwd', {
                            rules: [{
                                required: true,
                                message: '请输入您的新密码！'
                            }]
                        })(
                            <Input placeholder="请输入您的新密码..." />
                        )}
                    </Form.Item>
                    <Form.Item label="再次输入密码">
                        {getFieldDecorator('repeatPwd', {
                            rules: [{
                                required: true,
                                message: '请输入您的新密码！'
                            },{
                                validator: this.checkRePassword,
                            }]
                        })(
                            <Input placeholder="请输入您的新密码..." />
                        )}
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">提交修改</Button>
                        <Button type="primary" htmlType="reset">重置表单</Button>
                    </Form.Item>
                </Form>
            </div>
        );
    }

}
ResetPassword.contextTypes = {
    router: PropTypes.object.isRequired
};
ResetPassword = Form.create({})(ResetPassword);
export default withRouter(ResetPassword);