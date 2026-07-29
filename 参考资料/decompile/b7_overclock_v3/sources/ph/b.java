package ph;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.ui.MatisseActivity;
import g.p0;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f46672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Fragment> f46673b;

    public b(Activity activity) {
        this(activity, null);
    }

    public static b c(Activity activity) {
        return new b(activity);
    }

    public static b d(Fragment fragment) {
        return new b(fragment);
    }

    public static boolean g(Intent intent) {
        return intent.getBooleanExtra("extra_result_original_enable", false);
    }

    public static List<String> h(Intent intent) {
        return intent.getStringArrayListExtra(MatisseActivity.K7);
    }

    public static List<Uri> i(Intent intent) {
        return intent.getParcelableArrayListExtra(MatisseActivity.J7);
    }

    public c a(Set<MimeType> set) {
        return b(set, true);
    }

    public c b(Set<MimeType> set, boolean z10) {
        return new c(this, set, z10);
    }

    @p0
    public Activity e() {
        return this.f46672a.get();
    }

    @p0
    public Fragment f() {
        WeakReference<Fragment> weakReference = this.f46673b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public b(Fragment fragment) {
        this(fragment.w1(), fragment);
    }

    public b(Activity activity, Fragment fragment) {
        this.f46672a = new WeakReference<>(activity);
        this.f46673b = new WeakReference<>(fragment);
    }
}
