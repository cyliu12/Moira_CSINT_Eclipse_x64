package org.athomeprojects.base;

/*
return prefs.getInt(key, Integer.MIN_VALUE);
return prefs.get(key, invalid_string);
return prefs.getDouble(key, Double.MIN_VALUE) != Double.MIN_VALUE;
return prefs.getInt(key, Integer.MIN_VALUE) != Integer.MIN_VALUE;
return !prefs.get(key, invalid_string).equals(invalid_string);
prefs.putDouble(key, val);
prefs.put(key, str);
prefs.putInt(key, val);
prefs.put(key, str);
prefs.put(key, val);
prefs.put(key, str);
prefs.remove(key);
prefs = (clss == null) ? null : Preferences.userNodeForPackage(clss);
prefs.clear();
 */

import java.util.Hashtable;
import java.io.*;

public class MyPrefs {

	private Hashtable hash = new Hashtable();
	private File f = null;
	private String filename = null;

	public MyPrefs(Class clss) {
		// use class name as filename to check binary file
		filename = (clss == null) ? "null.prefs" : clss.getName() + ".prefs";

		// Get the file
		f = new File(filename);
		if (f.exists()) {
			// if binary exist, read binary into hash
			//System.out.println(filename + " Found");
			try {
				FileInputStream fi = new FileInputStream(filename);
				ObjectInputStream s = new ObjectInputStream(fi);

				try {
					hash = (Hashtable) s.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// if binary not exist, create the file and return prefs with a null
			// hash
			//System.out.println(filename + " Not Found");
			FileOutputStream fos;
			ObjectOutputStream oos;

			try {
				fos = new FileOutputStream(filename);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(hash);
				oos.close();
				//System.out.println("Create " + filename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public String get(String key, String invalid_string) {
		String str = (hash.get(key) == null) ? invalid_string : (String) hash.get(key);
		return str;
	}

	public int getInt(String key, int invalid_value) {
		int val = (hash.get(key) == null) ? invalid_value : (int) hash.get(key);
		return val;
	}

	public double getDouble(String key, double invalid_value) {
		double val = (hash.get(key) == null) ? invalid_value : (double) hash.get(key);
		return val;
	}

	public void put(String key, String str) {
		hash.put(key, str);
	}

	public void putInt(String key, int val) {
		hash.put(key, val);
	}

	public void putDouble(String key, double val) {
		hash.put(key, val);
	}

	public void remove(String key) {
		hash.remove(key);
	}

	public void save() {
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(hash);
			oos.close();
			//System.out.println("Save preference to " + filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteFile() {
		f.delete();
	}
	
	public void clear(){
		f.delete();
	}
}
