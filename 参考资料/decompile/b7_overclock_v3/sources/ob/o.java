package ob;

import com.google.android.exoplayer2.Format;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f43273l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f43274m = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f43276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f43277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f43278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f43279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Format f43280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f43281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public final long[] f43282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final long[] f43283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f43284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final p[] f43285k;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public o(int i10, int i11, long j10, long j11, long j12, Format format, int i12, @p0 p[] pVarArr, int i13, @p0 long[] jArr, @p0 long[] jArr2) {
        this.f43275a = i10;
        this.f43276b = i11;
        this.f43277c = j10;
        this.f43278d = j11;
        this.f43279e = j12;
        this.f43280f = format;
        this.f43281g = i12;
        this.f43285k = pVarArr;
        this.f43284j = i13;
        this.f43282h = jArr;
        this.f43283i = jArr2;
    }

    public o a(Format format) {
        return new o(this.f43275a, this.f43276b, this.f43277c, this.f43278d, this.f43279e, format, this.f43281g, this.f43285k, this.f43284j, this.f43282h, this.f43283i);
    }

    @p0
    public p b(int i10) {
        p[] pVarArr = this.f43285k;
        if (pVarArr == null) {
            return null;
        }
        return pVarArr[i10];
    }
}
