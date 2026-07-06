package a;

import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.RunnableNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kf0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lf0 f6599a;

    public kf0(lf0 lf0Var) {
        this.f6599a = lf0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6599a.f1794a.h();
        NodeInfoBase nodeInfoBase = this.f6599a.f1796a;
        if (!(nodeInfoBase instanceof RunnableNode) || ((RunnableNode) nodeInfoBase).getUpdateBlocks() == null) {
            return;
        }
        ze0 ze0Var = this.f6599a.f6701a.f2238a;
        String[] updateBlocks = ((RunnableNode) this.f6599a.f1796a).getUpdateBlocks();
        f92.b(updateBlocks);
        ze0Var.m(updateBlocks);
    }
}
