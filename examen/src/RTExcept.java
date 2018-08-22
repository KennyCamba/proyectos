/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Municipio de Gye
 */
public class RTExcept{
    public static void throwit (){
        System.out.print("throwit ");
        throw new RuntimeException();
    }
    public static void main(String [] args){
    try{
    System.out.print("hello ");
        throwit();
}catch (Exception re ){
System.out.print("caught ");
}finally{
System.out.print("finally ");
}
System.out.println("after ");
}
}

