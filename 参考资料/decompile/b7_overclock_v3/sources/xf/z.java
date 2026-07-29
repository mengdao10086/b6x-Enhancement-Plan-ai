package xf;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.just.agentweb.JsCallback;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w.w;

/* JADX INFO: loaded from: classes7.dex */
public class z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f55302e = "JsCallJava";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f55303f = "{\"CODE\": %d, \"result\": %s}";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f55304g = "AgentWeb:";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f55305h = "obj";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f55306i = "method";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f55307j = "types";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f55308k = "args";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f55309l = {"getClass", "hashCode", "notify", "notifyAll", "equals", "toString", "wait"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, Method> f55310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f55311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f55312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f55313d;

    public z(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.f55311b = obj;
            this.f55312c = str;
            this.f55310a = new HashMap<>();
            Method[] methods = this.f55311b.getClass().getMethods();
            StringBuilder sb2 = new StringBuilder("javascript:(function(b){console.log(\"");
            sb2.append(this.f55312c);
            sb2.append(" init begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : methods) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("method:");
                sb3.append(method);
                String strB = b(method);
                if (strB != null) {
                    this.f55310a.put(strB, method);
                    sb2.append(String.format("a.%s=", method.getName()));
                }
            }
            sb2.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb2.append(this.f55312c);
            sb2.append(" call result, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var k = new Date().getTime();var l = f.shift();var m=prompt('");
            sb2.append(f55304g);
            sb2.append("'+JSON.stringify(");
            sb2.append(h("'" + this.f55312c + "'", com.flydigi.sdk.bluetooth.l.f16298a, "e", "f"));
            sb2.append("));console.log(\"invoke \"+l+\", time: \"+(new Date().getTime()-k));var g=JSON.parse(m);if(g.CODE!=200){throw\"");
            sb2.append(this.f55312c);
            sb2.append(" call result, CODE:\"+g.CODE+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb2.append(this.f55312c);
            sb2.append("=a;console.log(\"");
            sb2.append(this.f55312c);
            sb2.append(" init end\")})(window)");
            this.f55313d = sb2.toString();
            sb2.setLength(0);
        } catch (Exception e10) {
            if (c0.d()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("init js result:");
                sb4.append(e10.getMessage());
            }
        }
    }

    public static String c(JSONObject jSONObject) {
        return jSONObject.optString("obj");
    }

    public static JSONObject d(String str) {
        try {
            return new JSONObject(str.substring(9));
        } catch (JSONException e10) {
            e10.printStackTrace();
            return new JSONObject();
        }
    }

    public static boolean g(String str) {
        return str.startsWith(f55304g);
    }

    public static String h(String str, String str2, String str3, String str4) {
        return zc.a.f58316d + "obj:" + str + ag.c.f654g + f55306i + ":" + str2 + ag.c.f654g + f55307j + ":" + str3 + ag.c.f654g + "args:" + str4 + zc.a.f58317e;
    }

    public String a(WebView webView, JSONObject jSONObject) {
        long jUptimeMillis = c0.d() ? SystemClock.uptimeMillis() : 0L;
        if (jSONObject == null) {
            return f(jSONObject, 500, "call data empty", jUptimeMillis);
        }
        try {
            String string = jSONObject.getString(f55306i);
            JSONArray jSONArray = jSONObject.getJSONArray(f55307j);
            JSONArray jSONArray2 = jSONObject.getJSONArray("args");
            int length = jSONArray.length();
            Object[] objArr = new Object[length];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                String strOptString = jSONArray.optString(i11);
                Object jSONObject2 = null;
                if (w.b.f53669e.equals(strOptString)) {
                    string = string + "_S";
                    if (!jSONArray2.isNull(i11)) {
                        jSONObject2 = jSONArray2.getString(i11);
                    }
                    objArr[i11] = jSONObject2;
                } else if ("number".equals(strOptString)) {
                    string = string + "_N";
                    i10 = (i10 * 10) + i11 + 1;
                } else if (w.b.f53670f.equals(strOptString)) {
                    string = string + "_B";
                    objArr[i11] = Boolean.valueOf(jSONArray2.getBoolean(i11));
                } else if ("object".equals(strOptString)) {
                    string = string + "_O";
                    if (!jSONArray2.isNull(i11)) {
                        jSONObject2 = jSONArray2.getJSONObject(i11);
                    }
                    objArr[i11] = jSONObject2;
                } else if ("function".equals(strOptString)) {
                    string = string + "_F";
                    objArr[i11] = new JsCallback(webView, this.f55312c, jSONArray2.getInt(i11));
                } else {
                    string = string + "_P";
                }
            }
            Method method = this.f55310a.get(string);
            if (method == null) {
                return f(jSONObject, 500, "not found method(" + string + ") with valid parameters", jUptimeMillis);
            }
            if (i10 > 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                while (i10 > 0) {
                    int i12 = (i10 - ((i10 / 10) * 10)) - 1;
                    Class<?> cls = parameterTypes[i12];
                    if (cls == Integer.TYPE) {
                        objArr[i12] = Integer.valueOf(jSONArray2.getInt(i12));
                    } else if (cls == Long.TYPE) {
                        objArr[i12] = Long.valueOf(Long.parseLong(jSONArray2.getString(i12)));
                    } else {
                        objArr[i12] = Double.valueOf(jSONArray2.getDouble(i12));
                    }
                    i10 /= 10;
                }
            }
            return f(jSONObject, 200, method.invoke(this.f55311b, objArr), jUptimeMillis);
        } catch (Exception e10) {
            c0.e(f55302e, f0.v.E0, e10);
            if (e10.getCause() != null) {
                return f(jSONObject, 500, "method execute result:" + e10.getCause().getMessage(), jUptimeMillis);
            }
            return f(jSONObject, 500, "method execute result:" + e10.getMessage(), jUptimeMillis);
        }
    }

    public final String b(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (String str : f55309l) {
            if (str.equals(name)) {
                if (!c0.d()) {
                    return null;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("method(");
                sb2.append(name);
                sb2.append(") is unsafe, will be pass");
                return null;
            }
        }
        for (Class<?> cls : parameterTypes) {
            if (cls == String.class) {
                name = name + "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                name = name + "_N";
            } else if (cls == Boolean.TYPE) {
                name = name + "_B";
            } else if (cls == JSONObject.class) {
                name = name + "_O";
            } else if (cls == JsCallback.class) {
                name = name + "_F";
            } else {
                name = name + "_P";
            }
        }
        return name;
    }

    public String e() {
        return this.f55313d;
    }

    public final String f(JSONObject jSONObject, int i10, Object obj, long j10) {
        String str = String.format(f55303f, Integer.valueOf(i10), obj == null ? com.blankj.utilcode.util.i0.f11859x : obj instanceof String ? "\"".concat(String.valueOf(((String) obj).replace("\"", "\\\""))).concat("\"") : String.valueOf(obj));
        if (c0.d()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("call time: ");
            sb2.append(SystemClock.uptimeMillis() - j10);
            sb2.append(", request: ");
            sb2.append(jSONObject);
            sb2.append(", result:");
            sb2.append(str);
        }
        return str;
    }
}
