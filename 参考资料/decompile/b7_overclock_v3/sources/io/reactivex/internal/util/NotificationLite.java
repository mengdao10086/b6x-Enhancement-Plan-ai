package io.reactivex.internal.util;

import java.io.Serializable;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public enum NotificationLite {
    COMPLETE;

    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        public final io.reactivex.disposables.b upstream;

        public DisposableNotification(io.reactivex.disposables.b bVar) {
            this.upstream = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Throwable f35250e;

        public ErrorNotification(Throwable th2) {
            this.f35250e = th2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return io.reactivex.internal.functions.a.c(this.f35250e, ((ErrorNotification) obj).f35250e);
            }
            return false;
        }

        public int hashCode() {
            return this.f35250e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f35250e + "]";
        }
    }

    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        public final bu.e upstream;

        public SubscriptionNotification(bu.e eVar) {
            this.upstream = eVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    public static <T> boolean accept(Object obj, bu.d<? super T> dVar) {
        if (obj == COMPLETE) {
            dVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            dVar.onError(((ErrorNotification) obj).f35250e);
            return true;
        }
        dVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, bu.d<? super T> dVar) {
        if (obj == COMPLETE) {
            dVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            dVar.onError(((ErrorNotification) obj).f35250e);
            return true;
        }
        if (obj instanceof SubscriptionNotification) {
            dVar.onSubscribe(((SubscriptionNotification) obj).upstream);
            return false;
        }
        dVar.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(io.reactivex.disposables.b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object error(Throwable th2) {
        return new ErrorNotification(th2);
    }

    public static io.reactivex.disposables.b getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f35250e;
    }

    public static bu.e getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t10) {
        return t10;
    }

    public static Object subscription(bu.e eVar) {
        return new SubscriptionNotification(eVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, g0<? super T> g0Var) {
        if (obj == COMPLETE) {
            g0Var.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            g0Var.onError(((ErrorNotification) obj).f35250e);
            return true;
        }
        g0Var.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, g0<? super T> g0Var) {
        if (obj == COMPLETE) {
            g0Var.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            g0Var.onError(((ErrorNotification) obj).f35250e);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            g0Var.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        }
        g0Var.onNext(obj);
        return false;
    }
}
