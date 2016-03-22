package com.cristik.business.entity.mvo;

import com.cristik.business.entity.svo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghua on 2016/3/18.
 */
public class UserMvo extends User {

    List<String> habit = new ArrayList<String>();

    public List<String> getHabit() {
        return habit;
    }

    public void setHabit(List<String> habit) {
        this.habit = habit;
    }

    public String toString() {
        return "UserMvo{" +
                "habit=" + habit +
                '}';
    }
}
