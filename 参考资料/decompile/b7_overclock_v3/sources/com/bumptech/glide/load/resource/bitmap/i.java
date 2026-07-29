package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import g.n0;
import t4.c;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends com.bumptech.glide.j<i, Bitmap> {
    @n0
    public static i m(@n0 t4.g<Bitmap> gVar) {
        return new i().f(gVar);
    }

    @n0
    public static i n() {
        return new i().h();
    }

    @n0
    public static i o(int i10) {
        return new i().i(i10);
    }

    @n0
    public static i p(@n0 c.a aVar) {
        return new i().j(aVar);
    }

    @n0
    public static i q(@n0 t4.c cVar) {
        return new i().k(cVar);
    }

    @n0
    public static i r(@n0 t4.g<Drawable> gVar) {
        return new i().l(gVar);
    }

    @n0
    public i h() {
        return j(new c.a());
    }

    @n0
    public i i(int i10) {
        return j(new c.a(i10));
    }

    @n0
    public i j(@n0 c.a aVar) {
        return l(aVar.a());
    }

    @n0
    public i k(@n0 t4.c cVar) {
        return l(cVar);
    }

    @n0
    public i l(@n0 t4.g<Drawable> gVar) {
        return f(new t4.b(gVar));
    }
}
