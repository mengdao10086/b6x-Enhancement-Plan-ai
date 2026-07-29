package rb;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f48101a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f48102b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f48103c = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f48104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f48106c;

        public a(String str, int i10, byte[] bArr) {
            this.f48104a = str;
            this.f48105b = i10;
            this.f48106c = bArr;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f48107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final String f48108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<a> f48109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f48110d;

        public b(int i10, @p0 String str, @p0 List<a> list, byte[] bArr) {
            this.f48107a = i10;
            this.f48108b = str;
            this.f48109c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f48110d = bArr;
        }
    }

    public interface c {
        SparseArray<i0> a();

        @p0
        i0 b(int i10, b bVar);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public static final class e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f48111f = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f48112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f48114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f48115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f48116e;

        public e(int i10, int i11) {
            this(Integer.MIN_VALUE, i10, i11);
        }

        public void a() {
            int i10 = this.f48115d;
            this.f48115d = i10 == Integer.MIN_VALUE ? this.f48113b : i10 + this.f48114c;
            this.f48116e = this.f48112a + this.f48115d;
        }

        public String b() {
            d();
            return this.f48116e;
        }

        public int c() {
            d();
            return this.f48115d;
        }

        public final void d() {
            if (this.f48115d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public e(int i10, int i11, int i12) {
            String str;
            if (i10 != Integer.MIN_VALUE) {
                str = i10 + fh.a.f28350w;
            } else {
                str = "";
            }
            this.f48112a = str;
            this.f48113b = i11;
            this.f48114c = i12;
            this.f48115d = Integer.MIN_VALUE;
            this.f48116e = "";
        }
    }

    void a();

    void b(hd.p0 p0Var, hb.m mVar, e eVar);

    void c(hd.c0 c0Var, int i10) throws ParserException;
}
