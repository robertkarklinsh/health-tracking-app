package com.gattaca.team.db.tracker;

import com.gattaca.team.ui.tracker.data.ItemType;
import com.gattaca.team.ui.tracker.data.TrackerItemContainer;
import com.gattaca.team.R;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Artem on 12.09.2016.
 */

@RealmClass
public class PulseMeasurement implements RealmModel, TrackerItemContainer{
    private boolean completed = false;
    private String name ;
    private int duration;
    private String units;

    @PrimaryKey
    private long primaryKey;
    public long getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getUnits() {
        return units;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public ItemType getType() {
        return ItemType.PRESSURE_MEASUREMENT;
    }

    @Override
    public int getIcon() {
        return R.drawable.cardiogram_icon;
    }

    @Override
    public String getBlackText() {
        return name;
    }

    @Override
    public String getGrayText() {
        return duration + " " + units;
    }
}