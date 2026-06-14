package a;

import com.omarea.vtools.activities.ActivityActionPage;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5975a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityActionPage.c f705a;

    public e71(n92 n92Var, ActivityActionPage.c cVar) {
        this.f5975a = n92Var;
        this.f705a = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        fe0 fe0VarA = fe0.f6097a.a((ArrayList) this.f5975a.f6891a, ActivityActionPage.this.f5094a, ActivityActionPage.this.f5098b ? null : new d71(this), ActivityActionPage.this.getThemeMode());
        hm hmVarA = ActivityActionPage.this.getSupportFragmentManager().a();
        hmVarA.m(t61.main_list, fe0VarA);
        hmVarA.g();
        ActivityActionPage.this.C();
        ActivityActionPage.this.f5098b = true;
    }
}
