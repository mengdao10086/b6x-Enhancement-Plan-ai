package af;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuilder f606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Charset f608c;

    public i() {
        this.f608c = StandardCharsets.ISO_8859_1;
        this.f606a = new StringBuilder();
    }

    public void a(byte b10) {
        this.f606a.append((char) (b10 & 255));
    }

    public void b(char c10) {
        this.f606a.append((char) (c10 & 255));
    }

    public void c(int i10) {
        d(String.valueOf(i10));
    }

    public void d(String str) {
        this.f606a.append(str);
    }

    public void e(StringBuilder sb2) {
        g();
        this.f607b.append((CharSequence) sb2);
    }

    public void f(int i10) throws FormatException {
        g();
        CharacterSetECI characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(i10);
        if (characterSetECIByValue == null) {
            throw FormatException.b();
        }
        this.f608c = characterSetECIByValue.getCharset();
    }

    public final void g() {
        if (this.f608c.equals(StandardCharsets.ISO_8859_1)) {
            if (this.f606a.length() > 0) {
                StringBuilder sb2 = this.f607b;
                if (sb2 == null) {
                    this.f607b = this.f606a;
                    this.f606a = new StringBuilder();
                    return;
                } else {
                    sb2.append((CharSequence) this.f606a);
                    this.f606a = new StringBuilder();
                    return;
                }
            }
            return;
        }
        if (this.f606a.length() > 0) {
            byte[] bytes = this.f606a.toString().getBytes(StandardCharsets.ISO_8859_1);
            this.f606a = new StringBuilder();
            StringBuilder sb3 = this.f607b;
            if (sb3 == null) {
                this.f607b = new StringBuilder(new String(bytes, this.f608c));
            } else {
                sb3.append(new String(bytes, this.f608c));
            }
        }
    }

    public boolean h() {
        StringBuilder sb2;
        return this.f606a.length() == 0 && ((sb2 = this.f607b) == null || sb2.length() == 0);
    }

    public int i() {
        return toString().length();
    }

    public String toString() {
        g();
        StringBuilder sb2 = this.f607b;
        return sb2 == null ? "" : sb2.toString();
    }

    public i(int i10) {
        this.f608c = StandardCharsets.ISO_8859_1;
        this.f606a = new StringBuilder(i10);
    }
}
