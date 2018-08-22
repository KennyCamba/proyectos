/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Municipio de Gye
 */
class MyThread extends Thread {
  MyThread() {					
    System.out.print(" MyThread");
  }					
  public void run() {
    System.out.print(" bar");		
  }
  public void run(String s) {
    System.out.print(" baz");
  }					
}
class TestThreads {			
    public static void main (String [] args) {
        Thread t = new MyThread();		
        t.start(); 
    }
} 

