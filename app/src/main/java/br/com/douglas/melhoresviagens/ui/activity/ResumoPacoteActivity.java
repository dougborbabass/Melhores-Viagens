package br.com.douglas.melhoresviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.douglas.melhoresviagens.R;
import br.com.douglas.melhoresviagens.model.Pacote;
import br.com.douglas.melhoresviagens.util.DiasUtil;
import br.com.douglas.melhoresviagens.util.MoedaUtil;
import br.com.douglas.melhoresviagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle("Resumo do pacote");

        Pacote pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView tv_local = findViewById(R.id.resumo_pacote_local);
        tv_local.setText(pacoteSP.getLocal());

        ImageView im_local = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveUmDrawable(this, pacoteSP.getImagem());
        im_local.setImageDrawable(drawableDoPacote);

        TextView tv_dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmdias(pacoteSP.getDias());
        tv_dias.setText(diasEmTexto);

        TextView tv_preco = findViewById(R.id.resumo_pacote_preco);
        String precoFormatadoBR = MoedaUtil.formataMoedaParaBR(pacoteSP.getPreco());
        tv_preco.setText(precoFormatadoBR);

        TextView tv_data = findViewById(R.id.resumo_pacote_data);
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, pacoteSP.getDias());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        String dataIdaFormatada = sdf.format(dataIda.getTime());
        String dataVoltaFormatada = sdf.format(dataVolta.getTime());
        String dataFormatadaDaViagem = dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
        tv_data.setText(dataFormatadaDaViagem);

    }
}