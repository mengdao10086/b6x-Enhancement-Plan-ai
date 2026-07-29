package com.iir_eq.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.flydigi.cyberfox.R;
import g.d0;
import g.n0;
import g.p0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class OtaConfigFragment extends DialogFragment {
    public boolean D8;
    public boolean E8;
    public boolean F8;
    public boolean G8;
    public boolean H8;
    public EditText I8;
    public EditText J8;
    public EditText K8;
    public EditText L8;
    public h M8;
    public final View.OnClickListener N8 = new a();
    public final View.OnClickListener O8 = new b();
    public final RadioGroup.OnCheckedChangeListener P8 = new c();
    public final RadioGroup.OnCheckedChangeListener Q8 = new d();
    public final RadioGroup.OnCheckedChangeListener R8 = new e();
    public final RadioGroup.OnCheckedChangeListener S8 = new f();
    public final RadioGroup.OnCheckedChangeListener T8 = new g();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (OtaConfigFragment.this.r6()) {
                OtaConfigFragment.this.I5();
                if (OtaConfigFragment.this.M8 != null) {
                    OtaConfigFragment.this.M8.z2();
                }
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OtaConfigFragment.this.I5();
            if (OtaConfigFragment.this.M8 != null) {
                OtaConfigFragment.this.M8.j2();
            }
        }
    }

    public class c implements RadioGroup.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, @d0 int i10) {
            if (i10 == R.id.clear_user_data_yes) {
                OtaConfigFragment.this.D8 = true;
            } else if (i10 == R.id.clear_user_data_no) {
                OtaConfigFragment.this.D8 = false;
            }
        }
    }

    public class d implements RadioGroup.OnCheckedChangeListener {
        public d() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, @d0 int i10) {
            if (i10 == R.id.update_bt_addr_yes) {
                OtaConfigFragment.this.E8 = true;
                OtaConfigFragment.this.I8.setEnabled(OtaConfigFragment.this.E8);
            } else if (i10 == R.id.update_bt_addr_no) {
                OtaConfigFragment.this.E8 = false;
                OtaConfigFragment.this.I8.setEnabled(OtaConfigFragment.this.E8);
            }
        }
    }

    public class e implements RadioGroup.OnCheckedChangeListener {
        public e() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, @d0 int i10) {
            if (i10 == R.id.update_bt_name_yes) {
                OtaConfigFragment.this.F8 = true;
                OtaConfigFragment.this.J8.setEnabled(OtaConfigFragment.this.F8);
            } else if (i10 == R.id.update_bt_name_no) {
                OtaConfigFragment.this.F8 = false;
                OtaConfigFragment.this.J8.setEnabled(OtaConfigFragment.this.F8);
            }
        }
    }

    public class f implements RadioGroup.OnCheckedChangeListener {
        public f() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, @d0 int i10) {
            if (i10 == R.id.update_ble_addr_yes) {
                OtaConfigFragment.this.G8 = true;
                OtaConfigFragment.this.K8.setEnabled(OtaConfigFragment.this.G8);
            } else if (i10 == R.id.update_ble_addr_no) {
                OtaConfigFragment.this.G8 = false;
                OtaConfigFragment.this.K8.setEnabled(OtaConfigFragment.this.G8);
            }
        }
    }

    public class g implements RadioGroup.OnCheckedChangeListener {
        public g() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, @d0 int i10) {
            if (i10 == R.id.update_ble_name_yes) {
                OtaConfigFragment.this.H8 = true;
                OtaConfigFragment.this.L8.setEnabled(OtaConfigFragment.this.H8);
            } else if (i10 == R.id.update_ble_name_no) {
                OtaConfigFragment.this.H8 = false;
                OtaConfigFragment.this.L8.setEnabled(OtaConfigFragment.this.H8);
            }
        }
    }

    public interface h {
        void j2();

        void z2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void H3(@k @n0 Context context) {
        super.H3(context);
        if (context instanceof h) {
            this.M8 = (h) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @p0
    public View O3(LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        L5().requestWindowFeature(1);
        View viewInflate = layoutInflater.inflate(R.layout.ota_config, viewGroup, false);
        q6(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        I5();
        h hVar = this.M8;
        if (hVar != null) {
            hVar.z2();
        }
    }

    public final void q6(View view) {
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.clear_user_data);
        androidx.fragment.app.g gVarW1 = w1();
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) wf.g.b(gVarW1, tf.a.f51266r, bool)).booleanValue();
        this.D8 = zBooleanValue;
        radioGroup.check(zBooleanValue ? R.id.clear_user_data_yes : R.id.clear_user_data_no);
        radioGroup.setOnCheckedChangeListener(this.P8);
        RadioGroup radioGroup2 = (RadioGroup) view.findViewById(R.id.update_bt_addr);
        boolean zBooleanValue2 = ((Boolean) wf.g.b(w1(), tf.a.f51267s, bool)).booleanValue();
        this.E8 = zBooleanValue2;
        radioGroup2.check(zBooleanValue2 ? R.id.update_bt_addr_yes : R.id.update_bt_addr_no);
        EditText editText = (EditText) view.findViewById(R.id.update_bt_addr_input);
        this.I8 = editText;
        editText.setEnabled(this.E8);
        this.I8.setText(wf.g.b(w1(), tf.a.f51268t, "").toString());
        radioGroup2.setOnCheckedChangeListener(this.Q8);
        RadioGroup radioGroup3 = (RadioGroup) view.findViewById(R.id.update_bt_name);
        boolean zBooleanValue3 = ((Boolean) wf.g.b(w1(), tf.a.f51269u, bool)).booleanValue();
        this.F8 = zBooleanValue3;
        radioGroup3.check(zBooleanValue3 ? R.id.update_bt_name_yes : R.id.update_bt_name_no);
        EditText editText2 = (EditText) view.findViewById(R.id.update_bt_name_input);
        this.J8 = editText2;
        editText2.setEnabled(this.F8);
        this.J8.setText(wf.g.b(w1(), tf.a.f51270v, "").toString());
        radioGroup3.setOnCheckedChangeListener(this.R8);
        RadioGroup radioGroup4 = (RadioGroup) view.findViewById(R.id.update_ble_addr);
        boolean zBooleanValue4 = ((Boolean) wf.g.b(w1(), tf.a.f51271w, bool)).booleanValue();
        this.G8 = zBooleanValue4;
        radioGroup4.check(zBooleanValue4 ? R.id.update_ble_addr_yes : R.id.update_ble_addr_no);
        EditText editText3 = (EditText) view.findViewById(R.id.update_ble_addr_input);
        this.K8 = editText3;
        editText3.setEnabled(this.G8);
        this.K8.setText(wf.g.b(w1(), tf.a.f51272x, "").toString());
        radioGroup4.setOnCheckedChangeListener(this.S8);
        RadioGroup radioGroup5 = (RadioGroup) view.findViewById(R.id.update_ble_name);
        boolean zBooleanValue5 = ((Boolean) wf.g.b(w1(), tf.a.f51273y, bool)).booleanValue();
        this.H8 = zBooleanValue5;
        radioGroup5.check(zBooleanValue5 ? R.id.update_ble_name_yes : R.id.update_ble_name_no);
        EditText editText4 = (EditText) view.findViewById(R.id.update_ble_name_input);
        this.L8 = editText4;
        editText4.setEnabled(this.H8);
        this.L8.setText(wf.g.b(w1(), tf.a.f51274z, "").toString());
        radioGroup5.setOnCheckedChangeListener(this.T8);
        view.findViewById(R.id.f14108ok).setOnClickListener(this.N8);
        view.findViewById(R.id.cancel).setOnClickListener(this.O8);
    }

    public final boolean r6() {
        if (this.E8) {
            String string = this.I8.getText().toString();
            if (!string.matches("[0-9a-fA-F]+") || string.length() != 12) {
                Toast.makeText(w1(), R.string.invalid_bt_address, 0).show();
                return false;
            }
            wf.g.d(w1(), tf.a.f51268t, string);
        }
        if (this.F8) {
            String string2 = this.J8.getText().toString();
            if (TextUtils.isEmpty(string2)) {
                Toast.makeText(w1(), R.string.invalid_bt_name, 0).show();
                return false;
            }
            wf.g.d(w1(), tf.a.f51270v, string2);
        }
        if (this.G8) {
            String string3 = this.K8.getText().toString();
            if (!string3.matches("[0-9a-fA-F]+") || string3.length() != 12) {
                Toast.makeText(w1(), R.string.invalid_ble_address, 0).show();
                return false;
            }
            wf.g.d(w1(), tf.a.f51272x, string3);
        }
        if (this.H8) {
            String string4 = this.L8.getText().toString();
            if (TextUtils.isEmpty(string4)) {
                Toast.makeText(w1(), R.string.invalid_ble_name, 0).show();
                return false;
            }
            wf.g.d(w1(), tf.a.f51274z, string4);
        }
        wf.g.d(w1(), tf.a.f51266r, Boolean.valueOf(this.D8));
        wf.g.d(w1(), tf.a.f51267s, Boolean.valueOf(this.E8));
        wf.g.d(w1(), tf.a.f51269u, Boolean.valueOf(this.F8));
        wf.g.d(w1(), tf.a.f51271w, Boolean.valueOf(this.G8));
        wf.g.d(w1(), tf.a.f51273y, Boolean.valueOf(this.H8));
        return true;
    }

    public void s6(h hVar) {
        this.M8 = hVar;
    }
}
