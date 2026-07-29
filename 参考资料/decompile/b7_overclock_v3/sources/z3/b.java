package z3;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f57719f = 13;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f57720g = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f57721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f57722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f57723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f57724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f57725e;

    public class a extends ByteArrayOutputStream {
        public a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, b.this.f57722b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void c() throws IOException {
        InputStream inputStream = this.f57721a;
        byte[] bArr = this.f57723c;
        int i10 = inputStream.read(bArr, 0, bArr.length);
        if (i10 == -1) {
            throw new EOFException();
        }
        this.f57724d = 0;
        this.f57725e = i10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f57721a) {
            if (this.f57723c != null) {
                this.f57723c = null;
                this.f57721a.close();
            }
        }
    }

    public boolean d() {
        return this.f57725e == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String f() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f57721a
            monitor-enter(r0)
            byte[] r1 = r7.f57723c     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L7f
            int r1 = r7.f57724d     // Catch: java.lang.Throwable -> L87
            int r2 = r7.f57725e     // Catch: java.lang.Throwable -> L87
            if (r1 < r2) goto L10
            r7.c()     // Catch: java.lang.Throwable -> L87
        L10:
            int r1 = r7.f57724d     // Catch: java.lang.Throwable -> L87
        L12:
            int r2 = r7.f57725e     // Catch: java.lang.Throwable -> L87
            r3 = 10
            if (r1 == r2) goto L41
            byte[] r2 = r7.f57723c     // Catch: java.lang.Throwable -> L87
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L87
            if (r4 != r3) goto L3e
            int r3 = r7.f57724d     // Catch: java.lang.Throwable -> L87
            if (r1 == r3) goto L2b
            int r4 = r1 + (-1)
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L87
            r6 = 13
            if (r5 != r6) goto L2b
            goto L2c
        L2b:
            r4 = r1
        L2c:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L87
            int r4 = r4 - r3
            java.nio.charset.Charset r6 = r7.f57722b     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L87
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L87
            int r1 = r1 + 1
            r7.f57724d = r1     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            return r5
        L3e:
            int r1 = r1 + 1
            goto L12
        L41:
            z3.b$a r1 = new z3.b$a     // Catch: java.lang.Throwable -> L87
            int r2 = r7.f57725e     // Catch: java.lang.Throwable -> L87
            int r4 = r7.f57724d     // Catch: java.lang.Throwable -> L87
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
        L4d:
            byte[] r2 = r7.f57723c     // Catch: java.lang.Throwable -> L87
            int r4 = r7.f57724d     // Catch: java.lang.Throwable -> L87
            int r5 = r7.f57725e     // Catch: java.lang.Throwable -> L87
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L87
            r2 = -1
            r7.f57725e = r2     // Catch: java.lang.Throwable -> L87
            r7.c()     // Catch: java.lang.Throwable -> L87
            int r2 = r7.f57724d     // Catch: java.lang.Throwable -> L87
        L5f:
            int r4 = r7.f57725e     // Catch: java.lang.Throwable -> L87
            if (r2 == r4) goto L4d
            byte[] r4 = r7.f57723c     // Catch: java.lang.Throwable -> L87
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L87
            if (r5 != r3) goto L7c
            int r3 = r7.f57724d     // Catch: java.lang.Throwable -> L87
            if (r2 == r3) goto L72
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L87
        L72:
            int r2 = r2 + 1
            r7.f57724d = r2     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            return r1
        L7c:
            int r2 = r2 + 1
            goto L5f
        L7f:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
            throw r1     // Catch: java.lang.Throwable -> L87
        L87:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.b.f():java.lang.String");
    }

    public b(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f57727a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f57721a = inputStream;
        this.f57722b = charset;
        this.f57723c = new byte[i10];
    }
}
