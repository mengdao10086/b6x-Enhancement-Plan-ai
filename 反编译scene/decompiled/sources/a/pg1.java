package a;

import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pg1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rg1 f7117a;

    public pg1(rg1 rg1Var) {
        this.f7117a = rg1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u90 u90VarJ = ActivitySwap.j(ActivitySwap.this);
        String string = ActivitySwap.this.getString(u61.file_creating);
        f92.c(string, "getString(R.string.file_creating)");
        u90VarJ.d(string);
    }
}
