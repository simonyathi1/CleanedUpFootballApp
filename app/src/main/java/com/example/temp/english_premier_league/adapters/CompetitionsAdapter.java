package com.example.temp.english_premier_league.adapters;

import android.app.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.temp.english_premier_league.R;
import com.example.temp.english_premier_league.model.Competition;

import java.util.ArrayList;

/**
 * Created by temp on 05/09/2017.
 */

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.CompetitionHolder> {

    public interface OnItemClickedListener {
        void onItemClick(Competition item);
    }

    private final OnItemClickedListener listener;
    private ArrayList<Competition> competitionData;
    private Activity activity;

    public CompetitionsAdapter( ArrayList<Competition> competitionData, Activity a, OnItemClickedListener listener) {
        this.listener = listener;
        this.competitionData = competitionData;
    }

    @Override
    public CompetitionsAdapter.CompetitionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.competition_item,parent,false);

        return new CompetitionHolder(view);
    }

    @Override
    public void onBindViewHolder(CompetitionsAdapter.CompetitionHolder holder, int position) {
        if(position < competitionData.size())
            holder.bind(competitionData.get(position),listener);
    }

    @Override
    public int getItemCount() {
        if(competitionData == null) {
            return 0;
        }else
            return competitionData.size();
    }

    class CompetitionHolder extends RecyclerView.ViewHolder{
        TextView competitionTextView;

        CompetitionHolder(View itemView) {
            super(itemView);
            competitionTextView = itemView.findViewById(R.id.competition_item_name);
        }

        //new binder method to bind data to the view
        void bind(final Competition item, final CompetitionsAdapter.OnItemClickedListener listener) {
            competitionTextView.setText(item.getLeague());
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
