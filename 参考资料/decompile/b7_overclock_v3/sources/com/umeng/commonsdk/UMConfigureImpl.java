package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class UMConfigureImpl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f23889e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ScheduledExecutorService f23890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Context f23891g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f23885a = z.b().b(z.f23809o);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CopyOnWriteArrayList<onMessageSendListener> f23886b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f23887c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f23888d = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f23892h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Runnable f23893i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f23887c == 0 || UMConfigureImpl.f23892h >= 10) {
                    if (!UMConfigureImpl.f23888d) {
                        boolean unused = UMConfigureImpl.f23888d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f23891g);
                    }
                    if (UMConfigureImpl.f23890f != null) {
                        UMConfigureImpl.f23890f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f23890f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    public static /* synthetic */ int f() {
        int i10 = f23892h;
        f23892h = i10 + 1;
        return i10;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f23891g = context;
        try {
            if (f23887c < 1 || d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f23890f == null) {
                    ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
                    f23890f = scheduledExecutorServiceNewScheduledThreadPool;
                    scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(f23893i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        try {
            f23887c++;
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList;
        try {
            CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList2 = f23886b;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.add(onmessagesendlistener);
            }
            if (UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = f23886b) != null && copyOnWriteArrayList.size() > 0) {
                Iterator<onMessageSendListener> it2 = f23886b.iterator();
                while (it2.hasNext()) {
                    it2.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeInterruptFlag() {
        try {
            f23887c--;
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f23886b;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.remove(onmessagesendlistener);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        try {
            UMEnvelopeBuild.setTransmissionSendFlag(true);
            CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f23886b;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                Iterator<onMessageSendListener> it2 = f23886b.iterator();
                while (it2.hasNext()) {
                    it2.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f23885a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putBoolean(f23885a, true);
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f23885a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(f23885a, false);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
