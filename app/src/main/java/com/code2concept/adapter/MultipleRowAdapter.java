package com.code2concept.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code2concept.utils.AppConstant;
import com.code2concept.R;
import com.code2concept.model.MultipleRowModel;
import com.code2concept.viewHolder.MultipleRowViewHolder;

import java.util.List;

public class MultipleRowAdapter extends RecyclerView.Adapter<MultipleRowViewHolder> {

    private LayoutInflater inflater = null;
    private List<MultipleRowModel> multipleRowModelList;

    public MultipleRowAdapter(Context context, List<MultipleRowModel> multipleRowModelList){
        this.multipleRowModelList = multipleRowModelList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MultipleRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        if (viewType == AppConstant.FIRST_ROW)
            view = inflater.inflate(R.layout.view_row_first, parent, false);
        else if (viewType == AppConstant.OTHER_ROW)
            view = inflater.inflate(R.layout.view_row_other, parent, false);

        return new MultipleRowViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(MultipleRowViewHolder holder, int position) {
        holder.multipleContent.setText(multipleRowModelList.get(position).modelContent);
    }

    @Override
    public int getItemCount() {
        return (multipleRowModelList != null && multipleRowModelList.size() > 0 ) ? multipleRowModelList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {

        MultipleRowModel multipleRowModel = multipleRowModelList.get(position);

        if (multipleRowModel != null)
            return multipleRowModel.type;

        return super.getItemViewType(position);
    }
}
