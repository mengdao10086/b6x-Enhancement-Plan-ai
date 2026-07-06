package a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a01 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f0a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ n92 f1b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a01(n92 n92Var, n92 n92Var2, b62 b62Var) {
        super(2, b62Var);
        this.f5554a = n92Var;
        this.f1b = n92Var2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        a01 a01Var = new a01(this.f5554a, this.f1b, b62Var);
        a01Var.f0a = (wd2) obj;
        return a01Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((a01) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((ImageView) this.f5554a.f6891a).setImageDrawable((Drawable) this.f1b.f6891a);
        return m42.f6769a;
    }
}
