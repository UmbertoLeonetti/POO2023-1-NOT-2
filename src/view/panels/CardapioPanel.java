package view.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class CardapioPanel extends JPanel {
	private static final long serialVersionUID = 7726321316097709372L;

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
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel pnlInfo = new JPanel();
		GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
		gbc_pnlInfo.insets = new Insets(0, 0, 0, 5);
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
		GridBagConstraints gbc_pnlMainCardapio = new GridBagConstraints();
		gbc_pnlMainCardapio.insets = new Insets(0, 0, 5, 0);
		gbc_pnlMainCardapio.fill = GridBagConstraints.BOTH;
		gbc_pnlMainCardapio.gridx = 0;
		gbc_pnlMainCardapio.gridy = 0;
		pnlInfo.add(pnlMainCardapio, gbc_pnlMainCardapio);
		GridBagLayout gbl_pnlMainCardapio = new GridBagLayout();
		gbl_pnlMainCardapio.columnWidths = new int[]{0};
		gbl_pnlMainCardapio.rowHeights = new int[]{0};
		gbl_pnlMainCardapio.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pnlMainCardapio.rowWeights = new double[]{Double.MIN_VALUE};
		pnlMainCardapio.setLayout(gbl_pnlMainCardapio);
		
		JPanel pnlSubCardapio = new JPanel();
		GridBagConstraints gbc_pnlSubCardapio = new GridBagConstraints();
		gbc_pnlSubCardapio.fill = GridBagConstraints.BOTH;
		gbc_pnlSubCardapio.gridx = 0;
		gbc_pnlSubCardapio.gridy = 1;
		pnlInfo.add(pnlSubCardapio, gbc_pnlSubCardapio);
		GridBagLayout gbl_pnlSubCardapio = new GridBagLayout();
		gbl_pnlSubCardapio.columnWidths = new int[]{0};
		gbl_pnlSubCardapio.rowHeights = new int[]{0};
		gbl_pnlSubCardapio.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pnlSubCardapio.rowWeights = new double[]{Double.MIN_VALUE};
		pnlSubCardapio.setLayout(gbl_pnlSubCardapio);
		
		JPanel pnlButtons = new JPanel();
		GridBagConstraints gbc_pnlButtons = new GridBagConstraints();
		gbc_pnlButtons.insets = new Insets(5, 5, 5, 5);
		gbc_pnlButtons.fill = GridBagConstraints.BOTH;
		gbc_pnlButtons.gridx = 1;
		gbc_pnlButtons.gridy = 0;
		panel.add(pnlButtons, gbc_pnlButtons);
		GridBagLayout gbl_pnlButtons = new GridBagLayout();
		gbl_pnlButtons.columnWidths = new int[]{0, 0};
		gbl_pnlButtons.rowHeights = new int[]{0, 0};
		gbl_pnlButtons.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlButtons.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlButtons.setLayout(gbl_pnlButtons);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		pnlButtons.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton = new JButton("Salvar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 2;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);

	}

}
