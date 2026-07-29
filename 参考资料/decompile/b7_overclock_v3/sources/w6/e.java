package w6;

import androidx.room.e1;
import androidx.room.l0;
import androidx.room.p1;
import androidx.room.q0;
import com.flydigi.data.bean.SupportedGameBean;
import java.util.List;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
@l0
public interface e {
    @p1("DELETE FROM supported_game")
    void a();

    @p1("SELECT * FROM supported_game WHERE package_name = :packageName")
    @k
    SupportedGameBean b(@k String str);

    @e1(onConflict = 1)
    @k
    xi.a c(@k List<? extends SupportedGameBean> list);

    @q0
    void d(@k SupportedGameBean... supportedGameBeanArr);

    @e1(onConflict = 1)
    void e(@k SupportedGameBean... supportedGameBeanArr);

    @e1(onConflict = 1)
    void f(@k List<? extends SupportedGameBean> list);

    @p1("SELECT * FROM supported_game")
    @k
    List<SupportedGameBean> getAll();
}
