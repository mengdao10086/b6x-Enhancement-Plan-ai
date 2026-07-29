package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ICrashClient f23028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f23029b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f23030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f23031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f23032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f23033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f23034g = new Object();

    public static void a(ICrashClient iCrashClient) {
        f23028a = iCrashClient;
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (f23031d == null) {
            synchronized (f23034g) {
                if (f23031d == null) {
                    f23031d = new ArrayList();
                }
            }
        }
        synchronized (f23031d) {
            if (f23031d.size() >= f23029b) {
                return false;
            }
            f23031d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (f23032e == null) {
            synchronized (f23034g) {
                if (f23032e == null) {
                    f23032e = new ArrayList();
                }
            }
        }
        synchronized (f23032e) {
            if (f23032e.size() >= f23029b) {
                return false;
            }
            f23032e.add(valueCallback);
            return true;
        }
    }

    public static boolean d(ValueCallback<Bundle> valueCallback) {
        if (f23033f == null) {
            synchronized (f23034g) {
                if (f23033f == null) {
                    f23033f = new ArrayList();
                }
            }
        }
        synchronized (f23033f) {
            if (f23033f.size() >= f23029b) {
                return false;
            }
            f23033f.add(valueCallback);
            return true;
        }
    }

    public static void a(String str, String str2, String str3) {
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "onLogGenerated file name is null!", null);
            return;
        }
        boolean zEquals = e.h().equals(str2);
        if (f23028a != null) {
            File file = new File(str);
            try {
                if (zEquals) {
                    f23028a.onLogGenerated(file, str3);
                } else {
                    f23028a.onClientProcessLogGenerated(str2, file, str3);
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        List<ValueCallback<Bundle>> list = f23030c;
        if (!zEquals) {
            list = f23031d;
        }
        if (list != null) {
            synchronized (list) {
                for (ValueCallback<Bundle> valueCallback : list) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("filePathName", str);
                        if (!zEquals) {
                            bundle.putString("processName", str2);
                        }
                        bundle.putString("logType", str3);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th3) {
                        com.uc.crashsdk.a.g.a(th3);
                    }
                }
            }
        }
    }

    public static File a(File file) {
        ICrashClient iCrashClient = f23028a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        return file;
    }

    public static void a(boolean z10) {
        ICrashClient iCrashClient = f23028a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z10);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        if (f23032e != null) {
            synchronized (f23032e) {
                for (ValueCallback<Bundle> valueCallback : f23032e) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isJava", z10);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th3) {
                        com.uc.crashsdk.a.g.a(th3);
                    }
                }
            }
        }
    }

    public static void a(String str, int i10, int i11) {
        ICrashClient iCrashClient = f23028a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i10, i11);
        }
        if (f23033f != null) {
            synchronized (f23033f) {
                for (ValueCallback<Bundle> valueCallback : f23033f) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("processName", str);
                        bundle.putInt("key", i10);
                        bundle.putInt(uh.a.C, i11);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static String a(String str, boolean z10) {
        ICrashClient iCrashClient = f23028a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z10) : "";
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (f23030c == null) {
            synchronized (f23034g) {
                if (f23030c == null) {
                    f23030c = new ArrayList();
                }
            }
        }
        synchronized (f23030c) {
            if (f23030c.size() >= f23029b) {
                return false;
            }
            f23030c.add(valueCallback);
            return true;
        }
    }
}
