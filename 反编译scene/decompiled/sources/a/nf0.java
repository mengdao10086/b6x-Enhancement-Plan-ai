package a;

import com.omarea.krscript.model.ClickableNode;
import com.omarea.krscript.model.NodeInfoBase;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nf0 implements xe0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ of0 f6909a;

    public nf0(of0 of0Var) {
        this.f6909a = of0Var;
    }

    @Override // a.xe0
    public void a(ye0 ye0Var) {
        f92.d(ye0Var, "listItemView");
        NodeInfoBase nodeInfoBaseM = this.f6909a.m(ye0Var.a(), this.f6909a.f2240a);
        if (nodeInfoBaseM instanceof ClickableNode) {
            this.f6909a.f7016a.d((ClickableNode) nodeInfoBaseM);
        }
    }
}
