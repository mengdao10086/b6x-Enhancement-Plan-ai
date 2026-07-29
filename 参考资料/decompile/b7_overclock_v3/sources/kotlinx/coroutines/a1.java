package kotlinx.coroutines;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,220:1\n1#2:221\n107#3,10:222\n118#3,2:236\n218#4:232\n219#4:235\n61#5,2:233\n75#6:238\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n*L\n88#1:222,10\n88#1:236,2\n101#1:232\n101#1:235\n101#1:233,2\n140#1:238\n*E\n"})
public abstract class a1<T> extends al.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    public int f38266c;

    public a1(int i10) {
        this.f38266c = i10;
    }

    public void c(@yt.l Object obj, @yt.k Throwable th2) {
    }

    @yt.k
    public abstract kotlin.coroutines.c<T> e();

    @yt.l
    public Throwable f(@yt.l Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var != null) {
            return c0Var.f38294a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T h(@yt.l Object obj) {
        return obj;
    }

    public final void i(@yt.l Throwable th2, @yt.l Throwable th3) throws IllegalAccessException, InvocationTargetException {
        if (th2 == null && th3 == null) {
            return;
        }
        if (th2 != null && th3 != null) {
            kotlin.o.a(th2, th3);
        }
        if (th2 == null) {
            th2 = th3;
        }
        kotlin.jvm.internal.f0.m(th2);
        l0.b(e().b(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
    }

    @yt.l
    public abstract Object j();

    /* JADX WARN: Removed duplicated region for block: B:25:0x0088 A[Catch: all -> 0x00b5, DONT_GENERATE, TRY_LEAVE, TryCatch #2 {all -> 0x00b5, blocks: (B:3:0x0002, B:5:0x001e, B:23:0x0082, B:25:0x0088, B:33:0x00ab, B:36:0x00b4, B:35:0x00b1, B:8:0x0024, B:10:0x0032, B:12:0x003a, B:15:0x0046, B:17:0x004c, B:21:0x007e, B:19:0x0063, B:20:0x0071), top: B:48:0x0002, inners: #3 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.a1.run():void");
    }
}
