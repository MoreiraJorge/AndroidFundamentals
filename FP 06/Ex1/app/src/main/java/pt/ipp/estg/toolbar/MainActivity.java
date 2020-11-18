package pt.ipp.estg.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pt.ipp.estg.toolbar.adapters.ContactAdapter;
import pt.ipp.estg.toolbar.models.Contact;


public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecycler;
    private ContactAdapter myAdapter;

    private Toolbar myToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Contact> contacts = createContactList(200);

        myAdapter = new ContactAdapter(this, contacts);

        myRecycler = findViewById(R.id.recycler_view);
        myRecycler.setAdapter(myAdapter);

        myRecycler.setLayoutManager(new LinearLayoutManager(this));
        myRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        myToolBar = (Toolbar) findViewById(R.id.toolbar);
        myToolBar.setTitle("Lista de Contactos");
        setSupportActionBar(myToolBar);

        Log.d("MAIN_ACTIVITY","onCreate()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent i = new Intent(this, SettingsActivity.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Contact> createContactList(int size){
        Random rd = new Random();
        List<Contact> tmp = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            tmp.add(i, new Contact("Person" + i, rd.nextBoolean()));
            //myAdapter.notifyItemInserted(i);
        }
        return tmp;
    }
}