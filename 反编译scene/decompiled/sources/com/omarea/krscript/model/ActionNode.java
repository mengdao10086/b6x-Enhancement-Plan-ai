package com.omarea.krscript.model;

import a.f92;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActionNode extends RunnableNode {
    public ArrayList<ActionParamInfo> params;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionNode(String str) {
        super(str);
        f92.d(str, "currentConfigXml");
    }

    public final ArrayList<ActionParamInfo> getParams() {
        return this.params;
    }

    public final void setParams(ArrayList<ActionParamInfo> arrayList) {
        this.params = arrayList;
    }
}
