package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PropertyReference extends CallableReference implements kotlin.reflect.n {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.reflect.n
    @kotlin.v0(version = "1.1")
    public boolean K0() {
        return U0().K0();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.c Q0() {
        return this.syntheticJavaProperty ? this : super.Q0();
    }

    @Override // kotlin.jvm.internal.CallableReference
    @kotlin.v0(version = "1.1")
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.n U0() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
        }
        return (kotlin.reflect.n) super.U0();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return T0().equals(propertyReference.T0()) && getName().equals(propertyReference.getName()) && V0().equals(propertyReference.V0()) && f0.g(S0(), propertyReference.S0());
        }
        if (obj instanceof kotlin.reflect.n) {
            return obj.equals(Q0());
        }
        return false;
    }

    public int hashCode() {
        return (((T0().hashCode() * 31) + getName().hashCode()) * 31) + V0().hashCode();
    }

    public String toString() {
        kotlin.reflect.c cVarQ0 = Q0();
        if (cVarQ0 != this) {
            return cVarQ0.toString();
        }
        return "property " + getName() + n0.f37924b;
    }

    @Override // kotlin.reflect.n
    @kotlin.v0(version = "1.1")
    public boolean w() {
        return U0().w();
    }

    @kotlin.v0(version = "1.1")
    public PropertyReference(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    @kotlin.v0(version = "1.4")
    public PropertyReference(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.syntheticJavaProperty = (i10 & 2) == 2;
    }
}
