package qj;

import android.content.Context;
import android.graphics.Bitmap;
import c4.h;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.bitmap.g;
import g.n0;
import java.security.MessageDigest;
import v4.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements h<Bitmap> {
    @Override // c4.b
    public abstract void a(@n0 MessageDigest messageDigest);

    @Override // c4.h
    @n0
    public final s<Bitmap> b(@n0 Context context, @n0 s<Bitmap> sVar, int i10, int i11) {
        if (!o.w(i10, i11)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.bumptech.glide.load.engine.bitmap_recycle.e eVarH = com.bumptech.glide.b.e(context).h();
        Bitmap bitmap = sVar.get();
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getWidth();
        }
        int i12 = i10;
        if (i11 == Integer.MIN_VALUE) {
            i11 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(context.getApplicationContext(), eVarH, bitmap, i12, i11);
        return bitmap.equals(bitmapC) ? sVar : g.f(bitmapC, eVarH);
    }

    public abstract Bitmap c(@n0 Context context, @n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11);

    @Override // c4.b
    public abstract boolean equals(Object obj);

    @Override // c4.b
    public abstract int hashCode();
}
