///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.dao;
//
//import javax.swing.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Diego Danniel
// */
//public class CasasDAO {
//
//    ConexaoDAO conect = new ConexaoDAO();
//    Connection conexao = null;
//    PreparedStatement pst = null;
//    ResultSet rs = null;
//    private static Casas cs;
//
//    public CasasDAO() {
//
//    }
//
//    /*
//     * Metodo resposanvel pelo cadastro das casas
//     */
//    public List<Casas> novoId() throws SQLException {
//        List<Casas> casa = new ArrayList<>();
//        conect.conexao();
//        String sql = "SELECT MAX(CODIGO) AS CODIGO FROM CASAS_CADASTRO";
//        pst = conect.conn.prepareStatement(sql);
//        rs = pst.executeQuery();
//        while (rs.next()) {
//            casa.add(new Casas(rs.getInt("CODIGO") + 1));
//
//        }
//        return casa;
//
//    }
//
//    public boolean insert(Casas casas) throws ParseException {
//
//        conect.conexao();
//        String sql = "INSERT INTO `casas_cadastro` (`CLASSIFICACAO`,"
//                + "`TIPO_IMOVEL`,"
//                + "`ENDERECO`,"
//                + "`N_ENDERECO`, "
//                + "`CEP`,"
//                + "`BAIRRO`,"
//                + "`CIDADE`,"
//                + "`UF`, "
//                + "`REFERENCIA`,"
//                + "`LOTE`, "
//                + "`QUADRA`,"
//                + "`MEDIDA`,"
//                + "`METRO_QUADRADO`,"
//                + "`QTDE_SALA`,"
//                + "`QTDE_QUARTOS`,"
//                + "`QTDE_GARAGEM`,"
//                + "QTDE_BWC,"
//                //		+ "`DATA_CONSTRUCAO`,"
//                //		+ "`DATA_REFORMA`,"
//                + "`OBSERVACAO_1`) "
//                + "VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        try {
//            pst = conect.conn.prepareStatement(sql);
//            pst.setString(1, casas.getClassificacao());
//            pst.setString(2, casas.getTipoImovel());
//            // pst.setString(3, casas.getDataCadastro());
//            pst.setString(3, casas.getEndereco());
//            pst.setString(4, casas.getNumero_end());
//            pst.setInt(5, casas.getCep());
//            pst.setString(6, casas.getBairro());
//            pst.setString(7, casas.getCidade());
//            pst.setString(8, casas.getUf());
//            pst.setString(9, casas.getReferencia());
//            pst.setDouble(10, casas.getLote());
//            pst.setFloat(11, casas.getQuadra());
//            pst.setFloat(12, casas.getMedida());
//            pst.setFloat(13, casas.getMetroQuadrado());
//            pst.setInt(14, casas.getQuantidadeSala());
//            pst.setInt(15, casas.getQuantidadeQuartos());
//            pst.setInt(16, casas.getQuantidadeGaragem());
//            pst.setInt(17, casas.getQuantidadeBanheiros());
//            //pst.setString(19, casas.getDataDeContrucao());
//            // pst.setDate(20, casas.getDataReforma());
//            pst.setString(18, casas.getObservacao1());
//
//            int add = pst.executeUpdate();
//            if (add > 0) {
//                JOptionPane.showMessageDialog(null, "Dados gravados com sucesso");
//            }
//            return true;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CasasDAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//            return false;
//        }
//
//    }
//
//    public boolean update(Casas casas) throws ParseException {
//        conect.conexao();
//        String sql = "UPDATE `casas_cadastro` SET \n"
//                + "  `CLASSIFICACAO` = ?,\n"
//                + "  `TIPO_IMOVEL` = ?,\n"
//                + "  `ENDERECO` = ?,\n"
//                + "  `N_ENDERECO` = ?,\n"
//                + "  `CEP` = ?,\n"
//                + "  `BAIRRO` = ?,\n"
//                + "  `CIDADE` = ?,\n"
//                + "  `UF` = ?,\n"
//                + "  `REFERENCIA` = ?,\n"
//                + "  `LOTE` = ?,\n"
//                + "  `QUADRA` = ?,\n"
//                + "  `MEDIDA` = ?,\n"
//                + "  `METRO_QUADRADO` = ?,\n"
//                + "  `QTDE_SALA` = ?,\n"
//                + "  `QTDE_QUARTOS` = ?,\n"
//                + "  `QTDE_GARAGEM` = ?,\n"
//                + "  `QTDE_BWC` = ?,\n"
////                + "  `DATA_CONSTRUCAO` = ?,\n"
////                + "  `DATA_REFORMA` = ?,\n"
//                + "  `OBSERVACAO_1` = ? \n"
//                + "WHERE `CODIGO` = ?;";
//        try {
//            pst = conect.conn.prepareStatement(sql);
//            pst.setString(1, casas.getClassificacao());
//            pst.setString(2, casas.getTipoImovel());
//            // pst.setString(3, casas.getDataCadastro());
//            pst.setString(3, casas.getEndereco());
//            pst.setString(4, casas.getNumero_end());
//            pst.setInt(5, casas.getCep());
//            pst.setString(6, casas.getBairro());
//            pst.setString(7, casas.getCidade());
//            pst.setString(8, casas.getUf());
//            pst.setString(9, casas.getReferencia());
//            pst.setDouble(10, casas.getLote());
//            pst.setFloat(11, casas.getQuadra());
//            pst.setFloat(12, casas.getMedida());
//            pst.setFloat(13, casas.getMetroQuadrado());
//            pst.setInt(14, casas.getQuantidadeSala());
//            pst.setInt(15, casas.getQuantidadeQuartos());
//            pst.setInt(16, casas.getQuantidadeGaragem());
//            pst.setInt(17, casas.getQuantidadeBanheiros());
//            //pst.setString(19, casas.getDataDeContrucao());
//            // pst.setDate(20, casas.getDataReforma());
//            pst.setString(18, casas.getObservacao1());
//            pst.setInt(19, casas.getCodigoCasa());
//            int add = pst.executeUpdate();
//            while (add > 0) {
//                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
//                return true;
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Atenção\nNão e possivel alterar os dados\n"+ex.getMessage());
//            return false;
//        }
//
//        return true;
//    }
//
//    public List<Casas> findAll(int codigo) throws SQLException {
//
//        List<Casas> casa = new ArrayList<>();
//        conect.conexao();
//        String sql = "SELECT * FROM CASAS_CADASTRO WHERE CODIGO = '" + codigo + "'";
//        try {
//            pst = conect.conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            if (rs.next()) {
//                casa.add(new Casas(rs.getInt("CODIGO"),
//                        rs.getString("CLASSIFICACAO"),
//                        rs.getString("TIPO_IMOVEL"),
//                        rs.getString("ENDERECO"),
//                        rs.getString("N_ENDERECO"),
//                        rs.getInt("CEP"),
//                        rs.getString("BAIRRO"),
//                        rs.getString("CIDADE"),
//                        rs.getString("UF"),
//                        rs.getString("REFERENCIA"),
//                        rs.getFloat("LOTE"),
//                        rs.getFloat("QUADRA"),
//                        rs.getFloat("MEDIDA"),
//                        rs.getFloat("METRO_QUADRADO"),
//                        rs.getInt("QTDE_SALA"),
//                        rs.getInt("QTDE_QUARTOS"),
//                        //rs.getInt("QTDE_SUITE") ,
//                        rs.getInt("QTDE_GARAGEM"),
//                        rs.getInt("QTDE_BWC"),
//                        rs.getString("OBSERVACAO_1")));
//            }
//            return casa;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//            return casa;
//        }
//
//    }
//
//    public List<Casas> findAllProximo(Casas c) throws SQLException {
//
//        List<Casas> casa = new ArrayList<>();
//        conect.conexao();
//        //String sql = "SELECT * FROM CASAS_CADASTRO";
//        try {
//            //  pst = conect.conn.prepareStatement(sql);
//            //  rs = pst.executeQuery();
//            if (rs.next()) {
//                casa.add(new Casas(rs.getInt("CODIGO"),
//                        rs.getString("CLASSIFICACAO"),
//                        rs.getString("TIPO_IMOVEL"),
//                        rs.getString("ENDERECO"),
//                        rs.getString("N_ENDERECO"),
//                        rs.getInt("CEP"),
//                        rs.getString("BAIRRO"),
//                        rs.getString("CIDADE"),
//                        rs.getString("UF"),
//                        rs.getString("REFERENCIA"),
//                        rs.getFloat("LOTE"),
//                        rs.getFloat("QUADRA"),
//                        rs.getFloat("MEDIDA"),
//                        rs.getFloat("METRO_QUADRADO"),
//                        rs.getInt("QTDE_SALA"),
//                        rs.getInt("QTDE_QUARTOS"),
//                        //rs.getInt("QTDE_SUITE") ,
//                        rs.getInt("QTDE_GARAGEM"),
//                        rs.getInt("QTDE_BWC"),
//                        rs.getString("OBSERVACAO_1")));
//            }
//            return casa;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//            return casa;
//        }
//
//    }
//
//    public List<Casas> findAllAnterior(Casas c) throws SQLException {
//
//        List<Casas> casa = new ArrayList<>();
//        conect.conexao();
//        // String sql = "SELECT * FROM CASAS_CADASTRO";
//        try {
//            //     pst = conect.conn.prepareStatement(sql);
//            //    rs = pst.executeQuery();
//            if (rs.previous()) {
//                casa.add(new Casas(rs.getInt("CODIGO"),
//                        rs.getString("CLASSIFICACAO"),
//                        rs.getString("TIPO_IMOVEL"),
//                        rs.getString("ENDERECO"),
//                        rs.getString("N_ENDERECO"),
//                        rs.getInt("CEP"),
//                        rs.getString("BAIRRO"),
//                        rs.getString("CIDADE"),
//                        rs.getString("UF"),
//                        rs.getString("REFERENCIA"),
//                        rs.getFloat("LOTE"),
//                        rs.getFloat("QUADRA"),
//                        rs.getFloat("MEDIDA"),
//                        rs.getFloat("METRO_QUADRADO"),
//                        rs.getInt("QTDE_SALA"),
//                        rs.getInt("QTDE_QUARTOS"),
//                        //rs.getInt("QTDE_SUITE") ,
//                        rs.getInt("QTDE_GARAGEM"),
//                        rs.getInt("QTDE_BWC"),
//                        rs.getString("OBSERVACAO_1")));
//            }
//            return casa;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//            return casa;
//        }
//
//    }
//
//    public boolean deleteCasa(int codigo) {
//        try {
//            String sql = "DELETE FROM CASAS_CADASTRO WHERE CODIGO = '" + codigo + "'";
//            pst = conect.conn.prepareStatement(sql);
//            pst.execute();
//            if (rs.next()) {
//                JOptionPane.showMessageDialog(null, "Registro deletado com sucesso");
//                conect.conn.close();
//
//            }
//            return true;
//        } catch (SQLException ex) {
//
//            if (ex.getErrorCode() == 1451) {
//                JOptionPane.showMessageDialog(null, "A casa esta vinculada a mas de um registro\n" + ex.getMessage());
//            } else {
//                JOptionPane.showMessageDialog(null, ex.getNextException());
//            }
//        }
//        return true;
//    }
//
//}
