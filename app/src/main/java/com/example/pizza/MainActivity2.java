package com.example.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizza.classe.Produit;
import com.example.pizza.service.ProduitService;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
        private ImageView photoImageView;
        private TextView nomTextView;
        private TextView descriptionTextView;
        private TextView ingredientsTextView;
        private TextView preparationTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            // Initialize views
            photoImageView = findViewById(R.id.photo);
            nomTextView = findViewById(R.id.nom);
            descriptionTextView = findViewById(R.id.description);
            ingredientsTextView = findViewById(R.id.ingredients);
            preparationTextView = findViewById(R.id.preparation);

            // Receive the ID from MainActivity
            Intent intent = getIntent();
            if (intent != null) {
                int id = intent.getIntExtra("id", -1);

                List<Produit> listePizza = (List<Produit>) intent.getSerializableExtra("listePizza");

                // Fetch the "Produit" object based on the ID
                if (id != -1 && listePizza != null) {
                    // Fetch the "Produit" object based on the ID
                    ProduitService produitService = new ProduitService(listePizza);
                    Produit produit = produitService.findById(id);
   
                    photoImageView.setImageResource(produit.getPhoto());
                    nomTextView.setText(produit.getNom());
                    descriptionTextView.setText(produit.getDescription());
                    ingredientsTextView.setText(produit.getDetaisIngred());
                    preparationTextView.setText(produit.getPreparation());
                    
                }

            }
        }
    @Override
    public void onBackPressed() {
        super.onBackPressed(); // This will execute the default back button behavior
        // Start MainActivity when the back button is pressed
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


