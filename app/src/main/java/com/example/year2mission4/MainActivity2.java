package com.example.year2mission4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener{
    ListView seriesList;
    ArrayAdapter<Double> adapterForList;
    TextView tv1;
    TextView tv2;
    Intent in;
    Intent in2;
    String mathmaticalOrGeometric;
    double firstNumber;
    double marginOrMulitplex;
    Double[] arrOfSeries = new Double[20];
    double sum;
    int pos;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        seriesList = (ListView) findViewById(R.id.listSeriesList);
        in = getIntent();
        in2 = new Intent(this, MainActivity3.class);
        mathmaticalOrGeometric = in.getStringExtra("mathmaticalOrGeometric");
        firstNumber = in.getDoubleExtra("firstNumber", -1);
        marginOrMulitplex = in.getDoubleExtra("marginOrMulitplex", -1);

        tv1 = (TextView) findViewById(R.id.textview1);
        tv2 = (TextView) findViewById(R.id.textview2);

        if(mathmaticalOrGeometric.equals("geometric"))
        {
            for(int i = 0; i < 20; i++)
            {
                arrOfSeries[i] = firstNumber * Math.pow(marginOrMulitplex, i);
            }
        }
        else
        {
            for(int i = 0; i < 20; i++)
            {
                arrOfSeries[i] = firstNumber + marginOrMulitplex * i;
            }
        }
        adapterForList = new ArrayAdapter<Double>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrOfSeries);
        seriesList.setAdapter(adapterForList);
        seriesList.setOnItemLongClickListener(this);
        seriesList.setOnCreateContextMenuListener(this);
    }

    /**
     * returns to main
     * @param view
     */
    public void goToMain(View view)
    {
        finish();
    }


    /**
     * this func creates the context menu
     * @param menu The context menu that is being built
     * @param v The view for which the context menu is being built
     * @param menuInfo Extra information about the item for which the
     *            context menu should be shown. This information will vary
     *            depending on the class of v.
     */
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("What do you want to see?");
        menu.add("position of the value");
        menu.add("sum of series until the position of the value");
    }

    /**
     * this func activates when a option is pressed and show what is needed on the text view
     * @param item
     * @return
     */
    public boolean onContextItemSelected(MenuItem item)
    {
        String oper = item.getTitle().toString();
        if (oper.equals("position of the value"))
        {
            tv1.setText("Position");
            tv2.setText(pos + "");
            return true;
        }
        if (oper.equals("sum of series until the position of the value"))
        {
            if (mathmaticalOrGeometric.equals("geometric"))
            {
                sum = firstNumber * ((Math.pow(marginOrMulitplex, pos) - 1) / (marginOrMulitplex - 1));
            }
            else
            {
                sum = pos * (2 * firstNumber + (pos - 1) * marginOrMulitplex) / 2;
            }
            tv1.setText("Sum till position");
            tv2.setText("" + sum);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * this function activates when an item from the list is long pressed and it gets its position
     * @param parent The AbsListView where the click happened
     * @param view The view within the AbsListView that was clicked
     * @param position The position of the view in the list
     * @param id The row id of the item that was clicked
     *
     * @return
     */
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        pos = position + 1;
        return false;
    }

    /**
     * goes to the credits
     * @param view
     */
    public void goToCredits(View view) {
        in2 = new Intent(this, MainActivity3.class);
        startActivity(in2);
    }
}