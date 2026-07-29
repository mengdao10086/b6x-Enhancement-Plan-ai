package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes5.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38236a;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            try {
                iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoroutineStart.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f38236a = iArr;
        }
    }

    @y1
    public static /* synthetic */ void isLazy$annotations() {
    }

    @y1
    public final <T> void invoke(@yt.k ik.l<? super kotlin.coroutines.c<? super T>, ? extends Object> lVar, @yt.k kotlin.coroutines.c<? super T> cVar) throws Throwable {
        int i10 = a.f38236a[ordinal()];
        if (i10 == 1) {
            zk.a.c(lVar, cVar);
            return;
        }
        if (i10 == 2) {
            kotlin.coroutines.e.h(lVar, cVar);
        } else if (i10 == 3) {
            zk.b.a(lVar, cVar);
        } else if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @y1
    public final <R, T> void invoke(@yt.k ik.p<? super R, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, R r10, @yt.k kotlin.coroutines.c<? super T> cVar) throws Throwable {
        int i10 = a.f38236a[ordinal()];
        if (i10 == 1) {
            zk.a.f(pVar, r10, cVar, null, 4, null);
            return;
        }
        if (i10 == 2) {
            kotlin.coroutines.e.i(pVar, r10, cVar);
        } else if (i10 == 3) {
            zk.b.b(pVar, r10, cVar);
        } else if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
