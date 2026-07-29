package so;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f50365a;

    public z1(cs.s sVar) {
        this.f50365a = sVar;
    }

    public z1(cs.y yVar) {
        this.f50365a = yVar;
    }

    public OutputStream a() {
        return ((cs.r) this.f50365a).c();
    }

    public InputStream b(InputStream inputStream) {
        Object obj = this.f50365a;
        return obj instanceof cs.s ? ((cs.s) obj).b(inputStream) : new kt.d(inputStream, ((cs.y) this.f50365a).b());
    }

    public byte[] c() {
        return ((cs.y) this.f50365a).d();
    }

    public boolean d() {
        return this.f50365a instanceof cs.r;
    }

    public boolean e() {
        return this.f50365a instanceof cs.y;
    }
}
