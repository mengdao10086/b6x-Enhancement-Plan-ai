package hb;

import com.google.android.exoplayer2.Format;
import g.p0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public interface d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30819a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30820b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f30821c = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f30823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f30824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f30825d;

        public a(int i10, byte[] bArr, int i11, int i12) {
            this.f30822a = i10;
            this.f30823b = bArr;
            this.f30824c = i11;
            this.f30825d = i12;
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f30822a == aVar.f30822a && this.f30824c == aVar.f30824c && this.f30825d == aVar.f30825d && Arrays.equals(this.f30823b, aVar.f30823b);
        }

        public int hashCode() {
            return (((((this.f30822a * 31) + Arrays.hashCode(this.f30823b)) * 31) + this.f30824c) * 31) + this.f30825d;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    void a(long j10, int i10, int i11, int i12, @p0 a aVar);

    int b(ed.h hVar, int i10, boolean z10, int i11) throws IOException;

    void c(hd.c0 c0Var, int i10, int i11);

    void d(hd.c0 c0Var, int i10);

    int e(ed.h hVar, int i10, boolean z10) throws IOException;

    void f(Format format);
}
