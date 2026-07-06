package a;

import android.view.View;
import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatQuicklyGrant$show$1$1", f = "FloatQuicklyGrant.kt", l = {}, m = "invokeSuspend")
public final class b12 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c12 f5664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f196a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ n92 f197b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b12(c12 c12Var, n92 n92Var, n92 n92Var2, b62 b62Var) {
        super(2, b62Var);
        this.f5664a = c12Var;
        this.f195a = n92Var;
        this.f197b = n92Var2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        b12 b12Var = new b12(this.f5664a, this.f195a, this.f197b, b62Var);
        b12Var.f196a = (wd2) obj;
        return b12Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((b12) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        if (((eh0) this.f195a.f6891a).b() == null) {
            this.f5664a.f317a.c();
        } else {
            try {
                View viewFindViewById = this.f5664a.f317a.f1093a.findViewById(2131362213);
                f92.c(viewFindViewById, "view.findViewById<TextView>(R.id.confirm_message)");
                q92 q92Var = q92.f7191a;
                String string = this.f5664a.f317a.f1092a.getString(u61.appops_quickly_grant_app);
                f92.c(string, "mContext.getString(R.str…appops_quickly_grant_app)");
                String str = String.format(string, Arrays.copyOf(new Object[]{((eh0) this.f195a.f6891a).a(), (String) this.f197b.f6891a}, 2));
                f92.c(str, "java.lang.String.format(format, *args)");
                ((TextView) viewFindViewById).setText(str);
            } catch (Exception unused) {
            }
        }
        return m42.f6769a;
    }
}
