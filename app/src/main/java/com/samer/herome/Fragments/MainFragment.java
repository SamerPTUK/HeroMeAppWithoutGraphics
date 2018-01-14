package com.samer.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.LinearLayout;

import com.samer.herome.Activities.MainActivity;
import com.samer.herome.R;
import com.samer.herome.draw.DrawMainFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */



public class MainFragment extends Fragment implements  View.OnClickListener{



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MainFragmentInteractionListener mListener;


    Button cameByAccidentBtn, geneticMutationBtn, bornWithThemBtn, choocePowersBtn;




    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters


    public static MainFragment newInstance(String param1, String param2) {

        MainFragment fragment = new MainFragment();
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

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        LinearLayout mainF_LL= view.findViewById(R.id.mainF_LL);
        cameByAccidentBtn = view.findViewById(R.id.cameByAccidentBtn);
        geneticMutationBtn = view.findViewById(R.id.geneticMutationBtn);
        bornWithThemBtn = view.findViewById(R.id.bornWithThemBtn);
        choocePowersBtn = view.findViewById(R.id.choocePowersBtn);

        choocePowersBtn.setEnabled(false);
        choocePowersBtn.getBackground().setAlpha(128);

        cameByAccidentBtn.setOnClickListener(this);
        geneticMutationBtn.setOnClickListener(this);
        bornWithThemBtn.setOnClickListener(this);


        choocePowersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadPickPowerScreen();
            }
        });



        MainActivity mainActivity = (MainActivity)getActivity();

        Bitmap bitmap = Bitmap.createBitmap(
                mainActivity.screenWidth,
                mainActivity.screenHeight,
                 Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.rgb(255, 153, 51));
        paint.setStrokeWidth(10);
        int startx = 50;
        int starty = 90;
        int endx = 150;
        int endy = 360;
        canvas.drawLine(startx, starty, endx, endy, paint);


        DrawMainFragment drawMainFragment = new DrawMainFragment(mainActivity.getApplicationContext());



        return view;
    }




    @Override
    public void onClick(View v) {
        choocePowersBtn.setEnabled(true);
        choocePowersBtn.getBackground().setAlpha(255);

        Button btn = (Button)v;
        int leftDrawable = 0;

        cameByAccidentBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning_icon, 0, 0, 0);
        geneticMutationBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic_icon, 0, 0, 0);
        bornWithThemBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket_icon, 0, 0, 0);

        if(btn == cameByAccidentBtn) {
            leftDrawable = R.drawable.lightning_icon;
        } else if (btn == geneticMutationBtn) {
            leftDrawable = R.drawable.atomic_icon;
        } else if(btn == bornWithThemBtn) {
            leftDrawable = R.drawable.rocket_icon;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.item_selected_btn, 0);
    }





    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);
    }
}
