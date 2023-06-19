package view.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import backend.Persiste;
import backend.Restaurante;
import backend.controller.Controller;
import backend.model.Cardapio;
import backend.model.Prato;
import backend.model.Produto;

public class CardapioPanel extends JPanel {
	private static final long serialVersionUID = 7726321316097709372L;
	private JTextField tfNome;
	private JList listProd;
	private JList listCardProd;
	private JList listCard;
	
	private int cardSelec = -1;
	private int cardCount = 0;
	private Restaurante restaurante;
	private Cardapio cardapio;
	private Controller<Cardapio> cardapios;
	private JFrame main;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JPanel panel;
	private ArrayList<String> produtos;
	
	private void removeCardapio() {
		ArrayList<String> selected = (ArrayList<String>) listCard.getSelectedValuesList();
		
		int opcao;
		int tamanho = selected.size();
		
		if (tamanho == 1)
			opcao = JOptionPane.showConfirmDialog(panel, "Você realmente deseja excluir o prato \"" + selected.get(0) + "\"?");
		else
			opcao = JOptionPane.showConfirmDialog(panel, "Você realmente deseja excluir os " + tamanho + " pratos selecionados?");

		if (opcao != 0)
			return;
	
		for (String string : selected)
			cardapios.remove(string);
		
		atualizaLista(cardapios.getNomes(), listCard);
		limpaSelecao();
		Persiste.salva(restaurante, "restaurante.txt");
	}
	
	private void limpaSelecao() {
		listCard.clearSelection();
		limpaCampos();
		mudaSalvarCancelar(false);
	}
	
	private void limpaCampos() {		
		tfNome.setText("");
	}

	private void atualizaLista(ArrayList<String> elements, JList list) {
		DefaultListModel model = new DefaultListModel();
		
		for (String str : elements)
			model.addElement(str);
		
		list.setModel(model);
	}
	
	private void mudaSalvarCancelar(boolean acao) {		
		btnSalvar.setEnabled(acao);
		btnCancelar.setEnabled(acao);
	}
	
	private void salvaRestaurante() {
		Persiste.salva(restaurante, "restaurante.txt");
	}
	
	private void adicionaCardapioSessao(String nome) {
		cardCount++;
		cardapios.add(new Cardapio(nome + cardCount));
		atualizaLista(cardapios.getNomes(), listCard);
		salvaRestaurante();
	}
	
	private int selecionaCardapio() {
		String nome = (String) listCard.getSelectedValue();
		if(nome == null)
			return -1;
		
		Cardapio selecionado = cardapios.get(nome);
		
		if(selecionado == null)
			return -1;
		
		tfNome.setText(selecionado.getNome());
		
		return listCard.getSelectedIndex();
	}
	
	private void removeProduto() {
		int ingIndex = listCardProd.getSelectedIndex();
		int pratoIndex = listCard.getSelectedIndex();
		
		if(ingIndex < 0 || pratoIndex < 0) {
			JOptionPane.showMessageDialog(panel, "Ingrediente e prato devem ser selecionados.");
			return;
		}
		
		Cardapio card = cardapios.get(pratoIndex);
		card.removeProduto(card.getProdutos().get(ingIndex).getNome());
		atualizaLista(card.getProdutos().getNomes(), listCardProd);
		Persiste.salva(restaurante, "restaurante.txt");
	}
	
	private void selecionaProduto() {
		int proIndex = listProd.getSelectedIndex();
		int cardIndex = listProd.getSelectedIndex();
		
		if(proIndex < 0 || cardIndex < 0) {
			JOptionPane.showMessageDialog(panel, "Ingrediente e prato devem ser selecionados.");
			return;
		}
		
		Cardapio card = cardapios.get(cardIndex);
		try {
			card.addProduto(restaurante.pratos.get(proIndex));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "O Produto '" + restaurante.pratos.get(proIndex).getNome() + "' Já está no Cardápio '" + card.getNome() + "'");
		}
		atualizaLista(card.getProdutos().getNomes(), listCardProd);
		Persiste.salva(restaurante, "restaurante.txt");
	}

	/**
	 * @wbp.parser.constructor
	 */
	public CardapioPanel(JFrame main, final Restaurante restaurante, Controller<Cardapio> cardapios) {

		produtos = new ArrayList<String>(restaurante.pratos.getTamanho() + restaurante.bebidas.getTamanho());
		produtos.addAll(restaurante.pratos.getNomes());
		produtos.addAll(restaurante.bebidas.getNomes());
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				atualizaLista(produtos, listProd);
			}
		});
		this.cardapios = cardapios;
		this.restaurante = restaurante;
		this.main = main;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 0;
		add(panel, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel_8);
		
		JPanel pnlInfo = new JPanel();
		GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
		gbc_pnlInfo.insets = new Insets(5, 5, 5, 5);
		gbc_pnlInfo.fill = GridBagConstraints.BOTH;
		gbc_pnlInfo.gridx = 0;
		gbc_pnlInfo.gridy = 0;
		panel.add(pnlInfo, gbc_pnlInfo);
		GridBagLayout gbl_pnlInfo = new GridBagLayout();
		gbl_pnlInfo.columnWidths = new int[]{147, 384, 0};
		gbl_pnlInfo.rowHeights = new int[]{0, 0};
		gbl_pnlInfo.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlInfo.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlInfo.setLayout(gbl_pnlInfo);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		pnlInfo.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
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
		
		listCard = new JList();
		listCard.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				cardSelec = selecionaCardapio();
				mudaSalvarCancelar(true);
				if(cardSelec == -1)
					return;
				
				atualizaLista(cardapios.get(cardSelec).getProdutos().getNomes(), listCardProd);
			}
		});
		atualizaLista(cardapios.getNomes(), listCard);
		scrollPane.setViewportView(listCard);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_2.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JButton btnNewButton_2 = new JButton("Adicionar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaCardapioSessao("Cardápio ");
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 0;
		panel_5.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCardapio();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 0;
		panel_5.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Novo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		pnlInfo.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 5, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.insets = new Insets(0, 0, 5, 0);
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 0;
		panel_4.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridwidth = 2;
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 1;
		panel_4.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 2;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 0;
		panel_7.add(scrollPane_2, gbc_scrollPane_2);
		
		listProd = new JList();
		ArrayList<String> str = new ArrayList<String>(restaurante.pratos.getTamanho() + restaurante.bebidas.getTamanho());
		str.addAll(restaurante.pratos.getNomes());
		str.addAll(restaurante.bebidas.getNomes());
		
		atualizaLista(str, listProd);
		scrollPane_2.setViewportView(listProd);
		
		JButton btnNewButton_5 = new JButton(">>");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionaProduto();

				Persiste.salva(restaurante, "restaurante.txt");
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 0;
		panel_7.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 0;
		panel_7.add(scrollPane_1, gbc_scrollPane_1);
		
		listCardProd = new JList();
		scrollPane_1.setViewportView(listCardProd);
		
		JButton btnNewButton_6 = new JButton("<<");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeProduto();
				Persiste.salva(restaurante, "restaurante.txt");
			}
		});
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 1;
		gbc_btnNewButton_6.gridy = 1;
		panel_7.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 5, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		panel_1.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cardapio p = cardapios.get((String)listCard.getSelectedValue());
				
				p.setNome(tfNome.getText());

				atualizaLista(cardapios.getNomes(), listCard);
				limpaSelecao();
				Persiste.salva(restaurante, "restaurante.txt");
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 0;
		panel_6.add(btnSalvar, gbc_btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_BtnCancelar = new GridBagConstraints();
		gbc_BtnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_BtnCancelar.gridx = 1;
		gbc_BtnCancelar.gridy = 0;
		panel_6.add(btnCancelar, gbc_BtnCancelar);

	}

}
