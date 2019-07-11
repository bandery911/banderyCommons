package com.bandery.random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/*
 * 随机生成中文用户名
 * */
public class RandomChineseName {

    private static final Random random = new Random(System.currentTimeMillis());

    /*
     * 随机生成中国用户名，姓氏只去常见姓氏，过滤冷僻姓
     * */
    public static String randomChineseName() throws Exception{
        BufferedReader firstNameReader = new BufferedReader(new FileReader(new File("resources/commonChineseFirstName")));
        BufferedReader chineseReader = new BufferedReader(new FileReader(new File("resources/commonChinese")));
        String line = firstNameReader.readLine();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> chinese = new ArrayList<>();
        while (line != null){
            firstNames.add(line.trim());
            line = firstNameReader.readLine();
        }
        line = chineseReader.readLine();
        while (line != null){
            chinese.add(line.trim());
            line = chineseReader.readLine();
        }
        firstNameReader.close();
        chineseReader.close();
        int firstNameSize = firstNames.size();
        int chineseSize = chinese.size();
        //随机二字还是三字
        if(random.nextBoolean())
            return firstNames.get(random.nextInt(firstNameSize)) + chinese.get(random.nextInt(chineseSize));
        return firstNames.get(random.nextInt(firstNameSize)) + chinese.get(random.nextInt(chineseSize)) +
                chinese.get(random.nextInt(chineseSize));
    }

    /*
    * 随机生成count个中文姓名
    * */
    public static String[] randomChineseName(int count) throws Exception{
        String[] names = new String[count];
        for (int i = 0; i < count; i++){
            names[i] = randomChineseName();
        }
        return names;
    }

}
