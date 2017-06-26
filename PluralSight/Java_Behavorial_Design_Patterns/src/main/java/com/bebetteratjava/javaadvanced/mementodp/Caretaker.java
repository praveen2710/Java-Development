package com.bebetteratjava.javaadvanced.mementodp;

import java.util.Stack;

//caretaker
public class Caretaker {


	//some people prefer arraylist however using stack has advantage of saving sequence;
	private Stack<EmployeeMemento> employeeHistory = new Stack<>();
	
	public void save(Employee emp) {
		employeeHistory.push(emp.save());
	}
	
	public void revert(Employee emp) {
		emp.revert(employeeHistory.pop());
	}
}
