package a;

import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ki2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6612a;

    static {
        Object objA;
        Object objA2;
        try {
            e42 e42Var = g42.f6169a;
            objA = Class.forName("a.s62").getCanonicalName();
            g42.a(objA);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            objA = h42.a(th);
            g42.a(objA);
        }
        if (g42.b(objA) != null) {
            objA = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f6612a = (String) objA;
        try {
            e42 e42Var3 = g42.f6169a;
            objA2 = Class.forName("a.ki2").getCanonicalName();
            g42.a(objA2);
        } catch (Throwable th2) {
            e42 e42Var4 = g42.f6169a;
            objA2 = h42.a(th2);
            g42.a(objA2);
        }
        if (g42.b(objA2) != null) {
            objA2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }

    public static final StackTraceElement b(String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    public static final <E extends Throwable> d42<E, StackTraceElement[]> c(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause == null || !f92.a(cause.getClass(), e.getClass())) {
            return j42.a(e, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (h(stackTrace[i])) {
                z = true;
                break;
            }
            i++;
        }
        return z ? j42.a(cause, stackTrace) : j42.a(e, new StackTraceElement[0]);
    }

    public static final <E extends Throwable> E d(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(b("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int iG = g(stackTrace, f6612a);
        int i = 0;
        if (iG == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            e2.setStackTrace((StackTraceElement[]) array);
            return e2;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + iG];
        for (int i2 = 0; i2 < iG; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        Iterator<T> it = arrayDeque.iterator();
        while (it.hasNext()) {
            stackTraceElementArr[iG + i] = (StackTraceElement) it.next();
            i++;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    public static final ArrayDeque<StackTraceElement> e(w62 w62Var) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElementP = w62Var.p();
        if (stackTraceElementP != null) {
            arrayDeque.add(stackTraceElementP);
        }
        while (true) {
            if (!(w62Var instanceof w62)) {
                w62Var = null;
            }
            if (w62Var == null || (w62Var = w62Var.v()) == null) {
                break;
            }
            StackTraceElement stackTraceElementP2 = w62Var.p();
            if (stackTraceElementP2 != null) {
                arrayDeque.add(stackTraceElementP2);
            }
        }
        return arrayDeque;
    }

    public static final boolean f(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && f92.a(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && f92.a(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && f92.a(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    public static final int g(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (f92.a(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean h(StackTraceElement stackTraceElement) {
        return bc2.x(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
    }

    public static final void i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (h(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            if (f(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            } else {
                length2--;
            }
        }
    }

    public static final <E extends Throwable> E j(E e, w62 w62Var) {
        d42 d42VarC = c(e);
        Throwable th = (Throwable) d42VarC.a();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) d42VarC.b();
        E e2 = (E) th2.e(th);
        if (e2 == null || (!f92.a(e2.getMessage(), th.getMessage()))) {
            return e;
        }
        ArrayDeque<StackTraceElement> arrayDequeE = e(w62Var);
        if (arrayDequeE.isEmpty()) {
            return e;
        }
        if (th != e) {
            i(stackTraceElementArr, arrayDequeE);
        }
        d(th, e2, arrayDequeE);
        return e2;
    }

    public static final <E extends Throwable> E k(E e) {
        E e2 = (E) e.getCause();
        if (e2 != null) {
            boolean z = true;
            if (!(!f92.a(e2.getClass(), e.getClass()))) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    if (h(stackTrace[i])) {
                        break;
                    }
                    i++;
                }
                if (z) {
                    return e2;
                }
            }
        }
        return e;
    }
}
