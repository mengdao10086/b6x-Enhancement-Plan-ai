package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ji2<T> extends hc2<T> implements w62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b62<T> f6514a;

    /* JADX WARN: Multi-variable type inference failed */
    public ji2(l62 l62Var, b62<? super T> b62Var) {
        super(l62Var, true);
        this.f6514a = b62Var;
    }

    @Override // a.hc2
    public void D0(Object obj) {
        b62<T> b62Var = this.f6514a;
        b62Var.y(hd2.a(obj, b62Var));
    }

    @Override // a.bg2
    public void E(Object obj) {
        me2.b(q62.b(this.f6514a), hd2.a(obj, this.f6514a));
    }

    @Override // a.bg2
    public final boolean e0() {
        return true;
    }

    @Override // a.w62
    public final StackTraceElement p() {
        return null;
    }

    @Override // a.w62
    public final w62 v() {
        return (w62) this.f6514a;
    }
}
