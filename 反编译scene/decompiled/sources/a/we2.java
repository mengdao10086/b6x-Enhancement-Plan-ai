package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class we2 extends ye2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ af2 f7781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tc2<m42> f3431a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public we2(af2 af2Var, long j, tc2<? super m42> tc2Var) {
        super(j);
        this.f7781a = af2Var;
        this.f3431a = tc2Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3431a.e(this.f7781a, m42.f6769a);
    }

    @Override // a.ye2
    public String toString() {
        return super.toString() + this.f3431a.toString();
    }
}
