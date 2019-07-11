package com.bandery.random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * 随机生成简单的中国地址，如：浙江省杭州市仙山东路99号
 * 门牌号最大99
 */
public class RandomChineseAddress {
    private static final Random random = new Random(System.currentTimeMillis());

    /**
     * 随机生成一个中国地址
     */
    public static String randomChineseAddress() throws Exception{
        BufferedReader provAndCityReader = new BufferedReader(new FileReader(new File("resources/chineseProvinceAndCity")));
        BufferedReader roadReader = new BufferedReader(new FileReader(new File("resources/commonStreetName")));
        ArrayList<String> cities = new ArrayList<>();
        ArrayList<String> roads = new ArrayList<>();
        String line = provAndCityReader.readLine();
        while (line != null){
            cities.add(line.trim());
            line = provAndCityReader.readLine();
        }
        line = roadReader.readLine();
        while (line != null){
            roads.add(line.trim());
            line = roadReader.readLine();
        }
        int citiesSize = cities.size();
        int roadsSize = roads.size();
        provAndCityReader.close();
        roadReader.close();
        return cities.get(random.nextInt(citiesSize)) + roads.get(random.nextInt(roadsSize));
    }

    /**
     * 随机生成一组中国地址
     */
    public static String[] randomChineseAddress(int count) throws Exception{
        String[] address = new String[count];
        for (int i = 0; i <count; i++)
            address[i] = randomChineseAddress();
        return address;
    }

}
