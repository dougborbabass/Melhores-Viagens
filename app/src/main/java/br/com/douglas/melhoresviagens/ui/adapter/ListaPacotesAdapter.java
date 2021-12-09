package br.com.douglas.melhoresviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.douglas.melhoresviagens.R;
import br.com.douglas.melhoresviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraQtdDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView tv_preco = viewCriada.findViewById(R.id.item_pacote_preco);
        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        BigDecimal precoDoPacote = pacote.getPreco();
        String precoPacoteFormatoBR = formatoBR
                .format(precoDoPacote)
                .replace("R$", "R$ ");
        tv_preco.setText(precoPacoteFormatoBR);
    }

    private void mostraQtdDias(View viewCriada, Pacote pacote) {
        TextView tv_dias = viewCriada.findViewById(R.id.item_pacote_dias);
        int qtdDias = pacote.getDias();
        tv_dias.setText(qtdDias > 1 ? qtdDias + " dias" : qtdDias + " dia");
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView im_image = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Resources.Theme tema = context.getTheme();
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable, tema);
        im_image.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView tv_local = viewCriada.findViewById(R.id.item_pacote_local);
        tv_local.setText(pacote.getLocal());
    }
}
