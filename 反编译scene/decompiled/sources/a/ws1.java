package a;

import a.p80;
import android.content.Context;
import android.widget.TextView;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ws1 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ys1 f7819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3477a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ws1(TextView textView, ys1 ys1Var, long j, long j2, float f) {
        super(0);
        this.f3477a = textView;
        this.f7819a = ys1Var;
    }

    public final void a() {
        p80.a aVar = p80.f2403a;
        Context context = this.f3477a.getContext();
        f92.b(context);
        String strY0 = e50.f677a.y0();
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (strY0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = strY0.toUpperCase(locale);
        f92.c(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        p80.a.B(aVar, context, upperCase, ub2.e("Used(Actual) =\n                                    |(\n                                    |   MemTotal + SwapTotal\n                                    |    - MemAvailable\n                                    |    - SwapFree\n                                    |    - ZramMemUsed\n                                    |) / MemTotal\n                                    |\n                                    |(\n                                    |   " + this.f7819a.f3770a + " + " + this.f7819a.f3771a.e() + "\n                                    |    - " + this.f7819a.b + "\n                                    |    - " + (this.f7819a.f3771a.d() / 1024) + "\n                                    |    - " + this.f7819a.f3773a + "\n                                    |) / " + this.f7819a.f3770a + "\n                                    |", null, 1, null), null, 8, null);
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
