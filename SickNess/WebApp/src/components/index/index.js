import React, { Component } from 'react';
import { Carousel, Menu } from 'antd';
import img1 from '../../images/1.jpg';
import img2 from '../../images/2.jpg';
import img3 from '../../images/3.jpg';
import './index.css';

class Index extends Component {

    state = {

    }

    render() {
        
        return (
            <div>
                <Carousel autoplay>
                    <div><img src={img1} /></div>
                    <div><img src={img2} /></div>
                    <div><img src={img3} /></div>
                </Carousel>
            </div>
        )
    }

}

export default Index;