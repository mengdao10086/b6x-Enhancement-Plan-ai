package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes7.dex */
public final class m extends c {
    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            char cD = hVar.d();
            hVar.f21324f++;
            d(cD, sb2);
            if (sb2.length() % 3 == 0) {
                c.h(hVar, sb2);
                if (j.p(hVar.e(), hVar.f21324f, a()) != a()) {
                    hVar.p(0);
                    break;
                }
            }
        }
        g(hVar, sb2);
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    public int d(char c10, StringBuilder sb2) {
        if (c10 == '\r') {
            sb2.append((char) 0);
        } else if (c10 == ' ') {
            sb2.append((char) 3);
        } else if (c10 == '*') {
            sb2.append((char) 1);
        } else if (c10 == '>') {
            sb2.append((char) 2);
        } else if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) ((c10 - '0') + 4));
        } else if (c10 < 'A' || c10 > 'Z') {
            j.g(c10);
        } else {
            sb2.append((char) ((c10 - 'A') + 14));
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    public void g(h hVar, StringBuilder sb2) {
        hVar.q();
        int iB = hVar.h().b() - hVar.a();
        hVar.f21324f -= sb2.length();
        if (hVar.g() > 1 || iB > 1 || hVar.g() != iB) {
            hVar.s((char) 254);
        }
        if (hVar.f() < 0) {
            hVar.p(0);
        }
    }
}
