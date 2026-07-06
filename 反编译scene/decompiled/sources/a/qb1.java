package a;

import com.omarea.vtools.activities.ActivityFreezeApps;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qb1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFreezeApps.g f7196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f2564a;

    public qb1(ActivityFreezeApps.g gVar, List list) {
        this.f7196a = gVar;
        this.f2564a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityFreezeApps.this.addFreezeApps(this.f2564a);
    }
}
