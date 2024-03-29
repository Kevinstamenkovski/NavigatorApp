package app.netlify.navigatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity {

    private EditText sourceEditText;
    private EditText destinationEditText;
    private Button navigateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(v -> exitApp());
        sourceEditText = findViewById(R.id.editTextSource);
        destinationEditText = findViewById(R.id.editTextDestination);
        navigateButton = findViewById(R.id.buttonNavigate);

        navigateButton.setOnClickListener(v -> navigate());


        findViewById(R.id.buttonStartSecondActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Optionally, pass data to SecondActivity using Intent extras
                intent.putExtra("MESSAGE", "Hello, Second Activity!");
                intent.putExtra("NUMBER", 42);

                // Start the SecondActivity
                startActivity(intent);
            }
        });
    }


    private void navigate() {
        String source = sourceEditText.getText().toString();
        String destination = destinationEditText.getText().toString();

        if (source.isEmpty() || destination.isEmpty()) {
            Toast.makeText(this, "Please enter source and destination", Toast.LENGTH_SHORT).show();
            return;
        }

        Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=" +
                source + "&destination=" + destination);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            Toast.makeText(this, "Google Maps app is not installed", Toast.LENGTH_SHORT).show();
        }
    }
    private void exitApp() {
        finishAffinity();
    }
}