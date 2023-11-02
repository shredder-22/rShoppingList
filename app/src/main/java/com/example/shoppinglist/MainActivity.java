package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.Fragment2Listner, Fragment1.Fragment1Listner {

    private FragmentContainerView fragmentContainerView;
    private Fragment1 fragment1;
    private BlankFragment fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new BlankFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.f1,fragment1).replace(R.id.f2,fragment2).commit();
        Button infobtn;
        infobtn = findViewById(R.id.info);
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onInput2Sent(CharSequence input) {
        //fragment1.updateEditText();
    }


    @Override
    public void onInput1Sent(CharSequence input) {
        fragment2.updateTable(input);

    }
}