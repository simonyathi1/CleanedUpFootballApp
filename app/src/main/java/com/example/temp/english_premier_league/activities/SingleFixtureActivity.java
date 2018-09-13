package com.example.temp.english_premier_league.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.temp.english_premier_league.R;

import java.util.ArrayList;

import static com.example.temp.english_premier_league.Controller.displayImage;
import static com.example.temp.english_premier_league.Controller.splitter;

public class SingleFixtureActivity extends AppCompatActivity {

    private ImageView homeTeamCrestImageView;
    private ImageView awayTeamCrestImageView;
    private TextView homeTeamNameTextView;
    private TextView awayTeamNameTextView;
    private TextView homeScoreTextView;
    private TextView awayScoreTextView;
    private TextView competitionNameTextView;
    private TextView matchDateTextView;
    private TextView halfTimeHomeScore;
    private TextView halfTimeAway;
    private TextView matchDay;
    private TextView odds;
    private TextView matchTime;
    private ArrayList dateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fixture);
        dateTime = splitter(getIntent().getStringExtra("matchDate"));

        homeTeamCrestImageView = findViewById(R.id.home_team_crest);
        awayTeamCrestImageView = findViewById(R.id.away_team_crest);
        homeTeamNameTextView = findViewById(R.id.home_team_name);
        awayTeamNameTextView = findViewById(R.id.away_team_name);
        homeScoreTextView = findViewById(R.id.home_team_score);
        awayScoreTextView = findViewById(R.id.away_team_score);
        competitionNameTextView = findViewById(R.id.competition_id_BIG);
        matchDateTextView = findViewById(R.id.match_date);
        matchTime = findViewById(R.id.match_date_time);
        halfTimeHomeScore = findViewById(R.id.half_home_team_score);
        halfTimeAway = findViewById(R.id.half_away_team_score);
        matchDay = findViewById(R.id.match_day);
        odds = findViewById(R.id.odds);
        actionBarSetup(getIntent().getStringExtra("matchTitle"), (String) dateTime.get(0));

        homeTeamNameTextView.setText(getIntent().getStringExtra("homeTeamName"));
        awayTeamNameTextView.setText(getIntent().getStringExtra("awayTeamName"));

        if (getIntent().getStringArrayExtra("fullTime").equals("null")) {
            homeScoreTextView.setText("__");
        } else {
            homeScoreTextView.setText(getIntent().getStringArrayExtra("fullTime")[0]);
        }

        if (getIntent().getStringArrayExtra("fullTime").equals("null")) {
            homeScoreTextView.setText("__");
        } else {
            awayScoreTextView.setText(getIntent().getStringArrayExtra("fullTime")[1]);
        }

        competitionNameTextView.setText(getIntent().getStringExtra("competitionName"));
        matchDateTextView.setText((String) dateTime.get(0));
        matchTime.setText((String) dateTime.get(1));

        halfTimeHomeScore.setText(getIntent().getStringArrayExtra("halfTime")[0]);
        halfTimeAway.setText(getIntent().getStringArrayExtra("halfTime")[1]);
        matchDay.setText(String.format("Match Day %s", getIntent().getStringExtra("matchday")));

        if (getIntent().getStringExtra("odds").equals("null")) {
            odds.setText("");

        } else {
            odds.setText(String.format("Odds: %s", getIntent().getStringExtra("odds")));
        }

        displayImage(getIntent().getStringExtra("homeCrest"), homeTeamCrestImageView, this);

        displayImage(getIntent().getStringExtra("awayCrest"), awayTeamCrestImageView, this);
    }

    private void actionBarSetup(String title, String subtitle) {
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
            ab.setSubtitle(subtitle);
        }
    }
}
