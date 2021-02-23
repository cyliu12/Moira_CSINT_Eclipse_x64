package csharp.moira;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Log {
	private static String filename = "mylog.log";
	private static FileOutputStream outputStream = null;
	private static OutputStreamWriter outputStreamWriter = null;
	private static BufferedWriter bufferedWriter = null;

	public static void c(String str) {
		System.out.println(str);
	}

	public static void c(int val) {
		System.out.println(val);
	}

	public static void c(double val) {
		System.out.println(val);
	}

	public static void c(boolean val) {
		System.out.println(Boolean.toString(val));
	}

	public static void setFilename(String name) {
		filename = name;
	}

	public static void OpenLogFile() {
		try {
			outputStream = new FileOutputStream(filename);
			outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
			bufferedWriter = new BufferedWriter(outputStreamWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void f(String str) {
		try {
			bufferedWriter.write(str);
			bufferedWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void f(int val) {
		try {
			bufferedWriter.write(val);
			bufferedWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void f(double val) {
		try {
			bufferedWriter.write(Double.toString(val));
			bufferedWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void f(boolean val) {
		try {
			bufferedWriter.write(Boolean.toString(val));
			bufferedWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void cf(String str) {
		c(str);
		f(str);
	}

	public static void cf(int val) {
		c(val);
		f(val);
	}

	public static void cf(double val) {
		c(val);
		f(val);
	}

	public static void cf(boolean val) {
		c(val);
		f(val);
	}

	public static void CloseLogFile() {
		try {
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
