package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class d implements c4.h<BitmapDrawable> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c4.h<Drawable> f12574c;

    public d(c4.h<Bitmap> hVar) {
        this.f12574c = (c4.h) v4.m.d(new q(hVar, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.bumptech.glide.load.engine.s<BitmapDrawable> c(com.bumptech.glide.load.engine.s<Drawable> sVar) {
        if (sVar.get() instanceof BitmapDrawable) {
            return sVar;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + sVar.get());
    }

    public static com.bumptech.glide.load.engine.s<Drawable> d(com.bumptech.glide.load.engine.s<BitmapDrawable> sVar) {
        return sVar;
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        this.f12574c.a(messageDigest);
    }

    @Override // c4.h
    @n0
    public com.bumptech.glide.load.engine.s<BitmapDrawable> b(@n0 Context context, @n0 com.bumptech.glide.load.engine.s<BitmapDrawable> sVar, int i10, int i11) {
        return c(this.f12574c.b(context, d(sVar), i10, i11));
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f12574c.equals(((d) obj).f12574c);
        }
        return false;
    }

    @Override // c4.b
    public int hashCode() {
        return this.f12574c.hashCode();
    }
}
