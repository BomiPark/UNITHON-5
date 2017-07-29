package project.android.unithon.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import project.android.unithon.R;


public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView contentImg, likeImg;
    public TextView likeCount, content, timeText;

    public ViewHolder(View view) {
        super(view);
        contentImg = (ImageView) view.findViewById(R.id.contentImg);
        likeImg = (ImageView) view.findViewById(R.id.likeImg);
        likeCount = (TextView) view.findViewById(R.id.likeCount);
        content = (TextView) view.findViewById(R.id.content);
        timeText = (TextView)view.findViewById(R.id.time);
    }
}