package com.example.shoppinglist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */

public class BlankFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    List<TextView> tvlist = new ArrayList<>();
    List<CheckBox> cblist = new ArrayList<>();
    static int index = 0;
    private TableLayout table;
    private Fragment2Listner listner;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Override
    public void onClick(View view)
    {
        for (int i = 0; i < index; i++)
        {
            if (view == cblist.get(i))
            {
                if (!cblist.get(i).isChecked()) {
                    tvlist.get(i).setTextColor(Color.BLACK);

                } else {
                    tvlist.get(i).setTextColor(Color.BLUE);

                }
            }
        }
    }


    public interface Fragment2Listner {
        void onInput2Sent(CharSequence input);
    }

    public BlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);

        table = v.findViewById(R.id.table);

        return v;
    }

    public void updateTable(CharSequence newText)
    {
        TableRow tr = null;
        Context context = getContext();
        tr = new TableRow(context);
        TextView tv= new TextView(context);
        tv.setText(newText);
        tv.setBackground(getResources().getDrawable(R.drawable.border, null));
        CheckBox rb = new CheckBox(context);
        rb.setBackground(getResources().getDrawable(R.drawable.border, null));
        rb.setOnClickListener(this);

        tvlist.add(index, tv);
        cblist.add(index, rb);
        tr.addView(tv);
        tr.addView(rb);
        table.addView(tr);

        index++;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment2Listner) {
            listner = (Fragment2Listner) context;
        } else {
            throw new RuntimeException(context.toString() + " must impl Fragment1listner");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listner = null;
    }
}

