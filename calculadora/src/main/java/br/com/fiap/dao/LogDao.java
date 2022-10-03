package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.model.Log;

public class LogDao {
    
    public void inserir(Log log) throws SQLException{

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO DDD_CALCULADORA_TB_LOG VALUES (?, ?, ?, ?)");
        prepareStatement.setDouble(1, log.getNumero1());
        prepareStatement.setDouble(2, log.getNumero2());
        prepareStatement.setString(3, log.getOperacao());
        prepareStatement.setDouble(4, log.getResultado());
        prepareStatement.execute();
        con.close();
    }

}
