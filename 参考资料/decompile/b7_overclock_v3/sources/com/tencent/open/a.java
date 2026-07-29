package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, b> f22642a = new HashMap<>();

    public static class b {
        public void call(String str, List<String> list, C0247a c0247a) {
            Method method;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i10];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                } else {
                    i10++;
                }
            }
            if (method == null) {
                if (c0247a != null) {
                    c0247a.a();
                    return;
                }
                return;
            }
            try {
                int size = list.size();
                Object objInvoke = size != 0 ? size != 1 ? size != 2 ? size != 3 ? size != 4 ? size != 5 ? method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3)) : method.invoke(this, list.get(0), list.get(1), list.get(2)) : method.invoke(this, list.get(0), list.get(1)) : method.invoke(this, list.get(0)) : method.invoke(this, new Object[0]);
                Class<?> returnType = method.getReturnType();
                SLog.d("openSDK_LOG.JsBridge", "-->call, result: " + objInvoke + " | ReturnType: " + returnType.getName());
                if (!"void".equals(returnType.getName()) && returnType != Void.class) {
                    if (c0247a == null || !customCallback()) {
                        return;
                    }
                    c0247a.a(objInvoke != null ? objInvoke.toString() : null);
                    return;
                }
                if (c0247a != null) {
                    c0247a.a((Object) null);
                }
            } catch (Exception e10) {
                SLog.e("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e10);
                if (c0247a != null) {
                    c0247a.a();
                }
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.f22642a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0247a c0247a) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                list.set(i10, URLDecoder.decode(list.get(i10), "UTF-8"));
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
        }
        b bVar = this.f22642a.get(str);
        if (bVar != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0247a);
        } else {
            SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (c0247a != null) {
                c0247a.a();
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.open.a$a, reason: collision with other inner class name */
    public static class C0247a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<WebView> f22643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f22644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22645c;

        public C0247a(WebView webView, long j10, String str) {
            this.f22643a = new WeakReference<>(webView);
            this.f22644b = j10;
            this.f22645c = str;
        }

        public void a(Object obj) {
            String string;
            WebView webView = this.f22643a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                string = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else {
                string = ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Boolean)) ? obj.toString() : "'undefined'";
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f22644b + ",{'r':0,'result':" + string + "});");
        }

        public void a() {
            WebView webView = this.f22643a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f22644b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.f22643a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split(fh.a.f28350w)));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List<String> listSubList = arrayList.subList(4, arrayList.size() - 1);
        C0247a c0247a = new C0247a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, listSubList, c0247a);
        return true;
    }
}
