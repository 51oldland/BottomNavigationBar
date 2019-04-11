package www.zyds.com.zyds.view.activity;

/**
 * Created by wwp
 * DATE: 2019/4/10:14:54
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public interface SingleInterfaceIView extends IView{
    void showArticleSuccess(String bean);

    void showArticleFail(String errorMsg);
}
