package Main;

import java.awt.EventQueue;

import Presentacion.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					VentanaPrincipal frame = new VentanaPrincipal();					
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
