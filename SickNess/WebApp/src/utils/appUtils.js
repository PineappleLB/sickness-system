class Utils {
    static getUser = () => {
        let userStr = sessionStorage.getItem("userInfo");
        if(userStr) {
            const user = JSON.parse(userStr);
            return user;
        }
        return null;
    }

    static isLogin = () => {
        let user = Utils.getUser();
        return user !== null;
    }



}

export default Utils;