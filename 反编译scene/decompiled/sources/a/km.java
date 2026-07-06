package a;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class km implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba f6619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wm f1656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Rect f1657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Fragment f1659a;
    public final /* synthetic */ Fragment b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f1660b;

    public km(Fragment fragment, Fragment fragment2, boolean z, ba baVar, View view, wm wmVar, Rect rect) {
        this.f1659a = fragment;
        this.b = fragment2;
        this.f1660b = z;
        this.f6619a = baVar;
        this.f1658a = view;
        this.f1656a = wmVar;
        this.f1657a = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        nm.f(this.f1659a, this.b, this.f1660b, this.f6619a, false);
        View view = this.f1658a;
        if (view != null) {
            this.f1656a.k(view, this.f1657a);
        }
    }
}
