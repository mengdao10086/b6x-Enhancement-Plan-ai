package qu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.flydigi.base.R;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final b f47637a = new b();

    public static /* synthetic */ c b(b bVar, Context context, AttributeSet attributeSet, c cVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            cVar = new c();
        }
        return bVar.a(context, attributeSet, cVar);
    }

    @k
    public final c a(@k Context context, @l AttributeSet attributeSet, @k c defaultStore) {
        f0.p(context, "context");
        f0.p(defaultStore, "defaultStore");
        if (attributeSet == null) {
            return defaultStore;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SuperLine);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…s, R.styleable.SuperLine)");
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.SuperLine_orientation) {
                defaultStore.m(typedArrayObtainStyledAttributes.getInt(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperLine_line_color) {
                defaultStore.h(typedArrayObtainStyledAttributes.getColor(index, -7829368));
            }
            if (index == R.styleable.SuperLine_line_startColor) {
                defaultStore.n(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperLine_line_endColor) {
                defaultStore.l(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperLine_line_dashWidth) {
                defaultStore.k(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperLine_line_dashGapWidth) {
                defaultStore.j(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperLine_line_dashGapColor) {
                defaultStore.i(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return defaultStore;
    }
}
