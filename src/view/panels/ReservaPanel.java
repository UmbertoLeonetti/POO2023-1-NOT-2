package view.panels;

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

//Para finalizar.
// adicionar salvamento 
// adicionar um controller de reserva no restaurante 

public class ReservaPanel extends JPanel {

	private JTextField tfCliente;
	private JTextField tfMesa;
	private JComboBox cbDia;
	private JComboBox cbMes;
	private JComboBox cbAno;
	private JList list;
	private JList listReserva;
	// private ArrayList<String> reservas;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnExcluir;
	private JButton btnConsultar;
	private JSpinner spinnerHora;
	private JSpinner spinnerMinuto;

	private Restaurante restaurante;
	private ArrayList<String> reservas;
	private Controller<Reserva> reservasList;

	private void atualizaLista(ArrayList<String> reservas, JList list) {
		DefaultListModel model = new DefaultListModel();

		for (String str : reservas)
			model.addElement(str);

		list.setModel(model);
	}

	private void limpaCampos() {
		LocalDate hoje = LocalDate.now();
		LocalTime agora = LocalTime.now();
		tfCliente.setText("");
		tfMesa.setText("");
		cbDia.setSelectedIndex(hoje.getDayOfMonth() - 1);
		cbMes.setSelectedIndex(hoje.getMonthValue() - 1);
		cbAno.setSelectedIndex(0);

		int hora = agora.getHour();
		int minuto = agora.getMinute();
		spinnerHora.setModel(new SpinnerNumberModel(hora, 0, 23, 1));
		spinnerMinuto.setModel(new SpinnerNumberModel(minuto, 0, 59, 1));
	}

	private void limpaSelecao() {
		list.clearSelection();
		limpaCampos();
		mudaSalvarCancelar(false);
	}

	private void mudaSalvarCancelar(boolean mod) {
		btnSalvar.setEnabled(!mod);
		btnCancelar.setEnabled(mod);
		btnExcluir.setEnabled(mod);
		btnConsultar.setEnabled(mod);
	}

	public ReservaPanel(Restaurante restaurante) {
		this.restaurante = restaurante;
		this.reservasList = restaurante.reservas;

		reservas = new ArrayList<String>();
		LocalDate hoje = LocalDate.now();
		LocalTime agora = LocalTime.now();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNomeCliente = new JLabel("  Nome cliente:");
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeCliente.anchor = GridBagConstraints.EAST;
		gbc_lblNomeCliente.gridx = 0;
		gbc_lblNomeCliente.gridy = 0;
		panel_2.add(lblNomeCliente, gbc_lblNomeCliente);

		tfCliente = new JTextField();
		GridBagConstraints gbc_tfCliente = new GridBagConstraints();
		gbc_tfCliente.insets = new Insets(0, 0, 5, 0);
		gbc_tfCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCliente.gridx = 1;
		gbc_tfCliente.gridy = 0;
		panel_2.add(tfCliente, gbc_tfCliente);
		tfCliente.setColumns(10);

		JLabel lblMesa = new JLabel("Mesa:");
		GridBagConstraints gbc_lblMesa = new GridBagConstraints();
		gbc_lblMesa.anchor = GridBagConstraints.EAST;
		gbc_lblMesa.insets = new Insets(0, 0, 5, 5);
		gbc_lblMesa.gridx = 0;
		gbc_lblMesa.gridy = 1;
		panel_2.add(lblMesa, gbc_lblMesa);

		tfMesa = new JTextField();
		GridBagConstraints gbc_tfMesa = new GridBagConstraints();
		gbc_tfMesa.insets = new Insets(0, 0, 5, 0);
		gbc_tfMesa.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMesa.gridx = 1;
		gbc_tfMesa.gridy = 1;
		panel_2.add(tfMesa, gbc_tfMesa);
		tfMesa.setColumns(10);

		JLabel lblData = new JLabel("Data:");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.anchor = GridBagConstraints.EAST;
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 2;
		panel_2.add(lblData, gbc_lblData);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 2;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		cbDia = new JComboBox();
		GridBagConstraints gbc_cbDia = new GridBagConstraints();
		gbc_cbDia.insets = new Insets(0, 0, 0, 5);
		gbc_cbDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDia.gridx = 0;
		gbc_cbDia.gridy = 0;
		panel_3.add(cbDia, gbc_cbDia);

		DefaultComboBoxModel<Integer> dias = new DefaultComboBoxModel<Integer>();

		for (int i = 1; i <= 31; i++) {
			dias.addElement(i);
		}
		cbDia.setModel(dias);

		cbMes = new JComboBox();
		GridBagConstraints gbc_cbMes = new GridBagConstraints();
		gbc_cbMes.insets = new Insets(0, 0, 0, 5);
		gbc_cbMes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMes.gridx = 1;
		gbc_cbMes.gridy = 0;
		panel_3.add(cbMes, gbc_cbMes);

		DefaultComboBoxModel<Integer> meses = new DefaultComboBoxModel<Integer>();

		for (int i = 1; i <= 12; i++) {
			meses.addElement(i);
		}
		cbMes.setModel(meses);

		cbAno = new JComboBox();
		GridBagConstraints gbc_cbAno = new GridBagConstraints();
		gbc_cbAno.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbAno.gridx = 2;
		gbc_cbAno.gridy = 0;
		panel_3.add(cbAno, gbc_cbAno);

		DefaultComboBoxModel<Integer> anos = new DefaultComboBoxModel<Integer>();

		int lastYear = 2024;

		for (int i = hoje.getYear(); i <= lastYear; i++) {
			anos.addElement(i);
		}
		cbAno.setModel(anos);

		cbDia.setSelectedIndex(hoje.getDayOfMonth() - 1);
		cbMes.setSelectedIndex(hoje.getMonthValue() - 1);
		cbAno.setSelectedIndex(0);

		JLabel lblHorario = new JLabel("Horário:");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 0, 5);
		gbc_lblHorario.gridx = 0;
		gbc_lblHorario.gridy = 3;
		panel_2.add(lblHorario, gbc_lblHorario);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 3;
		panel_2.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		int hora = agora.getHour();
		int minuto = agora.getMinute();

		spinnerHora = new JSpinner(new SpinnerNumberModel(hora, 0, 23, 1));
		GridBagConstraints gbc_spinnerHora = new GridBagConstraints();
		gbc_spinnerHora.insets = new Insets(0, 0, 0, 5);
		gbc_spinnerHora.gridx = 0;
		gbc_spinnerHora.gridy = 0;
		panel_5.add(spinnerHora, gbc_spinnerHora);

		JLabel lblDoisPontos = new JLabel(":");
		GridBagConstraints gbc_lblDoisPontos = new GridBagConstraints();
		gbc_lblDoisPontos.insets = new Insets(0, 0, 0, 5);
		gbc_lblDoisPontos.gridx = 1;
		gbc_lblDoisPontos.gridy = 0;
		panel_5.add(lblDoisPontos, gbc_lblDoisPontos);

		spinnerMinuto = new JSpinner(new SpinnerNumberModel(minuto, 0, 59, 1));
		GridBagConstraints gbc_spinnerMinuto = new GridBagConstraints();
		gbc_spinnerMinuto.gridx = 2;
		gbc_spinnerMinuto.gridy = 0;
		panel_5.add(spinnerMinuto, gbc_spinnerMinuto);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_4.add(scrollPane, gbc_scrollPane);

		list = new JList();

		scrollPane.setViewportView(list);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (list.getSelectedIndex() == -1) {
					mudaSalvarCancelar(false);
				} else {
					mudaSalvarCancelar(true);
				}
			}
		});

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String element = tfCliente.getText();
				if (element.length() == 0)
					return;

				String nome = tfCliente.getText();
				String mesa = tfMesa.getText();
				String dia = cbDia.getSelectedItem().toString();
				String mes = cbMes.getSelectedItem().toString();
				String ano = cbAno.getSelectedItem().toString();
				int hora = (int) spinnerHora.getValue();
				int minuto = (int) spinnerMinuto.getValue();

				try {
					LocalDate data = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					LocalTime horario = LocalTime.of(hora, minuto);
					Reserva rsv = new Reserva(nome, data, horario);
					reservasList.add(rsv);
					reservas.add(element);
					atualizaLista(reservas, list);
					Persiste.salva(restaurante, "restaurante.txt");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar a reserva:\n" + ex.getMessage(),
							"Erro", JOptionPane.ERROR_MESSAGE);
				}


			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 0;
		panel.add(btnSalvar, gbc_btnSalvar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaSelecao();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 0;
		panel.add(btnCancelar, gbc_btnCancelar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<String> selected = list.getSelectedValuesList();

				for (String string : selected)
					reservas.remove(string);
				atualizaLista(reservas, list);
				limpaCampos();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 0;
		panel.add(btnExcluir, gbc_btnExcluir);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarObjeto();
			}

			private void mostrarObjeto() {

				for (Reserva rsv : reservasList.getLista()) {

					atualizaLista(reservas, list);
					limpaCampos();
				}
			}
		});
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.anchor = GridBagConstraints.EAST;
		gbc_btnConsultar.gridx = 3;
		gbc_btnConsultar.gridy = 0;
		panel.add(btnConsultar, gbc_btnConsultar);
		mudaSalvarCancelar(false);
	}
}