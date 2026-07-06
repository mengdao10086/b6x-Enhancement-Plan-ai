package a;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba f6721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ mm f1826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wm f1827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Rect f1828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Fragment f1830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object f1831a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1832a;
    public final /* synthetic */ Fragment b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ Object f1833b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1834b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f1835b;

    public lm(wm wmVar, ba baVar, Object obj, mm mmVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f1827a = wmVar;
        this.f6721a = baVar;
        this.f1831a = obj;
        this.f1826a = mmVar;
        this.f1832a = arrayList;
        this.f1829a = view;
        this.f1830a = fragment;
        this.b = fragment2;
        this.f1835b = z;
        this.f1834b = arrayList2;
        this.f1833b = obj2;
        this.f1828a = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba<String, View> baVarH = nm.h(this.f1827a, this.f6721a, this.f1831a, this.f1826a);
        if (baVarH != null) {
            this.f1832a.addAll(baVarH.values());
            this.f1832a.add(this.f1829a);
        }
        nm.f(this.f1830a, this.b, this.f1835b, baVarH, false);
        Object obj = this.f1831a;
        if (obj != null) {
            this.f1827a.z(obj, this.f1834b, this.f1832a);
            View viewT = nm.t(baVarH, this.f1826a, this.f1833b, this.f1835b);
            if (viewT != null) {
                this.f1827a.k(viewT, this.f1828a);
            }
        }
    }
}
