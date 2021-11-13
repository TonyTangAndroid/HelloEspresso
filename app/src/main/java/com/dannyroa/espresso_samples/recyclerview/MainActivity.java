package com.dannyroa.espresso_samples.recyclerview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  RecyclerView rvTeams;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    rvTeams = (RecyclerView) findViewById(R.id.recycler_view);

    List<Team> teams = DataProvider.list();

    TeamAdapter adapter = new TeamAdapter(MainActivity.this, teams);

    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    rvTeams.setLayoutManager(layoutManager);
    rvTeams.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
