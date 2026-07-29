package u2;

import androidx.annotation.RestrictTo;
import androidx.room.Index;
import androidx.room.j0;
import androidx.room.u0;
import androidx.room.y0;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@u0(foreignKeys = {@y0(childColumns = {"work_spec_id"}, entity = r.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {CommonNetImpl.TAG, "work_spec_id"})
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @j0(name = CommonNetImpl.TAG)
    @n0
    public final String f51896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j0(name = "work_spec_id")
    @n0
    public final String f51897b;

    public u(@n0 String tag, @n0 String workSpecId) {
        this.f51896a = tag;
        this.f51897b = workSpecId;
    }
}
