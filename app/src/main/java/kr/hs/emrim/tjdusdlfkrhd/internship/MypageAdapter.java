package kr.hs.emrim.tjdusdlfkrhd.internship;
import android.content.Intent;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
public class MypageAdapter extends RecyclerView.Adapter<MypageAdapter.MypageViewHolder> {
    private ArrayList<User> mUser;

    public class MypageViewHolder extends RecyclerView.ViewHolder {
        protected TextView username;
        protected TextView useremail;

        public MypageViewHolder(View view){
            super(view);
            this.username = (TextView) view.findViewById(R.id.username);
            this.useremail = (TextView) view.findViewById(R.id.useremail);
        }
    }

    public MypageAdapter(ArrayList<User> user){
        this.mUser = user;
    }

    @Override
    public MypageViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_mypage, viewGroup, false);
        MypageViewHolder viewHolder = new MypageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MypageViewHolder viewHolder, int position) {

        viewHolder.username.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        viewHolder.username.setGravity(Gravity.CENTER);
        viewHolder.username.setText(mUser.get(position).getUserNickname());

        viewHolder.useremail.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        viewHolder.useremail.setGravity(Gravity.CENTER);
        viewHolder.useremail.setText(mUser.get(position).getEmail());

    }

    @Override
    public int getItemCount(){
        return (null != mUser ? mUser.size() : 0);
    }
}