import React,{ Component } from 'react';
import './clock.css';
import backgroundImg from '../../images/timg.jpg';

class Clock extends Component {
    state = {
        date: {}
    }

    componentWillMount() {
        this.intervalTime();
        setInterval(this.intervalTime, 1000)
    }

    intervalTime = () => {
        this.setState({
            date: new Date()
        })
    }

    render() {
        var date = this.state.date
        var minutes = date.getMinutes()
        var seconds = date.getSeconds()

        var hour = (date.getHours()) % 12 * (360 / 12) + (360 / 12) * (minutes / 60)
        var minute = minutes * (360 / 60) + (360 / 60) * (seconds / 60)
        var second = seconds * (360 / 60)
        return (
            <div className="style">
                <img className="backgroundImg" src={backgroundImg} />

                <div className="container">
                    <div className="clockMinuteLine" style={{ transform: 'rotateZ(' + minute + 'deg)' }}></div>
                    <div className="clockHourLine" style={{ transform: 'rotateZ(' + hour + 'deg)' }}></div>
                    <div className="clockSecondLine" style={{ transform: 'rotateZ(' + second + 'deg)' }}></div>
                </div>

            </div>
        )
    }
}

export default Clock;