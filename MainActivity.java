package com.example.anilkumarsj.frtofr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener,FragmentB.FragmentBListener {

    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_a,fragmentA)
                .replace(R.id.frame_b,fragmentB)
                .commit();

    }


    @Override
    public void onInputSendA(CharSequence input) {
        fragmentB.updateEditTextB(input);
    }

    @Override
    public void onInputSendB(CharSequence input) {
       fragmentA.updateEditTextA(input);
    }
}
