package a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6079a;

    public f61(Context context) {
        f92.d(context, "context");
        this.f6079a = context;
    }

    public final void a() {
        try {
            String str = new mp0(this.f6079a).F().get(5L, TimeUnit.SECONDS);
            if (str == null || str.length() == 0) {
                return;
            }
            b(str);
        } catch (Exception unused) {
        }
    }

    public final void b(String str) {
        c(this.f6079a, str);
    }

    public final boolean c(Context context, String str) {
        try {
            if (bc2.x(str, "alipayqr://", false, 2, null) || bc2.x(str, "alipays://", false, 2, null)) {
                d(context, str);
                return true;
            }
            try {
                String strEncode = URLEncoder.encode(str, "utf-8");
                f92.c(strEncode, "URLEncoder.encode(qrcode, \"utf-8\")");
                str = strEncode;
            } catch (Exception unused) {
            }
            d(context, ("alipayqr://platformapi/startapp?saId=10000007&qrcode=" + str) + "%3F_s%3Dweb-other&_t=" + System.currentTimeMillis());
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }

    public final void d(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
