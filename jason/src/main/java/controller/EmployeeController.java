package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;

@RestController
public class EmployeeController {

	List<Employee> empList = new ArrayList<Employee>();

	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		return empList;
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int id) {
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getId() == id) {
				return empList.get(i);
			}
		}
		return null;
	}

	@RequestMapping(value = "/emp/create", method = RequestMethod.POST)
	public @ResponseBody Employee addEmployee(@RequestBody Employee emp) {
		empList.add(emp);
		return emp;
	}

	@RequestMapping(value = "/emp/remove/{id}", method = RequestMethod.PUT)
	public @ResponseBody Employee removeEmployee(@PathVariable("id") int id) {
		Employee emp = null;
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getId() == id) {
				emp = empList.get(i);
				empList.remove(i);
			}
		}
		return emp;
	}

}
