import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Tela extends JFrame {
	
	private Filmoteca filmoteca;
	private Filme filme;
	
	private JTextField inputTitulo;
	private JTextField inputSinopse;
	private JTextField inputProdutora;
	private JTextField inputAtor;
	private JTextField inputEstilo;

	private JScrollPane scroll;
	
	private JLabel lblTitulo;
	private JLabel lblSinopse;
	private JLabel lblProdutora;
	private JLabel lblAtor;
	private JLabel lblEstilo;
	private JLabel lblNavegacao;
	private JLabel label;
	
	private JRadioButton atorPrincipal;
	private JRadioButton estilo;
	private JRadioButton titulo;
	private ButtonGroup bg;
	
	private JButton btnAnt;
	private JButton btnExc;
	private JButton btnNovo;
	private JButton btnProx;
	
	
	public void inicializaTela(final Filmoteca filmoteca) {
		setBounds(10, 10, 805, 515);
		setDefaultCloseOperation(Tela.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("Filmoteca");
		this.filmoteca = filmoteca;
		
		//ESPAÇO PARA ESCRITA DOS DADOS
		
		inputTitulo = new JTextField();
		inputTitulo.setBounds(500, 50, 250, 30);
		inputTitulo.setEditable(false);
		inputTitulo.setMargin(new Insets(0,5,0,0));
		
		inputSinopse = new JTextField();
		inputSinopse.setBounds(500, 115, 250, 30);
		inputSinopse.setEditable(false);
		inputSinopse.setMargin(new Insets(0,5,0,0));
		scroll = new JScrollPane(inputSinopse);
		scroll.setPreferredSize(new Dimension(50,50));
		scroll.setBounds(500, 100,250,50);
		
		inputProdutora = new JTextField();
		inputProdutora.setBounds(500, 165, 250, 30);
		inputProdutora.setEditable(false);
		inputProdutora.setMargin(new Insets(0,5,0,0));
		
		inputAtor = new JTextField();
		inputAtor.setBounds(500, 215, 250, 30);
		inputAtor.setEditable(false);
		inputAtor.setMargin(new Insets(0,5,0,0));
		
		inputEstilo = new JTextField();
		inputEstilo.setBounds(500, 265, 250, 30);
		inputEstilo.setEditable(false);
		inputEstilo.setMargin(new Insets(0,5,0,0));
		
		//ESCRITA
		
		lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(460,40,50,50);
		
		lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(450,100,50,50);
		
		lblProdutora = new JLabel("Produtora");
		lblProdutora.setBounds(440,155,60,50);

		lblAtor = new JLabel("Ator principal");
		lblAtor.setBounds(420,205,100,50);
		
		lblEstilo = new JLabel("Estilo");
		lblEstilo.setBounds(460,255,100,50);
		
		lblNavegacao = new JLabel("Navegação");
		lblNavegacao.setBounds(155, 347, 100, 15);
	
		
		//Radiobuttons
		
		atorPrincipal = new JRadioButton("Ator Principal",true);
		atorPrincipal.setBounds(275,347,125,15);
		
		estilo = new JRadioButton("Estilo",false);
		estilo.setBounds(410, 347, 75, 15);		
		
		titulo = new JRadioButton("Título", false);
		titulo.setBounds(500, 347, 100, 15);
		
		bg = new ButtonGroup();
		bg.add(titulo);
		bg.add(estilo);
		bg.add(atorPrincipal);
		
		
		
		//BOTÕES
	
		
		btnAnt = new JButton("Anterior");
		btnAnt.setBounds(45,400,160,50);
		
		btnExc = new JButton("Exclusão");
		btnExc.setBounds(225,400,160,50);
			
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(405,400,160,50);
		
		btnProx = new JButton("Próximo");
		btnProx.setBounds(585,400,160,50);
		
		
		
		//IMAGEM
		
		label = new JLabel();
        label.setBounds(100,25,200,300);
       

		//Botão para excluir na lista
		btnExc.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				if(filmoteca.excluiFilme(JOptionPane.showInputDialog("Digite o nome do filme a ser excluído: "))) {
					JOptionPane.showMessageDialog(Tela.this, "Excluído com sucesso" );
				}else {
					JOptionPane.showMessageDialog(Tela.this, "Filme não encontrado");
				}
				
				
			}
		});
		
		
		//Botão para retornar na lista
		btnAnt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(atorPrincipal.isSelected()) {
					if(filme.getAntAP() == null) {
						JOptionPane.showMessageDialog(Tela.this, "Esse é o primeiro filme da lista!");
					}else {
						filme = filme.getAntAP();
						inputAtor.setText(filme.getAtorPrincipal());
						inputEstilo.setText(filme.getEstilo());
						inputProdutora.setText(filme.getProdutora());
						inputSinopse.setText(filme.getSinopse());
						inputTitulo.setText(filme.getTitulo());
						
						
					}
					
				}
			
				if(estilo.isSelected()) {
					if(filme.getAntEstilo() == null) {
						JOptionPane.showMessageDialog(Tela.this, "Esse é o primeiro filme da lista!");
					}else {
						filme = filme.getAntEstilo();
						inputAtor.setText(filme.getAtorPrincipal());
						inputEstilo.setText(filme.getEstilo());
						inputProdutora.setText(filme.getProdutora());
						inputSinopse.setText(filme.getSinopse());
						inputTitulo.setText(filme.getTitulo());
						
					}
					
				}
				
				if(titulo.isSelected()) {
					if(filme.getAntTitulo() == null) {
						JOptionPane.showMessageDialog(Tela.this, "Esse é o primeiro filme da lista!");
					}else {
						filme = filme.getAntTitulo();
						inputAtor.setText(filme.getAtorPrincipal());
						inputEstilo.setText(filme.getEstilo());
						inputProdutora.setText(filme.getProdutora());
						inputSinopse.setText(filme.getSinopse());
						inputTitulo.setText(filme.getTitulo());
						
					}
					
				}
				
			}
		});
		
		
		//Botão para adicionar na lista
		btnNovo.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				
				TelaInsercao cadastra = new TelaInsercao();
				cadastra.insereNovoFilme(filmoteca);
				dispose();
				
			}
		});
		
		//Botão para avançar na lista
		btnProx.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					if(atorPrincipal.isSelected()) {
						if(filme.getProxAP() == null) {
							JOptionPane.showMessageDialog(Tela.this, "Esse é o último filme da lista!");
						}else {
							filme = filme.getProxAP();
							inputAtor.setText(filme.getAtorPrincipal());
							inputEstilo.setText(filme.getEstilo());
							inputProdutora.setText(filme.getProdutora());
							inputSinopse.setText(filme.getSinopse());
							inputTitulo.setText(filme.getTitulo());
							
						}
						
					}
				
					if(estilo.isSelected()) {
						if(filme.getProxEstilo() == null) {
							JOptionPane.showMessageDialog(Tela.this, "Esse é o último filme da lista!");
						}else {
							filme = filme.getProxEstilo();
							inputAtor.setText(filme.getAtorPrincipal());
							inputEstilo.setText(filme.getEstilo());
							inputProdutora.setText(filme.getProdutora());
							inputSinopse.setText(filme.getSinopse());
							inputTitulo.setText(filme.getTitulo());
							
						}
						
					}
					
					if(titulo.isSelected()) {
						if(filme.getProxTitulo() == null) {
							JOptionPane.showMessageDialog(Tela.this, "Esse é o último filme da lista!");
						}else {
							filme = filme.getProxTitulo();
							inputAtor.setText(filme.getAtorPrincipal());
							inputEstilo.setText(filme.getEstilo());
							inputProdutora.setText(filme.getProdutora());
							inputSinopse.setText(filme.getSinopse());
							inputTitulo.setText(filme.getTitulo());
							
						}
						
					}
			}
		});

		
		add(inputTitulo);
		add(scroll);
		add(inputAtor);
		add(inputProdutora);
		add(inputEstilo);
		add(lblTitulo);
		add(lblSinopse);
		add(lblAtor);
		add(lblProdutora);
		add(lblEstilo);
		add(lblNavegacao);
		add(atorPrincipal);
		add(estilo);
		add(titulo);
		add(btnAnt);
		add(btnProx);
		add(btnNovo);
		add(btnExc);
		add(label);
		
		
		setVisible(true);
		this.inicia();
		
	}
	
	private void inicia() {
		Filme primeiro = this.filmoteca.retornaPrimeiro();
		if(primeiro == null) {
			
		}else {
			filme = primeiro;
			this.inputTitulo.setText(primeiro.getTitulo());
			this.inputAtor.setText(primeiro.getAtorPrincipal());
			this.inputEstilo.setText(primeiro.getEstilo());
			this.inputProdutora.setText(primeiro.getProdutora());
			this.inputSinopse.setText(primeiro.getSinopse());
		
		}
	}
	
}
