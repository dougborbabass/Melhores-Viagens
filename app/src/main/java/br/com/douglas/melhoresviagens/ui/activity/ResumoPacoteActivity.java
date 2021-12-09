package br.com.douglas.melhoresviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.douglas.melhoresviagens.R;
import br.com.douglas.melhoresviagens.model.Pacote;
import br.com.douglas.melhoresviagens.util.Datautil;
import br.com.douglas.melhoresviagens.util.DiasUtil;
import br.com.douglas.melhoresviagens.util.MoedaUtil;
import br.com.douglas.melhoresviagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo do pacote";
    private Pacote pacoteSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APP_BAR);

        pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraLocalPacote();
        mostraImagemPacote();
        mostraDiasPacote();
        mostraPrecoPacote();
        mostraDataDaViagem();

    }

    private void mostraLocalPacote() {
        TextView tv_local = findViewById(R.id.resumo_pacote_local);
        tv_local.setText(pacoteSP.getLocal());
    }

    private void mostraImagemPacote() {
        ImageView im_local = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveUmDrawable(this, pacoteSP.getImagem());
        im_local.setImageDrawable(drawableDoPacote);
    }

    private void mostraDiasPacote() {
        TextView tv_dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmdias(pacoteSP.getDias());
        tv_dias.setText(diasEmTexto);
    }

    private void mostraPrecoPacote() {
        TextView tv_preco = findViewById(R.id.resumo_pacote_preco);
        String precoFormatadoBR = MoedaUtil.formataMoedaParaBR(pacoteSP.getPreco());
        tv_preco.setText(precoFormatadoBR);
    }

    private void mostraDataDaViagem() {
        TextView tv_data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = Datautil.periodoDaViagemEmTexto(pacoteSP.getDias());
        tv_data.setText(dataFormatadaDaViagem);
    }
}