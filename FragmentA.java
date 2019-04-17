package com.example.anilkumarsj.frtofr;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {
    FragmentAListener listener;
    private EditText eta;
    private Button btn_a;

    public interface FragmentAListener {

        void onInputSendA(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_a, container, false);

        eta = v.findViewById(R.id.et_a);
        btn_a = v.findViewById(R.id.btn_a);

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CharSequence input = eta.getText();

                listener.onInputSendA(input);

            }
        });

        return v;


    }

    public void updateEditTextA(CharSequence input) {

        eta.setText(input);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof FragmentAListener) {

            listener = (FragmentAListener) context;
        } else {

            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }
}
