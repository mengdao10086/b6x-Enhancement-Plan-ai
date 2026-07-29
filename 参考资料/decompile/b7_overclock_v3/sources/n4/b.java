package n4;

import a4.a;
import android.graphics.Bitmap;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a.InterfaceC0009a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f41828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f41829b;

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this(eVar, null);
    }

    @Override // a4.a.InterfaceC0009a
    @n0
    public Bitmap a(int i10, int i11, @n0 Bitmap.Config config) {
        return this.f41828a.g(i10, i11, config);
    }

    @Override // a4.a.InterfaceC0009a
    @n0
    public int[] b(int i10) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f41829b;
        return bVar == null ? new int[i10] : (int[]) bVar.f(i10, int[].class);
    }

    @Override // a4.a.InterfaceC0009a
    public void c(@n0 Bitmap bitmap) {
        this.f41828a.e(bitmap);
    }

    @Override // a4.a.InterfaceC0009a
    public void d(@n0 byte[] bArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f41829b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // a4.a.InterfaceC0009a
    @n0
    public byte[] e(int i10) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f41829b;
        return bVar == null ? new byte[i10] : (byte[]) bVar.f(i10, byte[].class);
    }

    @Override // a4.a.InterfaceC0009a
    public void f(@n0 int[] iArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f41829b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @p0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f41828a = eVar;
        this.f41829b = bVar;
    }
}
