package la;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f39500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f39501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f39502c;

    public f() {
        this.f39500a = 0.0f;
        this.f39501b = null;
        this.f39502c = null;
    }

    public Object a() {
        return this.f39501b;
    }

    public Drawable b() {
        return this.f39502c;
    }

    public float e() {
        return this.f39500a;
    }

    public void g(Object obj) {
        this.f39501b = obj;
    }

    public void j(Drawable drawable) {
        this.f39502c = drawable;
    }

    public void s(float f10) {
        this.f39500a = f10;
    }

    public f(float f10) {
        this.f39501b = null;
        this.f39502c = null;
        this.f39500a = f10;
    }

    public f(float f10, Object obj) {
        this(f10);
        this.f39501b = obj;
    }

    public f(float f10, Drawable drawable) {
        this(f10);
        this.f39502c = drawable;
    }

    public f(float f10, Drawable drawable, Object obj) {
        this(f10);
        this.f39502c = drawable;
        this.f39501b = obj;
    }
}
