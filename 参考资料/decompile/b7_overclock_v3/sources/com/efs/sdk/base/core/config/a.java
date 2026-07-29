package com.efs.sdk.base.core.config;

import android.text.TextUtils;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import zc.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f12848a = new ConcurrentHashMap();

    public final void a(String str, Object obj) {
        if (obj != null) {
            this.f12848a.put(str, obj);
        }
    }

    public final Object b(String str, Object obj) {
        Object obj2 = this.f12848a.get(str);
        return (obj2 != null || this.f12848a.containsKey(str)) ? obj2 : obj;
    }

    public final Map<String, Object> a() {
        HashMap map = new HashMap(this.f12848a);
        com.efs.sdk.base.core.a.a.a();
        map.put("ctime", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        map.put("w_tm", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        return map;
    }

    public final List<AbsSection> a(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection kVSectionPut = kVSection.put("type", str).put("appid", this.f12848a.get("appid")).put("wid", this.f12848a.get("wid")).put("pid", this.f12848a.get("pid")).put("pkg", this.f12848a.get("pkg")).put("ver", this.f12848a.get("ver")).put("vcode", this.f12848a.get("vcode")).put("ps", this.f12848a.get("ps")).put("stime", this.f12848a.get("stime"));
        com.efs.sdk.base.core.a.a.a();
        KVSection kVSectionPut2 = kVSectionPut.put("ctime", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        kVSectionPut2.put("w_tm", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000)).put(Constants.PARAM_SDK_VER, this.f12848a.get(Constants.PARAM_SDK_VER));
        String strValueOf = String.valueOf(b("uid", ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            kVSection.put("uid", strValueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put(f.f58391u, this.f12848a.get(f.f58391u)).put("brand", this.f12848a.get("brand")).put("model", this.f12848a.get("model")).put("build_model", this.f12848a.get("build_model")).put("rom", this.f12848a.get("rom")).put("sdk", this.f12848a.get("sdk")).put("dsp_h", this.f12848a.get("dsp_h")).put("dsp_w", this.f12848a.get("dsp_w")).put("tzone", this.f12848a.get("tzone")).put("net", this.f12848a.get("net")).put(SocializeProtocolConstants.PROTOCOL_KEY_FR, this.f12848a.get(SocializeProtocolConstants.PROTOCOL_KEY_FR));
        try {
            if (this.f12848a.containsKey(UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS, this.f12848a.get(UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.f12848a.containsKey(UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.f12848a.get(UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.f12848a.containsKey(UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_NETWORK_TYPE, this.f12848a.get(UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }
}
