package com.iir_eq.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.flydigi.cyberfox.R;
import g.p0;
import wf.g;

/* JADX INFO: loaded from: classes7.dex */
public class OtaDaulPickFileFragment extends DialogFragment implements View.OnClickListener {
    public static final int N8 = 3;
    public static final int O8 = 4;
    public static final String P8 = "ota_file_daul_both_one";
    public static final String Q8 = "ota_file_daul_both_two_left_file";
    public static final String R8 = "ota_file_daul_both_two_right_file";
    public c D8;
    public int E8;
    public TextView F8;
    public TextView G8;
    public Button H8;
    public TextView I8;
    public TextView J8;
    public Button K8;
    public final View.OnClickListener L8 = new a();
    public final View.OnClickListener M8 = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (OtaDaulPickFileFragment.this.h6()) {
                OtaDaulPickFileFragment.this.I5();
                if (OtaDaulPickFileFragment.this.D8 != null) {
                    OtaDaulPickFileFragment.this.D8.b();
                }
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OtaDaulPickFileFragment.this.I5();
            if (OtaDaulPickFileFragment.this.D8 != null) {
                OtaDaulPickFileFragment.this.D8.a();
            }
        }
    }

    public interface c {
        void a();

        void b();
    }

    @Override // androidx.fragment.app.Fragment
    public void F3(int i10, int i11, Intent intent) {
        super.F3(i10, i11, intent);
        if (i10 == 3) {
            e6(i11, intent);
        } else if (i10 == 4) {
            f6(i11, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @p0
    public View O3(LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        L5().requestWindowFeature(1);
        View viewInflate = layoutInflater.inflate(R.layout.ota_daul_pick_file, viewGroup, false);
        this.E8 = T1().getInt("apply_type", 0);
        d6(viewInflate);
        return viewInflate;
    }

    public final void d6(View view) {
        this.F8 = (TextView) view.findViewById(R.id.dual_pick_file_left_title);
        this.I8 = (TextView) view.findViewById(R.id.dual_pick_file_right_title);
        this.G8 = (TextView) view.findViewById(R.id.ota_file_left);
        this.J8 = (TextView) view.findViewById(R.id.ota_file_right);
        this.H8 = (Button) view.findViewById(R.id.pick_ota_file_left);
        this.K8 = (Button) view.findViewById(R.id.pick_ota_file_right);
        this.H8.setOnClickListener(this);
        this.K8.setOnClickListener(this);
        int i10 = this.E8;
        if (i10 == 0) {
            this.F8.setVisibility(0);
            this.G8.setVisibility(0);
            this.H8.setVisibility(0);
            this.I8.setVisibility(8);
            this.J8.setVisibility(8);
            this.K8.setVisibility(8);
        } else if (i10 == 1) {
            this.F8.setVisibility(8);
            this.G8.setVisibility(8);
            this.H8.setVisibility(8);
            this.I8.setVisibility(0);
            this.J8.setVisibility(0);
            this.K8.setVisibility(0);
        } else if (i10 == 2) {
            this.F8.setVisibility(0);
            this.G8.setVisibility(0);
            this.H8.setVisibility(0);
            this.I8.setVisibility(8);
            this.J8.setVisibility(8);
            this.K8.setVisibility(8);
            this.F8.setText(c3(R.string.pick_ota_file));
        } else if (i10 == 3) {
            this.F8.setVisibility(0);
            this.G8.setVisibility(0);
            this.H8.setVisibility(0);
            this.I8.setVisibility(0);
            this.J8.setVisibility(0);
            this.K8.setVisibility(0);
            this.F8.setText(c3(R.string.pick_ota_file));
            this.F8.setText(c3(R.string.pick_ota_file_left));
            this.I8.setText(c3(R.string.pick_ota_file_right));
        }
        view.findViewById(R.id.ok_dual_pick).setOnClickListener(this.L8);
        view.findViewById(R.id.cancel_dual_pick).setOnClickListener(this.M8);
    }

    public final void e6(int i10, Intent intent) {
    }

    public final void f6(int i10, Intent intent) {
    }

    public void g6(int i10) {
    }

    public final boolean h6() {
        int i10 = this.E8;
        if (i10 == 0) {
            if (TextUtils.isEmpty(this.G8.getText()) || this.G8.getText().toString().equals("--")) {
                Toast.makeText(w1(), c3(R.string.pick_File_tips), 0).show();
                return false;
            }
            g.d(w1(), tf.a.D, this.G8.getText());
            return true;
        }
        if (i10 == 1) {
            if (TextUtils.isEmpty(this.J8.getText()) || this.J8.getText().toString().equals("--")) {
                Toast.makeText(w1(), c3(R.string.pick_File_tips), 0).show();
                return false;
            }
            g.d(w1(), tf.a.E, this.J8.getText());
            return true;
        }
        if (i10 == 2) {
            if (TextUtils.isEmpty(this.G8.getText()) || this.G8.getText().toString().equals("--")) {
                Toast.makeText(w1(), c3(R.string.pick_File_tips), 0).show();
                return false;
            }
            g.d(w1(), tf.a.D, this.G8.getText());
            return true;
        }
        if (i10 == 3) {
            if (!TextUtils.isEmpty(this.J8.getText()) && !TextUtils.isEmpty(this.G8.getText()) && !this.J8.getText().toString().equals("--") && !this.G8.getText().toString().equals("--")) {
                g.d(w1(), tf.a.D, this.G8.getText());
                g.d(w1(), tf.a.E, this.J8.getText());
                return true;
            }
            Toast.makeText(w1(), c3(R.string.pick_File_tips), 0).show();
        }
        return false;
    }

    public void i6(c cVar) {
        this.D8 = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.pick_ota_file_left) {
            g6(3);
        } else if (id2 == R.id.pick_ota_file_right) {
            g6(4);
        }
    }
}
