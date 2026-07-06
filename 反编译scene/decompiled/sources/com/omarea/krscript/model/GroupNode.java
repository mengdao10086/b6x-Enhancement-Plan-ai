package com.omarea.krscript.model;

import a.f92;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class GroupNode extends NodeInfoBase {
    public final ArrayList<NodeInfoBase> children;
    public boolean supported;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupNode(String str) {
        super(str);
        f92.d(str, "currentPageConfigPath");
        this.supported = true;
        this.children = new ArrayList<>();
    }

    public final ArrayList<NodeInfoBase> getChildren() {
        return this.children;
    }

    public final boolean getSupported() {
        return this.supported;
    }

    public final void setSupported(boolean z) {
        this.supported = z;
    }
}
