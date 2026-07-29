package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class z implements c4.f<Uri, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l4.f f12673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f12674b;

    public z(l4.f fVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f12673a = fVar;
        this.f12674b = eVar;
    }

    @Override // c4.f
    @p0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.s<Bitmap> b(@n0 Uri uri, int i10, int i11, @n0 c4.e eVar) {
        com.bumptech.glide.load.engine.s<Drawable> sVarB = this.f12673a.b(uri, i10, i11, eVar);
        if (sVarB == null) {
            return null;
        }
        return p.a(this.f12674b, sVarB.get(), i10, i11);
    }

    @Override // c4.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 Uri uri, @n0 c4.e eVar) {
        return com.google.android.exoplayer2.upstream.c.f19120t.equals(uri.getScheme());
    }
}
