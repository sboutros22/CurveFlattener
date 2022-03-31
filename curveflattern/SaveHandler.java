package curveflattern;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveHandler {
	private final JFileChooser saveFileChooserPNG = new JFileChooser();
	private final JFileChooser saveFileChooserJPG = new JFileChooser();
	private final JFileChooser saveFileChooserXLS = new JFileChooser();
	private String outcome;

	public void saveImagePNG(String path) {

		String outcome;

		saveFileChooserPNG.setCurrentDirectory(new File("C:\\tempt"));
		saveFileChooserPNG.setFileFilter(new FileNameExtensionFilter("PNG images", "png"));

		int returnValue = saveFileChooserPNG.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			try {
				outcome = "Pass";
			} catch (Exception joe) {
				outcome = "Fail";
			}
		} else {
			outcome = "None";
		}
	}

	public void saveImageJPG(String path) {

		saveFileChooserJPG.setCurrentDirectory(new File("C:\\tempt"));
		saveFileChooserJPG.setFileFilter(new FileNameExtensionFilter("JPG images", "jpg"));

		int returnValue = saveFileChooserPNG.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			try {

				outcome = "Pass";
			} catch (Exception joe) {
				outcome = "Fail";
			}
		} else {
			outcome = "None";
		}
	}

	public void saveData(String path) {

		saveFileChooserXLS.setCurrentDirectory(new File("C:\\tempt"));
		saveFileChooserXLS.setFileFilter(new FileNameExtensionFilter("xls data", "xls"));

		int returnValue = saveFileChooserXLS.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			try {

				outcome = "Pass";
			} catch (Exception joe) {
				outcome = "Fail";
			}
		} else {
			outcome = "None";
		}

	}

	public String getOutcome() {
		return outcome;
	}

}