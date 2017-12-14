package com.thanh.Exercise1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFileChooser;

public class FileUtils {
	public static List<Student> getListStudent(String fileUrl) {
		List<Student> listSt = new ArrayList<>();
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream(fileUrl);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			
			String line = br.readLine();
			String [] st;
			
			while ((line = br.readLine()) != null) {
				st = line.split(",");
				listSt.add(new Student(st[0], st[1], st[2], st[3]));
			}	
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listSt;
	}
	
	public static void printListStudent (List<Student> students){
		Comparator<Student> comparator = (o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
		students.sort(comparator);
		students.forEach(st1 -> System.out.println(st1.toString()));
	}
	
	public static String chooseFile(){
		String filePath = "";
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File f = fc.getSelectedFile();
		filePath = f.getAbsolutePath();
		return filePath;
	}
}

