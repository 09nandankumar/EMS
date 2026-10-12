import { useEffect, useState } from "react"
import React from 'react'
import { deleteEmployee, listEmployees } from "../service/EmployeeService"
import { useNavigate } from "react-router-dom"

const ListEmployeeComponent = () => {

    const [employees, setEmployees] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        getAllEmployees();

    }, [])

    function getAllEmployees() {
        listEmployees().then((Response) => {
            setEmployees(Response.data);

        }).catch(error => {
            console.error(error);
        })
    }

    function addNewEmployee() {
        navigator('/add-employee')

    }

    function updateEmployee(id) {
        navigator(`/edit-employee/${id}`);
    }

    function removeEmployee(id) {
        console.log(id);

        deleteEmployee(id).then((response) => {
            getAllEmployees();
        }).catch(error => {
            console.error(error);
        })
    }

    return (
        <div className='container'>
            <h2 className='text-center'>List of Employee</h2>
            <button className="btn btn-primary md-2" type="button" onClick={addNewEmployee}> Add Employees</button>
            <table className='table table-striped table-bordered table-hover'>
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th> Employee First Name </th>
                        <th> Employee Last Name</th>
                        <th>Employee Email ID</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map(employee =>
                            <tr key={employee.id}>
                                <td>{employee.id}</td>
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.email}</td>
                                <td>
                                    <button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>Update</button>
                                    <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)}
                                        style={{marginLeft:'10px'}}
                                        >Delete</button>
                                </td>

                            </tr>
                        )
                    }

                </tbody>
            </table>
        </div>

    )
}

// rafc and rfc -- to write above functionlity code shortcut rafc-javascript arrow function and rfc is only function component

export default ListEmployeeComponent