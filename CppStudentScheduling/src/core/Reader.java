package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import people.Teacher;

public class Reader {
	/*
	 * This class reads Teachers.txt to get data quickly from the txt file
	 */

	File file;
	FileReader rd;
	BufferedReader bf;

	ArrayList<Teacher> elements;

	public Reader() {
		this.elements = new ArrayList<Teacher>();
		file = new File(getClass().getResource("/people/TeachersDB.txt")
				.getFile());

		try {
			rd = new FileReader(file);
			bf = new BufferedReader(rd);

			String read = "";

			String tname = "";
			String[] subjects = null;
			String[] data;
			while ((read = bf.readLine()) != null) {

				if (read != null) {
					data = read.split(",");
					if (data.length >= 1) {
						tname = data[0];
					}
					if (data.length >= 2) {
						subjects = data[1].split(" ");
					} else {
						subjects = null;
					}

					elements.add(new Teacher(tname, subjects));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
				rd.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Teacher> getTeachers() {
		return elements;
	}
}
