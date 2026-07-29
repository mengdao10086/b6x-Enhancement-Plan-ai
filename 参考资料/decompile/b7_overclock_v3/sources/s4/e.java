package s4;

import android.graphics.drawable.Drawable;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T> implements p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public com.bumptech.glide.request.e f49462c;

    public e() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // p4.m
    public void a() {
    }

    @Override // p4.m
    public void b() {
    }

    @Override // p4.m
    public void c() {
    }

    @Override // s4.p
    public final void f(@n0 o oVar) {
    }

    @Override // s4.p
    public final void l(@p0 com.bumptech.glide.request.e eVar) {
        this.f49462c = eVar;
    }

    @Override // s4.p
    public final void m(@n0 o oVar) {
        oVar.e(this.f49460a, this.f49461b);
    }

    @Override // s4.p
    public void n(@p0 Drawable drawable) {
    }

    @Override // s4.p
    public void q(@p0 Drawable drawable) {
    }

    @Override // s4.p
    @p0
    public final com.bumptech.glide.request.e r() {
        return this.f49462c;
    }

    public e(int i10, int i11) {
        if (v4.o.w(i10, i11)) {
            this.f49460a = i10;
            this.f49461b = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }
}
