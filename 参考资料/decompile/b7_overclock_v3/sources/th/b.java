package th;

import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.g;
import com.zhihu.matisse.internal.ui.widget.IncapableDialog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f51286d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f51287e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f51288f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f51289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f51290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f51291c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public b(String str) {
        this.f51289a = 0;
        this.f51291c = str;
    }

    public static void a(Context context, b bVar) {
        if (bVar == null) {
            return;
        }
        int i10 = bVar.f51289a;
        if (i10 == 1) {
            IncapableDialog.b6(bVar.f51290b, bVar.f51291c).Z5(((g) context).n3(), IncapableDialog.class.getName());
        } else if (i10 != 2) {
            Toast.makeText(context, bVar.f51291c, 0).show();
        }
    }

    public b(String str, String str2) {
        this.f51289a = 0;
        this.f51290b = str;
        this.f51291c = str2;
    }

    public b(int i10, String str) {
        this.f51289a = i10;
        this.f51291c = str;
    }

    public b(int i10, String str, String str2) {
        this.f51289a = i10;
        this.f51290b = str;
        this.f51291c = str2;
    }
}
