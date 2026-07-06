package a;

import a.tw0;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.scene_mode.SceneMode$Companion", f = "SceneMode.kt", l = {168}, m = "getForegroundApps")
public final class sw0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ tw0.a f2932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f2933a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sw0(tw0.a aVar, b62 b62Var) {
        super(b62Var);
        this.f2932a = aVar;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f2933a = obj;
        this.f7438a |= Integer.MIN_VALUE;
        return this.f2932a.c(this);
    }
}
