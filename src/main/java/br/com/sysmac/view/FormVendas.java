/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysmac.view;

import br.com.sysmac.emuns.FormaPagamento;
import br.com.sysmac.entitys.Cliente;
import br.com.sysmac.entitys.Produto;
import br.com.sysmac.entitys.Venda;
import br.com.sysmac.exceptions.ClienteExceptions;
import br.com.sysmac.servico.VendaService;
import br.com.sysmac.util.AppContext;
import br.com.sysmac.util.DefaultList;
import view.FormFinalizacaoVenda;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Optional;

import static javax.swing.JOptionPane.*;

public  class FormVendas extends javax.swing.JInternalFrame {

    private static FormPrincipal formPrincipal;
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
        atualizaValorTotalVenda();

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
        txtrecebeCalculo.setText(qtde + " * " + valorUn + " = " + valor);
        txtValorTotalProd.setText(String.valueOf(valor));
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

    public void insertVendaItem(Double qtde) {
        if (qtde == null || qtde <= 0) {
            JOptionPane.showMessageDialog(null, "Quantidade do produto e obrigatoria para venda");
            throw new RuntimeException("Quantidade do produto e obrigatoria para venda");
        } else {
            this.vendaService.insertVendaItens(qtde);
        }

    }

    public Produto buscaProduto() {
        Produto produto = this.vendaService.getProdutos(Long.parseLong(txtIdProduto.getText()));
        txtNomeProduto.setText(produto.getDescricao());
        return produto;

    }

    public void inseriProdutoListaQtde(Produto produto) {
        double qtde = Double.parseDouble(showInputDialog("Quantidade do produto"));
        insertVendaItem(qtde);
        defaultList.inseriItemLista(jListProdutos, produto, qtde);
        atualizaValorTotalProduto(qtde, produto.getValorUn());
        atualizaValorTotalVenda();
    }

    public double atualizaValorTotalProduto(double qtde, double vlUn) {
        double valorAtualizado = 0;
                valorAtualizado += (qtde * vlUn);

        txtValorTotalProd.setText(String.valueOf(valorAtualizado++));

        return valorAtualizado;

    }
    public void atualizaValorTotalVenda(){
        double v = 0;
                v += Double.parseDouble(txtValorTotalProd.getText());
         txtValorTotalVenda.setText(String.valueOf(v));
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

    public void finalizaVenda(FormaPagamento formaPagamento, double valorTroco, double valorEntrada){
        double valorTotalVenda = Double.parseDouble(txtValorTotalProd.getText());
        double valorTotalDesconto=Double.parseDouble(txtDescTotalVenda.getText());
        double valorAcrescimo = Double.parseDouble(txtAcTotalVenda.getText());
//        this.vendaService.updateVenda();
    }

    private void lipaCampos() {
        txtIdVenda.setText(null);
        dataInicioVenda.setDate(null);
        status.setVisible(false);
        txtNomeCliente.setText(null);
        txtValorTotalProd.setText("0.0");
        txtIdCliente.setText(null);
    }

    public void deleteVendaId() {
        if (!(txtIdVenda.getText() == null)) {
            this.vendaService.deleteByVendaId(Long.parseLong(txtIdVenda.getText()));
            showMessageDialog(null, "Venda deletada ");
            lipaCampos();
            defaultList.deleteListaAll(jListProdutos);
        }
    }

    public void buscaCliente() {
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
                    YES_NO_OPTION);
            if (resposta == YES_OPTION) {
                fv.isClosed();
            } else if (resposta == NO_OPTION) {
                deleteVendaId();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        txtValorTotalProd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDescTotalVenda = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAcTotalVenda = new javax.swing.JTextField();
        dataInicioVenda = new com.toedter.calendar.JDateChooser();
        status = new javax.swing.JLabel();
        txtrecebeCalculo = new javax.swing.JLabel();
        btmEcluirIdVenda = new javax.swing.JButton();
        btnExcluirTodos = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtValorTotalVenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

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

        jPanel1.setBackground(new java.awt.Color(162, 153, 167));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Vendas Retaguarda"));

        jLabel1.setBackground(new java.awt.Color(252, 246, 238));
        jLabel1.setForeground(new java.awt.Color(253, 251, 251));
        jLabel1.setText("CÓDIGO");

        txtIdVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setBackground(new java.awt.Color(252, 246, 238));
        jLabel2.setForeground(new java.awt.Color(253, 251, 251));
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
        orcamentoRadioButton.setFont(orcamentoRadioButton.getFont().deriveFont(orcamentoRadioButton.getFont().getSize()+2f));
        orcamentoRadioButton.setText("ORÇAMENTO");
        orcamentoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orcamentoRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(vendaRadioButton);
        vendaRadioButton.setFont(vendaRadioButton.getFont().deriveFont(vendaRadioButton.getFont().getSize()+2f));
        vendaRadioButton.setText("VENDAS");
        vendaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendaRadioButtonActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(252, 246, 238));
        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(253, 251, 251));
        jLabel9.setText("VALOR TOTAL PRODUTO");

        txtValorTotalProd.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        txtValorTotalProd.setForeground(new java.awt.Color(199, 15, 15));
        txtValorTotalProd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorTotalProd.setText("0.0");
        txtValorTotalProd.setEnabled(false);

        jLabel10.setBackground(new java.awt.Color(252, 246, 238));
        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(253, 251, 251));
        jLabel10.setText("DESCONTO");

        txtDescTotalVenda.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        txtDescTotalVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescTotalVenda.setText("0.0");
        txtDescTotalVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescTotalVendaActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(252, 246, 238));
        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(253, 251, 251));
        jLabel11.setText("ACRESCIMO");

        txtAcTotalVenda.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        txtAcTotalVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAcTotalVenda.setText("0.0");
        txtAcTotalVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAcTotalVendaActionPerformed(evt);
            }
        });

        dataInicioVenda.setDateFormatString("dd/MM/yyyy HH:mm:ss");

        status.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        status.setForeground(new java.awt.Color(231, 7, 7));
        status.setText("status");

        txtrecebeCalculo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        btmEcluirIdVenda.setText("Deletar Venda");
        btmEcluirIdVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmEcluirIdVendaActionPerformed(evt);
            }
        });

        btnExcluirTodos.setText("Excluir todos");
        btnExcluirTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTodosActionPerformed(evt);
            }
        });

        btnInserir.setText("Iniciar Venda");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar Item");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(252, 246, 238));
        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(253, 251, 251));
        jLabel3.setText("R$");

        jButton5.setText("Finalizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(252, 246, 238));
        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(253, 251, 251));
        jLabel12.setText("VALOR TOTAL COMPRA");

        txtValorTotalVenda.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        txtValorTotalVenda.setForeground(new java.awt.Color(199, 15, 15));
        txtValorTotalVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorTotalVenda.setText("0.0");
        txtValorTotalVenda.setEnabled(false);

        jLabel4.setBackground(new java.awt.Color(252, 246, 238));
        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(253, 251, 251));
        jLabel4.setText("R$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeProduto)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtrecebeCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel3))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dataInicioVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorTotalVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtValorTotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnInserir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirTodos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btmEcluirIdVenda))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(490, 490, 490)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vendaRadioButton)
                                    .addComponent(orcamentoRadioButton)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAcTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vendaRadioButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(dataInicioVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orcamentoRadioButton)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAcTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtValorTotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(txtrecebeCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btmEcluirIdVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInserir))))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTodosActionPerformed
        // TODO add your handling code here:

        int idx = JOptionPane.showConfirmDialog(null, "Deseja cancelar todos os registro da venda?", title, YES_NO_OPTION);
        if (idx == YES_OPTION) {
            this.vendaService.deleteByItensALl();
            defaultList.deleteListaAll(jListProdutos);
        }


    }//GEN-LAST:event_btnExcluirTodosActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        FormFinalizacaoVenda ffv;
        ffv = new FormFinalizacaoVenda(formPrincipal, true);
        ffv.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        buscaCliente();
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
            txtIdProduto.setText("");
            txtNomeProduto.setText("");
            txtIdProduto.requestFocus();


        }

    }// GEN-LAST:event_txtIdProdutoKeyPressed

    private void txtAcTotalVendaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtAcTotalVendaActionPerformed

    }// GEN-LAST:event_txtAcTotalVendaActionPerformed

    private void txtIdProdutoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtIdProdutoKeyReleased

    }// GEN-LAST:event_txtIdProdutoKeyReleased

    private void txtIdClienteKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtIdClienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscaCliente();
            insertIdVenda();

//            Thread();
        }
    }// GEN-LAST:event_txtIdClienteKeyPressed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:

    }// GEN-LAST:event_formInternalFrameActivated

    private void jListProdutosKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jListProdutosKeyPressed
        // TODO add your handling code here:

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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmEcluirIdVenda;
    private javax.swing.JButton btnExcluirTodos;
    private javax.swing.JButton btnInserir;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dataInicioVenda;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListProdutos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton orcamentoRadioButton;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txtAcTotalVenda;
    private javax.swing.JTextField txtDescTotalVenda;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtIdVenda;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtValorTotalProd;
    private javax.swing.JTextField txtValorTotalVenda;
    private javax.swing.JLabel txtrecebeCalculo;
    private javax.swing.JRadioButton vendaRadioButton;
    // End of variables declaration//GEN-END:variables
}
