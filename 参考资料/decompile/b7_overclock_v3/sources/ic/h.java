package ic;

import android.net.Uri;
import g.p0;
import hd.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f32078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f32079d;

    public h(@p0 String str, long j10, long j11) {
        this.f32078c = str == null ? "" : str;
        this.f32076a = j10;
        this.f32077b = j11;
    }

    @p0
    public h a(@p0 h hVar, String str) {
        String strC = c(str);
        if (hVar != null && strC.equals(hVar.c(str))) {
            long j10 = this.f32077b;
            if (j10 != -1) {
                long j11 = this.f32076a;
                if (j11 + j10 == hVar.f32076a) {
                    long j12 = hVar.f32077b;
                    return new h(strC, j11, j12 != -1 ? j10 + j12 : -1L);
                }
            }
            long j13 = hVar.f32077b;
            if (j13 != -1) {
                long j14 = hVar.f32076a;
                if (j14 + j13 == this.f32076a) {
                    return new h(strC, j14, j10 != -1 ? j13 + j10 : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return s0.e(str, this.f32078c);
    }

    public String c(String str) {
        return s0.d(str, this.f32078c);
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f32076a == hVar.f32076a && this.f32077b == hVar.f32077b && this.f32078c.equals(hVar.f32078c);
    }

    public int hashCode() {
        if (this.f32079d == 0) {
            this.f32079d = ((((527 + ((int) this.f32076a)) * 31) + ((int) this.f32077b)) * 31) + this.f32078c.hashCode();
        }
        return this.f32079d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f32078c + ", start=" + this.f32076a + ", length=" + this.f32077b + ee.a.f26979d;
    }
}
