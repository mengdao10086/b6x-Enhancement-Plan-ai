package a;

import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class y90 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa0 f7959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ha0 f3668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, Object> f3669a;

    public y90(ha0 ha0Var, aa0 aa0Var, HashMap<String, Object> map) {
        f92.d(ha0Var, "eventReceiver");
        this.f3668a = ha0Var;
        this.f7959a = aa0Var;
        this.f3669a = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ha0 ha0Var = this.f3668a;
        aa0 aa0Var = this.f7959a;
        f92.b(aa0Var);
        ha0Var.onReceive(aa0Var, this.f3669a);
    }
}
