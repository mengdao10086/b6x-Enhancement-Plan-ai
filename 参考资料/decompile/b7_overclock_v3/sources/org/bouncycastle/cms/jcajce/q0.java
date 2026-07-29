package org.bouncycastle.cms.jcajce;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes5.dex */
public class q0 implements cs.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f44618a;

    public class a implements cs.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44619a;

        public a(zn.b bVar) {
            this.f44619a = bVar;
        }

        @Override // cs.u
        public zn.b a() {
            return this.f44619a;
        }

        @Override // cs.u
        public InputStream b(InputStream inputStream) {
            InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
            return q0.this.f44618a >= 0 ? new b(inflaterInputStream, q0.this.f44618a) : inflaterInputStream;
        }
    }

    public static class b extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f44621a;

        public b(InputStream inputStream, long j10) {
            super(inputStream);
            this.f44621a = j10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        
            if (r4 >= 0) goto L8;
         */
        @Override // java.io.FilterInputStream, java.io.InputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int read() throws java.io.IOException {
            /*
                r8 = this;
                long r0 = r8.f44621a
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 < 0) goto L1c
                java.io.InputStream r0 = r8.in
                int r0 = r0.read()
                if (r0 < 0) goto L1b
                long r4 = r8.f44621a
                r6 = 1
                long r4 = r4 - r6
                r8.f44621a = r4
                int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r1 < 0) goto L1c
            L1b:
                return r0
            L1c:
                org.bouncycastle.util.io.StreamOverflowException r0 = new org.bouncycastle.util.io.StreamOverflowException
                java.lang.String r1 = "expanded byte limit exceeded"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.cms.jcajce.q0.b.read():int");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (i11 < 1) {
                return super.read(bArr, i10, i11);
            }
            long j10 = this.f44621a;
            if (j10 < 1) {
                read();
                return -1;
            }
            if (j10 <= i11) {
                i11 = (int) j10;
            }
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
            if (i12 > 0) {
                this.f44621a -= (long) i12;
            }
            return i12;
        }
    }

    public q0() {
        this.f44618a = -1L;
    }

    public q0(long j10) {
        this.f44618a = j10;
    }

    @Override // cs.v
    public cs.u a(zn.b bVar) {
        return new a(bVar);
    }
}
