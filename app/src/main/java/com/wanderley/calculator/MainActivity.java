package com.wanderley.calculator;

import static com.wanderley.calculator.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,numeroNove, ponto,soma,subtracao,multiplicacao,divisao,igual,botao_limpar;

    private TextView txtExpresao, txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){

                txtExpresao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){

                TextView expressao = findViewById(id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

    }

    private void IniciarComponentes(){     // Criar Método para chamar, recuperar os id's os componentes
        numeroZero = findViewById(id.numero_zero);
        numeroUm = findViewById(id.numero_um);
        numeroDois = findViewById(id.numero_dois);
        numeroTres = findViewById(id.numero_tres);
        numeroQuatro = findViewById(id.numero_quatro);
        numeroCinco = findViewById(id.numero_cinco);
        numeroSeis = findViewById(id.numero_seis);
        numeroSete = findViewById(id.numero_sete);
        numeroOito = findViewById(id.numero_oito);
        numeroNove = findViewById(id.numero_nove);
        ponto = findViewById(id.ponto);
        soma = findViewById(id.bt_soma);
        subtracao = findViewById(id.bt_subtracao);
        multiplicacao = findViewById(id.bt_multiplicacao);
        divisao = findViewById(id.bt_divisao);
        botao_limpar = findViewById(id.bt_limpar);
        txtExpresao = findViewById(id.txt_expressao);
        txtResultado = findViewById(id.txt_resultado);
        backspace = findViewById(id.backspace);
    }

    // Cria Método Acrescentar uma Expressão
    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){

        if (txtResultado.getText().equals("")){
            txtExpresao.setText("");
        }

        if (limpar_dados){
            txtResultado.setText("");
            txtExpresao.append(string);
        }
        else {
            txtExpresao.append(txtResultado.getText());
            txtExpresao.append(string);
            txtResultado.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.numero_zero:
                AcrescentarUmaExpressao("0",true);
                break;

            case R.id.numero_um:
                AcrescentarUmaExpressao("1", true);
                break;

            case R.id.numero_dois:
                AcrescentarUmaExpressao("2", true);
                break;

            case R.id.numero_tres:
                AcrescentarUmaExpressao("3", true);
                break;

            case R.id.numero_quatro:
                AcrescentarUmaExpressao("4", true);
                break;

            case R.id.numero_cinco:
                AcrescentarUmaExpressao("5", true);
                break;

            case R.id.numero_seis:
                AcrescentarUmaExpressao("6", true);
                break;

            case R.id.numero_sete:
                AcrescentarUmaExpressao("7", true);
                break;

            case R.id.numero_oito:
                AcrescentarUmaExpressao("8", true);
                break;

            case R.id.numero_nove:
                AcrescentarUmaExpressao("9", true);
                break;

            case id.ponto:
                AcrescentarUmaExpressao(".", true);
                break;

            case id.bt_soma:
                AcrescentarUmaExpressao("+", false);
                break;

            case id.bt_subtracao:
                AcrescentarUmaExpressao("-", false);
                break;

            case id.bt_multiplicacao:
                AcrescentarUmaExpressao("*", false);
                break;

            case id.bt_divisao:
                AcrescentarUmaExpressao("/", false);
                break;
        }
    }
}