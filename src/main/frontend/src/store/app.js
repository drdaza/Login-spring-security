// Utilities
import ApiCall from '@/apiCall/ApiCall'
import { defineStore } from 'pinia'

export const useAppStore = defineStore('app', {
  state: () => ({
    test: ''
  }),
  actions:{
    async login(username, password){
      const myApiCall = new ApiCall('users')
      const api = myApiCall.chooseApi();

      await api.login(username, password);

    } 
  }
})
