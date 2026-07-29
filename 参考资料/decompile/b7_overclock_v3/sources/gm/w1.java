package gm;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class w1 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f29818a;

    public w1(j0 j0Var) {
        this.f29818a = j0Var;
    }

    public static w2 c(j0 j0Var) throws IOException {
        try {
            return new w2(j0Var.k());
        } catch (IllegalArgumentException e10) {
            throw new ASN1Exception(e10.getMessage(), e10);
        }
    }

    @Override // gm.h
    public c0 b() {
        try {
            return o();
        } catch (IOException e10) {
            throw new ASN1ParsingException("unable to get DER object", e10);
        } catch (IllegalArgumentException e11) {
            throw new ASN1ParsingException("unable to get DER object", e11);
        }
    }

    @Override // gm.h3
    public c0 o() throws IOException {
        return c(this.f29818a);
    }

    @Override // gm.m
    public h readObject() throws IOException {
        return this.f29818a.j();
    }
}
