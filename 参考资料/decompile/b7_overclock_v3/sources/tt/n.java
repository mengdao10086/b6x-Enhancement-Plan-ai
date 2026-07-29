package tt;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes6.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f51697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadMode f51698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f51699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f51701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f51702f;

    public n(Method method, Class<?> cls, ThreadMode threadMode, int i10, boolean z10) {
        this.f51697a = method;
        this.f51698b = threadMode;
        this.f51699c = cls;
        this.f51700d = i10;
        this.f51701e = z10;
    }

    public final synchronized void a() {
        if (this.f51702f == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.f51697a.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.f51697a.getName());
            sb2.append('(');
            sb2.append(this.f51699c.getName());
            this.f51702f = sb2.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        a();
        n nVar = (n) obj;
        nVar.a();
        return this.f51702f.equals(nVar.f51702f);
    }

    public int hashCode() {
        return this.f51697a.hashCode();
    }
}
