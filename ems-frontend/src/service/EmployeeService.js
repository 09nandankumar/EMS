import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

export const listEmployees = () => axios.get(REST_API_BASE_URL);// one line //1
            //or
// export const listEmployees = () =>{
//     return axios.get(REST_API_BASE_URL);
// }

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL,employee);//2

export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL  + '/' + employeeId);//3

export const updateEmployee =(employeeId,employee)=>axios.put(REST_API_BASE_URL + '/' +employeeId, employee);//4

export const deleteEmployee =(employeeId) =>axios.delete(REST_API_BASE_URL + '/' +employeeId);//5