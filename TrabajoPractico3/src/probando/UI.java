package probando;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import arbitraje.*;
import data.Lectura;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UI {

	private JFrame frame;
	private static ArrayList <Fecha> torneo;
	private static ArrayList<Equipo> equipos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();

		agregarEquipos();
		crearTorneo();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 8));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane calendarioOriginal = new JTextPane();
		calendarioOriginal.setBounds(72, 39, 291, 420);
		frame.getContentPane().add(calendarioOriginal);
		
		JTextPane calendarioResultado = new JTextPane();
		calendarioResultado.setBounds(450, 39, 291, 420);
		frame.getContentPane().add(calendarioResultado);
		
		JButton leerCalendario = new JButton("Leer Calendario");
		leerCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					escribirCalendario();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Lectura leerarchivo = new Lectura();
				calendarioOriginal.setText(leerarchivo.getCalendario());
			}
		});
		leerCalendario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		leerCalendario.setBounds(166, 470, 116, 40);
		frame.getContentPane().add(leerCalendario);
		
		JButton aplicarHeuristica = new JButton("Aplicar Heur\u00EDstica");
		aplicarHeuristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Instancia arbitraje = new Instancia (torneo , equipos);
					Solver solver = new Solver(arbitraje);
					Instancia resultado = solver.solucion();
					calendarioResultado.setText(resultado.toString());
			}


		});
		aplicarHeuristica.setFont(new Font("Tahoma", Font.PLAIN, 10));
		aplicarHeuristica.setBounds(536, 470, 116, 40);
		frame.getContentPane().add(aplicarHeuristica);
		
		JLabel lblNewLabel = new JLabel("Calendario Original");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(142, 13, 142, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Asignaci\u00F3n de \u00C1rbitros");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(489, 14, 163, 20);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	private static void crearTorneo() {
		torneo = new ArrayList <Fecha>();
		Fecha fecha1 =new Fecha();
		fecha1.agregarPartido(new Partido (equipos.get(0), equipos.get(1)));
		fecha1.agregarPartido(new Partido (equipos.get(3), equipos.get(2)));
		fecha1.agregarPartido(new Partido (equipos.get(4), equipos.get(5)));
		
		Fecha fecha2 = new Fecha();
		fecha2.agregarPartido( new Partido (equipos.get(0), equipos.get(3)));
		fecha2.agregarPartido( new Partido (equipos.get(4), equipos.get(1)));
		fecha2.agregarPartido( new Partido (equipos.get(5), equipos.get(2)));
		
		Fecha fecha3 = new Fecha();
		fecha3.agregarPartido( new Partido (equipos.get(0), equipos.get(4)));
		fecha3.agregarPartido( new Partido (equipos.get(5), equipos.get(3)));
		fecha3.agregarPartido( new Partido (equipos.get(2), equipos.get(1)));
		
		Fecha fecha4 = new Fecha();
		fecha4.agregarPartido( new Partido (equipos.get(0), equipos.get(5)));
		fecha4.agregarPartido( new Partido (equipos.get(2), equipos.get(4)));
		fecha4.agregarPartido( new Partido (equipos.get(1), equipos.get(3)));
		
		Fecha fecha5 = new Fecha();
		fecha5.agregarPartido( new Partido (equipos.get(0), equipos.get(2)));
		fecha5.agregarPartido( new Partido (equipos.get(1), equipos.get(5)));
		fecha5.agregarPartido( new Partido (equipos.get(3), equipos.get(4)));
		
		torneo.add(fecha1);
		torneo.add(fecha2);
		torneo.add(fecha3);
		torneo.add(fecha4);
		torneo.add(fecha5);
	}

	private static void agregarEquipos() {
		equipos = new ArrayList <Equipo>();
		equipos.add(new Equipo("RIVER"));
		equipos.add(new Equipo("BOCA"));	
		equipos.add(new Equipo("RACING"));
		equipos.add(new Equipo ("INDEPENDIENTE"));
		equipos.add(new Equipo ("SAN LORENZO"));
		equipos.add(new Equipo("HURACAN"));
	}
	
	private void escribirCalendario () throws IOException{
		try {
			FileOutputStream fos = new FileOutputStream("Calendario.txt");
			OutputStreamWriter out = new OutputStreamWriter(fos);
			for (Fecha fecha : torneo) {
				out.write("Fecha " + (torneo.indexOf(fecha)+1)  + "\n");
				for (int i = 0; i < fecha.getPartidos().size(); i++) {
					out.write(fecha.getPartidos().get(i).toString() + "\n");
				}
				
			}
			
			out.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}