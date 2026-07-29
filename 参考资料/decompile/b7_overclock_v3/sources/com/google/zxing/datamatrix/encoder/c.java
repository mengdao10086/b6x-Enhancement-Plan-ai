package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes7.dex */
public class c implements g {
    public static String f(CharSequence charSequence) {
        int iCharAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * '(') + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    public static void h(h hVar, StringBuilder sb2) {
        hVar.t(f(sb2));
        sb2.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            char cD = hVar.d();
            hVar.f21324f++;
            int iD = d(cD, sb2);
            int iA = hVar.a() + ((sb2.length() / 3) * 2);
            hVar.r(iA);
            int iB = hVar.h().b() - iA;
            if (!hVar.j()) {
                StringBuilder sb3 = new StringBuilder();
                if (sb2.length() % 3 == 2 && iB != 2) {
                    iD = c(hVar, sb2, sb3, iD);
                }
                while (sb2.length() % 3 == 1 && (iD > 3 || iB != 1)) {
                    iD = c(hVar, sb2, sb3, iD);
                }
            } else if (sb2.length() % 3 == 0 && j.p(hVar.e(), hVar.f21324f, a()) != a()) {
                hVar.p(0);
                break;
            }
        }
        g(hVar, sb2);
    }

    public final int c(h hVar, StringBuilder sb2, StringBuilder sb3, int i10) {
        int length = sb2.length();
        sb2.delete(length - i10, length);
        hVar.f21324f--;
        int iD = d(hVar.d(), sb3);
        hVar.l();
        return iD;
    }

    public int d(char c10, StringBuilder sb2) {
        if (c10 == ' ') {
            sb2.append((char) 3);
            return 1;
        }
        if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) ((c10 - '0') + 4));
            return 1;
        }
        if (c10 >= 'A' && c10 <= 'Z') {
            sb2.append((char) ((c10 - 'A') + 14));
            return 1;
        }
        if (c10 < ' ') {
            sb2.append((char) 0);
            sb2.append(c10);
            return 2;
        }
        if (c10 <= '/') {
            sb2.append((char) 1);
            sb2.append((char) (c10 - '!'));
            return 2;
        }
        if (c10 <= '@') {
            sb2.append((char) 1);
            sb2.append((char) ((c10 - ':') + 15));
            return 2;
        }
        if (c10 <= '_') {
            sb2.append((char) 1);
            sb2.append((char) ((c10 - '[') + 22));
            return 2;
        }
        if (c10 > 127) {
            sb2.append("\u0001\u001e");
            return d((char) (c10 - 128), sb2) + 2;
        }
        sb2.append((char) 2);
        sb2.append((char) (c10 - '`'));
        return 2;
    }

    public void e(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = hVar.f21324f;
        int length = 0;
        int iD = 0;
        while (hVar.j()) {
            char cD = hVar.d();
            hVar.f21324f++;
            iD = d(cD, sb2);
            if (sb2.length() % 3 == 0) {
                i10 = hVar.f21324f;
                length = sb2.length();
            }
        }
        if (length != sb2.length()) {
            int iA = hVar.a() + ((sb2.length() / 3) * 2) + 1;
            hVar.r(iA);
            int iB = hVar.h().b() - iA;
            int length2 = sb2.length() % 3;
            if ((length2 == 2 && iB != 2) || (length2 == 1 && (iD > 3 || iB != 1))) {
                sb2.setLength(length);
                hVar.f21324f = i10;
            }
        }
        if (sb2.length() > 0) {
            hVar.s(j.f21334b);
        }
        g(hVar, sb2);
    }

    public void g(h hVar, StringBuilder sb2) {
        int length = (sb2.length() / 3) * 2;
        int length2 = sb2.length() % 3;
        int iA = hVar.a() + length;
        hVar.r(iA);
        int iB = hVar.h().b() - iA;
        if (length2 == 2) {
            sb2.append((char) 0);
            while (sb2.length() >= 3) {
                h(hVar, sb2);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
        } else if (iB == 1 && length2 == 1) {
            while (sb2.length() >= 3) {
                h(hVar, sb2);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
            hVar.f21324f--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb2.length() >= 3) {
                h(hVar, sb2);
            }
            if (iB > 0 || hVar.j()) {
                hVar.s((char) 254);
            }
        }
        hVar.p(0);
    }
}
