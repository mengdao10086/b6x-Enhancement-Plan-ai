package com.omarea.model;

import a.f92;
import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class AccountPointsResponse implements Serializable {
    public int consume;
    public int free;
    public int total;
    public boolean unbind;
    public String error = "";
    public AccountPoints[] records = new AccountPoints[0];
    public String detail = "";

    public final int getConsume() {
        return this.consume;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getError() {
        return this.error;
    }

    public final int getFree() {
        return this.free;
    }

    public final AccountPoints[] getRecords() {
        return this.records;
    }

    public final int getTotal() {
        return this.total;
    }

    public final boolean getUnbind() {
        return this.unbind;
    }

    public final void setConsume(int i) {
        this.consume = i;
    }

    public final void setDetail(String str) {
        f92.d(str, "<set-?>");
        this.detail = str;
    }

    public final void setError(String str) {
        f92.d(str, "<set-?>");
        this.error = str;
    }

    public final void setFree(int i) {
        this.free = i;
    }

    public final void setRecords(AccountPoints[] accountPointsArr) {
        f92.d(accountPointsArr, "<set-?>");
        this.records = accountPointsArr;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    public final void setUnbind(boolean z) {
        this.unbind = z;
    }
}
