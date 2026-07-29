package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CallableReference implements kotlin.reflect.c, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @kotlin.v0(version = "1.1")
    public static final Object f37869b = NoReceiver.f37871a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient kotlin.reflect.c f37870a;

    @kotlin.v0(version = "1.4")
    private final boolean isTopLevel;

    @kotlin.v0(version = "1.4")
    private final String name;

    @kotlin.v0(version = "1.4")
    private final Class owner;

    @kotlin.v0(version = "1.1")
    public final Object receiver;

    @kotlin.v0(version = "1.4")
    private final String signature;

    @kotlin.v0(version = "1.2")
    public static class NoReceiver implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoReceiver f37871a = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f37871a;
        }
    }

    public CallableReference() {
        this(f37869b);
    }

    @Override // kotlin.reflect.c
    public kotlin.reflect.r F0() {
        return U0().F0();
    }

    @Override // kotlin.reflect.c
    public Object O0(Object... objArr) {
        return U0().O0(objArr);
    }

    @kotlin.v0(version = "1.1")
    public kotlin.reflect.c Q0() {
        kotlin.reflect.c cVar = this.f37870a;
        if (cVar != null) {
            return cVar;
        }
        kotlin.reflect.c cVarR0 = R0();
        this.f37870a = cVarR0;
        return cVarR0;
    }

    @Override // kotlin.reflect.c
    public Object R(Map map) {
        return U0().R(map);
    }

    public abstract kotlin.reflect.c R0();

    @kotlin.v0(version = "1.1")
    public Object S0() {
        return this.receiver;
    }

    public kotlin.reflect.h T0() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? n0.g(cls) : n0.d(cls);
    }

    @kotlin.v0(version = "1.1")
    public kotlin.reflect.c U0() {
        kotlin.reflect.c cVarQ0 = Q0();
        if (cVarQ0 != this) {
            return cVarQ0;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public String V0() {
        return this.signature;
    }

    @Override // kotlin.reflect.c
    public List<KParameter> b() {
        return U0().b();
    }

    @Override // kotlin.reflect.c
    @kotlin.v0(version = "1.1")
    public KVisibility d() {
        return U0().d();
    }

    @Override // kotlin.reflect.c
    @kotlin.v0(version = "1.1")
    public boolean f() {
        return U0().f();
    }

    @Override // kotlin.reflect.b
    public List<Annotation> getAnnotations() {
        return U0().getAnnotations();
    }

    @Override // kotlin.reflect.c
    public String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.c
    @kotlin.v0(version = "1.1")
    public List<kotlin.reflect.s> getTypeParameters() {
        return U0().getTypeParameters();
    }

    @Override // kotlin.reflect.c
    @kotlin.v0(version = "1.1")
    public boolean isOpen() {
        return U0().isOpen();
    }

    @Override // kotlin.reflect.c
    @kotlin.v0(version = "1.1")
    public boolean k() {
        return U0().k();
    }

    @Override // kotlin.reflect.c
    @kotlin.v0(version = "1.3")
    public boolean m() {
        return U0().m();
    }

    @kotlin.v0(version = "1.1")
    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    @kotlin.v0(version = "1.4")
    public CallableReference(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }
}
