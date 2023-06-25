package view.panels;

import javax.swing.JPanel;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import backend.Persiste;
import backend.Restaurante;
import backend.controller.Controller;
import backend.model.Funcionario;
import backend.model.Prato;
import backend.model.Reserva;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerModel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class FuncionarioPanel extends JPanel {
	private JTextField textNomeFuncionario;
	private JTextField textSobrenome;
	private JTextField textCargo;
	

	public FuncionarioPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNomeFuncionario = new JLabel("Nome funcionário:");
		GridBagConstraints gbc_lblNomeFuncionario = new GridBagConstraints();
		gbc_lblNomeFuncionario.anchor = GridBagConstraints.EAST;
		gbc_lblNomeFuncionario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeFuncionario.gridx = 0;
		gbc_lblNomeFuncionario.gridy = 0;
		add(lblNomeFuncionario, gbc_lblNomeFuncionario);
		
		textNomeFuncionario = new JTextField();
		GridBagConstraints gbc_textNomeFuncionario = new GridBagConstraints();
		gbc_textNomeFuncionario.gridwidth = 4;
		gbc_textNomeFuncionario.insets = new Insets(0, 0, 5, 0);
		gbc_textNomeFuncionario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomeFuncionario.gridx = 1;
		gbc_textNomeFuncionario.gridy = 0;
		add(textNomeFuncionario, gbc_textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		GridBagConstraints gbc_lblSobrenome = new GridBagConstraints();
		gbc_lblSobrenome.anchor = GridBagConstraints.EAST;
		gbc_lblSobrenome.insets = new Insets(0, 0, 5, 5);
		gbc_lblSobrenome.gridx = 0;
		gbc_lblSobrenome.gridy = 1;
		add(lblSobrenome, gbc_lblSobrenome);
		
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
		gbc_lblCargo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargo.anchor = GridBagConstraints.EAST;
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
		
		JLabel lblHorário = new JLabel("Horário:");
		GridBagConstraints gbc_lblHorário = new GridBagConstraints();
		gbc_lblHorário.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorário.gridx = 0;
		gbc_lblHorário.gridy = 3;
		add(lblHorário, gbc_lblHorário);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 3;
		add(spinner, gbc_spinner);
		
		JLabel lbldois = new JLabel(":");
		GridBagConstraints gbc_lbldois = new GridBagConstraints();
		gbc_lbldois.insets = new Insets(0, 0, 5, 5);
		gbc_lbldois.gridx = 2;
		gbc_lbldois.gridy = 3;
		add(lbldois, gbc_lbldois);
		
		JSpinner spinner_1 = new JSpinner();
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 3;
		gbc_spinner_1.gridy = 3;
		add(spinner_1, gbc_spinner_1);
		
		JButton btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 10;
		add(btnSalvar, gbc_btnSalvar);
		
		JButton btnImportar = new JButton("Importar");
		GridBagConstraints gbc_btnImportar = new GridBagConstraints();
		gbc_btnImportar.anchor = GridBagConstraints.EAST;
		gbc_btnImportar.gridx = 4;
		gbc_btnImportar.gridy = 10;
		add(btnImportar, gbc_btnImportar);

	}

}
