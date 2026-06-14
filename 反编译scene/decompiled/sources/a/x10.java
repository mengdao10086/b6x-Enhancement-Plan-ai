package a;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class x10 extends TextInputLayout.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f7843a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x10(e20 e20Var, TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f7843a = e20Var;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.e, a.rf
    public void g(View view, ni niVar) {
        super.g(view, niVar);
        if (((f20) this.f7843a).f838a.getEditText().getKeyListener() == null) {
            niVar.a0(Spinner.class.getName());
        }
        if (niVar.L()) {
            niVar.l0(null);
        }
    }

    @Override // a.rf
    public void h(View view, AccessibilityEvent accessibilityEvent) {
        super.h(view, accessibilityEvent);
        e20 e20Var = this.f7843a;
        AutoCompleteTextView autoCompleteTextViewX = e20Var.x(((f20) e20Var).f838a.getEditText());
        if (accessibilityEvent.getEventType() == 1 && this.f7843a.f645a.isTouchExplorationEnabled()) {
            this.f7843a.F(autoCompleteTextViewX);
        }
    }
}
