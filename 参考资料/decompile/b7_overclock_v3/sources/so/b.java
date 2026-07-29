package so;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class b implements r0, h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.y f50062a;

    public b() {
        this(mm.k.I2);
    }

    public b(gm.y yVar) {
        this.f50062a = yVar;
    }

    @Override // so.r0
    public gm.y a() {
        return this.f50062a;
    }

    @Override // so.d0
    public Object b() {
        return null;
    }

    @Override // so.h0
    public InputStream c() {
        return null;
    }

    @Override // so.d0
    public void d(OutputStream outputStream) throws CMSException, IOException {
    }
}
