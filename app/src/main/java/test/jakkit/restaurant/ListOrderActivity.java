package test.jakkit.restaurant;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class ListOrderActivity extends ActionBarActivity {
    private TextView txtShowOfficer;
    private TextView txtShowTable;
    private TextView txtShowIdFood;
    private TextView txtShowFood;
    private TextView txtShowPrice;
    private TextView txtShowVolume;
    private String strOfficer, strTable, strNumFood, strFood, strPrice, strVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);

        bindWidget();

        showDate();

        showOfficer();

        showTable();

        //showIdFood();

        //showFood();

       // showPrice();

        //showVolume();
    }

   /* private void showVolume() {
        strVolume = getIntent().getExtras().getString(strVolume);
        txtShowVolume.setText(strVolume);
    }

    private void showPrice() {
        strPrice = getIntent().getExtras().getString(strPrice);
        txtShowPrice.setText(strPrice);
    }

    private void showFood() {
        strFood = getIntent().getExtras().getString(strFood);
        txtShowFood.setText(strFood);
    }

    private void showIdFood() {
        strNumFood = getIntent().getExtras().getString(strNumFood);
        txtShowIdFood.setText(strNumFood);
    } */

    private void showDate() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView time = (TextView) findViewById(R.id.txtShowDateTime);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh-mm-ss a");
                                String dateString = sdf.format(date);
                                time.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }
    private void showOfficer() {
        strOfficer = getIntent().getExtras().getString("Officer");
        txtShowOfficer.setText(strOfficer);
    }
    private void showTable(){
        strTable = getIntent().getExtras().getString("Table");
        txtShowTable.setText(strTable);
    }

    private void bindWidget() {
        txtShowOfficer = (TextView) findViewById(R.id.txtShowOfficer);
        txtShowTable = (TextView) findViewById(R.id.txtShowTable);

       /* txtShowIdFood = (TextView)findViewById(R.id.txtShowIdFood);
          txtShowFood = (TextView)findViewById(R.id.txtShowFood);
          txtShowPrice = (TextView)findViewById(R.id.txtShowPrice);
          txtShowVolume = (TextView)findViewById(R.id.txtShowVolume); */
    }
}
