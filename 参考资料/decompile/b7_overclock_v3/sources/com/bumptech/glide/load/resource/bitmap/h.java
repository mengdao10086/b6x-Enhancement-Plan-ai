package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements c4.h<Bitmap> {
    @Override // c4.h
    @n0
    public final com.bumptech.glide.load.engine.s<Bitmap> b(@n0 Context context, @n0 com.bumptech.glide.load.engine.s<Bitmap> sVar, int i10, int i11) {
        if (!v4.o.w(i10, i11)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.bumptech.glide.load.engine.bitmap_recycle.e eVarH = com.bumptech.glide.b.e(context).h();
        Bitmap bitmap = sVar.get();
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getWidth();
        }
        if (i11 == Integer.MIN_VALUE) {
            i11 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(eVarH, bitmap, i10, i11);
        return bitmap.equals(bitmapC) ? sVar : g.f(bitmapC, eVarH);
    }

    public abstract Bitmap c(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11);
}
