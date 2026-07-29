package y8;

import com.flydigi.base.common.k;
import com.flydigi.base.common.m;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.game.data.bean.SearchBean;
import com.flydigi.game.data.bean.SearchRecoBean;
import java.util.List;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: y8.a$a, reason: collision with other inner class name */
    public interface InterfaceC0666a extends k {
        void B(String str);

        void K();

        void Q();
    }

    public interface b extends m {
        void m1(z<BaseResponse<List<SearchRecoBean>>> zVar);

        void p0(z<BaseResponse<SearchBean>> zVar, int i10);
    }
}
