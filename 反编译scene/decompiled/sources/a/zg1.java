package a;

import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zg1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivitySwap.x f8070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ StringBuilder f3845a;

    public zg1(ActivitySwap.x xVar, StringBuilder sb) {
        this.f8070a = xVar;
        this.f3845a = sb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u90 u90VarJ = ActivitySwap.j(ActivitySwap.this);
        String string = this.f3845a.toString();
        f92.c(string, "tipStr.toString()");
        u90VarJ.d(string);
    }
}
