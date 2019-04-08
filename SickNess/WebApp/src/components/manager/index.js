import React, { Component } from 'react';
import { withRouter, NavLink } from "react-router-dom";
import "./header.css";
import PropTypes from "proptypes";
import { Menu, Dropdown, Icon } from 'antd';

class ManagerIndex extends Component {

    state = {
        isLogin: false,
    }

    componentWillMount(){

    }

    componentDidMount() {

    }



    render() {
        return (
            <div className="manager">

            </div>
        )
    }
}
ManagerIndex.contextTypes = {
    router: PropTypes.object.isRequired
};
export default withRouter(ManagerIndex);