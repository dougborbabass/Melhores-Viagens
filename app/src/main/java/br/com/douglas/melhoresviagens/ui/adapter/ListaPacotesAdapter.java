package br.com.douglas.melhoresviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.douglas.melhoresviagens.R;
import br.com.douglas.melhoresviagens.model.Pacote;
import br.com.douglas.melhoresviagens.util.DiasUtil;
import br.com.douglas.melhoresviagens.util.MoedaUtil;
import br.com.douglas.melhoresviagens.util.ResourcesUtil;

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
        String precoPacoteFormatoBR = MoedaUtil.formataMoedaParaBR(pacote.getPreco());
        tv_preco.setText(precoPacoteFormatoBR);
    }

    private void mostraQtdDias(View viewCriada, Pacote pacote) {
        TextView tv_dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmdias(pacote.getDias());
        tv_dias.setText(diasEmTexto);
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView im_image = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourcesUtil.devolveUmDrawable(context, pacote.getImagem());
        im_image.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView tv_local = viewCriada.findViewById(R.id.item_pacote_local);
        tv_local.setText(pacote.getLocal());
    }
}
