package v4;

import g.b0;
import g.n0;
import g.p0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0("POOL")
    public static final Queue<e> f52675c = o.f(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f52676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IOException f52677b;

    public static void a() {
        synchronized (f52675c) {
            while (true) {
                Queue<e> queue = f52675c;
                if (!queue.isEmpty()) {
                    queue.remove();
                }
            }
        }
    }

    @n0
    public static e d(@n0 InputStream inputStream) {
        e eVarPoll;
        Queue<e> queue = f52675c;
        synchronized (queue) {
            eVarPoll = queue.poll();
        }
        if (eVarPoll == null) {
            eVarPoll = new e();
        }
        eVarPoll.h(inputStream);
        return eVarPoll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f52676a.available();
    }

    @p0
    public IOException c() {
        return this.f52677b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f52676a.close();
    }

    public void f() {
        this.f52677b = null;
        this.f52676a = null;
        Queue<e> queue = f52675c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public void h(@n0 InputStream inputStream) {
        this.f52676a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f52676a.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f52676a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f52676a.read();
        } catch (IOException e10) {
            this.f52677b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f52676a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        try {
            return this.f52676a.skip(j10);
        } catch (IOException e10) {
            this.f52677b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f52676a.read(bArr);
        } catch (IOException e10) {
            this.f52677b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            return this.f52676a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f52677b = e10;
            throw e10;
        }
    }
}
