<template>
  <v-card title="Postgres Table">
    <div class="container">
      <v-data-table
        v-model:items-per-page="itemsPerPage"
        :headers="headers"
        :items="customers"
        :loading="loading"
        class="elevation-1"
        desnity="compact"
        @update:options="loadItems"
      >
      </v-data-table>
    </div>
  </v-card>
</template>

<script>
import CustomerService from "@/clients/customerdb.js"
//import axios from 'axios';
export default {
  data: () => ({
    itemsPerPage: 10,
    headers: [
      {
        title: 'First Name', align: 'start', sortable: false,
        key: 'firstName',
      },
      { title: 'Last Name', key: 'lastName', align: 'end' },
      { title: 'Age', key: 'age', align: 'end' },
      { title: 'Phone Number', key: 'phoneNumber', align: 'end' },
      { title: 'Address', key: 'address', align: 'end' },
      { title: 'Job', key: 'job', align: 'end' },
      { title: 'Input Time', key: 'inputTime', align: 'end' },
      { title: 'Output Time', key: 'outputTime', align: 'end' },
    ],
    customers: [],
    loading: true,
    totalItems: 0,
  }),
  methods: {
     async loadItems() {
      this.loading = true
      await CustomerService.getCustomers().then((response) => {
        this.customers = response.data
        this.loading = false
        console.log(this.customers) // log the customers data here
      })
    }
  },
  created() {
    this.loadItems()
  }
}
</script>

