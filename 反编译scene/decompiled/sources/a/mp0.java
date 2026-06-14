package a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.omarea.model.AccountPointsResponse;
import com.omarea.model.ActivationCodeResponse;
import com.omarea.model.DeviceBindInfo;
import com.omarea.model.ExchangeResponse;
import com.omarea.model.LoginResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mp0 extends r50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6831a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public mp0(Context context) {
        super(null, 1, 0 == true ? 1 : 0);
        f92.d(context, "context");
        this.f6831a = context;
    }

    public static /* synthetic */ LoginResponse O(mp0 mp0Var, String str, String str2, boolean z, g30 g30Var, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            g30Var = null;
        }
        return mp0Var.N(str, str2, z, g30Var);
    }

    public final FutureTask<String> A() {
        FutureTask<String> futureTask = new FutureTask<>(new dp0(this));
        qc2.d(xd2.a(qe2.b()), null, null, new cp0(futureTask, null), 3, null);
        return futureTask;
    }

    public final g30 B() {
        g30 g30VarM0 = e50.f677a.m0();
        if (g30VarM0 != null) {
            g30VarM0.x("product_model", Build.MODEL);
            g30VarM0.x("product_name", Build.PRODUCT);
            g30VarM0.x("product_brand", Build.BRAND);
            g30VarM0.x("product_manufacturer", Build.MANUFACTURER);
            g30VarM0.x("product_device", Build.DEVICE);
            g30VarM0.x("machine", jm0.f6525a.a());
        }
        return g30VarM0;
    }

    public final ExchangeResponse C(String str, boolean z) {
        f92.d(str, "key");
        g30 g30VarB = B();
        if (g30VarB == null) {
            return null;
        }
        String str2 = no0.f6937a.a() + "/release-exchange";
        g30 g30Var = new g30();
        Locale localeH = H();
        if (localeH != null) {
            g30Var.x("locale", localeH.getLanguage());
        }
        g30Var.x("key", str);
        g30Var.y("confirm", z);
        g30Var.x("device_info", g30VarB);
        m42 m42Var = m42.f6769a;
        g30 g30VarN = r50.n(this, str2, g30Var, 0L, 4, null);
        if (g30VarN == null) {
            return null;
        }
        try {
            Object objP = new vn0().p(g30VarN, new ExchangeResponse().getClass());
            String string = g30VarN.toString();
            f92.c(string, "response.toString()");
            ((ExchangeResponse) objP).setDetail(string);
            return (ExchangeResponse) objP;
        } catch (Exception unused) {
            return null;
        }
    }

    public final FutureTask<Boolean> D(String str) {
        f92.d(str, "uid");
        FutureTask<Boolean> futureTask = new FutureTask<>(new fp0(this, str));
        qc2.d(xd2.a(qe2.b()), null, null, new ep0(futureTask, null), 3, null);
        return futureTask;
    }

    public final ActivationCodeResponse E() {
        g30 g30VarB = B();
        String strL0 = e50.f677a.l0();
        long time = new Date().getTime();
        if (g30VarB == null) {
            return null;
        }
        g30 g30Var = new g30();
        g30Var.x("device", g30VarB);
        Locale localeH = H();
        if (localeH != null) {
            g30Var.x("locale", localeH.getLanguage());
        }
        if (strL0 != null) {
            g30Var.x("scene_version", strL0);
        }
        g30Var.w("request_time", time);
        String strP = r50.p(this, no0.f6937a.a() + "/release-activate2?t=" + time, g30Var, 0L, 4, null);
        if (strP == null) {
            new no0().A(true);
            return null;
        }
        String strK = k(strP);
        vn0 vn0Var = new vn0();
        new ActivationCodeResponse();
        ActivationCodeResponse activationCodeResponse = (ActivationCodeResponse) vn0Var.q(strK, ActivationCodeResponse.class);
        activationCodeResponse.setDetail(strK);
        return activationCodeResponse;
    }

    public final FutureTask<String> F() {
        FutureTask<String> futureTask = new FutureTask<>(new hp0(this));
        qc2.d(xd2.a(qe2.b()), null, null, new gp0(futureTask, null), 3, null);
        return futureTask;
    }

    public final FutureTask<ArrayList<DeviceBindInfo>> G(String str) {
        f92.d(str, "uid");
        FutureTask<ArrayList<DeviceBindInfo>> futureTask = new FutureTask<>(new jp0(this, str));
        qc2.d(xd2.a(qe2.b()), null, null, new ip0(futureTask, null), 3, null);
        return futureTask;
    }

    public final Locale H() {
        if (Build.VERSION.SDK_INT < 24) {
            Resources resources = this.f6831a.getResources();
            f92.c(resources, "context.resources");
            return resources.getConfiguration().locale;
        }
        Resources resources2 = this.f6831a.getResources();
        f92.c(resources2, "context.resources");
        Configuration configuration = resources2.getConfiguration();
        f92.c(configuration, "context.resources.configuration");
        return configuration.getLocales().get(0);
    }

    public final FutureTask<String> I() {
        FutureTask<String> futureTask = new FutureTask<>(new lp0(this));
        qc2.d(xd2.a(qe2.b()), null, null, new kp0(futureTask, null), 3, null);
        return futureTask;
    }

    public final LoginResponse J(String str) {
        String string;
        f92.d(str, "uid");
        g30 g30VarB = B();
        if (g30VarB == null) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setError("无法获取设备标识");
            return loginResponse;
        }
        String str2 = no0.f6937a.a() + "/account-unbind";
        g30 g30Var = new g30();
        Locale localeH = H();
        if (localeH != null) {
            g30Var.x("locale", localeH.getLanguage());
        }
        g30Var.x("uid", str);
        String str3 = "";
        g30Var.x("password", "");
        g30Var.x("device_info", g30VarB);
        m42 m42Var = m42.f6769a;
        g30 g30VarN = r50.n(this, str2, g30Var, 0L, 4, null);
        try {
            Object objP = new vn0().p(g30VarN, new LoginResponse().getClass());
            LoginResponse loginResponse2 = (LoginResponse) objP;
            if (g30VarN != null && (string = g30VarN.toString()) != null) {
                str3 = string;
            }
            loginResponse2.setDetail(str3);
            return (LoginResponse) objP;
        } catch (Exception unused) {
            return null;
        }
    }

    public final LoginResponse K(String str, String str2) throws e30 {
        f92.d(str, "uid");
        f92.d(str2, "password");
        g30 g30VarB = B();
        String strL0 = e50.f677a.l0();
        if (g30VarB == null) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setError("无法获取设备标识");
            return loginResponse;
        }
        long time = new Date().getTime();
        String str3 = no0.f6937a.a() + "/account-bind?t=" + time;
        g30 g30Var = new g30();
        Locale localeH = H();
        if (localeH != null) {
            g30Var.x("locale", localeH.getLanguage());
        }
        if (strL0 != null) {
            g30Var.x("scene_version", strL0);
        }
        g30Var.x("uid", str);
        g30Var.x("password", L(str2));
        g30Var.x("device_info", g30VarB);
        g30Var.w("request_time", time);
        m42 m42Var = m42.f6769a;
        g30 g30VarN = r50.n(this, str3, g30Var, 0L, 4, null);
        if (g30VarN != null) {
            try {
                Object objP = new vn0().p(g30VarN, new LoginResponse().getClass());
                String string = g30VarN.toString();
                f92.c(string, "response.toString()");
                ((LoginResponse) objP).setDetail(string);
                return (LoginResponse) objP;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final String L(String str) {
        f92.d(str, "password");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            f92.c(messageDigest, "MessageDigest.getInstance(\"MD5\")");
            byte[] bytes = str.getBytes(bb2.f5692a);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            f92.c(bArrDigest, "instance.digest(password.toByteArray())");
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            String string = stringBuffer.toString();
            f92.c(string, "sb.toString()");
            return string;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final LoginResponse M(String str, String str2, g30 g30Var) {
        f92.d(str, "uid");
        f92.d(str2, "password");
        f92.d(g30Var, "deviceInfo");
        String strL0 = e50.f677a.l0();
        String str3 = no0.f6937a.a() + "/account-unbind";
        g30 g30Var2 = new g30();
        Locale localeH = H();
        if (localeH != null) {
            g30Var2.x("locale", localeH.getLanguage());
        }
        if (strL0 != null) {
            g30Var2.x("scene_version", strL0);
        }
        g30Var2.x("uid", str);
        g30Var2.x("password", L(str2));
        g30Var2.x("device_info", g30Var);
        m42 m42Var = m42.f6769a;
        g30 g30VarN = r50.n(this, str3, g30Var2, 0L, 4, null);
        if (g30VarN != null) {
            try {
                Object objP = new vn0().p(g30VarN, new LoginResponse().getClass());
                LoginResponse loginResponse = (LoginResponse) objP;
                String string = g30VarN.toString();
                if (string == null) {
                    string = "";
                }
                loginResponse.setDetail(string);
                return (LoginResponse) objP;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final LoginResponse N(String str, String str2, boolean z, g30 g30Var) {
        f92.d(str, "uid");
        f92.d(str2, "password");
        g30 g30VarB = g30Var != null ? g30Var : B();
        String strL0 = e50.f677a.l0();
        if (g30VarB == null) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setError("无法获取设备标识");
            return loginResponse;
        }
        String str3 = no0.f6937a.a() + "/account-set-main";
        g30 g30Var2 = new g30();
        Locale localeH = H();
        if (localeH != null) {
            g30Var2.x("locale", localeH.getLanguage());
        }
        if (strL0 != null) {
            g30Var2.x("scene_version", strL0);
        }
        g30Var2.x("uid", str);
        g30Var2.x("password", L(str2));
        g30Var2.x("device_info", g30VarB);
        g30Var2.y("complement", z);
        m42 m42Var = m42.f6769a;
        g30 g30VarN = r50.n(this, str3, g30Var2, 0L, 4, null);
        if (g30VarN != null) {
            try {
                Object objP = new vn0().p(g30VarN, new LoginResponse().getClass());
                String string = g30VarN.toString();
                f92.c(string, "response.toString()");
                ((LoginResponse) objP).setDetail(string);
                return (LoginResponse) objP;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final FutureTask<AccountPointsResponse> z(String str, String str2) {
        f92.d(str, "uid");
        f92.d(str2, "password");
        FutureTask<AccountPointsResponse> futureTask = new FutureTask<>(new bp0(this, str, str2));
        qc2.d(xd2.a(qe2.b()), null, null, new ap0(futureTask, null), 3, null);
        return futureTask;
    }
}
