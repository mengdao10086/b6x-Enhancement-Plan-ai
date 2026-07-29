package zj;

import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/ModuleNameRetriever\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final g f58599a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final a f58600b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static a f58601c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @hk.e
        @l
        public final Method f58602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @hk.e
        @l
        public final Method f58603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hk.e
        @l
        public final Method f58604c;

        public a(@l Method method, @l Method method2, @l Method method3) {
            this.f58602a = method;
            this.f58603b = method2;
            this.f58604c = method3;
        }
    }

    public final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f58601c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f58600b;
            f58601c = aVar2;
            return aVar2;
        }
    }

    @l
    public final String b(@k BaseContinuationImpl continuation) {
        f0.p(continuation, "continuation");
        a aVarA = f58601c;
        if (aVarA == null) {
            aVarA = a(continuation);
        }
        if (aVarA == f58600b) {
            return null;
        }
        Method method = aVarA.f58602a;
        Object objInvoke = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVarA.f58603b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, new Object[0]) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVarA.f58604c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
