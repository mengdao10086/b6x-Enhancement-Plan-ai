package p0;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.os.f;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import g.y0;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f46295a;

    /* JADX INFO: renamed from: p0.a$a, reason: collision with other inner class name */
    public class C0518a extends FingerprintManager.AuthenticationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f46296a;

        public C0518a(c cVar) {
            this.f46296a = cVar;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i10, CharSequence charSequence) {
            this.f46296a.a(i10, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.f46296a.b();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i10, CharSequence charSequence) {
            this.f46296a.c(i10, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.f46296a.d(new d(a.f(b.b(authenticationResult))));
        }
    }

    @v0(23)
    public static class b {
        @u
        @y0("android.permission.USE_FINGERPRINT")
        public static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i10, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i10, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        @u
        public static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        @u
        public static FingerprintManager c(Context context) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 == 23) {
                return (FingerprintManager) context.getSystemService(FingerprintManager.class);
            }
            if (i10 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return null;
            }
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }

        @u
        @y0("android.permission.USE_FINGERPRINT")
        public static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        @u
        @y0("android.permission.USE_FINGERPRINT")
        public static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        @u
        public static e f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new e(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new e(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new e(cryptoObject.getMac());
            }
            return null;
        }

        @u
        public static FingerprintManager.CryptoObject g(e eVar) {
            if (eVar == null) {
                return null;
            }
            if (eVar.a() != null) {
                return new FingerprintManager.CryptoObject(eVar.a());
            }
            if (eVar.c() != null) {
                return new FingerprintManager.CryptoObject(eVar.c());
            }
            if (eVar.b() != null) {
                return new FingerprintManager.CryptoObject(eVar.b());
            }
            return null;
        }
    }

    public static abstract class c {
        public void a(int i10, CharSequence charSequence) {
        }

        public void b() {
        }

        public void c(int i10, CharSequence charSequence) {
        }

        public void d(d dVar) {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f46297a;

        public d(e eVar) {
            this.f46297a = eVar;
        }

        public e a() {
            return this.f46297a;
        }
    }

    public a(Context context) {
        this.f46295a = context;
    }

    @n0
    public static a b(@n0 Context context) {
        return new a(context);
    }

    @p0
    @v0(23)
    public static FingerprintManager c(@n0 Context context) {
        return b.c(context);
    }

    @v0(23)
    public static e f(FingerprintManager.CryptoObject cryptoObject) {
        return b.f(cryptoObject);
    }

    @v0(23)
    public static FingerprintManager.AuthenticationCallback g(c cVar) {
        return new C0518a(cVar);
    }

    @v0(23)
    public static FingerprintManager.CryptoObject h(e eVar) {
        return b.g(eVar);
    }

    @y0("android.permission.USE_FINGERPRINT")
    public void a(@p0 e eVar, int i10, @p0 f fVar, @n0 c cVar, @p0 Handler handler) {
        FingerprintManager fingerprintManagerC;
        if (Build.VERSION.SDK_INT < 23 || (fingerprintManagerC = c(this.f46295a)) == null) {
            return;
        }
        b.a(fingerprintManagerC, h(eVar), fVar != null ? (CancellationSignal) fVar.b() : null, i10, g(cVar), handler);
    }

    @y0("android.permission.USE_FINGERPRINT")
    public boolean d() {
        FingerprintManager fingerprintManagerC;
        return Build.VERSION.SDK_INT >= 23 && (fingerprintManagerC = c(this.f46295a)) != null && b.d(fingerprintManagerC);
    }

    @y0("android.permission.USE_FINGERPRINT")
    public boolean e() {
        FingerprintManager fingerprintManagerC;
        return Build.VERSION.SDK_INT >= 23 && (fingerprintManagerC = c(this.f46295a)) != null && b.e(fingerprintManagerC);
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Signature f46298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Cipher f46299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Mac f46300c;

        public e(@n0 Signature signature) {
            this.f46298a = signature;
            this.f46299b = null;
            this.f46300c = null;
        }

        @p0
        public Cipher a() {
            return this.f46299b;
        }

        @p0
        public Mac b() {
            return this.f46300c;
        }

        @p0
        public Signature c() {
            return this.f46298a;
        }

        public e(@n0 Cipher cipher) {
            this.f46299b = cipher;
            this.f46298a = null;
            this.f46300c = null;
        }

        public e(@n0 Mac mac) {
            this.f46300c = mac;
            this.f46299b = null;
            this.f46298a = null;
        }
    }
}
