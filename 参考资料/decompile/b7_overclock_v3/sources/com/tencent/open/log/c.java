package com.tencent.open.log;

import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import pp.l;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f22762a = 60;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f22763b = 60;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f22764c = "OpenSDK.Client.File.Tracer";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f22765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f22766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f22767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f22768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f22769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f22770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f22771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f22772k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f22773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f22774m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f22775n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f22776o;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Tencent");
        String str = File.separator;
        sb2.append(str);
        sb2.append("msflogs");
        sb2.append(str);
        sb2.append("com");
        sb2.append(str);
        sb2.append(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT);
        sb2.append(str);
        sb2.append("mobileqq");
        sb2.append(str);
        f22765d = sb2.toString();
        f22766e = ".log";
        f22767f = l.f46971i;
        f22768g = 262144;
        f22769h = 1024;
        f22770i = 10000;
        f22771j = "debug.file.blockcount";
        f22772k = "debug.file.keepperiod";
        f22773l = "debug.file.tracelevel";
        f22774m = 24;
        f22775n = 604800000L;
        f22776o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
