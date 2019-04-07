import React, { Component } from 'react';
import { withRouter, NavLink } from "react-router-dom";
import "./feedback.css";
import PropTypes from "proptypes";
import { Table, Dropdown, Icon, Row, Col, Form, Select, Input, Button } from 'antd';

class FeedBack extends Component {

    state = {
        isLogin: false,
        list: [],
        loading: false,
        pagination: {},
    }
    componentDidMount() {
        // props
        // let isLogin = this.props.isLogin;
        // this.setState({ isLogin })
    }


    handlerFeedBackTableChange = (e) => {

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
        let columns = [
            {
                title: '序号',
                dataIndex: 'no',
            },
            {
                title: '疾病分类',
                dataIndex: 'builderName',
            },
            {
                title: '详情描述',
                dataIndex: 'legalPerson',
            },
            {
                title: '审核状态',
                dataIndex: 'builderIDCard',
            },
            {
                title: '操作',
                dataIndex: 'builderId',
            },
        ];

        return (
            <div className="feedback">
                <Row>
                    <Col span={20} offset={2}>
                        <Form {...formItemLayout} onSubmit={this.formSubmit} onReset={() => { this.props.form.resetFields() }}>
                            <Row>
                                <Col span={10}>
                                    <Form.Item label="疾病分类">
                                        {getFieldDecorator('sickType')(
                                            <Select placeholder="请选择疾病分类...">
                                                <Select.Option value={"天花病毒"}>天花病毒</Select.Option>
                                                <Select.Option value={"狂犬病毒"}>狂犬病毒</Select.Option>
                                                <Select.Option value={"链球菌"}>链球菌</Select.Option>
                                            </Select>
                                        )}
                                    </Form.Item>
                                </Col>
                                <Col span={10}>
                                    <Form.Item label="详情描述">
                                        {getFieldDecorator('sickDetail')(
                                            <Input placeholder="请输入详细的疾病描述..." />
                                        )}
                                    </Form.Item>
                                </Col>
                                <Col span={4}>
                                    <Form.Item>
                                        <Button>提交</Button>
                                        <Button>重置</Button>
                                    </Form.Item>
                                </Col>
                            </Row>

                        </Form>
                        <Table
                            bordered
                            columns={columns}
                            loading={this.state.loading}
                            dataSource={this.state.list}
                            onChange={this.handlerFeedBackTableChange}
                            pagination={{ total: this.state.pagination.total, current: this.state.pagination.current, pageSize: this.state.pagination.pageSize, showTotal: () => `共 ${this.state.pagination.total} 条记录` }}
                        />
                    </Col>
                </Row>
            </div>
        )
    }
}

FeedBack.contextTypes = {
    router: PropTypes.object.isRequired
};
FeedBack = Form.create({})(FeedBack);
export default withRouter(FeedBack);