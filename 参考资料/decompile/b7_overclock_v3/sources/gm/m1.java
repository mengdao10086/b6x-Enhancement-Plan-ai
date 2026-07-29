package gm;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class m1 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f29742a;

    public m1(j0 j0Var) {
        this.f29742a = j0Var;
    }

    public static l1 c(j0 j0Var) throws IOException {
        return new l1(j0Var.k());
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
        return c(this.f29742a);
    }

    @Override // gm.i0
    public h readObject() throws IOException {
        return this.f29742a.j();
    }
}
