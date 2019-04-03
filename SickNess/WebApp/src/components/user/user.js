import React, { Component } from 'react';
import { Form, Input, Button, Radio, DatePicker, Cascader } from 'antd';
// import request from "../../utils/request";
import { withRouter, NavLink } from 'react-router-dom';
import emitter from '../../event';
import PropTypes from "proptypes";
import "./user.css"
import moment from 'moment';
import RadioGroup from 'antd/lib/radio/group';
import locale from 'antd/lib/date-picker/locale/zh_CN';
import 'moment/locale/zh-cn';
import options from '../../utils/cascader-address-options';
moment.locale('zh-cn');
class User extends Component {

    formSubmit = (e) => {
        
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
            <div className="user">
                <Form {...formItemLayout} onSubmit={this.formSubmit} onReset={() => { this.props.form.resetFields() }}>
                    <h1>个人中心</h1>
                    <Form.Item label="用户账号">
                        <Input disabled value={"123123"} />
                    </Form.Item>
                    <Form.Item label="真实姓名">
                        {getFieldDecorator('userRealName', {
                            rules: [{
                                required: true,
                                message: '请输入您的真实姓名...',
                            }],
                        })(
                            <Input placeholder="请输入真实姓名..." />
                        )}
                    </Form.Item>
                    <Form.Item label="用户性别">
                        {getFieldDecorator('gender', {
                            initialValue: 1,
                        })(
                            <RadioGroup >
                                <Radio value={1}>男</Radio>
                                <Radio value={2}>女</Radio>
                            </RadioGroup>
                        )}
                    </Form.Item>
                    <Form.Item label="出生日期">
                        {getFieldDecorator('birthday', {
                            initialValue: moment(new Date(), 'YYYY-MM-DD')
                        })(
                            <DatePicker locale={locale} placeholder="请选择您的出生日期..." />
                        )}
                    </Form.Item>
                    <Form.Item label="联系方式">
                        {getFieldDecorator('contact', {
                            rules: [{
                                required: true,
                                message: '请输入您的手机号码！'
                            },{
                                pattern: /^1[3456789]\d{9}$/,
                                message: '请输入正确的手机号！'
                            }]
                        })(
                            <Input locale={locale} placeholder="请输入您的手机号码..." />
                        )}
                    </Form.Item>
                    <Form.Item label="省市地区">
                        {getFieldDecorator('area')(
                            <Cascader allowClear={true} options={options} placeholder="请选择您所在的省市地区..." />
                        )}
                    </Form.Item>
                    <Form.Item label="居住地址">
                        {getFieldDecorator('homeAddress')(
                            <Input placeholder="请输入您的居住地址..." />
                        )}
                    </Form.Item>
                    <Form.Item label="工作地址">
                        {getFieldDecorator('workAddress')(
                            <Input placeholder="请输入您的工作地址..." />
                        )}
                    </Form.Item>
                    <Form.Item label="电子邮箱">
                        {getFieldDecorator('email', {
                            rules: [{
                                type: 'email',
                                message: "请输入正确的邮箱地址"
                            }]
                        })(
                            <Input placeholder="请输入您的电子邮箱..." />
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
User.contextTypes = {
    router: PropTypes.object.isRequired
};
User = Form.create({})(User);
export default withRouter(User);