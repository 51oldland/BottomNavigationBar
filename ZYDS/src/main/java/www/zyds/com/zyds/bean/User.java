package www.zyds.com.zyds.bean;

import javax.inject.Inject;

import dagger.Component;
import www.zyds.com.zyds.view.activity.MainActivity;

/**
 * Created by wwp
 * DATE: 2019/4/9:15:17
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public class User {
    private String name;

    @Inject
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Component
 public interface ActivityComponent {
         void inject(MainActivity MainActivity);
 }
}
