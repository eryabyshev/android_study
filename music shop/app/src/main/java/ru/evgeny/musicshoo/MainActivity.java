package ru.evgeny.musicshoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Spinner spinner;
    private int counter = 0;
    private Button minusButton;
    private TextView nameEditText;
    private TextView priceText;
    private ArrayAdapter<String> adapter;
    private static Map<String, Integer> itemPrice = new HashMap<>();
    private ImageView itemImage;

    private static final String DRUMS = "drums";
    private static final String GUITAR = "guitar";
    private static final String PIANO = "piano";


    private static List<String> spinnerArray = new ArrayList<>();

    static {

        spinnerArray.add(DRUMS);
        spinnerArray.add(GUITAR);
        spinnerArray.add(PIANO);

        itemPrice.put(DRUMS, 100);
        itemPrice.put(GUITAR, 200);
        itemPrice.put(PIANO, 300);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner();
        nameEditText = findViewById(R.id.display_quantity);
        nameEditText.setText("0");
        minusButton = findViewById(R.id.minus_button);
        disableMinusButtonIfNeed();
        priceText = findViewById(R.id.price_text_view);
        itemImage = findViewById(R.id.item_image);

    }

    private void createSpinner() {
        spinner = findViewById(R.id.my_spinner);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void minusButtonAction(View view) {
        counter--;
        updateTextCounter();
    }

    public void plusButton(View view) {
        counter++;
        updateTextCounter();
    }

    private void disableMinusButtonIfNeed() {
        if (counter == 0) {
            minusButton.setEnabled(false);
        } else {
            minusButton.setEnabled(true);
        }
    }

    private void updateTextCounter() {
        nameEditText.setText(counter + "");
        disableMinusButtonIfNeed();
        onItemSelected();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        onItemSelected();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void onItemSelected() {
        String item = spinner.getSelectedItem().toString();
        int price = itemPrice.get(item);
        priceText.setText((counter * price) + "");

        switch (item) {
            case DRUMS:
                itemImage.setImageResource(R.drawable.drum);
                break;
            case GUITAR:
                itemImage.setImageResource(R.drawable.guitar);
                break;
            case PIANO:
                itemImage.setImageResource(R.drawable.piano);
                break;
            default:
                itemImage.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    public void addToCart(View view) {
        TextView name = findViewById(R.id.name_edit_text);
        String item = spinner.getSelectedItem().toString();
        int price = itemPrice.get(item);
        Order order = new Order(name.getText().toString(), item, counter, counter * price, price);
        Intent orderIntent = new Intent(this, OrderActivity.class);
        orderIntent.putExtra("CART", order);

        startActivity(orderIntent);
    }
}
