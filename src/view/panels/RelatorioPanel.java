package view.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import backend.Restaurante;
import backend.controller.Controller;
import backend.model.Pedido;
import backend.model.Reserva;

import javax.swing.JRadioButton;

public class RelatorioPanel extends JPanel {

	
	private Controller<Reserva> reservas;
	private Controller<Pedido> pedidos;
	
	private String displayDados(Controller controller) {
		
		String output = "";
		ArrayList<Object> elements = controller.getLista();
		
		for (Object obj : elements) {
			output = obj + "\n";
		}
		
		return output;
		
	}
	
	public RelatorioPanel(Restaurante restaurante) {
		
		this.reservas = restaurante.reservas;
		this.pedidos = restaurante.pedidos;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		LocalDate hoje = LocalDate.now();
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JRadioButton rdbtnPedidos = new JRadioButton("Pedidos");
		rdbtnPedidos.setSelected(true);
		GridBagConstraints gbc_rdbtnPedidos = new GridBagConstraints();
		gbc_rdbtnPedidos.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnPedidos.gridx = 0;
		gbc_rdbtnPedidos.gridy = 0;
		panel_4.add(rdbtnPedidos, gbc_rdbtnPedidos);
		
		JRadioButton rdbtnReservas = new JRadioButton("Reservas");
		GridBagConstraints gbc_rdbtnReservas = new GridBagConstraints();
		gbc_rdbtnReservas.gridx = 1;
		gbc_rdbtnReservas.gridy = 0;
		panel_4.add(rdbtnReservas, gbc_rdbtnReservas);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnPedidos);
		buttonGroup.add(rdbtnReservas);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("  Data inicial:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox cbDia01 = new JComboBox();
		GridBagConstraints gbc_cbDia01 = new GridBagConstraints();
		gbc_cbDia01.insets = new Insets(0, 0, 5, 5);
		gbc_cbDia01.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDia01.gridx = 1;
		gbc_cbDia01.gridy = 0;
		panel_1.add(cbDia01, gbc_cbDia01);
		
		JComboBox cbMes01 = new JComboBox();
		GridBagConstraints gbc_cbMes01 = new GridBagConstraints();
		gbc_cbMes01.insets = new Insets(0, 0, 5, 5);
		gbc_cbMes01.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMes01.gridx = 2;
		gbc_cbMes01.gridy = 0;
		panel_1.add(cbMes01, gbc_cbMes01);
		
		JComboBox cbAno01 = new JComboBox();
		GridBagConstraints gbc_cbAno01 = new GridBagConstraints();
		gbc_cbAno01.insets = new Insets(0, 0, 5, 5);
		gbc_cbAno01.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbAno01.gridx = 3;
		gbc_cbAno01.gridy = 0;
		panel_1.add(cbAno01, gbc_cbAno01);
		
		JLabel lblNewLabel_1 = new JLabel("Data final:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JComboBox cbDia02 = new JComboBox();
		GridBagConstraints gbc_cbDia02 = new GridBagConstraints();
		gbc_cbDia02.insets = new Insets(0, 0, 0, 5);
		gbc_cbDia02.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDia02.gridx = 1;
		gbc_cbDia02.gridy = 1;
		panel_1.add(cbDia02, gbc_cbDia02);
		
		JComboBox cbMes02 = new JComboBox();
		GridBagConstraints gbc_cbMes02 = new GridBagConstraints();
		gbc_cbMes02.insets = new Insets(0, 0, 0, 5);
		gbc_cbMes02.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMes02.gridx = 2;
		gbc_cbMes02.gridy = 1;
		panel_1.add(cbMes02, gbc_cbMes02);
		
		JComboBox cbAno02 = new JComboBox();
		GridBagConstraints gbc_cbAno02 = new GridBagConstraints();
		gbc_cbAno02.insets = new Insets(0, 0, 0, 5);
		gbc_cbAno02.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbAno02.gridx = 3;
		gbc_cbAno02.gridy = 1;
		panel_1.add(cbAno02, gbc_cbAno02);
		
		DefaultComboBoxModel<Integer> dias = new DefaultComboBoxModel<Integer>();

		for (int i = 1; i <= 31; i++) {
			dias.addElement(i);
		}
		cbDia01.setModel(dias);
		cbDia02.setModel(dias);
		
		DefaultComboBoxModel<Integer> meses = new DefaultComboBoxModel<Integer>();

		for (int i = 1; i <= 12; i++) {
			meses.addElement(i);
		}
		cbMes01.setModel(meses);
		cbMes02.setModel(meses);
		
		DefaultComboBoxModel<Integer> anos = new DefaultComboBoxModel<Integer>();

		int firstYear = 1900;
		int anoAtual = hoje.getYear();

		for (int i = firstYear; i <= anoAtual; i++) {
			anos.addElement(i);
		}
		
		cbAno01.setModel(anos);
		cbAno02.setModel(anos);
		
		int diaIndex = hoje.getDayOfMonth() - 1;
		int mesIndex = hoje.getMonthValue() - 1;
		int anoIndex = anoAtual - 1900;
		
		cbDia01.setSelectedIndex(diaIndex);
		cbDia02.setSelectedIndex(diaIndex);
		cbMes01.setSelectedIndex(mesIndex);
		cbMes02.setSelectedIndex(mesIndex);
		cbAno01.setSelectedIndex(anoIndex);
		cbAno02.setSelectedIndex(anoIndex);
		
		JButton btnGerar = new JButton("Gerar relatório");
		GridBagConstraints gbc_btnGerar = new GridBagConstraints();
		gbc_btnGerar.anchor = GridBagConstraints.EAST;
		gbc_btnGerar.gridx = 4;
		gbc_btnGerar.gridy = 1;
		panel_1.add(btnGerar, gbc_btnGerar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		rdbtnPedidos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_2.setBorder(new TitledBorder(null, "Pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			}
		});
		
		rdbtnReservas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_2.setBorder(new TitledBorder(null, "Reservas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_2.add(scrollPane, gbc_scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		

		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(displayDados(reservas));
			}
		});
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnCopiar = new JButton("Copiar");
		GridBagConstraints gbc_btnCopiar = new GridBagConstraints();
		gbc_btnCopiar.anchor = GridBagConstraints.EAST;
		gbc_btnCopiar.gridx = 0;
		gbc_btnCopiar.gridy = 0;
		panel_3.add(btnCopiar, gbc_btnCopiar);

	}

}
