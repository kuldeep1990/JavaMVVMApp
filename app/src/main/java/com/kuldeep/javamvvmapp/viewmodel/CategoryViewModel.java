package com.kuldeep.javamvvmapp.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kuldeep.javamvvmapp.R;
import com.kuldeep.javamvvmapp.model.CategoryModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryViewModel extends ViewModel {
    public String id;
    public String title;
    public String imagePath;

    private ArrayList<CategoryViewModel> arrayList ;
    public MutableLiveData<ArrayList<CategoryViewModel>> categoryLivedata= new MutableLiveData<>();

    private CategoryViewModel(CategoryModel model){
        this.id=model.getId();
        this.title=model.getTitle();
        this.imagePath =model.getImagePath();
    }

    public String getImageUrl(){
        return imagePath;
    }

    @BindingAdapter({"bind:imageUrl"})
    public  static void loadImge(ImageView imageView,String imageUrl){
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(R.drawable.ic_app_logo).into(imageView);
    }

    public MutableLiveData<ArrayList<CategoryViewModel>> getCategoryLivedata() {
        arrayList=new ArrayList<>();
        arrayList.add(new CategoryViewModel(new CategoryModel("1","image1","image1")));
        categoryLivedata.setValue(arrayList);
        return categoryLivedata;
    }
}
