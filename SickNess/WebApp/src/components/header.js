import React, { Component } from 'react';
import { NavLink } from "react-router-dom";
import "./header.css";
import { Menu, Dropdown, Icon } from 'antd';
import emitter from '../event';
/**
 * props: user: 用户登录信息
 */
class Header extends Component {

    state = {
        isLogin: false,
    }
    componentDidMount() {
        // props
        let isLogin = this.props.isLogin;
        this.setState({ isLogin })
    }
    componentWillReceiveProps(nextProps) {
        console.log("props更新：")
        console.log(nextProps);
        this.setState({ isLogin: nextProps.isLogin });
    }

    userLogout = (e) => {
        emitter.emit("userLogout");
    }

    renderPersonalCenter = () => {
        let user = this.props.user;
        if (this.state.isLogin) {
            let menu = (
                <Menu>
                    <Menu.Item rel="noreferrer" href="javascript:void(0);">我的资料</Menu.Item>
                    <Menu.Item rel="noreferrer" href="javascript:void(0);">修改密码</Menu.Item>
                    <Menu.Item rel="noreferrer" onClick={this.userLogout} href="javascript:void(0);">退出登录</Menu.Item>
                </Menu>);
            return (
                <Dropdown overlay={menu} overlayClassName="dropdown-menu-item">
                    <NavLink to={user ? "/user" : "/login"}>
                        个人中心
                    </NavLink>
                </Dropdown>
            );
        } else {
            return (
                <NavLink to="/login">登录</NavLink>
            );
        }
    }

    render() {
        let user = this.props.user;
        let menu = this.renderPersonalCenter();
        return (
            <section className="menu_list">
                <ul>
                    <li>
                        区域疾病监控系统
                    </li>
                    <li>
                        <NavLink to="/index" activeClassName="index_menu_li_Color">首页</NavLink>
                    </li>
                    <li>
                        <NavLink to="/sick-knowledge" activeClassName="index_menu_li_Color">疾病知识</NavLink>
                    </li>
                    <li>
                        <NavLink to="/online-feedback" activeClassName="index_menu_li_Color">咨询反馈</NavLink>
                    </li>
                    <li>
                        <NavLink to="/data-upload" activeClassName="index_menu_li_Color">数据上传</NavLink>
                    </li>
                    <li>
                        <NavLink to="/data-analysis" activeClassName="index_menu_li_Color">数据分析</NavLink>
                    </li>
                    <li>
                        {this.renderPersonalCenter()}
                    </li>
                </ul>

            </section>)
    }

}
export default Header;