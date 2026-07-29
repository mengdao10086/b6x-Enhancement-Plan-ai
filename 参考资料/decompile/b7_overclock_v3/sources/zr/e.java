package zr;

import java.io.IOException;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f59653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f59654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f59655d;

    public e(String str, byte[] bArr, byte[] bArr2, h hVar) {
        this.f59652a = str;
        this.f59653b = bArr;
        this.f59654c = bArr2;
        this.f59655d = hVar;
    }

    public g a(d dVar) throws IOException {
        try {
            return this.f59655d.a(dVar.c(this.f59652a).a(this.f59654c, this.f59653b));
        } catch (IOException e10) {
            throw e10;
        } catch (OperatorCreationException e11) {
            throw new PEMException("cannot create extraction operator: " + e11.getMessage(), e11);
        } catch (Exception e12) {
            throw new PEMException("exception processing key pair: " + e12.getMessage(), e12);
        }
    }

    public String b() {
        return this.f59652a;
    }
}
