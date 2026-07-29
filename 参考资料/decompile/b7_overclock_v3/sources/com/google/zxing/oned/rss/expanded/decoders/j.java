package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes7.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.a f21484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f21485b;

    public j(af.a aVar) {
        this.f21484a = aVar;
        this.f21485b = new r(aVar);
    }

    public static j a(af.a aVar) {
        if (aVar.h(1)) {
            return new g(aVar);
        }
        if (!aVar.h(2)) {
            return new k(aVar);
        }
        int iG = r.g(aVar, 1, 4);
        if (iG == 4) {
            return new a(aVar);
        }
        if (iG == 5) {
            return new b(aVar);
        }
        int iG2 = r.g(aVar, 1, 5);
        if (iG2 == 12) {
            return new c(aVar);
        }
        if (iG2 == 13) {
            return new d(aVar);
        }
        switch (r.g(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            case 57:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            case 58:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_WPA_STATE);
            case 61:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_WPA_STATE);
            case 62:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_START_GROUP);
            case 63:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_START_GROUP);
            default:
                throw new IllegalStateException("unknown decoder: " + aVar);
        }
    }

    public final r b() {
        return this.f21485b;
    }

    public final af.a c() {
        return this.f21484a;
    }

    public abstract String d() throws NotFoundException, FormatException;
}
