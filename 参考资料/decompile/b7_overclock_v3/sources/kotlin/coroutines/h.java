package kotlin.coroutines;

import al.o;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.s0;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
@s0
public final class h<T> implements c<T>, zj.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final a f37763b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<h<?>, Object> f37764c = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, CommonNetImpl.RESULT);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final c<T> f37765a;

    @l
    private volatile Object result;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public static /* synthetic */ void a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@k c<? super T> delegate, @l Object obj) {
        f0.p(delegate, "delegate");
        this.f37765a = delegate;
        this.result = obj;
    }

    @Override // zj.c
    @l
    public StackTraceElement D() {
        return null;
    }

    @l
    @s0
    public final Object a() throws Throwable {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            if (o.a(f37764c, this, coroutineSingletons, yj.b.h())) {
                return yj.b.h();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return yj.b.h();
        }
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
        return obj;
    }

    @Override // kotlin.coroutines.c
    @k
    public CoroutineContext b() {
        return this.f37765a.b();
    }

    @Override // zj.c
    @l
    public zj.c r() {
        c<T> cVar = this.f37765a;
        if (cVar instanceof zj.c) {
            return (zj.c) cVar;
        }
        return null;
    }

    @k
    public String toString() {
        return "SafeContinuation for " + this.f37765a;
    }

    @Override // kotlin.coroutines.c
    public void x(@k Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                if (o.a(f37764c, this, coroutineSingletons, obj)) {
                    return;
                }
            } else {
                if (obj2 != yj.b.h()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (o.a(f37764c, this, yj.b.h(), CoroutineSingletons.RESUMED)) {
                    this.f37765a.x(obj);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @s0
    public h(@k c<? super T> delegate) {
        this(delegate, CoroutineSingletons.UNDECIDED);
        f0.p(delegate, "delegate");
    }
}
