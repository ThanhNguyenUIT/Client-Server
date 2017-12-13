package com.thanh.Exercise3;
import java.io.File;

import javax.swing.JFileChooser;

public class ChooseFile {
	public String chooseFile(){
		String filePath = "";
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File f = fc.getSelectedFile();
		filePath = f.getAbsolutePath();
		return filePath;
	}
}
