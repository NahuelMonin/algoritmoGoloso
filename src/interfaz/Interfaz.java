package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


import arbitraje.*;
import data.*;


import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class Interfaz {
	
	private Instancia torneo;
	private JFrame frmSeleccinAutomatizadaDe;
	private Lectura leerArchivo;
	private Solver solucion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmSeleccinAutomatizadaDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crearTorneo();
		try {
			escribirCalendario();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmSeleccinAutomatizadaDe = new JFrame();
		frmSeleccinAutomatizadaDe.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\icono.png"));
		frmSeleccinAutomatizadaDe.setResizable(false);
		frmSeleccinAutomatizadaDe.setTitle("Selecci\u00F3n automatizada de \u00E1rbitros.");
		frmSeleccinAutomatizadaDe.setBounds(100, 100, 835, 667);
		frmSeleccinAutomatizadaDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeleccinAutomatizadaDe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calendario original");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(60, 11, 125, 14);
		frmSeleccinAutomatizadaDe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Asignacion de \u00E1rbitros");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(317, 11, 149, 14);
		frmSeleccinAutomatizadaDe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Asignacion de Nombres");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(607, 11, 149, 14);
		frmSeleccinAutomatizadaDe.getContentPane().add(lblNewLabel_2);
		
		JTextPane torneoOriginal = new JTextPane();
		torneoOriginal.setEditable(false);
		torneoOriginal.setBounds(10, 36, 240, 485);
		frmSeleccinAutomatizadaDe.getContentPane().add(torneoOriginal);
		leerArchivo = new Lectura ();
		torneoOriginal.setText(leerArchivo.getCalendario());
		
		
		JTextPane despuesDelAlgoritmo = new JTextPane();
		despuesDelAlgoritmo.setEditable(false);
		despuesDelAlgoritmo.setBounds(270, 36, 240, 485);
		frmSeleccinAutomatizadaDe.getContentPane().add(despuesDelAlgoritmo);
		
		JTextPane calendarioConNombres = new JTextPane();
		calendarioConNombres.setEditable(false);
		calendarioConNombres.setBounds(538, 36, 259, 485);
		frmSeleccinAutomatizadaDe.getContentPane().add(calendarioConNombres);
		
		JButton asignarArbitros = new JButton("Asignar \u00C1rbitros");
		asignarArbitros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solucion = new Solver (torneo);
				solucion.asignarArbitros();
				despuesDelAlgoritmo.setText(solucion.toString());
				
			}
		});
		asignarArbitros.setBounds(340, 532, 133, 23);
		frmSeleccinAutomatizadaDe.getContentPane().add(asignarArbitros);
		
		JButton btnNewButton_2 = new JButton("Asignar Apellidos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Arbitro arbitro : torneo.getArbitros()) {
					arbitro.setApellido(JOptionPane.showInputDialog("Ingrese el nombre: "));
				}
				calendarioConNombres.setText(solucion.toString());
				
			}
		});
		btnNewButton_2.setBounds(622, 532, 134, 23);
		frmSeleccinAutomatizadaDe.getContentPane().add(btnNewButton_2);
		
	}
	
	
	public void crearTorneo () {
	
		Equipo[] equipos = new Equipo[6];
		equipos[0] = new Equipo("River Plate", 0);
		equipos[1] = new Equipo("Boca Jrs", 1);
		equipos[2] = new Equipo("Independiente", 2);
		equipos[3] = new Equipo("Racing", 3);
		equipos[4] = new Equipo("San Lorenzo", 4);
		equipos[5] = new Equipo("Huracan", 5);
		
		HashMap<Integer, Arbitro> arbitros = new HashMap<Integer, Arbitro>();
		arbitros.put(0, new Arbitro(1,6));
		arbitros.put(1, new Arbitro(2,6));
		arbitros.put(2, new Arbitro(3,6));
		
		ArrayList<Partido> partidosFecha1 = new ArrayList<Partido>();
		partidosFecha1.add(new Partido(equipos[0], equipos[1]));
		partidosFecha1.add(new Partido(equipos[2], equipos[3]));
		partidosFecha1.add(new Partido(equipos[4], equipos[5]));
		
		ArrayList<Partido> partidosFecha2 = new ArrayList<Partido>();
		partidosFecha2.add(new Partido(equipos[0], equipos[2]));
		partidosFecha2.add(new Partido(equipos[4], equipos[1]));
		partidosFecha2.add(new Partido(equipos[5], equipos[3]));
		
		ArrayList<Partido> partidosFecha3 = new ArrayList<Partido>();
		partidosFecha3.add(new Partido(equipos[0], equipos[4]));
		partidosFecha3.add(new Partido(equipos[5], equipos[2]));
		partidosFecha3.add(new Partido(equipos[3], equipos[1]));
		
		ArrayList<Partido> partidosFecha4 = new ArrayList<Partido>();
		partidosFecha4.add(new Partido(equipos[0], equipos[5]));
		partidosFecha4.add(new Partido(equipos[3], equipos[4]));
		partidosFecha4.add(new Partido(equipos[1], equipos[2]));
		
		ArrayList<Partido> partidosFecha5 = new ArrayList<Partido>();
		partidosFecha5.add(new Partido(equipos[0], equipos[3]));
		partidosFecha5.add(new Partido(equipos[1], equipos[5]));
		partidosFecha5.add(new Partido(equipos[2], equipos[4]));
		
		ArrayList<FechaTorneo> fechasTorneo = new ArrayList<FechaTorneo>();
		fechasTorneo.add(new FechaTorneo (1, partidosFecha1 ));
		fechasTorneo.add(new FechaTorneo (2, partidosFecha2 ));
		fechasTorneo.add(new FechaTorneo (3, partidosFecha3 ));
		fechasTorneo.add(new FechaTorneo (4, partidosFecha4 ));
		fechasTorneo.add(new FechaTorneo (5, partidosFecha5 ));
		
		torneo = new Instancia (fechasTorneo, arbitros);
		
	}
	

	private void escribirCalendario () throws IOException{
		try {
			FileOutputStream fos = new FileOutputStream("Calendario.txt");
			OutputStreamWriter out = new OutputStreamWriter(fos);
			out.write(torneo.toString());
			
			out.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
