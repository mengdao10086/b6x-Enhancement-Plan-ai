package a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n41 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2005a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ n92 f2006b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n41(n92 n92Var, n92 n92Var2, b62 b62Var) {
        super(2, b62Var);
        this.f6873a = n92Var;
        this.f2006b = n92Var2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        n41 n41Var = new n41(this.f6873a, this.f2006b, b62Var);
        n41Var.f2005a = (wd2) obj;
        return n41Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((n41) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((ImageView) this.f6873a.f6891a).setImageDrawable((Drawable) this.f2006b.f6891a);
        return m42.f6769a;
    }
}
