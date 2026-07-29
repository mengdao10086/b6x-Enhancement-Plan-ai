package io.reactivex.internal.operators.mixed;

import dj.o;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;
import xi.d;
import xi.g;
import xi.g0;
import xi.o0;
import xi.w;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public b() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean a(Object obj, o<? super T, ? extends g> oVar, d dVar) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            a0.b bVar = (Object) ((Callable) obj).call();
            g gVar = bVar != null ? (g) io.reactivex.internal.functions.a.g(oVar.apply(bVar), "The mapper returned a null CompletableSource") : null;
            if (gVar == null) {
                EmptyDisposable.complete(dVar);
            } else {
                gVar.a(dVar);
            }
            return true;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, dVar);
            return true;
        }
    }

    public static <T, R> boolean b(Object obj, o<? super T, ? extends w<? extends R>> oVar, g0<? super R> g0Var) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            a0.b bVar = (Object) ((Callable) obj).call();
            w wVar = bVar != null ? (w) io.reactivex.internal.functions.a.g(oVar.apply(bVar), "The mapper returned a null MaybeSource") : null;
            if (wVar == null) {
                EmptyDisposable.complete(g0Var);
            } else {
                wVar.a(MaybeToObservable.i8(g0Var));
            }
            return true;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, g0Var);
            return true;
        }
    }

    public static <T, R> boolean c(Object obj, o<? super T, ? extends o0<? extends R>> oVar, g0<? super R> g0Var) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            a0.b bVar = (Object) ((Callable) obj).call();
            o0 o0Var = bVar != null ? (o0) io.reactivex.internal.functions.a.g(oVar.apply(bVar), "The mapper returned a null SingleSource") : null;
            if (o0Var == null) {
                EmptyDisposable.complete(g0Var);
            } else {
                o0Var.a(SingleToObservable.i8(g0Var));
            }
            return true;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, g0Var);
            return true;
        }
    }
}
