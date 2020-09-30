package Presentacion;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {
		setResizable(false);
		setTitle("Programa");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelAgregar panelAgregar = new PanelAgregar();
				getContentPane().removeAll();
				getContentPane().add(panelAgregar);
				getContentPane().repaint();
				getContentPane().revalidate();
				
			}
		});
		mnPersona.add(mntmAgregar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnPersona.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnPersona.add(mntmEliminar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnPersona.add(mntmListar);
	}

	
	
}
