package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import zc.f;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public class FinalizableReferenceQueue implements Closeable {
    private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
    private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
    private static final Method startFinalizer = getStartFinalizer(loadFinalizer(new SystemLoader(), new DecoupledLoader(), new DirectLoader()));
    public final PhantomReference<Object> frqRef;
    public final ReferenceQueue<Object> queue;
    public final boolean threadStarted;

    public static class DecoupledLoader implements FinalizerLoader {
        private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

        public URL getBaseUrl() throws IOException {
            String str = FinalizableReferenceQueue.FINALIZER_CLASS_NAME.replace('.', f.f58380j) + ".class";
            URL resource = getClass().getClassLoader().getResource(str);
            if (resource == null) {
                throw new FileNotFoundException(str);
            }
            String string = resource.toString();
            if (string.endsWith(str)) {
                return new URL(resource, string.substring(0, string.length() - str.length()));
            }
            throw new IOException("Unsupported path style: " + string);
        }

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @NullableDecl
        public Class<?> loadFinalizer() {
            try {
                return newLoader(getBaseUrl()).loadClass(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
            } catch (Exception e10) {
                FinalizableReferenceQueue.logger.log(Level.WARNING, LOADING_ERROR, (Throwable) e10);
                return null;
            }
        }

        public URLClassLoader newLoader(URL url) {
            return new URLClassLoader(new URL[]{url}, null);
        }
    }

    public static class DirectLoader implements FinalizerLoader {
        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public Class<?> loadFinalizer() {
            try {
                return Class.forName(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
            } catch (ClassNotFoundException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public interface FinalizerLoader {
        @NullableDecl
        Class<?> loadFinalizer();
    }

    public static class SystemLoader implements FinalizerLoader {

        @VisibleForTesting
        public static boolean disabled;

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @NullableDecl
        public Class<?> loadFinalizer() {
            if (disabled) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public FinalizableReferenceQueue() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.queue = referenceQueue;
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, referenceQueue);
        this.frqRef = phantomReference;
        boolean z10 = true;
        try {
            startFinalizer.invoke(null, FinalizableReference.class, referenceQueue, phantomReference);
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        } catch (Throwable th2) {
            logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th2);
            z10 = false;
        }
        this.threadStarted = z10;
    }

    public static Method getStartFinalizer(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        } catch (NoSuchMethodException e10) {
            throw new AssertionError(e10);
        }
    }

    private static Class<?> loadFinalizer(FinalizerLoader... finalizerLoaderArr) {
        for (FinalizerLoader finalizerLoader : finalizerLoaderArr) {
            Class<?> clsLoadFinalizer = finalizerLoader.loadFinalizer();
            if (clsLoadFinalizer != null) {
                return clsLoadFinalizer;
            }
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void cleanUp() {
        if (this.threadStarted) {
            return;
        }
        while (true) {
            Reference<? extends Object> referencePoll = this.queue.poll();
            if (referencePoll == 0) {
                return;
            }
            referencePoll.clear();
            try {
                ((FinalizableReference) referencePoll).finalizeReferent();
            } catch (Throwable th2) {
                logger.log(Level.SEVERE, "Error cleaning up after reference.", th2);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frqRef.enqueue();
        cleanUp();
    }
}
