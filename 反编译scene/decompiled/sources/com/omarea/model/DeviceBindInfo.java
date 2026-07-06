package com.omarea.model;

import a.f92;
import a.g30;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class DeviceBindInfo {
    public boolean current;
    public String id;
    public g30 item;
    public String name;

    public final boolean getCurrent() {
        return this.current;
    }

    public final String getId() {
        String str = this.id;
        if (str != null) {
            return str;
        }
        f92.m("id");
        throw null;
    }

    public final g30 getItem() {
        g30 g30Var = this.item;
        if (g30Var != null) {
            return g30Var;
        }
        f92.m("item");
        throw null;
    }

    public final String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        f92.m("name");
        throw null;
    }

    public final void setCurrent(boolean z) {
        this.current = z;
    }

    public final void setId(String str) {
        f92.d(str, "<set-?>");
        this.id = str;
    }

    public final void setItem(g30 g30Var) {
        f92.d(g30Var, "<set-?>");
        this.item = g30Var;
    }

    public final void setName(String str) {
        f92.d(str, "<set-?>");
        this.name = str;
    }
}
