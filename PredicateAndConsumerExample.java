package com.biconsumer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

	Predicate<Student> p1=(student)->student.getGradeLevel()>=3;
	Predicate<Student> p2=(student)->student.getGpa()>=3;
	BiConsumer<String,List<String>> bi=(name,activities)->System.out.println("name:"+name+" activities:"+activities);
	Consumer<Student> studentConsumer=(student)->{
		if(p1.and(p2).test(student)){
			bi.accept(student.getName(), student.getActivities());
		}
	};
	public void printNameAndActivities(List<Student> studentList) {
		studentList.forEach(studentConsumer);
	}
	public static void main (String[] args) {
		List<Student> studentList=StudentDatabase.getAllStudents();
		new PredicateAndConsumerExample().printNameAndActivities(studentList);
	}
}
