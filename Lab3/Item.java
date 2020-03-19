/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author stefan
 */
public interface Item {

    String getName();

    double getValue();

    double getWeight();

    default double profitFactor() {
        return getValue() / getWeight();
    }
    /*default int compareTo(Item i)
     {
     int result=this.getName().compareTo(i.getName());
     if(result==0)
     return 0;
     else if(result<0)
     return -1;
     else return 1;

     }
     /* default double compareToProfit(Object i)
     {
     if( i==null)
     throw new NullPointerException();
     if(!(i instanceof Item))
            
     throw new ClassCastException("Uncomparable objects!");
     Item item=(Item) i;
     return (this.profitFactor()-item.profitFactor());
        
     }*/

}
