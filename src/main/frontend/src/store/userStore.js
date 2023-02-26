import ApiCall from '@/apiCall/ApiCall'
import { defineStore } from 'pinia'

export const usersStore = defineStore({
  id: 'users',
  state: ()=>({
    elements: ''
  }),
  actions:{
    async login(username, password){
      const myApiCall = new ApiCall('users')
      const api = myApiCall.chooseApi();

      await api.login(username, password);
    } 
  }

})