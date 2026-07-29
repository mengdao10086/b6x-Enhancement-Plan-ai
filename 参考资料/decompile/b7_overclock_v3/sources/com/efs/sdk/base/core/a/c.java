package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsConstant;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.PackageUtil;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import hb.u;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import l4.f;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f12788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f12789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f12790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f12791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f12792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f12793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f12794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f12795m = 0;

    public static c a() {
        c cVar = new c();
        cVar.f12783a = ControllerCenter.getGlobalEnvStruct().getAppid();
        cVar.f12784b = ControllerCenter.getGlobalEnvStruct().getSecret();
        cVar.f12794l = ControllerCenter.getGlobalEnvStruct().getUid();
        cVar.f12792j = BuildConfig.VERSION_NAME;
        cVar.f12785c = PackageUtil.getAppVersionName(ControllerCenter.getGlobalEnvStruct().mAppContext);
        cVar.f12791i = String.valueOf(com.efs.sdk.base.core.config.a.c.a().f12860d.f12850a);
        cVar.f12793k = EfsConstant.UM_SDK_VERSION;
        return cVar;
    }

    public final String b() {
        a.a();
        String strValueOf = String.valueOf(a.b() / 1000);
        String strA = com.efs.sdk.base.core.util.b.b.a(com.efs.sdk.base.core.util.b.a.a(this.f12794l + strValueOf, this.f12784b));
        TreeMap treeMap = new TreeMap();
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, this.f12783a);
        treeMap.put("sd", strA);
        if (!TextUtils.isEmpty(this.f12786d)) {
            treeMap.put("cp", this.f12786d);
        }
        if (this.f12789g != 0) {
            treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_DE, String.valueOf(this.f12787e));
            treeMap.put("type", this.f12790h);
            String str = this.f12788f;
            if (TextUtils.isEmpty(str)) {
                a.a();
                long jB = a.b();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(jB), Integer.valueOf(new Random(jB).nextInt(10000)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.f12791i);
        treeMap.put("os", f.f39447b);
        treeMap.put("sver", this.f12791i);
        treeMap.put("tm", strValueOf);
        treeMap.put("ver", this.f12785c);
        treeMap.put("um_sdk_ver", this.f12793k);
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + u.f30904o + ((String) entry.getValue());
            sb3.append(str2);
            sb2.append(str2);
            sb2.append("&");
        }
        String strA2 = com.efs.sdk.base.core.util.b.b.a(sb3.toString() + this.f12784b);
        sb2.append("sign=");
        sb2.append(strA2);
        Log.d("efs.config", sb2.toString());
        return com.efs.sdk.base.core.util.b.b.b(sb2.toString());
    }
}
