package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import g.i0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f7910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f7912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f7913f;

    public n(@n0 ViewGroup viewGroup) {
        this.f7909b = -1;
        this.f7910c = viewGroup;
    }

    @p0
    public static n c(@n0 ViewGroup viewGroup) {
        return (n) viewGroup.getTag(R.id.transition_current_scene);
    }

    @n0
    public static n d(@n0 ViewGroup viewGroup, @i0 int i10, @n0 Context context) {
        int i11 = R.id.transition_scene_layoutid_cache;
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(i11);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(i11, sparseArray);
        }
        n nVar = (n) sparseArray.get(i10);
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(viewGroup, i10, context);
        sparseArray.put(i10, nVar2);
        return nVar2;
    }

    public static void g(@n0 ViewGroup viewGroup, @p0 n nVar) {
        viewGroup.setTag(R.id.transition_current_scene, nVar);
    }

    public void a() {
        if (this.f7909b > 0 || this.f7911d != null) {
            e().removeAllViews();
            if (this.f7909b > 0) {
                LayoutInflater.from(this.f7908a).inflate(this.f7909b, this.f7910c);
            } else {
                this.f7910c.addView(this.f7911d);
            }
        }
        Runnable runnable = this.f7912e;
        if (runnable != null) {
            runnable.run();
        }
        g(this.f7910c, this);
    }

    public void b() {
        Runnable runnable;
        if (c(this.f7910c) != this || (runnable = this.f7913f) == null) {
            return;
        }
        runnable.run();
    }

    @n0
    public ViewGroup e() {
        return this.f7910c;
    }

    public boolean f() {
        return this.f7909b > 0;
    }

    public void h(@p0 Runnable runnable) {
        this.f7912e = runnable;
    }

    public void i(@p0 Runnable runnable) {
        this.f7913f = runnable;
    }

    public n(ViewGroup viewGroup, int i10, Context context) {
        this.f7908a = context;
        this.f7910c = viewGroup;
        this.f7909b = i10;
    }

    public n(@n0 ViewGroup viewGroup, @n0 View view) {
        this.f7909b = -1;
        this.f7910c = viewGroup;
        this.f7911d = view;
    }
}
