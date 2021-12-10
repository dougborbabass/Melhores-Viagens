package br.com.douglas.melhoresviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.douglas.melhoresviagens.R;
import br.com.douglas.melhoresviagens.model.Pacote;
import br.com.douglas.melhoresviagens.util.Datautil;
import br.com.douglas.melhoresviagens.util.DiasUtil;
import br.com.douglas.melhoresviagens.util.MoedaUtil;
import br.com.douglas.melhoresviagens.util.ResourcesUtil;

import static br.com.douglas.melhoresviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo do pacote";
    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APP_BAR);
        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos();
            configuraBotao();
        }
    }

    private void configuraBotao() {
        Button btn_realizaPagamento = findViewById(R.id.resumo_pacote_realizar_pagamento);
        btn_realizaPagamento.setOnClickListener(view -> {
            vaiParaPagamento();
        });
    }

    private void inicializaCampos() {
        mostraLocalPacote();
        mostraImagemPacote();
        mostraDiasPacote();
        mostraPrecoPacote();
        mostraDataDaViagem();
    }

    private void vaiParaPagamento() {
        Intent i = new Intent(this, PagamentoActivity.class);
        i.putExtra(CHAVE_PACOTE, pacote);
        startActivity(i);
    }

    private void mostraLocalPacote() {
        TextView tv_local = findViewById(R.id.resumo_pacote_local);
        tv_local.setText(pacote.getLocal());
    }

    private void mostraImagemPacote() {
        ImageView im_local = findViewById(R.id.resumo_pacote_banner);
        Drawable drawableDoPacote = ResourcesUtil.devolveUmDrawable(this, pacote.getImagem());
        im_local.setImageDrawable(drawableDoPacote);
    }

    private void mostraDiasPacote() {
        TextView tv_dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmdias(pacote.getDias());
        tv_dias.setText(diasEmTexto);
    }

    private void mostraPrecoPacote() {
        TextView tv_preco = findViewById(R.id.resumo_pacote_preco);
        String precoFormatadoBR = MoedaUtil.formataMoedaParaBR(pacote.getPreco());
        tv_preco.setText(precoFormatadoBR);
    }

    private void mostraDataDaViagem() {
        TextView tv_data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = Datautil.periodoDaViagemEmTexto(pacote.getDias());
        tv_data.setText(dataFormatadaDaViagem);
    }
}