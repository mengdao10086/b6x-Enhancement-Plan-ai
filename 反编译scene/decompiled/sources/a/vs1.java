package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentHome", f = "FragmentHome.kt", l = {289}, m = "updateRamInfo")
public final class vs1 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zs1 f3302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f3303a;
    public Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vs1(zs1 zs1Var, b62 b62Var) {
        super(b62Var);
        this.f3302a = zs1Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f3303a = obj;
        this.f7721a |= Integer.MIN_VALUE;
        return this.f3302a.T1(this);
    }
}
