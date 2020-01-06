package com.jintu.ipcdp.framework.utils;

public class ProductPlateNumber {
    public static String sss(String _buf){
        int Num1, Num2, Num3;
        char[] sn = new char[8];
        int i, len;
        Num1 = 0;
        Num2 = 0;
        Num3 = 0;
        len = _buf.length();

        if (len != 0)
        {
            for (i = 1; i <= len; i++)
            {
                //第一步算法
                Num1 = (int) (((Num1 + ((_buf.charAt(i - 1))*i*i)*(i*Math.sqrt((double)_buf.charAt(i - 1)) + 1))) % 100000);   // 求平方根 Math.sqrt
                //第二步算法
                Num2 = (int) ((Num2*i + ((Math.pow(_buf.charAt(i - 1), 2)*i))) % 100000);//    求幂 pow
                //第三步算法
                Num3 = (Num2 + (int)Math.sqrt((double)Num1)) % 100000;
            }
            //以下把三个算法结果分别生成2个字符，共有6个
            for (i = 0; i < 2; i++)
                sn[i] = (char) ((Num1 + 31 + i*i*i) % 128);
            for (i = 2; i < 5; i++)
                sn[i] = (char) ((Num2 + 31 + i*i*i) % 128);
            for (i = 5; i < 7; i++)
                sn[i] = (char) ((Num3 + 31 + i*i*i) % 128);

            //以下循环把所有生成的字符转换为0---9，A---Z，a----z
            for (i = 0; i < 8; i++)
            {
                while ((sn[i]<'0' || sn[i]>'9') && (sn[i]<'A' || sn[i]>'Z') && (sn[i]<'a' || sn[i]>'z'))
                {
                    sn[i] = (char) ((sn[i] + 31 + 7 * i) % 128);
                }

                if (sn[i] >= 'a' && sn[i] <= 'z')
                {
                    sn[i] = (char) (sn[i] - 32);
                }

                //  所有小写字母转为大写
                sn[i] = (sn[i] >= 'a' && sn[i] <= 'z') ? (char) (sn[i] - 32) : sn[i];
            }
            sn[7] = '\0';
            //赋值给一个CSTRING变量，用做函数返回值
            String s = String.copyValueOf(sn);
            return "临"+s;
        }
        return "";
    }
}