package so;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f50301c = 32768;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.y f50302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f50303b;

    public static class a extends FilterInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (i11 == 0) {
                return 0;
            }
            int iH = kt.c.h(((FilterInputStream) this).in, bArr, i10, i11);
            if (iH > 0) {
                return iH;
            }
            return -1;
        }
    }

    public s0(gm.y yVar) {
        this.f50302a = yVar;
    }

    public s0(gm.y yVar, InputStream inputStream) {
        this(yVar, inputStream, 32768);
    }

    public s0(gm.y yVar, InputStream inputStream, int i10) {
        this.f50302a = yVar;
        this.f50303b = new a(new BufferedInputStream(inputStream, i10));
    }

    public s0(InputStream inputStream) {
        this(pn.s.f46830o4.L(), inputStream, 32768);
    }

    public s0(String str, InputStream inputStream) {
        this(new gm.y(str), inputStream, 32768);
    }

    public s0(String str, InputStream inputStream, int i10) {
        this(new gm.y(str), inputStream, i10);
    }

    public void a() throws IOException {
        kt.c.a(this.f50303b);
        this.f50303b.close();
    }

    public InputStream b() {
        return this.f50303b;
    }

    public gm.y c() {
        return this.f50302a;
    }
}
