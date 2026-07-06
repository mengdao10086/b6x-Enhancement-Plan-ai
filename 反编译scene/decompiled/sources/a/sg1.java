package a;

import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sg1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivitySwap.s f7394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ StringBuilder f2892a;

    public sg1(ActivitySwap.s sVar, StringBuilder sb) {
        this.f7394a = sVar;
        this.f2892a = sb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u90 u90VarJ = ActivitySwap.j(ActivitySwap.this);
        String string = this.f2892a.toString();
        f92.c(string, "tipStr.toString()");
        u90VarJ.d(string);
    }
}
