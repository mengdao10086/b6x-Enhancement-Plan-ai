package gc;

import com.google.android.exoplayer2.Format;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f29209l = 16384;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f29210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f29211k;

    public k(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, int i10, Format format, int i11, @p0 Object obj, @p0 byte[] bArr) {
        k kVar;
        byte[] bArr2;
        super(aVar, bVar, i10, format, i11, obj, ya.g.f56663b, ya.g.f56663b);
        if (bArr == null) {
            bArr2 = u0.f31159f;
            kVar = this;
        } else {
            kVar = this;
            bArr2 = bArr;
        }
        kVar.f29210j = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void b() throws IOException {
        try {
            this.f29171i.a(this.f29164b);
            int i10 = 0;
            int i11 = 0;
            while (i10 != -1 && !this.f29211k) {
                i(i11);
                i10 = this.f29171i.read(this.f29210j, i11, 16384);
                if (i10 != -1) {
                    i11 += i10;
                }
            }
            if (!this.f29211k) {
                g(this.f29210j, i11);
            }
        } finally {
            u0.p(this.f29171i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void c() {
        this.f29211k = true;
    }

    public abstract void g(byte[] bArr, int i10) throws IOException;

    public byte[] h() {
        return this.f29210j;
    }

    public final void i(int i10) {
        byte[] bArr = this.f29210j;
        if (bArr.length < i10 + 16384) {
            this.f29210j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }
}
