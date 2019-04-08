class Utils {
    static getUser = () => {
        let userStr = sessionStorage.getItem("userInfo");
        if(userStr) {
            const user = JSON.parse(userStr);
            return user;
        }
        return null;
    }

    static getManager = () => {
        let managerStr = sessionStorage.getItem("managerInfo");
        if(managerStr) {
            const manager = JSON.parse(managerStr);
            return manager;
        }
        return null;
    }

    static getSuperManager = () => {
        let managerStr = sessionStorage.getItem("superManagerInfo");
        if(managerStr) {
            const manager = JSON.parse(managerStr);
            return manager;
        }
        return null;
    }
    static isLogin = () => {
        let user = Utils.getUser();
        return user !== null;
    }



}

export default Utils;