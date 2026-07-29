package n4;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.s;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements c4.f<a4.a, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f41873a;

    public h(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f41873a = eVar;
    }

    @Override // c4.f
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public s<Bitmap> b(@n0 a4.a aVar, int i10, int i11, @n0 c4.e eVar) {
        return com.bumptech.glide.load.resource.bitmap.g.f(aVar.a(), this.f41873a);
    }

    @Override // c4.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 a4.a aVar, @n0 c4.e eVar) {
        return true;
    }
}
