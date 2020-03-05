package br.com.view;

import br.com.controller.CasaControle;
import br.com.controller.UpperCase;
import br.com.controller.WebServiceCep;
import br.com.model.Casas;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Diego Danniel
 */
public class FormCasas extends javax.swing.JInternalFrame {

    private static FormPesquisaCasas pesquisaCasas;
    private static FormPesquisarCidades cidades;
    private static FormPesquisarProprietarios proprietarios;
    private static FormCasas casaCadastro;
    private final CasaControle casas;
    private static Casas cs;
    JFileChooser file;

    public FormCasas() {
        initComponents();
        txtInscricaoMunicipal.setVisible(false);
        jblInscricaoMunicipal.setVisible(false);
        jTabbedPane1.getSelectedComponent();
        casas = new CasaControle();

        txtBairro.setDocument(new UpperCase().getDocument());
        txtCaminhoFoto.setDocument(new UpperCase().getDocument());
        txtCidades.setDocument(new UpperCase().getDocument());
        txtEndereco.setDocument(new UpperCase().getDocument());
        txtObservacao.setDocument(new UpperCase().getDocument());
        txtCidades.setDocument(new UpperCase().getDocument());
        txtReferencia.setDocument(new UpperCase().getDocument());
    }

    public static FormCasas geCasasCadastro() {
        if (casaCadastro == null) {
            casaCadastro = new FormCasas();
        }
        return casaCadastro;
    }

    public void selecionarPessoa() {
        if (rbtJuridico.isSelected()) {
            jblCpf.setText("CNPJ");
            jblRg.setText("INSCRIÇÃO ESTADUAL");
            txtInscricaoMunicipal.setVisible(true);
            jblInscricaoMunicipal.setVisible(true);
        }
        if (rbtFisico.isSelected()) {
            jblCpf.setText("CPF");
            jblRg.setText("RG");
            txtInscricaoMunicipal.setVisible(false);
            jblInscricaoMunicipal.setVisible(false);
        }
    }

    public void chamarTelaPesquisaCasas() {
        pesquisaCasas = new FormPesquisaCasas(this, true);
        pesquisaCasas.setVisible(true);
    }

    public void chamarTelaPesquisaCidades() {
        cidades = new FormPesquisarCidades(this, true);
        cidades.setVisible(true);
    }

    public void chamarTelaPesquisaProprietarios() {
        proprietarios = new FormPesquisarProprietarios(this, true);
        proprietarios.setVisible(true);
    }

    public void abrirFotos() {

        file = new JFileChooser("C:\\SysMac Imobiliario\\Fotos casas");
        file.setDialogTitle("Selecione a foto");
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int opc = file.showOpenDialog(this.file);
        if (opc == JFileChooser.APPROVE_OPTION) {
            File files = new File("Caminho");
            files = file.getSelectedFile();
            String fileName = files.getAbsolutePath();
            txtCaminhoFoto.setText(fileName);
            ImageIcon imagem = new ImageIcon(file.getSelectedFile().getPath());
            imagem.getImageLoadStatus();
            jlbRecebeFotos.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(jlbRecebeFotos.getWidth(),
                    jlbRecebeFotos.getHeight(), Image.SCALE_DEFAULT)));
        }

    }

    public void buscaCep() {
        //Faz a busca para o cep 58043-280
        WebServiceCep webServiceCep = WebServiceCep.searchCep(txtCep.getText());
        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

        //caso a busca ocorra bem, imprime os resultados.
        if (webServiceCep.wasSuccessful()) {
            txtEndereco.setText(webServiceCep.getLogradouroFull());
            txtCidades.setText(webServiceCep.getCidade());
            txtBairro.setText(webServiceCep.getBairro());
            jcboUf.setSelectedItem(webServiceCep.getUf());
            System.out.println("Cep: " + webServiceCep.getCep());
            System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
            System.out.println("Bairro: " + webServiceCep.getBairro());
            System.out.println("Cidade: "
                    + webServiceCep.getCidade() + "/" + webServiceCep.getUf());

            //caso haja problemas imprime as exce??es.
        } else {
            //JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());

            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
        }
    }

    public void novoId(Casas cs) throws SQLException {
        this.casas.novoId();

        casas.getCasaCadastroModel().forEach((Casas casas1) -> {
            txtCodigoCasa.setText(("000").concat(String.valueOf(casas1.getCodigoCasa())));
            txtBairro.setEnabled(true);
            txtBairro.setEnabled(true);
            txtCaminhoFoto.setEnabled(true);
            txtCep.setEnabled(true);
            txtCidades.setEnabled(true);
            txtCodigoCasa.setEnabled(true);
            txtCodigoCidade.setEnabled(true);
            txtCpf.setEnabled(true);
            txtEndereco.setEnabled(true);
            txtInscricaoMunicipal.setEnabled(true);
            txtLote.setEnabled(true);
            txtMedidas.setEnabled(true);
            txtMetroQ.setEnabled(true);
            txtNEndereco.setEnabled(true);
            txtObservacao.setEnabled(true);
            txtQtdeGaragem.setEnabled(true);
            txtQuadra.setEnabled(true);
            txtReferencia.setEnabled(true);
            txtRg.setEnabled(true);
            txtqtdeBwc.setEnabled(true);
            txtqtdeQuartos.setEnabled(true);
            txtqtdeSalas.setEnabled(true);
            txtqtdeSuite.setEnabled(true);
            jcboClassificacao.setEnabled(true);
            jcboTipoImovel.setEnabled(true);

            txtBairro.setText(null);
            txtBairro.setText(null);
            txtCaminhoFoto.setText(null);
            txtCep.setText(null);
            txtCidades.setText(null);

            txtEndereco.requestFocus(true);

            txtCodigoCidade.setText(null);
            txtCpf.setText(null);
            txtEndereco.setText(null);
            txtInscricaoMunicipal.setText(null);
            txtLote.setText("0,0");
            txtMedidas.setText("0,0");
            txtMetroQ.setText("0,0");
            txtNEndereco.setText(null);
            txtObservacao.setText(null);
            txtQtdeGaragem.setText(null);
            txtQuadra.setText("0,0");
            txtReferencia.setText(null);
            txtRg.setText(null);
            txtqtdeBwc.setText("0");
            txtqtdeQuartos.setText("0");
            txtqtdeSalas.setText("0");
            txtqtdeSuite.setText("0");
            jcboClassificacao.setSelectedItem(null);
            jcboTipoImovel.setSelectedItem(null);
            jcboUf.setSelectedItem(null);

            jcboUf.setEnabled(true);
            btnGravar.setEnabled(true);

        });

    }

    public void cadastrarCasas(CasaControle casas) {

        try {
            casas.getCasaCadastro().setClassificacao(jcboClassificacao.getSelectedItem().toString());
            casas.getCasaCadastro().setTipoImovel(jcboTipoImovel.getSelectedItem().toString());
            casas.getCasaCadastro().setDataCadastro(jdateCadastro.getDateFormatString());
            casas.getCasaCadastro().setEndereco(txtEndereco.getText());
            casas.getCasaCadastro().setNumero_end(txtNEndereco.getText());
            casas.getCasaCadastro().setCep(Integer.parseInt(txtCep.getText()));
            casas.getCasaCadastro().setBairro(txtBairro.getText());
            casas.getCasaCadastro().setCidade(txtCidades.getText());
            casas.getCasaCadastro().setUf(jcboUf.getSelectedItem().toString());
            casas.getCasaCadastro().setReferencia(txtReferencia.getText());
            casas.getCasaCadastro().setLote(Float.parseFloat(txtLote.getText().replace(",", ".")));
            casas.getCasaCadastro().setQuadra(Float.parseFloat(txtQuadra.getText().replace(",", ".")));
            casas.getCasaCadastro().setMedida(Float.parseFloat(txtMedidas.getText().replace(",", ".")));
            casas.getCasaCadastro().setMetroQuadrado(Float.parseFloat(txtMetroQ.getText().replace(",", ".")));
            casas.getCasaCadastro().setQuantidadeQuartos(Integer.parseInt(txtqtdeQuartos.getText()));
            casas.getCasaCadastro().setQuantidadeSala(Integer.parseInt(txtqtdeSalas.getText()));
            casas.getCasaCadastro().setQuantidadeGaragem(Integer.parseInt(txtQtdeGaragem.getText()));
            casas.getCasaCadastro().setQuantidadeBanheiros(Integer.parseInt(txtqtdeBwc.getText()));
            casas.getCasaCadastro().setDataDeContrucao(jdateContrucao.getJCalendar().toString());
            casas.getCasaCadastro().setDataReforma((Date) jdateReforma.getDate());
            casas.getCasaCadastro().setObservacao1(txtObservacao.getText());

            boolean add = casas.inserirCasa();

        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void alterarCasas(CasaControle casas) {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja processeguir com a alteração dos dados", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {

            try {
                casas.getCasaCadastro().setCodigoCasa(Integer.parseInt(txtCodigoCasa.getText()));
                casas.getCasaCadastro().setClassificacao(jcboClassificacao.getSelectedItem().toString());
                casas.getCasaCadastro().setTipoImovel(jcboTipoImovel.getSelectedItem().toString());
                casas.getCasaCadastro().setDataCadastro(jdateCadastro.getDateFormatString());
                casas.getCasaCadastro().setEndereco(txtEndereco.getText());
                casas.getCasaCadastro().setNumero_end(txtNEndereco.getText());
                casas.getCasaCadastro().setCep(Integer.parseInt(txtCep.getText()));
                
                casas.getCasaCadastro().setCidade(txtCidades.getText());
                casas.getCasaCadastro().setUf(jcboUf.getSelectedItem().toString());
                casas.getCasaCadastro().setReferencia(txtReferencia.getText());
                casas.getCasaCadastro().setLote(Float.parseFloat(txtLote.getText().replace(",", ".")));
                casas.getCasaCadastro().setQuadra(Float.parseFloat(txtQuadra.getText().replace(",", ".")));
                casas.getCasaCadastro().setMedida(Float.parseFloat(txtMedidas.getText().replace(",", ".")));
                casas.getCasaCadastro().setMetroQuadrado(Float.parseFloat(txtMetroQ.getText().replace(",", ".")));
                casas.getCasaCadastro().setQuantidadeQuartos(Integer.parseInt(txtqtdeQuartos.getText()));
                casas.getCasaCadastro().setQuantidadeSala(Integer.parseInt(txtqtdeSalas.getText()));
                casas.getCasaCadastro().setQuantidadeGaragem(Integer.parseInt(txtQtdeGaragem.getText()));
                casas.getCasaCadastro().setQuantidadeBanheiros(Integer.parseInt(txtqtdeBwc.getText()));
                casas.getCasaCadastro().setDataDeContrucao(jdateContrucao.getJCalendar().toString());
                casas.getCasaCadastro().setDataReforma((Date) jdateReforma.getDate());
                casas.getCasaCadastro().setObservacao1(txtObservacao.getText());
                if (txtBairro.getText().isEmpty()) {
                    this.casas.getCasaCadastro().setBairro(null);
                }
                else{
                    casas.getCasaCadastro().setBairro(txtBairro.getText());
                }

                boolean atualizarCasa = casas.atualizarCasa();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }

    }

    public void buscarCasa(Casas cs) throws SQLException {
        casas.listarCasas(Integer.parseInt(txtCodigoCasa.getText()));
        if (casas.getCasaCadastroModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum resultado esperado");
        } else {
            casas.getCasaCadastroModel().forEach((casas1) -> {
                txtCodigoCasa.setText(String.valueOf(casas1.getCodigoCasa()));
                jcboClassificacao.setSelectedItem(casas1.getClassificacao());
                jcboTipoImovel.setSelectedItem(casas1.getTipoImovel());
                txtEndereco.setText(casas1.getEndereco());
                jcboUf.setSelectedItem(casas1.getUf());
                txtNEndereco.setText(casas1.getNumero_end());
                txtCep.setText(String.valueOf(casas1.getCep()));
                txtReferencia.setText(casas1.getReferencia());
                txtBairro.setText(casas1.getBairro());
                txtCidades.setText(casas1.getCidade());
                txtqtdeSalas.setText(String.valueOf(casas1.getQuantidadeSala()));
                txtqtdeQuartos.setText(String.valueOf(casas1.getQuantidadeQuartos()));
                txtqtdeBwc.setText(String.valueOf(casas1.getQuantidadeBanheiros()));
                txtqtdeSuite.setText(String.valueOf(casas1.getQuantidadeSuite()));
                txtQtdeGaragem.setText(String.valueOf(casas1.getQuantidadeGaragem()));
                txtLote.setText(String.valueOf(casas1.getLote()).replace(".", ","));
                txtQuadra.setText(String.valueOf(casas1.getQuadra()).replace(".", ","));
                txtMedidas.setText(String.valueOf(casas1.getMedida()).replace(".", ","));
                txtMetroQ.setText(String.valueOf(casas1.getMetroQuadrado()).replace(".", ","));
                if (casas1.getObservacao1() == null) {
                    txtObservacao.setText("");
                } else {
                    txtObservacao.setText(String.valueOf(casas1.getObservacao1()));
                }
                btnEcluir.setEnabled(true);
                habilitarCampos();
                btnGravar.setText("EDITAR");
            });

        }
    }

    public void buscarCasaProxima(Casas cs) throws SQLException {
        casas.listarCasasProximo();
        if (casas.getCasaCadastroModel().isEmpty()) {

        } else {
            casas.getCasaCadastroModel().forEach((casas1) -> {
                txtCodigoCasa.setText(String.valueOf(casas1.getCodigoCasa()));
                jcboClassificacao.setSelectedItem(casas1.getClassificacao());
                jcboTipoImovel.setSelectedItem(casas1.getTipoImovel());
                txtEndereco.setText(casas1.getEndereco());
                jcboUf.setSelectedItem(casas1.getUf());
                txtBairro.setText(casas1.getBairro());
                txtNEndereco.setText(casas1.getNumero_end());
                txtCep.setText(String.valueOf(casas1.getCep()));
                txtReferencia.setText(casas1.getReferencia());
                txtCidades.setText(casas1.getCidade());
                txtqtdeSalas.setText(String.valueOf(casas1.getQuantidadeSala()));
                txtqtdeQuartos.setText(String.valueOf(casas1.getQuantidadeQuartos()));
                txtqtdeBwc.setText(String.valueOf(casas1.getQuantidadeBanheiros()));
                txtqtdeSuite.setText(String.valueOf(casas1.getQuantidadeSuite()));
                txtQtdeGaragem.setText(String.valueOf(casas1.getQuantidadeGaragem()));
                txtLote.setText(String.valueOf(casas1.getLote()).replace(".", ","));
                txtQuadra.setText(String.valueOf(casas1.getQuadra()).replace(".", ","));
                txtMedidas.setText(String.valueOf(casas1.getMedida()).replace(".", ","));
                txtMetroQ.setText(String.valueOf(casas1.getMetroQuadrado()).replace(".", ","));
                if (casas1.getObservacao1() == null) {
                    txtObservacao.setText("");
                } else {
                    txtObservacao.setText(String.valueOf(casas1.getObservacao1()));
                }

            });

        }
    }

    public void buscarCasaAnterior(Casas cs) throws SQLException {
        casas.listarCasasAnterior();
        if (casas.getCasaCadastroModel().isEmpty()) {

        } else {
            casas.getCasaCadastroModel().forEach((casas1) -> {
                txtCodigoCasa.setText(String.valueOf(casas1.getCodigoCasa()));
                jcboClassificacao.setSelectedItem(casas1.getClassificacao());
                jcboUf.setSelectedItem(casas1.getUf());
                jcboTipoImovel.setSelectedItem(casas1.getTipoImovel());
                txtEndereco.setText(casas1.getEndereco());
                txtNEndereco.setText(casas1.getNumero_end());
                txtBairro.setText(casas1.getBairro());
                txtCep.setText(String.valueOf(casas1.getCep()));
                txtReferencia.setText(casas1.getReferencia());
                txtCidades.setText(casas1.getCidade());
                txtqtdeSalas.setText(String.valueOf(casas1.getQuantidadeSala()));
                txtqtdeQuartos.setText(String.valueOf(casas1.getQuantidadeQuartos()));
                txtqtdeBwc.setText(String.valueOf(casas1.getQuantidadeBanheiros()));
                txtqtdeSuite.setText(String.valueOf(casas1.getQuantidadeSuite()));
                txtQtdeGaragem.setText(String.valueOf(casas1.getQuantidadeGaragem()));
                txtLote.setText(String.valueOf(casas1.getLote()).replace(".", ","));
                txtQuadra.setText(String.valueOf(casas1.getQuadra()).replace(".", ","));
                txtMedidas.setText(String.valueOf(casas1.getMedida()).replace(".", ","));
                txtMetroQ.setText(String.valueOf(casas1.getMetroQuadrado()).replace(".", ","));
                if (casas1.getObservacao1() == null) {
                    txtObservacao.setText("");
                } else {
                    txtObservacao.setText(String.valueOf(casas1.getObservacao1()));
                }
            });

        }
    }

    public void deletarCasas(CasaControle casas) throws SQLException {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse registro?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            casas.deletaCasas(Integer.parseInt(txtCodigoCasa.getText()));
            txtBairro.setText(null);
            txtBairro.setText(null);
            txtCaminhoFoto.setText(null);
            txtCep.setText(null);
            txtCidades.setText(null);
            txtCodigoCasa.setText(null);
            txtCodigoCidade.setText(null);
            txtCpf.setText(null);
            txtEndereco.setText(null);
            txtInscricaoMunicipal.setText(null);
            txtLote.setText("0,0");
            txtMedidas.setText("0,0");
            txtMetroQ.setText("0,0");
            txtNEndereco.setText(null);
            txtObservacao.setText(null);
            txtQtdeGaragem.setText(null);
            txtQuadra.setText("0,0");
            txtReferencia.setText(null);
            txtRg.setText(null);
            txtqtdeBwc.setText("0");
            txtqtdeQuartos.setText("0");
            txtqtdeSalas.setText("0");
            txtqtdeSuite.setText("0");
            txtQtdeGaragem.setText("0");
            jcboClassificacao.setSelectedItem(null);
            jcboTipoImovel.setSelectedItem(null);
            jcboUf.setSelectedItem(null);

        }

    }

    public void habilitarCampos() {
        txtBairro.setEnabled(true);
        txtBairro.setEnabled(true);
        txtCaminhoFoto.setEnabled(true);
        txtCep.setEnabled(true);
        txtCidades.setEnabled(true);
        txtCodigoCasa.setEnabled(true);
        txtCodigoCidade.setEnabled(true);
        txtCpf.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtInscricaoMunicipal.setEnabled(true);
        txtLote.setEnabled(true);
        txtMedidas.setEnabled(true);
        txtMetroQ.setEnabled(true);
        txtNEndereco.setEnabled(true);
        txtObservacao.setEnabled(true);
        txtQtdeGaragem.setEnabled(true);
        txtQuadra.setEnabled(true);
        txtReferencia.setEnabled(true);
        txtRg.setEnabled(true);
        txtqtdeBwc.setEnabled(true);
        txtqtdeQuartos.setEnabled(true);
        txtqtdeSalas.setEnabled(true);
        txtqtdeSuite.setEnabled(true);
        jcboClassificacao.setEnabled(true);
        jcboTipoImovel.setEnabled(true);

        btnGravar.setEnabled(true);
        btnBuscarCep.setEnabled(true);
        jcboUf.setEnabled(true);
    }

    public void desabilitarCampos() {
        txtBairro.setEnabled(false);
        txtBairro.setEnabled(false);
        txtCaminhoFoto.setEnabled(false);
        txtCep.setEnabled(false);
        txtCidades.setEnabled(false);
        // txtCodigoCasa.setEnabled(false);
        txtCodigoCidade.setEnabled(false);
        txtCpf.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtInscricaoMunicipal.setEnabled(false);
        txtLote.setEnabled(false);
        txtMedidas.setEnabled(false);
        txtMetroQ.setEnabled(false);
        txtNEndereco.setEnabled(false);
        txtObservacao.setEnabled(false);
        txtQtdeGaragem.setEnabled(false);
        txtQuadra.setEnabled(false);
        txtReferencia.setEnabled(false);
        txtRg.setEnabled(false);
        txtqtdeBwc.setEnabled(false);
        txtqtdeQuartos.setEnabled(false);
        txtqtdeSalas.setEnabled(false);
        txtqtdeSuite.setEnabled(false);
        jcboClassificacao.setEnabled(false);
        jcboTipoImovel.setEnabled(false);
        jcboUf.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel64 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoCasa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcboClassificacao = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcboTipoImovel = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jdateCadastro = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoCidade = new javax.swing.JTextField();
        txtCidades = new javax.swing.JTextField();
        jcboUf = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtqtdeSalas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtqtdeQuartos = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtqtdeBwc = new javax.swing.JTextField();
        txtqtdeSuite = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtQtdeGaragem = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JEditorPane();
        jLabel71 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txtNEndereco = new javax.swing.JTextField();
        btnBuscarCep = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jdateReforma = new com.toedter.calendar.JDateChooser();
        jdateContrucao = new com.toedter.calendar.JDateChooser();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtLote = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtQuadra = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMedidas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMetroQ = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox<>();
        jComboBox14 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jComboBox17 = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jComboBox18 = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jComboBox19 = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jComboBox20 = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jComboBox21 = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jComboBox22 = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jComboBox23 = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jComboBox24 = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jComboBox25 = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jComboBox26 = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jComboBox27 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jComboBox28 = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        jComboBox29 = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        jComboBox30 = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jComboBox31 = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jComboBox32 = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        jComboBox33 = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jComboBox34 = new javax.swing.JComboBox<>();
        jblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jblRg = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        rbtJuridico = new javax.swing.JRadioButton();
        rbtFisico = new javax.swing.JRadioButton();
        jblInscricaoMunicipal = new javax.swing.JLabel();
        txtInscricaoMunicipal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jComboBox35 = new javax.swing.JComboBox<>();
        jLabel66 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jComboBox36 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlbRecebeFotos = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        txtCaminhoFoto = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableNomeFotos = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEcluir = new javax.swing.JButton();
        btnNovoI = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel64.setText("jLabel64");

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de casas");
        setToolTipText("Cadastro de casas");
        setName("Cadastro de casas"); // NOI18N

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informações Gerais"));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("CÓDIGO:");

        txtCodigoCasa.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtCodigoCasa.setToolTipText("Press F2 para abrir a Tela de Casas");
        txtCodigoCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCasaActionPerformed(evt);
            }
        });
        txtCodigoCasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoCasaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoCasaKeyReleased(evt);
            }
        });

        jLabel2.setText("CLASSIFICAÇÃO");

        jcboClassificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\t", "COMERCIAL", "RESIDENCIAL" }));
        jcboClassificacao.setEnabled(false);

        jLabel3.setText("TIPO DE IMÓVEL");

        jcboTipoImovel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\t", "APARTAMENTO", "CASA COMERCIAL", "CASA RESIDENCIAL", "LOTE", "MISTO", "SOBRADO" }));
        jcboTipoImovel.setEnabled(false);

        jLabel4.setText("DATA DE CADASTRO");

        jLabel5.setText("ENDEREÇO");

        txtEndereco.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtEndereco.setEnabled(false);

        jLabel6.setText("BAIRRO");

        txtBairro.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtBairro.setEnabled(false);

        jLabel7.setText("CIDADE:");

        txtCodigoCidade.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtCodigoCidade.setToolTipText("Press F2 para abrir a tela de Cidades");
        txtCodigoCidade.setEnabled(false);
        txtCodigoCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoCidadeKeyPressed(evt);
            }
        });

        txtCidades.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtCidades.setEnabled(false);

        jcboUf.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jcboUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\t", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", " " }));
        jcboUf.setEnabled(false);

        jLabel8.setText("UF");

        jLabel9.setText("REFERÊNCIA");

        txtReferencia.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtReferencia.setEnabled(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "DETALHES DE APRESENTAÇÃO"));

        jLabel15.setText("SALA");

        txtqtdeSalas.setEnabled(false);

        jLabel16.setText("QUARTOS");

        txtqtdeQuartos.setEnabled(false);

        jLabel17.setText("BWC");

        txtqtdeBwc.setEnabled(false);

        txtqtdeSuite.setEnabled(false);

        jLabel18.setText("SUITE");

        txtQtdeGaragem.setEnabled(false);

        jLabel19.setText("GARAGEM");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdeGaragem, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtqtdeSalas, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(txtqtdeQuartos))
                            .addComponent(txtqtdeBwc, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtqtdeSuite, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtqtdeSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtqtdeQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtqtdeBwc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtqtdeSuite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtQtdeGaragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "OBSERVAÇÕES"));

        txtObservacao.setEnabled(false);
        jScrollPane3.setViewportView(txtObservacao);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jLabel71.setText("CEP°");

        txtCep.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtCep.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtCep.setEnabled(false);

        jLabel73.setText("N°");

        txtNEndereco.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtNEndereco.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtNEndereco.setEnabled(false);

        btnBuscarCep.setText("Buscar CEP");
        btnBuscarCep.setEnabled(false);
        btnBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCepActionPerformed(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Construção e Reforma"));

        jLabel74.setText("Contruida em:");

        jLabel75.setText("Ultima reforma:");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdateReforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdateContrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdateContrucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdateReforma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Medidas"));
        jPanel17.setToolTipText("");

        jLabel10.setText("LOTE");

        txtLote.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtLote.setForeground(new java.awt.Color(255, 0, 0));
        txtLote.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtLote.setEnabled(false);

        jLabel11.setText("QUADRA");

        txtQuadra.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtQuadra.setForeground(new java.awt.Color(255, 0, 0));
        txtQuadra.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtQuadra.setEnabled(false);

        jLabel14.setText("MEDIDAS");

        txtMedidas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtMedidas.setForeground(new java.awt.Color(255, 0, 0));
        txtMedidas.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtMedidas.setEnabled(false);

        jLabel12.setText("M²");

        txtMetroQ.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtMetroQ.setForeground(new java.awt.Color(255, 0, 0));
        txtMetroQ.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtMetroQ.setEnabled(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel11))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel10))
                            .addComponent(jLabel14))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtMedidas))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuadra))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLote))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMetroQ, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtQuadra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMetroQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel73)
                                    .addComponent(txtNEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBairro)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel71)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarCep))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCodigoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcboUf, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(0, 226, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcboTipoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcboClassificacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdateCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodigoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jcboTipoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(jcboClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdateCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel71)
                    .addComponent(jLabel73))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCep, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(0, 0, 0)
                            .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(0, 0, 0)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("DADOS DO IMÓVEL", jPanel1);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "DETALHES GERAL"));

        jLabel29.setText("HALL SOCIAL");

        jComboBox6.setForeground(new java.awt.Color(56, 66, 33));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel30.setText("LAVABO");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel31.setText("LIVING");

        jLabel32.setText("SALA DE VISITAS");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel33.setText("SALA DE JANTAR");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel34.setText("SALA INTIMA");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel35.setText("HIDRO");

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel36.setText("CLOSET");

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel37.setText("LAREIRA");

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel38.setText("COPA");

        jLabel39.setText("ÁREA SERVIÇO");

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel40.setText("DEP.EMPREGADA");

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel41.setText("CHURRASQUEIRA");

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel42.setText("SACADA");

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel43.setText("DISPENSA");

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel44.setText("PISO");

        jComboBox21.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel45.setText("SALA DE JOGOS");

        jComboBox22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel46.setText("SALA DE FESTA");

        jComboBox23.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel47.setText("PISCINA");

        jComboBox24.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel48.setText("APTO P/ ANDAR");

        jComboBox25.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel49.setText("ÁGUA");

        jComboBox26.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel50.setText("ENERGIA");

        jComboBox27.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel51.setText("GÁS");

        jComboBox28.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel52.setText("QUINTAL");

        jComboBox29.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel53.setText("JARDIM");

        jComboBox30.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel54.setText("BWC SOCIAL");

        jComboBox31.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel55.setText("COZINHA");

        jComboBox32.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jLabel56.setText("ILUM. PUBLICA");

        jComboBox33.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SIM", "NÃO" }));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Observações"));

        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton5.setText("INSERIR");

        jButton6.setText("EXCLUIR");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addComponent(jLabel30)
                                    .addGap(4, 4, 4)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel31)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel32)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel40))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel42))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addGap(4, 4, 4)
                                    .addComponent(jComboBox30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel53)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel54)
                                        .addGap(4, 4, 4)
                                        .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel44))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(4, 4, 4)
                                .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(4, 4, 4)
                                .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(4, 4, 4)
                                .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel56))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel29)
                        .addGap(4, 4, 4)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 227, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(6, 6, 6)
                .addComponent(jButton6)
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, jComboBox14, jComboBox15, jComboBox16, jComboBox17, jComboBox18, jComboBox28);

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45)
                        .addComponent(jComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel55)
                        .addComponent(jComboBox32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel53)
                        .addComponent(jComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel56))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel54)
                                .addComponent(jComboBox23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel46)
                                .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel34)
                                .addComponent(jLabel47)
                                .addComponent(jComboBox24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel52))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44)
                                .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel48))
                            .addComponent(jLabel43))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel49)
                                .addComponent(jLabel35)
                                .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel31)
                                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel39)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)
                                    .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40)))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel41)
                            .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel50))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel51)))))
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton6))))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, jComboBox14, jComboBox15, jComboBox16, jComboBox17, jComboBox18, jComboBox28);

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, jComboBox10, jComboBox27, jComboBox6, jComboBox7, jComboBox8, jComboBox9);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DETALHES", jPanel3);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "DADOS DO PROPRIETARIO"));

        jLabel57.setText("CÓDIGO");

        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField23KeyPressed(evt);
            }
        });

        jLabel58.setText("NOME");

        jLabel59.setText("ENDEREÇO");

        jLabel60.setText("BAIRRO");

        jLabel61.setText("CIDADE");

        jLabel62.setText("N°");

        jLabel63.setText("UF");

        jComboBox34.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jblCpf.setText("CPF");

        jblRg.setText("RG");

        jLabel67.setText("REFERÊNCIA");

        buttonGroup1.add(rbtJuridico);
        rbtJuridico.setText("JURIDICA");
        rbtJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtJuridicoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtFisico);
        rbtFisico.setText("FISICA");
        rbtFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFisicoActionPerformed(evt);
            }
        });

        jblInscricaoMunicipal.setText("INSCRIÇÃO MUNICIPAL");

        jButton1.setText("GRAVAR");

        jButton2.setText("INSERIR");

        jButton7.setText("PESQUISAR");

        jButton8.setText("EXCLUIR");

        jButton9.setText("CANCELAR");

        jLabel65.setText("NACIONALIDADE");

        jComboBox35.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel66.setText("DATA DE NASCIMENTO");

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "DADOS COMPLEMENTARES"));

        jLabel68.setText("VALOR DE RECEBIMENTO EM PORCENTAGEM NA VENDA");

        jLabel69.setText("VALOR DE RECEBIMENTO BRUTO NA VENDA");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel68)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField31)
                    .addComponent(jTextField30, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("ACORDO DE VALORES", jPanel12);

        jLabel70.setText("NOME");

        jComboBox36.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NOME", "MATRICULA"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jButton13.setText("+>>");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("<<-");

        jButton15.setText("+");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)
                        .addContainerGap(753, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox36, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(jComboBox36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("CORRETORES", jPanel13);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(191, 191, 191))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(rbtFisico)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rbtJuridico))
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField26)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                            .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField28))
                                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField24)))))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jblCpf)
                                        .addGap(5, 5, 5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel62)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(jTextField29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jblRg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jblInscricaoMunicipal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtInscricaoMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel65)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox35, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox34, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtJuridico)
                    .addComponent(rbtFisico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblCpf)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblRg)
                            .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblInscricaoMunicipal)
                            .addComponent(txtInscricaoMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65)
                            .addComponent(jComboBox35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66)))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(jComboBox34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DADOS DO PROPRIETÁRIO(S)", jPanel4);

        jlbRecebeFotos.setBackground(new java.awt.Color(204, 204, 255));
        jlbRecebeFotos.setForeground(new java.awt.Color(204, 204, 255));
        jlbRecebeFotos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Fotos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "FOTOS DO IMÓVEL"));

        jLabel72.setText("CAMINHO DO ARQUIVO");

        jButton16.setText("BUSCAR");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jTableNomeFotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "FOTO"
            }
        ));
        jScrollPane5.setViewportView(jTableNomeFotos);

        jButton23.setText("INSERIR");

        jButton24.setText("GRAVAR");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCaminhoFoto)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton24))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel72)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCaminhoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24)
                    .addComponent(jButton23))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbRecebeFotos, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbRecebeFotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("FOTOS DO IMÓVEL", jPanel5);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "VALORES DE VENDAS E ALUGUEL"));

        jLabel21.setText("VALOR DE VENDA");

        jLabel22.setText("VALOR DE RENDA");

        jLabel23.setText("VALOR DE ENTRADA");

        jLabel24.setText("VALOR PRESTAÇÃO");

        jLabel25.setText("VALOR DO ALUGUEL");

        jLabel26.setText("VALOR IPTU");

        jLabel27.setText("SITUAÇÃO");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setText("ATÉ");

        jButton21.setText("INSERIR");

        jButton22.setText("GRAVAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(63, 63, 63)
                                    .addComponent(jLabel27))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(jTextField21, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField20, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 645, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22)
                    .addComponent(jButton21))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("VALORES", jPanel15);

        btnGravar.setText("GRAVAR");
        btnGravar.setEnabled(false);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnEcluir.setText("EXCLUIR");
        btnEcluir.setEnabled(false);
        btnEcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEcluirActionPerformed(evt);
            }
        });

        btnNovoI.setText("NOVO");
        btnNovoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoIActionPerformed(evt);
            }
        });

        jButton18.setText(">");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("<");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("<<");

        jButton25.setText(">>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovoI, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnEcluir)
                    .addComponent(btnNovoI)
                    .addComponent(jButton18)
                    .addComponent(jButton19)
                    .addComponent(jButton20)
                    .addComponent(jButton25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(180, 50, 978, 469);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFisicoActionPerformed
        // TODO add your handling code here:
        selecionarPessoa();
    }//GEN-LAST:event_rbtFisicoActionPerformed

    private void rbtJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtJuridicoActionPerformed
        // TODO add your handling code here:
        selecionarPessoa();
    }//GEN-LAST:event_rbtJuridicoActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        abrirFotos();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        try {
            if (btnGravar.getText().equals("GRAVAR")) {
                cadastrarCasas(casas);
            } else if (btnGravar.getText().equals("EDITAR")) {
                alterarCasas(casas);
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void txtCodigoCasaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCasaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            chamarTelaPesquisaCasas();
        }
    }//GEN-LAST:event_txtCodigoCasaKeyPressed

    private void txtCodigoCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCidadeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            chamarTelaPesquisaCidades();
        }
    }//GEN-LAST:event_txtCodigoCidadeKeyPressed

    private void jTextField23KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            chamarTelaPesquisaProprietarios();
        }
    }//GEN-LAST:event_jTextField23KeyPressed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        try {
            // TODO add your handling code here:
            buscarCasa(cs);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FormCasas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            // TODO add your handling code here:
            buscarCasaProxima(cs);
        } catch (SQLException ex) {
            Logger.getLogger(FormCasas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        try {
            // TODO add your handling code here:
            buscarCasaAnterior(cs);
        } catch (SQLException ex) {
            Logger.getLogger(FormCasas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void btnEcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEcluirActionPerformed
        try {
            // TODO add your handling code here:
            deletarCasas(casas);
        } catch (SQLException ex) {
            Logger.getLogger(FormCasas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEcluirActionPerformed

    private void txtCodigoCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCasaActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            buscarCasa(cs);
            
           
        } catch (SQLException ex) {
           
        }
    }//GEN-LAST:event_txtCodigoCasaActionPerformed

    private void btnNovoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoIActionPerformed
      

        try {
            if (btnNovoI.getText().equals("NOVO")) {
                novoId(cs);
                habilitarCampos();
                btnNovoI.setText("CANCELAR");
                btnGravar.setText("GRAVAR");
                btnPesquisar.setEnabled(false);
                btnEcluir.setEnabled(false);
            } else if (btnNovoI.getText().equals("CANCELAR")) {
                desabilitarCampos();
                btnGravar.setText("GRAVAR");
                btnNovoI.setText("NOVO");
                txtCodigoCasa.setText(null);
                txtBairro.setText(null);
                txtBairro.setText(null);
                txtCaminhoFoto.setText(null);
                txtCep.setText(null);
                txtCidades.setText(null);
                txtCodigoCasa.setText(null);
                txtCodigoCidade.setText(null);
                txtCpf.setText(null);
                txtEndereco.setText(null);
                txtInscricaoMunicipal.setText(null);
                txtLote.setText("0,0");
                txtMedidas.setText("0,0");
                txtMetroQ.setText("0,0");
                txtNEndereco.setText(null);
                txtObservacao.setText(null);
                txtQtdeGaragem.setText(null);
                txtQuadra.setText("0,0");
                txtReferencia.setText(null);
                txtRg.setText(null);
                txtqtdeBwc.setText("0");
                txtqtdeQuartos.setText("0");
                txtqtdeSalas.setText("0");
                txtqtdeSuite.setText("0");
                txtQtdeGaragem.setText("0");
                jcboClassificacao.setSelectedItem(null);
                jcboTipoImovel.setSelectedItem(null);
                jcboUf.setSelectedItem(null);
                btnGravar.setEnabled(false);
                btnEcluir.setEnabled(false);
                btnPesquisar.setEnabled(true);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FormCasas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNovoIActionPerformed

    private void btnBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCepActionPerformed
        // TODO add your handling code here:
        buscaCep();
    }//GEN-LAST:event_btnBuscarCepActionPerformed

    private void txtCodigoCasaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCasaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCasaKeyReleased

    public JTextField getTxtCodigoCasa() {
        return txtCodigoCasa;
    }

    public void setTxtCodigoCasa(JTextField txtCodigoCasa) {
        this.txtCodigoCasa = txtCodigoCasa;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCep;
    private javax.swing.JButton btnEcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovoI;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox20;
    private javax.swing.JComboBox<String> jComboBox21;
    private javax.swing.JComboBox<String> jComboBox22;
    private javax.swing.JComboBox<String> jComboBox23;
    private javax.swing.JComboBox<String> jComboBox24;
    private javax.swing.JComboBox<String> jComboBox25;
    private javax.swing.JComboBox<String> jComboBox26;
    private javax.swing.JComboBox<String> jComboBox27;
    private javax.swing.JComboBox<String> jComboBox28;
    private javax.swing.JComboBox<String> jComboBox29;
    private javax.swing.JComboBox<String> jComboBox30;
    private javax.swing.JComboBox<String> jComboBox31;
    private javax.swing.JComboBox<String> jComboBox32;
    private javax.swing.JComboBox<String> jComboBox33;
    private javax.swing.JComboBox<String> jComboBox34;
    private javax.swing.JComboBox<String> jComboBox35;
    private javax.swing.JComboBox<String> jComboBox36;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableNomeFotos;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel jblCpf;
    private javax.swing.JLabel jblInscricaoMunicipal;
    private javax.swing.JLabel jblRg;
    private javax.swing.JComboBox<String> jcboClassificacao;
    private javax.swing.JComboBox<String> jcboTipoImovel;
    private javax.swing.JComboBox<String> jcboUf;
    private com.toedter.calendar.JDateChooser jdateCadastro;
    private com.toedter.calendar.JDateChooser jdateContrucao;
    private com.toedter.calendar.JDateChooser jdateReforma;
    private javax.swing.JLabel jlbRecebeFotos;
    private javax.swing.JRadioButton rbtFisico;
    private javax.swing.JRadioButton rbtJuridico;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCaminhoFoto;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidades;
    private javax.swing.JTextField txtCodigoCasa;
    private javax.swing.JTextField txtCodigoCidade;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtInscricaoMunicipal;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtMedidas;
    private javax.swing.JTextField txtMetroQ;
    private javax.swing.JTextField txtNEndereco;
    private javax.swing.JEditorPane txtObservacao;
    private javax.swing.JTextField txtQtdeGaragem;
    private javax.swing.JTextField txtQuadra;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtqtdeBwc;
    private javax.swing.JTextField txtqtdeQuartos;
    private javax.swing.JTextField txtqtdeSalas;
    private javax.swing.JTextField txtqtdeSuite;
    // End of variables declaration//GEN-END:variables
}
