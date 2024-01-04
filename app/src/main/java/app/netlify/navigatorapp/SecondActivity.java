package app.netlify.navigatorapp;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Retrieve data passed from MainActivity
        if (getIntent().getExtras() != null) {
            String message = getIntent().getStringExtra("MESSAGE");
            int number = getIntent().getIntExtra("NUMBER", 0);

            // Display the received data in TextViews
            TextView messageTextView = findViewById(R.id.messageTextView);
            TextView numberTextView = findViewById(R.id.numberTextView);

            messageTextView.setText("Message: " + message);
            numberTextView.setText("Number: " + number);
        }
    }
}
