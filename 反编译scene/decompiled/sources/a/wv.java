package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f3483a;
    public int b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3484a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3485b = true;

    public wv(View view) {
        this.f3483a = view;
    }

    public void a() {
        View view = this.f3483a;
        eh.W(view, this.c - (view.getTop() - this.f7825a));
        View view2 = this.f3483a;
        eh.V(view2, this.d - (view2.getLeft() - this.b));
    }

    public int b() {
        return this.c;
    }

    public void c() {
        this.f7825a = this.f3483a.getTop();
        this.b = this.f3483a.getLeft();
    }

    public boolean d(int i) {
        if (!this.f3485b || this.d == i) {
            return false;
        }
        this.d = i;
        a();
        return true;
    }

    public boolean e(int i) {
        if (!this.f3484a || this.c == i) {
            return false;
        }
        this.c = i;
        a();
        return true;
    }
}
