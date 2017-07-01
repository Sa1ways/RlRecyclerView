package cn.shawn.shawnrvproject;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-6-24.
 */

public class DataUtil {

    public static List<String> generateData(int rangeL, int size){
        List<String> data = new ArrayList<>();
        for (int i = 0; i < rangeL+ Math.random()*size; i++) {
            data.add("");
        }
        return data;
    }
}
