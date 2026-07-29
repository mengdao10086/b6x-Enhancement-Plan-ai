package v0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.RestrictTo;
import androidx.core.util.o;
import g.f0;
import g.i1;
import g.n0;
import g.p0;
import g.v0;
import j0.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import m0.d0;
import m0.w;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static final String f52485a = "font_results";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static final int f52486b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static final int f52487c = -2;

    public static final class a implements BaseColumns {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f52488a = "file_id";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f52489b = "font_ttc_index";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f52490c = "font_variation_settings";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f52491d = "font_weight";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f52492e = "font_italic";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f52493f = "result_code";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f52494g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f52495h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f52496i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f52497j = 3;
    }

    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f52498c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f52499d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f52500e = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f52501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f52502b;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public b(int i10, @p0 c[] cVarArr) {
            this.f52501a = i10;
            this.f52502b = cVarArr;
        }

        public static b a(int i10, @p0 c[] cVarArr) {
            return new b(i10, cVarArr);
        }

        public c[] b() {
            return this.f52502b;
        }

        public int c() {
            return this.f52501a;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f52503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f52504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f52505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f52506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f52507e;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public c(@n0 Uri uri, @f0(from = 0) int i10, @f0(from = 1, to = 1000) int i11, boolean z10, int i12) {
            this.f52503a = (Uri) o.l(uri);
            this.f52504b = i10;
            this.f52505c = i11;
            this.f52506d = z10;
            this.f52507e = i12;
        }

        public static c a(@n0 Uri uri, @f0(from = 0) int i10, @f0(from = 1, to = 1000) int i11, boolean z10, int i12) {
            return new c(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f52507e;
        }

        @f0(from = 0)
        public int c() {
            return this.f52504b;
        }

        @n0
        public Uri d() {
            return this.f52503a;
        }

        @f0(from = 1, to = 1000)
        public int e() {
            return this.f52505c;
        }

        public boolean f() {
            return this.f52506d;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static final int f52508a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f52509b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f52510c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f52511d = -2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f52512e = -3;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f52513f = -4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f52514g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f52515h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f52516i = 3;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface a {
        }

        public void a(int i10) {
        }

        public void b(Typeface typeface) {
        }
    }

    @p0
    public static Typeface a(@n0 Context context, @p0 CancellationSignal cancellationSignal, @n0 c[] cVarArr) {
        return w.d(context, cancellationSignal, cVarArr, 0);
    }

    @n0
    public static b b(@n0 Context context, @p0 CancellationSignal cancellationSignal, @n0 f fVar) throws PackageManager.NameNotFoundException {
        return e.e(context, fVar, cancellationSignal);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface c(Context context, f fVar, @p0 i.g gVar, @p0 Handler handler, boolean z10, int i10, int i11) {
        return f(context, fVar, i11, z10, i10, i.g.e(handler), new w.a(gVar));
    }

    @Deprecated
    @i1
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ProviderInfo d(@n0 PackageManager packageManager, @n0 f fVar, @p0 Resources resources) throws PackageManager.NameNotFoundException {
        return e.f(packageManager, fVar, resources);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @v0(19)
    @Deprecated
    public static Map<Uri, ByteBuffer> e(Context context, c[] cVarArr, CancellationSignal cancellationSignal) {
        return d0.h(context, cVarArr, cancellationSignal);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface f(@n0 Context context, @n0 f fVar, int i10, boolean z10, @f0(from = 0) int i11, @n0 Handler handler, @n0 d dVar) {
        v0.a aVar = new v0.a(dVar, handler);
        return z10 ? g.e(context, fVar, aVar, i10, i11) : g.d(context, fVar, i10, null, aVar);
    }

    public static void g(@n0 Context context, @n0 f fVar, @n0 d dVar, @n0 Handler handler) {
        v0.a aVar = new v0.a(dVar);
        g.d(context.getApplicationContext(), fVar, 0, i.b(handler), aVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static void h() {
        g.f();
    }

    @i1
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void i() {
        g.f();
    }
}
