package a;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j6 implements r6, DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s6 f6478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u0 f1505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ListAdapter f1506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f1507a;

    public j6(s6 s6Var) {
        this.f6478a = s6Var;
    }

    @Override // a.r6
    public boolean a() {
        u0 u0Var = this.f1505a;
        if (u0Var != null) {
            return u0Var.isShowing();
        }
        return false;
    }

    @Override // a.r6
    public void b(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // a.r6
    public void d(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // a.r6
    public void dismiss() {
        u0 u0Var = this.f1505a;
        if (u0Var != null) {
            u0Var.dismiss();
            this.f1505a = null;
        }
    }

    @Override // a.r6
    public void f(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // a.r6
    public Drawable g() {
        return null;
    }

    @Override // a.r6
    public int i() {
        return 0;
    }

    @Override // a.r6
    public void j(CharSequence charSequence) {
        this.f1507a = charSequence;
    }

    @Override // a.r6
    public int k() {
        return 0;
    }

    @Override // a.r6
    public void l(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // a.r6
    public void n(ListAdapter listAdapter) {
        this.f1506a = listAdapter;
    }

    @Override // a.r6
    public CharSequence o() {
        return this.f1507a;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6478a.setSelection(i);
        if (this.f6478a.getOnItemClickListener() != null) {
            this.f6478a.performItemClick(null, i, this.f1506a.getItemId(i));
        }
        dismiss();
    }

    @Override // a.r6
    public void p(int i, int i2) {
        if (this.f1506a == null) {
            return;
        }
        t0 t0Var = new t0(this.f6478a.getPopupContext());
        CharSequence charSequence = this.f1507a;
        if (charSequence != null) {
            t0Var.h(charSequence);
        }
        t0Var.g(this.f1506a, this.f6478a.getSelectedItemPosition(), this);
        u0 u0VarA = t0Var.a();
        this.f1505a = u0VarA;
        ListView listViewE = u0VarA.e();
        if (Build.VERSION.SDK_INT >= 17) {
            listViewE.setTextDirection(i);
            listViewE.setTextAlignment(i2);
        }
        this.f1505a.show();
    }
}
