package com.example.rakib.asynchttp.adapter;

import android.view.View;

import java.util.List;

public interface T_ItemClickListener {

    List<?> onClick(View view, int position, boolean isLongClick);
}
