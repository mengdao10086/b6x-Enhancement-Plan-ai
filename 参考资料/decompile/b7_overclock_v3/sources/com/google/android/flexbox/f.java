package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f19410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f19411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19413m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f19415o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19416p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f19417q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19418r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19401a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19402b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19403c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19404d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<Integer> f19414n = new ArrayList();

    public int a() {
        return this.f19407g;
    }

    public int b() {
        return this.f19415o;
    }

    public int c() {
        return this.f19408h;
    }

    public int d() {
        return this.f19408h - this.f19409i;
    }

    public int e() {
        return this.f19405e;
    }

    public float f() {
        return this.f19410j;
    }

    public float g() {
        return this.f19411k;
    }

    public void h(View view, int leftDecoration, int topDecoration, int rightDecoration, int bottomDecoration) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f19401a = Math.min(this.f19401a, (view.getLeft() - flexItem.u()) - leftDecoration);
        this.f19402b = Math.min(this.f19402b, (view.getTop() - flexItem.x()) - topDecoration);
        this.f19403c = Math.max(this.f19403c, view.getRight() + flexItem.I() + rightDecoration);
        this.f19404d = Math.max(this.f19404d, view.getBottom() + flexItem.t() + bottomDecoration);
    }
}
