import axios from "axios";
export default class UserRepository{
    url;

    constructor(url){
        this.url = "http://localhost:8080/";
    }

    async login(username, password){
            axios.post(this.url, 
                         {
                            "username": username,
                            "password": password
                         }).then(data =>{
                             console.log(data);
                         }).catch(error => {
                             console.log(error);
                         });
    }
}