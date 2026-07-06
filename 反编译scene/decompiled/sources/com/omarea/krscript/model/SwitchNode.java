package com.omarea.krscript.model;

import a.f92;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class SwitchNode extends RunnableNode {
    public boolean checked;
    public String getState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchNode(String str) {
        super(str);
        f92.d(str, "currentConfigXml");
        this.getState = "";
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final String getGetState() {
        return this.getState;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public final void setGetState(String str) {
        f92.d(str, "<set-?>");
        this.getState = str;
    }
}
