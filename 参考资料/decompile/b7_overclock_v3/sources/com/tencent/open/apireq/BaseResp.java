package com.tencent.open.apireq;

/* JADX INFO: loaded from: classes5.dex */
public class BaseResp {
    public static final int CODE_ERROR_PARAMS = -2000;
    public static final int CODE_NOT_LOGIN = -2001;
    public static final int CODE_QQ_LOW_VERSION = -1001;
    public static final int CODE_QQ_NOT_INSTALLED = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED_BRANCH = -1002;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22657a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22658b = "";

    public String a(int i10) {
        return "Api call failed.";
    }

    public int getCode() {
        return this.f22657a;
    }

    public String getErrorMsg() {
        return this.f22658b;
    }

    public boolean isSuccess() {
        return this.f22657a == 0;
    }

    public void setCode(int i10) {
        String strA;
        this.f22657a = i10;
        if (i10 == -2001) {
            strA = "Not login.";
        } else if (i10 == -2000) {
            strA = "The given params check failed.";
        } else if (i10 != 0) {
            switch (i10) {
                case CODE_UNSUPPORTED_BRANCH /* -1002 */:
                    strA = "The QQ branch (e.g. TIM) is not supported";
                    break;
                case CODE_QQ_LOW_VERSION /* -1001 */:
                    strA = "QQ version is too low.";
                    break;
                case -1000:
                    strA = "QQ is not installed.";
                    break;
                default:
                    strA = a(i10);
                    break;
            }
        } else {
            strA = "";
        }
        setErrorMsg(strA);
    }

    public void setErrorMsg(String str) {
        this.f22658b = str;
    }

    public String toString() {
        return "BaseResp{mCode=" + this.f22657a + ", mErrorMsg='" + this.f22658b + "'}";
    }
}
