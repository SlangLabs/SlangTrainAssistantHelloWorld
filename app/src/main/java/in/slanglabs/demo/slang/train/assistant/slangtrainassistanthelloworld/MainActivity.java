package in.slanglabs.demo.slang.train.assistant.slangtrainassistanthelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import in.slanglabs.assistants.train.PNR;
import in.slanglabs.assistants.train.SlangTrainAssistant;
import in.slanglabs.assistants.train.Train;
import in.slanglabs.assistants.train.TrainSearchQuery;
import in.slanglabs.assistants.train.TrainSortQuery;
import in.slanglabs.platform.SlangSession;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SlangTrainAssistant.initialize(this);
        SlangTrainAssistant.setAction(new SlangTrainAssistant.Action() {
            @Override
            public Status onSearch(TrainSearchQuery query, SlangSession session, Bundle b) {
                // handle train search
                Toast.makeText(
                        MainActivity.this,
                        "TrainSearch [src:" + query.getSource().getName()
                                + ", dest:" + query.getDestination().getName()
                                + ", date:" + query.getDepartureDate()
                                + "]",
                        Toast.LENGTH_LONG
                ).show();
                return Status.SUCCESS;
            }

            @Override
            public Status onSort(TrainSortQuery query, SlangSession session, Bundle b) {
                // handle sorting of listings
                Toast.makeText(
                        MainActivity.this,
                        "TrainSort [type:" + query.getSortType().name()
                                + ", field:" + query.getSortField().name()
                                + "]",
                        Toast.LENGTH_LONG
                ).show();
                return Status.SUCCESS;
            }

            @Override
            public Status onTrackStatus(Train train, SlangSession session, Bundle b) {
                // handle train status tracking
                Toast.makeText(
                        MainActivity.this,
                        "TrainTrack [name:" + train.getName()
                                + ", number:" + train.getNumber() +
                                "]",
                        Toast.LENGTH_LONG
                ).show();
                return Status.SUCCESS;
            }

            @Override
            public Status onPNRLookUp(PNR pnr, SlangSession session, Bundle b) {
                // handle PNR lookup
                Toast.makeText(
                        MainActivity.this,
                        "PNR [number:" + pnr.getNumber() + "]",
                        Toast.LENGTH_LONG
                ).show();
                return Status.SUCCESS;
            }
        });

    }
}
