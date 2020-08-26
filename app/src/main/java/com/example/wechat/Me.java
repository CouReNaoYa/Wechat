package com.example.wechat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Me extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.me,null);
        List<Me_item>datas = new ArrayList<>();
        datas.add(new Me_item("支付",R.drawable.zhifu,R.drawable.jiantou));
        datas.add(new Me_item("收藏",R.drawable.shoucang,R.drawable.jiantou));
        datas.add(new Me_item("相册",R.drawable.xiangce,R.drawable.jiantou));
        datas.add(new Me_item("卡包",R.drawable.kabao,R.drawable.jiantou));
        datas.add(new Me_item("表情",R.drawable.biaoqing,R.drawable.jiantou));
        datas.add(new Me_item("设置",R.drawable.shezhi,R.drawable.jiantou));

        recyclerView = view.findViewById(R.id.my_recycler_view);
        GeneralAdapter generalAdapter=new GeneralAdapter(getActivity(),datas);
        recyclerView.setLayoutManager (new LinearLayoutManager(getActivity (),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(generalAdapter);
        return view;
    }


    class Me_item {
        public String topic_me;
        public int picture_me;  //图片的类型为int
        public int arrowhead_me;

        public Me_item(String topic_me,int picture_me,int arrowhead_me) {
            this.topic_me = topic_me;
            this.picture_me=picture_me;
            this.arrowhead_me=arrowhead_me;
        }
    }
    class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.MyViewHolder> {
        Context context; //当前上下文对象
        List<Me_item> datas; //RecyclerView填充Item数据的List对象

        public GeneralAdapter(Context context, List<Me_item> datas) {
            this.context = context;
            this.datas = datas;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //实例化得到Item布局文件的View对象
            View v = View.inflate(context, R.layout.me_item, null);//R后面的是item的ui
            //返回MyViewHolder的对象
            return new MyViewHolder(v);
        }


        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.topic_me.setText(datas.get(position).topic_me);    //前面的是myviewholder中的，后面的是类模板中的
            holder.picture_me.setImageResource(datas.get(position).picture_me);
            holder.arrowhead_me.setImageResource(datas.get(position).arrowhead_me);
            if(position==0||position==1||position==5){
                holder.order.setVisibility(View.VISIBLE);
            }
            else {
                holder.order.setVisibility(View.GONE);
            }

        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView topic_me;
            ImageView picture_me;               //图片当控件的时候是imageview，变量的时候是int
            ImageView arrowhead_me;
            View order;

            public MyViewHolder(View itemView) {
                super(itemView);
                topic_me = itemView.findViewById(R.id.me_topic);
                picture_me = itemView.findViewById(R.id.me_picture);
                arrowhead_me = itemView.findViewById(R.id.me_arrowhead);
                order=itemView.findViewById(R.id.order);

            }
        }

    }
}
