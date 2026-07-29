package gm;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class c3 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f29648a;

    public c3(j0 j0Var) {
        this.f29648a = j0Var;
    }

    @Override // gm.h
    public c0 b() {
        try {
            return o();
        } catch (IOException e10) {
            throw new ASN1ParsingException(e10.getMessage(), e10);
        }
    }

    @Override // gm.h3
    public c0 o() throws IOException {
        return x2.b(this.f29648a.k());
    }

    @Override // gm.i0
    public h readObject() throws IOException {
        return this.f29648a.j();
    }
}
