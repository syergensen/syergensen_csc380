package edu.neumont.csc380;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;

/**
 * User: seanyerg
 * Date: 7/11/13
 * Time: 12:55 PM
 */
public class Main {
	public static void main(String[] args) {
		try {
			Class intTest = Class.forName("int");
			Class<?> raClass = Class.forName("edu.neumont.csc380.ReflectionActivity");
			for(Constructor constructor : raClass.getConstructors()) {
				System.out.print(constructor.getName() + "(");
				for(int i = 0; i < constructor.getParameterTypes().length; i++) {
					Class parameterClass = constructor.getParameterTypes()[i];
					System.out.print(parameterClass.getName());
					if(i < constructor.getParameterTypes().length - 1) {
						System.out.print(", ");
					}
				}
				System.out.print(")\n");
			}

			ReflectionActivity ra = (ReflectionActivity) raClass.getDeclaredConstructor(String.class, double.class).newInstance("Sean", 3.5);
			System.out.println(ra.getId() + " " + ra.getName() + " " + ra.addToNumber(4.5));

			for(Field field : raClass.getDeclaredFields()) {
				System.out.println(field.getType().getName() + " " + field.getName());
			}

			double result = (Double) raClass.getMethod("addToNumber", double.class).invoke(ra, 4.5);
			System.out.println(result);

		} catch(Exception e) {
			e.printStackTrace();
		}


	}
}
