package me.taylor.tChattr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonListener implements ActionListener {

	tChattr chattr = new tChattr();
	GUI gui = new GUI();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			chattr.writer.println(gui.outgoing.getText());
			chattr.writer.flush();
		} catch(Exception ex) {
			ex.printStackTrace();
			gui.incoming.append("[WARNING] Sending message fail :(");
		}
		
		gui.outgoing.setText("");
		gui.outgoing.requestFocus();

	}

}
