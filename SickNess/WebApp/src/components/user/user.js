import React, { Component } from 'react';
import { Form, Input, Button, Radio, DatePicker } from 'antd';
import request from "../../utils/request";
import { withRouter, NavLink } from 'react-router-dom';
import emitter from '../../event';
import PropTypes from "proptypes";
import "./user.css"
import FormItem from 'antd/lib/form/FormItem';
import moment from 'moment';
import RadioGroup from 'antd/lib/radio/group';
import locale from 'antd/lib/date-picker/locale/zh_CN';
import 'moment/locale/zh-cn';
moment.locale('zh-cn');
class User extends Component {

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
                {/* `account` '用户账号',
            `home_address`  '住家庭址',
            `work_address` '工作地址',
            `email`  '电子邮箱',
            `area_id`  '地区id', */}
                <Form {...formItemLayout} onReset={() => { this.props.form.resetFields() }}>
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