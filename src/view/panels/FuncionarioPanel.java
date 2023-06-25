package view.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import backend.Persiste;
import backend.controller.Controller;
import backend.model.Funcionario;
import backend.model.Reserva;

import javax.swing.JSpinner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FuncionarioPanel extends JPanel {
	private Controller<Funcionario> funcionarios;
	private JTextField textNome;
	private JTextField textSobrenome;
	private JTextField textCargo;
	
	private void atualizaLista(Controller controller, JList list) {
		
		ArrayList<String> elements = controller.getNomes();
		
		DefaultListModel model = new DefaultListModel();

		for (String str : elements)
			model.addElement(str);

		list.setModel(model);
	}

	public FuncionarioPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNomeFuncionario = new JLabel("nome funcionario:");
		GridBagConstraints gbc_lblNomeFuncionario = new GridBagConstraints();
		gbc_lblNomeFuncionario.anchor = GridBagConstraints.EAST;
		gbc_lblNomeFuncionario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeFuncionario.gridx = 0;
		gbc_lblNomeFuncionario.gridy = 0;
		add(lblNomeFuncionario, gbc_lblNomeFuncionario);
		
		textNome = new JTextField();
		GridBagConstraints gbc_textNome = new GridBagConstraints();
		gbc_textNome.gridwidth = 4;
		gbc_textNome.insets = new Insets(0, 0, 5, 0);
		gbc_textNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNome.gridx = 1;
		gbc_textNome.gridy = 0;
		add(textNome, gbc_textNome);
		textNome.setColumns(10);
		
		JLabel lblsobrenome = new JLabel("Sobrenome:");
		GridBagConstraints gbc_lblsobrenome = new GridBagConstraints();
		gbc_lblsobrenome.anchor = GridBagConstraints.EAST;
		gbc_lblsobrenome.insets = new Insets(0, 0, 5, 5);
		gbc_lblsobrenome.gridx = 0;
		gbc_lblsobrenome.gridy = 1;
		add(lblsobrenome, gbc_lblsobrenome);
		
		textSobrenome = new JTextField();
		GridBagConstraints gbc_textSobrenome = new GridBagConstraints();
		gbc_textSobrenome.gridwidth = 4;
		gbc_textSobrenome.insets = new Insets(0, 0, 5, 0);
		gbc_textSobrenome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSobrenome.gridx = 1;
		gbc_textSobrenome.gridy = 1;
		add(textSobrenome, gbc_textSobrenome);
		textSobrenome.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		GridBagConstraints gbc_lblCargo = new GridBagConstraints();
		gbc_lblCargo.anchor = GridBagConstraints.EAST;
		gbc_lblCargo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargo.gridx = 0;
		gbc_lblCargo.gridy = 2;
		add(lblCargo, gbc_lblCargo);
		
		textCargo = new JTextField();
		GridBagConstraints gbc_textCargo = new GridBagConstraints();
		gbc_textCargo.gridwidth = 4;
		gbc_textCargo.insets = new Insets(0, 0, 5, 0);
		gbc_textCargo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCargo.gridx = 1;
		gbc_textCargo.gridy = 2;
		add(textCargo, gbc_textCargo);
		textCargo.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horário:");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 0;
		gbc_lblHorario.gridy = 3;
		add(lblHorario, gbc_lblHorario);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 3;
		add(spinner, gbc_spinner);
		
		JLabel lblNewLabel = new JLabel(":\r\n");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JSpinner spinner_1 = new JSpinner();
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 3;
		gbc_spinner_1.gridy = 3;
		add(spinner_1, gbc_spinner_1);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 5;
		gbc_list.gridheight = 6;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.gridx = 0;
		gbc_list.gridy = 4;
		add(list, gbc_list);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionarios.add(new Funcionario(textNome, textCargo, name));
				atualizaLista(funcionarios, list);
				Persiste.salva(funcionarios, "restaurante.txt");
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 10;
		add(btnSalvar, gbc_btnSalvar);
		
		JButton btnImportar = new JButton("Importar\r\n");
		GridBagConstraints gbc_btnImportar = new GridBagConstraints();
		gbc_btnImportar.anchor = GridBagConstraints.EAST;
		gbc_btnImportar.gridx = 4;
		gbc_btnImportar.gridy = 10;
		add(btnImportar, gbc_btnImportar);

	}

}
