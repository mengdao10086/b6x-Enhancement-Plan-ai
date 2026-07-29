package ld;

import android.view.View;
import androidx.core.view.u0;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f39587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f39589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f39590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f39591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f39592f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f39593g = true;

    public e(View view) {
        this.f39587a = view;
    }

    public void a() {
        View view = this.f39587a;
        u0.f1(view, this.f39590d - (view.getTop() - this.f39588b));
        View view2 = this.f39587a;
        u0.e1(view2, this.f39591e - (view2.getLeft() - this.f39589c));
    }

    public int b() {
        return this.f39589c;
    }

    public int c() {
        return this.f39588b;
    }

    public int d() {
        return this.f39591e;
    }

    public int e() {
        return this.f39590d;
    }

    public boolean f() {
        return this.f39593g;
    }

    public boolean g() {
        return this.f39592f;
    }

    public void h() {
        this.f39588b = this.f39587a.getTop();
        this.f39589c = this.f39587a.getLeft();
    }

    public void i(boolean z10) {
        this.f39593g = z10;
    }

    public boolean j(int i10) {
        if (!this.f39593g || this.f39591e == i10) {
            return false;
        }
        this.f39591e = i10;
        a();
        return true;
    }

    public boolean k(int i10) {
        if (!this.f39592f || this.f39590d == i10) {
            return false;
        }
        this.f39590d = i10;
        a();
        return true;
    }

    public void l(boolean z10) {
        this.f39592f = z10;
    }
}
