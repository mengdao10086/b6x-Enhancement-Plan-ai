package a;

import com.omarea.krscript.model.SwitchNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SwitchNode f3680a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f3681a;
    public final /* synthetic */ boolean b;

    public yd0(fe0 fe0Var, SwitchNode switchNode, boolean z, Runnable runnable) {
        this.f7971a = fe0Var;
        this.f3680a = switchNode;
        this.b = z;
        this.f3681a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7971a.Q1(this.f3680a, this.b, this.f3681a);
    }
}
