/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phjethva.login.signup.sqlite.database.R;
import com.phjethva.login.signup.sqlite.database.models.User;
import com.phjethva.login.signup.sqlite.database.widget.MyTextView;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {

    private ArrayList<User> user;

    public AdapterUser(ArrayList<User> user) {
        this.user = user;
    }

    @Override
    public AdapterUser.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_adm, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvID.setText("Id:\n"+user.get(position).getId());
        holder.tvUN.setText("Username:\n"+user.get(position).getUn());
        holder.tvEI.setText("Email Id:\n"+user.get(position).getEi());
        holder.tvPW.setText("Password:\n"+user.get(position).getPw());
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private MyTextView tvID, tvUN, tvEI, tvPW;
        public ViewHolder(View itemView) {
            super(itemView);
            tvID = (MyTextView) itemView.findViewById(R.id.row_tv_id);
            tvUN = (MyTextView) itemView.findViewById(R.id.row_tv_un);
            tvEI = (MyTextView) itemView.findViewById(R.id.row_tv_ei);
            tvPW = (MyTextView) itemView.findViewById(R.id.row_tv_pw);
        }
    }

}