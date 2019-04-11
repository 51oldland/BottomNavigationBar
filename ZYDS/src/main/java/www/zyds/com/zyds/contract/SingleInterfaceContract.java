package www.zyds.com.zyds.contract;
import www.zyds.com.zyds.view.activity.IView;


public interface SingleInterfaceContract {


    interface View extends IView {
        void showArticleSuccess(String bean);

        void showArticleFail(String errorMsg);
    }

    interface Presenter {
        void getData(int curPage);
    }

}
