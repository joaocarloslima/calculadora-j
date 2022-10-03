package br.com.fiap.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField display;

    private String operacao;
    private double numero;

    public void digitarNumero(ActionEvent event){
        Button botao = (Button) event.getSource();
        display.setText(display.getText() + botao.getText());
    }

    public void clear(){
        display.setText("0");
    }

    public void raiz(){
        double numero = Double.valueOf(display.getText());
        double raiz = Math.sqrt(numero);
        display.setText(String.valueOf(raiz));
    }

    public void quadrado(){
        double numero = Double.valueOf(display.getText());
        double raiz = Math.pow(numero, 2);
        display.setText(String.valueOf(raiz));
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
        System.out.println(operacao);
        if(operacao.equals("+")){
            resultado = numero + numero2;
        }else{
            resultado = numero - numero2;
        }

        display.setText(String.valueOf(resultado));
    }


}
