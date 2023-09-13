import { ApiClient } from "./client"
import axios from 'axios';
//const client = new ApiClient("localhost:8080/api/")

class CustomerService {
  getCustomers() {
    return axios.get('http://localhost:8080/api/customers')
  }
  getLatency() {
    return axios.get('http://localhost:8080/api/min-val')
  }

}
export default new CustomerService()


