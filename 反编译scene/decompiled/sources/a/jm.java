package a;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wm f6524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Fragment f1557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object f1558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1559a;
    public final /* synthetic */ Object b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1560b;
    public final /* synthetic */ ArrayList c;

    public jm(Object obj, wm wmVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f1558a = obj;
        this.f6524a = wmVar;
        this.f1556a = view;
        this.f1557a = fragment;
        this.f1559a = arrayList;
        this.f1560b = arrayList2;
        this.c = arrayList3;
        this.b = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.f1558a;
        if (obj != null) {
            this.f6524a.p(obj, this.f1556a);
            this.f1560b.addAll(nm.k(this.f6524a, this.f1558a, this.f1557a, this.f1559a, this.f1556a));
        }
        if (this.c != null) {
            if (this.b != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1556a);
                this.f6524a.q(this.b, this.c, arrayList);
            }
            this.c.clear();
            this.c.add(this.f1556a);
        }
    }
}
