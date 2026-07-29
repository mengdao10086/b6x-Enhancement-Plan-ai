package com.efs.sdk.pa;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.pa.config.ConfigManager;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class PAFactory {
    private static final long DEFAULT_TIME_OUT_TIME = 2000;
    private static final long INVALID_TIME_OUT_TIME = 0;
    private static final long MAX_TIME_OUT_TIME = 4000;
    private static final String TAG = "pafactory";
    public static final ThreadLocal<PA> sThreadLocal = new ThreadLocal<>();
    private ConfigManager mConfigManager;
    private Context mContext;
    private HashMap<String, String> mExtend;
    private EfsReporter mReporter;
    private IEfsReporter mReporterFactory;
    private String mSerial;
    private String mSver;
    private long mTimeOutTime;
    private PATraceListener mTraceListener;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PackageLevel f13107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IEfsReporter f13108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f13110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f13111e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private HashMap<String, String> f13112f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f13113g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f13114h = 2000;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private PATraceListener f13115i;

        public Builder(Context context, IEfsReporter iEfsReporter) {
            if (context == null) {
                throw new RuntimeException("context Should Not null");
            }
            if (iEfsReporter == null) {
                throw new RuntimeException("reporter Should Not Empty");
            }
            this.f13108b = iEfsReporter;
            this.f13110d = context;
        }

        public PAFactory build() {
            if (this.f13107a != null) {
                return new PAFactory(this.f13110d, this.f13107a, this.f13108b, this.f13109c, this.f13111e, this.f13112f, this.f13113g, this.f13114h, this.f13115i);
            }
            throw new RuntimeException(String.format("%s Should Not Null", ""));
        }

        public Builder extendLogInfo(HashMap<String, String> map) {
            this.f13112f = map;
            return this;
        }

        public Builder isNewInstall(boolean z10) {
            this.f13109c = z10;
            return this;
        }

        public Builder packageLevel(PackageLevel packageLevel) {
            this.f13107a = packageLevel;
            return this;
        }

        public Builder serial(String str) {
            this.f13111e = str;
            return this;
        }

        public Builder sver(String str) {
            this.f13113g = str;
            return this;
        }

        public Builder timeoutTime(long j10) {
            if (j10 <= 0) {
                this.f13114h = 2000L;
            } else {
                if (j10 > 4000) {
                    this.f13114h = 2000L;
                    return this;
                }
                this.f13114h = j10;
            }
            return this;
        }

        public Builder traceListener(PATraceListener pATraceListener) {
            this.f13115i = pATraceListener;
            return this;
        }
    }

    public ConfigManager getConfigManager() {
        return this.mConfigManager;
    }

    public Context getContext() {
        return this.mContext;
    }

    public HashMap<String, String> getExtend() {
        return this.mExtend;
    }

    public synchronized PA getPaInstance() {
        PA cVar;
        ThreadLocal<PA> threadLocal = sThreadLocal;
        cVar = threadLocal.get();
        if (cVar == null) {
            cVar = new com.efs.sdk.pa.a.c(this.mConfigManager.enableTracer());
            cVar.registerPAANRListener(this.mContext, new a(this), this.mTimeOutTime);
            threadLocal.set(cVar);
        }
        return cVar;
    }

    public EfsReporter getReporter() {
        if (this.mReporter == null) {
            IEfsReporter iEfsReporter = this.mReporterFactory;
            this.mReporter = iEfsReporter != null ? iEfsReporter.getReporter() : null;
        }
        return this.mReporter;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public String getSver() {
        return this.mSver;
    }

    public PATraceListener getTraceListener() {
        return this.mTraceListener;
    }

    private PAFactory(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z10, String str, HashMap<String, String> map, String str2, long j10, PATraceListener pATraceListener) {
        this.mReporterFactory = iEfsReporter;
        this.mSerial = str;
        this.mExtend = map;
        this.mSver = str2;
        this.mContext = context;
        this.mTraceListener = pATraceListener;
        this.mTimeOutTime = j10;
        this.mConfigManager = new ConfigManager(context, packageLevel, iEfsReporter, z10);
    }
}
