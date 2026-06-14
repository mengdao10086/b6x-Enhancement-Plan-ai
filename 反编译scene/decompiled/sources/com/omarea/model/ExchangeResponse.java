package com.omarea.model;

import a.f92;
import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ExchangeResponse implements Serializable {
    public boolean activated;
    public boolean exchanged;
    public boolean found;
    public int number;
    public int used;
    public String devices = "";
    public String error = "";
    public String deviceCode = "";
    public String sign = "";
    public String detail = "";

    public final boolean getActivated() {
        return this.activated;
    }

    public final String getCodeStr() {
        if (!(this.deviceCode.length() > 0)) {
            return "";
        }
        if (!(this.sign.length() > 0)) {
            return "";
        }
        return this.deviceCode + '|' + this.sign;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getDeviceCode() {
        return this.deviceCode;
    }

    public final String getDevices() {
        return this.devices;
    }

    public final String getError() {
        return this.error;
    }

    public final boolean getExchanged() {
        return this.exchanged;
    }

    public final boolean getFound() {
        return this.found;
    }

    public final int getNumber() {
        return this.number;
    }

    public final String getSign() {
        return this.sign;
    }

    public final int getUsed() {
        return this.used;
    }

    public final void setActivated(boolean z) {
        this.activated = z;
    }

    public final void setDetail(String str) {
        f92.d(str, "<set-?>");
        this.detail = str;
    }

    public final void setDeviceCode(String str) {
        f92.d(str, "<set-?>");
        this.deviceCode = str;
    }

    public final void setDevices(String str) {
        f92.d(str, "<set-?>");
        this.devices = str;
    }

    public final void setError(String str) {
        f92.d(str, "<set-?>");
        this.error = str;
    }

    public final void setExchanged(boolean z) {
        this.exchanged = z;
    }

    public final void setFound(boolean z) {
        this.found = z;
    }

    public final void setNumber(int i) {
        this.number = i;
    }

    public final void setSign(String str) {
        f92.d(str, "<set-?>");
        this.sign = str;
    }

    public final void setUsed(int i) {
        this.used = i;
    }
}
