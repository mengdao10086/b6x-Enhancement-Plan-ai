package com.github.dhaval2404.colorpicker;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.dhaval2404.colorpicker.model.ColorShape;
import com.github.dhaval2404.colorpicker.model.ColorSwatch;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b0\u00101J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/github/dhaval2404/colorpicker/MaterialColorPickerBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lba/a;", "listener", "k6", "Lba/b;", "l6", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", xc.d.V, "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "O3", "view", "Lkotlin/z1;", "j4", "H5", "Landroid/content/DialogInterface;", "dialog", "onCancel", "", "E8", "Ljava/lang/String;", "title", "F8", "positiveButton", "G8", "negativeButton", "J8", "defaultColor", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "K8", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "colorShape", "Lcom/github/dhaval2404/colorpicker/model/ColorSwatch;", "L8", "Lcom/github/dhaval2404/colorpicker/model/ColorSwatch;", "colorSwatch", "", "M8", "Ljava/util/List;", "colors", "", "N8", "Z", "isTickColorPerCard", "<init>", "()V", "O8", "a", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class MaterialColorPickerBottomSheet extends BottomSheetDialogFragment {

    @k
    public static final a O8 = new a(null);

    @k
    public static final String P8 = "extra.title";

    @k
    public static final String Q8 = "extra.positive_Button";

    @k
    public static final String R8 = "extra.negative_button";

    @k
    public static final String S8 = "extra.default_color";

    @k
    public static final String T8 = "extra.color_shape";

    @k
    public static final String U8 = "extra.color_swatch";

    @k
    public static final String V8 = "extra.colors";

    @k
    public static final String W8 = "extra.is_tick_color_per_card";

    @l
    public String E8;

    @l
    public String F8;

    @l
    public String G8;

    @l
    public ba.a H8;

    @l
    public ba.b I8;

    @l
    public String J8;

    @k
    public ColorShape K8 = ColorShape.CIRCLE;

    @k
    public ColorSwatch L8 = ColorSwatch._300;

    @l
    public List<String> M8;
    public boolean N8;

    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/github/dhaval2404/colorpicker/MaterialColorPickerBottomSheet$a;", "", "Lcom/github/dhaval2404/colorpicker/h;", "dialog", "Lcom/github/dhaval2404/colorpicker/MaterialColorPickerBottomSheet;", "a", "", "EXTRA_COLORS", "Ljava/lang/String;", "EXTRA_COLOR_SHAPE", "EXTRA_COLOR_SWATCH", "EXTRA_DEFAULT_COLOR", "EXTRA_IS_TICK_COLOR_PER_CARD", "EXTRA_NEGATIVE_BUTTON", "EXTRA_POSITIVE_BUTTON", "EXTRA_TITLE", "<init>", "()V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final MaterialColorPickerBottomSheet a(@k h dialog) {
            f0.p(dialog, "dialog");
            Bundle bundle = new Bundle();
            bundle.putString(MaterialColorPickerBottomSheet.P8, dialog.l());
            bundle.putString(MaterialColorPickerBottomSheet.Q8, dialog.k());
            bundle.putString(MaterialColorPickerBottomSheet.R8, dialog.j());
            bundle.putString(MaterialColorPickerBottomSheet.S8, dialog.h());
            bundle.putParcelable(MaterialColorPickerBottomSheet.U8, dialog.e());
            bundle.putParcelable(MaterialColorPickerBottomSheet.T8, dialog.d());
            bundle.putBoolean(MaterialColorPickerBottomSheet.W8, dialog.m());
            bundle.putStringArrayList(MaterialColorPickerBottomSheet.V8, dialog.f() != null ? new ArrayList<>(dialog.f()) : null);
            MaterialColorPickerBottomSheet materialColorPickerBottomSheet = new MaterialColorPickerBottomSheet();
            materialColorPickerBottomSheet.c5(bundle);
            return materialColorPickerBottomSheet;
        }
    }

    public static final void i6(aa.c adapter, MaterialColorPickerBottomSheet this$0, View view) {
        ba.a aVar;
        f0.p(adapter, "$adapter");
        f0.p(this$0, "this$0");
        String strS = adapter.s();
        if ((!kotlin.text.u.V1(strS)) && (aVar = this$0.H8) != null) {
            ca.b bVar = ca.b.f10676a;
            aVar.a(ca.b.k(strS), strS);
        }
        this$0.H5();
    }

    public static final void j6(MaterialColorPickerBottomSheet this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.H5();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void H5() {
        super.H5();
        ba.b bVar = this.I8;
        if (bVar == null) {
            return;
        }
        bVar.onDismiss();
    }

    @Override // androidx.fragment.app.Fragment
    @l
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_bottomsheet_material_color_picker, viewGroup, false);
    }

    public void h6() {
    }

    @Override // androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.E8 = bundleT1.getString(P8);
            this.F8 = bundleT1.getString(Q8);
            this.G8 = bundleT1.getString(R8);
            this.J8 = bundleT1.getString(S8);
            ColorSwatch colorSwatch = (ColorSwatch) bundleT1.getParcelable(U8);
            f0.m(colorSwatch);
            this.L8 = colorSwatch;
            ColorShape colorShape = (ColorShape) bundleT1.getParcelable(T8);
            f0.m(colorShape);
            this.K8 = colorShape;
            this.M8 = bundleT1.getStringArrayList(V8);
            this.N8 = bundleT1.getBoolean(W8);
        }
        String str = this.E8;
        if (str != null) {
            View viewK3 = k3();
            ((AppCompatTextView) (viewK3 == null ? null : viewK3.findViewById(R.id.titleTxt))).setText(str);
        }
        String str2 = this.F8;
        if (str2 != null) {
            View viewK32 = k3();
            ((AppCompatButton) (viewK32 == null ? null : viewK32.findViewById(R.id.positiveBtn))).setText(str2);
        }
        String str3 = this.G8;
        if (str3 != null) {
            View viewK33 = k3();
            ((AppCompatButton) (viewK33 == null ? null : viewK33.findViewById(R.id.negativeBtn))).setText(str3);
        }
        List<String> listC = this.M8;
        if (listC == null) {
            ca.b bVar = ca.b.f10676a;
            Context contextR4 = R4();
            f0.o(contextR4, "requireContext()");
            listC = bVar.c(contextR4, this.L8.getValue());
        }
        final aa.c cVar = new aa.c(listC);
        cVar.v(this.K8);
        cVar.x(this.N8);
        String str4 = this.J8;
        if (!(str4 == null || kotlin.text.u.V1(str4))) {
            String str5 = this.J8;
            f0.m(str5);
            cVar.w(str5);
        }
        View viewK34 = k3();
        ((RecyclerView) (viewK34 == null ? null : viewK34.findViewById(R.id.materialColorRV))).setHasFixedSize(true);
        View viewK35 = k3();
        ((RecyclerView) (viewK35 == null ? null : viewK35.findViewById(R.id.materialColorRV))).setLayoutManager(new FlexboxLayoutManager(X1()));
        View viewK36 = k3();
        ((RecyclerView) (viewK36 == null ? null : viewK36.findViewById(R.id.materialColorRV))).setAdapter(cVar);
        View viewK37 = k3();
        ((AppCompatButton) (viewK37 == null ? null : viewK37.findViewById(R.id.positiveBtn))).setOnClickListener(new View.OnClickListener() { // from class: com.github.dhaval2404.colorpicker.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MaterialColorPickerBottomSheet.i6(cVar, this, view2);
            }
        });
        View viewK38 = k3();
        ((AppCompatButton) (viewK38 != null ? viewK38.findViewById(R.id.negativeBtn) : null)).setOnClickListener(new View.OnClickListener() { // from class: com.github.dhaval2404.colorpicker.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MaterialColorPickerBottomSheet.j6(this.f16488a, view2);
            }
        });
    }

    @k
    public final MaterialColorPickerBottomSheet k6(@l ba.a aVar) {
        this.H8 = aVar;
        return this;
    }

    @k
    public final MaterialColorPickerBottomSheet l6(@l ba.b bVar) {
        this.I8 = bVar;
        return this;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@k DialogInterface dialog) {
        f0.p(dialog, "dialog");
        super.onCancel(dialog);
        ba.b bVar = this.I8;
        if (bVar == null) {
            return;
        }
        bVar.onDismiss();
    }
}
