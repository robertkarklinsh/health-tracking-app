package com.gattaca.team.db.sensor.optimizing;


import com.gattaca.team.annotation.GraphPeriod;

import io.realm.RealmModel;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class BpmPoint_1_hour implements RealmModel, BpmOptimizing.IBpmOptimizing {
    @PrimaryKey
    private long time;
    private float value;
    private int channel = 0;
    @Ignore
    private BpmOptimizing optimizing = new BpmOptimizing(this, GraphPeriod.period_1hour);

    public long getTime() {
        return time;
    }

    @Override
    public void setTime(long time) {
        this.time = time;
    }

    public float getValue() {
        return value;
    }

    @Override
    public void setValue(float value) {
        this.value = value;
    }

    public int getChannel() {
        return channel;
    }

    public BpmPoint_1_hour setChannel(int channel) {
        this.channel = channel;
        return this;
    }

    @Override
    public boolean addPoint(long globalTimeStump, double time, float value) {
        return optimizing.addPoint(globalTimeStump, time, value);
    }

    @Override
    public void collapsePoints() {
        optimizing.collapsePoints();
    }
}
