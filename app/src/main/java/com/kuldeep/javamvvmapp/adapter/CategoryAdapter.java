package com.kuldeep.javamvvmapp.adapter;


import android.content.Context;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kuldeep.javamvvmapp.R;
import com.kuldeep.javamvvmapp.databinding.CategoryBinding;
import com.kuldeep.javamvvmapp.viewmodel.CategoryViewModel;

import java.util.List;


/**
 * Author: kuldeepkumar
 * Created on 23/08/20
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private android.content.Context mContext;

    private java.util.List<CategoryViewModel> mDataList;

    private ClickListener clickListener;

    public CategoryAdapter(Context context, List<CategoryViewModel> dataList) {
        this.mContext = context;
        this.mDataList = dataList;
    }


    @Override
    public ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        CategoryBinding binding = DataBindingUtil.inflate(android.view.LayoutInflater.from(mContext),
        R.layout.category_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CategoryViewModel entity = mDataList.get(position);
            if (clickListener != null)
                clickListener.onClick(holder.mBinding.getRoot(), position);


    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CategoryBinding mBinding;

        public ViewHolder(CategoryBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }

    public interface ClickListener {
        void onClick(android.view.View view, int position);
    }

}
