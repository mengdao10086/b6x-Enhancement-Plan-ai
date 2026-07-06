package a;

import android.util.Log;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lp0<V> implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mp0 f6729a;

    public lp0(mp0 mp0Var) {
        this.f6729a = mp0Var;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String call() {
        g30 g30VarB = this.f6729a.B();
        if (g30VarB == null) {
            return "";
        }
        try {
            mp0 mp0Var = this.f6729a;
            String str = no0.f6937a.a() + "/payment-wechat";
            g30 g30Var = new g30();
            Locale localeH = this.f6729a.H();
            if (localeH != null) {
                g30Var.x("locale", localeH.getLanguage());
            }
            g30Var.x("device_info", g30VarB);
            m42 m42Var = m42.f6769a;
            String strL = mp0Var.l(str, g30Var);
            if (strL == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String string = ec2.r0(strL).toString();
            if (string.length() > 0) {
                return string;
            }
            return null;
        } catch (Exception unused) {
            Log.e("Scene", "Cloud Request(wechat), Fail!");
            return null;
        }
    }
}
