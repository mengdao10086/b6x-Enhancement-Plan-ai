package k6;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes7.dex */
public class i extends k6.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f37040l = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f37041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f37042k;

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {

        /* JADX INFO: renamed from: c3, reason: collision with root package name */
        public static final int f37043c3 = 65;

        /* JADX INFO: renamed from: d3, reason: collision with root package name */
        public static final int f37044d3 = 66;

        /* JADX INFO: renamed from: e3, reason: collision with root package name */
        public static final int f37045e3 = 67;

        /* JADX INFO: renamed from: f3, reason: collision with root package name */
        public static final int f37046f3 = 68;

        /* JADX INFO: renamed from: g3, reason: collision with root package name */
        public static final int f37047g3 = 69;

        /* JADX INFO: renamed from: h3, reason: collision with root package name */
        public static final int f37048h3 = 70;

        /* JADX INFO: renamed from: i3, reason: collision with root package name */
        public static final int f37049i3 = 76;

        /* JADX INFO: renamed from: j3, reason: collision with root package name */
        public static final int f37050j3 = 75;
    }

    public interface b {
        boolean a(byte[] bArr);

        void b();
    }

    public i(b bVar, int i10) {
        super(i10);
        this.f37041j = "RemoteGaiaManager";
        this.f37042k = bVar;
    }

    public void E(int i10) {
        l(D(gg.b.N0, new byte[]{(byte) i10}));
    }

    @Override // gg.c
    public void o(hg.a aVar) {
    }

    @Override // gg.c
    public boolean p(hg.a aVar) {
        return false;
    }

    @Override // gg.c
    public void r(hg.a aVar) {
    }

    @Override // gg.c
    public void t(hg.a aVar) {
        aVar.e();
    }

    @Override // gg.c
    public void u(hg.a aVar) {
        this.f37042k.b();
    }

    @Override // gg.c
    public boolean y(byte[] bArr) {
        return this.f37042k.a(bArr);
    }
}
