package view.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import backend.controller.IngredienteController;
import backend.model.Ingrediente;
import javax.swing.SpinnerNumberModel;

public class IngredientePanel extends JPanel {
	private JTextField tfNome;
	private JTextField tfPreco;	
	private JTextField tfPesquisa;
	private JSpinner spQuantidade;
	private JList list;

	private IngredienteController ingredientes;
	private int ingSelec = 0;
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	
	//Método contém que verifica se a String a contém a String b
	private boolean contem(String a, String b) {
		
		int q1 = a.length();
		int q2 = b.length();
		
		if (q1 < q2) {
			
			return false;
			
		}
		
		for (int i = 0; i < q2; i++) {
			
			char charA = a.toUpperCase().charAt(i);
			char charB = b.toUpperCase().charAt(i);
			
			if (charA != charB) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	
	//Método retorna os nomes de ingredientes que possuem a String nomePesquisa 
	public ArrayList<String> getIngredientes(String nomePesquisa) {
		
		ArrayList<String> nomes = ingredientes.getNomes();
		ArrayList<String> nomesPesquisa = new ArrayList<String>();
		
		for (String nome : nomes) {
			
			if (contem(nome, nomePesquisa)) {
				
				nomesPesquisa.add(nome);
				
			}
			
		}
		
		return nomesPesquisa;
		
	}
	
	private void novoIngrediente() {
		ingredientes.add();
	}
	
	private void excluiIngrediente() {
		String selected = (String) list.getSelectedValue();
		
		ingredientes.remove(selected);
	}
	
	private int selecionaIngrediente() {
		String nome = (String) list.getSelectedValue();
		Ingrediente selecionado = ingredientes.get(nome);
		
		if(selecionado == null)
			return -1;
		
		tfNome.setText(selecionado.getNome());
		tfPreco.setText(String.format("%.2f", selecionado.getPreco()));
		spQuantidade.setValue(selecionado.getQuantidade());
		
		return list.getSelectedIndex();
	}
	
	private void atualizaLista() {
		
		DefaultListModel model = new DefaultListModel();
		ArrayList<String> elements = getIngredientes(tfPesquisa.getText());
		
		for (String string : elements)
			model.addElement(string);
		
		list.setModel(model);
	}
	
	private void limpaCampos() {
		tfNome.setText("");
		tfPreco.setText("");
		spQuantidade.setValue(0);
	}
	
	private void mudaSalvarCancelar(boolean mod) {
		btnSalvar.setEnabled(mod);
		btnCancelar.setEnabled(mod);
	}
	
	private void salvaIngrediente() {
		ingredientes.remove(ingSelec);
		
		String nome = tfNome.getText();
		float preco = Float.parseFloat(tfPreco.getText().replace(',', '.'));
		int qtd 	= Integer.parseInt(spQuantidade.getValue().toString());
		
		ingredientes.add(new Ingrediente(nome, preco, qtd), ingSelec);
		
		ingSelec = -1;
	}
	
	public IngredientePanel(IngredienteController ingredientes) {
		this.ingredientes = ingredientes;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 5, 5, 5);
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
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 294, 321, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Pesquisa:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(5, 0, 0, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfPesquisa = new JTextField();
		GridBagConstraints gbc_tfPesquisa = new GridBagConstraints();
		gbc_tfPesquisa.anchor = GridBagConstraints.NORTH;
		gbc_tfPesquisa.insets = new Insets(7, 0, 0, 5);
		gbc_tfPesquisa.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPesquisa.gridx = 1;
		gbc_tfPesquisa.gridy = 0;
		panel_1.add(tfPesquisa, gbc_tfPesquisa);
		tfPesquisa.setColumns(10);
		
        tfPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               atualizaLista();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
            	atualizaLista();
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
		
		JPanel pnlLista = new JPanel();
		GridBagConstraints gbc_pnlLista = new GridBagConstraints();
		gbc_pnlLista.gridwidth = 2;
		gbc_pnlLista.insets = new Insets(7, 0, 0, 5);
		gbc_pnlLista.fill = GridBagConstraints.BOTH;
		gbc_pnlLista.gridx = 0;
		gbc_pnlLista.gridy = 1;
		panel_1.add(pnlLista, gbc_pnlLista);
		GridBagLayout gbl_pnlLista = new GridBagLayout();
		gbl_pnlLista.columnWidths = new int[]{0, 0};
		gbl_pnlLista.rowHeights = new int[]{0, 17, 0};
		gbl_pnlLista.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlLista.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		pnlLista.setLayout(gbl_pnlLista);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlLista.add(scrollPane, gbc_scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				ingSelec = selecionaIngrediente();
				mudaSalvarCancelar(true);
			}
		});
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 1, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		pnlLista.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JButton btnNewButton = new JButton("Adicionar Novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novoIngrediente();
				atualizaLista();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_4.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluiIngrediente();
				atualizaLista();
				limpaCampos();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel_4.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)), "Novo Ingrediente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(5, 5, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 33, 0, 81, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.gridwidth = 3;
		gbc_tfNome.insets = new Insets(0, 0, 5, 0);
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 0;
		panel_3.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preço:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfPreco = new JTextField();
		GridBagConstraints gbc_tfPreco = new GridBagConstraints();
		gbc_tfPreco.insets = new Insets(0, 0, 0, 5);
		gbc_tfPreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPreco.gridx = 1;
		gbc_tfPreco.gridy = 1;
		panel_3.add(tfPreco, gbc_tfPreco);
		tfPreco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		spQuantidade = new JSpinner();
		spQuantidade.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		GridBagConstraints gbc_spQuantidade = new GridBagConstraints();
		gbc_spQuantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_spQuantidade.gridx = 3;
		gbc_spQuantidade.gridy = 1;
		panel_3.add(spQuantidade, gbc_spQuantidade);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(5, 5, 5, 5);
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
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvaIngrediente();
				limpaCampos();
				atualizaLista();
				mudaSalvarCancelar(false);
			}
		});
		btnSalvar.setEnabled(false);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 0;
		panel_5.add(btnSalvar, gbc_btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaSalvarCancelar(false);
				limpaCampos();
				
			}
		});
		btnCancelar.setEnabled(false);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 0;
		panel_5.add(btnCancelar, gbc_btnCancelar);

	}

}
