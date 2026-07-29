package ra;

import android.view.View;
import xa.h;
import xa.i;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends h.a implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f47898c = new float[2];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f47899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f47900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f47901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f47902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f47903h;

    public e(l lVar, float f10, float f11, i iVar, View view) {
        this.f47899d = lVar;
        this.f47900e = f10;
        this.f47901f = f11;
        this.f47902g = iVar;
        this.f47903h = view;
    }

    public float b() {
        return this.f47900e;
    }

    public float c() {
        return this.f47901f;
    }
}
