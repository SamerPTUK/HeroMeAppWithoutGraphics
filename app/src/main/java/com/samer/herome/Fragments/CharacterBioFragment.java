package com.samer.herome.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.samer.herome.Activities.MainActivity;
import com.samer.herome.R;
import com.samer.herome.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterBioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class CharacterBioFragment extends Fragment {




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CharacterBioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterBioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterBioFragment newInstance(String param1, String param2) {
        CharacterBioFragment fragment = new CharacterBioFragment();
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
        View view = inflater.inflate(R.layout.fragment_character_bio, container, false);

        Button startOverBtn = view.findViewById(R.id.startOverBtn);
        Button primaryPowerBtn = view.findViewById(R.id.primaryPowerBtn);
        Button secondaryPowerBtn = view.findViewById(R.id.secondaryPowerBtn);

        TextView titleTxt = view.findViewById(R.id.titleTxt);

        Bundle bundle = this.getArguments();


        if(bundle != null) {
            int id = bundle.getInt(MainActivity.ID);

            String[] titles = DataService.getInstance().getTitles(id);
            int[] resources = DataService.getInstance().getResources(id);

            primaryPowerBtn.setText(titles[0].toUpperCase());
            primaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(resources[0], 0, 0, 0);

            secondaryPowerBtn.setText(titles[1].toUpperCase());
            secondaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(resources[1], 0, 0, 0);

            if (id == 1 || id == 5) {
                titleTxt.setText("NINJA");
            }else if(id == 2 || id == 6) {
                titleTxt.setText("SUPERMAN");
            } else if (id == 3 || id == 4) {
                titleTxt.setText("BATMAN");
            }

        }


        startOverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.returnToMain();
            }
        });

        return view;
    }





}



