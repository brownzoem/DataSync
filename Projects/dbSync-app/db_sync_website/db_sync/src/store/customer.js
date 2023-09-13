// Utilities
import { defineStore } from 'pinia'
import customerApi from '@/clients/customerDB'

export const useAppStore = defineStore('customer', {
  state: () => ({
    //
    data: [],
    minLatency: null,
    maxLatency: null,
    _90thpercent: null,
    latency: []
  }),

})



