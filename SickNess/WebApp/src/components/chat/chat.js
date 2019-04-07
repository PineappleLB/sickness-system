import React, { Component } from 'react';
import { withRouter, NavLink } from "react-router-dom";
import "./chat.css";
import PropTypes from "proptypes";
import { Menu, message, Icon, Row, Col, List, Avatar, Input, Button } from 'antd';

class Chat extends Component {

    state = {
        msg: '',
        messageList: [],
    }

    componentWillMount() {
        let dockerId = this.props.match.params.dockerId;
    }

    componentDidMount() {
        let data = [
            {
                user: 1,
                title: 'Ant Design, a design language for background applications, is refined by Ant UED Team',
            },
            {
                user: 0,
                title: 'Ant Design, a design language for background applications, is refined by Ant UED Team',
            },
            {
                user: 1,
                title: 'Ant Design, a design language for background applications',
            },
            {
                user: 0,
                title: 'Ant Design, a design language for background applications, is refined by AnAnt Design, a design language for background applications, is refined by Ant UED TeamAnt Design, a design language for background applications, is refined by Ant UED Teamt UED Team',
            },
        ];
        this.setState({ messageList: data });
    }

    sendMessage = () => {
        let { msg, messageList } = this.state;
        if(!msg || msg == "") {
            message.info("消息不能为空！")
            return;
        }
        messageList.push({
            user: 0,
            title: msg
        });
        this.setState({ messageList, msg: '' });
    }

    keyDown = (e) => {
        if (e.keyCode == 13 || e.keyCode == 108) {
            this.sendMessage();
        }
    }

    messageChange = (e) => {
        let value = e.target.value || "";
        value = value.replace(/[\r\n]/g, '');
        this.setState({ msg: value })
    }

    render() {
        const IconText = ({ type, text, className = "" }) => (
            <span>
                <Icon className={className} type={type} style={{ marginRight: 8 }} />
                {text}
            </span>
        );
        return (
            <div className="chat">
                <Row>
                    <Col span={18} offset={3}>
                        <div className="chatBox">
                            <Row>
                                <Col span={6}>
                                    <div className="base">
                                        <div>医生姓名：xx医生</div>
                                        <div>医生简介：xx医生是来自xxx医院的一名主任医师，拥有二十多年的从医经验</div>
                                        <div><IconText className="online" type="aliwangwang" text="在线" /></div>
                                    </div>
                                </Col>
                                <Col span={18}>
                                    <div className="messageBox">
                                        <List
                                            itemLayout="horizontal"
                                            dataSource={this.state.messageList}
                                            renderItem={item => (
                                                <List.Item>
                                                    <List.Item.Meta
                                                        avatar={<Avatar icon={item.user == 1 ? "aliwangwang" : "user"} />}
                                                        // title={<NavLink to={"/onlineChat/1"}>{item.title}</NavLink>}
                                                        description={item.title}
                                                    />
                                                </List.Item>
                                            )}
                                        />
                                    </div>
                                    <Input.TextArea placeholder="输入消息，按回车键发送..." value={this.state.msg} onKeyDown={this.keyDown} onChange={this.messageChange} />
                                </Col>
                            </Row>
                        </div>
                    </Col>
                </Row>
            </div>
        )
    }
}
Chat.contextTypes = {
    router: PropTypes.object.isRequired
};
export default withRouter(Chat);