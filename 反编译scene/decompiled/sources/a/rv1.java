package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rv1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g91 f7335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ tv1 f2791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ x90 f2792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f2794a;
    public final /* synthetic */ ArrayList b;

    public rv1(tv1 tv1Var, x90 x90Var, ArrayList arrayList, ArrayList arrayList2, g91 g91Var, String str) {
        this.f2791a = tv1Var;
        this.f2792a = x90Var;
        this.f2794a = arrayList;
        this.b = arrayList2;
        this.f7335a = g91Var;
        this.f2793a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b90 b90Var = new b90(this.f2792a.a(), this.f2794a, false, new qv1(this), 0, 16, null);
        String strJ = this.f2791a.f7539a.f7636a.J(u61.user_devices);
        f92.c(strJ, "getString(R.string.user_devices)");
        b90Var.K1(strJ);
        String strJ2 = this.f2791a.f7539a.f7636a.J(u61.user_device_remove);
        f92.c(strJ2, "getString(R.string.user_device_remove)");
        b90Var.I1(strJ2);
        b90Var.B1(this.f7335a.getSupportFragmentManager(), "devices-manager");
    }
}
