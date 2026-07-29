package com.flydigi.qiji.ui.about_phone;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.os.e;
import b9.f;
import com.blankj.utilcode.util.o;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.qiji.ui.about_phone.QrCodeDialogFragment;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.EnumMap;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import m5.b;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class QrCodeDialogFragment extends BaseDialogFragment {

    @k
    public static final a F8 = new a(null);

    @k
    public static final String G8 = "key_mac";

    @k
    public static final String H8 = "key_uuid";
    public f E8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final QrCodeDialogFragment a(@l String str, @l String str2) {
            QrCodeDialogFragment qrCodeDialogFragment = new QrCodeDialogFragment();
            qrCodeDialogFragment.c5(e.b(new Pair(QrCodeDialogFragment.G8, str), new Pair(QrCodeDialogFragment.H8, str2)));
            return qrCodeDialogFragment;
        }
    }

    public static final void h6(QrCodeDialogFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.e6();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        f fVarD = f.d(inflater, viewGroup, false);
        f0.o(fVarD, "inflate(inflater, container, false)");
        this.E8 = fVarD;
        if (fVarD == null) {
            f0.S("viewBinding");
            fVarD = null;
        }
        FrameLayout root = fVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.main_dialog_qrcode;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        Window window;
        super.f4();
        Dialog dialogL5 = L5();
        if (dialogL5 == null || (window = dialogL5.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        f0.o(attributes, "it.attributes");
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) throws WriterException {
        f0.p(view, "view");
        super.j4(view, bundle);
        Dialog dialogL5 = L5();
        if (dialogL5 != null) {
            dialogL5.setCancelable(false);
        }
        f fVar = this.E8;
        f fVar2 = null;
        if (fVar == null) {
            f0.S("viewBinding");
            fVar = null;
        }
        o.r(fVar.f9163b, new View.OnClickListener() { // from class: d9.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QrCodeDialogFragment.h6(this.f26117a, view2);
            }
        });
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mac=");
        Bundle bundleT1 = T1();
        sb2.append(bundleT1 != null ? bundleT1.getString(G8) : null);
        sb2.append("&uuid=");
        Bundle bundleT12 = T1();
        sb2.append(bundleT12 != null ? bundleT12.getString(H8) : null);
        String strD = b.d(sb2.toString());
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
        int dimensionPixelSize = V2().getDimensionPixelSize(R.dimen.qb_px_320);
        int dimensionPixelSize2 = V2().getDimensionPixelSize(R.dimen.qb_px_320);
        af.b bVarB = new of.b().b(strD, BarcodeFormat.QR_CODE, dimensionPixelSize, dimensionPixelSize2, enumMap);
        int[] iArr = new int[dimensionPixelSize * dimensionPixelSize2];
        for (int i10 = 0; i10 < dimensionPixelSize; i10++) {
            for (int i11 = 0; i11 < dimensionPixelSize2; i11++) {
                if (bVarB.f(i10, i11)) {
                    iArr[(i10 * dimensionPixelSize) + i11] = -16777216;
                } else {
                    iArr[(i10 * dimensionPixelSize) + i11] = -1;
                }
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, dimensionPixelSize, dimensionPixelSize2, Bitmap.Config.RGB_565);
        f fVar3 = this.E8;
        if (fVar3 == null) {
            f0.S("viewBinding");
        } else {
            fVar2 = fVar3;
        }
        fVar2.f9164c.setImageBitmap(bitmapCreateBitmap);
    }
}
