# R7 — UI 基础设施与日志页 只读全量审查

> 审查者：R7（子 agent）。日期：2026-11-13。全程只读：未修改任何源码/资源/配置，未编译、未提交、未投放。
> 唯一写盘为本文件。

## 范围与读取清单

**白名单（15 Java + 3 res，共 5,166 行；本报告全部审计对象）**

| 文件 | 行数 |
|---|---|
| `ui/Motion.java` | 619 |
| `ui/EdgeToEdge.java` | 404 |
| `ui/WrapRowLayout.java` | 852 |
| `ui/PageScrollView.java` | 92 |
| `ui/ScrollbarDrag.java` | 193 |
| `ui/SelectionDismiss.java` | 16 |
| `ui/ViewSource.java` | 89 |
| `ui/TextCopy.java` | 1283 |
| `ui/LogClassifier.java` | 68 |
| `ui/LogFragment.java` | 679 |
| `ui/LogLine.java` | 34 |
| `ui/LogListAdapter.java` | 194 |
| `ui/LogTailReader.java` | 166 |
| `ui/OpLog.java` | 238 |
| `ui/StartupTimingReport.java` | 146 |
| `res/values/strings_log.xml` | 37 |
| `res/values/styles_log.xml` | 27 |
| `res/values/attrs_wrap_row.xml` | 29 |

**必读上下文（已读）**：项目 `CLAUDE.md`、`参数定义/对齐报告.md`、`TECH_DEBT.md`、`待办.md`、`lsp模块/app/逻辑说明.md`（全 1036 行）。

**越界只读（仅相关方法/行，未整包审）**：
`core/AppFiles.java`（全文）、`core/StartupTiming.java`（槽位/存储 API）、`SetupActivity.java`（onCreate 尾段、onResume、broadcastVisibility、dispatchTouchEvent）、`SettingsActivity.java`（EdgeToEdge 调用）、`ChartFragment.java`（指纹回写照抄、图例参数）、`ConfigKeyRow.java`（hint 图标/字段开关的 LayoutParams 用法）、`ConfigDiagnostics.java`（StartupTimingReport 调用）、`res/layout/fragment_log.xml`（全文）、`fragment_status.xml`/`activity_setup.xml`/`activity_settings.xml`（根与滚动容器节）、`daemon/tempctrl.c`（write_log 与轮转算法）、`参数定义/params.def.json`（UI_ANIM_TUNING / UI_PATH_COPY）、`values/colors.xml`、`values-night/colors.xml`、`values/dimens.xml`。

---

## A. 十条横切判据（逐条结论）

1. **契约一致性** —— 有缺陷。
   - `LogFragment → LogTailReader` 的「上次指纹/关键词」契约未兑现：`lastFingerprint`/`lastKeyword` 只读不写（`LogFragment.java:103-104,305-306`），`Snapshot.unchanged` 分支实际不可达。见 S2-1。
   - `ScrollbarDrag` 宣称的 20dp 命中带与 `OnTouchListener` 的实际可达范围不一致（子 View 消费 DOWN 时监听收不到）。见 S2-4。
   - `TextCopy` 的路径字符集两处不一致：正则不含 `:`（`TextCopy.java:140-141`），`isPathChar` 含 `:`（`:1205-1208`）。见 S3-6。
   - `WrapRowLayout`、`Motion`、`StartupTimingReport` 的公开契约与实现一致（`LayoutParams` 类型由 `addView` 统一转换，`slot()*2` 映射与 `StartupTiming` 一致）。
2. **资源生命周期** —— 有缺陷。
   - `TextCopy.CALLBACKS`（`:146`）是 `WeakHashMap`，但 value 强引用 key（`:200` 的 `view`），条目**永不可回收**；每次 Activity 重建累积整棵视图树。见 S2-2。
   - `Motion.HEIGHT_ANIMS`、`KeyboardState` 的 Handler、`PENDING/POLLING` 均有明确摘除路径（见 D）。
   - `PathActionCard` 的 `PopupWindow` 无页面销毁收尾（见 S3-4），静态 `current` 为弱引用但窗口本身可能挂住 Activity。
3. **静默失败** —— 有缺陷。
   - 日志读取失败链路完整（`Snapshot.failureText` 原样上屏，`LogFragment.java:361-368`），不静默。
   - `TextCopy.copy` 在 `ClipboardManager` 为 null 时静默不写（`:1276-1282`），S3-9。
   - root 跳转失败有 Toast + 剪贴板兜底（`:816-820`），不静默；SAF 分支对「目标无授权」不可感知（S3-8）。
   - `Motion.disableMagnifier` 的静默失败是文档明示的设计。
4. **并发与竞态** —— 未见 S1/S2。
   - `LogFragment` 的 `worker` 互斥、主线程单线程状态、`onDestroyView` 置空后 `listView == null` 守卫成立（`:308-320`）。
   - 守护进程原地轮转与读端的无锁窗口：读端可能读到短暂混合内容，下一轮自愈（S3-10）。
   - `OpLog`、`TextCopy`、`Motion` 的共享可变状态均只在主线程访问（或单线程 executor），未发现数据竞态。
5. **状态机完整性** —— 有缺陷但非致命。
   - 键盘 present/absent + 120ms 复核 + 取消路径完整（`EdgeToEdge.java:290-323`）。
   - 高度/箭头动画的「打断即换向」以 animator 身份比对收尾，正确（`Motion.java:335-339,377-389,451-461`）。
   - 日志整行选择：进入/扩展/复制/取消/返回/销毁六条出口齐全；选择期间不 `submit`（`LogFragment.java:371-375`）。
   - `ScrollbarDrag` 在拖动中可滚动余量骤减为 0 时无状态复检（S3-12）。
6. **输入边界** —— 有缺陷。
   - 单行可达 200KB（尾读上限）且无单行截断（S2-5）。
   - 含空格路径无法识别/整条复制（S3-7）。
   - 关键词过滤不解释正则、无长度上限，安全。
   - `LogListAdapter.selectedText()` 的 `to` 有钳制，`from` 无钳制但选择期间禁止换数据，实际不越界（D）。
7. **旧键兼容层** —— 无缺陷。
   - `UI_PATH_COPY` 旧单值配置：`holdToExpandMs` 在字段不足时回退 300ms（`TextCopy.java:1150-1152`）；开关读取异常按开（`:1161-1168`）。
   - `UI_ANIM_TUNING` 旧两值由 `ConfigStore` 按字段默认补齐，`Motion.setAnimTuning` 对非法强度回退 0.60（`Motion.java:147-153`），与文档一致。
   - `WrapRowLayout`/`LogClassifier`/`LogTailReader`/`OpLog` 无旧键面。
8. **重复与死代码** —— 有（S3）。
   - `TextCopy.expandOnce()` 私有且无调用（`:519-525`）；`LogTailReader.Snapshot.tailLines` 只写不读（`:63`）。
   - 未发现同一逻辑两份实现（`easeOut`/`panelCurve`、`copy` 均为单点）。
9. **文档偏差** —— 有（S3）。
   - `逻辑说明.md:884` 声称「无变化跳过」，与 S2-1 的实现不符。
   - `逻辑说明.md:883` 的刷新节奏、`:887-891` 的三条硬约束、`:936-937` 的列表/选择口径与实现一致。
   - `逻辑说明.md:769` 对 `ScrollbarDrag` 命中带的描述与实现公式一致，但未覆盖「子 View 消费 DOWN」这一边界（S2-4）。
10. **测试缺口** —— 全缺。
    - 仓库无 `src/test`、`src/androidTest`（实测 `find` 为空）。`LogClassifier`（纯函数）、`LogTailReader` 窗口切分（可拆纯函数）、`OpLog`（javadoc 自称可在 JVM 验证）、`StartupTimingReport` 均无任何用例。

---

## B. 缺陷清单

### S1（崩溃 / 功能失效 / 数据损坏）

**0 条。** 未发现可复现的崩溃、功能整体失效或数据损坏路径（含越界读取的调用点）。

### S2（边界条件下行为与预期不符）

| # | 文件:行 | 触发条件 | 后果 | 建议 |
|---|---|---|---|---|
| 1 | `LogFragment.java:305-306`（字段 `:103-104`） | 页面可见、2s 定时刷新 | 指纹/关键词从未回写，`LogTailReader.read` 的 `unchanged` 分支永不成立：每 2s 整段尾读 200KB、重建≤3000 个 `LogLine` 并 `notifyDataSetChanged`，滚动条与按压状态反复受扰 | 渲染成功后回写 `lastFingerprint`/`lastKeyword`（抄 `ChartFragment.java:360`） |
| 2 | `TextCopy.java:146`（value 在 `:200`） | 每次 Activity 重建都 `installPathSelection` | `WeakHashMap` 的 value 强引 key，条目永不可回收；反复旋转/进出页面累积 TextView→Context→整棵视图树 | 回调改持 `WeakReference<TextView>`，或在 detach 时移除条目 |
| 3 | `TextCopy.java:553-554` | 按住期满时系统尚未建立选区，且 TextView 有内边距/滚动偏移 | 用未扣 `totalPadding`/`scrollX/Y` 的坐标算字符偏移（对比 `:323-324`），扩选落到错误字符或整条路径认不出 | 坐标先减 `getTotalPadding*`、加 `getScroll*` |
| 4 | `LogFragment.java:160` + `ScrollbarDrag.java:54`（推断） | 手指落在右侧 20dp 命中带内、但压在某条日志行上（超出 RecyclerView 的 8dp 内边距） | DOWN 被可点击的行 View 消费，`OnTouchListener` 收不到 DOWN，拖动不启动，且可能误触行长按选择；命中带实际可用宽度≈内边距宽 | 改在容器 `onInterceptTouchEvent` 判定命中，或包一层命中层 |
| 5 | `LogTailReader.java:140-141` | 尾部存在 >200KB 无换行超长行（外部写入/文件损坏；`AppFiles.readTail` 对无换行整块返回） | 单个 200KB 字符串进入一个 TextView，主线程 measure/排版可能卡顿数秒甚至 ANR | 单行截断到上限（如 4KB）并显式标注 |

### S3（一致性 / 可读性 / 运维负担）

| # | 文件:行 | 触发条件 | 后果 | 建议 |
|---|---|---|---|---|
| 1 | `LogClassifier.java:15-22` | 正常日志含「失败/异常」（如 `tempctrl.c:1043` 迁移提示、`:2746` 去重跳过） | 正常行被涂成 ERROR，分级失去区分度 | 先判固定前缀，或对已知搭配豁免 |
| 2 | `TextCopy.java:519-525` | 无调用 | 死代码；读代码会误以为存在键盘/无障碍扩选入口 | 删除或接入实际入口 |
| 3 | `LogTailReader.java:63` | 无 | `tailLines` 只写不读，诊断信息缺一项 | 删除字段，或上屏「尾读总行数」 |
| 4 | `TextCopy.java:680-741` | 路径小卡显示期间切页/页面销毁 | `PopupWindow` 无生命周期收尾，窗口链可能持有 Activity；静态 `current` 弱引用不解决窗口本身 | 页面销毁时显式 `dismiss` |
| 5 | `TextCopy.java:722-732` | 存在状态栏/导航栏或显示区域裁剪 | `getWindowVisibleDisplayFrame`（可见框）与 `getLocationOnScreen`/`showAtLocation`（屏幕坐标）混用，卡片可能整体偏移一条系统栏高 | 统一换算到窗口坐标后再定位 |
| 6 | `TextCopy.java:140-141` vs `:1205-1208` | 选区紧邻 ASCII 词 + 冒号（如 `path:/data/x`） | 正则不认 `:`、扩选却把 `:` 当路径字符，回扫越界到词首，整条扩选失败 | 两处路径字符集统一 |
| 7 | `TextCopy.java:140-141` | 路径含空格（如 `/sdcard/My Files/a.txt`） | 路径在空格处截断，无法整条复制/跳转 | 允许段内空格（至少引号/转义形式） |
| 8 | `TextCopy.java:849-865,915-931` | 用户选中的候选文件管理器不持 `MANAGE_DOCUMENTS` | 未加 `FLAG_GRANT_READ_URI_PERMISSION`，`startActivity` 成功但目标读不到 URI；`SecurityException` 分支不回退目录选择器 | 对非系统目标补授权或回退 `openDocumentTree` |
| 9 | `TextCopy.java:1276-1282` | `ClipboardManager` 取不到 | 长按/复制按钮无任何反馈，用户以为已复制 | manager 为空时 Toast 提示 |
| 10 | `LogTailReader.java:117` | 守护进程正在原地轮转（`tempctrl.c:1873-1890` 先 `pwrite` 头再 `ftruncate`） | 读窗口可能拼到新旧混合内容，出现短暂乱行；下一轮自愈 | 读后复核 size/mtime，变化则重读 |
| 11 | `LogFragment.java:295-321` | 页面可见期间 | 每 2s 新建一条 `ww-log` 线程（线程/秒级 churn） | 复用单线程 executor |
| 12 | `ScrollbarDrag.java:184` | 拖动中列表内容骤减、可用余量变 0 | `usable == 0` 时 `0/0 → NaN`，`Math.round` 得 0，视图被拉到顶部；拖动状态不结束 | MOVE 内重判 `usable`，≤0 即结束拖动 |
| 13 | `WrapRowLayout.java:287-306` | 容器为 `wrap_content` 且内容折行（当前唯一用例 `item_config_field_switch.xml` 为单行） | 测量用 spec 宽、布局用实际宽，行分组可能不同，理论上有高度低估/裁切 | 布局阶段复用测量时的 `rowLimit` |
| 14 | `EdgeToEdge.java:80-83` | 根布局将来带 XML padding | `setPadding` 是覆盖而非叠加，设计间距被系统栏 inset 取代 | 以「基准 padding + inset」赋值 |
| 15 | `逻辑说明.md:884` | 阅读文档 | 文档承诺的「无变化跳过」实际不成立（见 S2-1） | 随 S2-1 一并修正文档或实现 |

---

## C. 越界发现（归属包 + 一句话）

| # | 位置 | 归属包 | 一句话 |
|---|---|---|---|
| 1 | `core/AppFiles.java:90-91` | core（AppFiles） | 指纹 `mtimeMs = st_mtime * 1000` 只有**秒级**精度，同秒等长改写（如曲线/配置类小文件）会漏判；日志追加因 size 变化不受影响。 |
| 2 | `daemon/tempctrl.c:1873-1890` | daemon（tempctrl） | 日志轮转为原地 `pwrite` + `ftruncate`，与读端无同步，读端可短暂看到新旧混合内容（已列 S3-10）。 |
| 3 | `ChartFragment.java:296-360` | ui（曲线包） | 同一「指纹回写」模式在此实现正确（`:351` 置空、`:360` 成功回写），可作为 S2-1 的修法参照。 |
| 4 | `SetupActivity.java:438-447` | app 外壳 | `broadcastVisibility` 在 `onResume` 与首帧后各广播一次，日志页的 `onPageVisible(true)` 可能在 `onResume` 前触发一次 `startRefresh`；幂等且 `onPause` 会停，未判缺陷。 |
| 5 | `ConfigKeyRow.java:1712-1785` | ui（表单包） | 子控件先 `setLayoutParams(ViewGroup.LayoutParams)` 再 `WrapRowLayout.addView`，由 `addView` 的 `checkLayoutParams/generateLayoutParams` 转成本类参数，已核实不会 ClassCastException。 |

---

## D. 已核实无害（可疑但查证不成立）

1. **`Motion.HEIGHT_ANIMS` 用 `WeakHashMap`（`Motion.java:131`）**：value（`ValueAnimator`）的 update listener 强引 View，若动画永不结束确实会漏；但所有入口都在结束/替换/取消路径摘除条目，且时长上限 600ms、无「永久运行」分支，故不是泄漏。
2. **`TextCopy.PENDING/POLLING` 静态表（`:1230-1273`）**：value `Runnable` 为方法引用（会持有 Fragment），但 key 在视图可见时压入；轮询 Runnable 挂在 view 的消息队列，视图 detach 后仍会执行一次并删除两侧条目，故不是永久泄漏。
3. **`EdgeToEdge.ContentHostAvoid`/`BottomBarLayout` 的基准值只量一次**：`apply()` 在 `onCreate` 内、窗口 attach 之前注册监听，material 自带监听未有机会先写 padding，基准不会被 inset 污染；底栏首次量到的是 XML 定高。
4. **`EdgeToEdge` 覆盖根 padding（`:80-83`）**：`setup_root` 与 `settings_root` 均无 XML padding（布局实读），当前无实际损失；仅列为将来风险（S3-14）。
5. **`LogTailReader` 的窗口切分数学（`:122-152`）**：0 字节、纯换行、≤MAX_LINES、>MAX_LINES 四种情形逐一推演，`windowNl` 恰为自尾第 MAX_LINES 个换行，`tail` 长度 = `candidate`，无越界/丢行。
6. **`ScrollbarDrag` 的 `usable` 除法（`:184`）**：DOWN 时 `usable <= 0` 已拒绝，正常拖动不会除零；仅拖动中数据变化可触发（S3-12）。
7. **`WrapRowLayout` 的 `(LayoutParams)` 强转（`:318`）**：所有 `setLayoutParams` 调用点（`ChartFragment`、`ConfigKeyRow`、`KiCutTableEditor`、`UiSettingsFragment`）均发生在 `addView` 转换之后或传入本类参数，未发现可触发 ClassCastException 的路径。
8. **`LogFragment` 销毁后仍可能到达的 worker 回调**：`applySnapshot` 先判 `listView == null`（`:311-314`），且所有视图字段在 `onDestroyView` 一起置空，主线程无交错。
9. **`OpLog.evict` 不会删掉本会话文件**：`evict()` 只在 `beginSession()` 调一次，此时 `sessionFile` 尚未创建；此后不再淘汰。
10. **`Motion.animateHeight` 的收尾竞态**：先摘账再 `cancel`、`onAnimationEnd` 比对 animator 身份（`:335-339,380-387`），旧动画不会误置最终态；打断换向从当前高度继续。
11. **`LogClassifier` 时间戳正则（`:37`）与 C 端格式**：`tempctrl.c:1909` 的 `snprintf("%02d %02d:%02d:%02d")` 与 `^\[\d\d \d\d:\d\d:\d\d\] ` 精确对应，INFO 判定不会整体失效。
12. **`LogListAdapter.selectedText()` 越界**：`to` 已钳到 `items.size()-1`；选择期间调用方禁止 `submit`，`from` 不会越界，最坏返回空串，不崩溃。
13. **`KeyboardState` 的 Handler（`EdgeToEdge.java:281`）**：销毁后最多 120ms 内持有 root，随后自然回收；未发现跨 Activity 的长持有。
14. **`OpLog` 只 `flush` 不 `fsync`**：文档口径是「进程被杀不丢」，`flush` 已满足；掉电丢尾部不在承诺内，不判缺陷。

---

## E. 未覆盖 / 待真机

1. **真机手势边界**：S2-4（滚动条命中带被行 View 消费）是由框架事件分发推得，需真机确认实际可用宽度；`PageScrollView` 与 ViewPager2 的斜向拖动、系统手势导航最外侧边缘的占用、`requestDisallowInterceptTouchEvent` 的交接时序均未真机验证。
2. **快速滑动 / 惯性**：`ScrollbarDrag.stopOngoingScroll` 用 `fling(0)` 结束 `ScrollView` 惯性，真机上是否完全接管、是否存在一帧回写未验证。
3. **TextCopy 三条路径**：第三方文件管理器对无授权 `content://` URI 的实际表现；MT 的显式组件是否在目标 ROM 存在、`am start` 输出格式是否仍含 `Starting: Intent`；root 被拒/超时的 Toast 观感。均需真机。
4. **PopupWindow 定位**：状态栏/挖孔/手势条下的实际偏移（S3-5）。
5. **SELinux 直读**：日志/曲线文件由 root daemon 创建时 `errno=13` 的可能性（`AppFiles` 文档已列），日志页失败态的真实表现未验证。
6. **旋转/进出页面后的内存曲线**：S2-2 的累积速度需在真机连续旋转数十次后观察（`dumpsys meminfo` / LeakCanary 类工具）。
7. **日志页 2s 重建的观感**：S2-1 修复前后长按选择成功率、滚动条抖动、耗电对比未实测。
8. **C 端原地轮转的读取窗口**：S3-10 的乱行频率取决于写入量与读时序，未在真机采样。
9. **未审的相邻包**：`ConfigKeyRow`/`ConfigGroupBinder`/`ChartFragment`/`ChartView`/`StatusFragment`/`Deployer`/`MainHook` 仅在调用点级别读过，未做本包式全量审查；`StartupTimingReport` 的槽位语义按 `StartupTiming` 源码核对，但未验证展示值在真机上的合理性。
10. **测试**：仓库无任何单元/仪器测试；`LogClassifier`、`LogTailReader` 窗口切分、`OpLog`、`StartupTimingReport` 的 JVM 可测性已确认，但本轮只读未运行。
