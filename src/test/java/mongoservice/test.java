package mongoservice;

import java.util.Date;

import com.paymoon.common.date.DateUtil;


public class test {
public static void main(String[] args) {
	System.out.println(DateUtil.DateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
}
}
