package com.kuldeep.javamvvmapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kuldeep.javamvvmapp.R;
import com.kuldeep.javamvvmapp.databinding.CategoryBinding;
import com.kuldeep.javamvvmapp.viewmodel.CategoryViewModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView> {
    private ArrayList<CategoryViewModel> arrayList;
    private LayoutInflater layoutInflater;
    private Context context;

    public  CustomAdapter(Context context, ArrayList<CategoryViewModel> arrayList){
        this.context=context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater= LayoutInflater.from(parent.getContext());
        }
        CategoryBinding categoryBinding = DataBindingUtil.inflate(layoutInflater, R.layout.category_item,parent,false);
        return new CustomView(categoryBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {
        CategoryViewModel categoryViewModel = arrayList.get(position);
        holder.bind(categoryViewModel);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder{
        private CategoryBinding categoryBinding;
        public CustomView(CategoryBinding categoryBinding){
            super(categoryBinding.getRoot());
            this.categoryBinding = categoryBinding;
        }

        public void bind(CategoryViewModel categoryModel)
        {
            this.categoryBinding.setCategoryModel(categoryModel);
            categoryBinding.executePendingBindings();
        }

        public  CategoryBinding getCategoryBinding(){
           return categoryBinding;
        }
    }
}
