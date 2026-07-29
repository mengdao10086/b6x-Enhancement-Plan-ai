package k4;

import com.bumptech.glide.load.engine.s;
import g.n0;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public class b implements s<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f36992a;

    public b(byte[] bArr) {
        this.f36992a = (byte[]) m.d(bArr);
    }

    @Override // com.bumptech.glide.load.engine.s
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f36992a;
    }

    @Override // com.bumptech.glide.load.engine.s
    public int c() {
        return this.f36992a.length;
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Class<byte[]> d() {
        return byte[].class;
    }
}
