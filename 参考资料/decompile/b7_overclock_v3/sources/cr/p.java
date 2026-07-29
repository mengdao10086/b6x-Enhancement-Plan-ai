package cr;

import java.security.spec.EncodedKeySpec;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class p extends EncodedKeySpec {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f25845b = {org.bouncycastle.crypto.util.h.f44738a, org.bouncycastle.crypto.util.h.f44740c, org.bouncycastle.crypto.util.h.f44741d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25846a;

    public p(byte[] bArr) {
        super(bArr);
        int i10 = 0;
        int i11 = (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) + 4;
        if (i11 >= bArr.length) {
            throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
        }
        String strC = Strings.c(org.bouncycastle.util.a.W(bArr, 4, i11));
        this.f25846a = strC;
        if (strC.startsWith(org.bouncycastle.crypto.util.h.f44739b)) {
            return;
        }
        while (true) {
            String[] strArr = f25845b;
            if (i10 >= strArr.length) {
                throw new IllegalArgumentException("unrecognised public key type " + this.f25846a);
            }
            if (strArr[i10].equals(this.f25846a)) {
                return;
            } else {
                i10++;
            }
        }
    }

    public String a() {
        return this.f25846a;
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return "OpenSSH";
    }
}
