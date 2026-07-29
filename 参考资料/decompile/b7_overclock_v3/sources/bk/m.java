package bk;

import kotlin.jvm.internal.f0;
import kotlin.s0;
import kotlin.v0;
import kotlin.w;

/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final l f9497a;

    static {
        l lVar;
        Object objNewInstance;
        try {
            objNewInstance = dk.a.class.newInstance();
            f0.o(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                } catch (ClassNotFoundException unused) {
                    Object objNewInstance2 = ck.a.class.newInstance();
                    f0.o(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        try {
                            if (objNewInstance2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            }
                            lVar = (l) objNewInstance2;
                        } catch (ClassCastException e10) {
                            ClassLoader classLoader = objNewInstance2.getClass().getClassLoader();
                            ClassLoader classLoader2 = l.class.getClassLoader();
                            if (f0.g(classLoader, classLoader2)) {
                                throw e10;
                            }
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e10);
                        }
                    } catch (ClassNotFoundException unused2) {
                        lVar = new l();
                    }
                }
            } catch (ClassCastException e11) {
                ClassLoader classLoader3 = objNewInstance.getClass().getClassLoader();
                ClassLoader classLoader4 = l.class.getClassLoader();
                if (f0.g(classLoader3, classLoader4)) {
                    throw e11;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e11);
            }
        } catch (ClassNotFoundException unused3) {
            Object objNewInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            f0.o(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    if (objNewInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    lVar = (l) objNewInstance3;
                } catch (ClassCastException e12) {
                    ClassLoader classLoader5 = objNewInstance3.getClass().getClassLoader();
                    ClassLoader classLoader6 = l.class.getClassLoader();
                    if (f0.g(classLoader5, classLoader6)) {
                        throw e12;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e12);
                }
            } catch (ClassNotFoundException unused4) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                f0.o(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    lVar = (l) objNewInstance4;
                } catch (ClassCastException e13) {
                    ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = l.class.getClassLoader();
                    if (f0.g(classLoader7, classLoader8)) {
                        throw e13;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e13);
                }
            }
        }
        if (objNewInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        lVar = (l) objNewInstance;
        f9497a = lVar;
    }

    @v0(version = "1.2")
    @s0
    public static final boolean a(int i10, int i11, int i12) {
        return w.f38221g.h(i10, i11, i12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    public static final /* synthetic */ <T> T b(Object obj) throws ClassNotFoundException {
        try {
            f0.y(1, i1.a.f31577d5);
            return obj;
        } catch (ClassCastException e10) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            f0.y(4, i1.a.f31577d5);
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (f0.g(classLoader, classLoader2)) {
                throw e10;
            }
            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e10);
        }
    }
}
