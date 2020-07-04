package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private ArrayList<Countries> mList;

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        protected TextView country_id;

        public HomeViewHolder(View view){
            super(view);
            country_id = itemView.findViewById(R.id.country_id);
        }
    }

    public HomeAdapter(ArrayList<Countries> list){
        this.mList = list;
    } //들어갈 list

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        HomeViewHolder viewHolder = new HomeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder viewHolder, int position) {
        viewHolder.country_id.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        viewHolder.country_id.setGravity(Gravity.CENTER);
        viewHolder.country_id.setText(Integer.toString(mList.get(position).getId()));
    }

    @Override
    public int getItemCount(){
        return (null != mList ? mList.size() : 0);
    }
}