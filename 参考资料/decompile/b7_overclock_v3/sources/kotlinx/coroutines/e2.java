package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.s0
public class e2 extends JobSupport implements a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f38470c;

    public e2(@yt.l c2 c2Var) {
        super(true);
        N0(c2Var);
        this.f38470c = E1();
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean B0() {
        return this.f38470c;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean E0() {
        return true;
    }

    public final boolean E1() {
        JobSupport jobSupportS;
        u uVarJ0 = J0();
        v vVar = uVarJ0 instanceof v ? (v) uVarJ0 : null;
        if (vVar != null && (jobSupportS = vVar.S()) != null) {
            while (!jobSupportS.B0()) {
                u uVarJ02 = jobSupportS.J0();
                v vVar2 = uVarJ02 instanceof v ? (v) uVarJ02 : null;
                if (vVar2 == null || (jobSupportS = vVar2.S()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.a0
    public boolean a() {
        return W0(kotlin.z1.f38230a);
    }

    @Override // kotlinx.coroutines.a0
    public boolean l(@yt.k Throwable th2) {
        return W0(new c0(th2, false, 2, null));
    }
}
