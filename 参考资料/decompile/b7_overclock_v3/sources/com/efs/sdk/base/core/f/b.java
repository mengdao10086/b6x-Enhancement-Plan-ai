package com.efs.sdk.base.core.f;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.record.AbsRecordLog;
import hb.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AbsRecordLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12908d;

    public b(String str, String str2, String str3) {
        super("wa");
        this.f12905a = str;
        this.f12906b = str2;
        this.f12908d = str3;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.CHINA);
        com.efs.sdk.base.core.a.a.a();
        this.f12907c = simpleDateFormat.format(new Date(com.efs.sdk.base.core.a.a.b()));
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final byte[] generate() {
        String strGenerateString = generateString();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.i("efs.base", strGenerateString);
        }
        return strGenerateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String generateString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("lt=event`");
        sb2.append("ev_ct=");
        sb2.append(this.f12905a);
        sb2.append("`");
        sb2.append("ev_ac=");
        sb2.append(this.f12906b);
        sb2.append("`");
        sb2.append("tm=");
        sb2.append(this.f12907c);
        sb2.append("`");
        sb2.append("dn=");
        sb2.append(this.f12908d);
        sb2.append("`");
        for (Map.Entry<String, Object> entry : this.dataMap.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append(u.f30904o);
            sb2.append(entry.getValue());
            sb2.append("`");
        }
        return sb2.subSequence(0, sb2.length() - 1).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkId() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkKey() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void insertGlobal(com.efs.sdk.base.core.config.a aVar) {
        this.dataMap.putAll(aVar.a());
        this.dataMap.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }
}
