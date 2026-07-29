package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class CheckPhoneSupportBean {
    private int useCompatibleDriver;
    private int tradition = -1;
    private int flashplay = -1;

    @SerializedName("screen_type")
    private int rotation = -1;

    public int getFlashplay() {
        return this.flashplay;
    }

    public int getRotation() {
        return this.rotation;
    }

    public int getTradition() {
        return this.tradition;
    }

    public int getUseCompatibleDriver() {
        return this.useCompatibleDriver;
    }

    public boolean isUseCompatibleDriver() {
        return this.useCompatibleDriver == 1;
    }

    public void setFlashplay(int flashplay) {
        this.flashplay = flashplay;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void setTradition(int tradition) {
        this.tradition = tradition;
    }

    public void setUseCompatibleDriver(int useCompatibleDriver) {
        this.useCompatibleDriver = useCompatibleDriver;
    }

    public String toString() {
        return "CheckPhoneSupportBean{tradition=" + this.tradition + ", flashplay=" + this.flashplay + ", rotation=" + this.rotation + '}';
    }
}
