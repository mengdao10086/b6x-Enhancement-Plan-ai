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
public final class b implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ScrollView f30544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f30545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f30546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f30547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final Button f30548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final Button f30549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f30550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f30551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f30552i;

    public b(@n0 ScrollView scrollView, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 Button button, @n0 Button button2, @n0 TextView textView4, @n0 TextView textView5, @n0 TextView textView6) {
        this.f30544a = scrollView;
        this.f30545b = textView;
        this.f30546c = textView2;
        this.f30547d = textView3;
        this.f30548e = button;
        this.f30549f = button2;
        this.f30550g = textView4;
        this.f30551h = textView5;
        this.f30552i = textView6;
    }

    @n0
    public static b a(@n0 View view) {
        int i10 = R.id.dump_log_address;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.dump_log_name;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.dump_log_ota_info;
                TextView textView3 = (TextView) j2.c.a(view, i10);
                if (textView3 != null) {
                    i10 = R.id.dump_log_pick_device;
                    Button button = (Button) j2.c.a(view, i10);
                    if (button != null) {
                        i10 = R.id.dump_log_read_fw_version;
                        Button button2 = (Button) j2.c.a(view, i10);
                        if (button2 != null) {
                            i10 = R.id.flash_content_details;
                            TextView textView4 = (TextView) j2.c.a(view, i10);
                            if (textView4 != null) {
                                i10 = R.id.fw_version_info;
                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                if (textView5 != null) {
                                    i10 = R.id.fw_version_title;
                                    TextView textView6 = (TextView) j2.c.a(view, i10);
                                    if (textView6 != null) {
                                        return new b((ScrollView) view, textView, textView2, textView3, button, button2, textView4, textView5, textView6);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static b c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static b d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.act_dumplog, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f30544a;
    }
}
