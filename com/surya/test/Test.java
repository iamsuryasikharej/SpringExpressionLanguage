package com.surya.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.surya.beans.Student;

public class Test {

	public static void main(String[] args) {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/surya/resources/applicationContext.xml");
		Student student=(Student) applicationContext.getBean("student");
		System.out.println(student.toString());
		Student student1=new Student();
		ExpressionParser parser=new SpelExpressionParser();
		StandardEvaluationContext context=new StandardEvaluationContext(student1);
		context.setVariable("name1", "surya");
		context.setVariable("roll1", 115);
		parser.parseExpression("Name= #name1").getValue(context);
		parser.parseExpression("Roll= #roll1").getValue(context);
//		expr.setValue(context,"surya");
		System.out.println(student1.getName());
		System.out.println(student1.getRoll());

	}

}
