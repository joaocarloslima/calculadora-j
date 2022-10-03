package br.com.fiap.controller;

import java.sql.SQLException;

import br.com.fiap.dao.LogDao;
import br.com.fiap.model.Log;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    @FXML private TextField display;

    private String operacao;
    private double numero;

    public void digitarNumero(ActionEvent event){
        Button botao = (Button) event.getSource();
        if (display.getText().equals("0")) display.setText("");
        display.setText(display.getText() + botao.getText());
    }

    public void clear(){
        display.setText("0");
    }

    public void raiz(){
        double numero = Double.valueOf(display.getText());
        double raiz = Math.sqrt(numero);
        display.setText(String.valueOf(raiz));
        salvarLog(new Log(numero, 0, "raiz", raiz));
    }

    public void quadrado(){
        double numero = Double.valueOf(display.getText());
        double quadrado = Math.pow(numero, 2);
        display.setText(String.valueOf(quadrado));
        salvarLog(new Log(numero, 0, "quadrado", quadrado));
    }

    public void iniciarOperacao(ActionEvent event){
        numero = Double.valueOf(display.getText());
        Button botao = (Button) event.getSource();
        operacao = botao.getText();
        clear();
    }

    public void calcular(){
        double numero2 = Double.valueOf(display.getText());
        double resultado;

       switch (operacao){
            case "+":
                resultado = numero + numero2;
                break;
                
            case "-":
                resultado = numero - numero2;
                break;

            case "x":
                resultado = numero * numero2;
                break;

            case "/":
                resultado = numero / numero2;
                break;

            default:
                throw new IllegalArgumentException("Operação inválida");
       }

        display.setText(String.valueOf(resultado));

        salvarLog(new Log(numero, numero2, operacao, resultado));

    }

    private void salvarLog(Log log){
        try{
            new LogDao().inserir(log);
        }catch(SQLException e){
            var alert = new Alert(AlertType.ERROR);
            alert.setContentText("Erro ao salvar log no banco de dados");
            alert.show();
        }
    }


}
