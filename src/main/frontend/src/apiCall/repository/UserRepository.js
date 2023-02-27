import axios from "axios";
export default class UserRepository{
    url;

    constructor(url){
        this.url = "http://localhost:8080/login";
    }

    async login(username, password){
          const reponse =  axios.post(this.url, 
                         {
                            "username": username,
                            "password": password
                         });

          const status = (await reponse).status

          return status;
    }
}