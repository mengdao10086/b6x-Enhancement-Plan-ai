package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements g {
    public static void c(char c10, StringBuilder sb2) {
        if (c10 >= ' ' && c10 <= '?') {
            sb2.append(c10);
        } else if (c10 < '@' || c10 > '^') {
            j.g(c10);
        } else {
            sb2.append((char) (c10 - '@'));
        }
    }

    public static String d(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(0) << 18) + ((length >= 2 ? charSequence.charAt(1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(3) : (char) 0);
        char c10 = (char) ((iCharAt >> 16) & 255);
        char c11 = (char) ((iCharAt >> 8) & 255);
        char c12 = (char) (iCharAt & 255);
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append(c10);
        if (length >= 2) {
            sb2.append(c11);
        }
        if (length >= 3) {
            sb2.append(c12);
        }
        return sb2.toString();
    }

    public static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z10 = true;
            if (length == 1) {
                hVar.q();
                int iB = hVar.h().b() - hVar.a();
                int iG = hVar.g();
                if (iG > iB) {
                    hVar.r(hVar.a() + 1);
                    iB = hVar.h().b() - hVar.a();
                }
                if (iG <= iB && iB <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i10 = length - 1;
            String strD = d(charSequence);
            if (!(!hVar.j()) || i10 > 2) {
                z10 = false;
            }
            if (i10 <= 2) {
                hVar.r(hVar.a() + i10);
                if (hVar.h().b() - hVar.a() >= 3) {
                    hVar.r(hVar.a() + strD.length());
                    z10 = false;
                }
            }
            if (z10) {
                hVar.l();
                hVar.f21324f -= i10;
            } else {
                hVar.t(strD);
            }
        } finally {
            hVar.p(0);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 4;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            c(hVar.d(), sb2);
            hVar.f21324f++;
            if (sb2.length() >= 4) {
                hVar.t(d(sb2));
                sb2.delete(0, 4);
                if (j.p(hVar.e(), hVar.f21324f, a()) != a()) {
                    hVar.p(0);
                    break;
                }
            }
        }
        sb2.append((char) 31);
        e(hVar, sb2);
    }
}
