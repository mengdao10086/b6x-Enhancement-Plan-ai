package st;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class e extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f50516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final st.a f50517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f50518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f50519d;

    public e() {
        this(8192);
    }

    public final void a() throws IOException {
        if (this.f50519d) {
            throw new IOException("PipelineInputStream was closed (broken pipeline)");
        }
    }

    public InputStream c() {
        return this.f50516a;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f50518c = true;
        d();
    }

    public void d() {
        notifyAll();
    }

    public void f() throws IOException {
        try {
            wait();
        } catch (InterruptedException e10) {
            throw new IOException(e10);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 != i11) {
            a();
            int iJ = this.f50517b.j(bArr, i10 + i12, i11 - i12);
            if (iJ > 0) {
                i12 += iJ;
                d();
            } else {
                f();
            }
        }
    }

    public e(int i10) {
        this.f50517b = new st.a(i10);
        this.f50516a = new a();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i10) throws IOException {
        a();
        while (!this.f50517b.k((byte) i10)) {
            f();
            a();
        }
        d();
    }

    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return e.this.f50517b.a();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            e.this.f50519d = true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int iG;
            if (i11 == 0) {
                return e.this.f50518c ? -1 : 0;
            }
            synchronized (e.this) {
                do {
                    iG = e.this.f50517b.g(bArr, i10, i11);
                    if (iG == 0) {
                        e eVar = e.this;
                        if (eVar.f50518c) {
                            return -1;
                        }
                        eVar.f();
                    }
                } while (iG == 0);
                e.this.d();
                return iG;
            }
        }

        @Override // java.io.InputStream
        public long skip(long j10) throws IOException {
            int iMin = (int) Math.min(j10, 2147483647L);
            synchronized (e.this) {
                int i10 = 0;
                while (i10 < iMin) {
                    int iO = e.this.f50517b.o(iMin - i10);
                    if (iO == 0) {
                        e eVar = e.this;
                        if (eVar.f50518c) {
                            return i10;
                        }
                        eVar.f();
                    } else {
                        i10 += iO;
                        e.this.d();
                    }
                }
                return i10;
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            synchronized (e.this) {
                int iE = e.this.f50517b.e();
                while (iE == -1) {
                    e eVar = e.this;
                    if (eVar.f50518c) {
                        return -1;
                    }
                    eVar.f();
                    iE = e.this.f50517b.e();
                }
                e.this.d();
                return iE;
            }
        }
    }
}
