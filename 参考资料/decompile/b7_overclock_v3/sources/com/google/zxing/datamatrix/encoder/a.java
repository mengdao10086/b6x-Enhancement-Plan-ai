package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements g {
    public static char c(char c10, char c11) {
        if (j.h(c10) && j.h(c11)) {
            return (char) (((c10 - '0') * 10) + (c11 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c10 + c11);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 0;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        if (j.a(hVar.e(), hVar.f21324f) >= 2) {
            hVar.s(c(hVar.e().charAt(hVar.f21324f), hVar.e().charAt(hVar.f21324f + 1)));
            hVar.f21324f += 2;
            return;
        }
        char cD = hVar.d();
        int iP = j.p(hVar.e(), hVar.f21324f, a());
        if (iP == a()) {
            if (!j.i(cD)) {
                hVar.s((char) (cD + 1));
                hVar.f21324f++;
                return;
            } else {
                hVar.s(j.f21336d);
                hVar.s((char) ((cD - 128) + 1));
                hVar.f21324f++;
                return;
            }
        }
        if (iP == 1) {
            hVar.s(j.f21334b);
            hVar.p(1);
            return;
        }
        if (iP == 2) {
            hVar.s(j.f21340h);
            hVar.p(2);
            return;
        }
        if (iP == 3) {
            hVar.s(j.f21339g);
            hVar.p(3);
            return;
        }
        if (iP == 4) {
            hVar.s(j.f21341i);
            hVar.p(4);
        } else if (iP == 5) {
            hVar.s(j.f21335c);
            hVar.p(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + iP);
        }
    }
}
