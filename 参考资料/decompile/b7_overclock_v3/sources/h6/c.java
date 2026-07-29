package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ScrollView f30553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Switch f30554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f30555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f30556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final Button f30557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f30558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f30559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final RadioButton f30560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f30561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final TextView f30562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final TextView f30563k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final Button f30564l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final Button f30565m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final RadioButton f30566n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final TextView f30567o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final RadioGroup f30568p;

    public c(@n0 ScrollView scrollView, @n0 Switch r42, @n0 TextView textView, @n0 TextView textView2, @n0 Button button, @n0 TextView textView3, @n0 TextView textView4, @n0 RadioButton radioButton, @n0 TextView textView5, @n0 TextView textView6, @n0 TextView textView7, @n0 Button button2, @n0 Button button3, @n0 RadioButton radioButton2, @n0 TextView textView8, @n0 RadioGroup radioGroup) {
        this.f30553a = scrollView;
        this.f30554b = r42;
        this.f30555c = textView;
        this.f30556d = textView2;
        this.f30557e = button;
        this.f30558f = textView3;
        this.f30559g = textView4;
        this.f30560h = radioButton;
        this.f30561i = textView5;
        this.f30562j = textView6;
        this.f30563k = textView7;
        this.f30564l = button2;
        this.f30565m = button3;
        this.f30566n = radioButton2;
        this.f30567o = textView8;
        this.f30568p = radioGroup;
    }

    @n0
    public static c a(@n0 View view) {
        int i10 = R.id.ack_switch;
        Switch r52 = (Switch) j2.c.a(view, i10);
        if (r52 != null) {
            i10 = R.id.ack_title;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.address;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.connect_device_ota;
                    Button button = (Button) j2.c.a(view, i10);
                    if (button != null) {
                        i10 = R.id.current_ota_file_title;
                        TextView textView3 = (TextView) j2.c.a(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.current_version_details;
                            TextView textView4 = (TextView) j2.c.a(view, i10);
                            if (textView4 != null) {
                                i10 = R.id.fast_mod;
                                RadioButton radioButton = (RadioButton) j2.c.a(view, i10);
                                if (radioButton != null) {
                                    i10 = R.id.name;
                                    TextView textView5 = (TextView) j2.c.a(view, i10);
                                    if (textView5 != null) {
                                        i10 = R.id.ota_file;
                                        TextView textView6 = (TextView) j2.c.a(view, i10);
                                        if (textView6 != null) {
                                            i10 = R.id.ota_info;
                                            TextView textView7 = (TextView) j2.c.a(view, i10);
                                            if (textView7 != null) {
                                                i10 = R.id.pick_device;
                                                Button button2 = (Button) j2.c.a(view, i10);
                                                if (button2 != null) {
                                                    i10 = R.id.pick_ota_file;
                                                    Button button3 = (Button) j2.c.a(view, i10);
                                                    if (button3 != null) {
                                                        i10 = R.id.slow_mod;
                                                        RadioButton radioButton2 = (RadioButton) j2.c.a(view, i10);
                                                        if (radioButton2 != null) {
                                                            i10 = R.id.update_static;
                                                            TextView textView8 = (TextView) j2.c.a(view, i10);
                                                            if (textView8 != null) {
                                                                i10 = R.id.upgradechoose;
                                                                RadioGroup radioGroup = (RadioGroup) j2.c.a(view, i10);
                                                                if (radioGroup != null) {
                                                                    return new c((ScrollView) view, r52, textView, textView2, button, textView3, textView4, radioButton, textView5, textView6, textView7, button2, button3, radioButton2, textView8, radioGroup);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
    public static c c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static c d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.act_ota, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f30553a;
    }
}
