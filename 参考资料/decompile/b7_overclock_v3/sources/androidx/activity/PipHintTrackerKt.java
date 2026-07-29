package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import g.v0;
import kotlin.z1;
import kotlinx.coroutines.s1;

/* JADX INFO: loaded from: classes2.dex */
public final class PipHintTrackerKt {

    public static final class a<T> implements kotlinx.coroutines.flow.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f1348a;

        public a(Activity activity) {
            this.f1348a = activity;
        }

        @Override // kotlinx.coroutines.flow.f
        @yt.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object f(@yt.k Rect rect, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            b.f1358a.a(this.f1348a, rect);
            return z1.f38230a;
        }
    }

    @s1
    @yt.l
    @v0(26)
    public static final Object b(@yt.k Activity activity, @yt.k View view, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objA = kotlinx.coroutines.flow.g.s(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).a(new a(activity), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    public static final Rect c(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
