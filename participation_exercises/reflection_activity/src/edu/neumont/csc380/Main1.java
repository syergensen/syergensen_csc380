package edu.neumont.csc380;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Main1 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("edu.neumont.csc380.ReflectionActivity");

			Constructor[] constructors = c.getDeclaredConstructors();
			for(Constructor constructor : constructors) {
				System.out.print(constructor.getName());
				System.out.print("(");
				for(int i = 0; i < constructor.getParameterTypes().length; i++) {
					Class aClass = constructor.getParameterTypes()[i];
					System.out.print(aClass.getName());
					if(i < constructor.getParameterTypes().length - 1) {
						System.out.print(", ");
					}
				}
				System.out.print(")\n");
			}

			Object instance = c.getConstructor(String.class, double.class).newInstance("sean", 4.5);

			for(int i = 0; i < c.getDeclaredFields().length; i++) {
				Field field = c.getDeclaredFields()[i];
				System.out.println(field.getType().getName() + " " + field.getName());
			}

			Method meth = c.getDeclaredMethod("addToNumber", double.class);
			System.out.println(meth.invoke(instance, 5));

			Main1 main1 = new Main1();
			for(Class className : main1.getClassesInPackage("edu.neumont.csc380")) {
				System.out.println(className.getName());
			}

		} catch(Exception e) {

		}
	}

	public List<Class> getClassesInPackage(String packageName) throws Exception {
		URL packageUrl = this.getClass().getClassLoader().getResource(packageName.replace(".", "/"));
		List<Class> allClasses = new ArrayList<>();
		if(packageUrl != null) {
			Path packagePath = Paths.get(packageUrl.toURI());
			if(Files.isDirectory(packagePath)) {
				try(DirectoryStream<Path> ds = Files.newDirectoryStream(packagePath, "*.class")) {
					for(Path d : ds) {
						allClasses.add(Class.forName(packageName + "." + d.getFileName().toString().replace(".class", "")));
					}
				}
			}
			return allClasses;
		}
		return null;
	}
}
