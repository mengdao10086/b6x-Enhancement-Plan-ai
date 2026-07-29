package com.just.agentweb.download;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import com.just.agentweb.Action;
import com.just.agentweb.ActionActivity;
import com.just.agentweb.download.AgentWebDownloader;
import g.n0;
import g.p0;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import xf.c0;
import xf.g0;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultDownloadImpl implements DownloadListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile AtomicInteger f21912p = new AtomicInteger(1);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f21913q = DefaultDownloadImpl.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f21915b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f21918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f21919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f21920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f21921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<xf.b> f21922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ExtraServiceImpl f21923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f21924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ExtraServiceImpl f21925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile h f21926m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Activity> f21916c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g0 f21917d = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Pattern f21927n = Pattern.compile(".*filename=(.*)");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e f21928o = new c();

    public static class ExecuteTasksMap extends ReentrantReadWriteLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static volatile ExecuteTasksMap f21929a;
        private LinkedList<String> mTasks;

        private ExecuteTasksMap() {
            super(false);
            this.mTasks = null;
            this.mTasks = new LinkedList<>();
        }

        public static ExecuteTasksMap c() {
            if (f21929a == null) {
                synchronized (ExecuteTasksMap.class) {
                    if (f21929a == null) {
                        f21929a = new ExecuteTasksMap();
                    }
                }
            }
            return f21929a;
        }

        public void a(String str, String str2) {
            try {
                writeLock().lock();
                this.mTasks.add(str);
                this.mTasks.add(str2);
            } finally {
                writeLock().unlock();
            }
        }

        public boolean b(String str) {
            try {
                readLock().lock();
                return this.mTasks.contains(str);
            } finally {
                readLock().unlock();
            }
        }

        public void d(String str) {
            try {
                writeLock().lock();
                int iIndexOf = this.mTasks.indexOf(str);
                if (iIndexOf == -1) {
                    return;
                }
                this.mTasks.remove(iIndexOf);
                this.mTasks.remove(iIndexOf - 1);
            } finally {
                writeLock().unlock();
            }
        }
    }

    public static class ExtraServiceImpl extends AgentWebDownloader.ExtraService implements Cloneable, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Activity f21930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient d f21931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient g0 f21932c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public transient WebView f21933d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public transient h f21934e;
        public String mContentDisposition;
        public long mContentLength;
        private DefaultDownloadImpl mDefaultDownload;
        private boolean mIsCloneObject = false;
        public String mMimetype;
        public String mUrl;
        public String mUserAgent;

        public ExtraServiceImpl A0(WebView webView) {
            this.f21933d = webView;
            return this;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.ExtraService
        public synchronized void L() {
            c0.c(DefaultDownloadImpl.f21913q, "performReDownload:" + this.mDefaultDownload);
            DefaultDownloadImpl defaultDownloadImpl = this.mDefaultDownload;
            if (defaultDownloadImpl != null) {
                defaultDownloadImpl.q(m(), n(), d(), l(), f(), this);
            }
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        public String d() {
            return this.mContentDisposition;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        public long f() {
            return this.mContentLength;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        public String l() {
            return this.mMimetype;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        public String m() {
            return this.mUrl;
        }

        /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
        public ExtraServiceImpl clone() throws CloneNotSupportedException {
            ExtraServiceImpl extraServiceImpl = (ExtraServiceImpl) super.clone();
            extraServiceImpl.mIsCloneObject = true;
            extraServiceImpl.f21930a = null;
            extraServiceImpl.f21931b = null;
            extraServiceImpl.f21932c = null;
            extraServiceImpl.f21933d = null;
            return extraServiceImpl;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        public String n() {
            return this.mUserAgent;
        }

        public DefaultDownloadImpl o0() {
            DefaultDownloadImpl defaultDownloadImpl = new DefaultDownloadImpl(this);
            this.mDefaultDownload = defaultDownloadImpl;
            return defaultDownloadImpl;
        }

        public ExtraServiceImpl p0(Activity activity) {
            this.f21930a = activity;
            return this;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
        public ExtraServiceImpl x(String str) {
            this.mContentDisposition = str;
            return this;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
        public ExtraServiceImpl y(long j10) {
            this.mContentLength = j10;
            return this;
        }

        public ExtraServiceImpl t0(d dVar) {
            this.f21931b = dVar;
            return this;
        }

        public ExtraServiceImpl u0(h hVar) {
            this.f21934e = hVar;
            return this;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
        public ExtraServiceImpl G(String str) {
            this.mMimetype = str;
            return this;
        }

        public ExtraServiceImpl w0(g0 g0Var) {
            this.f21932c = g0Var;
            return this;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public ExtraServiceImpl J(String str) {
            this.mUrl = str;
            return this;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
        public ExtraServiceImpl K(String str) {
            this.mUserAgent = str;
            return this;
        }
    }

    public class a implements ActionActivity.b {
        public a() {
        }

        @Override // com.just.agentweb.ActionActivity.b
        public void a(@n0 String[] strArr, @n0 int[] iArr, Bundle bundle) {
            if (DefaultDownloadImpl.this.j().isEmpty()) {
                DefaultDownloadImpl.this.s();
                return;
            }
            if (DefaultDownloadImpl.this.f21922i.get() != null) {
                ((xf.b) DefaultDownloadImpl.this.f21922i.get()).m((String[]) DefaultDownloadImpl.this.j().toArray(new String[0]), xf.e.f55221f, "Download");
            }
            c0.a(DefaultDownloadImpl.f21913q, "储存权限获取失败~");
        }
    }

    public class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f21936a;

        public b(File file) {
            this.f21936a = file;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            DefaultDownloadImpl.this.m(this.f21936a);
            return true;
        }
    }

    public class c extends e {
        public c() {
        }

        @Override // com.just.agentweb.download.e, com.just.agentweb.download.h
        public void b(String str, i iVar) {
            if (DefaultDownloadImpl.this.f21926m != null) {
                synchronized (DefaultDownloadImpl.this.f21926m) {
                    DefaultDownloadImpl.this.f21926m.b(str, iVar);
                }
            }
        }

        @Override // com.just.agentweb.download.e, com.just.agentweb.download.h
        public void c(String str, i iVar) {
            if (DefaultDownloadImpl.this.f21926m != null) {
                synchronized (DefaultDownloadImpl.this.f21926m) {
                    DefaultDownloadImpl.this.f21926m.c(str, iVar);
                }
            }
        }

        @Override // com.just.agentweb.download.e, com.just.agentweb.download.d
        public boolean d(String str, String str2, Throwable th2) {
            ExecuteTasksMap.c().d(str);
            return DefaultDownloadImpl.this.f21915b != null && DefaultDownloadImpl.this.f21915b.d(str, str2, th2);
        }

        @Override // com.just.agentweb.download.e, com.just.agentweb.download.h
        public void e(String str, long j10, long j11, long j12) {
            if (DefaultDownloadImpl.this.f21926m != null) {
                synchronized (DefaultDownloadImpl.this.f21926m) {
                    if (DefaultDownloadImpl.this.f21926m != null) {
                        DefaultDownloadImpl.this.f21926m.e(str, j10, j11, j12);
                    }
                }
            }
        }
    }

    public DefaultDownloadImpl(ExtraServiceImpl extraServiceImpl) {
        this.f21925l = null;
        if (extraServiceImpl.mIsCloneObject) {
            this.f21925l = extraServiceImpl;
        } else {
            i(extraServiceImpl);
            this.f21923j = extraServiceImpl;
        }
    }

    public static DefaultDownloadImpl k(@n0 Activity activity, @n0 WebView webView, @p0 d dVar, @n0 h hVar, @p0 g0 g0Var) {
        return new ExtraServiceImpl().p0(activity).A0(webView).t0(dVar).w0(g0Var).u0(hVar).o0();
    }

    public final void i(ExtraServiceImpl extraServiceImpl) {
        this.f21916c = new WeakReference<>(extraServiceImpl.f21930a);
        this.f21914a = extraServiceImpl.f21930a.getApplicationContext();
        this.f21915b = extraServiceImpl.f21931b;
        this.f21926m = extraServiceImpl.f21934e;
        this.f21917d = extraServiceImpl.f21932c;
        this.f21922i = new WeakReference<>(com.just.agentweb.a.p(extraServiceImpl.f21933d));
    }

    public final List<String> j() {
        ArrayList arrayList = new ArrayList();
        Activity activity = this.f21916c.get();
        String[] strArr = xf.e.f55218c;
        if (!com.just.agentweb.a.H(activity, strArr)) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return arrayList;
    }

    public final Handler.Callback l(File file) {
        return new b(file);
    }

    public final void m(File file) {
        this.f21925l.C(true);
        r(file);
    }

    public final File n(String str, String str2) {
        String strO;
        String str3 = "";
        try {
            strO = o(str);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            boolean z10 = true;
            if (TextUtils.isEmpty(strO) && !TextUtils.isEmpty(str2)) {
                Uri uri = Uri.parse(str2);
                strO = uri.getPath().substring(uri.getPath().lastIndexOf(47) + 1);
            }
            if (!TextUtils.isEmpty(strO) && strO.length() > 64) {
                strO = strO.substring(strO.length() - 64, strO.length());
            }
            if (TextUtils.isEmpty(strO)) {
                strO = com.just.agentweb.a.S(str2);
            }
            if (strO.contains("\"")) {
                strO = strO.replace("\"", "");
            }
            str3 = strO;
            Context context = this.f21914a;
            if (this.f21925l.r()) {
                z10 = false;
            }
            return com.just.agentweb.a.k(context, str3, z10);
        } catch (Throwable th3) {
            th = th3;
            str3 = strO;
            if (!c0.d()) {
                return null;
            }
            c0.c(f21913q, "fileName:" + str3);
            th.printStackTrace();
            return null;
        }
    }

    public final String o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = this.f21927n.matcher(str.toLowerCase());
        return matcher.find() ? matcher.group(1) : "";
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        q(str, str2, str3, str4, j10, null);
    }

    public final ActionActivity.b p() {
        return new a();
    }

    public final synchronized void q(String str, String str2, String str3, String str4, long j10, ExtraServiceImpl extraServiceImpl) {
        if (this.f21916c.get() != null && !this.f21916c.get().isFinishing()) {
            g0 g0Var = this.f21917d;
            if (g0Var == null || !g0Var.a(str, xf.e.f55218c, "download")) {
                if (extraServiceImpl == null) {
                    try {
                        extraServiceImpl = this.f21923j.clone();
                    } catch (CloneNotSupportedException e10) {
                        if (c0.d()) {
                            e10.printStackTrace();
                        }
                        c0.c(f21913q, " clone object failure !!! ");
                        return;
                    }
                }
                this.f21918e = str;
                ExtraServiceImpl extraServiceImplJ = extraServiceImpl.J(str);
                this.f21921h = str4;
                ExtraServiceImpl extraServiceImplG = extraServiceImplJ.G(str4);
                this.f21919f = str3;
                ExtraServiceImpl extraServiceImplX = extraServiceImplG.x(str3);
                this.f21920g = j10;
                ExtraServiceImpl extraServiceImplY = extraServiceImplX.y(j10);
                this.f21924k = str2;
                extraServiceImplY.K(str2);
                this.f21925l = extraServiceImpl;
                if (Build.VERSION.SDK_INT >= 23) {
                    List<String> listJ = j();
                    if (listJ.isEmpty()) {
                        s();
                    } else {
                        Action actionA = Action.a((String[]) listJ.toArray(new String[0]));
                        ActionActivity.h(p());
                        ActionActivity.i(this.f21916c.get(), actionA);
                    }
                } else {
                    s();
                }
            }
        }
    }

    public final void r(File file) {
        try {
            ExecuteTasksMap.c().a(this.f21918e, file.getAbsolutePath());
            if (this.f21922i.get() != null) {
                this.f21922i.get().p(this.f21916c.get().getString(R.string.agentweb_coming_soon_download) + ":" + file.getName(), f21913q.concat("|performDownload"));
            }
            new g().a(new DownloadTask(f21912p.incrementAndGet(), this.f21928o, this.f21914a, file, this.f21925l));
            this.f21918e = null;
            this.f21919f = null;
            this.f21920g = -1L;
            this.f21921h = null;
            this.f21924k = null;
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
        }
    }

    public final void s() {
        Intent intentS;
        d dVar = this.f21915b;
        if (dVar == null || !dVar.a(this.f21918e, this.f21924k, this.f21919f, this.f21921h, this.f21920g, this.f21925l)) {
            File fileN = n(this.f21919f, this.f21918e);
            if (fileN == null) {
                c0.a(f21913q, "新建文件失败");
                return;
            }
            if (fileN.exists()) {
                long length = fileN.length();
                long j10 = this.f21920g;
                if (length >= j10 && j10 > 0) {
                    d dVar2 = this.f21915b;
                    if ((dVar2 != null && dVar2.d(fileN.getAbsolutePath(), this.f21918e, null)) || (intentS = com.just.agentweb.a.s(this.f21914a, fileN)) == null) {
                        return;
                    }
                    try {
                        if (!(this.f21914a instanceof Activity)) {
                            intentS.addFlags(268435456);
                        }
                        this.f21914a.startActivity(intentS);
                        return;
                    } catch (Throwable th2) {
                        if (c0.d()) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
            if (ExecuteTasksMap.c().b(this.f21918e) || ExecuteTasksMap.c().b(fileN.getAbsolutePath())) {
                if (this.f21922i.get() != null) {
                    this.f21922i.get().p(this.f21916c.get().getString(R.string.agentweb_download_task_has_been_exist), f21913q.concat("|preDownload"));
                }
            } else if (this.f21925l.q() || com.just.agentweb.a.b(this.f21914a) <= 1) {
                r(fileN);
            } else {
                t(fileN);
            }
        }
    }

    public final void t(File file) {
        xf.b bVar;
        Activity activity = this.f21916c.get();
        if (activity == null || activity.isFinishing() || (bVar = this.f21922i.get()) == null) {
            return;
        }
        bVar.f(this.f21918e, l(file));
    }
}
