package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.d1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nStackTraceRecovery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,214:1\n1735#2,6:215\n12744#2,2:223\n1627#2,6:227\n12744#2,2:233\n1627#2,6:236\n37#3,2:221\n26#4:225\n26#4:226\n1#5:235\n*S KotlinDebug\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n43#1:215,6\n131#1:223,2\n141#1:227,6\n171#1:233,2\n192#1:236,6\n106#1:221,2\n133#1:225\n135#1:226\n*E\n"})
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final String f38817a = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final String f38818b = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final StackTraceElement f38819c = new b.a().a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f38820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f38821e;

    static {
        Object objB;
        Object objB2;
        try {
            Result.a aVar = Result.f37633a;
            objB = Result.b(Class.forName(f38817a).getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(kotlin.u0.a(th2));
        }
        if (Result.f(objB) != null) {
            objB = f38817a;
        }
        f38820d = (String) objB;
        try {
            Result.a aVar3 = Result.f37633a;
            objB2 = Result.b(n0.class.getCanonicalName());
        } catch (Throwable th3) {
            Result.a aVar4 = Result.f37633a;
            objB2 = Result.b(kotlin.u0.a(th3));
        }
        if (Result.f(objB2) != null) {
            objB2 = f38818b;
        }
        f38821e = (String) objB2;
    }

    public static /* synthetic */ void a() {
    }

    public static /* synthetic */ void b() {
    }

    public static final <E extends Throwable> Pair<E, StackTraceElement[]> d(E e10) {
        boolean z10;
        Throwable cause = e10.getCause();
        if (cause == null || !kotlin.jvm.internal.f0.g(cause.getClass(), e10.getClass())) {
            return d1.a(e10, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e10.getStackTrace();
        int length = stackTrace.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            if (j(stackTrace[i10])) {
                z10 = true;
                break;
            }
            i10++;
        }
        return z10 ? d1.a(cause, stackTrace) : d1.a(e10, new StackTraceElement[0]);
    }

    public static final <E extends Throwable> E e(E e10, E e11, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(f38819c);
        StackTraceElement[] stackTrace = e10.getStackTrace();
        int iH = h(stackTrace, f38820d);
        int i10 = 0;
        if (iH == -1) {
            e11.setStackTrace((StackTraceElement[]) arrayDeque.toArray(new StackTraceElement[0]));
            return e11;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + iH];
        for (int i11 = 0; i11 < iH; i11++) {
            stackTraceElementArr[i11] = stackTrace[i11];
        }
        Iterator<StackTraceElement> it2 = arrayDeque.iterator();
        while (it2.hasNext()) {
            int i12 = i10 + 1;
            stackTraceElementArr[i10 + iH] = it2.next();
            i10 = i12;
        }
        e11.setStackTrace(stackTraceElementArr);
        return e11;
    }

    public static final ArrayDeque<StackTraceElement> f(zj.c cVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElementD = cVar.D();
        if (stackTraceElementD != null) {
            arrayDeque.add(stackTraceElementD);
        }
        while (true) {
            cVar = cVar.r();
            if (cVar == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElementD2 = cVar.D();
            if (stackTraceElementD2 != null) {
                arrayDeque.add(stackTraceElementD2);
            }
        }
    }

    public static final boolean g(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.f0.g(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && kotlin.jvm.internal.f0.g(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && kotlin.jvm.internal.f0.g(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    public static final int h(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (kotlin.jvm.internal.f0.g(str, stackTraceElementArr[i10].getClassName())) {
                return i10;
            }
        }
        return -1;
    }

    public static final void i(@yt.k Throwable th2, @yt.k Throwable th3) {
        th2.initCause(th3);
    }

    public static final boolean j(@yt.k StackTraceElement stackTraceElement) {
        return kotlin.text.u.v2(stackTraceElement.getClassName(), b.b.c(), false, 2, null);
    }

    public static final void k(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            } else if (j(stackTraceElementArr[i10])) {
                break;
            } else {
                i10++;
            }
        }
        int i11 = i10 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i11 > length2) {
            return;
        }
        while (true) {
            if (g(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i11) {
                return;
            } else {
                length2--;
            }
        }
    }

    @yt.l
    public static final Object l(@yt.k Throwable th2, @yt.k kotlin.coroutines.c<?> cVar) throws Throwable {
        throw th2;
    }

    public static final Object m(Throwable th2, kotlin.coroutines.c<?> cVar) throws Throwable {
        throw th2;
    }

    public static final <E extends Throwable> E n(E e10, zj.c cVar) {
        Pair pairD = d(e10);
        Throwable th2 = (Throwable) pairD.a();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) pairD.b();
        Throwable thG = ExceptionsConstructorKt.g(th2);
        if (thG == null) {
            return e10;
        }
        ArrayDeque<StackTraceElement> arrayDequeF = f(cVar);
        if (arrayDequeF.isEmpty()) {
            return e10;
        }
        if (th2 != e10) {
            k(stackTraceElementArr, arrayDequeF);
        }
        return (E) e(th2, thG, arrayDequeF);
    }

    @yt.k
    public static final <E extends Throwable> E o(@yt.k E e10) {
        return e10;
    }

    @yt.k
    public static final <E extends Throwable> E p(@yt.k E e10, @yt.k kotlin.coroutines.c<?> cVar) {
        return e10;
    }

    public static final <E extends Throwable> E q(E e10) {
        StackTraceElement[] stackTrace = e10.getStackTrace();
        int length = stackTrace.length;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i10 = length2 - 1;
                if (kotlin.jvm.internal.f0.g(f38821e, stackTrace[length2].getClassName())) {
                    break;
                }
                if (i10 < 0) {
                    break;
                }
                length2 = i10;
            }
            length2 = -1;
        } else {
            length2 = -1;
        }
        int i11 = length2 + 1;
        int iH = h(stackTrace, f38820d);
        int i12 = 0;
        int i13 = (length - length2) - (iH == -1 ? 0 : length - iH);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i13];
        while (i12 < i13) {
            stackTraceElementArr[i12] = i12 == 0 ? f38819c : stackTrace[(i11 + i12) - 1];
            i12++;
        }
        e10.setStackTrace(stackTraceElementArr);
        return e10;
    }

    @yt.k
    public static final <E extends Throwable> E r(@yt.k E e10) {
        return e10;
    }

    @yt.k
    public static final <E extends Throwable> E s(@yt.k E e10) {
        E e11 = (E) e10.getCause();
        if (e11 != null && kotlin.jvm.internal.f0.g(e11.getClass(), e10.getClass())) {
            StackTraceElement[] stackTrace = e10.getStackTrace();
            int length = stackTrace.length;
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (j(stackTrace[i10])) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (z10) {
                return e11;
            }
        }
        return e10;
    }
}
