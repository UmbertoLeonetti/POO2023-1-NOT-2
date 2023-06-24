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
import javax.swing.SpinnerModel;

//Para finalizar.
// adicionar salvamento 
// adicionar um controller de reserva no restaurante 

public class ReservaPanel extends JPanel {
	private JList listReserva;

	private Restaurante restaurante;
	private Controller<Reserva> reservas;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNomeCliente;
	private JTextField tfCliente;
	private JLabel lblMesa;
	private JTextField tfMesa;
	private JLabel lblData;
	private JPanel panel_3;
	private JComboBox<Integer> cbDia;
	private JComboBox<Integer> cbMes;
	private JComboBox<Integer> cbAno;
	private JLabel lblHorario;
	private JPanel panel_4;
	private JSpinner spinnerHora;
	private JLabel lblDoisPontos;
	private JSpinner spinnerMinuto;
	private JPanel panel_5;
	private JScrollPane scrollPane;
	private JPanel panel_6;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnExcluir;
	private JList list;
	private JButton btnAdd;

	private void atualizaLista(Controller controller, JList list) {
		
		ArrayList<String> elements = controller.getNomes();
		
		DefaultListModel model = new DefaultListModel();

		for (String str : elements)
			model.addElement(str);

		list.setModel(model);
	}
	
	private void removeReserva() {
		ArrayList<String> selected = (ArrayList<String>) list.getSelectedValuesList();
		
		int opcao;
		int tamanho = selected.size();
		
		if (tamanho == 1)
			opcao = JOptionPane.showConfirmDialog(panel, "Você realmente deseja excluir a reserva de \"" + selected.get(0) + "\"?");
		else
			opcao = JOptionPane.showConfirmDialog(panel, "Você realmente deseja excluir as " + tamanho + " reservas selecionadas?");

		if (opcao != 0)
			return;
	
		for (String string : selected)
			reservas.remove(string);
		
		atualizaLista(reservas, list);
		limpaSelecao();
		Persiste.salva(restaurante, "restaurante.txt");
		
	}
	
	private void limpaSelecao() {
		list.clearSelection();
		atualizaLista(reservas, list);
		mudaSalvarCancelar(false);
		limpaCampos();
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
	
	private int selecionaReserva() {
		String nome = (String) list.getSelectedValue();
		if(nome == null)
			return -1;
		
		Reserva selecionado = reservas.get(nome);
		
		if(selecionado == null)
			return -1;
		
		LocalDate hoje = LocalDate.now();
		LocalTime agora = LocalTime.now();
		tfCliente.setText(selecionado.getNome());
		tfMesa.setText("" + selecionado.getMesa());
		cbDia.setSelectedIndex(selecionado.getData().getDayOfMonth() - 1);
		cbMes.setSelectedIndex(selecionado.getData().getMonthValue() - 1);
		cbAno.setSelectedItem(selecionado.getData().getYear());
		
		spinnerHora.setModel(new SpinnerNumberModel(selecionado.getHorario().getHour(), 0, 23, 1));
		spinnerMinuto.setModel(new SpinnerNumberModel(selecionado.getHorario().getMinute(), 0, 59, 1));
		
		mudaSalvarCancelar(true);
		return list.getSelectedIndex();
	}

	private void mudaSalvarCancelar(boolean mod) {
		btnSalvar.setEnabled(mod);
		btnCancelar.setEnabled(mod);
		btnExcluir.setEnabled(mod);
		btnAdd.setEnabled(!mod);
	}

	public ReservaPanel(Restaurante restaurante) {
		this.restaurante = restaurante;
		this.reservas = restaurante.reservas;

		LocalDate hoje = LocalDate.now();
		LocalTime agora = LocalTime.now();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		lblNomeCliente = new JLabel("  Nome cliente:");
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.anchor = GridBagConstraints.EAST;
		gbc_lblNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeCliente.gridx = 0;
		gbc_lblNomeCliente.gridy = 0;
		panel_2.add(lblNomeCliente, gbc_lblNomeCliente);
		
		tfCliente = new JTextField();
		tfCliente.setColumns(10);
		GridBagConstraints gbc_tfCliente = new GridBagConstraints();
		gbc_tfCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCliente.insets = new Insets(0, 0, 5, 0);
		gbc_tfCliente.gridx = 1;
		gbc_tfCliente.gridy = 0;
		panel_2.add(tfCliente, gbc_tfCliente);
		
		lblMesa = new JLabel("Mesa:");
		GridBagConstraints gbc_lblMesa = new GridBagConstraints();
		gbc_lblMesa.anchor = GridBagConstraints.EAST;
		gbc_lblMesa.insets = new Insets(0, 0, 5, 5);
		gbc_lblMesa.gridx = 0;
		gbc_lblMesa.gridy = 1;
		panel_2.add(lblMesa, gbc_lblMesa);
		
		tfMesa = new JTextField();
		tfMesa.setColumns(10);
		GridBagConstraints gbc_tfMesa = new GridBagConstraints();
		gbc_tfMesa.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMesa.insets = new Insets(0, 0, 5, 0);
		gbc_tfMesa.gridx = 1;
		gbc_tfMesa.gridy = 1;
		panel_2.add(tfMesa, gbc_tfMesa);
		
		lblData = new JLabel("Data:");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.anchor = GridBagConstraints.EAST;
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 2;
		panel_2.add(lblData, gbc_lblData);
		
		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 2;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		cbDia = new JComboBox();
		GridBagConstraints gbc_cbDia = new GridBagConstraints();
		gbc_cbDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDia.insets = new Insets(0, 0, 0, 5);
		gbc_cbDia.gridx = 0;
		gbc_cbDia.gridy = 0;
		panel_3.add(cbDia, gbc_cbDia);
		
		cbMes = new JComboBox<Integer>();
		GridBagConstraints gbc_cbMes = new GridBagConstraints();
		gbc_cbMes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMes.insets = new Insets(0, 0, 0, 5);
		gbc_cbMes.gridx = 1;
		gbc_cbMes.gridy = 0;
		panel_3.add(cbMes, gbc_cbMes);
		
		cbAno = new JComboBox<Integer>();
		GridBagConstraints gbc_cbAno = new GridBagConstraints();
		gbc_cbAno.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbAno.gridx = 2;
		gbc_cbAno.gridy = 0;
		panel_3.add(cbAno, gbc_cbAno);
		
		DefaultComboBoxModel<Integer> dias = new DefaultComboBoxModel<Integer>();

		for (int i = 1; i <= 31; i++) {
			dias.addElement(i);
		}
		cbDia.setModel(dias);
		
		DefaultComboBoxModel<Integer> meses = new DefaultComboBoxModel<Integer>();

		for (int i = 1; i <= 12; i++) {
			meses.addElement(i);
		}
		cbMes.setModel(meses);
		
		DefaultComboBoxModel<Integer> anos = new DefaultComboBoxModel<Integer>();

		int lastYear = hoje.getYear() + 1;

		for (int i = hoje.getYear(); i <= lastYear; i++) {
			anos.addElement(i);
		}
		
		cbAno.setModel(anos);
		
		lblHorario = new JLabel("Horário:");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 0, 5);
		gbc_lblHorario.gridx = 0;
		gbc_lblHorario.gridy = 3;
		panel_2.add(lblHorario, gbc_lblHorario);
		
		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 3;
		panel_2.add(panel_4, gbc_panel_4);
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
		
		lblDoisPontos = new JLabel(":");
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
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_1.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_5.add(scrollPane, gbc_scrollPane);
		
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				selecionaReserva();
			}
		});
		scrollPane.setViewportView(list);

		
		panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.anchor = GridBagConstraints.NORTH;
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		panel.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reserva reserva = reservas.get(list.getSelectedIndex());
				reserva.setNome(tfCliente.getText());
				LocalDate data = LocalDate.of((int) cbAno.getSelectedItem(), cbMes.getSelectedIndex() + 1, cbDia.getSelectedIndex() + 1);
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
				
				
				LocalTime horaLocalTime = LocalTime.of(horaInt, minutoInt);
				reserva.setDataHorario(data, horaLocalTime);
				reserva.setMesa(Integer.parseInt(tfMesa.getText()));
				limpaSelecao();
				Persiste.salva(restaurante, "restaurante.txt");
			}
		});
		
		btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservas.add(new Reserva());
				atualizaLista(reservas, list);
				Persiste.salva(restaurante, "restaurante.txt");
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		panel_6.add(btnAdd, gbc_btnAdd);
		btnSalvar.setEnabled(false);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.EAST;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 0;
		panel_6.add(btnSalvar, gbc_btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpaSelecao();
			}
		});
		btnCancelar.setEnabled(false);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 0;
		panel_6.add(btnCancelar, gbc_btnCancelar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeReserva();
				atualizaLista(reservas, list);
				limpaSelecao();
			}
		});
		btnExcluir.setEnabled(false);
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 0;
		panel_6.add(btnExcluir, gbc_btnExcluir);
		
		limpaSelecao();

	}
}