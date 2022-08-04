import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TelaInsercao extends JFrame{
	
	private JTextField inputTitulo;
	private JTextField inputSinopse;
	private JTextField inputProdutora;
	private JTextField inputAtor;
	private JTextField inputEstilo;
	
	private JLabel lblTitulo;
	private JLabel lblSinopse;
	private JLabel lblProdutora;
	private JLabel lblAtor;
	private JLabel lblEstilo;
	private JLabel lblLabel; 
	
	private JButton btnApaga;
	private JButton btnConfirma;
	
	String titulo;
	String sinopse;
	String produtora;
	String atorP;
	String estilo;
	String imagem;
	PreparedStatement ps;


	
	public void insereNovoFilme(final Filmoteca filmoteca) {
		setBounds(10, 10, 460, 500);
		setLayout(null);
		setLocationRelativeTo(null);
		
		//ESPAÇO PARA ESCRITA DOS DADOS
		
		inputTitulo = new JTextField();
		inputTitulo.setBounds(150, 50, 250, 30);
		
		inputSinopse = new JTextField();
		inputSinopse.setBounds(150, 100, 250, 30);
		
		inputProdutora = new JTextField();
		inputProdutora.setBounds(150, 150, 250, 30);
		
		inputAtor = new JTextField();
		inputAtor.setBounds(150, 200, 250, 30);
		
		inputEstilo = new JTextField();
		inputEstilo.setBounds(150, 250, 250, 30);
		

		//ESCRITA
		
		lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(50,40,50,50);
		
		lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(50,90,50,50);
		
		lblProdutora = new JLabel("Produtora");
		lblProdutora.setBounds(50,140,60,50);

		lblAtor = new JLabel("Ator principal");
		lblAtor.setBounds(50,190,100,50);
		
		lblEstilo = new JLabel("Estilo");
		lblEstilo.setBounds(50,240,100,50);
	
		
		lblLabel = new JLabel("ADICIONAR FILME");
		lblLabel.setBounds(10, 1,100,50);

		
		btnApaga = new JButton("Apagar");
		btnApaga.setBounds(115, 370, 100, 50);
		
		btnConfirma = new JButton("Confirmar");
		btnConfirma.setBounds(235, 370, 100, 50);
		
		
		
		
		
		btnConfirma.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(inputAtor.getText().equals("") || inputEstilo.getText().equals("") || inputTitulo.getText().equals("") || inputProdutora.getText().equals("") || inputSinopse.getText().equals("") ) {
					JOptionPane.showMessageDialog(TelaInsercao.this, "Todos os campos devem ser preenchidos");
					return;
					
				}else {
					
					titulo = inputTitulo.getText();
					sinopse = inputSinopse.getText();
					produtora = inputProdutora.getText();
					atorP = inputAtor.getText();
					estilo = inputEstilo.getText();				
					
					
					filmoteca.insereOrdenado(titulo, sinopse, produtora, atorP, estilo);
					
					new Tela().inicializaTela(filmoteca);
					dispose();

										
		try {
			
			ps = BancodeDados.getConnection().prepareStatement("Insert into teste(titulo,sinopse,produtora,ator,estilo)"+"values(?,?,?,?,?)");

			ps.setString(1, titulo);
			ps.setString(2, sinopse);
			ps.setString(3, produtora);
			ps.setString(4, atorP);
			ps.setString(5, estilo);
			ps.execute();
			ps.close();
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
			
		}

	System.out.println("Filme adicionado a lista");
		
				}
				
			}
			  
		});


			

		

		
		
		add(inputTitulo);
		add(inputSinopse);
		add(inputAtor);
		add(inputProdutora);
		add(inputEstilo);
		add(lblTitulo);
		add(lblSinopse);
		add(lblAtor);
		add(lblProdutora);
		add(lblEstilo);
		add(btnConfirma);
		add(btnApaga);
		add(lblLabel);
		
		setVisible(true);

		
	}
	
}
