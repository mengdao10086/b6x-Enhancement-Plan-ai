package id;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import g.p0;
import hd.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f32158c;

    public c(int i10, int i11, String str) {
        this.f32156a = i10;
        this.f32157b = i11;
        this.f32158c = str;
    }

    @p0
    public static c a(c0 c0Var) {
        String str;
        c0Var.T(2);
        int iG = c0Var.G();
        int i10 = iG >> 1;
        int iG2 = ((c0Var.G() >> 3) & 31) | ((iG & 1) << 5);
        if (i10 == 4 || i10 == 5 || i10 == 7) {
            str = "dvhe";
        } else if (i10 == 8) {
            str = MediaCodecUtil.f17176g;
        } else {
            if (i10 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".0");
        sb2.append(i10);
        sb2.append(iG2 >= 10 ? j3.b.f36044h : ".0");
        sb2.append(iG2);
        return new c(i10, iG2, sb2.toString());
    }
}
