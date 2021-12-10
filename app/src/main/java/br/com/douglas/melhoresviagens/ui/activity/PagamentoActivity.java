package br.com.douglas.melhoresviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")) {
            pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostraPreco();
        }

        Button btn_pagamento = findViewById(R.id.pagamento_finalizar_compra);
        btn_pagamento.setOnClickListener(view -> {
            Intent i = new Intent(this, ResumoCompraActivity.class);
            i.putExtra("pacote", pacote);
            startActivity(i);
        });

    }

    private void mostraPreco() {
        TextView tv_preco = findViewById(R.id.pagamento_preco_pacote);
        String precoFormatatoBR = MoedaUtil.formataMoedaParaBR(pacote.getPreco());
        tv_preco.setText(precoFormatatoBR);
    }
}