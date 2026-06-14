package a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.lang.Thread;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e50 extends r50 implements i50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f5967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final f50 f678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static l50 f679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final v50 f681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Looper f682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ArrayList<SocketChannel> f685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ConcurrentHashMap<String, g82<String, m42>> f686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f687a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f688b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static boolean f690c;
    public static final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static boolean f692d;
    public static final int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static String f693e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static boolean f694e;
    public static int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static String f695f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final e50 f677a = new e50();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static o30 f680a = o30.STATUS_STOP;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f684a = "";
    public static int c = 8788;
    public static String b = "0.0.0";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static String f689c = "";

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static String f691d = "omarea.com";

    static {
        Charset charset = bb2.f5692a;
        if ("omarea.com" == 0) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        f92.c("omarea.com".getBytes(charset), "(this as java.lang.String).getBytes(charset)");
        f683a = new Object();
        a42.a(h40.f6273a);
        f681a = new v50();
        f688b = true;
        f693e = "basic";
        d = 2000;
        e = 3600000;
        f678a = new f50();
        f686a = new ConcurrentHashMap<>();
        f682a = Looper.getMainLooper();
        f685a = new ArrayList<>();
        f695f = "";
    }

    public e50() {
        super(Proxy.NO_PROXY);
    }

    public static /* synthetic */ boolean B1(e50 e50Var, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return e50Var.A1(j);
    }

    public static /* synthetic */ o50 J0(e50 e50Var, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return e50Var.I0(str, str2);
    }

    public static /* synthetic */ String Q0(e50 e50Var, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "custom-cache";
        }
        return e50Var.P0(str);
    }

    public static /* synthetic */ Object T(e50 e50Var, String str, b62 b62Var, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "all";
        }
        return e50Var.S(str, b62Var);
    }

    public static /* synthetic */ boolean f0(e50 e50Var, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return e50Var.e0(str, z);
    }

    public static /* synthetic */ Object h1(e50 e50Var, String str, String str2, Long l, b62 b62Var, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        return e50Var.g1(str, str2, l, b62Var);
    }

    public static /* synthetic */ String j1(e50 e50Var, String str, String str2, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        return e50Var.i1(str, str2, l);
    }

    public static /* synthetic */ boolean s1(e50 e50Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return e50Var.r1(z);
    }

    public static /* synthetic */ Object v0(e50 e50Var, String str, Double d2, b62 b62Var, int i, Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if ((i & 2) != 0) {
            d2 = null;
        }
        return e50Var.u0(str, d2, b62Var);
    }

    public static final /* synthetic */ ConcurrentHashMap z(e50 e50Var) {
        return f686a;
    }

    public final boolean A0() throws IOException {
        String str = "@version:" + b;
        if (!f688b || !f681a.b()) {
            return i0(str, this);
        }
        q1(f681a, this);
        n1(f681a, W("@version:" + b));
        i0(str, this);
        return true;
    }

    public final boolean A1(long j) {
        FutureTask futureTask = new FutureTask(d50.f5862a);
        qc2.d(hf2.f6309a, qe2.b(), null, new c50(j, futureTask, null), 2, null);
        try {
            Boolean bool = (Boolean) futureTask.get();
            f92.c(bool, "r");
            if (bool.booleanValue()) {
                f680a = o30.STATUS_RUNNING;
            }
            return bool.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public final void B0() {
        Z("killall scene-daemon");
    }

    public final SocketChannel C0() throws IOException {
        SocketChannel socketChannelOpen = SocketChannel.open();
        socketChannelOpen.configureBlocking(true);
        Socket socket = socketChannelOpen.socket();
        socket.setTrafficClass(20);
        socket.setSendBufferSize(4096);
        socket.setReceiveBufferSize(40960);
        socket.setTcpNoDelay(true);
        socket.setKeepAlive(true);
        f92.c(socketChannelOpen, "SocketChannel.open().app…e\n            }\n        }");
        return socketChannelOpen;
    }

    public final void D0(String str) {
        Object next;
        int iN = ec2.N(str, ":", 0, false, 6, null);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(0, iN);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int i = iN + 1;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = str.substring(i);
        f92.c(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        byte[] bArrDecode = Base64.decode(strSubstring2, 11);
        f92.c(bArrDecode, "Base64.decode(content, B…DDING or Base64.URL_SAFE)");
        String str2 = new String(bArrDecode, bb2.f5692a);
        Set<Map.Entry<String, g82<String, m42>>> setEntrySet = f686a.entrySet();
        f92.c(setEntrySet, "asyncTaskList.entries");
        Iterator<T> it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (f92.a((String) ((Map.Entry) next).getKey(), strSubstring)) {
                    break;
                }
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if ((entry != null ? (g82) entry.getValue() : null) != null) {
            f686a.remove(strSubstring);
            ((g82) entry.getValue()).f(str2);
            return;
        }
        Log.e("@Scene", "ApiRequest " + strSubstring + " Callback Removed!");
    }

    public final String E0(String str) {
        return i1("path-basic-info", str, 1000L);
    }

    public final int F0(String str) {
        f92.d(str, "path");
        Integer numJ = ac2.j(i1("dir-child-count", str, 1000L));
        if (numJ != null) {
            return numJ.intValue();
        }
        return 0;
    }

    public final n50 G0(String str) {
        f92.d(str, "path");
        String strI1 = i1("path-detail-info", str, 10000L);
        if (!(strI1.length() > 0) || !(!f92.a(strI1, "error"))) {
            return null;
        }
        try {
            return new n50(new g30(strI1));
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean H0(String str) {
        f92.d(str, "path");
        String strE0 = E0(str);
        return bc2.x(strE0, "dir", false, 2, null) || bc2.x(strE0, "file", false, 2, null);
    }

    public final o50 I0(String str, String str2) {
        f92.d(str, "path");
        f92.d(str2, "suffix");
        g30 g30Var = new g30();
        g30Var.x("dir", str);
        g30Var.x("suffix", str2);
        m42 m42Var = m42.f6769a;
        String string = g30Var.toString();
        f92.c(string, "JSONObject().apply {\n   …fix)\n        }.toString()");
        String strI1 = i1("path-list", string, 30000L);
        if (!(strI1.length() > 0) || !(!f92.a(strI1, "error"))) {
            return null;
        }
        try {
            return new o50(new g30(strI1));
        } catch (Exception unused) {
            return null;
        }
    }

    public final g30 K0(String str) {
        f92.d(str, "path");
        try {
            return new g30(i1("path-tree", str, 2000L));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L0(a.b62<? super java.lang.Boolean> r7) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            boolean r0 = r7 instanceof a.f40
            if (r0 == 0) goto L13
            r0 = r7
            a.f40 r0 = (a.f40) r0
            int r1 = r0.f6071a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6071a = r1
            goto L18
        L13:
            a.f40 r0 = new a.f40
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f852a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6071a
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.b
            a.e50 r0 = (a.e50) r0
            a.h42.b(r7)
            goto L4d
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            a.h42.b(r7)
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Long r7 = a.t62.f(r4)
            r0.b = r6
            r0.f6071a = r3
            java.lang.String r2 = "ping"
            java.lang.String r4 = ""
            java.lang.Object r7 = r6.g1(r2, r4, r7, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r0 = "error"
            boolean r7 = a.f92.a(r7, r0)
            r7 = r7 ^ r3
            java.lang.Boolean r7 = a.t62.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.L0(a.b62):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M0(a.j50 r7, java.lang.String r8, a.b62<? super java.lang.Boolean> r9) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            boolean r0 = r9 instanceof a.i40
            if (r0 == 0) goto L13
            r0 = r9
            a.i40 r0 = (a.i40) r0
            int r1 = r0.f6374a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6374a = r1
            goto L18
        L13:
            a.i40 r0 = new a.i40
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f1326a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6374a
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.d
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.c
            a.j50 r7 = (a.j50) r7
            java.lang.Object r7 = r0.b
            a.e50 r7 = (a.e50) r7
            a.h42.b(r9)
            goto L6f
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            a.h42.b(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = r7.name()
            r9.append(r2)
            r2 = 124(0x7c, float:1.74E-43)
            r9.append(r2)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.Long r2 = a.t62.f(r4)
            r0.b = r6
            r0.c = r7
            r0.d = r8
            r0.f6374a = r3
            java.lang.String r7 = "event"
            java.lang.Object r9 = r6.g1(r7, r9, r2, r0)
            if (r9 != r1) goto L6f
            return r1
        L6f:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r7 = "success"
            boolean r7 = a.f92.a(r9, r7)
            java.lang.Boolean r7 = a.t62.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.M0(a.j50, java.lang.String, a.b62):java.lang.Object");
    }

    public final String N0(d30 d30Var) {
        f92.d(d30Var, "calls");
        String string = d30Var.toString();
        f92.c(string, "calls.toString()");
        return i1("scheduler-func", string, 2000L);
    }

    public final String O0(String[]... strArr) {
        f92.d(strArr, "args");
        d30 d30Var = new d30();
        for (String[] strArr2 : strArr) {
            d30 d30Var2 = new d30();
            for (String str : strArr2) {
                d30Var2.k(str);
            }
            d30Var.k(d30Var2);
        }
        return N0(d30Var);
    }

    public final String P0(String str) {
        f92.d(str, "action");
        return i1("scheduler-refresh", str, 2000L);
    }

    public final String Q(String str) throws InterruptedException {
        f92.d(str, "code");
        Charset charsetDefaultCharset = Charset.defaultCharset();
        f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
        byte[] bytes = str.getBytes(charsetDefaultCharset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        long jCurrentTimeMillis = System.currentTimeMillis();
        do {
            String strI1 = i1("activate", new String(bytes, bb2.f5692a), 2500L);
            if (!f92.a(strI1, "error")) {
                return strI1;
            }
            Thread.sleep(300L);
        } while (System.currentTimeMillis() - jCurrentTimeMillis < 6000);
        return "error";
    }

    public final void R() {
        ArrayList<SocketChannel> arrayList = f685a;
        List<SocketChannel> listSubList = arrayList.subList(0, arrayList.size());
        f92.c(listSubList, "connectList.subList(0, connectList.size)");
        f685a.clear();
        f = 0;
        try {
            Iterator<T> it = listSubList.iterator();
            while (it.hasNext()) {
                ((SocketChannel) it.next()).close();
            }
        } catch (Exception unused) {
        }
    }

    public final String R0() {
        return i1("scheduler-status", "", 2000L);
    }

    public final Object S(String str, b62<? super String> b62Var) {
        return g1("dex2oat-clear", str, t62.f(1000L), b62Var);
    }

    public final Object S0(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, b62<? super String> b62Var) {
        g30 g30Var = new g30();
        g30Var.x("source", str5);
        g30Var.x("category", str);
        g30Var.x("scene", str2);
        g30Var.x("mode", str3);
        g30Var.y("force", z);
        g30Var.x("reason", str4);
        g30Var.y("logger", z2);
        m42 m42Var = m42.f6769a;
        String string = g30Var.toString();
        f92.c(string, "(JSONObject().apply {\n  …er)\n        }).toString()");
        return g1("mode-switch", string, t62.f(2000L), b62Var);
    }

    public final boolean U(String str) {
        f92.d(str, "path");
        return bc2.x(E0(str), "dir", false, 2, null);
    }

    public final void U0(Boolean bool) {
        if (bool != null) {
            f690c = f92.a(bool, Boolean.TRUE);
        }
        if (r0()) {
            qc2.d(xd2.a(qe2.b()), null, null, new j40(bool, null), 3, null);
        }
    }

    public final Object V(String str, String[] strArr, b62<? super String> b62Var) {
        d30 d30Var = new d30();
        d30Var.k(str);
        for (String str2 : strArr) {
            d30Var.k(str2);
        }
        String string = d30Var.toString();
        f92.c(string, "dumpArgs.toString()");
        return g1("dumpsys", string, t62.f(5000L), b62Var);
    }

    public final void V0(String str, h50 h50Var) {
        f92.d(str, "path");
        f92.d(h50Var, "config");
        f684a = str;
        h50Var.a();
        b = h50Var.c();
        X0(h50Var.b());
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
    }

    public final byte[] W(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        f50 f50Var = f678a;
        Charset charset = bb2.f5692a;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        String str2 = f691d;
        Charset charset2 = bb2.f5692a;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes2 = str2.getBytes(charset2);
        f92.c(bytes2, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrEncode = Base64.encode(f50Var.c(bytes, bytes2), 11);
        f92.c(bArrEncode, "Base64.encode(\n         …Base64.URL_SAFE\n        )");
        return bArrEncode;
    }

    public final String W0(String str) {
        f92.d(str, "key");
        f689c = str;
        return f680a == o30.STATUS_RUNNING ? Q(str) : "";
    }

    public final Object X(String str, b62<? super String> b62Var) {
        return h1(this, "exec-shell", str, null, b62Var, 4, null);
    }

    public final void X0(int i) {
        if (1 <= i && 65534 >= i) {
            c = i;
        }
    }

    public final void Y(String str) {
        f92.d(str, "shell");
        qc2.d(hf2.f6309a, qe2.b(), null, new p30(str, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y0(boolean r7, a.b62<? super a.m42> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof a.k40
            if (r0 == 0) goto L13
            r0 = r8
            a.k40 r0 = (a.k40) r0
            int r1 = r0.f6571a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6571a = r1
            goto L18
        L13:
            a.k40 r0 = new a.k40
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f1603a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6571a
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            boolean r7 = r0.f1604b
            java.lang.Object r7 = r0.b
            a.e50 r7 = (a.e50) r7
            a.h42.b(r8)
            goto L6c
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            a.h42.b(r8)
            java.lang.String r8 = r6.y0()
            java.lang.String r2 = "root"
            boolean r8 = a.f92.a(r8, r2)
            if (r8 == 0) goto L6c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = ""
            r8.append(r2)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Long r2 = a.t62.f(r4)
            r0.b = r6
            r0.f1604b = r7
            r0.f6571a = r3
            java.lang.String r7 = "frame-time"
            java.lang.Object r7 = r6.g1(r7, r8, r2, r0)
            if (r7 != r1) goto L6c
            return r1
        L6c:
            a.m42 r7 = a.m42.f6769a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.Y0(boolean, a.b62):java.lang.Object");
    }

    public final String Z(String str) {
        f92.d(str, "shell");
        return j1(this, "exec-shell", str, null, 4, null);
    }

    public final String Z0(String str, String str2, int i, Long l) {
        f92.d(str, "prop");
        f92.d(str2, "value");
        g30 g30Var = new g30();
        g30Var.x("path", str);
        g30Var.x("text", str2);
        g30Var.v("mode", i);
        m42 m42Var = m42.f6769a;
        String string = g30Var.toString();
        f92.c(string, "JSONObject().apply {\n   …ode)\n        }.toString()");
        return i1("set-kernel-prop", string, Long.valueOf(l != null ? l.longValue() : 3000L));
    }

    @Override // a.i50
    public void a(SocketChannel socketChannel) {
        f92.d(socketChannel, "socketChannel");
        if (f685a.contains(socketChannel)) {
            Collection<g82<String, m42>> collectionValues = f686a.values();
            f92.c(collectionValues, "asyncTaskList.values");
            if (f685a.size() == 1 && (!collectionValues.isEmpty())) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(collectionValues);
                f686a.clear();
                new Thread(new a40(arrayList)).start();
            }
            f685a.remove(socketChannel);
        }
        if (f685a.isEmpty()) {
            f680a = o30.STATUS_STOP;
        }
        Log.e("Scene", "Daemon [onDisconnect]");
    }

    public final String a0(String str, long j) {
        f92.d(str, "shell");
        return i1("exec-shell", str, Long.valueOf(j));
    }

    public final Object a1(String str, b62<? super String> b62Var) {
        return g1("set-kernel-props", str, t62.f(15000L), b62Var);
    }

    @Override // a.i50
    public void b(String str, String str2) {
        f92.d(str, "type");
        f92.d(str2, "error");
        if (f92.a(str2, "exit")) {
            f680a = o30.STATUS_STOP;
        } else if (f92.a(str2, "license")) {
            f92.a(f693e, "root");
        }
    }

    public final void b0() {
        j1(this, "exit", "", null, 4, null);
    }

    public final Object b1(int i, b62<? super String> b62Var) {
        return g1("set-refresh-rate", String.valueOf(i), t62.f(500L), b62Var);
    }

    @Override // a.i50
    public void c(SocketChannel socketChannel, k50 k50Var) {
        f92.d(socketChannel, "socketChannel");
        f92.d(k50Var, "command");
        f = 0;
        R();
        f685a.add(0, socketChannel);
        f680a = o30.STATUS_RUNNING;
        Log.i("Scene", "Daemon [onConnected]");
        qc2.d(xd2.a(qe2.b()), null, null, new z30(null), 3, null);
    }

    public final g30 c0(boolean z) {
        String strI1 = i1("extreme-perf", "" + z, 2000L);
        if ((strI1.length() > 0) && (!f92.a(strI1, "error"))) {
            try {
                return new g30(strI1);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void c1(Application application, l50 l50Var) {
        f92.d(application, "context");
        f92.d(l50Var, "signalHandler");
        f679a = l50Var;
        SharedPreferences sharedPreferences = application.getSharedPreferences("daemon-info", 0);
        if (!f92.a(sharedPreferences.getString("version", ""), b)) {
            f687a = true;
            sharedPreferences.edit().putString("version", b).apply();
        }
    }

    @Override // a.i50
    public void d(SocketChannel socketChannel) {
        f92.d(socketChannel, "socketChannel");
        Log.e("Scene", "Daemon [onConnectFail]");
    }

    public final String d0() {
        String strJ1 = j1(this, "fas-supported", "", null, 4, null);
        return f92.a(strJ1, "error") ? "" : strJ1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d1(java.lang.String r6, a.b62<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof a.l40
            if (r0 == 0) goto L13
            r0 = r7
            a.l40 r0 = (a.l40) r0
            int r1 = r0.f6672a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6672a = r1
            goto L18
        L13:
            a.l40 r0 = new a.l40
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f1752a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6672a
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.c
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r0.b
            a.e50 r0 = (a.e50) r0
            a.h42.b(r7)
            goto L77
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            a.h42.b(r7)
            int r7 = r6.hashCode()
            r2 = 96415(0x1789f, float:1.35106E-40)
            java.lang.String r4 = "basic"
            if (r7 == r2) goto L62
            r2 = 3506402(0x3580e2, float:4.913516E-39)
            if (r7 == r2) goto L59
            r2 = 93508654(0x592d42e, float:1.3807717E-35)
            if (r7 == r2) goto L52
            goto La2
        L52:
            boolean r7 = r6.equals(r4)
            if (r7 == 0) goto La2
            goto L6a
        L59:
            java.lang.String r7 = "root"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto La2
            goto L6a
        L62:
            java.lang.String r7 = "adb"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto La2
        L6a:
            r0.b = r5
            r0.c = r6
            r0.f6672a = r3
            java.lang.Object r7 = r5.t1(r6, r0)
            if (r7 != r1) goto L77
            return r1
        L77:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L86
            a.e50.f693e = r6
            java.lang.Boolean r6 = a.t62.a(r3)
            return r6
        L86:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "setWorkingMode("
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = ") Fail!"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "Scene"
            android.util.Log.e(r7, r6)
            goto La4
        La2:
            a.e50.f693e = r4
        La4:
            r6 = 0
            java.lang.Boolean r6 = a.t62.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.d1(java.lang.String, a.b62):java.lang.Object");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Type inference failed for: r1v12, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v12, types: [T, java.lang.String] */
    @Override // a.i50
    public void e(String str, String str2) {
        Object next;
        wd2 wd2VarA;
        l62 l62Var;
        zd2 zd2Var;
        k82 e40Var;
        f92.d(str, "type");
        f92.d(str2, "message");
        if (f679a != null) {
            switch (str.hashCode()) {
                case -884997049:
                    if (str.equals("@Replay")) {
                        try {
                            g30 g30Var = new g30(str2);
                            String strI = g30Var.i("id");
                            String strI2 = g30Var.i("response");
                            Set<Map.Entry<String, g82<String, m42>>> setEntrySet = f686a.entrySet();
                            f92.c(setEntrySet, "asyncTaskList.entries");
                            Iterator<T> it = setEntrySet.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    next = it.next();
                                    if (f92.a((String) ((Map.Entry) next).getKey(), strI)) {
                                    }
                                } else {
                                    next = null;
                                }
                            }
                            Map.Entry entry = (Map.Entry) next;
                            if ((entry != null ? (g82) entry.getValue() : null) != null) {
                                f686a.remove(strI);
                                g82 g82Var = (g82) entry.getValue();
                                f92.c(strI2, "response");
                                g82Var.f(strI2);
                                return;
                            }
                            Log.e("@Scene", "ApiRequest " + strI + " Callback Removed!");
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    return;
                case -838369973:
                    if (!str.equals("@Notification")) {
                        return;
                    }
                    n92 n92Var = new n92();
                    n92Var.f6891a = "";
                    n92 n92Var2 = new n92();
                    n92Var2.f6891a = "";
                    try {
                        if (str2.length() > 0) {
                            if (ec2.C(str2, "|", false, 2, null)) {
                                int iN = ec2.N(str2, "|", 0, false, 6, null);
                                String strSubstring = str2.substring(0, iN);
                                f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                byte[] bArrDecode = Base64.decode(strSubstring, 11);
                                f92.c(bArrDecode, "Base64.decode(message.su…_WRAP or Base64.URL_SAFE)");
                                n92Var.f6891a = new String(bArrDecode, bb2.f5692a);
                                String strSubstring2 = str2.substring(iN + 1);
                                f92.c(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                                byte[] bArrDecode2 = Base64.decode(strSubstring2, 11);
                                f92.c(bArrDecode2, "Base64.decode(message.su…_WRAP or Base64.URL_SAFE)");
                                n92Var2.f6891a = new String(bArrDecode2, bb2.f5692a);
                            } else {
                                byte[] bArrDecode3 = Base64.decode(str2, 11);
                                f92.c(bArrDecode3, "Base64.decode(\n         …                        )");
                                n92Var.f6891a = new String(bArrDecode3, bb2.f5692a);
                            }
                        }
                        break;
                    } catch (Exception unused2) {
                    }
                    wd2VarA = xd2.a(qe2.b());
                    l62Var = null;
                    zd2Var = null;
                    e40Var = new e40(n92Var, n92Var2, null);
                    break;
                case -414679454:
                    if (str.equals("@TaskResult")) {
                        String strSubstring3 = str2.substring(ec2.N(str2, ":", 0, false, 6, null) + 1, ec2.N(str2, "=", 0, false, 6, null));
                        f92.c(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String strSubstring4 = str2.substring(ec2.N(str2, "=", 0, false, 6, null) + 1, str2.length());
                        f92.c(strSubstring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        qc2.d(xd2.a(qe2.b()), null, null, new b40(strSubstring3, strSubstring4.length() > 0 ? Base64.decode(strSubstring4, 11) : new byte[0], null), 3, null);
                        return;
                    }
                    return;
                case 1911967788:
                    if (!str.equals("@Scene")) {
                        return;
                    }
                    wd2VarA = xd2.a(qe2.b());
                    l62Var = null;
                    zd2Var = null;
                    e40Var = new d40(str2, null);
                    break;
                case 1913245127:
                    if (!str.equals("@Toast")) {
                        return;
                    }
                    wd2VarA = xd2.a(qe2.b());
                    l62Var = null;
                    zd2Var = null;
                    e40Var = new c40(str2, null);
                    break;
                default:
                    return;
            }
            qc2.d(wd2VarA, l62Var, zd2Var, e40Var, 3, null);
        }
    }

    public final boolean e0(String str, boolean z) {
        f92.d(str, "path");
        String strE0 = E0(str);
        if (!bc2.x(strE0, "file", false, 2, null)) {
            return false;
        }
        if (!z) {
            return true;
        }
        int iM = ec2.M(strE0, ',', 0, false, 6, null) + 1;
        if (strE0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strE0.substring(iM);
        f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return Long.parseLong(strSubstring) > 0;
    }

    public final Object e1(String str, int i, b62<? super String> b62Var) {
        g30 g30Var = new g30();
        g30Var.x("shell", str);
        g30Var.v("delay", i);
        String string = g30Var.toString();
        f92.c(string, "task.toString()");
        return g1("shell-delayed-add", string, t62.f(1000L), b62Var);
    }

    @Override // a.i50
    public void f(int i) {
    }

    public final Object f1(String str, b62<? super m42> b62Var) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Object objG1 = g1("shell-delayed-remove", str, t62.f(1000L), b62Var);
        return objG1 == r62.c() ? objG1 : m42.f6769a;
    }

    public final long g0(String str) {
        f92.d(str, "path");
        String strE0 = E0(str);
        if (!ec2.C(strE0, ",", false, 2, null)) {
            return -1L;
        }
        int iN = ec2.N(strE0, ",", 0, false, 6, null) + 1;
        if (strE0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strE0.substring(iN);
        f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return Long.parseLong(strSubstring);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object g1(java.lang.String r9, java.lang.String r10, java.lang.Long r11, a.b62<? super java.lang.String> r12) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r8 = this;
            boolean r0 = r12 instanceof a.m40
            if (r0 == 0) goto L13
            r0 = r12
            a.m40 r0 = (a.m40) r0
            int r1 = r0.f6767a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6767a = r1
            goto L18
        L13:
            a.m40 r0 = new a.m40
            r0.<init>(r8, r12)
        L18:
            r6 = r0
            java.lang.Object r12 = r6.f1889a
            java.lang.Object r0 = a.r62.c()
            int r1 = r6.f6767a
            r2 = 2
            r3 = 1
            java.lang.String r7 = "error"
            if (r1 == 0) goto L60
            if (r1 == r3) goto L4c
            if (r1 != r2) goto L44
            java.lang.Object r9 = r6.f
            java.nio.channels.SocketChannel r9 = (java.nio.channels.SocketChannel) r9
            java.lang.Object r9 = r6.e
            java.lang.Long r9 = (java.lang.Long) r9
            java.lang.Object r9 = r6.d
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r6.c
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r6.b
            a.e50 r9 = (a.e50) r9
            a.h42.b(r12)
            goto Laa
        L44:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L4c:
            java.lang.Object r9 = r6.e
            java.lang.Long r9 = (java.lang.Long) r9
            java.lang.Object r9 = r6.d
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r6.c
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r6.b
            a.e50 r9 = (a.e50) r9
            a.h42.b(r12)
            goto L82
        L60:
            a.h42.b(r12)
            a.v50 r12 = a.e50.f681a
            boolean r12 = r12.c()
            if (r12 == 0) goto L88
            a.v50 r2 = a.e50.f681a
            r6.b = r8
            r6.c = r9
            r6.d = r10
            r6.e = r11
            r6.f6767a = r3
            r1 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r12 = r1.m1(r2, r3, r4, r5, r6)
            if (r12 != r0) goto L82
            return r0
        L82:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L87
            r7 = r12
        L87:
            return r7
        L88:
            boolean r12 = a.e50.f694e
            if (r12 != 0) goto Lb3
            java.nio.channels.SocketChannel r12 = r8.q0()
            if (r12 == 0) goto Lb0
            r6.b = r8
            r6.c = r9
            r6.d = r10
            r6.e = r11
            r6.f = r12
            r6.f6767a = r2
            r1 = r8
            r2 = r12
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r12 = r1.m1(r2, r3, r4, r5, r6)
            if (r12 != r0) goto Laa
            return r0
        Laa:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto Laf
            r7 = r12
        Laf:
            return r7
        Lb0:
            r8.x1()
        Lb3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.g1(java.lang.String, java.lang.String, java.lang.Long, a.b62):java.lang.Object");
    }

    @Override // a.r50
    public int h() {
        return d;
    }

    public final Object h0(String str, b62<? super String> b62Var) {
        return g1("app-refresh-rate", str, t62.f(500L), b62Var);
    }

    @Override // a.r50
    public int i() {
        return e;
    }

    public final boolean i0(String str, i50 i50Var) throws IOException {
        f92.d(str, "shellCommand");
        f92.d(i50Var, "handler");
        if (q0() != null) {
            j1(this, "connect", "", null, 4, null);
        }
        SocketChannel socketChannelC0 = C0();
        try {
            socketChannelC0.connect(new InetSocketAddress("127.0.0.1", c));
            i50Var.c(socketChannelC0, k0(socketChannelC0));
            q1(socketChannelC0, i50Var);
            o1(socketChannelC0, W(str));
            return true;
        } catch (IOException e2) {
            if ((e2 instanceof ConnectException) && f92.a(e2.getMessage(), "Permission denied") && System.currentTimeMillis() - f5967a > 5000) {
                l50 l50Var = f679a;
                if (l50Var != null) {
                    l50Var.c("请不要禁止Scene连接网络!\nDo not deny Scene access to the network!");
                }
                f5967a = System.currentTimeMillis();
            }
            i50Var.d(socketChannelC0);
            return false;
        }
    }

    public final String i1(String str, String str2, Long l) {
        f92.d(str, "api");
        f92.d(str2, "content");
        if ((l != null ? l.longValue() : 9999L) > 5000 && f92.a(Looper.myLooper(), f682a)) {
            Log.e("@Scene", "在主线程上执行耗时调用！" + str);
        }
        return (String) pc2.b(null, new n40(str, str2, l, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j0(a.b62<? super java.util.ArrayList<java.lang.Integer>> r11) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r10 = this;
            boolean r0 = r11 instanceof a.q30
            if (r0 == 0) goto L13
            r0 = r11
            a.q30 r0 = (a.q30) r0
            int r1 = r0.f7173a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7173a = r1
            goto L18
        L13:
            a.q30 r0 = new a.q30
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.f2540a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f7173a
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r0.c
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.lang.Object r0 = r0.b
            a.e50 r0 = (a.e50) r0
            a.h42.b(r11)
            goto L5a
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L39:
            a.h42.b(r11)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Long r2 = a.t62.f(r4)
            r0.b = r10
            r0.c = r11
            r0.f7173a = r3
            java.lang.String r4 = "cpu-cycles"
            java.lang.String r5 = ""
            java.lang.Object r0 = r10.g1(r4, r5, r2, r0)
            if (r0 != r1) goto L58
            return r1
        L58:
            r1 = r11
            r11 = r0
        L5a:
            r4 = r11
            java.lang.String r4 = (java.lang.String) r4
            int r11 = r4.length()
            if (r11 <= 0) goto L65
            r11 = r3
            goto L66
        L65:
            r11 = 0
        L66:
            if (r11 == 0) goto La0
            java.lang.String r11 = "error"
            boolean r11 = a.f92.a(r4, r11)
            r11 = r11 ^ r3
            if (r11 == 0) goto La0
            java.lang.String r11 = "\n"
            java.lang.String[] r5 = new java.lang.String[]{r11}     // Catch: java.lang.Exception -> La0
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            java.util.List r11 = a.ec2.d0(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> La0
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Exception -> La0
        L83:
            boolean r0 = r11.hasNext()     // Catch: java.lang.Exception -> La0
            if (r0 == 0) goto La0
            java.lang.Object r0 = r11.next()     // Catch: java.lang.Exception -> La0
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> La0
            long r2 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Exception -> La0
            r0 = 1000(0x3e8, float:1.401E-42)
            long r4 = (long) r0     // Catch: java.lang.Exception -> La0
            long r2 = r2 / r4
            int r0 = (int) r2     // Catch: java.lang.Exception -> La0
            java.lang.Integer r0 = a.t62.e(r0)     // Catch: java.lang.Exception -> La0
            r1.add(r0)     // Catch: java.lang.Exception -> La0
            goto L83
        La0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.j0(a.b62):java.lang.Object");
    }

    public final k50 k0(SocketChannel socketChannel) {
        return new s30(socketChannel);
    }

    public final byte[] k1(String str, String str2, String str3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        return W("@Api:" + (ec2.X(str, 20, ' ') + ec2.X(str2, 30, ' ') + str3));
    }

    public final String l0() {
        String strI1 = i1("daemon-version", "", 500L);
        if ((strI1.length() > 0) && (!f92.a(strI1, "error"))) {
            return strI1;
        }
        return null;
    }

    public final void l1(i50 i50Var, ArrayList<String> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        qc2.d(hf2.f6309a, qe2.b(), null, new o40(arrayList, i50Var, null), 2, null);
    }

    public final g30 m0() {
        String strI1 = i1("device-id", "", 1000L);
        if ((strI1.length() > 0) && (!f92.a(strI1, "error"))) {
            try {
                return new g30(strI1);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, a.tc2, a.uc2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ <T> java.lang.Object m1(T r22, java.lang.String r23, java.lang.String r24, java.lang.Long r25, a.b62<? super java.lang.String> r26) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.m1(java.lang.Object, java.lang.String, java.lang.String, java.lang.Long, a.b62):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n0(a.b62<? super java.lang.String> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof a.t30
            if (r0 == 0) goto L13
            r0 = r9
            a.t30 r0 = (a.t30) r0
            int r1 = r0.f7460a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7460a = r1
            goto L18
        L13:
            a.t30 r0 = new a.t30
            r0.<init>(r8, r9)
        L18:
            r5 = r0
            java.lang.Object r9 = r5.f2947a
            java.lang.Object r0 = a.r62.c()
            int r1 = r5.f7460a
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r0 = r5.b
            a.e50 r0 = (a.e50) r0
            a.h42.b(r9)
            goto L4c
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L36:
            a.h42.b(r9)
            r4 = 0
            r6 = 4
            r7 = 0
            r5.b = r8
            r5.f7460a = r2
            java.lang.String r2 = "focused-activity"
            java.lang.String r3 = ""
            r1 = r8
            java.lang.Object r9 = h1(r1, r2, r3, r4, r5, r6, r7)
            if (r9 != r0) goto L4c
            return r0
        L4c:
            java.lang.String r9 = (java.lang.String) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.n0(a.b62):java.lang.Object");
    }

    public final void n1(v50 v50Var, byte[] bArr) {
        try {
            byte[] bArr2 = new byte[bArr.length + 4];
            System.arraycopy(u50.b(bArr.length), 0, bArr2, 0, 4);
            System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
            qc2.d(xd2.a(qe2.b()), null, null, new u40(v50Var, bArr2, null), 3, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o0(java.lang.String r7, a.b62<? super java.lang.String> r8) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof a.u30
            if (r0 == 0) goto L13
            r0 = r8
            a.u30 r0 = (a.u30) r0
            int r1 = r0.f7562a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7562a = r1
            goto L18
        L13:
            a.u30 r0 = new a.u30
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f3123a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f7562a
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.b
            a.e50 r7 = (a.e50) r7
            a.h42.b(r8)
            goto L51
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            a.h42.b(r8)
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.Long r8 = a.t62.f(r4)
            r0.b = r6
            r0.c = r7
            r0.f7562a = r3
            java.lang.String r2 = "get-kernel-prop"
            java.lang.Object r8 = r6.g1(r2, r7, r8, r0)
            if (r8 != r1) goto L51
            return r1
        L51:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L5e
            java.lang.CharSequence r7 = a.ec2.r0(r8)
            java.lang.String r7 = r7.toString()
            return r7
        L5e:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.CharSequence"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.o0(java.lang.String, a.b62):java.lang.Object");
    }

    public final void o1(SocketChannel socketChannel, byte[] bArr) {
        try {
            qc2.d(xd2.a(qe2.b()), null, null, new t40(socketChannel, p1(bArr), null), 3, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p0(java.lang.String[] r14, a.b62<? super java.lang.String[]> r15) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r13 = this;
            boolean r0 = r15 instanceof a.v30
            if (r0 == 0) goto L13
            r0 = r15
            a.v30 r0 = (a.v30) r0
            int r1 = r0.f7654a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7654a = r1
            goto L18
        L13:
            a.v30 r0 = new a.v30
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.f3231a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f7654a
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r14 = r0.c
            java.lang.String[] r14 = (java.lang.String[]) r14
            java.lang.Object r0 = r0.b
            a.e50 r0 = (a.e50) r0
            a.h42.b(r15)
            goto L60
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L39:
            a.h42.b(r15)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 62
            r12 = 0
            java.lang.String r5 = "\n"
            r4 = r14
            java.lang.String r15 = a.u42.x(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Long r2 = a.t62.f(r4)
            r0.b = r13
            r0.c = r14
            r0.f7654a = r3
            java.lang.String r3 = "get-kernel-props"
            java.lang.Object r15 = r13.g1(r3, r15, r2, r0)
            if (r15 != r1) goto L60
            return r1
        L60:
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto La2
            java.lang.CharSequence r15 = a.ec2.r0(r15)
            java.lang.String r15 = r15.toString()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r14 = r14.length
            r0.<init>(r14)
            r14 = 0
            a.d30 r1 = new a.d30     // Catch: java.lang.Exception -> L91
            r1.<init>(r15)     // Catch: java.lang.Exception -> L91
            int r15 = r1.g()     // Catch: java.lang.Exception -> L91
            r2 = r14
        L7d:
            if (r2 >= r15) goto L91
            boolean r3 = r1.f(r2)     // Catch: java.lang.Exception -> L91
            if (r3 == 0) goto L87
            r3 = 0
            goto L8b
        L87:
            java.lang.String r3 = r1.e(r2)     // Catch: java.lang.Exception -> L91
        L8b:
            r0.add(r3)     // Catch: java.lang.Exception -> L91
            int r2 = r2 + 1
            goto L7d
        L91:
            java.lang.String[] r14 = new java.lang.String[r14]
            java.lang.Object[] r14 = r0.toArray(r14)
            if (r14 == 0) goto L9a
            return r14
        L9a:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            java.lang.String r15 = "null cannot be cast to non-null type kotlin.Array<T>"
            r14.<init>(r15)
            throw r14
        La2:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            java.lang.String r15 = "null cannot be cast to non-null type kotlin.CharSequence"
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.p0(java.lang.String[], a.b62):java.lang.Object");
    }

    public final ByteBuffer p1(byte[] bArr) {
        ByteBuffer byteBufferPut = ByteBuffer.allocate(bArr.length + 4).put(u50.b(bArr.length)).put(bArr);
        byteBufferPut.flip();
        f92.c(byteBufferPut, "buffer");
        return byteBufferPut;
    }

    public final SocketChannel q0() {
        Object next;
        Iterator<T> it = f685a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SocketChannel) next).isConnected()) {
                break;
            }
        }
        return (SocketChannel) next;
    }

    public final <T> void q1(T t, i50 i50Var) {
        new x40(t, i50Var).start();
    }

    public final boolean r0() {
        return q0() != null || f681a.c() || (f680a == o30.STATUS_RUNNING && !f694e);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[Catch: all -> 0x0175, Exception -> 0x0177, TRY_ENTER, TryCatch #0 {all -> 0x0175, blocks: (B:12:0x0020, B:78:0x0177, B:15:0x002a, B:18:0x003a, B:19:0x0059, B:21:0x0065, B:22:0x0085, B:24:0x008b, B:26:0x0091, B:31:0x00a7, B:33:0x00c9, B:34:0x00da, B:35:0x00e1, B:30:0x0099), top: B:90:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[Catch: all -> 0x0175, Exception -> 0x0177, TryCatch #0 {all -> 0x0175, blocks: (B:12:0x0020, B:78:0x0177, B:15:0x002a, B:18:0x003a, B:19:0x0059, B:21:0x0065, B:22:0x0085, B:24:0x008b, B:26:0x0091, B:31:0x00a7, B:33:0x00c9, B:34:0x00da, B:35:0x00e1, B:30:0x0099), top: B:90:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012b A[Catch: all -> 0x016e, Exception -> 0x0173, TryCatch #4 {Exception -> 0x0173, all -> 0x016e, blocks: (B:40:0x00e8, B:42:0x00ee, B:44:0x00f9, B:46:0x00fd, B:48:0x0103, B:49:0x010c, B:52:0x011e, B:54:0x012b, B:56:0x013a, B:63:0x0151, B:65:0x0157, B:68:0x0161, B:70:0x0165, B:51:0x0114, B:43:0x00f6), top: B:92:0x00e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0165 A[Catch: all -> 0x016e, Exception -> 0x0173, TRY_LEAVE, TryCatch #4 {Exception -> 0x0173, all -> 0x016e, blocks: (B:40:0x00e8, B:42:0x00ee, B:44:0x00f9, B:46:0x00fd, B:48:0x0103, B:49:0x010c, B:52:0x011e, B:54:0x012b, B:56:0x013a, B:63:0x0151, B:65:0x0157, B:68:0x0161, B:70:0x0165, B:51:0x0114, B:43:0x00f6), top: B:92:0x00e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r1(boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.r1(boolean):boolean");
    }

    public final String s0() {
        return f695f;
    }

    public final Object t0(String str, b62<? super String> b62Var) {
        return h1(this, "surface-view-size", str, null, b62Var, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object t1(java.lang.String r11, a.b62<? super java.lang.Boolean> r12) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.t1(java.lang.String, a.b62):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u0(java.lang.String r7, java.lang.Double r8, a.b62<? super java.lang.Double> r9) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            boolean r0 = r9 instanceof a.w30
            if (r0 == 0) goto L13
            r0 = r9
            a.w30 r0 = (a.w30) r0
            int r1 = r0.f7751a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7751a = r1
            goto L18
        L13:
            a.w30 r0 = new a.w30
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f3377a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f7751a
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r7 = r0.d
            r8 = r7
            java.lang.Double r8 = (java.lang.Double) r8
            java.lang.Object r7 = r0.c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.b
            a.e50 r7 = (a.e50) r7
            a.h42.b(r9)
            goto L58
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            a.h42.b(r9)
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.Long r9 = a.t62.f(r4)
            r0.b = r6
            r0.c = r7
            r0.d = r8
            r0.f7751a = r3
            java.lang.String r2 = "temperature"
            java.lang.Object r9 = r6.g1(r2, r7, r9, r0)
            if (r9 != r1) goto L58
            return r1
        L58:
            java.lang.String r9 = (java.lang.String) r9
            int r7 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.Exception -> L63
            java.lang.Integer r7 = a.t62.e(r7)     // Catch: java.lang.Exception -> L63
            goto L64
        L63:
            r7 = 0
        L64:
            if (r7 == 0) goto L78
            int r9 = r7.intValue()
            r0 = -1
            if (r9 == r0) goto L78
            int r7 = r7.intValue()
            int r7 = r7 / 100
            double r7 = (double) r7
            r0 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r7 = r7 / r0
            goto L81
        L78:
            if (r8 == 0) goto L7f
            double r7 = r8.doubleValue()
            goto L81
        L7f:
            r7 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L81:
            java.lang.Double r7 = a.t62.c(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.u0(java.lang.String, java.lang.Double, a.b62):java.lang.Object");
    }

    public final void u1(boolean z) {
        f692d = z;
        qc2.d(xd2.a(qe2.b()), null, null, new z40(z, null), 3, null);
    }

    public final boolean v1(String str, String str2) {
        f92.d(str, "path");
        f92.d(str2, "text");
        g30 g30Var = new g30();
        g30Var.x("path", str);
        g30Var.x("text", str2);
        m42 m42Var = m42.f6769a;
        String string = g30Var.toString();
        f92.c(string, "JSONObject().apply {\n   …ext)\n        }.toString()");
        return f92.a(i1("text-write", string, 20000L), "true");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w0(int r7, a.b62<? super a.d30> r8) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof a.x30
            if (r0 == 0) goto L13
            r0 = r8
            a.x30 r0 = (a.x30) r0
            int r1 = r0.f7850a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7850a = r1
            goto L18
        L13:
            a.x30 r0 = new a.x30
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f3522a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f7850a
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r7 = r0.b
            java.lang.Object r7 = r0.f3523b
            a.e50 r7 = (a.e50) r7
            a.h42.b(r8)
            goto L53
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            a.h42.b(r8)
            java.lang.String r8 = java.lang.String.valueOf(r7)
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Long r2 = a.t62.f(r4)
            r0.f3523b = r6
            r0.b = r7
            r0.f7850a = r3
            java.lang.String r7 = "get-threads"
            java.lang.Object r8 = r6.g1(r7, r8, r2, r0)
            if (r8 != r1) goto L53
            return r1
        L53:
            java.lang.String r8 = (java.lang.String) r8
            int r7 = r8.length()
            if (r7 <= 0) goto L5d
            r7 = r3
            goto L5e
        L5d:
            r7 = 0
        L5e:
            r0 = 0
            if (r7 == 0) goto L70
            java.lang.String r7 = "error"
            boolean r7 = a.f92.a(r8, r7)
            r7 = r7 ^ r3
            if (r7 == 0) goto L70
            a.d30 r7 = new a.d30     // Catch: java.lang.Exception -> L70
            r7.<init>(r8)     // Catch: java.lang.Exception -> L70
            return r7
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.w0(int, a.b62):java.lang.Object");
    }

    public final void w1(String str, String str2) {
        int i;
        Log.e("@Scene", "api:" + str);
        int i2 = 0;
        if (f > 14) {
            f = 0;
            ArrayList<SocketChannel> arrayList = f685a;
            List<SocketChannel> listSubList = arrayList.subList(0, arrayList.size());
            f92.c(listSubList, "connectList.subList(0, connectList.size)");
            Iterator<T> it = listSubList.iterator();
            while (it.hasNext()) {
                ((SocketChannel) it.next()).close();
            }
            return;
        }
        int iActiveCount = Thread.activeCount();
        int size = f686a.size();
        Thread[] threadArr = new Thread[iActiveCount];
        Thread threadCurrentThread = Thread.currentThread();
        f92.c(threadCurrentThread, "current");
        threadCurrentThread.getThreadGroup().enumerate(threadArr);
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 1;
            if (i2 >= iActiveCount) {
                break;
            }
            Thread thread = threadArr[i2];
            if (thread != null && thread.getState() == Thread.State.BLOCKED) {
                if (f92.a(thread.getClass().getName(), "kotlinx.coroutines.scheduling.CoroutineScheduler$Worker")) {
                    i4++;
                } else {
                    i3++;
                    if (f92.a(thread.getName(), "main")) {
                        z = true;
                    }
                    sb.append(thread.getName());
                    sb.append(",");
                }
            }
            i2++;
        }
        int i5 = f;
        if (z) {
            i = 10;
        } else if (i3 > 0) {
            i = 5;
        }
        f = i5 + i;
        if (i4 > 0 || i3 > 0) {
            Log.e("@Scene", "出现阻塞，线程数:" + iActiveCount + "，挂起任务:" + size + "，阻塞协程:" + i4 + "，阻塞线程:" + i3 + ' ' + ((Object) sb));
            if (i4 > 20) {
                Process.killProcess(Process.myPid());
            } else if (i4 > 5) {
                R();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x0(java.lang.String r7, a.b62<? super a.d30> r8) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof a.y30
            if (r0 == 0) goto L13
            r0 = r8
            a.y30 r0 = (a.y30) r0
            int r1 = r0.f7945a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7945a = r1
            goto L18
        L13:
            a.y30 r0 = new a.y30
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f3654a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f7945a
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.b
            a.e50 r7 = (a.e50) r7
            a.h42.b(r8)
            goto L62
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            a.h42.b(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "pkg:"
            r8.append(r2)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Long r2 = a.t62.f(r4)
            r0.b = r6
            r0.c = r7
            r0.f7945a = r3
            java.lang.String r7 = "get-threads"
            java.lang.Object r8 = r6.g1(r7, r8, r2, r0)
            if (r8 != r1) goto L62
            return r1
        L62:
            java.lang.String r8 = (java.lang.String) r8
            int r7 = r8.length()
            if (r7 <= 0) goto L6c
            r7 = r3
            goto L6d
        L6c:
            r7 = 0
        L6d:
            r0 = 0
            if (r7 == 0) goto L7f
            java.lang.String r7 = "error"
            boolean r7 = a.f92.a(r8, r7)
            r7 = r7 ^ r3
            if (r7 == 0) goto L7f
            a.d30 r7 = new a.d30     // Catch: java.lang.Exception -> L7f
            r7.<init>(r8)     // Catch: java.lang.Exception -> L7f
            return r7
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.x0(java.lang.String, a.b62):java.lang.Object");
    }

    public final void x1() {
        if (f694e) {
            return;
        }
        f694e = true;
        R();
        qc2.d(xd2.a(qe2.b()), null, null, new a50(null), 3, null);
    }

    public final String y0() {
        return r0() ? f693e : "basic";
    }

    public final Object y1(b62<? super String> b62Var) {
        return g1("user-group", "", t62.f(1000L), b62Var);
    }

    public final void z0(Context context) {
        f92.d(context, "context");
        String strD = new k60().d(context);
        f92.c(strD, "SignTool().getSignature(context)");
        f691d = strD;
        Charset charset = bb2.f5692a;
        if (strD == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        f92.c(strD.getBytes(charset), "(this as java.lang.String).getBytes(charset)");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object z1(java.lang.String r7, a.b62<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof a.b50
            if (r0 == 0) goto L13
            r0 = r8
            a.b50 r0 = (a.b50) r0
            int r1 = r0.f5674a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5674a = r1
            goto L18
        L13:
            a.b50 r0 = new a.b50
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f231a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f5674a
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r0.b
            a.e50 r0 = (a.e50) r0
            a.h42.b(r8)
            goto L55
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            a.h42.b(r8)
            r4 = 0
            r8 = 0
            B1(r6, r4, r3, r8)
            a.o30 r8 = a.e50.f680a
            a.o30 r2 = a.o30.STATUS_RUNNING
            if (r8 != r2) goto L5c
            r0.b = r6
            r0.c = r7
            r0.f5674a = r3
            java.lang.Object r8 = r6.y1(r0)
            if (r8 != r1) goto L55
            return r1
        L55:
            java.lang.String r8 = (java.lang.String) r8
            boolean r7 = a.f92.a(r8, r7)
            goto L5d
        L5c:
            r7 = 0
        L5d:
            java.lang.Boolean r7 = a.t62.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e50.z1(java.lang.String, a.b62):java.lang.Object");
    }
}
