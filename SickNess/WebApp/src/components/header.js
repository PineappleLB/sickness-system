import React, { Component } from 'react';
import { NavLink } from "react-router-dom";
import "./header.css";
/**
 * props: user: 用户登录信息
 */
class Header extends Component{

    componentDidMount(){
        // props
    }

    render() {
        let user = this.props.user;
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
                    <NavLink to={user ? "/user" : "/login"} activeClassName="index_menu_li_Color">个人中心</NavLink>
                </li>
            </ul>

        </section>)
    }

}
export default Header;