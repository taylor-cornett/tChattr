package me.taylor.tChattr;

import java.io.IOException;

public class IncomingReader implements Runnable {

	GUI gui = new GUI();
	tChattr chattr = new tChattr();

	@Override
	public void run() {
		String message;

		try {
			while ((message = chattr.reader.readLine()) != null) {
				System.out.println();
				gui.incoming.append(message + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			gui.incoming.append("[WARNING] Recieving message failed. \n");
		}
	}
}
