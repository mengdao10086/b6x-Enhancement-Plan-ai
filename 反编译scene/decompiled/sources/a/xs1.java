package a;

import a.p80;
import android.content.Context;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xs1 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ys1 f7917a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xs1(ys1 ys1Var) {
        super(0);
        this.f7917a = ys1Var;
    }

    public final void a() {
        p80.a aVar = p80.f2403a;
        Context contextP = this.f7917a.f3772a.p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        String strY0 = e50.f677a.y0();
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (strY0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = strY0.toUpperCase(locale);
        f92.c(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        p80.a.B(aVar, contextP, upperCase, ub2.e("Used(Maybe) =\n                                    |(\n                                    |   MemTotal + SwapTotal\n                                    |    - MemAvailable\n                                    |    - SwapFree\n                                    |) / MemTotal\n                                    |\n                                    |(\n                                    |   " + this.f7917a.f3770a + " + " + this.f7917a.f3771a.e() + "\n                                    |    - " + this.f7917a.b + "\n                                    |    - " + (this.f7917a.f3771a.d() / 1024) + "\n                                    |) / " + this.f7917a.f3770a + "\n                                    |", null, 1, null), null, 8, null);
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
