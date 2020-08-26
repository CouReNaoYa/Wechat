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

public class Finding extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.finding,null);
        List<Finding_item>datas = new ArrayList<>();
        datas.add(new Finding_item("朋友圈",R.drawable.pengyouquan,R.drawable.jiantou));
        datas.add(new Finding_item("扫一扫",R.drawable.saoyisao,R.drawable.jiantou));
        datas.add(new Finding_item("摇一摇",R.drawable.yaoyiyao,R.drawable.jiantou));
        datas.add(new Finding_item("看一看",R.drawable.kanyikan,R.drawable.jiantou));
        datas.add(new Finding_item("搜一搜",R.drawable.souyisou,R.drawable.jiantou));
        datas.add(new Finding_item("附近的人",R.drawable.fujinderen,R.drawable.jiantou));
        datas.add(new Finding_item("购物",R.drawable.gouwu,R.drawable.jiantou));
        datas.add(new Finding_item("游戏",R.drawable.youxi,R.drawable.jiantou));
        datas.add(new Finding_item("小程序",R.drawable.xiaochengxu,R.drawable.jiantou));

        recyclerView = view.findViewById(R.id.my_recycler_view);
        GeneralAdapter generalAdapter=new GeneralAdapter(getActivity(),datas);
        recyclerView.setLayoutManager (new LinearLayoutManager(getActivity (),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(generalAdapter);
        return view;
    }

    class Finding_item {
        public String topic_finding;
        public int picture_finding;  //图片的类型为int
        public int arrowhead_finding;

        public Finding_item(String topic_finding,int picture_finding,int arrowhead_finding) {
            this.topic_finding = topic_finding;
            this.picture_finding=picture_finding;
            this.arrowhead_finding=arrowhead_finding;
        }
    }

    class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.MyViewHolder>{
        Context context; //当前上下文对象
        List<Finding_item> datas; //RecyclerView填充Item数据的List对象

        public GeneralAdapter(Context context,List<Finding_item> datas){
            this.context = context;
            this.datas = datas;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //实例化得到Item布局文件的View对象
            View v = View.inflate(context, R.layout.finding_item,null);//R后面的是item的ui
            //返回MyViewHolder的对象
            return new MyViewHolder(v);
        }


        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.topic_finding.setText(datas.get(position).topic_finding);    //前面的是myviewholder中的，后面的是类模板中的
            holder.picture_finding.setImageResource(datas.get (position).picture_finding);
            holder.arrowhead_finding.setImageResource(datas.get (position).arrowhead_finding);
            if(position==1||position==3||position==5||position==6){
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

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView topic_finding;
            ImageView picture_finding;               //图片当控件的时候是imageview，变量的时候是int
            ImageView arrowhead_finding;
            View order;
            public MyViewHolder(View itemView) {
                super(itemView);
                topic_finding = itemView.findViewById(R.id.finding_topic);
                picture_finding=itemView.findViewById(R.id.finding_picture);
                arrowhead_finding=itemView.findViewById(R.id.finding_arrowhead);
                order=itemView.findViewById(R.id.order);


            }
        }


    }
}
