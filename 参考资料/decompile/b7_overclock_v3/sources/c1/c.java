package c1;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.j;
import androidx.core.util.o;
import androidx.core.view.e;
import androidx.core.view.u0;
import g.n0;
import g.p0;
import g.u;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9672a = "InputConnectionCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9673b = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9674c = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9675d = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9676e = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9677f = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9678g = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9679h = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9680i = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9681j = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9682k = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9683l = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9684m = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9685n = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9686o = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f9687p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f9688q = "androidx.core.view.extra.INPUT_CONTENT_INFO";

    public class a extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f9689a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InputConnection inputConnection, boolean z10, d dVar) {
            super(inputConnection, z10);
            this.f9689a = dVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i10, Bundle bundle) {
            if (this.f9689a.a(c1.d.g(inputContentInfo), i10, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i10, bundle);
        }
    }

    public class b extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f9690a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InputConnection inputConnection, boolean z10, d dVar) {
            super(inputConnection, z10);
            this.f9690a = dVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) {
            if (c.f(str, bundle, this.f9690a)) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    /* JADX INFO: renamed from: c1.c$c, reason: collision with other inner class name */
    @v0(25)
    public static class C0106c {
        @u
        public static boolean a(InputConnection inputConnection, InputContentInfo inputContentInfo, int i10, Bundle bundle) {
            return inputConnection.commitContent(inputContentInfo, i10, bundle);
        }
    }

    public interface d {
        boolean a(@n0 c1.d dVar, int i10, @p0 Bundle bundle);
    }

    @Deprecated
    public c() {
    }

    public static boolean b(@n0 InputConnection inputConnection, @n0 EditorInfo editorInfo, @n0 c1.d dVar, int i10, @p0 Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25) {
            return C0106c.a(inputConnection, (InputContentInfo) dVar.f(), i10, bundle);
        }
        int iE = c1.a.e(editorInfo);
        boolean z10 = false;
        if (iE == 2) {
            z10 = true;
        } else if (iE != 3 && iE != 4) {
            return false;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(z10 ? f9676e : f9675d, dVar.a());
        bundle2.putParcelable(z10 ? f9678g : f9677f, dVar.b());
        bundle2.putParcelable(z10 ? f9680i : f9679h, dVar.c());
        bundle2.putInt(z10 ? f9684m : f9683l, i10);
        bundle2.putParcelable(z10 ? f9682k : f9681j, bundle);
        return inputConnection.performPrivateCommand(z10 ? f9674c : f9673b, bundle2);
    }

    @n0
    public static d c(@n0 final View view) {
        o.l(view);
        return new d() { // from class: c1.b
            @Override // c1.c.d
            public final boolean a(d dVar, int i10, Bundle bundle) {
                return c.g(view, dVar, i10, bundle);
            }
        };
    }

    @n0
    public static InputConnection d(@n0 View view, @n0 InputConnection inputConnection, @n0 EditorInfo editorInfo) {
        return e(inputConnection, editorInfo, c(view));
    }

    @n0
    @Deprecated
    public static InputConnection e(@n0 InputConnection inputConnection, @n0 EditorInfo editorInfo, @n0 d dVar) {
        j.e(inputConnection, "inputConnection must be non-null");
        j.e(editorInfo, "editorInfo must be non-null");
        j.e(dVar, "onCommitContentListener must be non-null");
        return Build.VERSION.SDK_INT >= 25 ? new a(inputConnection, false, dVar) : c1.a.a(editorInfo).length == 0 ? inputConnection : new b(inputConnection, false, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static boolean f(@p0 String str, @p0 Bundle bundle, @n0 d dVar) throws Throwable {
        boolean z10;
        ResultReceiver resultReceiver;
        ?? A = 0;
        A = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals(f9673b, str)) {
            z10 = false;
        } else {
            if (!TextUtils.equals(f9674c, str)) {
                return false;
            }
            z10 = true;
        }
        try {
            resultReceiver = (ResultReceiver) bundle.getParcelable(z10 ? f9686o : f9685n);
            try {
                Uri uri = (Uri) bundle.getParcelable(z10 ? f9676e : f9675d);
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z10 ? f9678g : f9677f);
                Uri uri2 = (Uri) bundle.getParcelable(z10 ? f9680i : f9679h);
                int i10 = bundle.getInt(z10 ? f9684m : f9683l);
                Bundle bundle2 = (Bundle) bundle.getParcelable(z10 ? f9682k : f9681j);
                if (uri != null && clipDescription != null) {
                    A = dVar.a(new c1.d(uri, clipDescription, uri2), i10, bundle2);
                }
                if (resultReceiver != 0) {
                    resultReceiver.send(A, null);
                }
                return A;
            } catch (Throwable th2) {
                th = th2;
                if (resultReceiver != 0) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            resultReceiver = 0;
        }
    }

    public static /* synthetic */ boolean g(View view, c1.d dVar, int i10, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i10 & 1) != 0) {
            try {
                dVar.e();
                InputContentInfo inputContentInfo = (InputContentInfo) dVar.f();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable(f9688q, inputContentInfo);
            } catch (Exception unused) {
                return false;
            }
        }
        return u0.m1(view, new e.b(new ClipData(dVar.b(), new ClipData.Item(dVar.a())), 2).e(dVar.c()).c(bundle).a()) == null;
    }
}
