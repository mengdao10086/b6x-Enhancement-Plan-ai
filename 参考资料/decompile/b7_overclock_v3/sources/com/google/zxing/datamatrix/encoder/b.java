package com.google.zxing.datamatrix.encoder;

import com.flydigi.sdk.waspwing.WaspWingInfo;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements g {
    public static char c(char c10, int i10) {
        int i11 = c10 + ((i10 * WaspWingInfo.COLD_LEVEL_STANDARD_B7) % 255) + 1;
        return i11 <= 255 ? (char) i11 : (char) (i11 - 256);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 5;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) 0);
        while (true) {
            if (!hVar.j()) {
                break;
            }
            sb2.append(hVar.d());
            hVar.f21324f++;
            if (j.p(hVar.e(), hVar.f21324f, a()) != a()) {
                hVar.p(0);
                break;
            }
        }
        int length = sb2.length() - 1;
        int iA = hVar.a() + length + 1;
        hVar.r(iA);
        boolean z10 = hVar.h().b() - iA > 0;
        if (hVar.j() || z10) {
            if (length <= 249) {
                sb2.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb2.setCharAt(0, (char) ((length / 250) + a4.d.f205j));
                sb2.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb2.length();
        for (int i10 = 0; i10 < length2; i10++) {
            hVar.s(c(sb2.charAt(i10), hVar.a() + 1));
        }
    }
}
