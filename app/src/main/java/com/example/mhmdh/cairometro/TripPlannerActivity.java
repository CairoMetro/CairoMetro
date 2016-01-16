package com.example.mhmdh.cairometro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mhmdh.cairometro.TripGuide.MetroSystem;
import com.example.mhmdh.cairometro.TripGuide.Station;

import java.util.ArrayList;
import java.util.List;

public class TripPlannerActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner spinnerTo,spinnerFrom;
    Button buttonGetItinerary;
    TextView textViewStationNumber,textViewTripTime;
    LinearLayout layoutStationsContainer;
    List<String> listStationNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_planner);
        initStationNames();
        initView();
    }

    private void initStationNames() {
        listStationNames = new ArrayList<>();
        for(Station itr: MetroSystem.MARG_HELWAN_ARR)
            listStationNames.add(itr.name);
        for(Station itr: MetroSystem.SHOBRA_GIZA_STATIONS)
            listStationNames.add(itr.name);
        for(Station itr: MetroSystem.THIRD_LINE_STATIONS)
            listStationNames.add(itr.name);
    }

    private void initView() {
        spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        initSpinner();
        textViewStationNumber = (TextView) findViewById(R.id.textViewStationNumber);
        textViewTripTime = (TextView) findViewById(R.id.textViewTripTime);
        buttonGetItinerary = (Button) findViewById(R.id.buttonGetItinerary);
        layoutStationsContainer = (LinearLayout) findViewById(R.id.layoutStationsContainer);

        buttonGetItinerary.setOnClickListener(this);
    }

    private void initSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listStationNames);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonGetItinerary:
                onGetItineraryClicked(spinnerFrom.getSelectedItemPosition(),spinnerTo.getSelectedItemPosition());
                break;
        }
    }

    private void onGetItineraryClicked(int from, int to) {
        String fromName = listStationNames.get(from);
        String toName = listStationNames.get(to);
        if(fromName.equals(toName)) return;

        List<Station[]> stations = MetroSystem.getInstance().metroPath(fromName,toName);
        layoutStationsContainer.removeAllViews();

        int numOfStations = 0;

        for(int i=stations.size()-1;i>=0;i--) {
            Station[] listItr=stations.get(i);
            for (int j=0;j < listItr.length;j++)
            {
                if(i < stations.size()-1&& j ==0) continue;
                Station arrItr = listItr[j];
                if(j == listItr.length-1 && i != 0) layoutStationsContainer.addView(inflateStationView(arrItr,true));
                else layoutStationsContainer.addView(inflateStationView(arrItr,false));
            }
            numOfStations += listItr.length;
        }

        numOfStations -= (stations.size()-1);

        textViewStationNumber.setText(getString(R.string.number_of_stations) + " = "+numOfStations+" "+getString(R.string.station));
        textViewTripTime.setText(getString(R.string.time_of_trip) +  " = "+(numOfStations * 2.5)+" "+getString(R.string.minute));
    }

    View inflateStationView(Station station,boolean isConverterStation)
    {
        View view = getLayoutInflater().inflate(R.layout.station_item,null);
        TextView name = (TextView) view.findViewById(R.id.textViewStationName);
        name.setText(station.name);
        if(isConverterStation)
        {
            ImageView imageView = (ImageView) view.findViewById(R.id.imageViewStation);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.metro_red));

            name.setText("ححول من "+station.name);
        }
        else name.setText(station.name);
        return view;
    }
}
