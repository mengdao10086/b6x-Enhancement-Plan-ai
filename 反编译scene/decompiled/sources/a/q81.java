package a;

import com.omarea.vtools.activities.ActivityAppRetrieve;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q81 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAppRetrieve.d f7188a;

    public q81(ActivityAppRetrieve.d dVar) {
        this.f7188a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y60.f7952a.b("/data/system/users/0/package-restrictions.xml.fallback");
        y60.f7952a.b("/data/system/users/0/package-restrictions.xml.reservecopy");
        y60.f7952a.b("/data/system/users/0/package-restrictions.xml");
        s60.f7366a.a("sync;" + ActivityAppRetrieve.this.getString(u61.cmd_power_reboot));
    }
}
