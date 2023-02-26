import UserRepository from "./repository/UserRepository";

export default class ApiCall{
    Api;

    constructor(api){
        this.Api = api;
    }

    chooseApi(){
        if(this.Api==='users') return new UserRepository();
    }
}