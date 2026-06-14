package a;

import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ch1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ eh1 f5793a;

    public ch1(eh1 eh1Var) {
        this.f5793a = eh1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u90 u90VarJ = ActivitySwap.j(ActivitySwap.this);
        String string = ActivitySwap.this.getString(u61.zram_resizing);
        f92.c(string, "getString(R.string.zram_resizing)");
        u90VarJ.d(string);
    }
}
