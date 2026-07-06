package com.omarea.model;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class PowerStatRecord {
    public int capacity;
    public boolean charging;
    public long endTime;
    public boolean fuzzy;
    public long io;
    public String packageName;
    public boolean screenOn;
    public long startTime;

    public String toString() {
        return "PowerHistory{io=" + this.io + ", capacity=" + this.capacity + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", screenOn=" + this.screenOn + ", charging=" + this.charging + ", packageName=" + this.packageName + '}';
    }
}
