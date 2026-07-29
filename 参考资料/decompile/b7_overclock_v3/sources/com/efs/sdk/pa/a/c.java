package com.efs.sdk.pa.a;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.pa.PA;
import com.efs.sdk.pa.PAANRListener;
import com.efs.sdk.pa.PAMsgListener;
import com.efs.sdk.pa.a.b;
import com.efs.sdk.pa.a.g;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements PA {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13143a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f13145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f13146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f13147e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f13151i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f13144b = Looper.myLooper();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f13148f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f13149g = new g();

    public c(boolean z10) {
        this.f13151i = z10;
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableDumpToFile(String str) {
        FileOutputStream fileOutputStream;
        f fVar = this.f13146d;
        if (fVar == null || str == null || str.trim().length() == 0) {
            return;
        }
        fVar.f13160c = str;
        if (fVar.f13161d == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception unused) {
            }
            try {
                fVar.f13161d = new BufferedOutputStream(fileOutputStream);
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableLog(boolean z10) {
        this.f13143a = z10;
        this.f13148f.f13137b = z10;
        this.f13149g.f13163b = z10;
        f fVar = this.f13146d;
        if (fVar != null) {
            fVar.f13159b = z10;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final int endCalFPS(String str) {
        if (!this.f13150h) {
            return -1;
        }
        b bVar = this.f13148f;
        if (str != null && str.trim().length() != 0) {
            b.a aVar = bVar.f13136a.get(str);
            if (aVar == null) {
                return 0;
            }
            View view = aVar.f13141d;
            if (view != null && aVar.f13140c != null) {
                view.getViewTreeObserver().removeOnPreDrawListener(aVar.f13140c);
            }
            bVar.f13136a.remove(str);
            int iCurrentTimeMillis = (int) (aVar.f13139b / ((System.currentTimeMillis() - aVar.f13138a) / 1000.0f));
            i = iCurrentTimeMillis > 0 ? iCurrentTimeMillis : 0;
            if (bVar.f13137b) {
                StringBuilder sb2 = new StringBuilder("key=");
                sb2.append(str);
                sb2.append(",fps=");
                sb2.append(i);
            }
        }
        return i;
    }

    @Override // com.efs.sdk.pa.PA
    public final long endCalTime(String str) {
        if (!this.f13150h) {
            return -1L;
        }
        g gVar = this.f13149g;
        long jCurrentTimeMillis = 0;
        if (str != null && str.trim().length() != 0) {
            g.a aVar = gVar.f13162a.get(str);
            if (aVar == null) {
                return 0L;
            }
            gVar.f13162a.remove(str);
            jCurrentTimeMillis = System.currentTimeMillis() - aVar.f13164a;
            if (gVar.f13163b) {
                StringBuilder sb2 = new StringBuilder("key=");
                sb2.append(str);
                sb2.append(",consumeTime=");
                sb2.append(jCurrentTimeMillis);
            }
        }
        return jCurrentTimeMillis;
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener) {
        registerPAANRListener(context, pAANRListener, 2000L);
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAMsgListener(PAMsgListener pAMsgListener) {
        if (this.f13145c == null) {
            this.f13145c = new e();
        }
        this.f13144b.setMessageLogging(this.f13145c);
        if (this.f13146d == null) {
            this.f13146d = new f();
        }
        f fVar = this.f13146d;
        fVar.f13159b = this.f13143a;
        fVar.f13158a = pAMsgListener;
        this.f13145c.f13152a.add(fVar);
    }

    @Override // com.efs.sdk.pa.PA
    public final void start() {
        if (this.f13151i || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            this.f13150h = true;
            e eVar = this.f13145c;
            if (eVar != null) {
                this.f13144b.setMessageLogging(eVar);
            }
            a aVar = this.f13147e;
            if (aVar == null || !aVar.f13123f) {
                return;
            }
            aVar.f13123f = false;
            aVar.f13124g.post(aVar.f13130m);
            aVar.f13127j = SystemClock.uptimeMillis();
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalFPS(String str, View view) {
        if (this.f13150h) {
            b bVar = this.f13148f;
            if (str == null || str.trim().length() == 0 || view == null || bVar.f13136a.get(str) != null) {
                return;
            }
            b.a aVar = new b.a((byte) 0);
            aVar.f13141d = view;
            b.a.AnonymousClass1 anonymousClass1 = new ViewTreeObserver.OnPreDrawListener() { // from class: com.efs.sdk.pa.a.b.a.1
                public AnonymousClass1() {
                }

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    a.this.f13139b++;
                    return true;
                }
            };
            aVar.f13140c = anonymousClass1;
            aVar.f13141d.getViewTreeObserver().addOnPreDrawListener(anonymousClass1);
            aVar.f13138a = System.currentTimeMillis();
            bVar.f13136a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalTime(String str) {
        if (this.f13150h) {
            g gVar = this.f13149g;
            if (str == null || str.trim().length() == 0 || gVar.f13162a.get(str) != null) {
                return;
            }
            g.a aVar = new g.a((byte) 0);
            aVar.f13164a = System.currentTimeMillis();
            gVar.f13162a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void stop() {
        this.f13150h = false;
        this.f13144b.setMessageLogging(null);
        a aVar = this.f13147e;
        if (aVar != null) {
            aVar.f13123f = true;
            aVar.f13124g.removeCallbacksAndMessages(null);
            aVar.f13118a = true;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unRegisterPAMsgListener() {
        f fVar = this.f13146d;
        if (fVar != null) {
            fVar.f13158a = null;
        }
        e eVar = this.f13145c;
        if (eVar != null) {
            eVar.f13152a.remove(fVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unregisterPAANRListener() {
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j10) {
        registerPAANRListener(context, pAANRListener, j10, Looper.getMainLooper().getThread());
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j10, Thread thread) {
        if (this.f13147e == null) {
            if (thread != null) {
                this.f13147e = new a((Application) context.getApplicationContext(), j10);
            } else {
                this.f13147e = new a((Application) context.getApplicationContext(), j10, false);
            }
        }
        this.f13147e.f13125h = pAANRListener;
    }
}
