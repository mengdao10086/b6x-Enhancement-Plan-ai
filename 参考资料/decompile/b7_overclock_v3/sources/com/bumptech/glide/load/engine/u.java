package com.bumptech.glide.load.engine;

import g.n0;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements c4.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v4.j<Class<?>, byte[]> f12481k = new v4.j<>(50);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f12482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c4.b f12483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c4.b f12484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class<?> f12487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c4.e f12488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c4.h<?> f12489j;

    public u(com.bumptech.glide.load.engine.bitmap_recycle.b bVar, c4.b bVar2, c4.b bVar3, int i10, int i11, c4.h<?> hVar, Class<?> cls, c4.e eVar) {
        this.f12482c = bVar;
        this.f12483d = bVar2;
        this.f12484e = bVar3;
        this.f12485f = i10;
        this.f12486g = i11;
        this.f12489j = hVar;
        this.f12487h = cls;
        this.f12488i = eVar;
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f12482c.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f12485f).putInt(this.f12486g).array();
        this.f12484e.a(messageDigest);
        this.f12483d.a(messageDigest);
        messageDigest.update(bArr);
        c4.h<?> hVar = this.f12489j;
        if (hVar != null) {
            hVar.a(messageDigest);
        }
        this.f12488i.a(messageDigest);
        messageDigest.update(c());
        this.f12482c.put(bArr);
    }

    public final byte[] c() {
        v4.j<Class<?>, byte[]> jVar = f12481k;
        byte[] bArrK = jVar.k(this.f12487h);
        if (bArrK != null) {
            return bArrK;
        }
        byte[] bytes = this.f12487h.getName().getBytes(c4.b.f9745b);
        jVar.o(this.f12487h, bytes);
        return bytes;
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f12486g == uVar.f12486g && this.f12485f == uVar.f12485f && v4.o.d(this.f12489j, uVar.f12489j) && this.f12487h.equals(uVar.f12487h) && this.f12483d.equals(uVar.f12483d) && this.f12484e.equals(uVar.f12484e) && this.f12488i.equals(uVar.f12488i);
    }

    @Override // c4.b
    public int hashCode() {
        int iHashCode = (((((this.f12483d.hashCode() * 31) + this.f12484e.hashCode()) * 31) + this.f12485f) * 31) + this.f12486g;
        c4.h<?> hVar = this.f12489j;
        if (hVar != null) {
            iHashCode = (iHashCode * 31) + hVar.hashCode();
        }
        return (((iHashCode * 31) + this.f12487h.hashCode()) * 31) + this.f12488i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f12483d + ", signature=" + this.f12484e + ", width=" + this.f12485f + ", height=" + this.f12486g + ", decodedResourceClass=" + this.f12487h + ", transformation='" + this.f12489j + "', options=" + this.f12488i + '}';
    }
}
