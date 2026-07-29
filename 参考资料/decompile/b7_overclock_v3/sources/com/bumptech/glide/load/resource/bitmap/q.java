package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class q implements c4.h<Drawable> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c4.h<Bitmap> f12625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12626d;

    public q(c4.h<Bitmap> hVar, boolean z10) {
        this.f12625c = hVar;
        this.f12626d = z10;
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        this.f12625c.a(messageDigest);
    }

    @Override // c4.h
    @n0
    public com.bumptech.glide.load.engine.s<Drawable> b(@n0 Context context, @n0 com.bumptech.glide.load.engine.s<Drawable> sVar, int i10, int i11) {
        com.bumptech.glide.load.engine.bitmap_recycle.e eVarH = com.bumptech.glide.b.e(context).h();
        Drawable drawable = sVar.get();
        com.bumptech.glide.load.engine.s<Bitmap> sVarA = p.a(eVarH, drawable, i10, i11);
        if (sVarA != null) {
            com.bumptech.glide.load.engine.s<Bitmap> sVarB = this.f12625c.b(context, sVarA, i10, i11);
            if (!sVarB.equals(sVarA)) {
                return d(context, sVarB);
            }
            sVarB.a();
            return sVar;
        }
        if (!this.f12626d) {
            return sVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    public c4.h<BitmapDrawable> c() {
        return this;
    }

    public final com.bumptech.glide.load.engine.s<Drawable> d(Context context, com.bumptech.glide.load.engine.s<Bitmap> sVar) {
        return x.f(context.getResources(), sVar);
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (obj instanceof q) {
            return this.f12625c.equals(((q) obj).f12625c);
        }
        return false;
    }

    @Override // c4.b
    public int hashCode() {
        return this.f12625c.hashCode();
    }
}
