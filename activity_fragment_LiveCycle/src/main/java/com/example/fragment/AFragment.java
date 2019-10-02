package com.example.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author:Created by WangZhiQiang on 2018/8/29.
 * listview 点击打开新的activity;
 */
public class AFragment extends Fragment{



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("wzq-Fragment","---------------onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("wzq-Fragment","---------------onCreate");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("wzq-Fragment","---------------onCreateView");
        View view = View.inflate(getActivity(), R.layout.fragmnet01, null);
            view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().startActivity(new Intent(getActivity(),Main2Activity.class));
                }
            });
        return view ;


    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("wzq-Fragment","---------------onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e("wzq-Fragment","---------------onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e("wzq-Fragment","---------------onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("wzq-Fragment","---------------onPause");
        super.onPause();
    }


    @Override
    public void onStop() {
        Log.e("wzq-Fragment","---------------onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("wzq-Fragment","---------------onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("wzq-Fragment","---------------onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("wzq-Fragment","---------------onDetach");
        super.onDetach();
    }
}
