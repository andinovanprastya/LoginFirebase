package com.example.andinovanprastya.loginfirebase.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andinovanprastya.loginfirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignoutFragment extends Fragment {

    private FirebaseAuth mAuth;
    private Button mButton;

    private static final String TAG = "EmailPassword";


    private OnFragmentInteractionListener mListener;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = v.getId();
            switch (i){
                case R.id.signOutButton2:
                    signOut();
                    break;
            }
        }
    };

    public SignoutFragment() {
        // Required empty public constructor
    }

    public static SignoutFragment newInstance(String param1, String param2) {
        SignoutFragment fragment = new SignoutFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_signout, container, false);
        mButton = view.findViewById(R.id.signOutButton2);
        mButton.setOnClickListener(mOnClickListener);

        return view;
    }



    private void initView(View view) {
        mButton = view.findViewById(R.id.signOutButton2);
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

//    private void signOut() {
//        mAuth.signOut();
//    }

    private void signOut(){
        if(mAuth != null){
            mAuth.signOut();
        }
    }



//    @Override
//    public void onClick(View v) {
//        int i = v.getId();
//        switch (i){
//            case R.id.signOutButton2:
//                signOut();
//                break;
//        }
//    }


}
