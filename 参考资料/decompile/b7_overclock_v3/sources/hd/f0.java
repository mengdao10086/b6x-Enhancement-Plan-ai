package hd;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends BufferedOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f30986a;

    public f0(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        a.i(this.f30986a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f30986a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f30986a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        if (th != null) {
            u0.l1(th);
        }
    }

    public f0(OutputStream outputStream, int i10) {
        super(outputStream, i10);
    }
}
