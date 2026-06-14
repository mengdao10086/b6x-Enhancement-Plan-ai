package a;

import android.util.Log;
import com.omarea.model.DeviceBindInfo;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jp0<V> implements Callable<ArrayList<DeviceBindInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mp0 f6533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1576a;

    public jp0(mp0 mp0Var, String str) {
        this.f6533a = mp0Var;
        this.f1576a = str;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ArrayList<DeviceBindInfo> call() {
        String strL;
        String strI;
        try {
            g30 g30VarB = this.f6533a.B();
            mp0 mp0Var = this.f6533a;
            String str = no0.f6937a.a() + "/account-devices";
            g30 g30Var = new g30();
            Locale localeH = this.f6533a.H();
            if (localeH != null) {
                g30Var.x("locale", localeH.getLanguage());
            }
            g30Var.x("device_info", g30VarB);
            g30Var.x("uid", this.f1576a);
            g30Var.x("password", "");
            m42 m42Var = m42.f6769a;
            strL = mp0Var.l(str, g30Var);
        } catch (Exception unused) {
            Log.e("Scene", "Cloud Request(exchangeCode), Fail!");
        }
        if (strL == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String string = ec2.r0(strL).toString();
        if (string.length() > 0) {
            try {
                ArrayList<DeviceBindInfo> arrayList = new ArrayList<>();
                d30 d30Var = new d30(string);
                int iG = d30Var.g();
                for (int i = 0; i < iG; i++) {
                    g30 g30VarD = d30Var.d(i);
                    DeviceBindInfo deviceBindInfo = new DeviceBindInfo();
                    f92.c(g30VarD, "obj");
                    deviceBindInfo.setItem(g30VarD);
                    String strI2 = g30VarD.i("device_id");
                    if (g30VarD.j("product_model")) {
                        strI = g30VarD.i("product_model");
                        f92.c(strI, "obj.getString(\"product_model\")");
                    } else {
                        strI = "";
                    }
                    if (strI.length() == 0) {
                        f92.c(strI2, "id");
                        strI = strI2;
                    }
                    deviceBindInfo.setCurrent(g30VarD.c("current"));
                    deviceBindInfo.setName(strI);
                    f92.c(strI2, "id");
                    deviceBindInfo.setId(strI2);
                    arrayList.add(deviceBindInfo);
                }
                return arrayList;
            } catch (Exception e) {
                e.toString();
                return null;
            }
        }
        return null;
    }
}
