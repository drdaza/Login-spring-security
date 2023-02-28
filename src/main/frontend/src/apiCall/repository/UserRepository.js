import axios from "axios";
export default class UserRepository{
    url;

    constructor(url){
        this.url = "http://localhost:8080/api";
    }

    async login(username, password){

          const reponse =  axios.get(this.url +'/login',
                                    {auth:{
                                        username: username,
                                        password: password
                                    }}
                                    );

          const status = (await reponse).status;
          
          console.log((await reponse).data);
          return status;
    }
    encode(username, password){
        const encodeData = window.btoa(`${username}:${password}`);
        return encodeData;
    }
}