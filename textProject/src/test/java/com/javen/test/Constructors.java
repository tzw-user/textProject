package com.javen.test;

import java.lang.reflect.Constructor;

/* 
 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员； 
 *  
 * 1.获取构造方法： 
 *      1).批量的方法： 
 *          public Constructor[] getConstructors()：所有"公有的"构造方法 
            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有) 
      
 *      2).获取单个的方法，并调用： 
 *          public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法： 
 *          public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有； 
 *       
 *          调用构造方法： 
 *          Constructor-->newInstance(Object... initargs) 
 */  
public class Constructors {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Class.forName("com.javen.bean.Student");
		System.out.println("**********************所有公有构造方法*********************************");
		Constructor[] conArray = clazz.getConstructors();
		for (Constructor c : conArray) {
			System.out.println(c);
		}
		
	}
	
	
}
