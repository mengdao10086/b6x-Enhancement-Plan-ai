package e6;

import android.os.Environment;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final C0307a f26659a = new C0307a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static String f26660b = "gb2312";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f26661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f26662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f26663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f26664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final String f26665g = ".local.fdg";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final String f26666h = ".cloud";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final String f26667i = ".vibrate.fdg";

    /* JADX INFO: renamed from: e6.a$a, reason: collision with other inner class name */
    public static final class C0307a {
        public C0307a() {
        }

        public /* synthetic */ C0307a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    static {
        String str = Environment.getExternalStorageDirectory().toString() + "/Android/data/com.android.motionelf";
        f26661c = str;
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString() + "/flydigi";
        f26662d = str2;
        f26663e = str + "/cfg";
        f26664f = str2 + "/cfg";
    }
}
