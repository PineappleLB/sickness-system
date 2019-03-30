import React, { Component } from 'react';
import { NavLink } from "react-router-dom";
import "./header.css";
import { Menu, Dropdown, Icon } from 'antd';
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
    renderPersonalCenter = () => {
        if (this.state.isLogin) {
            return (
                <Menu>
                    <Menu.Item rel="noreferrer" href="javascript:void(0);">我的资料</Menu.Item>
                    <Menu.Item rel="noreferrer" href="javascript:void(0);">修改密码</Menu.Item>
                    <Menu.Item rel="noreferrer" href="javascript:void(0);">退出登录</Menu.Item>
                </Menu>
            );
        } else {
            return (
                <Menu>
                    <Menu.Item rel="noreferrer" onClick={this.props.login} href="javascript:void(0);">登录</Menu.Item>
                    <Menu.Item rel="noreferrer" href="javascript:void(0);">注册</Menu.Item>
                </Menu>
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
                        <Dropdown overlay={menu} overlayClassName="dropdown-menu-item">
                            <NavLink to={user ? "/user" : "/login"}>
                                个人中心
                            </NavLink>
                        </Dropdown>
                        {/* <NavLink to={user ? "/user" : "/login"} activeClassName="index_menu_li_Color">{
                        this.renderPersonalCenter()
                    }</NavLink> */}
                    </li>
                </ul>

            </section>)
    }

}
export default Header;