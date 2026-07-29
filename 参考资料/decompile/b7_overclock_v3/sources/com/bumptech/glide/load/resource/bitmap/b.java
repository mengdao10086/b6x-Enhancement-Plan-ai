package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import g.n0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class b implements c4.g<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f12564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4.g<Bitmap> f12565b;

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, c4.g<Bitmap> gVar) {
        this.f12564a = eVar;
        this.f12565b = gVar;
    }

    @Override // c4.g
    @n0
    public EncodeStrategy b(@n0 c4.e eVar) {
        return this.f12565b.b(eVar);
    }

    @Override // c4.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 com.bumptech.glide.load.engine.s<BitmapDrawable> sVar, @n0 File file, @n0 c4.e eVar) {
        return this.f12565b.a((Bitmap) new g(sVar.get().getBitmap(), this.f12564a), file, eVar);
    }
}
