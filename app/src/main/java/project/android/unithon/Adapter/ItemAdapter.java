package project.android.unithon.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import project.android.unithon.Holder.ViewHolder;
import project.android.unithon.Model.Item;
import project.android.unithon.R;

/**
 * Created by qkrqh on 2017-07-29.
 */

public class ItemAdapter extends RecyclerView.Adapter<ViewHolder>{

    private Context context;
    private ArrayList<Item> items;
    int item_layout;
    public ViewHolder viewHolder;

    public ItemAdapter(ArrayList<Item> items, Context context, int item_layout) {
        this.items = items;
        this.context = context;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        viewHolder = new ViewHolder(view);

        return viewHolder;

    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){ // 이방법너무비열한거같아요 ㅠㅠ 다른방법찾아볼게요

        final Item item = items.get(position);
        Glide.with(context).load(R.drawable.content_img1).centerCrop() // 메인 사진
                .override(1400,600).into(holder.contentImg);
        holder.likeImg.setImageResource(R.drawable.heart);
        holder.likeCount.setText(item.getLike());
        holder.content.setText(item.getContent());
        holder.timeText.setText(item.getSecond());


        /*
        if(item.getCheck() == true) { // 좋아요 클릭 시 채워진 하트
            Glide.with(context).load(R.drawable.check).centerCrop()
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(holder.checkView);
        }
        else {
            Glide.with(context).load(R.drawable.no_check).centerCrop()
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(holder.checkView);
        }*/


    }

    @Override
    public int getItemCount() {

        return items.size();
    }

}