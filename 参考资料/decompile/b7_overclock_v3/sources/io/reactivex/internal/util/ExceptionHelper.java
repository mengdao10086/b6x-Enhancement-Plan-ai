package io.reactivex.internal.util;

import com.blankj.utilcode.util.i0;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ExceptionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f35249a = new Termination();

    public static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public ExceptionHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th2) {
        Throwable th3;
        do {
            th3 = atomicReference.get();
            if (th3 == f35249a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th3, th3 == null ? th2 : new CompositeException(th3, th2)));
        return true;
    }

    public static List<Throwable> b(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(th2);
        while (!arrayDeque.isEmpty()) {
            Throwable th3 = (Throwable) arrayDeque.removeFirst();
            if (th3 instanceof CompositeException) {
                List<Throwable> listB = ((CompositeException) th3).b();
                for (int size = listB.size() - 1; size >= 0; size--) {
                    arrayDeque.offerFirst(listB.get(size));
                }
            } else {
                arrayList.add(th3);
            }
        }
        return arrayList;
    }

    public static <T> Throwable c(AtomicReference<Throwable> atomicReference) {
        Throwable th2 = atomicReference.get();
        Throwable th3 = f35249a;
        return th2 != th3 ? atomicReference.getAndSet(th3) : th2;
    }

    public static <E extends Throwable> Exception d(Throwable th2) throws Throwable {
        if (th2 instanceof Exception) {
            return (Exception) th2;
        }
        throw th2;
    }

    public static String e(long j10, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j10 + i0.f11861z + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException f(Throwable th2) {
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        return th2 instanceof RuntimeException ? (RuntimeException) th2 : new RuntimeException(th2);
    }
}
