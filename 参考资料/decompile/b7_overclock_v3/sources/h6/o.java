package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ScrollView f30668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Button f30669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final RadioGroup f30670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final RadioButton f30671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final RadioButton f30672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final Button f30673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final RadioGroup f30674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final EditText f30675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final RadioButton f30676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final RadioButton f30677j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final RadioGroup f30678k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final EditText f30679l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final RadioButton f30680m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final RadioButton f30681n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final RadioGroup f30682o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final EditText f30683p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public final RadioButton f30684q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @n0
    public final RadioButton f30685r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @n0
    public final RadioGroup f30686s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @n0
    public final EditText f30687t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @n0
    public final RadioButton f30688u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @n0
    public final RadioButton f30689v;

    public o(@n0 ScrollView scrollView, @n0 Button button, @n0 RadioGroup radioGroup, @n0 RadioButton radioButton, @n0 RadioButton radioButton2, @n0 Button button2, @n0 RadioGroup radioGroup2, @n0 EditText editText, @n0 RadioButton radioButton3, @n0 RadioButton radioButton4, @n0 RadioGroup radioGroup3, @n0 EditText editText2, @n0 RadioButton radioButton5, @n0 RadioButton radioButton6, @n0 RadioGroup radioGroup4, @n0 EditText editText3, @n0 RadioButton radioButton7, @n0 RadioButton radioButton8, @n0 RadioGroup radioGroup5, @n0 EditText editText4, @n0 RadioButton radioButton9, @n0 RadioButton radioButton10) {
        this.f30668a = scrollView;
        this.f30669b = button;
        this.f30670c = radioGroup;
        this.f30671d = radioButton;
        this.f30672e = radioButton2;
        this.f30673f = button2;
        this.f30674g = radioGroup2;
        this.f30675h = editText;
        this.f30676i = radioButton3;
        this.f30677j = radioButton4;
        this.f30678k = radioGroup3;
        this.f30679l = editText2;
        this.f30680m = radioButton5;
        this.f30681n = radioButton6;
        this.f30682o = radioGroup4;
        this.f30683p = editText3;
        this.f30684q = radioButton7;
        this.f30685r = radioButton8;
        this.f30686s = radioGroup5;
        this.f30687t = editText4;
        this.f30688u = radioButton9;
        this.f30689v = radioButton10;
    }

    @n0
    public static o a(@n0 View view) {
        int i10 = R.id.cancel;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.clear_user_data;
            RadioGroup radioGroup = (RadioGroup) j2.c.a(view, i10);
            if (radioGroup != null) {
                i10 = R.id.clear_user_data_no;
                RadioButton radioButton = (RadioButton) j2.c.a(view, i10);
                if (radioButton != null) {
                    i10 = R.id.clear_user_data_yes;
                    RadioButton radioButton2 = (RadioButton) j2.c.a(view, i10);
                    if (radioButton2 != null) {
                        i10 = R.id.f14108ok;
                        Button button2 = (Button) j2.c.a(view, i10);
                        if (button2 != null) {
                            i10 = R.id.update_ble_addr;
                            RadioGroup radioGroup2 = (RadioGroup) j2.c.a(view, i10);
                            if (radioGroup2 != null) {
                                i10 = R.id.update_ble_addr_input;
                                EditText editText = (EditText) j2.c.a(view, i10);
                                if (editText != null) {
                                    i10 = R.id.update_ble_addr_no;
                                    RadioButton radioButton3 = (RadioButton) j2.c.a(view, i10);
                                    if (radioButton3 != null) {
                                        i10 = R.id.update_ble_addr_yes;
                                        RadioButton radioButton4 = (RadioButton) j2.c.a(view, i10);
                                        if (radioButton4 != null) {
                                            i10 = R.id.update_ble_name;
                                            RadioGroup radioGroup3 = (RadioGroup) j2.c.a(view, i10);
                                            if (radioGroup3 != null) {
                                                i10 = R.id.update_ble_name_input;
                                                EditText editText2 = (EditText) j2.c.a(view, i10);
                                                if (editText2 != null) {
                                                    i10 = R.id.update_ble_name_no;
                                                    RadioButton radioButton5 = (RadioButton) j2.c.a(view, i10);
                                                    if (radioButton5 != null) {
                                                        i10 = R.id.update_ble_name_yes;
                                                        RadioButton radioButton6 = (RadioButton) j2.c.a(view, i10);
                                                        if (radioButton6 != null) {
                                                            i10 = R.id.update_bt_addr;
                                                            RadioGroup radioGroup4 = (RadioGroup) j2.c.a(view, i10);
                                                            if (radioGroup4 != null) {
                                                                i10 = R.id.update_bt_addr_input;
                                                                EditText editText3 = (EditText) j2.c.a(view, i10);
                                                                if (editText3 != null) {
                                                                    i10 = R.id.update_bt_addr_no;
                                                                    RadioButton radioButton7 = (RadioButton) j2.c.a(view, i10);
                                                                    if (radioButton7 != null) {
                                                                        i10 = R.id.update_bt_addr_yes;
                                                                        RadioButton radioButton8 = (RadioButton) j2.c.a(view, i10);
                                                                        if (radioButton8 != null) {
                                                                            i10 = R.id.update_bt_name;
                                                                            RadioGroup radioGroup5 = (RadioGroup) j2.c.a(view, i10);
                                                                            if (radioGroup5 != null) {
                                                                                i10 = R.id.update_bt_name_input;
                                                                                EditText editText4 = (EditText) j2.c.a(view, i10);
                                                                                if (editText4 != null) {
                                                                                    i10 = R.id.update_bt_name_no;
                                                                                    RadioButton radioButton9 = (RadioButton) j2.c.a(view, i10);
                                                                                    if (radioButton9 != null) {
                                                                                        i10 = R.id.update_bt_name_yes;
                                                                                        RadioButton radioButton10 = (RadioButton) j2.c.a(view, i10);
                                                                                        if (radioButton10 != null) {
                                                                                            return new o((ScrollView) view, button, radioGroup, radioButton, radioButton2, button2, radioGroup2, editText, radioButton3, radioButton4, radioGroup3, editText2, radioButton5, radioButton6, radioGroup4, editText3, radioButton7, radioButton8, radioGroup5, editText4, radioButton9, radioButton10);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static o c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static o d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.ota_config, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f30668a;
    }
}
