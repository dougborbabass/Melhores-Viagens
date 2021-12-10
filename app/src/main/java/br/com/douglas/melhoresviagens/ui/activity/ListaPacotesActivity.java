package br.com.douglas.melhoresviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.douglas.melhoresviagens.R;
import br.com.douglas.melhoresviagens.dao.PacoteDao;
import br.com.douglas.melhoresviagens.model.Pacote;
import br.com.douglas.melhoresviagens.ui.adapter.ListaPacotesAdapter;

import static br.com.douglas.melhoresviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pacotes";

    private ListaPacotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APP_BAR);
        List<Pacote> pacotes = carregaPacotesDao();
        configuraLista(pacotes);
    }

    private void configuraLista(List<Pacote> pacotes) {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        configuraAdapter(pacotes, listaDePacotes);
    }

    private void configuraAdapter(List<Pacote> pacotes, ListView listaDePacotes) {
        adapter = new ListaPacotesAdapter(pacotes, this);
        listaDePacotes.setAdapter(adapter);
        listaDePacotes.setOnItemClickListener((adapterView, view, position, l) -> {
            vaiParaResumoPacote(pacotes.get(position));
        });
    }

    private List<Pacote> carregaPacotesDao() {
        return new PacoteDao().lista();
    }

    private void vaiParaResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}