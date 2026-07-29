package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DragAndDropPermissions f4920a;

    @g.v0(24)
    public static class a {
        @g.u
        public static void a(DragAndDropPermissions dragAndDropPermissions) {
            dragAndDropPermissions.release();
        }

        @g.u
        public static DragAndDropPermissions b(Activity activity, DragEvent dragEvent) {
            return activity.requestDragAndDropPermissions(dragEvent);
        }
    }

    public h(DragAndDropPermissions dragAndDropPermissions) {
        this.f4920a = dragAndDropPermissions;
    }

    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static h b(@g.n0 Activity activity, @g.n0 DragEvent dragEvent) {
        DragAndDropPermissions dragAndDropPermissionsB;
        if (Build.VERSION.SDK_INT < 24 || (dragAndDropPermissionsB = a.b(activity, dragEvent)) == null) {
            return null;
        }
        return new h(dragAndDropPermissionsB);
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(this.f4920a);
        }
    }
}
