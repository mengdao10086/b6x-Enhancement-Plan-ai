package com.omarea.model;

import a.f92;
import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class LoginResponse implements Serializable {
    public boolean activated;
    public boolean pass;
    public String error = "";
    public String detail = "";

    public final boolean getActivated() {
        return this.activated;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getError() {
        return this.error;
    }

    public final boolean getPass() {
        return this.pass;
    }

    public final void setActivated(boolean z) {
        this.activated = z;
    }

    public final void setDetail(String str) {
        f92.d(str, "<set-?>");
        this.detail = str;
    }

    public final void setError(String str) {
        f92.d(str, "<set-?>");
        this.error = str;
    }

    public final void setPass(boolean z) {
        this.pass = z;
    }
}
