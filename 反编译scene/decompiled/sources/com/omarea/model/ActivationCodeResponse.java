package com.omarea.model;

import a.f92;
import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivationCodeResponse implements Serializable {
    public boolean expired;
    public long expiry_time;
    public boolean pass;
    public String error = "";
    public String code = "";
    public String sign = "";
    public String type = "";
    public String detail = "";
    public String account = "";

    public final String getAccount() {
        return this.account;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCodeStr() {
        return this.code + '|' + this.sign;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getError() {
        return this.error;
    }

    public final boolean getExpired() {
        return this.expired;
    }

    public final long getExpiry_time() {
        return this.expiry_time;
    }

    public final boolean getPass() {
        return this.pass;
    }

    public final String getSign() {
        return this.sign;
    }

    public final String getType() {
        return this.type;
    }

    public final void setAccount(String str) {
        f92.d(str, "<set-?>");
        this.account = str;
    }

    public final void setCode(String str) {
        f92.d(str, "<set-?>");
        this.code = str;
    }

    public final void setDetail(String str) {
        f92.d(str, "<set-?>");
        this.detail = str;
    }

    public final void setError(String str) {
        f92.d(str, "<set-?>");
        this.error = str;
    }

    public final void setExpired(boolean z) {
        this.expired = z;
    }

    public final void setExpiry_time(long j) {
        this.expiry_time = j;
    }

    public final void setPass(boolean z) {
        this.pass = z;
    }

    public final void setSign(String str) {
        f92.d(str, "<set-?>");
        this.sign = str;
    }

    public final void setType(String str) {
        f92.d(str, "<set-?>");
        this.type = str;
    }
}
