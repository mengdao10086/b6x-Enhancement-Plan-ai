package a;

import android.widget.LinearLayout;
import com.omarea.vtools.activities.ActivityAppContents;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityAppContents$onCreate$1$1", f = "ActivityAppContents.kt", l = {}, m = "invokeSuspend")
public final class d81 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppContents.b f515a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d81(ActivityAppContents.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f515a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        d81 d81Var = new d81(this.f515a, b62Var);
        d81Var.f5872a = (wd2) obj;
        return d81Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((d81) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        LinearLayout linearLayout = (LinearLayout) ActivityAppContents.this._$_findCachedViewById(t61.loading_view);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        return m42.f6769a;
    }
}
