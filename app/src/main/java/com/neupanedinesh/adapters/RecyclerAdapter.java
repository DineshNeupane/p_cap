package com.neupanedinesh.adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.neupanedinesh.photocaptions.R;
import com.neupanedinesh.models.CardItemModel;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private Context context;


    public List<CardItemModel> cardItems;

    public RecyclerAdapter(List<CardItemModel> cardItems){
        this.cardItems = cardItems;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView copyButton;
        ImageView shareButton;


        TextView title;
        TextView content;
        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView)itemView.findViewById(R.id.card_title);
            this.content = (TextView)itemView.findViewById(R.id.card_content);
            this.copyButton= (ImageView) itemView.findViewById(R.id.copyButton);
            this.shareButton=(ImageView) itemView.findViewById(R.id.shareButton);




        }
    }







    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.title.setText(cardItems.get(position).title);
        holder.content.setText(cardItems.get(position).content);

        holder.copyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                myClipboard = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);


                myClip = ClipData.newPlainText("label", holder.content.getText().toString());
                myClipboard.setPrimaryClip(myClip);
                Toast.makeText(v.getContext(), "Copied to clipboard" , Toast.LENGTH_SHORT ).show();

            }
        });
        holder.shareButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, holder.content.getText().toString());
                v.getContext().startActivity(Intent.createChooser(share, "Share Text"));
            }
        });


    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }




}
