package a;

import android.content.Context;
import com.omarea.ui.Games;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.Games$addAppDialog$1$1", f = "Games.kt", l = {}, m = "invokeSuspend")
public final class y21 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7943a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Games.a f3651a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y21(Games.a aVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f3651a = aVar;
        this.f7943a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        y21 y21Var = new y21(this.f3651a, this.f7943a, b62Var);
        y21Var.f3650a = (wd2) obj;
        return y21Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((y21) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        Context context;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        try {
            Games.e(Games.this).c();
            context = Games.this.getContext();
        } catch (Exception unused) {
        }
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.vtools.activities.ActivityBase");
        }
        g91 g91Var = (g91) context;
        d80 d80Var = new d80(g91Var.getThemeMode().a(), (ArrayList) this.f7943a.f6891a, true, new x21(this));
        d80Var.G1(false);
        d80Var.B1(g91Var.getSupportFragmentManager(), "freeze-app-add");
        return m42.f6769a;
    }
}
