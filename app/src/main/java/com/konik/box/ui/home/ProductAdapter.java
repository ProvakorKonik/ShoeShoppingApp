package com.konik.box.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.konik.box.Model.ProductModel;
import com.konik.box.R;
import com.konik.box.RecylerviewClickInterface;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductAdapter_Holder> {
    private Context mContext;
    private List<ProductModel> mData;
    private RecylerviewClickInterface recylerviewClickInterface;
    
    public ProductAdapter(Context mContext, List<ProductModel> mData, RecylerviewClickInterface recylerviewClickInterface) {
        this.mContext = mContext;
        this.mData = mData;
        this.recylerviewClickInterface = recylerviewClickInterface;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductAdapter_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_product,parent,false); //connecting to cardview
        return new ProductAdapter.ProductAdapter_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductAdapter_Holder holder, int position) {
        String dPhotoURL = mData.get(position).getProductPhotoUrl();
        Picasso.get().load(dPhotoURL).fit().centerCrop().into(holder.mItemImageView);
        String dsTitle = mData.get(position).getProductName();
        //String dsBio = mData.get(position).getProductBio();
        int diViews = 1234;
        String dsBio = mData.get(position).getProductBio();
        holder.mItemTitleText.setText(dsTitle);
        holder.mItemBioText.setText(dsBio);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ProductAdapter_Holder extends RecyclerView.ViewHolder {

        ImageView mItemImageView;
        TextView mItemTitleText;
        TextView mItemBioText;


        public ProductAdapter_Holder(@NonNull View itemView) {
            super(itemView);

            mItemImageView = (ImageView) itemView.findViewById(R.id.item_product_imagecard);
            mItemTitleText = (TextView)itemView.findViewById(R.id.item_product_title);
            mItemBioText = (TextView)itemView.findViewById(R.id.item_product_bio);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recylerviewClickInterface .onProductItemClick(getAdapterPosition());
                }
            });

        }
    }



}
