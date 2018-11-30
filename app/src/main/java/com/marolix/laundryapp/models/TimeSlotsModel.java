package com.marolix.laundryapp.models;

import java.io.Serializable;

public class TimeSlotsModel implements Serializable {
    private String slotId = "";
    private String slotName = "";
    private String slotTime = "";

    public String getSlotName() {
        return this.slotName;
    }

    public void setSlotName(String str) {
        this.slotName = str;
    }

    public String getSlotTime() {
        return this.slotTime;
    }

    public void setSlotTime(String str) {
        this.slotTime = str;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public void setSlotId(String str) {
        this.slotId = str;
    }
}
