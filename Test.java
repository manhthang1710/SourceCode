package Test;

import javax.swing.UIManager;

import view.QLKHview;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLKHview();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}