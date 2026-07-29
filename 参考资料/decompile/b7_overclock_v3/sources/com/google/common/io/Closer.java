package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
public final class Closer implements Closeable {
    private static final Suppressor SUPPRESSOR;
    private final Deque<Closeable> stack = new ArrayDeque(4);

    @VisibleForTesting
    public final Suppressor suppressor;

    @MonotonicNonNullDecl
    private Throwable thrown;

    @VisibleForTesting
    public static final class LoggingSuppressor implements Suppressor {
        public static final LoggingSuppressor INSTANCE = new LoggingSuppressor();

        @Override // com.google.common.io.Closer.Suppressor
        public void suppress(Closeable closeable, Throwable th2, Throwable th3) {
            Closeables.logger.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th3);
        }
    }

    @VisibleForTesting
    public static final class SuppressingSuppressor implements Suppressor {
        public static final SuppressingSuppressor INSTANCE = new SuppressingSuppressor();
        public static final Method addSuppressed = getAddSuppressed();

        private static Method getAddSuppressed() {
            try {
                return Throwable.class.getMethod("addSuppressed", Throwable.class);
            } catch (Throwable unused) {
                return null;
            }
        }

        public static boolean isAvailable() {
            return addSuppressed != null;
        }

        @Override // com.google.common.io.Closer.Suppressor
        public void suppress(Closeable closeable, Throwable th2, Throwable th3) {
            if (th2 == th3) {
                return;
            }
            try {
                addSuppressed.invoke(th2, th3);
            } catch (Throwable unused) {
                LoggingSuppressor.INSTANCE.suppress(closeable, th2, th3);
            }
        }
    }

    @VisibleForTesting
    public interface Suppressor {
        void suppress(Closeable closeable, Throwable th2, Throwable th3);
    }

    static {
        SUPPRESSOR = SuppressingSuppressor.isAvailable() ? SuppressingSuppressor.INSTANCE : LoggingSuppressor.INSTANCE;
    }

    @VisibleForTesting
    public Closer(Suppressor suppressor) {
        this.suppressor = (Suppressor) Preconditions.checkNotNull(suppressor);
    }

    public static Closer create() {
        return new Closer(SUPPRESSOR);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        Throwable th2 = this.thrown;
        while (!this.stack.isEmpty()) {
            Closeable closeableRemoveFirst = this.stack.removeFirst();
            try {
                closeableRemoveFirst.close();
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    this.suppressor.suppress(closeableRemoveFirst, th2, th3);
                }
            }
        }
        if (this.thrown != null || th2 == null) {
            return;
        }
        Throwables.propagateIfPossible(th2, IOException.class);
        throw new AssertionError(th2);
    }

    @CanIgnoreReturnValue
    public <C extends Closeable> C register(@NullableDecl C c10) {
        if (c10 != null) {
            this.stack.addFirst(c10);
        }
        return c10;
    }

    public RuntimeException rethrow(Throwable th2) throws Throwable {
        Preconditions.checkNotNull(th2);
        this.thrown = th2;
        Throwables.propagateIfPossible(th2, IOException.class);
        throw new RuntimeException(th2);
    }

    public <X extends Exception> RuntimeException rethrow(Throwable th2, Class<X> cls) throws Exception {
        Preconditions.checkNotNull(th2);
        this.thrown = th2;
        Throwables.propagateIfPossible(th2, IOException.class);
        Throwables.propagateIfPossible(th2, cls);
        throw new RuntimeException(th2);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable th2, Class<X1> cls, Class<X2> cls2) throws Exception {
        Preconditions.checkNotNull(th2);
        this.thrown = th2;
        Throwables.propagateIfPossible(th2, IOException.class);
        Throwables.propagateIfPossible(th2, cls, cls2);
        throw new RuntimeException(th2);
    }
}
