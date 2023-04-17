package tsn_java_preferences;

import java.util.prefs.Preferences;


public class TSN_JAVA_Preferences {

    public static void main(String[] args) {
        final int r = 5; final int c = 6; 
        int m[][] = new int[r][c]; 
        int k;
        
    
        
        System.out.println("Task:���� ������������ ������� � ������� ���������� ����� ������������,");
        System.out.println("�� �������� �������� ��������� ������ � ������ ������ ����� �����");
        
        Preferences prefs = Preferences.userRoot().node("tsn_sp_lab3");
        
        // ��������� ��������� ����� �� 0 �� 9
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                k = (int) Math.round(Math.random() * 20 -10);
                prefs.putInt("m" + i + j, k);
            }
        }
        
        System.out.println("����������� ������");

        // ������ ����� �� ����� ��� �������
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                k = prefs.getInt("m" + i + j, 0);
                m[i][j] = k;
                System.out.print(k + " ");
            }
            System.out.println("");
        }
            
        System.out.println("���� ������������ � ����������� ��������");
        
       // ������� ������������ � ����������� �������� � �� �������
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
        
        System.out.println("����� ������������� �������� " + maxIndex + " ����� ������������ ��������:"+ minIndex);
        
        if(maxIndex>minIndex){
            System.out.println("�� �����������, ������������ ������� ���������� ����� �����������, ������ ���������"); 
            int[] temp = m[0];
             m[0] = m[1];
             m[1] = temp;
        }
        else{
            System.out.println("������� ����� �����");
            System.exit(0);
        }
        

        // ���������� ������ � pref ( �������� � ���������) 
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                
                prefs.putInt("m" + i + j, m[i][j]);
            }
        }
        
        // ����� ������� ������
        System.out.println("��� ����� ����� ����������:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(prefs.getInt("m" + i + j, -999) + " ");
            }
            System.out.println("");
        }
    }
    
}
