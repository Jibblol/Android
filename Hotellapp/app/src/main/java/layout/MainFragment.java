package layout;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vegard.hotellapp.BookingsActivity;
import com.example.vegard.hotellapp.HotellApp;
import com.example.vegard.hotellapp.LateArrivalActivity;
import com.example.vegard.hotellapp.MainActivity;
import com.example.vegard.hotellapp.MapActivity;
import com.example.vegard.hotellapp.R;
import com.example.vegard.hotellapp.RoomServiceActivity;

public class MainFragment extends Fragment {

    private HotellApp hotell;
    private Button roomServiceBtn, lateArrivalBtn, mapBtn, myBookingsBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        roomServiceBtn = (Button) (R.id.roomServiceBtn);
        roomServiceBtn.setOnClickListener(this);

        lateArrivalBtn = (Button) findViewById(R.id.lateArrivalBtn);
        lateArrivalBtn.setOnClickListener(this);

        mapBtn = (Button) findViewById(R.id.mapBtn);
        mapBtn.setOnClickListener(this);

        myBookingsBtn = (Button) findViewById(R.id.myBookingsBtn);
        myBookingsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == roomServiceBtn) {
            startActivity(new Intent(MainActivity.this, RoomServiceActivity.class));
        } else if (v == lateArrivalBtn){
            startActivity(new Intent(MainActivity.this, LateArrivalActivity.class));
        } else if (v == mapBtn){
            startActivity(new Intent(MainActivity.this, MapActivity.class));
        } else if (v == myBookingsBtn){
            startActivity(new Intent(MainActivity.this, BookingsActivity.class));
        }
    }
}
