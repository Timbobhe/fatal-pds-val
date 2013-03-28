package com.esiag.isids.consumers;

import javax.swing.*;

public class ClientRTDRS extends JFrame {

	public ClientRTDRS() {
		setTitle("RTDRS");
		setSize(300, 200); // default size is 0,0
		setLocation(10, 200); // default is 0,0 (top left corner)
	}

	public static void main(String[] args) {
		JFrame f = new ClientRTDRS();
		f.show();
	}
}
