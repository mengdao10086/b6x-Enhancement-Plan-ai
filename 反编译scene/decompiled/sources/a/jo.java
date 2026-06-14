package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class jo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ to f6529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1565a;

    public jo(to toVar, ArrayList arrayList) {
        this.f6529a = toVar;
        this.f1565a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (so soVar : this.f1565a) {
            this.f6529a.T(soVar.f2910a, soVar.f7417a, soVar.b, soVar.c, soVar.d);
        }
        this.f1565a.clear();
        this.f6529a.g.remove(this.f1565a);
    }
}
