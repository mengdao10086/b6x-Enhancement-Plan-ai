package com.umeng.socialize.net.verify;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class VerifyResponse extends SocializeReseponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24772b;

    public VerifyResponse(Integer num, JSONObject jSONObject) {
        super(null);
        this.f24771a = num.intValue();
        this.f24772b = false;
        parseJsonObject(jSONObject);
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isHttpOK() {
        return this.f24771a == 200;
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isOk() {
        return this.f24772b;
    }

    public void parseJsonObject(JSONObject jSONObject) {
        try {
            if (jSONObject.getString(CommonNetImpl.RESULT).startsWith("success")) {
                this.f24772b = true;
            } else {
                this.f24772b = false;
            }
        } catch (JSONException e10) {
            SLog.error(UmengText.NET.PARSEERROR, e10);
        }
    }
}
