package a;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class tm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f3041a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ ArrayList d;

    public tm(wm wmVar, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f7513a = i;
        this.f3041a = arrayList;
        this.b = arrayList2;
        this.c = arrayList3;
        this.d = arrayList4;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f7513a; i++) {
            eh.z0((View) this.f3041a.get(i), (String) this.b.get(i));
            eh.z0((View) this.c.get(i), (String) this.d.get(i));
        }
    }
}
