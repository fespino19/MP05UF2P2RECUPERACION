package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void count() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(0,hashTable.count());

        hashTable.put("1","p1");
        hashTable.put("2","p2");
        hashTable.put("3","p3");
        Assertions.assertEquals(3,hashTable.count());



    }

    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();


        Assertions.assertEquals(16,hashTable.size());



       }


    @org.junit.jupiter.api.Test
    void put() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","p1");
        hashTable.put("2","p2");
        hashTable.put("3","p3");
        hashTable.put("4","p4");

        hashTable.put("12","p12");
        hashTable.put("12","p11");
        hashTable.put("13","p13");
        hashTable.put("14","p14");


        hashTable.put("23","p21");
        hashTable.put("24","p24");
        hashTable.put("25","p25");

        hashTable.put("34","p34");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1] -> [12, p11] -> [23, p21] -> [34, p34]\n" +
                " bucket[2] = [2, p2] -> [13, p13] -> [24, p24]\n" +
                " bucket[3] = [3, p3] -> [14, p14] -> [25, p25]\n" +
                " bucket[4] = [4, p4]",hashTable.toString());




    }

    @org.junit.jupiter.api.Test
    void getSinColision() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","p1");
        hashTable.put("2","p2");
        hashTable.put("3","p3");
        hashTable.put("4","p4");

       // Assertions.assertEquals("\n" +
            //  "bucket[1] = [1, p1]\n" +
            //   " bucket[2] = [2, p2]\n" +
             // "bucket[3] = [3, p3]\n" +
            // " bucket[4] = [4, p4]",hashTable.toString());



        Assertions.assertEquals("p2",hashTable.get("2"));





       }
    @org.junit.jupiter.api.Test
       void getConColision(){
        HashTable hashTable = new HashTable();
        hashTable.put("1","p1");
        hashTable.put("12","p2");
        hashTable.put("23","p13");
        hashTable.put("34","p34");

      // ejemplo
      //Assertions.assertEquals("\n" +
          //     " bucket[1] = [11, p1] -> [12, p2] -> [23, p13] -> [34, p34]",hashTable.toString());


        Assertions.assertEquals("p13",hashTable.get("23"));

       }
    @org.junit.jupiter.api.Test
    void getNoExiste() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","Hola1");
        Assertions.assertEquals(null,hashTable.get("12"));
    }

    @org.junit.jupiter.api.Test
    void drop() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","p1");
        hashTable.put("2","p2");
        hashTable.put("3","p3");
        hashTable.put("4","p4");

        hashTable.put("12","p12");
        hashTable.put("13","p13");
        hashTable.put("14","p14");

        hashTable.put("23","p23");
        hashTable.put("24","p24");
        hashTable.put("25","p25");

        hashTable.put("34","p34");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1] -> [12, p12] -> [23, p23] -> [34, p34]\n" +
                " bucket[2] = [2, p2] -> [13, p13] -> [24, p24]\n" +
                " bucket[3] = [3, p3] -> [14, p14] -> [25, p25]\n" +
                " bucket[4] = [4, p4]",hashTable.toString());

        //Borrar el primero
        hashTable.drop("2");
        //Borrar el ultimo
        hashTable.drop("25");
        //Borrar en medio
        hashTable.drop("12");
        //Borrar en medio
        hashTable.drop("23");
        //Borrar unico valor
        hashTable.drop("4");

        hashTable.drop("37");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1] -> [34, p34]\n" +
                " bucket[2] = [13, p13] -> [24, p24]\n" +
                " bucket[3] = [3, p3] -> [14, p14]", hashTable.toString());

        Assertions.assertEquals(6,hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void dropAlgoinexistente() {
        //No puedes borrar algo que no existe
        HashTable hashTable = new HashTable();

        hashTable.put("1","p1");
        hashTable.put("12","p1");
        hashTable.drop("137");

    }






    }

