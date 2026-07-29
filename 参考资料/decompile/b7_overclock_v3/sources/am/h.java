package am;

import java.lang.reflect.Method;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¨\u0006\u000e"}, d2 = {"Lam/h;", "", "", "closer", "a", "closeGuardInstance", "", "b", "Ljava/lang/reflect/Method;", "getMethod", "openMethod", "warnIfOpenMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f792d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final Method f793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final Method f794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final Method f795c;

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lam/h$a;", "", "Lam/h;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final h a() throws NoSuchMethodException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod(xc.d.A0, String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new h(method3, method2, method);
        }
    }

    public h(@yt.l Method method, @yt.l Method method2, @yt.l Method method3) {
        this.f793a = method;
        this.f794b = method2;
        this.f795c = method3;
    }

    @yt.l
    public final Object a(@yt.k String closer) {
        f0.p(closer, "closer");
        Method method = this.f793a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, new Object[0]);
                Method method2 = this.f794b;
                f0.m(method2);
                method2.invoke(objInvoke, closer);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean b(@yt.l Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.f795c;
            f0.m(method);
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
