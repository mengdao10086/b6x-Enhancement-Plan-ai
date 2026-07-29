package okhttp3.internal.cache;

import ik.l;
import java.io.EOFException;
import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import okio.j;
import okio.r0;
import okio.t;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lokhttp3/internal/cache/d;", "Lokio/t;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "close", "", "c", "Z", "hasErrors", "Lkotlin/Function1;", "Ljava/io/IOException;", "onException", "Lik/l;", "d", "()Lik/l;", "Lokio/r0;", "delegate", "<init>", "(Lokio/r0;Lik/l;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public class d extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final l<IOException, z1> f43768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f43769c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@k r0 delegate, @k l<? super IOException, z1> onException) {
        super(delegate);
        f0.p(delegate, "delegate");
        f0.p(onException, "onException");
        this.f43768b = onException;
    }

    @Override // okio.t, okio.r0
    public void V0(@k j source, long j10) throws EOFException {
        f0.p(source, "source");
        if (this.f43769c) {
            source.skip(j10);
            return;
        }
        try {
            super.V0(source, j10);
        } catch (IOException e10) {
            this.f43769c = true;
            this.f43768b.i(e10);
        }
    }

    @Override // okio.t, okio.r0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f43769c) {
            return;
        }
        try {
            super.close();
        } catch (IOException e10) {
            this.f43769c = true;
            this.f43768b.i(e10);
        }
    }

    @k
    public final l<IOException, z1> d() {
        return this.f43768b;
    }

    @Override // okio.t, okio.r0, java.io.Flushable
    public void flush() {
        if (this.f43769c) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e10) {
            this.f43769c = true;
            this.f43768b.i(e10);
        }
    }
}
