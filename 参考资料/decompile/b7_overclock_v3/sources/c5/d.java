package c5;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9754a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9755b = 20001;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9756c = 20002;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9757d = 20003;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9758e = 20004;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9759f = 20006;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f9760g = 20007;

    public static String a(int i10) {
        switch (i10) {
            case f9755b /* 20001 */:
                return "手机号码不合法";
            case f9756c /* 20002 */:
                return "号码已被注册";
            case f9757d /* 20003 */:
                return "短信发送失败";
            case f9758e /* 20004 */:
                return "验证码错误";
            case 20005:
            default:
                return "";
            case f9759f /* 20006 */:
                return "注册失败";
            case f9760g /* 20007 */:
                return "账号不存在";
        }
    }
}
