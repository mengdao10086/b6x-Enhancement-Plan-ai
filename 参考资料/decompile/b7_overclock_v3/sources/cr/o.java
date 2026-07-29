package cr;

import java.security.spec.EncodedKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class o extends EncodedKeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25844a;

    public o(byte[] bArr) {
        String str;
        super(bArr);
        if (bArr[0] == 48) {
            str = "ASN.1";
        } else {
            if (bArr[0] != 111) {
                throw new IllegalArgumentException("unknown byte encoding");
            }
            str = "OpenSSH";
        }
        this.f25844a = str;
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return this.f25844a;
    }
}
