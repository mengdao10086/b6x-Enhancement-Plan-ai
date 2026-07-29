package so;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class e0 implements r0, h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.y f50157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f50158b;

    public e0(gm.y yVar, byte[] bArr) {
        this.f50157a = yVar;
        this.f50158b = bArr;
    }

    public e0(byte[] bArr) {
        this(mm.k.I2, bArr);
    }

    @Override // so.r0
    public gm.y a() {
        return this.f50157a;
    }

    @Override // so.d0
    public Object b() {
        return org.bouncycastle.util.a.p(this.f50158b);
    }

    @Override // so.h0
    public InputStream c() {
        return new ByteArrayInputStream(this.f50158b);
    }

    @Override // so.d0
    public void d(OutputStream outputStream) throws CMSException, IOException {
        outputStream.write(this.f50158b);
    }
}
