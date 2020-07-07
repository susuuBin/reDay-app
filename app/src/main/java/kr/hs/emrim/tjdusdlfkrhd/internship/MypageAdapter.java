package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.NoCopySpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class MypageAdapter extends RecyclerView.Adapter<MypageAdapter.CustomViewHolder> {
    private ArrayList<Article> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView re_username;
        protected TextView re_text1;
        protected TextView re_text2;
        protected TextView heart;
        protected ImageView re_image;

        public CustomViewHolder(View view){
            super(view);
            this.re_username= (TextView)view.findViewById(R.id.re_username);
            this.re_text1=(TextView)view.findViewById(R.id.re_text1);
            this.re_text2 = (TextView) view.findViewById(R.id.re_text2);
            this.heart = (TextView) view.findViewById(R.id.count_heart);
            this.re_image = (ImageView) view.findViewById(R.id.re_image);

        }
    }

    public MypageAdapter(ArrayList<Article> list){
        this.mList = list;
    } //들어갈 list

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewHolder, int position){

        viewHolder.re_username.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        viewHolder.re_username.setGravity(Gravity.CENTER);
        viewHolder.re_username.setText(mList.get(position).getUserName());

        viewHolder.re_text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        viewHolder.re_text1.setGravity(Gravity.CENTER);
        viewHolder.re_text1.setText(mList.get(position).getTitle());

        viewHolder.re_text2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        viewHolder.re_text2.setGravity(Gravity.CENTER);
        viewHolder.re_text2.setText(mList.get(position).getContents());

        viewHolder.heart.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        viewHolder.heart.setGravity(Gravity.CENTER);
        viewHolder.heart.setText(Integer.toString(mList.get(position).getHeart()));

        // viewHolder.re_image.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        // viewHolder.re_image.setGravity(Gravity.CENTER);
//        viewHolder.re_image.setImageURI(Uri.fromFile(new File(String.valueOf(mList.get(position).getFile()))));
}

    @Override
    public int getItemCount(){
        return (null != mList ? mList.size() : 0);
    }


}