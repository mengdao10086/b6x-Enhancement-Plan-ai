package gm;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class g2 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g3 f29692a;

    public g2(g3 g3Var) {
        this.f29692a = g3Var;
    }

    @Override // gm.a0
    public InputStream a() {
        return this.f29692a;
    }

    @Override // gm.h
    public c0 b() {
        try {
            return o();
        } catch (IOException e10) {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }

    @Override // gm.h3
    public c0 o() throws IOException {
        return new f2(this.f29692a.h());
    }
}
