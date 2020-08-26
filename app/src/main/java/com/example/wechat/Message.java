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

public class Message extends Fragment {
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.message,null);
        List<Message_item>datas = new ArrayList<>();
        datas.add(new Message_item("联系人1","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人2","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人3","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人4","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人5","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人6","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人7","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人8","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人9","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人10","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人11","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人12","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人13","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));
        datas.add(new Message_item("联系人14","吃饭了吗？","10:00",R.drawable.lianxirentouxiang));



        recyclerView = view.findViewById(R.id.my_recycler_view);
        GeneralAdapter generalAdapter=new GeneralAdapter(getActivity(),datas);
        recyclerView.setLayoutManager (new LinearLayoutManager(getActivity (),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(generalAdapter);
        return view;
    }


    class Message_item {
        public String name_message;
        public String text_message;
        public String time_message;
        public int picture_message;  //图片的类型为int

        public Message_item(String name_message,String text_message,String time_message,int picture_message) {
            this.name_message = name_message;
            this.text_message = text_message;
            this.time_message = time_message;
            this.picture_message=picture_message;
        }
    }

    class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.MyViewHolder>{
        Context context; //当前上下文对象
        List<Message_item> datas; //RecyclerView填充Item数据的List对象

        public GeneralAdapter(Context context,List<Message_item> datas){
            this.context = context;
            this.datas = datas;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //实例化得到Item布局文件的View对象
            View v = View.inflate(context, R.layout.message_item,null);//R后面的是item的ui
            //返回MyViewHolder的对象
            return new MyViewHolder(v);
        }


        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.name_message.setText(datas.get(position).name_message);    //前面的是myviewholder中的，后面的是类模板中的
            holder.text_message.setText(datas.get(position).text_message);
            holder.time_message.setText(datas.get(position).time_message);
            holder.picture_message.setImageResource(datas.get(position).picture_message);

        }
        @Override
        public int getItemCount() {
            return datas.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView name_message;
            TextView text_message;
            TextView time_message;
            ImageView picture_message;                                                              //图片当控件的时候是imageview，变量的时候是int

            public MyViewHolder(View itemView) {
                super(itemView);
                name_message = itemView.findViewById(R.id.message_name);
                text_message = itemView.findViewById(R.id.message_text);
                time_message = itemView.findViewById(R.id.message_time);
                picture_message=itemView.findViewById(R.id.message_picture);

            }
        }

    }
}
