/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysmac.view;

import br.com.sysmac.entitys.Cliente;
import br.com.sysmac.entitys.Produto;
import br.com.sysmac.entitys.Venda;
import br.com.sysmac.exceptions.ClienteExceptions;
import br.com.sysmac.servico.VendaService;
import br.com.sysmac.util.AppContext;
import br.com.sysmac.util.DefaultList;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Optional;

import static javax.swing.JOptionPane.*;

public class FormVendas extends javax.swing.JInternalFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -7606177640563166796L;
	private VendaService vendaService;
	@SuppressWarnings("unused")
	private DefaultListModel<Object> model;

	private static String orc;
	private static String vd;

	private DefaultList defaultList;

	public FormVendas() {
		vendaService = AppContext.getInstance().getContext().getBean(VendaService.class);
		initComponents();
		status.setVisible(false);
		model = new DefaultListModel<>();
		defaultList = new DefaultList();

	}

	public void verificaCLienteNull() {

		if (txtNomeCliente.getText().equals("") && txtIdCliente.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Cliente obrigatório para venda");
			throw new ClienteExceptions("Cliente obrigatório para venda");
		} else {
			insertIdVenda();

		}
	}

	public double atualizaValorVenda(double qtde, double valorUn) {

		double valor = 0;
		valor += qtde * valorUn;
		recebeCalculo.setText(qtde + " * " + valorUn + " = " + valor);
		txtValorTotalVenda.setText(String.valueOf(valor));
		return valor;
	}

	public void insertIdVenda() {

		JRadioButton orcamentoButton = new JRadioButton();
		orcamentoButton.setText("Orçamento");
		orcamentoButton.setModel(orcamentoRadioButton.getModel());

		String st = "A";

		JRadioButton vendaButton = new JRadioButton();
		vendaButton.setText("Venda");
		vendaButton.setModel(vendaRadioButton.getModel());

		showMessageDialog(rootPane, new Object[]{"Abertura ", orcamentoButton, vendaButton}, "Tipo de venda:",
				PLAIN_MESSAGE);

		if (orcamentoButton.isSelected()) {
			status.setVisible(true);
			Venda venda = this.vendaService.iniciaCodigoVenda(new Venda(), orc, st);
			txtIdVenda.setText(String.valueOf(venda.getId()));
			dataInicioVenda.setDate(venda.getDataVenda());
			status.setText("Orçamento aberto");
			btnInserir.setText("Cancelar Orcamento");
			enableButtonFalse();

		} else if (vendaButton.isSelected()) {
			status.setVisible(true);
			Venda venda = vendaService.iniciaCodigoVenda(new Venda(), vd, st);
			txtIdVenda.setText(String.valueOf(venda.getId()));
			dataInicioVenda.setDate(venda.getDataVenda());
			status.setText("Venda Aberta");
			btnInserir.setText("Cancelar Venda");
			enableButtonFalse();

		}

	}

	public void insertVendaItem(Double qtde, double valorAcrescimo, double valorDesconto) {
		if (qtde.equals(null) || qtde <= 0) {
			JOptionPane.showMessageDialog(null, "Quantidade do produto e obrigatoria para venda");
			throw new RuntimeException("Quantidade do produto e obrigatoria para venda");
		} else {
			this.vendaService.insertVendaItens(qtde, valorAcrescimo, valorDesconto);
		}

	}

	public Produto buscaProduto() {
		Produto produto = this.vendaService.getProdutos(Long.parseLong(txtIdProduto.getText()));
		txtNomeProduto.setText(produto.getDescricao());
		return produto;

	}

	public void inseriProdutoListaQtde(Produto produto) {
		double qtde = Double.parseDouble(showInputDialog("Quantidade do produto"));
		insertVendaItem(qtde, 15.5, 0);
		defaultList.inseriItemLista(jListProdutos, produto, qtde);
	}

	private void enableButtonFalse() {
		dataInicioVenda.setEnabled(false);
		txtIdVenda.setEditable(false);

	}

	private void enableButtonTrue() {
		dataInicioVenda.setEnabled(true);
		orcamentoRadioButton.setEnabled(true);
		vendaRadioButton.setEnabled(true);
		orcamentoRadioButton.setSelected(false);
		vendaRadioButton.setSelected(false);
		txtIdVenda.setEditable(true);

	}

	private void lipaCampos() {
		txtIdVenda.setText(null);
		dataInicioVenda.setDate(null);
		status.setVisible(false);
		txtNomeCliente.setText(null);
		txtValorTotalVenda.setText("0.0");
		txtIdCliente.setText(null);
	}

	public void deleteVendaId() {
		if (!txtIdVenda.getText().equals(null)) {
			this.vendaService.deleteByVendaId(Long.parseLong(txtIdVenda.getText()));
			showMessageDialog(null, "Venda deletada ");
			lipaCampos();
			defaultList.deleteListaAll(jListProdutos);
		}
	}

	public void getCliente() {
		Optional<Cliente> optional = Optional
				.ofNullable(this.vendaService.getCliente(Long.parseLong(txtIdCliente.getText())));
		if (optional.isPresent()) {
			txtNomeCliente.setText(optional.get().getNome());
		}

	}

	public void sair() {
		FormVendas fv = new FormVendas();
		if (fv.isClosable()) {
			int resposta = showConfirmDialog(null, "Deseja sair e salvar as informações? ", "Informações para sair",
					YES_NO_CANCEL_OPTION);
			if (resposta == YES_OPTION) {
				fv.isClosed();
			} else if (resposta == NO_OPTION) {
				deleteVendaId();
			}
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jDialog1 = new javax.swing.JDialog();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtIdVenda = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtIdCliente = new javax.swing.JTextField();
		txtNomeCliente = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jListProdutos = new javax.swing.JList<>();
		txtIdProduto = new javax.swing.JTextField();
		txtNomeProduto = new javax.swing.JTextField();
		orcamentoRadioButton = new javax.swing.JRadioButton();
		vendaRadioButton = new javax.swing.JRadioButton();
		jLabel9 = new javax.swing.JLabel();
		txtValorTotalVenda = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		txtDescTotalVenda = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		txtAcTotalVenda = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		dataInicioVenda = new com.toedter.calendar.JDateChooser();
		status = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jButton4 = new javax.swing.JButton();
		btnInserir = new javax.swing.JButton();
		btmEcluirIdVenda = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		recebeCalculo = new javax.swing.JLabel();

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Vendas Retaguarda");
		addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
				formInternalFrameActivated(evt);
			}

			public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
				formInternalFrameClosed(evt);
			}

			public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
			}

			public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
			}
		});
		addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				formKeyPressed(evt);
			}
		});

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Vendas Retaguarda"));

		jLabel1.setText("CÓDIGO");

		txtIdVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

		jLabel2.setText("CLIENTE");

		txtIdCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtIdClienteActionPerformed(evt);
			}
		});
		txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtIdClienteKeyPressed(evt);
			}
		});

		jListProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jListProdutosKeyPressed(evt);
			}
		});
		jScrollPane1.setViewportView(jListProdutos);

		txtIdProduto.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtIdProdutoKeyPressed(evt);
			}

			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtIdProdutoKeyReleased(evt);
			}
		});

		buttonGroup1.add(orcamentoRadioButton);
		orcamentoRadioButton.setText("ORÇAMENTO");
		orcamentoRadioButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				orcamentoRadioButtonActionPerformed(evt);
			}
		});

		buttonGroup1.add(vendaRadioButton);
		vendaRadioButton.setText("VENDAS");
		vendaRadioButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				vendaRadioButtonActionPerformed(evt);
			}
		});

		jLabel9.setText("VALOR TOTAL");

		txtValorTotalVenda.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
		txtValorTotalVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

		jLabel10.setText("DESCONTO");

		txtDescTotalVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		txtDescTotalVenda.setText("0");
		txtDescTotalVenda.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtDescTotalVendaActionPerformed(evt);
			}
		});

		jLabel11.setText("ACRECIMO");

		txtAcTotalVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		txtAcTotalVenda.setText("0");
		txtAcTotalVenda.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtAcTotalVendaActionPerformed(evt);
			}
		});

		jLabel12.setText("Seq");

		jLabel13.setText("Código Item");

		jLabel14.setText("Descricção Item");

		jLabel15.setText("Qtde");

		jLabel16.setText("Valor Un");

		dataInicioVenda.setDateFormatString("dd/MM/yyyy HH:mm:ss");

		status.setText("status");

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Menu de Ações",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Dialog", 0, 12), new java.awt.Color(164, 13, 13))); // NOI18N

		jButton4.setText("Cancelar Item");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		btnInserir.setText("Iniciar Venda");
		btnInserir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInserirActionPerformed(evt);
			}
		});

		btmEcluirIdVenda.setText("Deletar Venda");
		btmEcluirIdVenda.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btmEcluirIdVendaActionPerformed(evt);
			}
		});

		jButton2.setText("PESQUISAR");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton1.setText("Finalizar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
								jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 100,
												Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(btmEcluirIdVenda, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton4).addComponent(btnInserir))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btmEcluirIdVenda).addComponent(jButton2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 230,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel12)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addGap(43, 43, 43).addComponent(jLabel13)
																.addGap(90, 90, 90).addComponent(jLabel14)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(jLabel15).addGap(133, 133, 133)
																.addComponent(jLabel16))
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addGap(39, 39, 39)
																.addComponent(
																		txtIdCliente,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 89,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(txtNomeCliente,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 290,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0, 0, Short.MAX_VALUE))))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout
												.createSequentialGroup()
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel2).addComponent(jLabel1))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(dataInicioVenda, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE)))
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout
														.createSequentialGroup().addGap(24, 24, 24)
														.addComponent(txtValorTotalVenda))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
														.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																		jPanel1Layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addGroup(jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(recebeCalculo,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								137,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtDescTotalVenda,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								94,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addContainerGap())
																				.addGroup(jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel9,
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)
																										.addComponent(
																												status,
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												jPanel1Layout
																														.createSequentialGroup()
																														.addComponent(
																																orcamentoRadioButton)
																														.addPreferredGap(
																																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																vendaRadioButton)))))
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																		jPanel1Layout.createSequentialGroup()
																				.addComponent(jPanel2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(2, 2, 2))
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																		jPanel1Layout.createSequentialGroup()
																				.addComponent(txtAcTotalVenda,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						93,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addContainerGap())
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																		jPanel1Layout.createSequentialGroup()
																				.addComponent(jLabel11)
																				.addContainerGap())
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																		jPanel1Layout.createSequentialGroup()
																				.addComponent(jLabel10)
																				.addContainerGap()))))))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(status)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(vendaRadioButton).addComponent(orcamentoRadioButton))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel11)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtAcTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel10)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtDescTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(recebeCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel9)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtValorTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1).addComponent(txtIdVenda,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(dataInicioVenda, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(7, 7, 7)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(20, 20, 20)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel12).addComponent(jLabel13).addComponent(jLabel14)
										.addComponent(jLabel15).addComponent(jLabel16))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
										jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(33, 33, 33)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:

		getCliente();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInserirActionPerformed
		// TODO add your handling code here:

		if (btnInserir.getText().equalsIgnoreCase("Iniciar Venda")) {
			verificaCLienteNull();
		} else if (btnInserir.getText().equalsIgnoreCase("Cancelar Venda")
				   || btnInserir.getText().equalsIgnoreCase("Cancelar Orcamento")) {
			deleteVendaId();
			btnInserir.setText("Iniciar Venda");
			enableButtonTrue();

		}

	}// GEN-LAST:event_btnInserirActionPerformed

	private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameClosed
		// TODO add your handling code here:
		sair();
	}// GEN-LAST:event_formInternalFrameClosed

	private void orcamentoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_orcamentoRadioButtonActionPerformed
		// TODO add your handling code here:
		orc = "ORC";
	}// GEN-LAST:event_orcamentoRadioButtonActionPerformed

	private void vendaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_vendaRadioButtonActionPerformed
		// TODO add your handling code here:
		vd = "VD";
	}// GEN-LAST:event_vendaRadioButtonActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

	}// GEN-LAST:event_jButton1ActionPerformed

	private void txtIdProdutoKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtIdProdutoKeyPressed

		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			Produto p = buscaProduto();
			inseriProdutoListaQtde(p);

		}

	}// GEN-LAST:event_txtIdProdutoKeyPressed

	private void txtAcTotalVendaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtAcTotalVendaActionPerformed

	}// GEN-LAST:event_txtAcTotalVendaActionPerformed

	private void txtIdProdutoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtIdProdutoKeyReleased

	}// GEN-LAST:event_txtIdProdutoKeyReleased

	private void txtIdClienteKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtIdClienteKeyPressed
		// TODO add your handling code here:
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			getCliente();
			insertIdVenda();

//            Thread();
		}
	}// GEN-LAST:event_txtIdClienteKeyPressed

	private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameActivated
		// TODO add your handling code here:

	}// GEN-LAST:event_formInternalFrameActivated

	private void jListProdutosKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jListProdutosKeyPressed
		// TODO add your handling code here:
		if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

			defaultList.deleteListaItemOneOne(jListProdutos);
		}

	}// GEN-LAST:event_jListProdutosKeyPressed

	private void formKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_formKeyPressed

	}// GEN-LAST:event_formKeyPressed

	private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtIdClienteActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_txtIdClienteActionPerformed

	private void btmEcluirIdVendaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btmEcluirIdVendaActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_btmEcluirIdVendaActionPerformed

	private void txtDescTotalVendaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtDescTotalVendaActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtDescTotalVendaActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed

		Long idx = Long.valueOf(JOptionPane.showInputDialog(null, "Digite o codigo do produto que deseja excluir"));
		if (!idx.equals(null)) {
			defaultList.deleteListaItemOneOne(jListProdutos);
			this.vendaService.deleteItensById(idx);
		}

	}// GEN-LAST:event_jButton4ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormVendas().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btmEcluirIdVenda;
	private javax.swing.JButton btnInserir;
	private javax.swing.ButtonGroup buttonGroup1;
	private com.toedter.calendar.JDateChooser dataInicioVenda;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton4;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JList<String> jListProdutos;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JRadioButton orcamentoRadioButton;
	private javax.swing.JLabel recebeCalculo;
	private javax.swing.JLabel status;
	private javax.swing.JTextField txtAcTotalVenda;
	private javax.swing.JTextField txtDescTotalVenda;
	private javax.swing.JTextField txtIdCliente;
	private javax.swing.JTextField txtIdProduto;
	private javax.swing.JTextField txtIdVenda;
	private javax.swing.JTextField txtNomeCliente;
	private javax.swing.JTextField txtNomeProduto;
	private javax.swing.JTextField txtValorTotalVenda;
	private javax.swing.JRadioButton vendaRadioButton;
	// End of variables declaration//GEN-END:variables
}
