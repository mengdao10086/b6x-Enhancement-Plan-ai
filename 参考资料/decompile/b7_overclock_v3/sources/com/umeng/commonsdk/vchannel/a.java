package com.umeng.commonsdk.vchannel;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f24434a = "https://pslog.umeng.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f24435b = "https://pslog.umeng.com/";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f24436c = "explog";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f24437d = "analytics";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f24438e = "ekv";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f24439f = "id";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f24440g = "ts";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f24441h = "ds";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f24442i = "pn";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f24443j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(String.format("%0" + (32 - str.length()) + "d", 0));
        f24443j = sb2.toString();
    }
}
