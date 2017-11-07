package team_18.financialadvisor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    String[] months={"11/10/17: Car Payment $150.00","11/15/17: Phone Bill $80.00","11/29/17: Internet Bill $30.00"};
    BarGraph barGraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barGraph = (BarGraph) findViewByID(R.id.barGraph);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new NewEntry(44f, 0));
        barEntries.add(new NewEntry(54f, 1));
        barEntries.add(new NewEntry(64f, 2));
        barEntries.add(new NewEntry(74f, 3));
        barEntries.add(new NewEntry(84f, 4));
        barEntries.add(new NewEntry(94f, 5));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");

        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("August");
        theDates.add("September");
        theDates.add("October");
        theDates.add("November");
        theDates.add("December");

        BarData theData = new BarData(theDates,barEntries);
        barGraph.setData(theData);

        barGraph.setTouchEnabled(true);
        barGraph.setDragEnabled(true);
        barGraph.setScaleEnabled(true);


        Button buttonMMGoToBS = (Button)findViewById(R.id.buttonMMGoToBS);
        Button buttonMMGoToCV = (Button)findViewById(R.id.buttonMMGoToCV);
        Button buttonMMGoToGV = (Button)findViewById(R.id.buttonMMGoToGV);

        //Setting button behavior
        buttonMMGoToBS.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(MainActivity.this, BudgetSummary.class);
                startActivity(myIntent);
            }
        });

        buttonMMGoToCV.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(MainActivity.this, CalendarView.class);
                startActivity(myIntent);
            }
        });

        buttonMMGoToGV.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(MainActivity.this, GraphView.class);
                startActivity(myIntent);
            }
        });

        lst= (ListView) findViewById(R.id.list);
        ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,months);
        lst.setAdapter(arrayadapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv= (TextView) view;
                Toast.makeText(MainActivity.this,tv.getText()+"  "+position,Toast.LENGTH_LONG).show();
            }
        });

        }

    }

