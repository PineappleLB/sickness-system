import React, { Component } from 'react';
import { withRouter, NavLink } from "react-router-dom";
import "./consult.css";
import PropTypes from "proptypes";
import { Menu, Dropdown, Icon, Form, List, Avatar, Row, Col } from 'antd';

class Consult extends Component {

    state = {
        isLogin: false,
    }
    componentDidMount() {
        // props
        // let isLogin = this.props.isLogin;
        // this.setState({ isLogin })
    }

    // userLogout = (e) => {
    //     emitter.emit("userLogout");
    // }


    render() {
        const data = [
            {
                title: '医生 Title 1',
            },
            {
                title: '医生 Title 2',
            },
            {
                title: '医生 Title 3',
            },
            {
                title: '医生 Title 4',
            },
        ];
        const IconText = ({ type, text, className }) => (
            <span>
                <Icon className={className} type={type} style={{ marginRight: 8 }} />
                {text}
            </span>
        );
        return (
            <div className="consult">
                <Row>
                    <Col span={14} offset={5}>
                        <List
                            itemLayout="horizontal"
                            dataSource={data}
                            renderItem={item => (
                                <List.Item
                                actions={[<IconText className="online" type="aliwangwang" text="在线" />]}>
                                    <List.Item.Meta
                                        // avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />}
                                        title={<NavLink to={"/onlineChat/1"}>{item.title}</NavLink>}
                                        description="Ant Design, a design language for background applications, is refined by Ant UED Team"
                                    />
                                </List.Item>
                            )}
                        />
                    </Col>
                </Row>


            </div>
        )
    }
}
Consult.contextTypes = {
    router: PropTypes.object.isRequired
};
export default withRouter(Consult);