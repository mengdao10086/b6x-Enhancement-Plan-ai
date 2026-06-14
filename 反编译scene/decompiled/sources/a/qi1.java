package a;

import a.p80;
import android.app.Activity;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qi1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pj1 f7215a;

    public qi1(pj1 pj1Var) {
        this.f7215a = pj1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f7215a.C() || e60.m() || (!this.f7215a.D("/system/app") && !this.f7215a.D("/system/priv-app"))) {
            this.f7215a.c();
            return;
        }
        p80.a aVar = p80.f2403a;
        Activity activityB = this.f7215a.B();
        String string = this.f7215a.B().getString(u61.apps_op_magisk_clash);
        f92.c(string, "context.getString(R.string.apps_op_magisk_clash)");
        String string2 = this.f7215a.B().getString(u61.apps_op_magisk_clash_desc);
        f92.c(string2, "context.getString(R.stri…pps_op_magisk_clash_desc)");
        String string3 = this.f7215a.B().getString(u61.btn_continue);
        f92.c(string3, "context.getString(R.string.btn_continue)");
        aVar.h(activityB, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new q80(string3, new pi1(this), false, 4, null), (16 & 16) != 0 ? null : null);
    }
}
