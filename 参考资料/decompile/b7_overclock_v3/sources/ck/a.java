package ck;

import bk.l;
import hk.e;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public class a extends l {

    /* JADX INFO: renamed from: ck.a$a, reason: collision with other inner class name */
    @t0({"SMAP\nJDK7PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK7PlatformImplementations.kt\nkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,38:1\n1#2:39\n*E\n"})
    public static final class C0109a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public static final C0109a f10957a = new C0109a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @e
        @yt.l
        public static final Integer f10958b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null) {
                if (num2.intValue() > 0) {
                    num = num2;
                }
            }
            f10958b = num;
        }
    }

    @Override // bk.l
    public void a(@k Throwable cause, @k Throwable exception) throws IllegalAccessException, InvocationTargetException {
        f0.p(cause, "cause");
        f0.p(exception, "exception");
        if (e(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }

    @Override // bk.l
    @k
    public List<Throwable> d(@k Throwable exception) {
        f0.p(exception, "exception");
        if (!e(19)) {
            return super.d(exception);
        }
        Throwable[] suppressed = exception.getSuppressed();
        f0.o(suppressed, "exception.suppressed");
        return m.t(suppressed);
    }

    public final boolean e(int i10) {
        Integer num = C0109a.f10958b;
        return num == null || num.intValue() >= i10;
    }
}
