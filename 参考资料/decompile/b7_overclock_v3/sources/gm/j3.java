package gm;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class j3 implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f29720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f29721b = a();

    public j3(byte[] bArr) {
        this.f29720a = new s(bArr, true);
    }

    public final Object a() {
        try {
            return this.f29720a.n();
        } catch (IOException e10) {
            throw new ASN1ParsingException("malformed ASN.1: " + e10, e10);
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f29721b != null;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object obj = this.f29721b;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        this.f29721b = a();
        return obj;
    }
}
