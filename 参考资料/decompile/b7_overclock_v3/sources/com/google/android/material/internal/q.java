package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f20486c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public ie.d f20489f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f20484a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ie.f f20485b = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20487d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public WeakReference<b> f20488e = new WeakReference<>(null);

    public class a extends ie.f {
        public a() {
        }

        @Override // ie.f
        public void a(int i10) {
            q.this.f20487d = true;
            b bVar = (b) q.this.f20488e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // ie.f
        public void b(@n0 Typeface typeface, boolean z10) {
            if (z10) {
                return;
            }
            q.this.f20487d = true;
            b bVar = (b) q.this.f20488e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        @n0
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public q(@p0 b bVar) {
        h(bVar);
    }

    public final float c(@p0 CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f20484a.measureText(charSequence, 0, charSequence.length());
    }

    @p0
    public ie.d d() {
        return this.f20489f;
    }

    @n0
    public TextPaint e() {
        return this.f20484a;
    }

    public float f(String str) {
        if (!this.f20487d) {
            return this.f20486c;
        }
        float fC = c(str);
        this.f20486c = fC;
        this.f20487d = false;
        return fC;
    }

    public boolean g() {
        return this.f20487d;
    }

    public void h(@p0 b bVar) {
        this.f20488e = new WeakReference<>(bVar);
    }

    public void i(@p0 ie.d dVar, Context context) {
        if (this.f20489f != dVar) {
            this.f20489f = dVar;
            if (dVar != null) {
                dVar.o(context, this.f20484a, this.f20485b);
                b bVar = this.f20488e.get();
                if (bVar != null) {
                    this.f20484a.drawableState = bVar.getState();
                }
                dVar.n(context, this.f20484a, this.f20485b);
                this.f20487d = true;
            }
            b bVar2 = this.f20488e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void j(boolean z10) {
        this.f20487d = z10;
    }

    public void k(Context context) {
        this.f20489f.n(context, this.f20484a, this.f20485b);
    }
}
