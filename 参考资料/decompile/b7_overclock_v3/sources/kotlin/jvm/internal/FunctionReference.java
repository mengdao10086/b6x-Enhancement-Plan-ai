package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public class FunctionReference extends CallableReference implements b0, kotlin.reflect.i {
    private final int arity;

    @kotlin.v0(version = "1.4")
    private final int flags;

    public FunctionReference(int i10) {
        this(i10, CallableReference.f37869b, null, null, null, 0);
    }

    @Override // kotlin.reflect.i
    @kotlin.v0(version = "1.1")
    public boolean D0() {
        return U0().D0();
    }

    @Override // kotlin.reflect.i
    @kotlin.v0(version = "1.1")
    public boolean L() {
        return U0().L();
    }

    @Override // kotlin.reflect.i
    @kotlin.v0(version = "1.1")
    public boolean N0() {
        return U0().N0();
    }

    @Override // kotlin.jvm.internal.CallableReference
    @kotlin.v0(version = "1.1")
    public kotlin.reflect.c R0() {
        return n0.c(this);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @kotlin.v0(version = "1.1")
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.i U0() {
        return (kotlin.reflect.i) super.U0();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && V0().equals(functionReference.V0()) && this.flags == functionReference.flags && this.arity == functionReference.arity && f0.g(S0(), functionReference.S0()) && f0.g(T0(), functionReference.T0());
        }
        if (obj instanceof kotlin.reflect.i) {
            return obj.equals(Q0());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.b0
    public int h() {
        return this.arity;
    }

    public int hashCode() {
        return (((T0() == null ? 0 : T0().hashCode() * 31) + getName().hashCode()) * 31) + V0().hashCode();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
    @kotlin.v0(version = "1.1")
    public boolean m() {
        return U0().m();
    }

    public String toString() {
        kotlin.reflect.c cVarQ0 = Q0();
        if (cVarQ0 != this) {
            return cVarQ0.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + n0.f37924b;
    }

    @Override // kotlin.reflect.i
    @kotlin.v0(version = "1.1")
    public boolean u() {
        return U0().u();
    }

    @kotlin.v0(version = "1.1")
    public FunctionReference(int i10, Object obj) {
        this(i10, obj, null, null, null, 0);
    }

    @kotlin.v0(version = "1.4")
    public FunctionReference(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.arity = i10;
        this.flags = i11 >> 1;
    }
}
