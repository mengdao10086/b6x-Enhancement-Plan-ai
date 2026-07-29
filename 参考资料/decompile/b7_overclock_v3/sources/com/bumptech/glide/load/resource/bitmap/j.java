package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import g.n0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class j implements c4.f<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f12597a;

    public j(o oVar) {
        this.f12597a = oVar;
    }

    @Override // c4.f
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.s<Bitmap> b(@n0 ByteBuffer byteBuffer, int i10, int i11, @n0 c4.e eVar) throws IOException {
        return this.f12597a.h(byteBuffer, i10, i11, eVar);
    }

    @Override // c4.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 ByteBuffer byteBuffer, @n0 c4.e eVar) {
        return this.f12597a.t(byteBuffer);
    }
}
