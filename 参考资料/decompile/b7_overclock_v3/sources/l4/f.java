package l4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.s;
import g.n0;
import g.p0;
import g.v;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f implements c4.f<Uri, Drawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f39447b = "android";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39448c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39449d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f39450e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f39451f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f39452g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f39453h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39454a;

    public f(Context context) {
        this.f39454a = context.getApplicationContext();
    }

    @Override // c4.f
    @p0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public s<Drawable> b(@n0 Uri uri, int i10, int i11, @n0 c4.e eVar) {
        Context contextD = d(uri, uri.getAuthority());
        return e.f(b.b(this.f39454a, contextD, g(contextD, uri)));
    }

    @n0
    public final Context d(Uri uri, String str) {
        if (str.equals(this.f39454a.getPackageName())) {
            return this.f39454a;
        }
        try {
            return this.f39454a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            if (str.contains(this.f39454a.getPackageName())) {
                return this.f39454a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e10);
        }
    }

    @v
    public final int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e10) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e10);
        }
    }

    @v
    public final int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, f39447b);
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @v
    public final int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // c4.f
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 Uri uri, @n0 c4.e eVar) {
        return uri.getScheme().equals(com.google.android.exoplayer2.upstream.c.f19120t);
    }
}
