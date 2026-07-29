package ar;

import gm.c0;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import np.n1;
import org.bouncycastle.util.j;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f8865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f8866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f8867c;

    public static class a implements PrivilegedExceptionAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8868a;

        public a(String str) {
            this.f8868a = str;
        }

        @Override // java.security.PrivilegedExceptionAction
        public Object run() throws Exception {
            return g.f8865a.getDeclaredMethod(this.f8868a, new Class[0]);
        }
    }

    public static class b implements PrivilegedExceptionAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n1 f8869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AlgorithmParameterSpec f8870b;

        public b(n1 n1Var, AlgorithmParameterSpec algorithmParameterSpec) {
            this.f8869a = n1Var;
            this.f8870b = algorithmParameterSpec;
        }

        @Override // java.security.PrivilegedExceptionAction
        public Object run() throws Exception {
            return new np.a(this.f8869a, ((Integer) g.f8866b.invoke(this.f8870b, new Object[0])).intValue(), (byte[]) g.f8867c.invoke(this.f8870b, new Object[0]));
        }
    }

    public static class c implements PrivilegedExceptionAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlgorithmParameterSpec f8871a;

        public c(AlgorithmParameterSpec algorithmParameterSpec) {
            this.f8871a = algorithmParameterSpec;
        }

        @Override // java.security.PrivilegedExceptionAction
        public Object run() throws Exception {
            return new cq.c((byte[]) g.f8867c.invoke(this.f8871a, new Object[0]), ((Integer) g.f8866b.invoke(this.f8871a, new Object[0])).intValue() / 8);
        }
    }

    static {
        Method methodD;
        Class clsA = f.a(g.class, "javax.crypto.spec.GCMParameterSpec");
        f8865a = clsA;
        if (clsA != null) {
            f8866b = d("getTLen");
            methodD = d("getIV");
        } else {
            methodD = null;
            f8866b = null;
        }
        f8867c = methodD;
    }

    public static np.a a(n1 n1Var, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        try {
            return (np.a) AccessController.doPrivileged(new b(n1Var, algorithmParameterSpec));
        } catch (Exception unused) {
            throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
        }
    }

    public static cq.c b(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        try {
            return (cq.c) AccessController.doPrivileged(new c(algorithmParameterSpec));
        } catch (Exception unused) {
            throw new InvalidParameterSpecException("Cannot process GCMParameterSpec");
        }
    }

    public static AlgorithmParameterSpec c(c0 c0Var) throws InvalidParameterSpecException {
        try {
            cq.c cVarY = cq.c.y(c0Var);
            return (AlgorithmParameterSpec) f8865a.getConstructor(Integer.TYPE, byte[].class).newInstance(j.g(cVarY.x() * 8), cVarY.z());
        } catch (NoSuchMethodException unused) {
            throw new InvalidParameterSpecException("No constructor found!");
        } catch (Exception e10) {
            throw new InvalidParameterSpecException("Construction failed: " + e10.getMessage());
        }
    }

    public static Method d(String str) {
        try {
            return (Method) AccessController.doPrivileged(new a(str));
        } catch (PrivilegedActionException unused) {
            return null;
        }
    }

    public static boolean e() {
        return f8865a != null;
    }

    public static boolean f(Class cls) {
        return f8865a == cls;
    }

    public static boolean g(AlgorithmParameterSpec algorithmParameterSpec) {
        Class cls = f8865a;
        return cls != null && cls.isInstance(algorithmParameterSpec);
    }
}
