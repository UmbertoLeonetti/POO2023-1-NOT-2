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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import backend.Persiste;
import backend.Restaurante;
import backend.controller.Controller;
import backend.model.Ingrediente;
import backend.model.Prato;

public class PratoPanel extends JPanel {
	
	private JPanel panel;
	private JTextField tfNome;
	private JTextField tfPreco;
	private JList listPrato;
	private JSpinner spPeso;
	private JTextArea taObservacao;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnExcluir;
	private JList<String> listIngrediente;
	private JList listPratoIngrediente;
	
	private Restaurante restaurante;
	private Controller<Prato> pratos;
	private Controller<Ingrediente> ingredientes;
	private int pratoSelec = -1;
	private int nomeCount = 0;
	
	private void atualizaLista(ArrayList<String> elements, JList list) {
		DefaultListModel model = new DefaultListModel();
		
		for (String str : elements)
			model.addElement(str);
		
		list.setModel(model);
	}

	private void adicionaPrato() {
		nomeCount++;
		pratos.add(new Prato("Prato " + nomeCount));
		atualizaLista(pratos.getNomes(), listPrato);
		Persiste.salva(restaurante, "restaurante.txt");
	}

	private void removePrato() {
		ArrayList<String> selected = (ArrayList<String>) listPrato.getSelectedValuesList();
		
		int opcao;
		int tamanho = selected.size();
		
		if (tamanho == 1)
			opcao = JOptionPane.showConfirmDialog(panel, "Você realmente deseja excluir o prato \"" + selected.get(0) + "\"?");
		else
			opcao = JOptionPane.showConfirmDialog(panel, "Você realmente deseja excluir os " + tamanho + " pratos selecionados?");

		if (opcao != 0)
			return;
	
		for (String string : selected)
			pratos.remove(string);
		
		atualizaLista(pratos.getNomes(), listPrato);
		limpaSelecao();
		Persiste.salva(restaurante, "restaurante.txt");
	}
	
	private int selecionaPrato() {
		String nome = (String) listPrato.getSelectedValue();
		if(nome == null)
			return -1;
		
		Prato selecionado = pratos.get(nome);
		
		if(selecionado == null)
			return -1;
		
		tfNome.setText(selecionado.getNome());
		tfPreco.setText(String.format("%.2f", selecionado.getValor()));
		spPeso.setValue(selecionado.getGramas());
		taObservacao.setText(selecionado.getDesc());
		
		return listPrato.getSelectedIndex();
	}
	
	private void adicionaIngrediente() {
		int ingIndex = listIngrediente.getSelectedIndex();
		int pratoIndex = listPrato.getSelectedIndex();
		
		if(ingIndex < 0 || pratoIndex < 0) {
			JOptionPane.showMessageDialog(panel, "Ingrediente e prato devem ser selecionados.");
			return;
		}
		
		Prato prato = pratos.get(pratoIndex);
		try {
			prato.addIngrediente(ingredientes.get(ingIndex));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "O ingrediente '" + ingredientes.get(ingIndex).getNome() + "' Já está no prato '" + prato.getNome() + "'");
		}
		atualizaLista(prato.getIngredientes().getNomes(), listPratoIngrediente);
		Persiste.salva(restaurante, "restaurante.txt");
	}
	
	private void removeIngrediente() {
		int ingIndex = listPratoIngrediente.getSelectedIndex();
		int pratoIndex = listPrato.getSelectedIndex();
		
		if(ingIndex < 0 || pratoIndex < 0) {
			JOptionPane.showMessageDialog(panel, "Ingrediente e prato devem ser selecionados.");
			return;
		}
		
		Prato prato = pratos.get(pratoIndex);
		prato.removeIngrediente(prato.getIngredientes().get(ingIndex).getNome());
		atualizaLista(prato.getIngredientes().getNomes(), listPratoIngrediente);
		Persiste.salva(restaurante, "restaurante.txt");
	}
	
	private void limpaCampos() {		
		tfNome.setText("");
		tfPreco.setText("");
		spPeso.setValue(0);
		taObservacao.setText("");
	}
	
	private void limpaSelecao() {
		listPrato.clearSelection();
		limpaCampos();
		mudaSalvarCancelar(false);
	}

	private void mudaSalvarCancelar(boolean mod) {
		btnSalvar.setEnabled(mod);
		btnCancelar.setEnabled(mod);
		btnExcluir.setEnabled(mod);
	}

	public PratoPanel(Restaurante restaurante) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				atualizaLista(ingredientes.getNomes(), listIngrediente);
			}
		});
		
		this.restaurante = restaurante;
		this.pratos = restaurante.pratos;
		this.ingredientes = restaurante.ingredientes;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(8, 8, 8, 8);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{429, 233, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{20, 102, 36, 91, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 143, 301, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.gridwidth = 3;
		gbc_tfNome.insets = new Insets(0, 0, 5, 0);
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 0;
		panel_1.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preço:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfPreco = new JTextField();
		GridBagConstraints gbc_tfPreco = new GridBagConstraints();
		gbc_tfPreco.insets = new Insets(0, 0, 5, 5);
		gbc_tfPreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPreco.gridx = 1;
		gbc_tfPreco.gridy = 1;
		panel_1.add(tfPreco, gbc_tfPreco);
		tfPreco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Peso(g):");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 1;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		spPeso = new JSpinner();
		spPeso.setModel(new SpinnerNumberModel(0, 0, 10000, 50));
		GridBagConstraints gbc_spPeso = new GridBagConstraints();
		gbc_spPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_spPeso.insets = new Insets(0, 0, 5, 0);
		gbc_spPeso.gridx = 3;
		gbc_spPeso.gridy = 1;
		panel_1.add(spPeso, gbc_spPeso);
		
		JLabel lblNewLabel_2 = new JLabel("Observações:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		taObservacao = new JTextArea();
		taObservacao.setWrapStyleWord(true);
		GridBagConstraints gbc_taObservacao = new GridBagConstraints();
		gbc_taObservacao.gridwidth = 3;
		gbc_taObservacao.insets = new Insets(0, 0, 5, 0);
		gbc_taObservacao.fill = GridBagConstraints.BOTH;
		gbc_taObservacao.gridx = 1;
		gbc_taObservacao.gridy = 2;
		panel_1.add(taObservacao, gbc_taObservacao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)), "Ingredientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridwidth = 4;
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 2;
		gbc_panel_5.insets = new Insets(5, 5, 0, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_4.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_5.add(scrollPane_1, gbc_scrollPane_1);
		
		listIngrediente = new JList();
		scrollPane_1.setViewportView(listIngrediente);
		
		JButton btnNewButton_2 = new JButton(">>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaIngrediente();
				atualizaLista(ingredientes.getNomes(), listIngrediente);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 0;
		panel_5.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.gridheight = 2;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 0;
		panel_5.add(scrollPane_2, gbc_scrollPane_2);
		
		listPratoIngrediente = new JList();
		scrollPane_2.setViewportView(listPratoIngrediente);
		
		JButton btnNewButton_3 = new JButton("<<");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeIngrediente();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 1;
		panel_5.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prato p = pratos.get((String)listPrato.getSelectedValue());
				
				p.setNome(tfNome.getText());
				p.setDesc(taObservacao.getText());
				
				Object peso = spPeso.getValue();
				int pesoInt;
				
				if (peso instanceof Double) {
					Double pesoDouble = (Double) peso;
					pesoInt = pesoDouble.intValue();
		
				} else 
					pesoInt = (Integer) peso;
				
				p.setGramas(pesoInt);
				
				String precoString = tfPreco.getText();

				precoString = precoString.replace(",", ".");
				p.setValor(Float.parseFloat(precoString));
				atualizaLista(pratos.getNomes(), listPrato);
				limpaSelecao();
			}
		});
		btnSalvar.setEnabled(false);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 0;
		panel_2.add(btnSalvar, gbc_btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaSelecao();
			}
		});
		btnCancelar.setEnabled(false);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 0;
		panel_2.add(btnCancelar, gbc_btnCancelar);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_3.add(scrollPane, gbc_scrollPane);
		
		listPrato = new JList();
		atualizaLista(pratos.getNomes(), listPrato);
		atualizaLista(ingredientes.getNomes(), listIngrediente);
		scrollPane.setViewportView(listPrato);
		listPrato.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				pratoSelec = selecionaPrato();
				mudaSalvarCancelar(true);
				if(pratoSelec == -1)
					return;
				
				atualizaLista(pratos.get(pratoSelec).getIngredientes().getNomes(), listPratoIngrediente);
			}
		});
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaPrato();
			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 0;
		gbc_btnAdicionar.gridy = 1;
		panel_3.add(btnAdicionar, gbc_btnAdicionar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePrato();
			}
		});
		btnExcluir.setEnabled(false);
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 1);
		gbc_btnExcluir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExcluir.gridx = 1;
		gbc_btnExcluir.gridy = 1;
		panel_3.add(btnExcluir, gbc_btnExcluir);

	}

}
