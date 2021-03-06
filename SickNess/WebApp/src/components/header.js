import React, { Component } from 'react';
import { withRouter, NavLink } from "react-router-dom";
import "./header.css";
import PropTypes from "proptypes";
import { Menu, Dropdown, Icon } from 'antd';
import emitter from '../event';
/**
 * props: user: 用户登录信息
 */
class Header extends Component {

    state = {
        isLogin: false,
        loginType: 0,
    }

    componentDidMount() {
        // props
        let isLogin = this.props.isLogin;
        this.setState({ isLogin })
    }

    componentWillReceiveProps(nextProps) {
        console.log("props更新：")
        console.log(nextProps);
        this.setState({ isLogin: nextProps.isLogin, loginType: nextProps.loginType });
    }

    userLogout = (e) => {
        emitter.emit("userLogout");
    }

    renderTarget = (e) => {
        e.preventDefault();
        // let { isLogin } = this.state;
        // const history = this.context.router.history;
        // if(isLogin) {
        //     history.push();
        // }
    }

    renderPersonalCenter = () => {
        let { isLogin } = this.state;
        if (isLogin) {
            let menu = (
                <Menu>
                    <Menu.Item rel="noreferrer" href="javascript:void(0);">
                        <NavLink to="/user">我的资料</NavLink>
                    </Menu.Item>
                    <Menu.Item rel="noreferrer" href="javascript:void(0);">
                        <NavLink to="/resetPwd">修改密码</NavLink>
                    </Menu.Item>
                    <Menu.Item rel="noreferrer" onClick={this.userLogout} href="javascript:void(0);">
                        退出登录
                    </Menu.Item>
                </Menu>);
            return (
                <Dropdown overlay={menu} overlayClassName="dropdown-menu-item">
                    <a href="#" onClick={this.renderTarget}>
                        个人中心
                    </a>
                </Dropdown>
            );
        } else {
            return (
                <NavLink to="/login">登录</NavLink>
            );
        }
    }

    renderUserMenu = () => {
        return (
            <ul className="user-h">
                <li>
                    区域疾病监控系统
                    </li>
                <li>
                    <NavLink to="/index" activeClassName="index_menu_li_Color">首页</NavLink>
                </li>
                <li>
                    <NavLink to="/knowledge" activeClassName="index_menu_li_Color">疾病知识</NavLink>
                </li>
                <li>
                    <NavLink to="/feedback" activeClassName="index_menu_li_Color">反馈</NavLink>
                </li>
                <li>
                    <NavLink to="/consult" activeClassName="index_menu_li_Color">咨询</NavLink>
                </li>
                <li>
                    {this.renderPersonalCenter()}
                </li>
            </ul>
        );
    }

    renderManagerMenu = () => {
        return (
            <ul className="manager-h">
                <li>
                    区域疾病监控系统
                    </li>
                <li>
                    <NavLink to="/index" activeClassName="index_menu_li_Color">首页</NavLink>
                </li>
                <li>
                    <NavLink to="/sickerConsult" activeClassName="index_menu_li_Color">病人咨询</NavLink>
                </li>
                <li>
                    <NavLink to="/dataSubmit" activeClassName="index_menu_li_Color">数据上传</NavLink>
                </li>
                <li>
                    <NavLink to="/dataCheck" activeClassName="index_menu_li_Color">上传信息审核</NavLink>
                </li>
                {/* <li>
                    <NavLink to="/knowledgePublish" activeClassName="index_menu_li_Color">疾病知识发布</NavLink>
                </li> */}
                <li>
                    {this.renderPersonalCenter()}
                </li>
            </ul>
        )
    }

    renderSuperManagerMenu = () => {
        return (
            <ul className="superManager-h">
                <li>
                    区域疾病监控系统
                    </li>
                <li>
                    <NavLink to="/index" activeClassName="index_menu_li_Color">首页</NavLink>
                </li>
                <li>
                    <NavLink to="/knowledge" activeClassName="index_menu_li_Color">疾病知识</NavLink>
                </li>
                <li>
                    <NavLink to="/feedback" activeClassName="index_menu_li_Color">反馈</NavLink>
                </li>
                <li>
                    <NavLink to="/consult" activeClassName="index_menu_li_Color">咨询</NavLink>
                </li>
                <li>
                    {this.renderPersonalCenter()}
                </li>
            </ul>
        )
    }

    render() {
        return (
            <section className="menu_list">
                {
                    this.state.loginType <= 1 ? 
                    this.renderUserMenu() : 
                    this.state.loginType == 2 ? 
                    this.renderManagerMenu() : 
                    this.renderSuperManagerMenu()
                }
            </section>
        )
    }
}
Header.contextTypes = {
    router: PropTypes.object.isRequired
};
export default withRouter(Header);