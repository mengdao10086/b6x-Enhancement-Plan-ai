package com.umeng.socialize.tracker.utils;

/* JADX INFO: loaded from: classes5.dex */
public enum a {
    UnKnownCode(5000),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(5003),
    IOException(5004),
    UnKnownHostException(5005),
    HttpError(5006),
    EmptyResponse(5007),
    ErrorResponse(5008),
    ErrorMakeRequestBody(5009);


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f24810k;

    a(int i10) {
        this.f24810k = i10;
    }

    private String b() {
        return "错误码：" + this.f24810k + " 错误信息：";
    }

    public String a() {
        if (this == UnKnownCode) {
            return b() + "--未知错误--";
        }
        if (this == Timeout) {
            return b() + "--连接超时--";
        }
        if (this == NetworkUnavailable) {
            return b() + "--网络不可用--";
        }
        if (this == SSLException) {
            return b() + "--SSL证书认证失败--";
        }
        if (this == IOException) {
            return b() + "--IO异常--";
        }
        if (this == HttpError) {
            return b() + "--服务端返回HTTP错误--";
        }
        if (this == EmptyResponse) {
            return b() + "--服务端返回数据为空--";
        }
        if (this == ErrorResponse) {
            return b() + "--服务端返回错误数据--";
        }
        if (this != ErrorMakeRequestBody) {
            return "unknown";
        }
        return b() + "--请求报文构建错误--";
    }
}
