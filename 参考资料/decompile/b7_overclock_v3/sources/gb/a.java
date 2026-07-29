package gb;

import androidx.lifecycle.r0;
import hd.u0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f29102a = "ClearKeyUtil";

    public static byte[] a(byte[] bArr) {
        return u0.f31154a >= 27 ? bArr : u0.w0(c(u0.J(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (u0.f31154a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(u0.J(bArr));
            StringBuilder sb2 = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray(r0.f6237h);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                if (i10 != 0) {
                    sb2.append(ag.c.f654g);
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                sb2.append("{\"k\":\"");
                sb2.append(d(jSONObject2.getString("k")));
                sb2.append("\",\"kid\":\"");
                sb2.append(d(jSONObject2.getString("kid")));
                sb2.append("\",\"kty\":\"");
                sb2.append(jSONObject2.getString("kty"));
                sb2.append("\"}");
            }
            sb2.append("]}");
            return u0.w0(sb2.toString());
        } catch (JSONException e10) {
            hd.t.e(f29102a, "Failed to adjust response data: " + u0.J(bArr), e10);
            return bArr;
        }
    }

    public static String c(String str) {
        return str.replace('+', '-').replace(zc.f.f58380j, '_');
    }

    public static String d(String str) {
        return str.replace('-', '+').replace('_', zc.f.f58380j);
    }
}
