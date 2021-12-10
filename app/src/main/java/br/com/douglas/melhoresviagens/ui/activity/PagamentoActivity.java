package br.com.douglas.melhoresviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.douglas.melhoresviagens.R;
import br.com.douglas.melhoresviagens.model.Pacote;
import br.com.douglas.melhoresviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    private Pacote pacote;
    public static final String TITULO_APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APP_BAR);

        pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraPreco();
    }

    private void mostraPreco() {
        TextView tv_preco = findViewById(R.id.pagamento_preco_pacote);
        String precoFormatatoBR = MoedaUtil.formataMoedaParaBR(pacote.getPreco());
        tv_preco.setText(precoFormatatoBR);
    }
}