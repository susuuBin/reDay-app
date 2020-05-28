package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MypageAdapter extends RecyclerView.Adapter<MypageAdapter.MypageViewHolder> {

    private ArrayList<MypageData> arrayList;

    public MypageAdapter(ArrayList<MypageData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MypageAdapter.MypageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        MypageViewHolder holder = new MypageViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MypageAdapter.MypageViewHolder holder, int position) {
        holder.re_image1.setImageResource(arrayList.get(position).getRe_image1());
        holder.re_username.setText(arrayList.get(position).getRe_username());
        holder.re_text1.setText(arrayList.get(position).getRe_text1());
        holder.re_text2.setText(arrayList.get(position).getRe_text2());
        holder.re_image2.setImageResource(arrayList.get(position).getRe_image2());



    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class MypageViewHolder extends RecyclerView.ViewHolder {

        protected ImageView re_image1;
        protected TextView re_username;
        protected TextView re_text1;
        protected TextView re_text2;
        protected ImageView re_image2;


        public MypageViewHolder(@NonNull View itemView) {
            super(itemView);

            this.re_image1 = (ImageView)itemView.findViewById(R.id.mypage_profileimg);
            this.re_username = (TextView)itemView.findViewById(R.id.re_username);
            this.re_text1 = (TextView)itemView.findViewById(R.id.re_text1);
            this.re_text2 = (TextView)itemView.findViewById(R.id.re_text2);
            this.re_image2 = (ImageView) itemView.findViewById(R.id.re_image);
        }
    }
}
