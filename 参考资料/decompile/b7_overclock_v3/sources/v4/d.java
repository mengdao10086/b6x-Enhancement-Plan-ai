package v4;

import g.n0;
import g.p0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class d extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Queue<d> f52672c = o.f(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f52673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IOException f52674b;

    public static void a() {
        while (true) {
            Queue<d> queue = f52672c;
            if (queue.isEmpty()) {
                return;
            } else {
                queue.remove();
            }
        }
    }

    @n0
    public static d d(@n0 InputStream inputStream) {
        d dVarPoll;
        Queue<d> queue = f52672c;
        synchronized (queue) {
            dVarPoll = queue.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.h(inputStream);
        return dVarPoll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f52673a.available();
    }

    @p0
    public IOException c() {
        return this.f52674b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f52673a.close();
    }

    public void f() {
        this.f52674b = null;
        this.f52673a = null;
        Queue<d> queue = f52672c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public void h(@n0 InputStream inputStream) {
        this.f52673a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f52673a.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f52673a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f52673a.read(bArr);
        } catch (IOException e10) {
            this.f52674b = e10;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f52673a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) {
        try {
            return this.f52673a.skip(j10);
        } catch (IOException e10) {
            this.f52674b = e10;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        try {
            return this.f52673a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f52674b = e10;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f52673a.read();
        } catch (IOException e10) {
            this.f52674b = e10;
            return -1;
        }
    }
}
