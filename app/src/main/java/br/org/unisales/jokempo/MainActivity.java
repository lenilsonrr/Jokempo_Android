package br.org.unisales.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Random random = new Random();
    String escolha = "";
    String[] vJogo = {"Pedra", "Papel", "Tesoura"};

    public String escolhaMac() {
        Random random = new Random();
        ImageView vazio = findViewById(R.id.imageView);
        int posicaoSorteada = random.nextInt(vJogo.length);

        String macEsc = vJogo[posicaoSorteada];

        switch (macEsc) {
            case "Pedra":
                vazio.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                vazio.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                vazio.setImageResource(R.drawable.tesoura);
                break;
        }
        return macEsc;
    }

    public String regras(String j1, String j2){
        String desisao = "";
        if(j1==j2){
            desisao="Empatou";
        } else if (j1=="Pedra" && j2 =="Tesoura") {
            desisao="Ganhou";
        } else if (j1=="Pedra" && j2 =="Papel") {
            desisao="Pedeu";
        } else if (j1=="Papel" && j2 =="Pedra") {
            desisao="Ganhou";
        }else if (j1=="Papel" && j2 =="Tesoura") {
            desisao="Perdeu";
        }else if (j1=="Tesoura" && j2 =="Pedra") {
            desisao="Perdeu";
        }else if (j1=="Tesoura" && j2 =="Papel") {
            desisao="Ganhou";
        }
        return desisao;
    }

    public void btnPedra(View v) {
        TextView resultado = findViewById(R.id.textView3);
        escolha = "Pedra";
        String oponete =  escolhaMac();
        resultado.setText(regras(escolha,oponete));
    }

    public void btnPapel(View v) {
        TextView resultado = findViewById(R.id.textView3);
        escolha = "Papel";
        String oponete =  escolhaMac();
        resultado.setText(regras(escolha,oponete));
    }
    public void btnTesoura(View v) {
        TextView resultado = findViewById(R.id.textView3);
        escolha = "Tesoura";
        String oponete =  escolhaMac();
        resultado.setText(regras(escolha,oponete));
    }


}