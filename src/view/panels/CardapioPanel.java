package view.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class CardapioPanel extends JPanel {
	private static final long serialVersionUID = 7726321316097709372L;
	private JTextField textField;
	private JTextField textField_1;

	public CardapioPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel pnlInfo = new JPanel();
		GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
		gbc_pnlInfo.insets = new Insets(5, 5, 0, 0);
		gbc_pnlInfo.fill = GridBagConstraints.BOTH;
		gbc_pnlInfo.gridx = 0;
		gbc_pnlInfo.gridy = 0;
		panel.add(pnlInfo, gbc_pnlInfo);
		GridBagLayout gbl_pnlInfo = new GridBagLayout();
		gbl_pnlInfo.columnWidths = new int[]{0, 0};
		gbl_pnlInfo.rowHeights = new int[]{0, 0, 0};
		gbl_pnlInfo.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlInfo.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		pnlInfo.setLayout(gbl_pnlInfo);
		
		JPanel pnlMainCardapio = new JPanel();
		pnlMainCardapio.setBorder(new TitledBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Card\u00E1pio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Card\u00E1pio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Card\u00E1pio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlMainCardapio = new GridBagConstraints();
		gbc_pnlMainCardapio.fill = GridBagConstraints.BOTH;
		gbc_pnlMainCardapio.gridx = 0;
		gbc_pnlMainCardapio.gridy = 0;
		pnlInfo.add(pnlMainCardapio, gbc_pnlMainCardapio);
		GridBagLayout gbl_pnlMainCardapio = new GridBagLayout();
		gbl_pnlMainCardapio.columnWidths = new int[]{434, 0, 0};
		gbl_pnlMainCardapio.rowHeights = new int[]{0, 0};
		gbl_pnlMainCardapio.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlMainCardapio.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlMainCardapio.setLayout(gbl_pnlMainCardapio);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		pnlMainCardapio.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{323, 265, 0};
		gbl_panel_1.rowHeights = new int[]{47, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(5, 5, 5, 10);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{47, 197, 0};
		gbl_panel_2.rowHeights = new int[]{22, 20, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Cardápio:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel_2.add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_3.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.SOUTH;
		gbc_panel_5.ipady = 10;
		gbc_panel_5.insets = new Insets(5, 5, 0, 10);
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_1.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Itens:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_5.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 0;
		panel_5.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		panel_5.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNomeProd = new JLabel("");
		GridBagConstraints gbc_lblNomeProd = new GridBagConstraints();
		gbc_lblNomeProd.anchor = GridBagConstraints.WEST;
		gbc_lblNomeProd.insets = new Insets(0, 0, 5, 0);
		gbc_lblNomeProd.gridx = 1;
		gbc_lblNomeProd.gridy = 1;
		panel_5.add(lblNomeProd, gbc_lblNomeProd);
		
		JLabel lblNewLabel_5 = new JLabel("Preço:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		panel_5.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblPrecoProd = new JLabel("R$ 0,00");
		GridBagConstraints gbc_lblPrecoProd = new GridBagConstraints();
		gbc_lblPrecoProd.anchor = GridBagConstraints.WEST;
		gbc_lblPrecoProd.gridx = 1;
		gbc_lblPrecoProd.gridy = 2;
		panel_5.add(lblPrecoProd, gbc_lblPrecoProd);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 5, 5, 10);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 2;
		panel_1.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JButton btnNewButton_3 = new JButton("Adicionar");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 0;
		panel_6.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Remover");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 0;
		panel_6.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.NORTH;
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		pnlMainCardapio.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JButton btnNewButton = new JButton("Salvar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_4.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel_4.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panel_4.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel pnlSubCardapio = new JPanel();
		pnlSubCardapio.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)), "Sess\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlSubCardapio = new GridBagConstraints();
		gbc_pnlSubCardapio.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSubCardapio.fill = GridBagConstraints.BOTH;
		gbc_pnlSubCardapio.gridx = 0;
		gbc_pnlSubCardapio.gridy = 1;
		pnlInfo.add(pnlSubCardapio, gbc_pnlSubCardapio);
		GridBagLayout gbl_pnlSubCardapio = new GridBagLayout();
		gbl_pnlSubCardapio.columnWidths = new int[]{612, 0, 0};
		gbl_pnlSubCardapio.rowHeights = new int[]{0, 0};
		gbl_pnlSubCardapio.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSubCardapio.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlSubCardapio.setLayout(gbl_pnlSubCardapio);
		
		JPanel panel_1_1 = new JPanel();
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1.gridx = 0;
		gbc_panel_1_1.gridy = 0;
		pnlSubCardapio.add(panel_1_1, gbc_panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[]{323, 265, 0};
		gbl_panel_1_1.rowHeights = new int[]{47, 0, 0, 0};
		gbl_panel_1_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1_1.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1_1.setLayout(gbl_panel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		GridBagConstraints gbc_panel_2_1 = new GridBagConstraints();
		gbc_panel_2_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2_1.insets = new Insets(5, 5, 5, 5);
		gbc_panel_2_1.gridx = 0;
		gbc_panel_2_1.gridy = 0;
		panel_1_1.add(panel_2_1, gbc_panel_2_1);
		GridBagLayout gbl_panel_2_1 = new GridBagLayout();
		gbl_panel_2_1.columnWidths = new int[]{47, 197, 0};
		gbl_panel_2_1.rowHeights = new int[]{22, 20, 0};
		gbl_panel_2_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2_1.setLayout(gbl_panel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Cardápio:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 0;
		panel_2_1.add(comboBox_2, gbc_comboBox_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 1;
		panel_2_1.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_2_1.add(textField_1, gbc_textField_1);
		
		JPanel panel_3_1 = new JPanel();
		GridBagConstraints gbc_panel_3_1 = new GridBagConstraints();
		gbc_panel_3_1.insets = new Insets(5, 5, 0, 0);
		gbc_panel_3_1.fill = GridBagConstraints.BOTH;
		gbc_panel_3_1.gridheight = 3;
		gbc_panel_3_1.gridx = 1;
		gbc_panel_3_1.gridy = 0;
		panel_1_1.add(panel_3_1, gbc_panel_3_1);
		GridBagLayout gbl_panel_3_1 = new GridBagLayout();
		gbl_panel_3_1.columnWidths = new int[]{0, 0};
		gbl_panel_3_1.rowHeights = new int[]{0, 0};
		gbl_panel_3_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3_1.setLayout(gbl_panel_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_3_1.add(scrollPane_1, gbc_scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JPanel panel_5_1 = new JPanel();
		GridBagConstraints gbc_panel_5_1 = new GridBagConstraints();
		gbc_panel_5_1.ipady = 10;
		gbc_panel_5_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5_1.anchor = GridBagConstraints.SOUTH;
		gbc_panel_5_1.insets = new Insets(5, 5, 5, 5);
		gbc_panel_5_1.gridx = 0;
		gbc_panel_5_1.gridy = 1;
		panel_1_1.add(panel_5_1, gbc_panel_5_1);
		GridBagLayout gbl_panel_5_1 = new GridBagLayout();
		gbl_panel_5_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_5_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5_1.setLayout(gbl_panel_5_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Itens:");
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 0;
		gbc_lblNewLabel_2_1.gridy = 0;
		panel_5_1.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1_1 = new GridBagConstraints();
		gbc_comboBox_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1_1.gridx = 1;
		gbc_comboBox_1_1.gridy = 0;
		panel_5_1.add(comboBox_1_1, gbc_comboBox_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.gridx = 0;
		gbc_lblNewLabel_4_1.gridy = 1;
		panel_5_1.add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);
		
		JLabel lblNomeProd_1 = new JLabel("");
		GridBagConstraints gbc_lblNomeProd_1 = new GridBagConstraints();
		gbc_lblNomeProd_1.anchor = GridBagConstraints.WEST;
		gbc_lblNomeProd_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNomeProd_1.gridx = 1;
		gbc_lblNomeProd_1.gridy = 1;
		panel_5_1.add(lblNomeProd_1, gbc_lblNomeProd_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Preço:");
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5_1.gridx = 0;
		gbc_lblNewLabel_5_1.gridy = 2;
		panel_5_1.add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);
		
		JLabel lblPrecoProd_1 = new JLabel("R$ 0,00");
		GridBagConstraints gbc_lblPrecoProd_1 = new GridBagConstraints();
		gbc_lblPrecoProd_1.anchor = GridBagConstraints.WEST;
		gbc_lblPrecoProd_1.gridx = 1;
		gbc_lblPrecoProd_1.gridy = 2;
		panel_5_1.add(lblPrecoProd_1, gbc_lblPrecoProd_1);
		
		JPanel panel_6_1 = new JPanel();
		GridBagConstraints gbc_panel_6_1 = new GridBagConstraints();
		gbc_panel_6_1.fill = GridBagConstraints.BOTH;
		gbc_panel_6_1.insets = new Insets(0, 5, 5, 5);
		gbc_panel_6_1.gridx = 0;
		gbc_panel_6_1.gridy = 2;
		panel_1_1.add(panel_6_1, gbc_panel_6_1);
		GridBagLayout gbl_panel_6_1 = new GridBagLayout();
		gbl_panel_6_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_6_1.rowHeights = new int[]{0, 0};
		gbl_panel_6_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6_1.setLayout(gbl_panel_6_1);
		
		JButton btnNewButton_3_1 = new JButton("Adicionar");
		GridBagConstraints gbc_btnNewButton_3_1 = new GridBagConstraints();
		gbc_btnNewButton_3_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3_1.gridx = 0;
		gbc_btnNewButton_3_1.gridy = 0;
		panel_6_1.add(btnNewButton_3_1, gbc_btnNewButton_3_1);
		
		JButton btnNewButton_4_1 = new JButton("Remover");
		GridBagConstraints gbc_btnNewButton_4_1 = new GridBagConstraints();
		gbc_btnNewButton_4_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4_1.gridx = 1;
		gbc_btnNewButton_4_1.gridy = 0;
		panel_6_1.add(btnNewButton_4_1, gbc_btnNewButton_4_1);
		
		JPanel panel_4_1 = new JPanel();
		GridBagConstraints gbc_panel_4_1 = new GridBagConstraints();
		gbc_panel_4_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4_1.fill = GridBagConstraints.BOTH;
		gbc_panel_4_1.gridx = 1;
		gbc_panel_4_1.gridy = 0;
		pnlSubCardapio.add(panel_4_1, gbc_panel_4_1);
		GridBagLayout gbl_panel_4_1 = new GridBagLayout();
		gbl_panel_4_1.columnWidths = new int[]{0, 0};
		gbl_panel_4_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_4_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4_1.setLayout(gbl_panel_4_1);
		
		JButton btnNewButton_5 = new JButton("Adicionar");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 0;
		panel_4_1.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_1_1 = new JButton("Cancelar");
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_1.gridx = 0;
		gbc_btnNewButton_1_1.gridy = 1;
		panel_4_1.add(btnNewButton_1_1, gbc_btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Remover");
		GridBagConstraints gbc_btnNewButton_2_1 = new GridBagConstraints();
		gbc_btnNewButton_2_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2_1.gridx = 0;
		gbc_btnNewButton_2_1.gridy = 2;
		panel_4_1.add(btnNewButton_2_1, gbc_btnNewButton_2_1);

	}

}
