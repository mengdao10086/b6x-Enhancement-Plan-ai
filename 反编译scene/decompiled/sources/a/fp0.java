package a;

import android.util.Log;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fp0<V> implements Callable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mp0 f6126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f935a;

    public fp0(mp0 mp0Var, String str) {
        this.f6126a = mp0Var;
        this.f935a = str;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean call() {
        String strL;
        try {
            long time = new Date().getTime();
            mp0 mp0Var = this.f6126a;
            String str = no0.f6937a.a() + "/account-exist?t=" + time;
            g30 g30Var = new g30();
            Locale localeH = this.f6126a.H();
            if (localeH != null) {
                g30Var.x("locale", localeH.getLanguage());
            }
            g30Var.x("uid", this.f935a);
            g30Var.w("request_time", time);
            m42 m42Var = m42.f6769a;
            strL = mp0Var.l(str, g30Var);
        } catch (Exception unused) {
            Log.e("Scene", "Cloud Request(account exist), Fail!");
        }
        if (strL == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String string = ec2.r0(strL).toString();
        if ((string.length() > 0) && f92.a(string, "true")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
