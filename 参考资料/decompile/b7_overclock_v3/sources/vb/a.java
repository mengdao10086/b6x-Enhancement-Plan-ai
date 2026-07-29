package vb;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.common.base.Charsets;
import g.p0;
import hd.b0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import ub.d;
import ub.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f52918a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f52919b = 21;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f52920c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f52921d = 116;

    @p0
    public static Metadata c(b0 b0Var) {
        b0Var.s(12);
        int iD = (b0Var.d() + b0Var.h(12)) - 4;
        b0Var.s(44);
        b0Var.t(b0Var.h(12));
        b0Var.s(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strM = null;
            if (b0Var.d() >= iD) {
                break;
            }
            b0Var.s(48);
            int iH = b0Var.h(8);
            b0Var.s(4);
            int iD2 = b0Var.d() + b0Var.h(12);
            String strM2 = null;
            while (b0Var.d() < iD2) {
                int iH2 = b0Var.h(8);
                int iH3 = b0Var.h(8);
                int iD3 = b0Var.d() + iH3;
                if (iH2 == 2) {
                    int iH4 = b0Var.h(16);
                    b0Var.s(8);
                    if (iH4 == 3) {
                        while (b0Var.d() < iD3) {
                            strM = b0Var.m(b0Var.h(8), Charsets.US_ASCII);
                            int iH5 = b0Var.h(8);
                            for (int i10 = 0; i10 < iH5; i10++) {
                                b0Var.t(b0Var.h(8));
                            }
                        }
                    }
                } else if (iH2 == 21) {
                    strM2 = b0Var.m(iH3, Charsets.US_ASCII);
                }
                b0Var.q(iD3 * 8);
            }
            b0Var.q(iD2 * 8);
            if (strM != null && strM2 != null) {
                arrayList.add(new AppInfoTable(iH, strM + strM2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // ub.f
    @p0
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new b0(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
