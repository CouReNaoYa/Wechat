package com.example.wechat;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

public class Content extends Fragment {
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.content,null);
        List<Content_item>datas = new ArrayList<>();
        datas.add(new Content_item("新的朋友",R.drawable.xindepengyou));
        datas.add(new Content_item("群聊",R.drawable.qunliao));
        datas.add(new Content_item("标签",R.drawable.biaoqian));
        datas.add(new Content_item("公众号",R.drawable.gongzhonghao));
        datas.add(new Content_item("联系人1",R.drawable.lianxirentouxiang));
        datas.add(new Content_item("联系人2",R.drawable.lianxirentouxiang));
        datas.add(new Content_item("联系人3",R.drawable.lianxirentouxiang));
        datas.add(new Content_item("联系人4",R.drawable.lianxirentouxiang));
        datas.add(new Content_item("联系人5",R.drawable.lianxirentouxiang));
        datas.add(new Content_item("联系人6",R.drawable.lianxirentouxiang));
        datas.add(new Content_item("联系人7",R.drawable.lianxirentouxiang));
        datas.add(new Content_item("联系人8",R.drawable.lianxirentouxiang));
        datas.add(new Content_item("联系人9",R.drawable.lianxirentouxiang));


        recyclerView = view.findViewById(R.id.my_recycler_view);
        GeneralAdapter generalAdapter=new GeneralAdapter(getActivity(),datas);
        recyclerView.setLayoutManager (new LinearLayoutManager (getActivity (),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(generalAdapter);
        return view;
    }



    class Content_item {
        public String name_content;
        public int picture_content;  //图片的类型为int

        public Content_item(String name_content,int picture_content) {
            this.name_content = name_content;
            this.picture_content=picture_content;
        }
    }

    class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.MyViewHolder>{
        Context context; //当前上下文对象
        List<Content_item> datas; //RecyclerView填充Item数据的List对象

        public GeneralAdapter(Context context,List<Content_item> datas){
            this.context = context;
            this.datas = datas;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //实例化得到Item布局文件的View对象
            View v = View.inflate(context, R.layout.content_item,null);//R后面的是item的ui
            //返回MyViewHolder的对象
            return new MyViewHolder(v);
        }


        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.name_content.setText(datas.get(position).name_content);    //前面的是myviewholder中的，后面的是类模板中的
            holder.picture_content.setImageResource(datas.get (position).picture_content);
            if(position==4){
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
            TextView name_content;
            ImageView picture_content;               //图片当控件的时候是imageview，变量的时候是int
            View order;

            public MyViewHolder(View itemView) {
                super(itemView);
                name_content = itemView.findViewById(R.id.name_content);
                picture_content=itemView.findViewById(R.id.picture_content);
                order=itemView.findViewById(R.id.order);

            }
        }

    }


}
