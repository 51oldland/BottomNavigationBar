package www.zyds.com.zyds.contract;


import www.zyds.com.zyds.view.activity.IView;

public interface MultipleInterfaceContract {


    interface View extends IView {
        void showMultipleSuccess(String bean);

        void showMultipleFail(String errorMsg);
    }

    interface Presenter {
        void getBanner();
    }


}
