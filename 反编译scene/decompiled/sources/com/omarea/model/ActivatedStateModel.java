package com.omarea.model;

import a.f92;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivatedStateModel {
    public boolean activated;
    public boolean permanent;
    public String text = "";
    public String type = "";
    public String typeName = "";

    public final boolean getActivated() {
        return this.activated;
    }

    public final boolean getPermanent() {
        return this.permanent;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final void setActivated(boolean z) {
        this.activated = z;
    }

    public final void setPermanent(boolean z) {
        this.permanent = z;
    }

    public final void setText(String str) {
        f92.d(str, "<set-?>");
        this.text = str;
    }

    public final void setType(String str) {
        f92.d(str, "<set-?>");
        this.type = str;
    }

    public final void setTypeName(String str) {
        f92.d(str, "<set-?>");
        this.typeName = str;
    }
}
