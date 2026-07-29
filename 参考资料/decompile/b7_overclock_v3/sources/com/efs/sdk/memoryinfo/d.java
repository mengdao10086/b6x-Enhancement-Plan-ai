package com.efs.sdk.memoryinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.observer.IConfigCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
final class d implements UMMemoryMonitorApi {
    private boolean A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f13020u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f13021v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private b f13022w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private WeakReference<Activity> f13023x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f13024y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f13025z;

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final String getCurrentActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f13023x;
        return (weakReference == null || (activity = weakReference.get()) == null) ? "" : activity.getClass().getName();
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isEnable() {
        b bVar;
        return this.f13021v && (bVar = this.f13022w) != null && bVar.f12997b;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isForeground() {
        return this.f13024y;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityResumed(Activity activity) {
        if (this.f13021v) {
            this.f13023x = new WeakReference<>(activity);
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStarted(Activity activity) {
        if (this.f13021v && activity != null) {
            if (this.A) {
                this.A = false;
                return;
            }
            int i10 = this.f13025z + 1;
            this.f13025z = i10;
            if (i10 == 1) {
                this.f13024y = true;
            }
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStopped(Activity activity) {
        if (this.f13021v && activity != null) {
            if (activity.isChangingConfigurations()) {
                this.A = true;
                return;
            }
            int i10 = this.f13025z - 1;
            this.f13025z = i10;
            if (i10 == 0) {
                this.f13024y = false;
            }
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void setEnable(boolean z10) {
        this.f13021v = z10;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void start(Context context, EfsReporter efsReporter) {
        if ((this.f13021v || IntegrationTestingUtil.isIntegrationTestingInPeriod()) && !this.f13020u) {
            this.f13020u = true;
            final b bVar = new b(context, efsReporter);
            this.f13022w = bVar;
            bVar.f12996a.getAllSdkConfig(new String[]{"apm_memperf_sampling_rate", "apm_memperf_collect_interval", "apm_memperf_collect_max_period_sec"}, new IConfigCallback() { // from class: com.efs.sdk.memoryinfo.b.1

                /* JADX INFO: renamed from: com.efs.sdk.memoryinfo.b$1$1 */
                public class HandlerC01271 extends Handler {

                    /* JADX INFO: renamed from: d */
                    public final /* synthetic */ HandlerThread f12999d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public HandlerC01271(Looper looper, HandlerThread handlerThread) {
                        super(looper);
                        handlerThread = handlerThread;
                    }

                    @Override // android.os.Handler
                    public final void handleMessage(Message message) {
                        super.handleMessage(message);
                        if (message.what == 1) {
                            try {
                                handlerThread.quit();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }

                /* JADX INFO: renamed from: com.efs.sdk.memoryinfo.b$1$2 */
                public class AnonymousClass2 implements Runnable {

                    /* JADX INFO: renamed from: f */
                    public final /* synthetic */ Handler f13002f;

                    /* JADX INFO: renamed from: g */
                    public final /* synthetic */ int f13003g;

                    /* JADX INFO: renamed from: h */
                    public final /* synthetic */ int f13004h;

                    public AnonymousClass2(Handler handler, int i10, int i11) {
                        handler = handler;
                        i = i10;
                        i = i11;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            String string = UUID.randomUUID().toString();
                            String lowerCase = UMUtils.MD5(Process.myPid() + string).toLowerCase();
                            b bVar = b.this;
                            Handler handler = handler;
                            handler.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.2

                                /* JADX INFO: renamed from: f */
                                public final /* synthetic */ Handler f13006f;

                                /* JADX INFO: renamed from: i */
                                public final /* synthetic */ long f13007i;

                                /* JADX INFO: renamed from: j */
                                public final /* synthetic */ int f13008j;

                                /* JADX INFO: renamed from: k */
                                public final /* synthetic */ e f13009k;

                                /* JADX INFO: renamed from: l */
                                public final /* synthetic */ String f13010l;

                                /* JADX INFO: renamed from: m */
                                public final /* synthetic */ int f13011m;

                                public AnonymousClass2(long j10, int i10, Handler handler2, e eVar, String lowerCase2, int i11) {
                                    j = j10;
                                    i = i10;
                                    handler = handler2;
                                    eVar = eVar;
                                    str = lowerCase2;
                                    i = i11;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (SystemClock.elapsedRealtime() - j > i * 1000) {
                                        handler.sendEmptyMessage(1);
                                        return;
                                    }
                                    try {
                                        b.a(b.this, eVar, str);
                                    } catch (Throwable th2) {
                                        f.a("collect ", th2);
                                    }
                                    handler.postDelayed(this, i * 1000);
                                }
                            });
                        } catch (Throwable unused) {
                            handler.sendEmptyMessage(1);
                        }
                    }
                }

                public AnonymousClass1() {
                }

                @Override // com.efs.sdk.base.observer.IConfigCallback
                public final void onChange(Map<String, Object> map) {
                    Object obj;
                    Object obj2;
                    Object obj3;
                    try {
                        if (b.this.f12997b || (obj = map.get("apm_memperf_sampling_rate")) == null) {
                            return;
                        }
                        int i10 = Integer.parseInt(obj.toString());
                        if ((!(i10 != 0 && (i10 == 100 || new Random().nextInt(100) <= i10)) && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) || (obj2 = map.get("apm_memperf_collect_interval")) == null || (obj3 = map.get("apm_memperf_collect_max_period_sec")) == null) {
                            return;
                        }
                        int i11 = Integer.parseInt(obj2.toString());
                        int i12 = Integer.parseInt(obj3.toString());
                        HandlerThread handlerThread = new HandlerThread("mem-info");
                        handlerThread.start();
                        HandlerC01271 handlerC01271 = new Handler(handlerThread.getLooper()) { // from class: com.efs.sdk.memoryinfo.b.1.1

                            /* JADX INFO: renamed from: d */
                            public final /* synthetic */ HandlerThread f12999d;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public HandlerC01271(Looper looper, HandlerThread handlerThread2) {
                                super(looper);
                                handlerThread = handlerThread2;
                            }

                            @Override // android.os.Handler
                            public final void handleMessage(Message message) {
                                super.handleMessage(message);
                                if (message.what == 1) {
                                    try {
                                        handlerThread.quit();
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        };
                        handlerC01271.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.1.2

                            /* JADX INFO: renamed from: f */
                            public final /* synthetic */ Handler f13002f;

                            /* JADX INFO: renamed from: g */
                            public final /* synthetic */ int f13003g;

                            /* JADX INFO: renamed from: h */
                            public final /* synthetic */ int f13004h;

                            public AnonymousClass2(Handler handlerC012712, int i112, int i122) {
                                handler = handlerC012712;
                                i = i112;
                                i = i122;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    String string = UUID.randomUUID().toString();
                                    String lowerCase2 = UMUtils.MD5(Process.myPid() + string).toLowerCase();
                                    b bVar2 = b.this;
                                    Handler handler2 = handler;
                                    handler2.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.2

                                        /* JADX INFO: renamed from: f */
                                        public final /* synthetic */ Handler f13006f;

                                        /* JADX INFO: renamed from: i */
                                        public final /* synthetic */ long f13007i;

                                        /* JADX INFO: renamed from: j */
                                        public final /* synthetic */ int f13008j;

                                        /* JADX INFO: renamed from: k */
                                        public final /* synthetic */ e f13009k;

                                        /* JADX INFO: renamed from: l */
                                        public final /* synthetic */ String f13010l;

                                        /* JADX INFO: renamed from: m */
                                        public final /* synthetic */ int f13011m;

                                        public AnonymousClass2(long j10, int i102, Handler handler22, e eVar, String lowerCase22, int i112) {
                                            j = j10;
                                            i = i102;
                                            handler = handler22;
                                            eVar = eVar;
                                            str = lowerCase22;
                                            i = i112;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            if (SystemClock.elapsedRealtime() - j > i * 1000) {
                                                handler.sendEmptyMessage(1);
                                                return;
                                            }
                                            try {
                                                b.a(b.this, eVar, str);
                                            } catch (Throwable th2) {
                                                f.a("collect ", th2);
                                            }
                                            handler.postDelayed(this, i * 1000);
                                        }
                                    });
                                } catch (Throwable unused) {
                                    handler.sendEmptyMessage(1);
                                }
                            }
                        });
                        b.this.f12997b = true;
                    } catch (Throwable th2) {
                        f.a("collect ", th2);
                    }
                }
            });
        }
    }
}
