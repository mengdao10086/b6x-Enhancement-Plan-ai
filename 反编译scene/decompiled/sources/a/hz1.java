package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hz1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iz1 f6358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1296a;

    public hz1(iz1 iz1Var, ArrayList arrayList, String str) {
        this.f6358a = iz1Var;
        this.f1296a = arrayList;
        this.f1295a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1296a.isEmpty()) {
            this.f6358a.f1483a.setText(this.f6358a.f1477a.getString(u61.monitor_threads_no_process));
            this.f6358a.f1476a.z(new ArrayList<>());
        } else {
            this.f6358a.f1476a.z(this.f1296a);
            this.f6358a.f1483a.setText(this.f1295a);
        }
    }
}
