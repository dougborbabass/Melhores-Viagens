package br.com.douglas.melhoresviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.douglas.melhoresviagens.R;
import br.com.douglas.melhoresviagens.model.Pacote;
import br.com.douglas.melhoresviagens.util.DiasUtil;
import br.com.douglas.melhoresviagens.util.MoedaUtil;
import br.com.douglas.melhoresviagens.util.ResourcesUtil;

public class ListaPacotesAdapter extends RecyclerView.Adapter<ListaPacotesAdapter.mViewHolder> {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
        return new mViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        Pacote pacote = pacotes.get(position);
        holder.preencheCampos(pacote);
    }


    @Override
    public int getItemCount() {
        return pacotes.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder {

        final TextView tv_preco;
        final TextView tv_dias;
        final ImageView im_image;
        final TextView tv_local;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_preco = itemView.findViewById(R.id.item_pacote_preco);
            tv_dias = itemView.findViewById(R.id.item_pacote_dias);
            im_image = itemView.findViewById(R.id.item_pacote_imagem);
            tv_local = itemView.findViewById(R.id.item_pacote_local);
        }

        private void preencheCampos(Pacote pacote) {
            String precoPacoteFormatoBR = MoedaUtil.formataMoedaParaBR(pacote.getPreco());
            tv_preco.setText(precoPacoteFormatoBR);

            String diasEmTexto = DiasUtil.formataEmdias(pacote.getDias());
            tv_dias.setText(diasEmTexto);

            Drawable drawableImagemPacote = ResourcesUtil.devolveUmDrawable(context, pacote.getImagem());
            im_image.setImageDrawable(drawableImagemPacote);

            tv_local.setText(pacote.getLocal());
        }
    }
}
