package com.blankj.utilcode.util;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.blankj.utilcode.util.l1;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {
    public static SimpleDateFormat B = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11836a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11837b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11838c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11839d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11840e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11841f = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f11843h = 16;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f11844i = 32;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f11845j = 48;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f11848m = "┌";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f11849n = "├";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f11850o = "│ ";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f11851p = "└";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f11852q = "────────────────────────────────────────────────────────";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f11853r = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f11854s = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f11855t = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f11856u = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f11857v = 1100;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f11858w = "log nothing";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f11859x = "null";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f11860y = "args";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f11861z = " ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char[] f11842g = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f11846k = System.getProperty("file.separator");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f11847l = System.getProperty("line.separator");
    public static final e A = new e(null);
    public static final ExecutorService C = Executors.newSingleThreadExecutor();
    public static final androidx.collection.l<Class, g> D = new androidx.collection.l<>();

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f11863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f11864c;

        public a(int i10, l lVar, String str) {
            this.f11862a = i10;
            this.f11863b = lVar;
            this.f11864c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.Q(this.f11862a, this.f11863b.f11888a, this.f11863b.f11890c + this.f11864c);
        }
    }

    public static class b implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return i0.I(str);
        }
    }

    public static class c implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return i0.I(str);
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f11865a;

        public d(File file) {
            this.f11865a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11865a.delete()) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delete ");
            sb2.append(this.f11865a);
            sb2.append(" failed!");
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f11870e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f11871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f11872g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f11873h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f11874i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f11875j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f11876k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f11877l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11878m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11879n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11880o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f11881p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f11882q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f11883r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public f f11884s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public i f11885t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public j f11886u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public l1.a f11887v;

        public /* synthetic */ e(a aVar) {
            this();
        }

        public final boolean A() {
            return this.f11874i;
        }

        public final boolean B() {
            return this.f11870e;
        }

        public final boolean C() {
            return this.f11877l;
        }

        public final e D(boolean z10) {
            this.f11876k = z10;
            return this;
        }

        public final e E(int i10) {
            this.f11878m = i10;
            return this;
        }

        public final e F(boolean z10) {
            this.f11871f = z10;
            return this;
        }

        public final e G(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + i0.f11846k;
            }
            this.f11867b = str;
            return this;
        }

        public final e H(String str) {
            if (l1.C0(str)) {
                this.f11867b = null;
            } else {
                if (!str.endsWith(i0.f11846k)) {
                    str = str + i0.f11846k;
                }
                this.f11867b = str;
            }
            return this;
        }

        public final e I(String str) {
            if (l1.C0(str)) {
                this.f11869d = ".txt";
            } else if (str.startsWith(j3.b.f36044h)) {
                this.f11869d = str;
            } else {
                this.f11869d = j3.b.f36044h + str;
            }
            return this;
        }

        public final e J(int i10) {
            this.f11879n = i10;
            return this;
        }

        public final e K(String str) {
            if (l1.C0(str)) {
                this.f11868c = "util";
            } else {
                this.f11868c = str;
            }
            return this;
        }

        public final e L(f fVar) {
            this.f11884s = fVar;
            return this;
        }

        public final e M(String str) {
            if (l1.C0(str)) {
                this.f11872g = "";
                this.f11873h = true;
            } else {
                this.f11872g = str;
                this.f11873h = false;
            }
            return this;
        }

        public final e N(boolean z10) {
            this.f11875j = z10;
            return this;
        }

        public final e O(boolean z10) {
            this.f11874i = z10;
            return this;
        }

        public final e P(boolean z10) {
            this.f11870e = z10;
            return this;
        }

        public final e Q(i iVar) {
            this.f11885t = iVar;
            return this;
        }

        public final e R(j jVar) {
            this.f11886u = jVar;
            return this;
        }

        public final e S(@g.f0(from = 1) int i10) {
            this.f11882q = i10;
            return this;
        }

        public final e T(boolean z10) {
            this.f11877l = z10;
            return this;
        }

        public final e U(@g.f0(from = 1) int i10) {
            this.f11880o = i10;
            return this;
        }

        public final e V(@g.f0(from = 0) int i10) {
            this.f11881p = i10;
            return this;
        }

        public final e h(String str, String str2) {
            this.f11887v.b(str, str2);
            return this;
        }

        public final e i(Map<String, String> map) {
            this.f11887v.c(map);
            return this;
        }

        public final <T> e j(g<T> gVar) {
            if (gVar != null) {
                i0.D.put(i0.E(gVar), gVar);
            }
            return this;
        }

        public final char k() {
            return i0.f11842g[this.f11878m - 2];
        }

        public final String l() {
            return this.f11866a;
        }

        public final String m() {
            String str = this.f11867b;
            return str == null ? this.f11866a : str;
        }

        public final String n() {
            return this.f11869d;
        }

        public final char o() {
            return i0.f11842g[this.f11879n - 2];
        }

        public final String p() {
            return this.f11868c;
        }

        public final String q() {
            return l1.C0(this.f11872g) ? "" : this.f11872g;
        }

        public final String r() {
            String str = this.f11883r;
            return str == null ? "" : str.replace(":", "_");
        }

        public final int s() {
            return this.f11882q;
        }

        public final int t() {
            return this.f11880o;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("process: ");
            sb2.append(r());
            sb2.append(i0.f11847l);
            sb2.append("logSwitch: ");
            sb2.append(B());
            sb2.append(i0.f11847l);
            sb2.append("consoleSwitch: ");
            sb2.append(x());
            sb2.append(i0.f11847l);
            sb2.append("tag: ");
            sb2.append(q().equals("") ? i0.f11859x : q());
            sb2.append(i0.f11847l);
            sb2.append("headSwitch: ");
            sb2.append(A());
            sb2.append(i0.f11847l);
            sb2.append("fileSwitch: ");
            sb2.append(y());
            sb2.append(i0.f11847l);
            sb2.append("dir: ");
            sb2.append(m());
            sb2.append(i0.f11847l);
            sb2.append("filePrefix: ");
            sb2.append(p());
            sb2.append(i0.f11847l);
            sb2.append("borderSwitch: ");
            sb2.append(z());
            sb2.append(i0.f11847l);
            sb2.append("singleTagSwitch: ");
            sb2.append(C());
            sb2.append(i0.f11847l);
            sb2.append("consoleFilter: ");
            sb2.append(k());
            sb2.append(i0.f11847l);
            sb2.append("fileFilter: ");
            sb2.append(o());
            sb2.append(i0.f11847l);
            sb2.append("stackDeep: ");
            sb2.append(t());
            sb2.append(i0.f11847l);
            sb2.append("stackOffset: ");
            sb2.append(u());
            sb2.append(i0.f11847l);
            sb2.append("saveDays: ");
            sb2.append(s());
            sb2.append(i0.f11847l);
            sb2.append("formatter: ");
            sb2.append(i0.D);
            sb2.append(i0.f11847l);
            sb2.append("fileWriter: ");
            sb2.append(this.f11884s);
            sb2.append(i0.f11847l);
            sb2.append("onConsoleOutputListener: ");
            sb2.append(this.f11885t);
            sb2.append(i0.f11847l);
            sb2.append("onFileOutputListener: ");
            sb2.append(this.f11886u);
            sb2.append(i0.f11847l);
            sb2.append("fileExtraHeader: ");
            sb2.append(this.f11887v.f());
            return sb2.toString();
        }

        public final int u() {
            return this.f11881p;
        }

        public final boolean v() {
            return this.f11885t != null;
        }

        public final boolean w() {
            return this.f11886u != null;
        }

        public final boolean x() {
            return this.f11871f;
        }

        public final boolean y() {
            return this.f11875j;
        }

        public final boolean z() {
            return this.f11876k;
        }

        public e() {
            this.f11868c = "util";
            this.f11869d = ".txt";
            this.f11870e = true;
            this.f11871f = true;
            this.f11872g = "";
            this.f11873h = true;
            this.f11874i = true;
            this.f11875j = false;
            this.f11876k = true;
            this.f11877l = true;
            this.f11878m = 2;
            this.f11879n = 2;
            this.f11880o = 1;
            this.f11881p = 0;
            this.f11882q = -1;
            this.f11883r = l1.N();
            this.f11887v = new l1.a("Log");
            if (!l1.z0() || j1.a().getExternalFilesDir(null) == null) {
                this.f11866a = j1.a().getFilesDir() + i0.f11846k + "log" + i0.f11846k;
                return;
            }
            this.f11866a = j1.a().getExternalFilesDir(null) + i0.f11846k + "log" + i0.f11846k;
        }
    }

    public interface f {
        void a(String str, String str2);
    }

    public static abstract class g<T> {
        public abstract String a(T t10);
    }

    public static final class h {
        public static String a(Object obj) {
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
        }

        public static String b(Bundle bundle) {
            Iterator<String> it2 = bundle.keySet().iterator();
            if (!it2.hasNext()) {
                return "Bundle {}";
            }
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Bundle { ");
            while (true) {
                String next = it2.next();
                Object obj = bundle.get(next);
                sb2.append(next);
                sb2.append('=');
                if (obj instanceof Bundle) {
                    sb2.append(obj == bundle ? "(this Bundle)" : b((Bundle) obj));
                } else {
                    sb2.append(i0.w(obj));
                }
                if (!it2.hasNext()) {
                    sb2.append(" }");
                    return sb2.toString();
                }
                sb2.append(',');
                sb2.append(zc.f.f58383m);
            }
        }

        @g.v0(api = 16)
        public static void c(ClipData clipData, StringBuilder sb2) {
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt == null) {
                sb2.append("ClipData.Item {}");
                return;
            }
            sb2.append("ClipData.Item { ");
            String htmlText = itemAt.getHtmlText();
            if (htmlText != null) {
                sb2.append("H:");
                sb2.append(htmlText);
                sb2.append(zc.a.f58317e);
                return;
            }
            CharSequence text = itemAt.getText();
            if (text != null) {
                sb2.append("T:");
                sb2.append(text);
                sb2.append(zc.a.f58317e);
                return;
            }
            Uri uri = itemAt.getUri();
            if (uri != null) {
                sb2.append("U:");
                sb2.append(uri);
                sb2.append(zc.a.f58317e);
                return;
            }
            Intent intent = itemAt.getIntent();
            if (intent == null) {
                sb2.append("NULL");
                sb2.append(zc.a.f58317e);
            } else {
                sb2.append("I:");
                sb2.append(f(intent));
                sb2.append(zc.a.f58317e);
            }
        }

        public static String d(String str) {
            try {
                int length = str.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt == '{') {
                        return new JSONObject(str).toString(2);
                    }
                    if (cCharAt == '[') {
                        return new JSONArray(str).toString(2);
                    }
                    if (!Character.isWhitespace(cCharAt)) {
                        return str;
                    }
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            return str;
        }

        public static String e(String str) {
            try {
                StreamSource streamSource = new StreamSource(new StringReader(str));
                StreamResult streamResult = new StreamResult(new StringWriter());
                Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
                transformerNewTransformer.setOutputProperty("indent", "yes");
                transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformerNewTransformer.transform(streamSource, streamResult);
                return streamResult.getWriter().toString().replaceFirst(">", ">" + i0.f11847l);
            } catch (Exception e10) {
                e10.printStackTrace();
                return str;
            }
        }

        public static String f(Intent intent) {
            boolean z10;
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Intent { ");
            String action = intent.getAction();
            boolean z11 = true;
            boolean z12 = false;
            if (action != null) {
                sb2.append("act=");
                sb2.append(action);
                z10 = false;
            } else {
                z10 = true;
            }
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                if (!z10) {
                    sb2.append(zc.f.f58383m);
                }
                sb2.append("cat=[");
                for (String str : categories) {
                    if (!z11) {
                        sb2.append(',');
                    }
                    sb2.append(str);
                    z11 = false;
                }
                sb2.append("]");
                z10 = false;
            }
            Uri data = intent.getData();
            if (data != null) {
                if (!z10) {
                    sb2.append(zc.f.f58383m);
                }
                sb2.append("dat=");
                sb2.append(data);
                z10 = false;
            }
            String type = intent.getType();
            if (type != null) {
                if (!z10) {
                    sb2.append(zc.f.f58383m);
                }
                sb2.append("typ=");
                sb2.append(type);
                z10 = false;
            }
            int flags = intent.getFlags();
            if (flags != 0) {
                if (!z10) {
                    sb2.append(zc.f.f58383m);
                }
                sb2.append("flg=0x");
                sb2.append(Integer.toHexString(flags));
                z10 = false;
            }
            String str2 = intent.getPackage();
            if (str2 != null) {
                if (!z10) {
                    sb2.append(zc.f.f58383m);
                }
                sb2.append("pkg=");
                sb2.append(str2);
                z10 = false;
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                if (!z10) {
                    sb2.append(zc.f.f58383m);
                }
                sb2.append("cmp=");
                sb2.append(component.flattenToShortString());
                z10 = false;
            }
            Rect sourceBounds = intent.getSourceBounds();
            if (sourceBounds != null) {
                if (!z10) {
                    sb2.append(zc.f.f58383m);
                }
                sb2.append("bnds=");
                sb2.append(sourceBounds.toShortString());
                z10 = false;
            }
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                if (!z10) {
                    sb2.append(zc.f.f58383m);
                }
                c(clipData, sb2);
                z10 = false;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (!z10) {
                    sb2.append(zc.f.f58383m);
                }
                sb2.append("extras={");
                sb2.append(b(extras));
                sb2.append('}');
            } else {
                z12 = z10;
            }
            Intent selector = intent.getSelector();
            if (selector != null) {
                if (!z12) {
                    sb2.append(zc.f.f58383m);
                }
                sb2.append("sel={");
                sb2.append(selector == intent ? "(this Intent)" : f(selector));
                sb2.append(zc.a.f58317e);
            }
            sb2.append(" }");
            return sb2.toString();
        }

        public static String g(Object obj) {
            if (obj instanceof CharSequence) {
                return l1.G(obj.toString());
            }
            try {
                return l1.U().toJson(obj);
            } catch (Throwable unused) {
                return obj.toString();
            }
        }

        public static String h(Object obj) {
            return i(obj, -1);
        }

        public static String i(Object obj, int i10) {
            return obj.getClass().isArray() ? a(obj) : obj instanceof Throwable ? l1.T((Throwable) obj) : obj instanceof Bundle ? b((Bundle) obj) : obj instanceof Intent ? f((Intent) obj) : i10 == 32 ? g(obj) : i10 == 48 ? e(obj.toString()) : obj.toString();
        }
    }

    public interface i {
        void a(int i10, String str, String str2);
    }

    public interface j {
        void a(String str, String str2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f11889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11890c;

        public l(String str, String[] strArr, String str2) {
            this.f11888a = str;
            this.f11889b = strArr;
            this.f11890c = str2;
        }
    }

    public i0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(Date date) {
        String strSubstring = D().format(date).substring(0, 10);
        StringBuilder sb2 = new StringBuilder();
        e eVar = A;
        sb2.append(eVar.m());
        sb2.append(eVar.p());
        sb2.append("_");
        sb2.append(strSubstring);
        sb2.append("_");
        sb2.append(eVar.r());
        sb2.append(eVar.n());
        return sb2.toString();
    }

    public static String B(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        if (fileName != null) {
            return fileName;
        }
        String className = stackTraceElement.getClassName();
        String[] strArrSplit = className.split("\\.");
        if (strArrSplit.length > 0) {
            className = strArrSplit[strArrSplit.length - 1];
        }
        int iIndexOf = className.indexOf(36);
        if (iIndexOf != -1) {
            className = className.substring(0, iIndexOf);
        }
        return className + ".java";
    }

    public static List<File> C() {
        File file = new File(A.m());
        if (!file.exists()) {
            return new ArrayList();
        }
        File[] fileArrListFiles = file.listFiles(new b());
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fileArrListFiles);
        return arrayList;
    }

    public static SimpleDateFormat D() {
        if (B == null) {
            B = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.getDefault());
        }
        return B;
    }

    public static <T> Class E(g<T> gVar) {
        Type[] genericInterfaces = gVar.getClass().getGenericInterfaces();
        Type rawType = ((ParameterizedType) (genericInterfaces.length == 1 ? genericInterfaces[0] : gVar.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        while (rawType instanceof ParameterizedType) {
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        String string = rawType.toString();
        if (string.startsWith("class ")) {
            string = string.substring(6);
        } else if (string.startsWith("interface ")) {
            string = string.substring(10);
        }
        try {
            return Class.forName(string);
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void F(Object... objArr) {
        N(4, A.q(), objArr);
    }

    public static void G(String str, Object... objArr) {
        N(4, str, objArr);
    }

    public static void H(String str, String str2) {
        e eVar = A;
        if (eVar.f11884s == null) {
            l1.i1(str, str2, true);
        } else {
            eVar.f11884s.a(str, str2);
        }
        if (eVar.f11886u != null) {
            eVar.f11886u.a(str, str2);
        }
    }

    public static boolean I(String str) {
        return str.matches("^" + A.p() + "_[0-9]{4}_[0-9]{2}_[0-9]{2}_.*$");
    }

    public static void J(int i10, Object obj) {
        N(i10 | 32, A.q(), obj);
    }

    public static void K(int i10, String str, Object obj) {
        N(i10 | 32, str, obj);
    }

    public static void L(Object obj) {
        N(35, A.q(), obj);
    }

    public static void M(String str, Object obj) {
        N(35, str, obj);
    }

    public static void N(int i10, String str, Object... objArr) {
        e eVar = A;
        if (eVar.B()) {
            int i11 = i10 & 15;
            int i12 = i10 & 240;
            if (eVar.x() || eVar.y() || i12 == 16) {
                if (i11 >= eVar.f11878m || i11 >= eVar.f11879n) {
                    l lVarZ = Z(str);
                    String strX = X(i12, objArr);
                    if (eVar.x() && i12 != 16 && i11 >= eVar.f11878m) {
                        P(i11, lVarZ.f11888a, lVarZ.f11889b, strX);
                    }
                    if ((eVar.y() || i12 == 16) && i11 >= eVar.f11879n) {
                        C.execute(new a(i11, lVarZ, strX));
                    }
                }
            }
        }
    }

    public static void O(int i10, String str, String str2) {
        Log.println(i10, str, str2);
        e eVar = A;
        if (eVar.f11885t != null) {
            eVar.f11885t.a(i10, str, str2);
        }
    }

    public static void P(int i10, String str, String[] strArr, String str2) {
        if (A.C()) {
            V(i10, str, Y(i10, str, strArr, str2));
            return;
        }
        R(i10, str, true);
        T(i10, str, strArr);
        U(i10, str, str2);
        R(i10, str, false);
    }

    public static void Q(int i10, String str, String str2) {
        Date date = new Date();
        String str3 = D().format(date);
        String strSubstring = str3.substring(0, 10);
        String strA = A(date);
        if (!k(strA, strSubstring)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("create ");
            sb2.append(strA);
            sb2.append(" failed!");
            return;
        }
        H(strA, str3.substring(11) + f11842g[i10 - 2] + fh.a.f28350w + str + str2 + f11847l);
    }

    public static void R(int i10, String str, boolean z10) {
        if (A.z()) {
            O(i10, str, z10 ? "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────" : "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }
    }

    public static void S(String str, String str2) {
        e eVar = A;
        eVar.f11887v.a("Date of Log", str2);
        H(str, eVar.f11887v.toString());
    }

    public static void T(int i10, String str, String[] strArr) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (A.z()) {
                    str2 = f11850o + str2;
                }
                O(i10, str, str2);
            }
            if (A.z()) {
                O(i10, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
        }
    }

    public static void U(int i10, String str, String str2) {
        int length = str2.length();
        int i11 = length / f11857v;
        if (i11 <= 0) {
            W(i10, str, str2);
            return;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i13 + f11857v;
            W(i10, str, str2.substring(i13, i14));
            i12++;
            i13 = i14;
        }
        if (i13 != length) {
            W(i10, str, str2.substring(i13, length));
        }
    }

    public static void V(int i10, String str, String str2) {
        int length = str2.length();
        e eVar = A;
        boolean z10 = eVar.z();
        int i11 = f11857v;
        int i12 = z10 ? (length - 113) / f11857v : length / f11857v;
        if (i12 <= 0) {
            O(i10, str, str2);
            return;
        }
        int i13 = 1;
        if (!eVar.z()) {
            O(i10, str, str2.substring(0, f11857v));
            while (i13 < i12) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f11861z);
                sb2.append(f11847l);
                int i14 = i11 + f11857v;
                sb2.append(str2.substring(i11, i14));
                O(i10, str, sb2.toString());
                i13++;
                i11 = i14;
            }
            if (i11 != length) {
                O(i10, str, f11861z + f11847l + str2.substring(i11, length));
                return;
            }
            return;
        }
        O(i10, str, str2.substring(0, f11857v) + f11847l + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        while (i13 < i12) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(f11861z);
            String str3 = f11847l;
            sb3.append(str3);
            sb3.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb3.append(str3);
            sb3.append(f11850o);
            int i15 = i11 + f11857v;
            sb3.append(str2.substring(i11, i15));
            sb3.append(str3);
            sb3.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            O(i10, str, sb3.toString());
            i13++;
            i11 = i15;
        }
        if (i11 != length - 113) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(f11861z);
            String str4 = f11847l;
            sb4.append(str4);
            sb4.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb4.append(str4);
            sb4.append(f11850o);
            sb4.append(str2.substring(i11, length));
            O(i10, str, sb4.toString());
        }
    }

    public static void W(int i10, String str, String str2) {
        if (!A.z()) {
            O(i10, str, str2);
            return;
        }
        for (String str3 : str2.split(f11847l)) {
            O(i10, str, f11850o + str3);
        }
    }

    public static String X(int i10, Object... objArr) {
        String string;
        if (objArr != null) {
            if (objArr.length == 1) {
                string = v(i10, objArr[0]);
            } else {
                StringBuilder sb2 = new StringBuilder();
                int length = objArr.length;
                for (int i11 = 0; i11 < length; i11++) {
                    Object obj = objArr[i11];
                    sb2.append("args");
                    sb2.append("[");
                    sb2.append(i11);
                    sb2.append("]");
                    sb2.append(" = ");
                    sb2.append(w(obj));
                    sb2.append(f11847l);
                }
                string = sb2.toString();
            }
        } else {
            string = f11859x;
        }
        return string.length() == 0 ? f11858w : string;
    }

    public static String Y(int i10, String str, String[] strArr, String str2) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        if (A.z()) {
            sb2.append(f11861z);
            String str3 = f11847l;
            sb2.append(str3);
            sb2.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb2.append(str3);
            if (strArr != null) {
                for (String str4 : strArr) {
                    sb2.append(f11850o);
                    sb2.append(str4);
                    sb2.append(f11847l);
                }
                sb2.append("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                sb2.append(f11847l);
            }
            String[] strArrSplit = str2.split(f11847l);
            int length = strArrSplit.length;
            while (i11 < length) {
                String str5 = strArrSplit[i11];
                sb2.append(f11850o);
                sb2.append(str5);
                sb2.append(f11847l);
                i11++;
            }
            sb2.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        } else {
            if (strArr != null) {
                sb2.append(f11861z);
                sb2.append(f11847l);
                int length2 = strArr.length;
                while (i11 < length2) {
                    sb2.append(strArr[i11]);
                    sb2.append(f11847l);
                    i11++;
                }
            }
            sb2.append(str2);
        }
        return sb2.toString();
    }

    public static l Z(String str) {
        String strSubstring;
        String strQ;
        String strSubstring2;
        e eVar = A;
        if (eVar.f11873h || eVar.A()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int iU = eVar.u() + 3;
            if (iU >= stackTrace.length) {
                String strB = B(stackTrace[3]);
                if (eVar.f11873h && l1.C0(str)) {
                    int iIndexOf = strB.indexOf(46);
                    strSubstring2 = iIndexOf == -1 ? strB : strB.substring(0, iIndexOf);
                } else {
                    strSubstring2 = str;
                }
                return new l(strSubstring2, null, ": ");
            }
            StackTraceElement stackTraceElement = stackTrace[iU];
            String strB2 = B(stackTraceElement);
            if (eVar.f11873h && l1.C0(str)) {
                int iIndexOf2 = strB2.indexOf(46);
                strSubstring = iIndexOf2 == -1 ? strB2 : strB2.substring(0, iIndexOf2);
            } else {
                strSubstring = str;
            }
            if (eVar.A()) {
                String name = Thread.currentThread().getName();
                String string = new Formatter().format("%s, %s.%s(%s:%d)", name, stackTraceElement.getClassName(), stackTraceElement.getMethodName(), strB2, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                String str2 = " [" + string + "]: ";
                if (eVar.t() <= 1) {
                    return new l(strSubstring, new String[]{string}, str2);
                }
                int iMin = Math.min(eVar.t(), stackTrace.length - iU);
                String[] strArr = new String[iMin];
                strArr[0] = string;
                int length = name.length() + 2;
                String string2 = new Formatter().format(i6.a.f31863g + length + an.aB, "").toString();
                for (int i10 = 1; i10 < iMin; i10++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i10 + iU];
                    strArr[i10] = new Formatter().format("%s%s.%s(%s:%d)", string2, stackTraceElement2.getClassName(), stackTraceElement2.getMethodName(), B(stackTraceElement2), Integer.valueOf(stackTraceElement2.getLineNumber())).toString();
                }
                return new l(strSubstring, strArr, str2);
            }
            strQ = strSubstring;
        } else {
            strQ = eVar.q();
        }
        return new l(strQ, null, ": ");
    }

    public static void a(Object... objArr) {
        N(7, A.q(), objArr);
    }

    public static void a0(Object... objArr) {
        N(2, A.q(), objArr);
    }

    public static void b(String str, Object... objArr) {
        N(7, str, objArr);
    }

    public static void b0(String str, Object... objArr) {
        N(2, str, objArr);
    }

    public static void c0(Object... objArr) {
        N(5, A.q(), objArr);
    }

    public static void d0(String str, Object... objArr) {
        N(5, str, objArr);
    }

    public static void e0(int i10, String str) {
        N(i10 | 48, A.q(), str);
    }

    public static void f0(int i10, String str, String str2) {
        N(i10 | 48, str, str2);
    }

    public static void g0(String str) {
        N(51, A.q(), str);
    }

    public static void h0(String str, String str2) {
        N(51, str, str2);
    }

    public static boolean k(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!l1.s(file.getParentFile())) {
            return false;
        }
        try {
            n(str, str2);
            boolean zCreateNewFile = file.createNewFile();
            if (zCreateNewFile) {
                S(str, str2);
            }
            return zCreateNewFile;
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static void l(Object... objArr) {
        N(3, A.q(), objArr);
    }

    public static void m(String str, Object... objArr) {
        N(3, str, objArr);
    }

    public static void n(String str, String str2) {
        File[] fileArrListFiles;
        e eVar = A;
        if (eVar.s() > 0 && (fileArrListFiles = new File(str).getParentFile().listFiles(new c())) != null && fileArrListFiles.length > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault());
            try {
                long time = simpleDateFormat.parse(str2).getTime() - (((long) eVar.s()) * 86400000);
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    name.length();
                    if (simpleDateFormat.parse(u(name)).getTime() <= time) {
                        C.execute(new d(file));
                    }
                }
            } catch (ParseException e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void o(Object... objArr) {
        N(6, A.q(), objArr);
    }

    public static void p(String str, Object... objArr) {
        N(6, str, objArr);
    }

    public static void q(int i10, Object obj) {
        N(i10 | 16, A.q(), obj);
    }

    public static void r(int i10, String str, Object obj) {
        N(i10 | 16, str, obj);
    }

    public static void s(Object obj) {
        N(19, A.q(), obj);
    }

    public static void t(String str, Object obj) {
        N(19, str, obj);
    }

    public static String u(String str) {
        Matcher matcher = Pattern.compile("[0-9]{4}_[0-9]{2}_[0-9]{2}").matcher(str);
        return matcher.find() ? matcher.group() : "";
    }

    public static String v(int i10, Object obj) {
        return obj == null ? f11859x : i10 == 32 ? h.i(obj, 32) : i10 == 48 ? h.i(obj, 48) : w(obj);
    }

    public static String w(Object obj) {
        g gVar;
        if (obj == null) {
            return f11859x;
        }
        androidx.collection.l<Class, g> lVar = D;
        return (lVar.isEmpty() || (gVar = lVar.get(x(obj))) == null) ? h.h(obj) : gVar.a(obj);
    }

    public static Class x(Object obj) {
        String string;
        Class<?> cls = obj.getClass();
        if (cls.isAnonymousClass() || cls.isSynthetic()) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces.length == 1) {
                Type rawType = genericInterfaces[0];
                while (rawType instanceof ParameterizedType) {
                    rawType = ((ParameterizedType) rawType).getRawType();
                }
                string = rawType.toString();
            } else {
                Type genericSuperclass = cls.getGenericSuperclass();
                while (genericSuperclass instanceof ParameterizedType) {
                    genericSuperclass = ((ParameterizedType) genericSuperclass).getRawType();
                }
                string = genericSuperclass.toString();
            }
            if (string.startsWith("class ")) {
                string = string.substring(6);
            } else if (string.startsWith("interface ")) {
                string = string.substring(10);
            }
            try {
                return Class.forName(string);
            } catch (ClassNotFoundException e10) {
                e10.printStackTrace();
            }
        }
        return cls;
    }

    public static e y() {
        return A;
    }

    public static String z() {
        return A(new Date());
    }
}
