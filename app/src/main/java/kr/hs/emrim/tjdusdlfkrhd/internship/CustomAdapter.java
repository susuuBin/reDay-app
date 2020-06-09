package kr.hs.emrim.tjdusdlfkrhd.internship;
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
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<Article> mList;
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView re_username;
        protected TextView re_text1;
        protected TextView re_text2;
        protected TextView count_heart;
        protected ImageView fileLocation;
        public CustomViewHolder(View view){
            super(view);
            this.re_username = view.findViewById(R.id.re_username);
            this.re_text1 = (TextView) view.findViewById(R.id.re_text1);
            this.re_text2 = (TextView) view.findViewById(R.id.re_text2);
            this.count_heart = (TextView)view.findViewById(R.id.count_heart);
            this.fileLocation = (ImageView) view.findViewById(R.id.file_location);
        }
    }
    public CustomAdapter(ArrayList<Article> list){
        this.mList = list;
    }
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
        viewHolder.re_username.setText((CharSequence) mList.get(position).getUser());

        viewHolder.re_text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        viewHolder.re_text1.setGravity(Gravity.CENTER);
        viewHolder.re_text1.setText(mList.get(position).getContents());

        viewHolder.re_text2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        viewHolder.re_text2.setGravity(Gravity.CENTER);
        viewHolder.re_text2.setText(mList.get(position).getTitle());

        viewHolder.count_heart.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        viewHolder.count_heart.setGravity(Gravity.CENTER);
        viewHolder.count_heart.setText(Integer.toString(mList.get(position).getHeart()));

//        viewHolder.fileLocation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
 //       viewHolder.fileLocation.setGravity(Gravity.CENTER);
 //       viewHolder.fileLocation.setText(mList.get(position).getFileLocation()); // 쓸데없는 거임.

    }
    @Override
    public int getItemCount(){
        return (null != mList ? mList.size() : 0);
    }
}