package tech.pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FilterMas {

    public void filter_file() throws IOException {
        // открыл поток в try чтобы потом его не закрывать
        try (BufferedReader in = new BufferedReader(new FileReader("/Users/user/Downloads/end.txt")))
        {
            String str = in.readLine();
            // создаю List для хранения чисел файла
            ArrayList<Integer> list = new ArrayList<>();
            // записываю значения в массив, поделив запятой
            String[] mas = str.split(",");
            for (String s : mas) {
                list.add(Integer.parseInt(s.trim()));
            }

            // сортирую по возрастанию
            Collections.sort(list);
            for (int t : list) {
                System.out.println(t);
            }
            //сортирую по убыванию
            Collections.reverse(list);
            for (int t : list) {
                System.out.println(t);
            }
        }
    }
}
