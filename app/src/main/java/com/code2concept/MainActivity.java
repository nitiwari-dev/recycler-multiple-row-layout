package com.code2concept;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.code2concept.adapter.MultipleRowAdapter;
import com.code2concept.model.MultipleRowModel;
import com.code2concept.utils.AppConstant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView multipleRowRecyclerView;
    private MultipleRowAdapter multipleRowAdapter;

    private List<MultipleRowModel> multipleRowModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multipleRowRecyclerView = (RecyclerView)findViewById(R.id.multipleRowRecyclerView);
        multipleRowRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        multipleRowRecyclerView.setLayoutManager(linearLayoutManager);
        multipleRowRecyclerView.setItemAnimator(new DefaultItemAnimator());

        fillAdapter();

        multipleRowAdapter = new MultipleRowAdapter(MainActivity.this, multipleRowModelList);

        multipleRowRecyclerView.setAdapter(multipleRowAdapter);
    }

    private void fillAdapter() {

        int type;

        String content;

        for (int i = 0; i < 10; i++) {

            if (i == 0 || i == 5 || i == 9) {
                type = AppConstant.FIRST_ROW;
                content = "Type 1: This is Multiple row layout";
            } else {
                type = AppConstant.OTHER_ROW;
                content = "Type 2";
            }

            multipleRowModelList.add(new MultipleRowModel(type , content));
        }
    }
}
