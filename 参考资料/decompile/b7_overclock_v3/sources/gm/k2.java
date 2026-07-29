package gm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class k2 extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ByteArrayOutputStream f29727e;

    public k2(OutputStream outputStream) throws IOException {
        super(outputStream);
        this.f29727e = new ByteArrayOutputStream();
    }

    public k2(OutputStream outputStream, int i10, boolean z10) throws IOException {
        super(outputStream, i10, z10);
        this.f29727e = new ByteArrayOutputStream();
    }

    @Override // gm.p
    public OutputStream a() {
        return this.f29727e;
    }

    public void e(h hVar) throws IOException {
        hVar.b().u(this.f29727e, j.f29713a);
    }

    public void f(c0 c0Var) throws IOException {
        c0Var.u(this.f29727e, j.f29713a);
    }

    public void g() throws IOException {
        b(48, this.f29727e.toByteArray());
    }
}
