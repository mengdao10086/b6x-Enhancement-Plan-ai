package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public final class Throwables {

    @GwtIncompatible
    private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";

    @VisibleForTesting
    @GwtIncompatible
    public static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";

    @NullableDecl
    @GwtIncompatible
    private static final Method getStackTraceDepthMethod;

    @NullableDecl
    @GwtIncompatible
    private static final Method getStackTraceElementMethod;

    @NullableDecl
    @GwtIncompatible
    private static final Object jla;

    static {
        Object jla2 = getJLA();
        jla = jla2;
        getStackTraceElementMethod = jla2 == null ? null : getGetMethod();
        getStackTraceDepthMethod = jla2 != null ? getSizeMethod() : null;
    }

    private Throwables() {
    }

    @Beta
    public static List<Throwable> getCausalChain(Throwable th2) {
        Preconditions.checkNotNull(th2);
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(th2);
        boolean z10 = false;
        Throwable cause = th2;
        while (true) {
            th2 = th2.getCause();
            if (th2 == null) {
                return Collections.unmodifiableList(arrayList);
            }
            arrayList.add(th2);
            if (th2 == cause) {
                throw new IllegalArgumentException("Loop in causal chain detected.", th2);
            }
            if (z10) {
                cause = cause.getCause();
            }
            z10 = !z10;
        }
    }

    @Beta
    @GwtIncompatible
    public static <X extends Throwable> X getCauseAs(Throwable th2, Class<X> cls) {
        try {
            return cls.cast(th2.getCause());
        } catch (ClassCastException e10) {
            e10.initCause(th2);
            throw e10;
        }
    }

    @NullableDecl
    @GwtIncompatible
    private static Method getGetMethod() {
        return getJlaMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @NullableDecl
    @GwtIncompatible
    private static Object getJLA() {
        try {
            return Class.forName(SHARED_SECRETS_CLASSNAME, false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    @GwtIncompatible
    private static Method getJlaMethod(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName(JAVA_LANG_ACCESS_CLASSNAME, false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Throwable getRootCause(Throwable th2) {
        boolean z10 = false;
        Throwable cause = th2;
        while (true) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                return th2;
            }
            if (cause2 == cause) {
                throw new IllegalArgumentException("Loop in causal chain detected.", cause2);
            }
            if (z10) {
                cause = cause.getCause();
            }
            z10 = !z10;
            th2 = cause2;
        }
    }

    @NullableDecl
    @GwtIncompatible
    private static Method getSizeMethod() {
        try {
            Method jlaMethod = getJlaMethod("getStackTraceDepth", Throwable.class);
            if (jlaMethod == null) {
                return null;
            }
            jlaMethod.invoke(getJLA(), new Throwable());
            return jlaMethod;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @GwtIncompatible
    public static String getStackTraceAsString(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GwtIncompatible
    public static Object invokeAccessibleNonThrowingMethod(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw propagate(e11.getCause());
        }
    }

    @GwtIncompatible
    private static List<StackTraceElement> jlaStackTrace(final Throwable th2) {
        Preconditions.checkNotNull(th2);
        return new AbstractList<StackTraceElement>() { // from class: com.google.common.base.Throwables.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return ((Integer) Throwables.invokeAccessibleNonThrowingMethod(Throwables.getStackTraceDepthMethod, Throwables.jla, th2)).intValue();
            }

            @Override // java.util.AbstractList, java.util.List
            public StackTraceElement get(int i10) {
                return (StackTraceElement) Throwables.invokeAccessibleNonThrowingMethod(Throwables.getStackTraceElementMethod, Throwables.jla, th2, Integer.valueOf(i10));
            }
        };
    }

    @Beta
    @GwtIncompatible
    public static List<StackTraceElement> lazyStackTrace(Throwable th2) {
        return lazyStackTraceIsLazy() ? jlaStackTrace(th2) : Collections.unmodifiableList(Arrays.asList(th2.getStackTrace()));
    }

    @Beta
    @GwtIncompatible
    public static boolean lazyStackTraceIsLazy() {
        return (getStackTraceElementMethod == null || getStackTraceDepthMethod == null) ? false : true;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public static RuntimeException propagate(Throwable th2) {
        throwIfUnchecked(th2);
        throw new RuntimeException(th2);
    }

    @GwtIncompatible
    @Deprecated
    public static <X extends Throwable> void propagateIfInstanceOf(@NullableDecl Throwable th2, Class<X> cls) throws Throwable {
        if (th2 != null) {
            throwIfInstanceOf(th2, cls);
        }
    }

    @GwtIncompatible
    @Deprecated
    public static void propagateIfPossible(@NullableDecl Throwable th2) {
        if (th2 != null) {
            throwIfUnchecked(th2);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    @GwtIncompatible
    public static <X extends Throwable> void throwIfInstanceOf(Throwable th2, Class<X> cls) throws Throwable {
        Preconditions.checkNotNull(th2);
        if (cls.isInstance(th2)) {
            throw cls.cast(th2);
        }
    }

    public static void throwIfUnchecked(Throwable th2) {
        Preconditions.checkNotNull(th2);
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
    }

    @GwtIncompatible
    public static <X extends Throwable> void propagateIfPossible(@NullableDecl Throwable th2, Class<X> cls) throws Throwable {
        propagateIfInstanceOf(th2, cls);
        propagateIfPossible(th2);
    }

    @GwtIncompatible
    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@NullableDecl Throwable th2, Class<X1> cls, Class<X2> cls2) throws Throwable {
        Preconditions.checkNotNull(cls2);
        propagateIfInstanceOf(th2, cls);
        propagateIfPossible(th2, cls2);
    }
}
