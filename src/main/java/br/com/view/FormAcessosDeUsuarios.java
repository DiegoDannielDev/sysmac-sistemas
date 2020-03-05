/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

/**
 *
 * @author Diego Danniel
 */
public class FormAcessosDeUsuarios extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form Tela_AcessosDeUsuarios
     */
    public FormAcessosDeUsuarios() {
        initComponents();

    }

    public void liberarMenuInicio() {

        if (jchInicio.isSelected()) {
            jchCadastro.setEnabled(true);
            jchCadEmpresa.setEnabled(true);

        } else {
            jchCadastro.setEnabled(false);
            jchCadastro.setSelected(false);

            jchCadCliente.setEnabled(false);
            jchCadFornec.setEnabled(false);
            jchCadCasas.setEnabled(false);
            jchCadFunc.setEnabled(false);

            jchCadCliente.setSelected(false);
            jchCadFornec.setSelected(false);
            jchCadCasas.setSelected(false);
            jchCadFunc.setSelected(false);

            jchCadEmpresa.setEnabled(false);
            jchCadEmpresa.setSelected(false);
            jchCadEmpresaCadastro.setEnabled(false);
            jchCadEmpresaCadastro.setSelected(false);
        }

    }

    public void liberarTodos() {
        jchAlugueis.setEnabled(true);
        jchAlugueis.setSelected(true);
        jchAlugueisAlugar.setEnabled(true);
        jchAlugueisAlugar.setSelected(true);
        jchBackup.setEnabled(true);
        jchBackup.setSelected(true);
        jchBackupIniciar.setEnabled(true);
        jchBackupIniciar.setSelected(true);
        jchCadCasas.setEnabled(true);
        jchCadCasas.setSelected(true);
        jchCadCliente.setEnabled(true);
        jchCadCliente.setSelected(true);
        jchCadEmpresa.setEnabled(true);
        jchCadEmpresa.setSelected(true);
        jchCadEmpresaCadastro.setEnabled(true);
        jchCadEmpresaCadastro.setSelected(true);
        jchCadFornec.setEnabled(true);
        jchCadFornec.setSelected(true);
        jchCadFunc.setEnabled(true);
        jchCadFunc.setSelected(true);
        jchCadastro.setEnabled(true);
        jchCadastro.setSelected(true);
        jchCasasAlugadasRel.setEnabled(true);
        jchCasasAlugadasRel.setSelected(true);
        jchCasasNaoAlugadasRel.setEnabled(true);
        jchCasasNaoAlugadasRel.setSelected(true);
        jchCasasTodasRel.setEnabled(true);
        jchCasasTodasRel.setSelected(true);
        jchClientesAniversarioRel.setEnabled(true);
        jchClientesAniversarioRel.setSelected(true);
        jchClientesFiadoresRel.setEnabled(true);
        jchClientesFiadoresRel.setSelected(true);
        jchClientesGeralRel.setEnabled(true);
        jchClientesGeralRel.setSelected(true);
        jchConfiguracao.setEnabled(true);
        jchConfiguracao.setSelected(true);
        jchConfiguracaoEBackup.setEnabled(true);
        jchConfiguracaoEBackup.setSelected(true);
        jchConfiguracaoParametros.setEnabled(true);
        jchConfiguracaoParametros.setSelected(true);
        jchContasAPagarLancamentos.setEnabled(true);
        jchContasAPagarLancamentos.setSelected(true);
        jchContasAPagarPagamentos.setEnabled(true);
        jchContasAPagarPagamentos.setSelected(true);
        jchContasAReceberLancamentos.setEnabled(true);
        jchContasAReceberLancamentos.setSelected(true);
        jchContasAReceberRecebimentos.setEnabled(true);
        jchContasAReceberRecebimentos.setSelected(true);
        jchFinanceiroContasAReceber.setEnabled(true);
        jchFinanceiroContasAReceber.setSelected(true);
        jchEmail.setEnabled(true);
        jchEmail.setSelected(true);
        jchFinanceiro.setEnabled(true);
        jchFinanceiro.setSelected(true);
        jchFinanceiroContasAPagar.setEnabled(true);
        jchFinanceiroContasAPagar.setSelected(true);
        jchGerenciador.setEnabled(true);jchGerenciador.setSelected(true);
        jchGerenciadorEmail.setEnabled(true);
        jchGerenciadorEmail.setSelected(true);
        jchInicio.setEnabled(true);
        jchInicio.setSelected(true);
        jchProdutos.setEnabled(true);
        jchProdutos.setSelected(true);
        jchProdutosCadastro.setEnabled(true);
        jchProdutosCadastro.setSelected(true);
        jchRelatorioClientes.setEnabled(true);
        jchRelatorioClientes.setSelected(true);
        jchRelatorios.setEnabled(true);
        jchRelatorios.setSelected(true);
        jchRelatorioClientes.setEnabled(true);
        jchRelatoriosCasas.setEnabled(true);
        jchRelatoriosCasas.setSelected(true);
    }

    public void bloquearTodos() {
        jchAlugueis.setEnabled(false);
        jchAlugueis.setSelected(false);
        jchAlugueisAlugar.setEnabled(false);
        jchAlugueisAlugar.setSelected(false);
        jchBackup.setEnabled(false);
        jchBackup.setSelected(false);
        jchBackupIniciar.setEnabled(false);
        jchBackupIniciar.setSelected(false);
        jchCadCasas.setEnabled(false);
        jchCadCasas.setSelected(false);
        jchCadCliente.setEnabled(false);
        jchCadCliente.setSelected(false);
        jchCadEmpresa.setEnabled(false);
        jchCadEmpresa.setSelected(false);
        jchCadEmpresaCadastro.setEnabled(false);
        jchCadEmpresaCadastro.setSelected(false);
        jchCadFornec.setEnabled(false);
        jchCadFornec.setSelected(false);
        jchCadFunc.setEnabled(false);
        jchCadFunc.setSelected(false);
        jchCadastro.setEnabled(false);
        jchCadastro.setSelected(false);
        jchCasasAlugadasRel.setEnabled(false);
        jchCasasAlugadasRel.setSelected(false);
        jchCasasNaoAlugadasRel.setEnabled(false);
        jchCasasNaoAlugadasRel.setSelected(false);
        jchCasasTodasRel.setEnabled(false);
        jchCasasTodasRel.setSelected(false);
        jchClientesAniversarioRel.setEnabled(false);
        jchClientesAniversarioRel.setSelected(false);
        jchClientesFiadoresRel.setEnabled(false);
        jchClientesFiadoresRel.setSelected(false);
        jchClientesGeralRel.setEnabled(false);
        jchClientesGeralRel.setSelected(false);
        jchConfiguracao.setEnabled(false);
        jchConfiguracao.setSelected(false);
        //jchConfiguracaoEBackup.setEnabled(false);
        jchConfiguracaoEBackup.setSelected(false);
        jchConfiguracaoParametros.setEnabled(false);
        jchConfiguracaoParametros.setSelected(false);
        jchContasAPagarLancamentos.setEnabled(false);
        jchContasAPagarLancamentos.setSelected(false);
        jchContasAPagarPagamentos.setEnabled(false);
        jchContasAPagarPagamentos.setSelected(false);
        jchContasAReceberLancamentos.setEnabled(false);
        jchContasAReceberLancamentos.setSelected(false);
        jchContasAReceberRecebimentos.setEnabled(false);
        jchContasAReceberRecebimentos.setSelected(false);
        jchFinanceiroContasAReceber.setEnabled(false);
        jchFinanceiroContasAReceber.setSelected(false);
        jchEmail.setEnabled(false);
        jchEmail.setSelected(false);//jchFinanceiro.setEnabled(false);
        jchFinanceiro.setSelected(false);
        jchFinanceiroContasAPagar.setEnabled(false);
        jchFinanceiroContasAPagar.setSelected(false);//jchGerenciador.setEnabled(false);
        jchGerenciador.setSelected(false);
        jchGerenciadorEmail.setEnabled(false);
        jchGerenciadorEmail.setSelected(false);//jchInicio.setEnabled(false);
        jchInicio.setSelected(false);
        jchProdutos.setEnabled(false);
        jchProdutos.setSelected(false);
        jchProdutosCadastro.setEnabled(false);
        jchProdutosCadastro.setSelected(false);
        jchRelatorioClientes.setEnabled(false);
        jchRelatorioClientes.setSelected(false);//jchRelatorios.setEnabled(false);
        jchRelatorios.setSelected(false);
        jchRelatorioClientes.setEnabled(false);
        jchRelatoriosCasas.setEnabled(false);
        jchRelatoriosCasas.setSelected(false);
    }

    public void liberarGerenciadorMenu() {
        if (jchGerenciador.isSelected()) {
            jchAlugueis.setEnabled(true);
            jchProdutos.setEnabled(true);
            jchEmail.setEnabled(true);
        } else {
            jchAlugueis.setEnabled(false);
            jchProdutos.setEnabled(false);
            jchEmail.setEnabled(false);
            jchAlugueisAlugar.setEnabled(false);

            jchAlugueis.setSelected(false);
            jchProdutos.setSelected(false);
            jchEmail.setSelected(false);
            jchAlugueisAlugar.setSelected(false);
        }
    }

    public void liberarFinanceiro() {
        if (jchFinanceiro.isSelected()) {
            jchFinanceiroContasAPagar.setEnabled(true);
            jchFinanceiroContasAReceber.setEnabled(true);
        } else {
            jchFinanceiroContasAPagar.setEnabled(false);
            jchFinanceiroContasAReceber.setEnabled(false);

            jchFinanceiroContasAPagar.setSelected(false);
            jchFinanceiroContasAReceber.setSelected(false);

            jchContasAReceberLancamentos.setEnabled(false);
            jchContasAReceberRecebimentos.setEnabled(false);

            jchContasAReceberLancamentos.setSelected(false);
            jchContasAReceberRecebimentos.setSelected(false);

            jchContasAPagarLancamentos.setEnabled(false);
            jchContasAPagarPagamentos.setEnabled(false);

            jchContasAPagarLancamentos.setSelected(false);
            jchContasAPagarPagamentos.setSelected(false);
        }
    }

    public void liberaFinanceiroContasAReceber() {
        if (jchFinanceiroContasAReceber.isSelected()) {
            jchContasAReceberLancamentos.setEnabled(true);
            jchContasAReceberRecebimentos.setEnabled(true);
        } else {
            jchContasAReceberLancamentos.setEnabled(false);
            jchContasAReceberRecebimentos.setEnabled(false);

            jchContasAReceberLancamentos.setSelected(false);
            jchContasAReceberRecebimentos.setSelected(false);
        }
    }

    public void liberaFinanceiroContasAPagar() {
        if (jchFinanceiroContasAPagar.isSelected()) {
            jchContasAPagarLancamentos.setEnabled(true);
            jchContasAPagarPagamentos.setEnabled(true);
        } else {
            jchContasAPagarLancamentos.setEnabled(false);
            jchContasAPagarPagamentos.setEnabled(false);

            jchContasAPagarLancamentos.setSelected(false);
            jchContasAPagarPagamentos.setSelected(false);
        }
    }

    public void liberarRelatorios() {
        if (jchRelatorios.isSelected()) {
            jchRelatorioClientes.setEnabled(true);
            jchRelatoriosCasas.setEnabled(true);
        } else {
            jchRelatorioClientes.setEnabled(false);
            jchRelatorioClientes.setSelected(false);
            jchRelatoriosCasas.setEnabled(false);
            jchRelatoriosCasas.setSelected(false);

            jchClientesGeralRel.setEnabled(false);
            jchClientesGeralRel.setSelected(false);
            jchClientesAniversarioRel.setEnabled(false);
            jchClientesAniversarioRel.setSelected(false);
            jchClientesFiadoresRel.setEnabled(false);
            jchClientesFiadoresRel.setSelected(false);

            jchCasasAlugadasRel.setEnabled(false);
            jchCasasAlugadasRel.setSelected(false);
            jchCasasNaoAlugadasRel.setEnabled(false);
            jchCasasNaoAlugadasRel.setSelected(false);
            jchCasasTodasRel.setEnabled(false);
            jchCasasTodasRel.setSelected(false);
        }
    }

    public void liberarRelatoriosAtributosClientes() {
        if (jchRelatorioClientes.isSelected()) {
            jchClientesGeralRel.setEnabled(true);
            jchClientesAniversarioRel.setEnabled(true);
            jchClientesFiadoresRel.setEnabled(true);
        } else {
            jchClientesGeralRel.setEnabled(false);
            jchClientesGeralRel.setSelected(false);
            jchClientesAniversarioRel.setEnabled(false);
            jchClientesAniversarioRel.setSelected(false);
            jchClientesFiadoresRel.setEnabled(false);
            jchClientesFiadoresRel.setSelected(false);
        }
    }

    public void liberarRelatoriosAtributosCasas() {
        if (jchRelatoriosCasas.isSelected()) {
            jchCasasAlugadasRel.setEnabled(true);
            jchCasasNaoAlugadasRel.setEnabled(true);
            jchCasasTodasRel.setEnabled(true);
        } else {
            jchCasasAlugadasRel.setEnabled(false);
            jchCasasAlugadasRel.setSelected(false);
            jchCasasNaoAlugadasRel.setEnabled(false);
            jchCasasNaoAlugadasRel.setSelected(false);
            jchCasasTodasRel.setEnabled(false);
            jchCasasTodasRel.setSelected(false);
        }
    }

    public void liberarConfiguracao() {
        if (jchConfiguracaoEBackup.isSelected()) {
            jchConfiguracao.setEnabled(true);
            jchBackup.setEnabled(true);
        } else {
            jchConfiguracao.setEnabled(false);
            jchConfiguracao.setSelected(false);
            jchBackup.setEnabled(false);
            jchBackup.setSelected(false);

            jchConfiguracaoParametros.setEnabled(false);
            jchConfiguracaoParametros.setSelected(false);
            
              jchBackupIniciar.setEnabled(false);
            jchBackupIniciar.setSelected(false);
        }
    }

    public void liberarConfiguracaoParametro() {
        if (jchConfiguracao.isSelected()) {
            jchConfiguracaoParametros.setEnabled(true);

        } else {
            jchConfiguracaoParametros.setEnabled(false);
            jchConfiguracaoParametros.setSelected(false);
        }
    }
    
    public void liberarConfiguracaoBackup(){
        if (jchBackup.isSelected()) {
            jchBackupIniciar.setEnabled(true);
        }
        else{
            jchBackupIniciar.setEnabled(false);
            jchBackupIniciar.setSelected(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcboUsuario = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnBloqueiaTodos = new javax.swing.JButton();
        btnLiberaTodos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jchInicio = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jchCadastro = new javax.swing.JCheckBox();
        jSeparator5 = new javax.swing.JSeparator();
        jchCadCliente = new javax.swing.JCheckBox();
        jchCadFornec = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        jchCadCasas = new javax.swing.JCheckBox();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jchCadFunc = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jchCadEmpresa = new javax.swing.JCheckBox();
        jSeparator10 = new javax.swing.JSeparator();
        jchCadEmpresaCadastro = new javax.swing.JCheckBox();
        jchGerenciador = new javax.swing.JCheckBox();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jchAlugueis = new javax.swing.JCheckBox();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jchAlugueisAlugar = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        jchProdutos = new javax.swing.JCheckBox();
        jSeparator14 = new javax.swing.JSeparator();
        jchProdutosCadastro = new javax.swing.JCheckBox();
        jSeparator15 = new javax.swing.JSeparator();
        jchEmail = new javax.swing.JCheckBox();
        jSeparator16 = new javax.swing.JSeparator();
        jchGerenciadorEmail = new javax.swing.JCheckBox();
        jchFinanceiro = new javax.swing.JCheckBox();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jchContasAReceberLancamentos = new javax.swing.JCheckBox();
        jSeparator21 = new javax.swing.JSeparator();
        jchContasAReceberRecebimentos = new javax.swing.JCheckBox();
        jSeparator22 = new javax.swing.JSeparator();
        jchFinanceiroContasAPagar = new javax.swing.JCheckBox();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jchContasAPagarPagamentos = new javax.swing.JCheckBox();
        jchContasAPagarLancamentos = new javax.swing.JCheckBox();
        jchRelatorios = new javax.swing.JCheckBox();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator28 = new javax.swing.JSeparator();
        jchFinanceiroContasAReceber = new javax.swing.JCheckBox();
        jSeparator31 = new javax.swing.JSeparator();
        jchRelatorioClientes = new javax.swing.JCheckBox();
        jSeparator30 = new javax.swing.JSeparator();
        jSeparator32 = new javax.swing.JSeparator();
        jSeparator33 = new javax.swing.JSeparator();
        jchClientesAniversarioRel = new javax.swing.JCheckBox();
        jchClientesGeralRel = new javax.swing.JCheckBox();
        jSeparator34 = new javax.swing.JSeparator();
        jchClientesFiadoresRel = new javax.swing.JCheckBox();
        jSeparator35 = new javax.swing.JSeparator();
        jchRelatoriosCasas = new javax.swing.JCheckBox();
        jSeparator36 = new javax.swing.JSeparator();
        jSeparator37 = new javax.swing.JSeparator();
        jchCasasAlugadasRel = new javax.swing.JCheckBox();
        jchCasasNaoAlugadasRel = new javax.swing.JCheckBox();
        jSeparator38 = new javax.swing.JSeparator();
        jSeparator39 = new javax.swing.JSeparator();
        jchCasasTodasRel = new javax.swing.JCheckBox();
        jchConfiguracaoEBackup = new javax.swing.JCheckBox();
        jSeparator40 = new javax.swing.JSeparator();
        jSeparator41 = new javax.swing.JSeparator();
        jchConfiguracao = new javax.swing.JCheckBox();
        jSeparator42 = new javax.swing.JSeparator();
        jchBackup = new javax.swing.JCheckBox();
        jSeparator43 = new javax.swing.JSeparator();
        jchConfiguracaoParametros = new javax.swing.JCheckBox();
        jSeparator44 = new javax.swing.JSeparator();
        jchBackupIniciar = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator45 = new javax.swing.JSeparator();
        jSeparator46 = new javax.swing.JSeparator();
        jSeparator47 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setBackground(java.awt.Color.darkGray);
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Acessos de Usuários");
        setToolTipText("Acessos de Usuários");
        setFrameIcon(null);

        jPanel1.setBackground(new java.awt.Color(200, 195, 192));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Acessos de Usuarios"));

        jLabel2.setText("Nome da Empresa");

        jLabel1.setText("Nome do Usuario");

        jcboUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBloqueiaTodos.setText("Bloquear Tudo");
        btnBloqueiaTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloqueiaTodosActionPerformed(evt);
            }
        });

        btnLiberaTodos.setText("Liberar Todos");
        btnLiberaTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberaTodosActionPerformed(evt);
            }
        });

        jchInicio.setText("Inicio");
        jchInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchInicioActionPerformed(evt);
            }
        });

        jchCadastro.setText("Cadastro");
        jchCadastro.setEnabled(false);
        jchCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchCadastroActionPerformed(evt);
            }
        });

        jchCadCliente.setText("Clientes");
        jchCadCliente.setEnabled(false);

        jchCadFornec.setText("Fornecedores");
        jchCadFornec.setEnabled(false);

        jchCadCasas.setText("Casas");
        jchCadCasas.setEnabled(false);

        jchCadFunc.setText("Funcionarios e Usuarios");
        jchCadFunc.setEnabled(false);

        jchCadEmpresa.setText("Empresa");
        jchCadEmpresa.setEnabled(false);
        jchCadEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchCadEmpresaActionPerformed(evt);
            }
        });

        jchCadEmpresaCadastro.setText("Cadastro");
        jchCadEmpresaCadastro.setEnabled(false);

        jchGerenciador.setText("Gerenciador");
        jchGerenciador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchGerenciadorActionPerformed(evt);
            }
        });

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jchAlugueis.setText("Alugueis");
        jchAlugueis.setEnabled(false);
        jchAlugueis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchAlugueisActionPerformed(evt);
            }
        });

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jchAlugueisAlugar.setText("Alugar");
        jchAlugueisAlugar.setEnabled(false);

        jchProdutos.setText("Produtos");
        jchProdutos.setEnabled(false);
        jchProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchProdutosActionPerformed(evt);
            }
        });

        jchProdutosCadastro.setText("Cadastro");
        jchProdutosCadastro.setEnabled(false);

        jchEmail.setText("E-mail");
        jchEmail.setEnabled(false);
        jchEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchEmailActionPerformed(evt);
            }
        });

        jchGerenciadorEmail.setText("Gerenciador de e-mail");
        jchGerenciadorEmail.setEnabled(false);

        jchFinanceiro.setText("Financeiro");
        jchFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchFinanceiroActionPerformed(evt);
            }
        });

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jchContasAReceberLancamentos.setText("Lançamentos");
        jchContasAReceberLancamentos.setEnabled(false);

        jchContasAReceberRecebimentos.setText("Recebimentos");
        jchContasAReceberRecebimentos.setEnabled(false);

        jchFinanceiroContasAPagar.setText("Contas a Pagar");
        jchFinanceiroContasAPagar.setEnabled(false);
        jchFinanceiroContasAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchFinanceiroContasAPagarActionPerformed(evt);
            }
        });

        jSeparator24.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jchContasAPagarPagamentos.setText("Pagamento de contas");
        jchContasAPagarPagamentos.setEnabled(false);

        jchContasAPagarLancamentos.setText("Lançamentos");
        jchContasAPagarLancamentos.setEnabled(false);

        jchRelatorios.setText("Relatorios");
        jchRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchRelatoriosActionPerformed(evt);
            }
        });

        jSeparator26.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator28.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jchFinanceiroContasAReceber.setText("Contas a Receber");
        jchFinanceiroContasAReceber.setEnabled(false);
        jchFinanceiroContasAReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchFinanceiroContasAReceberActionPerformed(evt);
            }
        });

        jchRelatorioClientes.setText("Clientes");
        jchRelatorioClientes.setEnabled(false);
        jchRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchRelatorioClientesActionPerformed(evt);
            }
        });

        jSeparator32.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jchClientesAniversarioRel.setText("Clientes Aniversário");
        jchClientesAniversarioRel.setEnabled(false);

        jchClientesGeralRel.setText("Clientes Geral");
        jchClientesGeralRel.setEnabled(false);

        jchClientesFiadoresRel.setText("Clientes Fiadores");
        jchClientesFiadoresRel.setEnabled(false);

        jchRelatoriosCasas.setText("Casas");
        jchRelatoriosCasas.setEnabled(false);
        jchRelatoriosCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchRelatoriosCasasActionPerformed(evt);
            }
        });

        jSeparator36.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jchCasasAlugadasRel.setText("Alugadas");
        jchCasasAlugadasRel.setEnabled(false);

        jchCasasNaoAlugadasRel.setText("Não Alugadas");
        jchCasasNaoAlugadasRel.setEnabled(false);

        jchCasasTodasRel.setText("Todas");
        jchCasasTodasRel.setEnabled(false);

        jchConfiguracaoEBackup.setText("Configurações e Backup");
        jchConfiguracaoEBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchConfiguracaoEBackupActionPerformed(evt);
            }
        });

        jSeparator40.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jchConfiguracao.setText("Configurações");
        jchConfiguracao.setEnabled(false);
        jchConfiguracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchConfiguracaoActionPerformed(evt);
            }
        });

        jchBackup.setText("Backup");
        jchBackup.setEnabled(false);
        jchBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchBackupActionPerformed(evt);
            }
        });

        jchConfiguracaoParametros.setText("Parâmetros");
        jchConfiguracaoParametros.setEnabled(false);

        jchBackupIniciar.setText("Iniciar Backup");
        jchBackupIniciar.setEnabled(false);

        jSeparator27.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator46)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchInicio)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jchCadastro)
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jchCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jchCadFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jchCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jchCadCasas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jchCadEmpresa)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jchCadEmpresaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jchProdutos))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jchEmail))
                            .addComponent(jchGerenciador)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jchAlugueis))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchAlugueisAlugar)
                            .addComponent(jchProdutosCadastro)
                            .addComponent(jchGerenciadorEmail)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchFinanceiro)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jchFinanceiroContasAPagar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jchFinanceiroContasAReceber))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchContasAReceberLancamentos)
                            .addComponent(jchContasAReceberRecebimentos)
                            .addComponent(jchContasAPagarLancamentos)
                            .addComponent(jchContasAPagarPagamentos)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchRelatorios)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jchRelatorioClientes)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jchClientesGeralRel)
                                    .addComponent(jchClientesAniversarioRel)
                                    .addComponent(jchClientesFiadoresRel)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jchRelatoriosCasas)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator36, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jchCasasAlugadasRel)
                                    .addComponent(jchCasasNaoAlugadasRel)
                                    .addComponent(jchCasasTodasRel)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchConfiguracaoEBackup)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jSeparator44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jchBackup))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator40, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jchConfiguracao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jchConfiguracaoParametros))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jchBackupIniciar)))
                .addGap(0, 387, Short.MAX_VALUE))
            .addComponent(jSeparator47)
            .addComponent(jSeparator1)
            .addComponent(jSeparator45)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jchInicio)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jchCadastro))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jchCadCliente)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jchCadFornec))
                                .addGap(47, 47, 47)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jchCadFunc))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jchCadCasas))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchCadEmpresa)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jchCadEmpresaCadastro)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jSeparator45, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jchProdutos))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jchEmail))
                    .addComponent(jchGerenciador)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jchAlugueis))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jchAlugueisAlugar)
                        .addGap(17, 17, 17)
                        .addComponent(jchProdutosCadastro)
                        .addGap(17, 17, 17)
                        .addComponent(jchGerenciadorEmail)))
                .addGap(7, 7, 7)
                .addComponent(jSeparator46, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jchFinanceiro)
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jchFinanceiroContasAPagar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jchFinanceiroContasAReceber))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jchContasAReceberLancamentos)
                        .addGap(7, 7, 7)
                        .addComponent(jchContasAReceberRecebimentos)
                        .addGap(7, 7, 7)
                        .addComponent(jchContasAPagarLancamentos)
                        .addGap(7, 7, 7)
                        .addComponent(jchContasAPagarPagamentos)))
                .addGap(7, 7, 7)
                .addComponent(jSeparator47, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jchRelatorios)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator35, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jchRelatorioClientes))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jchClientesGeralRel)
                                .addGap(7, 7, 7)
                                .addComponent(jchClientesAniversarioRel)
                                .addGap(7, 7, 7)
                                .addComponent(jchClientesFiadoresRel)))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jchRelatoriosCasas))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator37, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jSeparator38, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jSeparator39, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jchCasasAlugadasRel)
                                .addGap(7, 7, 7)
                                .addComponent(jchCasasNaoAlugadasRel)
                                .addGap(7, 7, 7)
                                .addComponent(jchCasasTodasRel)))))
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchConfiguracaoEBackup)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator40, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jSeparator41, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jchConfiguracao)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jchConfiguracaoParametros)
                                        .addComponent(jSeparator43, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator42, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator44, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchBackup)
                            .addComponent(jchBackupIniciar)))))
        );

        jScrollPane2.setViewportView(jPanel2);

        jButton1.setText("Gravar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBloqueiaTodos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(181, 181, 181)
                                .addComponent(jLabel2)
                                .addGap(267, 267, 267)))
                        .addComponent(btnLiberaTodos)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLiberaTodos)
                    .addComponent(btnBloqueiaTodos)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(290, 40, 835, 529);
    }// </editor-fold>//GEN-END:initComponents

    private void jchInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchInicioActionPerformed
        liberarMenuInicio();

    }//GEN-LAST:event_jchInicioActionPerformed

    private void jchCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchCadastroActionPerformed
        // TODO add your handling code here:
        if (jchCadastro.isSelected()) {
            jchCadCliente.setEnabled(true);
            jchCadFornec.setEnabled(true);
            jchCadCasas.setEnabled(true);
            jchCadFunc.setEnabled(true);
        } else {
            jchCadCliente.setEnabled(false);
            jchCadFornec.setEnabled(false);
            jchCadCasas.setEnabled(false);
            jchCadFunc.setEnabled(false);

            jchCadCliente.setSelected(false);
            jchCadFornec.setSelected(false);
            jchCadCasas.setSelected(false);
            jchCadFunc.setSelected(false);

        }

    }//GEN-LAST:event_jchCadastroActionPerformed

    private void jchCadEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchCadEmpresaActionPerformed
        // TODO add your handling code here:
        if (jchCadEmpresa.isSelected()) {
            jchCadEmpresaCadastro.setEnabled(true);
        } else {
            jchCadEmpresaCadastro.setEnabled(false);
            jchCadEmpresaCadastro.setSelected(false);
        }
    }//GEN-LAST:event_jchCadEmpresaActionPerformed

    private void btnLiberaTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberaTodosActionPerformed
        // TODO add your handling code here:
        liberarTodos();
    }//GEN-LAST:event_btnLiberaTodosActionPerformed

    private void btnBloqueiaTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloqueiaTodosActionPerformed
        // TODO add your handling code here:
        bloquearTodos();
    }//GEN-LAST:event_btnBloqueiaTodosActionPerformed

    private void jchRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchRelatoriosActionPerformed
        // TODO add your handling code here:
        liberarRelatorios();
    }//GEN-LAST:event_jchRelatoriosActionPerformed

    private void jchGerenciadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchGerenciadorActionPerformed
        // TODO add your handling code here:
        liberarGerenciadorMenu();
    }//GEN-LAST:event_jchGerenciadorActionPerformed

    private void jchAlugueisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchAlugueisActionPerformed
        // TODO add your handling code here:
        if (jchAlugueis.isSelected()) {
            jchAlugueisAlugar.setEnabled(true);
        } else {
            jchAlugueisAlugar.setEnabled(false);
            jchAlugueisAlugar.setSelected(false);
        }

    }//GEN-LAST:event_jchAlugueisActionPerformed

    private void jchProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchProdutosActionPerformed
        // TODO add your handling code here:
        if (jchProdutos.isSelected()) {
            jchProdutosCadastro.setEnabled(true);
        } else {
            jchProdutosCadastro.setEnabled(false);
            jchProdutosCadastro.setSelected(false);
        }
    }//GEN-LAST:event_jchProdutosActionPerformed

    private void jchEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchEmailActionPerformed
        // TODO add your handling code here:
        if (jchEmail.isSelected()) {
            jchGerenciadorEmail.setEnabled(true);
        } else {
            jchGerenciadorEmail.setEnabled(false);
            jchGerenciadorEmail.setSelected(false);
        }
    }//GEN-LAST:event_jchEmailActionPerformed

    private void jchFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchFinanceiroActionPerformed
        // TODO add your handling code here:
        liberarFinanceiro();
    }//GEN-LAST:event_jchFinanceiroActionPerformed

    private void jchFinanceiroContasAReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchFinanceiroContasAReceberActionPerformed
        // TODO add your handling code here:
        liberaFinanceiroContasAReceber();
    }//GEN-LAST:event_jchFinanceiroContasAReceberActionPerformed

    private void jchFinanceiroContasAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchFinanceiroContasAPagarActionPerformed
        // TODO add your handling code here:
        liberaFinanceiroContasAPagar();
    }//GEN-LAST:event_jchFinanceiroContasAPagarActionPerformed

    private void jchRelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchRelatorioClientesActionPerformed
        // TODO add your handling code here:
        liberarRelatoriosAtributosClientes();
    }//GEN-LAST:event_jchRelatorioClientesActionPerformed

    private void jchRelatoriosCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchRelatoriosCasasActionPerformed
        // TODO add your handling code here:
        liberarRelatoriosAtributosCasas();
    }//GEN-LAST:event_jchRelatoriosCasasActionPerformed

    private void jchConfiguracaoEBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchConfiguracaoEBackupActionPerformed
        // TODO add your handling code here:
        liberarConfiguracao();
    }//GEN-LAST:event_jchConfiguracaoEBackupActionPerformed

    private void jchConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchConfiguracaoActionPerformed
        // TODO add your handling code here:
        liberarConfiguracaoParametro();
    }//GEN-LAST:event_jchConfiguracaoActionPerformed

    private void jchBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchBackupActionPerformed
        // TODO add your handling code here:
        liberarConfiguracaoBackup();
    }//GEN-LAST:event_jchBackupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloqueiaTodos;
    private javax.swing.JButton btnLiberaTodos;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator47;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JComboBox<String> jcboUsuario;
    private javax.swing.JCheckBox jchAlugueis;
    private javax.swing.JCheckBox jchAlugueisAlugar;
    private javax.swing.JCheckBox jchBackup;
    private javax.swing.JCheckBox jchBackupIniciar;
    private javax.swing.JCheckBox jchCadCasas;
    private javax.swing.JCheckBox jchCadCliente;
    private javax.swing.JCheckBox jchCadEmpresa;
    private javax.swing.JCheckBox jchCadEmpresaCadastro;
    private javax.swing.JCheckBox jchCadFornec;
    private javax.swing.JCheckBox jchCadFunc;
    private javax.swing.JCheckBox jchCadastro;
    private javax.swing.JCheckBox jchCasasAlugadasRel;
    private javax.swing.JCheckBox jchCasasNaoAlugadasRel;
    private javax.swing.JCheckBox jchCasasTodasRel;
    private javax.swing.JCheckBox jchClientesAniversarioRel;
    private javax.swing.JCheckBox jchClientesFiadoresRel;
    private javax.swing.JCheckBox jchClientesGeralRel;
    private javax.swing.JCheckBox jchConfiguracao;
    private javax.swing.JCheckBox jchConfiguracaoEBackup;
    private javax.swing.JCheckBox jchConfiguracaoParametros;
    private javax.swing.JCheckBox jchContasAPagarLancamentos;
    private javax.swing.JCheckBox jchContasAPagarPagamentos;
    private javax.swing.JCheckBox jchContasAReceberLancamentos;
    private javax.swing.JCheckBox jchContasAReceberRecebimentos;
    private javax.swing.JCheckBox jchEmail;
    private javax.swing.JCheckBox jchFinanceiro;
    private javax.swing.JCheckBox jchFinanceiroContasAPagar;
    private javax.swing.JCheckBox jchFinanceiroContasAReceber;
    private javax.swing.JCheckBox jchGerenciador;
    private javax.swing.JCheckBox jchGerenciadorEmail;
    private javax.swing.JCheckBox jchInicio;
    private javax.swing.JCheckBox jchProdutos;
    private javax.swing.JCheckBox jchProdutosCadastro;
    private javax.swing.JCheckBox jchRelatorioClientes;
    private javax.swing.JCheckBox jchRelatorios;
    private javax.swing.JCheckBox jchRelatoriosCasas;
    // End of variables declaration//GEN-END:variables
}
