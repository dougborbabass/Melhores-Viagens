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
import br.com.douglas.melhoresviagens.util.MoedaUtil;
import br.com.douglas.melhoresviagens.util.ResourcesUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraImagemPacote();
        mostraLocalPacote();
        mostraDataDaViagem();
        mostraPrecoPacote();
    }

    private void mostraImagemPacote() {
        ImageView im_local = findViewById(R.id.resumo_compra_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveUmDrawable(this, pacote.getImagem());
        im_local.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocalPacote() {
        TextView tv_local = findViewById(R.id.resumo_compra_local);
        tv_local.setText(pacote.getLocal());
    }

    private void mostraDataDaViagem() {
        TextView tv_data = findViewById(R.id.resumo_compra_data);
        String dataFormatadaDaViagem = Datautil.periodoDaViagemEmTexto(pacote.getDias());
        tv_data.setText(dataFormatadaDaViagem);
    }

    private void mostraPrecoPacote() {
        TextView tv_preco = findViewById(R.id.resumo_compra_preco);
        String precoFormatadoBR = MoedaUtil.formataMoedaParaBR(pacote.getPreco());
        tv_preco.setText(precoFormatadoBR);
    }
}