package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.scene_mode.ModeSwitcher", f = "ModeSwitcher.kt", l = {258}, m = "executeMode")
public final class vu0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wu0 f3305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f3306a;
    public Object b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3307b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vu0(wu0 wu0Var, b62 b62Var) {
        super(b62Var);
        this.f3305a = wu0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f3306a = obj;
        this.f7725a |= Integer.MIN_VALUE;
        return this.f3305a.o(null, null, null, this);
    }
}
