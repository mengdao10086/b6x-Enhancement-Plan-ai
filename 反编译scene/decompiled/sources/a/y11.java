package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.AdapterProcess", f = "AdapterProcess.kt", l = {151}, m = "initAppName")
public final class y11 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7941a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ a21 f3645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f3646a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3647b;
    public Object c;
    public Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y11(a21 a21Var, b62 b62Var) {
        super(b62Var);
        this.f3645a = a21Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f3646a = obj;
        this.f7941a |= Integer.MIN_VALUE;
        return this.f3645a.d(this);
    }
}
