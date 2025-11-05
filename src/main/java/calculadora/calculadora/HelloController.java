package calculadora.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HelloController {
    @FXML
    private TextField txtVisor;


    private String expressao = "";


    @FXML
    protected void onNumero(ActionEvent event) {
        Button botao = (Button) event.getSource();
        expressao += botao.getText();
        txtVisor.setText(expressao);

    }

    @FXML
    protected void onOperacao(ActionEvent event) {
        Button botao = (Button) event.getSource();
        String operacao = botao.getText();

        switch (operacao) {
            case "AC":
                expressao = "";
                txtVisor.setText(expressao);
                break;
            case "=":
                onCalcular();
                break;
            case "*":
            case "+":
            case "-":
            case "/":
            case "(":
            case ")":
                expressao += operacao;
                txtVisor.setText(expressao);
                break;
            default:
                expressao += operacao;
                txtVisor.setText(expressao);

        }
    }


    @FXML
    protected void onCalcular() {
        // divide a expressão em partes pelos operadores
        if (expressao.contains("+")) {
            String[] partes = expressao.split("\\+");
            int num1 = Integer.parseInt(partes[0]);
            int num2 = Integer.parseInt(partes[1]);
            txtVisor.setText(String.valueOf(num1 + num2));

        } else if (expressao.contains("-")) {
            String[] partes = expressao.split("-");
            int num1 = Integer.parseInt(partes[0]);
            int num2 = Integer.parseInt(partes[1]);
            txtVisor.setText(String.valueOf(num1 - num2));

        } else if (expressao.contains("*")) {
            String[] partes = expressao.split("\\*");
            int num1 = Integer.parseInt(partes[0]);
            int num2 = Integer.parseInt(partes[1]);
            txtVisor.setText(String.valueOf(num1 * num2));

        } else if (expressao.contains("/")) {
            String[] partes = expressao.split("/");
            int num1 = Integer.parseInt(partes[0]);
            int num2 = Integer.parseInt(partes[1]);
            if (num2 == 0) {
                txtVisor.setText("Erro");
            } else {
                txtVisor.setText(String.valueOf(num1 / num2));
            }
        } else {
            txtVisor.setText("Inválido");
        }
    }
}


