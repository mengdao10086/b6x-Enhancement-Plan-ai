package xc;

import android.text.TextUtils;
import com.google.common.collect.ImmutableSet;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55041d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55042e = -2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f55043f = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ImmutableSet<String> f55044g = ImmutableSet.of("auto", "none");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ImmutableSet<String> f55045h = ImmutableSet.of(d.f55102w0, d.f55104x0, d.f55106y0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ImmutableSet<String> f55046i = ImmutableSet.of(d.f55108z0, d.A0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ImmutableSet<String> f55047j = ImmutableSet.of(d.f55072c0, d.f55071b0, d.f55073d0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f55049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f55050c;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public b(int i10, int i11, int i12) {
        this.f55048a = i10;
        this.f55049b = i11;
        this.f55050c = i12;
    }

    @p0
    public static b a(@p0 String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.copyOf(TextUtils.split(strTrim, f55043f)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static xc.b b(com.google.common.collect.ImmutableSet<java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xc.b.b(com.google.common.collect.ImmutableSet):xc.b");
    }
}
