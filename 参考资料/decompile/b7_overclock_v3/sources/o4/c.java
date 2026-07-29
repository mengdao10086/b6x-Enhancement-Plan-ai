package o4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.s;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements e<Drawable, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f42709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e<Bitmap, byte[]> f42710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<n4.c, byte[]> f42711c;

    public c(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 e<Bitmap, byte[]> eVar2, @n0 e<n4.c, byte[]> eVar3) {
        this.f42709a = eVar;
        this.f42710b = eVar2;
        this.f42711c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @n0
    public static s<n4.c> b(@n0 s<Drawable> sVar) {
        return sVar;
    }

    @Override // o4.e
    @p0
    public s<byte[]> a(@n0 s<Drawable> sVar, @n0 c4.e eVar) {
        Drawable drawable = sVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f42710b.a(com.bumptech.glide.load.resource.bitmap.g.f(((BitmapDrawable) drawable).getBitmap(), this.f42709a), eVar);
        }
        if (drawable instanceof n4.c) {
            return this.f42711c.a(b(sVar), eVar);
        }
        return null;
    }
}
