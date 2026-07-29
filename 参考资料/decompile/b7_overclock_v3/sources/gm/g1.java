package gm;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class g1 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f29691a;

    public g1(j0 j0Var) {
        this.f29691a = j0Var;
    }

    public static e1 c(j0 j0Var) throws IOException {
        return new e1(kt.c.e(new r1(j0Var)));
    }

    @Override // gm.a0
    public InputStream a() {
        return new r1(this.f29691a);
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
        return c(this.f29691a);
    }
}
