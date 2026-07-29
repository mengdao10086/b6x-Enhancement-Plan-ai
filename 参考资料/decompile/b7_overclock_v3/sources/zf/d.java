package zf;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f58574a = "channel";

    public static c a(File file) {
        Map<String, String> mapB = b(file);
        if (mapB == null) {
            return null;
        }
        String str = mapB.get("channel");
        mapB.remove("channel");
        return new c(str, mapB);
    }

    public static Map<String, String> b(File file) {
        try {
            String strC = c(file);
            if (strC == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strC);
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                map.put(string, jSONObject.getString(string));
            }
            return map;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String c(File file) {
        return f.d(file, a.f58560g);
    }
}
