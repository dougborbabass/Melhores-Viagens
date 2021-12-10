package br.com.douglas.melhoresviagens.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.douglas.melhoresviagens.R;
import br.com.douglas.melhoresviagens.dao.PacoteDao;
import br.com.douglas.melhoresviagens.model.Pacote;
import br.com.douglas.melhoresviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pacotes";

    private ListaPacotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        RecyclerView recyclerView = findViewById(R.id.lista_pacotes_recyclerview);
        List<Pacote> pacotes = new PacoteDao().lista();

        recyclerView.setAdapter(new ListaPacotesAdapter(pacotes, this));


    }
}