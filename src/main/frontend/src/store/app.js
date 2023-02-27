// Utilities
import ApiCall from '@/apiCall/ApiCall'
import { defineStore } from 'pinia'

export const useAppStore = defineStore('app', {
  state: () => ({
    test: 0
  }),
  actions:{
    async login(username, password){
      const myApiCall = new ApiCall('users')
      const api = myApiCall.chooseApi();


      const response = await api.login(username, password);

      console.log(response);

      this.test = response;

      return response;
    } 
  }
})
