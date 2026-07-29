package fa;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.e;
import com.github.drjacky.imagepicker.R;
import com.github.drjacky.imagepicker.constant.ImageProvider;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u000b"}, d2 = {"Lfa/e;", "", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "Lea/b;", "Lcom/github/drjacky/imagepicker/constant/ImageProvider;", "listener", "Lkotlin/z1;", "e", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final e f28007a = new e();

    public static final void f(ea.b listener, DialogInterface dialogInterface) {
        f0.p(listener, "$listener");
        listener.onResult(null);
    }

    public static final void g(ea.b listener, DialogInterface dialogInterface, int i10) {
        f0.p(listener, "$listener");
        listener.onResult(null);
    }

    public static final void h(ea.b listener, androidx.appcompat.app.e eVar, View view) {
        f0.p(listener, "$listener");
        listener.onResult(ImageProvider.CAMERA);
        eVar.dismiss();
    }

    public static final void i(ea.b listener, androidx.appcompat.app.e eVar, View view) {
        f0.p(listener, "$listener");
        listener.onResult(ImageProvider.GALLERY);
        eVar.dismiss();
    }

    public final void e(@yt.k Context context, @yt.k final ea.b<ImageProvider> listener) {
        f0.p(context, "context");
        f0.p(listener, "listener");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.dialog_choose_app, (ViewGroup) null);
        final androidx.appcompat.app.e eVarI = new e.a(context).F(R.string.title_choose_image_provider).setView(viewInflate).u(new DialogInterface.OnCancelListener() { // from class: fa.a
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                e.f(listener, dialogInterface);
            }
        }).setNegativeButton(R.string.action_cancel, new DialogInterface.OnClickListener() { // from class: fa.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                e.g(listener, dialogInterface, i10);
            }
        }).I();
        ((LinearLayout) viewInflate.findViewById(R.id.lytCameraPick)).setOnClickListener(new View.OnClickListener() { // from class: fa.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.h(listener, eVarI, view);
            }
        });
        ((LinearLayout) viewInflate.findViewById(R.id.lytGalleryPick)).setOnClickListener(new View.OnClickListener() { // from class: fa.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.i(listener, eVarI, view);
            }
        });
    }
}
