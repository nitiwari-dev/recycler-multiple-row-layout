package com.code2concept.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.code2concept.utils.AppConstant;
import com.code2concept.R;

/**
 * Created by nitesh on 10/14/2015.
 */
public class MultipleRowViewHolder extends RecyclerView.ViewHolder {

    public TextView multipleContent;

    private int type;

    public MultipleRowViewHolder(View itemView, int type) {
        super(itemView);

        if (type == AppConstant.FIRST_ROW){
            multipleContent = (TextView)itemView.findViewById(R.id.row_first_name_tv);
        }else if(type == AppConstant.OTHER_ROW) {
            multipleContent = (TextView)itemView.findViewById(R.id.row_other_name_tv);
        }
    }
}
