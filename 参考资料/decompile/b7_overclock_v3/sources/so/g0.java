package so;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class g0 implements d0, h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f50176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f50177b = false;

    public g0(InputStream inputStream) {
        this.f50176a = inputStream;
    }

    @Override // so.d0
    public Object b() {
        return c();
    }

    @Override // so.h0
    public InputStream c() {
        e();
        return this.f50176a;
    }

    @Override // so.d0
    public void d(OutputStream outputStream) throws CMSException, IOException {
        e();
        kt.c.b(this.f50176a, outputStream);
        this.f50176a.close();
    }

    public final synchronized void e() {
        if (this.f50177b) {
            throw new IllegalStateException("CMSProcessableInputStream can only be used once");
        }
        this.f50177b = true;
    }
}
