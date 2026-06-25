package view;

import java.awt.EventQueue;
import java.awt.Image;


import java.util.ArrayList;
import javax.swing.JScrollPane;

import model.Cliente;
import model.ClienteTableModel;

import javax.swing.ButtonGroup;// para os botoes de marca masculino e feminino
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ClienteDAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private ArrayList<Cliente> clientes;
	private ClienteTableModel modelo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private JTable table_1;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private ClienteDAO dao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		dao = new ClienteDAO();
        clientes = new ArrayList<>();
		modelo = new ClienteTableModel(clientes);
		//modelo = new ClienteTableModel
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter.ofPattern("dd/MM/yyy");
		DateTimeFormatter formato;
		//String dataFormatada = hoje.format(formato);
		//System.out.println(dataFormatada);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnFeminino = new JRadioButton("Feminino");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(57, 26, 80, 80);
		ImageIcon image = new ImageIcon(TelaCadastro.class.getResource("/img/753210.png"));
		Image imageScaled = image.getImage();
		Image novaImag = imageScaled.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		 
		lblNewLabel.setIcon(new ImageIcon(novaImag));
		
		JLabel lblNewLabel_CadrastroCilente = new JLabel("CADRASTRO CLIENTE");
		lblNewLabel_CadrastroCilente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_CadrastroCilente.setBounds(147, 25, 287, 54);
		lblNewLabel_CadrastroCilente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_CadrastroCilente.setBackground(new Color(0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 116, 570, 122);
		panel.setBackground(new Color(192, 192, 192));
		panel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(318, 79, 228, 33);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Masculino");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnNewRadioButton_1.setBounds(110, 6, 102, 20);
		panel_5.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Feminino");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnNewRadioButton.setBounds(6, 6, 102, 20);
		panel_5.add(rdbtnNewRadioButton);
		
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rdbtnMasculino);
		grupoSexo.add(rdbtnFeminino);
		
		JLabel lblNewLabel_nome = new JLabel("Nome:");
		lblNewLabel_nome.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_nome.setBounds(10, 8, 44, 12);
		panel.add(lblNewLabel_nome);
		
		
		JLabel lblNewLabel_email = new JLabel("E-mail:");
		lblNewLabel_email.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_email.setBounds(10, 62, 82, 24);
		panel.add(lblNewLabel_email);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 268, 570, 64);
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_CadrastroCilente);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 644, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Arquivo");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Abrir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFileChooser = new JFileChooser();
				if(jFileChooser.showOpenDialog(TelaCadastro.this)
						== JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					carregarDados(file, modelo);
					
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Salvar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				if(jFileChooser.showSaveDialog(TelaCadastro.this)
						== JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					salvarDados(file, modelo);
				}
				
			
			}	
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sair");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("Editar");
		menuBar.add(mnNewMenu);
		JMenu mnNewMenu_3 = new JMenu("Atualizar");
		mnNewMenu_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linha = table_1.getSelectedRow();
				if (linha < 0) {
					JOptionPane.showMessageDialog(TelaCadastro.this, "Selecione um cliente para atualizar!", 
							"Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}else {
					Cliente cliente = modelo.getCliente(linha);
					TelaAtualizar dialogo = new TelaAtualizar(TelaCadastro.this, cliente);
					dialogo.setVisible(true);
					if (dialogo.getClienteEditado() != null) {
						dao.atualizar(dialogo.getClienteEditado());
						modelo.atualizarTabela(dao.listar());
					}
				}
			
			}
		});
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_2 = new JMenu("Preferencia");
		menuBar.add(mnNewMenu_2);
		contentPane.add(panel);
		
		JMenu mnNewMenu_4 = new JMenu("Sobre");
		menuBar.add(mnNewMenu_4);
	
	
	
		
		JLabel lblNewLabel_telefone= new JLabel("Telefone:");
		lblNewLabel_telefone.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_telefone.setBounds(319, 8, 77, 12);
		panel.add(lblNewLabel_telefone);
		
		JLabel lblNewLabel_sexo= new JLabel("Sexo:");
		lblNewLabel_sexo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_sexo.setBounds(319, 68, 44, 12);
		panel.add(lblNewLabel_sexo);
		
		textField = new JTextField();
		textField.setBounds(10, 30, 96, 18);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 83, 96, 18);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(318, 30, 96, 18);
		panel.add(textField_2);
		textField_2.setColumns(10);
		contentPane.add(panel_1);
		
		JToggleButton textSalvar = new JToggleButton("Salvar");
		textSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText().toString();
				String email = textField_1.getText().toString();
				String telefone = textField_2.getText().toString();
				String sexo = rdbtnMasculino.isSelected() ?"Masculino":"Feminina";
				  if(nome.isBlank() || email.isBlank() || telefone.isBlank()) {
				        JOptionPane.showMessageDialog(
				            TelaCadastro.this,
				            "Preencha todos os campos",
				            "Alerta",
				            JOptionPane.WARNING_MESSAGE
				        );
				        return;
				    }

				    //aqui
				    if(!nome.matches("[a-zA-ZÀ-ÿ ]+")) {
				        JOptionPane.showMessageDialog(
				            TelaCadastro.this,
				            "O nome não pode conter números ou caracteres especiais.",
				            "Erro",
				            JOptionPane.ERROR_MESSAGE
				        );
				        return;
				    }

				    
				    if(!email.contains("@")) {
				        JOptionPane.showMessageDialog(
				            TelaCadastro.this,
				            "E-mail inválido.",
				            "Erro",
				            JOptionPane.ERROR_MESSAGE
				        );
				        return;
				    }

				    
				    if(!telefone.matches("\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}$")) {
				        JOptionPane.showMessageDialog(
				            TelaCadastro.this,
				            "O telefone deve conter apenas números ex: (69) 99999-9999.",
				            "Erro",
				            JOptionPane.ERROR_MESSAGE
				        );
				        return;
				    }

				    Cliente cliente = new Cliente(nome, telefone, email, sexo);
				    modelo.addCliente(cliente);

				    JOptionPane.showMessageDialog(
				        TelaCadastro.this,
				        "Cliente adicionado com sucesso!",
				        "Sucesso!",
				        JOptionPane.INFORMATION_MESSAGE
				    );
				}
			
			
			
			
	
			
		});
		textSalvar.setBounds(10, 23, 114, 20);
		panel_1.add(textSalvar);
			
		
		JToggleButton textExcluir = new JToggleButton("Excluir");
		textExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = table_1.getSelectedRow();
				if(indice >= 0) {
					modelo.removerCliente(indice);
					Cliente cliente = modelo.getCliente(indice);
					dao.excluir(cliente.getId());
					modelo.removerCliente(indice);
					
				}else {
					JOptionPane.showMessageDialog(TelaCadastro.this, "Selecione um cliente!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		textExcluir.setBounds(128, 23, 114, 20);
		panel_1.add(textExcluir);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Buscar");
		tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String buscarNome = textField_3.getText().toString();
				if(!buscarNome.isBlank()) {
					int indice = modelo.buscarCliente(buscarNome);
					if(indice >= 0) {
						table_1.setRowSelectionInterval(indice, indice);
					
					}else {
						JOptionPane.showMessageDialog(null, "Cliente não encontrado");
					}
				}
			}
		});
		tglbtnNewToggleButton_2.setBounds(244, 23, 114, 20);
		panel_1.add(tglbtnNewToggleButton_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(368, 24, 162, 18);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 347, 570, 196);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(modelo);
		//JScrollPane scrollPane = null;
		scrollPane_1.setViewportView(table_1);
	}	
		
		private void carregarDados(File file, ClienteTableModel modelo) {
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				modelo.limparDados();
				bufferedReader.readLine();
				String linha = "";
				while((linha = bufferedReader.readLine()) != null) {
					String campos [] = linha.split(",");
					if (campos.length == 4) {
						String nome = campos[0];
						String telefone = campos[1];
						String email = campos[2];
						String sexo = campos[3];
						Cliente cliente = new Cliente(nome, telefone, email, sexo);
						modelo.addCliente(cliente);
					}	
		        }
		  }catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					bufferedReader.close();
					fileReader.close();				
				}catch(IOException e) {
					e.printStackTrace();
				}
			}		
			
		}
			
			private void salvarDados(File file, ClienteTableModel modelo) {
				try {
					fileWriter = new FileWriter(file);
					bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write("Nome, Telefone, Email, Sexo");
					bufferedWriter.newLine();
					for (int i=0; i < modelo.getRowCount(); i++) {
						String nome = (String) modelo.getValueAt(i, 0);
						String telefone = (String) modelo.getValueAt(i, 1);
						String email = (String) modelo.getValueAt(i, 2);
						String sexo = (String) modelo.getValueAt(i, 3);
						bufferedWriter.write(nome+","+telefone+","+
						","+email+","+sexo);
						bufferedWriter.newLine();
					}
				}catch(IOException e) {
					e.printStackTrace();
				}finally {
					try {
				        if(bufferedWriter != null) {
				            bufferedWriter.close();
				        }

				        if(fileWriter != null) {
				            fileWriter.close();
				        }
				    } catch(IOException e) {
				        e.printStackTrace();
				    }
				}
			


		}
			
}
