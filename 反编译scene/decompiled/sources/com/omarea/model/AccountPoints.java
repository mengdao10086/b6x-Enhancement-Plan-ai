package com.omarea.model;

import a.f92;
import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class AccountPoints implements Serializable {
    public String device_id;
    public int integral;
    public String remark = "";
    public String serial_id;
    public String serial_no;
    public long time;

    public final String getDevice_id() {
        return this.device_id;
    }

    public final int getIntegral() {
        return this.integral;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getSerial_id() {
        return this.serial_id;
    }

    public final String getSerial_no() {
        return this.serial_no;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setDevice_id(String str) {
        this.device_id = str;
    }

    public final void setIntegral(int i) {
        this.integral = i;
    }

    public final void setRemark(String str) {
        f92.d(str, "<set-?>");
        this.remark = str;
    }

    public final void setSerial_id(String str) {
        this.serial_id = str;
    }

    public final void setSerial_no(String str) {
        this.serial_no = str;
    }

    public final void setTime(long j) {
        this.time = j;
    }
}
