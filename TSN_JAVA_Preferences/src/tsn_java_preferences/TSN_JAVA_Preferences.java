package tsn_java_preferences;

import java.util.prefs.Preferences;


public class TSN_JAVA_Preferences {

    public static void main(String[] args) {
        final int r = 5; final int c = 6; 
        int m[][] = new int[r][c]; 
        int k;
        
    
        
        System.out.println("Task:Если максимальный элемент в таблице расположен после минимального,");
        System.out.println("то поменять значения элементов первой и второй строки между собой");
        
        Preferences prefs = Preferences.userRoot().node("tsn_sp_lab3");
        
        // Генерация рандомных чисел от 0 до 9
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                k = (int) Math.round(Math.random() * 20 -10);
                prefs.putInt("m" + i + j, k);
            }
        }
        
        System.out.println("Изначальный массив");

        // Читаем числа из префа для массива
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                k = prefs.getInt("m" + i + j, 0);
                m[i][j] = k;
                System.out.print(k + " ");
            }
            System.out.println("");
        }
            
        System.out.println("Ищем максимальный и минимальный эллемент");
        
       // Считаем максимальный и минимальный эллемент и их индексы
        int max = 0;
        int min = m[0][0];
        int maxIndex = 0;
        int minIndex = 0;
      
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j]>max){ 
                    max = m[i][j];
                    maxIndex = i * m[i].length + j;}
                if(m[i][j]<min){
                    min  = m[i][j];
                    minIndex = i * m[i].length + j;
                }
                    
            }
        }
        
        System.out.println("Номер максимального элемента " + maxIndex + " Номер минимального элемента:"+ minIndex);
        
        if(maxIndex>minIndex){
            System.out.println("Вы счастливчик, максимальный элемент расположен после минимаьного, делаем махинации"); 
            int[] temp = m[0];
             m[0] = m[1];
             m[1] = temp;
        }
        else{
            System.out.println("Попытай удачу снова");
            System.exit(0);
        }
        

        // Записываем массиф в pref ( Украдено с интернета) 
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                
                prefs.putInt("m" + i + j, m[i][j]);
            }
        }
        
        // Снова выводим массив
        System.out.println("Вот такая песня получается:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(prefs.getInt("m" + i + j, -999) + " ");
            }
            System.out.println("");
        }
    }
    
}
