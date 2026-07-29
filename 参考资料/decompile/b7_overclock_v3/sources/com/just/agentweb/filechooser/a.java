package com.just.agentweb.filechooser;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.just.agentweb.Action;
import com.just.agentweb.ActionActivity;
import g.n0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONObject;
import xf.c0;
import xf.g0;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f22020p = 596;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f22021q = "a";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f22022r = 8000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueCallback<Uri> f22024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueCallback<Uri[]> f22025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WebChromeClient.FileChooserParams f22027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f22028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WebView f22030h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g0 f22032j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WeakReference<xf.b> f22034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f22035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Handler.Callback f22036n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22031i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22033k = 21;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ActionActivity.b f22037o = new d();

    /* JADX INFO: renamed from: com.just.agentweb.filechooser.a$a, reason: collision with other inner class name */
    public class RunnableC0238a implements Runnable {
        public RunnableC0238a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.w();
        }
    }

    public class b implements ActionActivity.a {
        public b() {
        }

        @Override // com.just.agentweb.ActionActivity.a
        public void a(int i10, int i11, Intent intent) {
            c0.c(a.f22021q, "request:" + i10 + "  resultCode:" + i11);
            a.this.u(i10, i11, intent);
        }
    }

    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                a.this.f22031i = true;
                a.this.t();
            } else if (i10 != 1) {
                a.this.h();
            } else {
                a.this.f22031i = false;
                a.this.m();
            }
            return true;
        }
    }

    public class d implements ActionActivity.b {
        public d() {
        }

        @Override // com.just.agentweb.ActionActivity.b
        public void a(@n0 String[] strArr, @n0 int[] iArr, Bundle bundle) {
            a.this.y(com.just.agentweb.a.G(a.this.f22023a, Arrays.asList(strArr)), bundle.getInt(ActionActivity.f21733e));
        }
    }

    public static final class e implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ValueCallback<Uri[]> f22042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Uri[] f22043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<xf.b> f22044c;

        /* JADX INFO: renamed from: com.just.agentweb.filechooser.a$e$a, reason: collision with other inner class name */
        public class RunnableC0239a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Message f22045a;

            public RunnableC0239a(Message message) {
                this.f22045a = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.b(this.f22045a);
            }
        }

        public /* synthetic */ e(ValueCallback valueCallback, Uri[] uriArr, WeakReference weakReference, RunnableC0238a runnableC0238a) {
            this(valueCallback, uriArr, weakReference);
        }

        public final void b(Message message) {
            ValueCallback<Uri[]> valueCallback = this.f22042a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(this.f22043b);
            }
            WeakReference<xf.b> weakReference = this.f22044c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f22044c.get().e();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            com.just.agentweb.a.T(new RunnableC0239a(message));
            return false;
        }

        public e(ValueCallback<Uri[]> valueCallback, Uri[] uriArr, WeakReference<xf.b> weakReference) {
            this.f22042a = valueCallback;
            this.f22043b = uriArr;
            this.f22044c = weakReference;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f22047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ValueCallback<Uri> f22048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ValueCallback<Uri[]> f22049c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public WebChromeClient.FileChooserParams f22051e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public WebView f22053g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public g0 f22054h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Handler.Callback f22056j;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f22050d = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f22052f = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f22055i = "*/*";

        public a k() {
            return new a(this);
        }

        public f l(String str) {
            this.f22055i = str;
            return this;
        }

        public f m(Activity activity) {
            this.f22047a = activity;
            return this;
        }

        public f n(WebChromeClient.FileChooserParams fileChooserParams) {
            this.f22051e = fileChooserParams;
            return this;
        }

        public f o(Handler.Callback callback) {
            this.f22056j = callback;
            this.f22052f = true;
            this.f22048b = null;
            this.f22049c = null;
            return this;
        }

        public f p(g0 g0Var) {
            this.f22054h = g0Var;
            return this;
        }

        public f q(ValueCallback<Uri> valueCallback) {
            this.f22048b = valueCallback;
            this.f22050d = false;
            this.f22052f = false;
            this.f22049c = null;
            return this;
        }

        public f r(ValueCallback<Uri[]> valueCallback) {
            this.f22049c = valueCallback;
            this.f22050d = true;
            this.f22048b = null;
            this.f22052f = false;
            return this;
        }

        public f s(WebView webView) {
            this.f22053g = webView;
            return this;
        }
    }

    public static class g extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<i> f22057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f22058b;

        public /* synthetic */ g(i iVar, String[] strArr, RunnableC0238a runnableC0238a) {
            this(iVar, strArr);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                String strL = a.l(a.j(this.f22058b));
                WeakReference<i> weakReference = this.f22057a;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                this.f22057a.get().a(strL);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public g(i iVar, String[] strArr) {
            this.f22057a = new WeakReference<>(iVar);
            this.f22058b = strArr;
        }
    }

    public static class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Queue<FileParcel> f22060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CountDownLatch f22061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22062d;

        public h(String str, Queue<FileParcel> queue, CountDownLatch countDownLatch, int i10) {
            this.f22059a = str;
            this.f22060b = queue;
            this.f22061c = countDownLatch;
            this.f22062d = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileInputStream fileInputStream;
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th2;
            File file;
            byte[] bArr;
            FileInputStream fileInputStream2 = null;
            try {
                file = new File(this.f22059a);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                byteArrayOutputStream = null;
            }
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bArr = new byte[1024];
                    } catch (Throwable th4) {
                        th2 = th4;
                        try {
                            c0.c(a.f22021q, "throwwable");
                            th2.printStackTrace();
                            com.just.agentweb.a.j(fileInputStream);
                        } catch (Throwable th5) {
                            com.just.agentweb.a.j(fileInputStream);
                            com.just.agentweb.a.j(byteArrayOutputStream);
                            this.f22061c.countDown();
                            throw th5;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                    th2 = th;
                    c0.c(a.f22021q, "throwwable");
                    th2.printStackTrace();
                    com.just.agentweb.a.j(fileInputStream);
                    com.just.agentweb.a.j(byteArrayOutputStream);
                    this.f22061c.countDown();
                }
                while (true) {
                    int i10 = fileInputStream.read(bArr, 0, 1024);
                    if (i10 == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, i10);
                    }
                    com.just.agentweb.a.j(byteArrayOutputStream);
                    this.f22061c.countDown();
                }
                this.f22060b.offer(new FileParcel(this.f22062d, file.getAbsolutePath(), Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0)));
                c0.c(a.f22021q, "enqueue");
                fileInputStream2 = fileInputStream;
            } else {
                c0.c(a.f22021q, "File no exists");
                byteArrayOutputStream = null;
            }
            com.just.agentweb.a.j(fileInputStream2);
            com.just.agentweb.a.j(byteArrayOutputStream);
            this.f22061c.countDown();
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Handler.Callback> f22063a;

        public i(Handler.Callback callback) {
            this.f22063a = null;
            this.f22063a = new WeakReference<>(callback);
        }

        public static i b(Handler.Callback callback) {
            return new i(callback);
        }

        public void a(String str) {
            WeakReference<Handler.Callback> weakReference = this.f22063a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f22063a.get().handleMessage(Message.obtain(null, 2077613503, str));
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Handler.Callback f22065b;

        public /* synthetic */ j(String str, Handler.Callback callback, RunnableC0238a runnableC0238a) {
            this(str, callback);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f22064a) || !new File(this.f22064a).exists()) {
                Handler.Callback callback = this.f22065b;
                if (callback != null) {
                    callback.handleMessage(Message.obtain((Handler) null, -1));
                    return;
                }
                return;
            }
            int i10 = 0;
            while (true) {
                if (i10 > a.f22022r) {
                    break;
                }
                i10 += 300;
                SystemClock.sleep(300L);
                if (new File(this.f22064a).length() > 0) {
                    Handler.Callback callback2 = this.f22065b;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain((Handler) null, 1));
                        this.f22065b = null;
                    }
                }
            }
            if (i10 > a.f22022r) {
                c0.c(a.f22021q, "WaitPhotoRunnable finish!");
                Handler.Callback callback3 = this.f22065b;
                if (callback3 != null) {
                    callback3.handleMessage(Message.obtain((Handler) null, -1));
                }
            }
            this.f22065b = null;
            this.f22064a = null;
        }

        public j(String str, Handler.Callback callback) {
            this.f22064a = str;
            this.f22065b = callback;
        }
    }

    public a(f fVar) {
        this.f22026d = false;
        this.f22029g = false;
        this.f22034l = null;
        this.f22035m = "*/*";
        this.f22023a = fVar.f22047a;
        this.f22024b = fVar.f22048b;
        this.f22025c = fVar.f22049c;
        this.f22026d = fVar.f22050d;
        this.f22029g = fVar.f22052f;
        this.f22027e = fVar.f22051e;
        if (this.f22029g) {
            this.f22028f = i.b(fVar.f22056j);
        }
        this.f22030h = fVar.f22053g;
        this.f22032j = fVar.f22054h;
        this.f22035m = fVar.f22055i;
        this.f22034l = new WeakReference<>(com.just.agentweb.a.p(this.f22030h));
        this.f22036n = fVar.f22056j;
    }

    public static Queue<FileParcel> j(String[] strArr) throws Exception {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int i10 = 1;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        if (strArr.length <= iAvailableProcessors) {
            iAvailableProcessors = strArr.length;
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iAvailableProcessors);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        CountDownLatch countDownLatch = new CountDownLatch(strArr.length);
        for (String str : strArr) {
            c0.c(f22021q, "path:" + str);
            if (TextUtils.isEmpty(str)) {
                countDownLatch.countDown();
            } else {
                executorServiceNewFixedThreadPool.execute(new h(str, linkedBlockingQueue, countDownLatch, i10));
                i10++;
            }
        }
        countDownLatch.await();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorServiceNewFixedThreadPool;
        if (!threadPoolExecutor.isShutdown()) {
            threadPoolExecutor.shutdownNow();
        }
        c0.c(f22021q, "convertFile isShutDown:" + threadPoolExecutor.isShutdown());
        return linkedBlockingQueue;
    }

    public static String l(Collection<FileParcel> collection) {
        if (collection == null || collection.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (FileParcel fileParcel : collection) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("contentPath", fileParcel.a());
                jSONObject.put("fileBase64", fileParcel.b());
                jSONObject.put("mId", fileParcel.e());
                jSONArray.put(jSONObject);
            } catch (Throwable th2) {
                if (c0.d()) {
                    th2.printStackTrace();
                }
            }
        }
        return jSONArray + "";
    }

    public static f s(Activity activity, WebView webView) {
        return new f().m(activity).s(webView);
    }

    public final void A() {
        Action action = new Action();
        action.j(2);
        ActionActivity.g(o());
        this.f22023a.startActivity(new Intent(this.f22023a, (Class<?>) ActionActivity.class).putExtra(ActionActivity.f21731c, action).putExtra(ActionActivity.f21734f, p()));
    }

    public final void h() {
        if (this.f22029g) {
            this.f22028f.a(null);
            return;
        }
        ValueCallback<Uri> valueCallback = this.f22024b;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
        ValueCallback<Uri[]> valueCallback2 = this.f22025c;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
        }
    }

    public final List<String> i() {
        ArrayList arrayList = new ArrayList();
        Activity activity = this.f22023a;
        String[] strArr = xf.e.f55216a;
        if (!com.just.agentweb.a.H(activity, strArr)) {
            arrayList.add(strArr[0]);
        }
        Activity activity2 = this.f22023a;
        String[] strArr2 = xf.e.f55218c;
        if (!com.just.agentweb.a.H(activity2, strArr2)) {
            arrayList.addAll(Arrays.asList(strArr2));
        }
        return arrayList;
    }

    public final void k(Uri[] uriArr) {
        String[] strArrZ;
        RunnableC0238a runnableC0238a = null;
        if (uriArr == null || uriArr.length == 0 || (strArrZ = com.just.agentweb.a.Z(this.f22023a, uriArr)) == null || strArrZ.length == 0) {
            this.f22028f.a(null);
            return;
        }
        int length = 0;
        for (String str : strArrZ) {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists()) {
                    length = (int) (((long) length) + file.length());
                }
            }
        }
        if (length <= xf.c.f55209n) {
            new g(this.f22028f, strArrZ, runnableC0238a).start();
            return;
        }
        if (this.f22034l.get() != null) {
            this.f22034l.get().p(this.f22023a.getString(R.string.agentweb_max_file_length_limit, new Object[]{((xf.c.f55209n / 1024) / 1024) + ""}), f22021q.concat("|convertFileAndCallBack"));
        }
        this.f22028f.a(null);
    }

    public final void m() {
        Activity activity = this.f22023a;
        String[] strArr = xf.e.f55218c;
        if (com.just.agentweb.a.u(activity, strArr).isEmpty()) {
            A();
            return;
        }
        Action actionA = Action.a(strArr);
        actionA.s(this.f22033k >> 2);
        ActionActivity.h(this.f22037o);
        ActionActivity.i(this.f22023a, actionA);
    }

    public final Handler.Callback n() {
        return new c();
    }

    public final ActionActivity.a o() {
        return new b();
    }

    public final Intent p() {
        WebChromeClient.FileChooserParams fileChooserParams;
        Intent intentCreateIntent;
        if (this.f22026d && (fileChooserParams = this.f22027e) != null && (intentCreateIntent = fileChooserParams.createIntent()) != null) {
            return intentCreateIntent;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (TextUtils.isEmpty(this.f22035m)) {
            intent.setType("*/*");
        } else {
            intent.setType(this.f22035m);
        }
        intent.addFlags(1);
        return Intent.createChooser(intent, "");
    }

    public final void q(Uri[] uriArr, boolean z10) {
        ValueCallback<Uri[]> valueCallback = this.f22025c;
        if (valueCallback == null) {
            return;
        }
        if (!z10) {
            if (uriArr == null) {
                uriArr = new Uri[0];
            }
            valueCallback.onReceiveValue(uriArr);
            return;
        }
        RunnableC0238a runnableC0238a = null;
        if (this.f22034l.get() == null) {
            this.f22025c.onReceiveValue(null);
            return;
        }
        String[] strArrZ = com.just.agentweb.a.Z(this.f22023a, uriArr);
        if (strArrZ == null || strArrZ.length == 0) {
            this.f22025c.onReceiveValue(null);
            return;
        }
        String str = strArrZ[0];
        this.f22034l.get().j(this.f22023a.getString(R.string.agentweb_loading));
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new j(str, new e(this.f22025c, uriArr, this.f22034l, runnableC0238a), runnableC0238a));
    }

    public final void r(Intent intent) {
        if (intent == null) {
            ValueCallback<Uri> valueCallback = this.f22024b;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(Uri.EMPTY);
                return;
            }
            return;
        }
        Uri data = intent.getData();
        c0.c(f22021q, "handleBelowLollipop  -- >uri:" + data + "  mUriValueCallback:" + this.f22024b);
        ValueCallback<Uri> valueCallback2 = this.f22024b;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(data);
        }
    }

    public final void t() {
        if (this.f22023a == null) {
            return;
        }
        g0 g0Var = this.f22032j;
        if (g0Var != null && g0Var.a(this.f22030h.getUrl(), xf.e.f55216a, "camera")) {
            h();
            return;
        }
        Action action = new Action();
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> listI = i();
            if (!listI.isEmpty()) {
                action.j(1);
                action.C((String[]) listI.toArray(new String[0]));
                action.s(this.f22033k >> 3);
                ActionActivity.h(this.f22037o);
                ActionActivity.i(this.f22023a, action);
                return;
            }
        }
        v();
    }

    public void u(int i10, int i11, Intent intent) {
        c0.c(f22021q, "request:" + i10 + "  result:" + i11 + "  data:" + intent);
        if (596 != i10) {
            return;
        }
        if (i11 == 0 || intent == null) {
            h();
            return;
        }
        if (i11 != -1) {
            h();
            return;
        }
        if (this.f22029g) {
            k(this.f22031i ? new Uri[]{(Uri) intent.getParcelableExtra(ActionActivity.f21732d)} : z(intent));
            return;
        }
        if (this.f22026d) {
            q(this.f22031i ? new Uri[]{(Uri) intent.getParcelableExtra(ActionActivity.f21732d)} : z(intent), this.f22031i);
            return;
        }
        ValueCallback<Uri> valueCallback = this.f22024b;
        if (valueCallback == null) {
            h();
        } else if (this.f22031i) {
            valueCallback.onReceiveValue((Uri) intent.getParcelableExtra(ActionActivity.f21732d));
        } else {
            r(intent);
        }
    }

    public final void v() {
        Action action = new Action();
        action.j(3);
        ActionActivity.g(o());
        ActionActivity.i(this.f22023a, action);
    }

    public void w() {
        if (com.just.agentweb.a.R()) {
            x();
        } else {
            com.just.agentweb.a.T(new RunnableC0238a());
        }
    }

    public final void x() {
        WebChromeClient.FileChooserParams fileChooserParams;
        boolean z10;
        if (this.f22026d && (fileChooserParams = this.f22027e) != null && fileChooserParams.getAcceptTypes() != null) {
            for (String str : this.f22027e.getAcceptTypes()) {
                c0.c(f22021q, "typeTmp:" + str);
                if (!TextUtils.isEmpty(str) && (str.contains("*/") || str.contains("image/"))) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
            if (!z10) {
                A();
                return;
            }
        }
        if (!TextUtils.isEmpty(this.f22035m) && !this.f22035m.contains("*/") && !this.f22035m.contains("image/")) {
            A();
            return;
        }
        String str2 = f22021q;
        c0.c(str2, "controller:" + this.f22034l.get() + "   mAcceptType:" + this.f22035m);
        if (this.f22034l.get() != null) {
            xf.b bVar = this.f22034l.get();
            WebView webView = this.f22030h;
            bVar.n(webView, webView.getUrl(), new String[]{this.f22023a.getString(R.string.agentweb_camera), this.f22023a.getString(R.string.agentweb_file_chooser)}, n());
            c0.c(str2, xc.d.A0);
        }
    }

    public final void y(boolean z10, int i10) {
        int i11 = this.f22033k;
        if (i10 == (i11 >> 2)) {
            if (z10) {
                A();
                return;
            }
            h();
            if (this.f22034l.get() != null) {
                this.f22034l.get().m(xf.e.f55218c, xf.e.f55221f, "Open file chooser");
            }
            c0.c(f22021q, "permission denied");
            return;
        }
        if (i10 == (i11 >> 3)) {
            if (z10) {
                v();
                return;
            }
            h();
            if (this.f22034l.get() != null) {
                this.f22034l.get().m(xf.e.f55216a, xf.e.f55219d, "Take photo");
            }
            c0.c(f22021q, "permission denied");
        }
    }

    public final Uri[] z(Intent intent) {
        Uri[] uriArr = null;
        if (intent == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!TextUtils.isEmpty(dataString)) {
            return new Uri[]{Uri.parse(dataString)};
        }
        ClipData clipData = intent.getClipData();
        if (clipData != null && clipData.getItemCount() > 0) {
            uriArr = new Uri[clipData.getItemCount()];
            for (int i10 = 0; i10 < clipData.getItemCount(); i10++) {
                uriArr[i10] = clipData.getItemAt(i10).getUri();
            }
        }
        return uriArr;
    }
}
