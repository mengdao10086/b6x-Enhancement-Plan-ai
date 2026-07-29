package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ScrollView f30537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f30538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f30539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f30540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f30541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final Button f30542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final Button f30543g;

    public a(@n0 ScrollView scrollView, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4, @n0 Button button, @n0 Button button2) {
        this.f30537a = scrollView;
        this.f30538b = textView;
        this.f30539c = textView2;
        this.f30540d = textView3;
        this.f30541e = textView4;
        this.f30542f = button;
        this.f30543g = button2;
    }

    @n0
    public static a a(@n0 View view) {
        int i10 = R.id.crash_content_details;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.crash_log_address;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.crash_log_name;
                TextView textView3 = (TextView) j2.c.a(view, i10);
                if (textView3 != null) {
                    i10 = R.id.crash_log_ota_info;
                    TextView textView4 = (TextView) j2.c.a(view, i10);
                    if (textView4 != null) {
                        i10 = R.id.crash_log_pick_device;
                        Button button = (Button) j2.c.a(view, i10);
                        if (button != null) {
                            i10 = R.id.crash_log_read_fw_version;
                            Button button2 = (Button) j2.c.a(view, i10);
                            if (button2 != null) {
                                return new a((ScrollView) view, textView, textView2, textView3, textView4, button, button2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static a c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static a d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.act_crashlog, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f30537a;
    }
}
