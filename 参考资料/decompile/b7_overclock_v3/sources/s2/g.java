package s2;

import android.content.Context;
import androidx.annotation.RestrictTo;
import g.i1;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static g f49440e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f49441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f49442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f49443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f49444d;

    public g(@n0 Context context, @n0 w2.a taskExecutor) {
        Context applicationContext = context.getApplicationContext();
        this.f49441a = new a(applicationContext, taskExecutor);
        this.f49442b = new b(applicationContext, taskExecutor);
        this.f49443c = new e(applicationContext, taskExecutor);
        this.f49444d = new f(applicationContext, taskExecutor);
    }

    @n0
    public static synchronized g c(Context context, w2.a taskExecutor) {
        if (f49440e == null) {
            f49440e = new g(context, taskExecutor);
        }
        return f49440e;
    }

    @i1
    public static synchronized void f(@n0 g trackers) {
        f49440e = trackers;
    }

    @n0
    public a a() {
        return this.f49441a;
    }

    @n0
    public b b() {
        return this.f49442b;
    }

    @n0
    public e d() {
        return this.f49443c;
    }

    @n0
    public f e() {
        return this.f49444d;
    }
}
