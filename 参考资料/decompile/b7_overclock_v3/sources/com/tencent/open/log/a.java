package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes5.dex */
public class a extends Tracer implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f22739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FileWriter f22740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FileWriter f22741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f22742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f22743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private char[] f22744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile f f22745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile f f22746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile f f22747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile f f22748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f22749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private HandlerThread f22750l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Handler f22751m;

    public a(b bVar) {
        this(c.f22763b, true, g.f22783a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f22750l && !this.f22749k) {
            this.f22749k = true;
            j();
            try {
                try {
                    this.f22748j.a(g(), this.f22744f);
                } catch (IOException e10) {
                    SLog.e("FileTracer", "flushBuffer exception", e10);
                }
                this.f22749k = false;
            } finally {
                this.f22748j.b();
            }
        }
    }

    private Writer[] g() {
        File[] fileArrA = c().a();
        if (fileArrA != null && fileArrA.length >= 2) {
            File file = fileArrA[0];
            if ((file != null && !file.equals(this.f22742d)) || (this.f22740b == null && file != null)) {
                this.f22742d = file;
                h();
                try {
                    this.f22740b = new FileWriter(this.f22742d, true);
                } catch (IOException unused) {
                    this.f22740b = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                }
            }
            File file2 = fileArrA[1];
            if ((file2 != null && !file2.equals(this.f22743e)) || (this.f22741c == null && file2 != null)) {
                this.f22743e = file2;
                i();
                try {
                    this.f22741c = new FileWriter(this.f22743e, true);
                } catch (IOException unused2) {
                    this.f22741c = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                }
            }
        }
        return new Writer[]{this.f22740b, this.f22741c};
    }

    private void h() {
        try {
            FileWriter fileWriter = this.f22740b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f22740b.close();
            }
        } catch (IOException e10) {
            SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e10);
        }
    }

    private void i() {
        try {
            FileWriter fileWriter = this.f22741c;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f22741c.close();
            }
        } catch (IOException e10) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e10);
        }
    }

    private void j() {
        synchronized (this) {
            if (this.f22747i == this.f22745g) {
                this.f22747i = this.f22746h;
                this.f22748j = this.f22745g;
            } else {
                this.f22747i = this.f22745g;
                this.f22748j = this.f22746h;
            }
        }
    }

    public void a() {
        if (this.f22751m.hasMessages(1024)) {
            this.f22751m.removeMessages(1024);
        }
        this.f22751m.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        i();
        this.f22750l.quit();
    }

    public b c() {
        return this.f22739a;
    }

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int i10, Thread thread, long j10, String str, String str2, Throwable th2) {
        a(e().a(i10, thread, j10, str, str2, th2));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i10, boolean z10, g gVar, b bVar) {
        super(i10, z10, gVar);
        this.f22749k = false;
        a(bVar);
        this.f22745g = new f();
        this.f22746h = new f();
        this.f22747i = this.f22745g;
        this.f22748j = this.f22746h;
        this.f22744f = new char[bVar.d()];
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.f22750l = handlerThread;
        handlerThread.start();
        if (!this.f22750l.isAlive() || this.f22750l.getLooper() == null) {
            return;
        }
        this.f22751m = new Handler(this.f22750l.getLooper(), this);
    }

    private void a(String str) {
        this.f22747i.a(str);
        if (this.f22747i.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f22739a = bVar;
    }
}
