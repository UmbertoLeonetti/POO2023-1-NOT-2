package view.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;

import backend.Persiste;
import backend.Restaurante;
import backend.controller.Controller;
import backend.controller.FuncionarioManager;
import backend.model.Funcionario;
import backend.model.Reserva;

import javax.swing.JSpinner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FuncionarioPanel extends JPanel {
	private FuncionarioManager funcionarios;
	private JPanel panel;
	private Restaurante restaurante;
	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfCargo;
	private JSpinner spinnerHora;
	private JSpinner spinnerMinuto;
	
	private void atualizaLista(FuncionarioManager funcionarios, JList list) {
		
		ArrayList<String> elements = funcionarios.getNomes();
		
		DefaultListModel model = new DefaultListModel();

		for (String str : elements)
			model.addElement(str);

		list.setModel(model);
	}
	
	private void adicionaFuncionario() {
		
		String nome = tfNome.getText() + " " + tfSobrenome.getText();
		String cargo =  tfCargo.getText();
		
		Object hora = spinnerHora.getValue();
		int horaInt;
		
		if (hora instanceof Double) {
			Double horaDouble = (Double) hora;
			horaInt = horaDouble.intValue();

		} else 
			horaInt = (Integer) hora;
		
		Object minuto = spinnerMinuto.getValue();
		int minutoInt;
		
		if (minuto instanceof Double) {
			Double minutoDouble = (Double) minuto;
			minutoInt = minutoDouble.intValue();

		} else 
			minutoInt = (Integer) minuto;

		funcionarios.adicionarFuncionario(nome, cargo, horaInt + ":" + minutoInt);
		Persiste.salva(restaurante,"restaurante.txt");
	}

	public FuncionarioPanel(Restaurante restaurante) {
		this.restaurante = restaurante;
		this.funcionarios = restaurante.funcionarios;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNomeFuncionario = new JLabel("Nome:");
		GridBagConstraints gbc_lblNomeFuncionario = new GridBagConstraints();
		gbc_lblNomeFuncionario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeFuncionario.gridx = 0;
		gbc_lblNomeFuncionario.gridy = 0;
		panel_1.add(lblNomeFuncionario, gbc_lblNomeFuncionario);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.insets = new Insets(0, 0, 5, 5);
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 0;
		panel_1.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblsobrenome = new JLabel("Sobrenome:");
		GridBagConstraints gbc_lblsobrenome = new GridBagConstraints();
		gbc_lblsobrenome.insets = new Insets(0, 0, 5, 5);
		gbc_lblsobrenome.gridx = 2;
		gbc_lblsobrenome.gridy = 0;
		panel_1.add(lblsobrenome, gbc_lblsobrenome);
		
		tfSobrenome = new JTextField();
		GridBagConstraints gbc_tfSobrenome = new GridBagConstraints();
		gbc_tfSobrenome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSobrenome.insets = new Insets(0, 0, 5, 0);
		gbc_tfSobrenome.gridx = 3;
		gbc_tfSobrenome.gridy = 0;
		panel_1.add(tfSobrenome, gbc_tfSobrenome);
		tfSobrenome.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		GridBagConstraints gbc_lblCargo = new GridBagConstraints();
		gbc_lblCargo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargo.gridx = 0;
		gbc_lblCargo.gridy = 1;
		panel_1.add(lblCargo, gbc_lblCargo);
		
		tfCargo = new JTextField();
		GridBagConstraints gbc_tfCargo = new GridBagConstraints();
		gbc_tfCargo.gridwidth = 3;
		gbc_tfCargo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCargo.insets = new Insets(0, 0, 5, 5);
		gbc_tfCargo.gridx = 1;
		gbc_tfCargo.gridy = 1;
		panel_1.add(tfCargo, gbc_tfCargo);
		tfCargo.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horário:");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.insets = new Insets(0, 0, 0, 5);
		gbc_lblHorario.gridx = 0;
		gbc_lblHorario.gridy = 2;
		panel_1.add(lblHorario, gbc_lblHorario);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.WEST;
		gbc_panel_4.gridwidth = 3;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 2;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		spinnerHora = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
		GridBagConstraints gbc_spinnerHora = new GridBagConstraints();
		gbc_spinnerHora.insets = new Insets(0, 0, 0, 5);
		gbc_spinnerHora.gridx = 0;
		gbc_spinnerHora.gridy = 0;
		panel_4.add(spinnerHora, gbc_spinnerHora);
		
		JLabel lblDoisPontos = new JLabel(":\r\n");
		GridBagConstraints gbc_lblDoisPontos = new GridBagConstraints();
		gbc_lblDoisPontos.insets = new Insets(0, 0, 0, 5);
		gbc_lblDoisPontos.gridx = 1;
		gbc_lblDoisPontos.gridy = 0;
		panel_4.add(lblDoisPontos, gbc_lblDoisPontos);
		
		spinnerMinuto = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
		GridBagConstraints gbc_spinnerMinuto = new GridBagConstraints();
		gbc_spinnerMinuto.gridx = 2;
		gbc_spinnerMinuto.gridy = 0;
		panel_4.add(spinnerMinuto, gbc_spinnerMinuto);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_2.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 0;
		panel_3.add(btnSalvar, gbc_btnSalvar);
		
		JButton btnImportar = new JButton("Importar\r\n");
		GridBagConstraints gbc_btnImportar = new GridBagConstraints();
		gbc_btnImportar.anchor = GridBagConstraints.EAST;
		gbc_btnImportar.gridx = 1;
		gbc_btnImportar.gridy = 0;
		panel_3.add(btnImportar, gbc_btnImportar);
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				 FileNameExtensionFilter filter = new FileNameExtensionFilter("JavaScript Object Notation (*.json)", "json");
				 fc.setFileFilter(filter);
				int opcao = fc.showOpenDialog(null);
				
				 if (opcao == JFileChooser.APPROVE_OPTION) {
	                 try {
						funcionarios.adicionarFuncionarioFromJSON(fc.getSelectedFile().toString());
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(panel, "Ocorreu um erro ao importar o arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
	             } else if (opcao == JFileChooser.CANCEL_OPTION) {
	                 
	             }
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adicionaFuncionario();
				atualizaLista(funcionarios, list);
			}
		});

	}

}
