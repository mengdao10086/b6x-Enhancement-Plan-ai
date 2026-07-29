package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f24251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f24252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f24253g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24254a = "10.0.0.172";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24255b = 80;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f24256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f24257d;

    public c(Context context) {
        this.f24256c = context;
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f24256c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f24256c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f24256c, "oversea_domain_p", "");
        String strImprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f24256c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(strImprintProperty3);
        }
        if (!TextUtils.isEmpty(strImprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(strImprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f24154b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f24154b.startsWith("460") || com.umeng.commonsdk.statistics.b.f24154b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (f24253g) {
            return;
        }
        ImprintHandler.getImprintService(this.f24256c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.b()) {
                    FieldManager.a().a(c.this.f24256c, str2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(c.this.f24256c, com.umeng.commonsdk.internal.a.f24051w, com.umeng.commonsdk.internal.b.a(c.this.f24256c).a(), null);
                }
            }
        });
        f24253g = true;
    }

    private void d() {
        if (f24252f) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.f24256c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f24256c);
                UMWorkDispatch.sendEvent(c.this.f24256c, com.umeng.commonsdk.internal.a.f24047s, com.umeng.commonsdk.internal.b.a(c.this.f24256c).a(), null);
                ImprintHandler.getImprintService(c.this.f24256c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f24256c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f24256c, str2);
                UMWorkDispatch.sendEvent(c.this.f24256c, com.umeng.commonsdk.internal.a.f24047s, com.umeng.commonsdk.internal.b.a(c.this.f24256c).a(), null);
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(c.this.f24256c, o.a.D, CoreProtocol.getInstance(c.this.f24256c), null, 0L);
                    }
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    l.a(c.this.f24256c).b(c.this.f24256c);
                }
                ImprintHandler.getImprintService(c.this.f24256c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f24252f = true;
    }

    public void a(b bVar) {
        this.f24257d = bVar;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f24256c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f24256c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    public byte[] a(byte[] bArr, boolean z10, boolean z11, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        int i10 = 0;
        byte[] bArrA = null;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i10 >= strArr.length) {
                break;
            }
            String str2 = strArr[i10];
            if (z11) {
                d();
            } else {
                c();
            }
            bArrA = a(bArr, str2 + File.separator + str);
            if (bArrA != null) {
                b bVar = this.f24257d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z10);
                }
            } else {
                b bVar2 = this.f24257d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i10++;
            }
        }
        return bArrA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0160: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:85:0x016c, block:B:80:0x0160 */
    public byte[] a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        try {
            try {
                b bVar = this.f24257d;
                if (bVar != null) {
                    bVar.onRequestStart();
                }
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    boolean z10 = true;
                    if (!f24251e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        f24251e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", a.a(this.f24256c).b());
                    httpsURLConnection.setRequestProperty("Content-Type", a.a(this.f24256c).a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setRequestMethod(Constants.HTTP_POST);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(bArr);
                        outputStream.flush();
                        httpsURLConnection.connect();
                        b bVar2 = this.f24257d;
                        if (bVar2 != null) {
                            bVar2.onRequestEnd();
                        }
                        int responseCode = httpsURLConnection.getResponseCode();
                        String headerField = httpsURLConnection.getHeaderField("Content-Type");
                        if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                            z10 = false;
                        }
                        boolean z11 = AnalyticsConstants.UM_DEBUG;
                        if (responseCode == 200 && z10) {
                            InputStream inputStream = httpsURLConnection.getInputStream();
                            try {
                                byte[] streamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                                try {
                                    outputStream.close();
                                } catch (Exception e10) {
                                    UMCrashManager.reportCrash(this.f24256c, e10);
                                }
                                try {
                                    httpsURLConnection.getInputStream().close();
                                } catch (IOException unused) {
                                }
                                httpsURLConnection.disconnect();
                                return streamToByteArray;
                            } finally {
                                HelperUtils.safeClose(inputStream);
                            }
                        }
                        try {
                            outputStream.close();
                        } catch (Exception e11) {
                            UMCrashManager.reportCrash(this.f24256c, e11);
                        }
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused2) {
                        }
                        httpsURLConnection.disconnect();
                        return null;
                    } catch (UnknownHostException unused3) {
                        UMLog.aq("A_10200", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e12) {
                                UMCrashManager.reportCrash(this.f24256c, e12);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused4) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    } catch (SSLHandshakeException unused5) {
                        UMLog.aq("A_10201", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e13) {
                                UMCrashManager.reportCrash(this.f24256c, e13);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused6) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable unused7) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e14) {
                                UMCrashManager.reportCrash(this.f24256c, e14);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused8) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    }
                } catch (UnknownHostException unused9) {
                    outputStream = null;
                } catch (SSLHandshakeException unused10) {
                    outputStream = null;
                } catch (Throwable unused11) {
                    outputStream = null;
                }
            } catch (Throwable th2) {
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Exception e15) {
                        UMCrashManager.reportCrash(this.f24256c, e15);
                    }
                }
                if (str == 0) {
                    throw th2;
                }
                try {
                    str.getInputStream().close();
                } catch (IOException unused12) {
                }
                str.disconnect();
                throw th2;
            }
        } catch (UnknownHostException unused13) {
            httpsURLConnection = null;
            outputStream = null;
        } catch (SSLHandshakeException unused14) {
            httpsURLConnection = null;
            outputStream = null;
        } catch (Throwable unused15) {
            httpsURLConnection = null;
            outputStream = null;
        }
    }
}
