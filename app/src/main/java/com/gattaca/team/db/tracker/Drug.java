package com.gattaca.team.db.tracker;

import com.gattaca.bitalinoecgchart.tracker.data.ItemType;
import com.gattaca.bitalinoecgchart.tracker.data.TrackerItemContainer;
import com.gattaca.team.R;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by Artem on 12.09.2016.
 */
@RealmClass
public class Drug implements RealmModel, TrackerItemContainer {
    private boolean completed = false;
    private String name;
    private int dose;
    //TODO maybe we must unify doses Enum etc;
    private String units;


    long creationDate;
    private RealmList<Intake> intakes;

    public void setCreationDate(long creationDate){
        this.creationDate = creationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getName() {
        return name;
    }

    public RealmList<Intake> getIntakes() {
        return intakes;
    }

    public int getDose() {
        return dose;
    }

    public String getUnits() {
        return units;
    }

    @Override
    public ItemType getType() {
        return ItemType.DRUG;
    }

    @Override
    public int getIcon() {
        return R.drawable.pills_icon;
    }

    @Override
    public String getBlackText() {
        return getName();
    }

    @Override
    public String getGrayText() {
        return getDose() + " " + getUnits();
    }
}
