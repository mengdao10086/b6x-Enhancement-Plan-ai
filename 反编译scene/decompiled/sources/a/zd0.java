package a;

import com.omarea.krscript.model.SwitchNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f8059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SwitchNode f3829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f3830a;
    public final /* synthetic */ boolean b;

    public zd0(fe0 fe0Var, SwitchNode switchNode, boolean z, Runnable runnable) {
        this.f8059a = fe0Var;
        this.f3829a = switchNode;
        this.b = z;
        this.f3830a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8059a.Q1(this.f3829a, this.b, this.f3830a);
    }
}
