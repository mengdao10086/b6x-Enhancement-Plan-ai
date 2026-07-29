package cd;

import android.graphics.Color;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static String a(String str) {
        return j3.b.f36044h + str + ",." + str + " *";
    }

    public static String b(@g.l int i10) {
        return u0.I("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)), Double.valueOf(((double) Color.alpha(i10)) / 255.0d));
    }
}
