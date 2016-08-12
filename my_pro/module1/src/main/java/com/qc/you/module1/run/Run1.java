package com.qc.you.module1.run;

import com.qc.you.module1.entity.ReqModel;
import com.qc.you.utils.Object2Json;

/**
 * Created by youxiaojia on 2016/7/21.
 */
public class Run1 {
    public static void main( String arg[] ){
        ReqModel reqModel = new ReqModel();
        reqModel.setReq1("A");
        reqModel.setReq2("B");
        System.out.println(Object2Json.parse(reqModel));
    }
}
