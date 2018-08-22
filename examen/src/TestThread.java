/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Municipio de Gye
 */
public class TestThread implements Runnable{
      public static void main(String[] args) {
           Thread t1 = new Thread(new TestThread(),"Thread-1");
           Thread t2 = new Thread(new TestThread(),"Thread-2");
           t1.start();
           t2.start();
      }
      public void run() {
          for(int i = 0; i < 2; i++)
             System.out.print(Thread.currentThread().getName() + " ");
    }
 }

